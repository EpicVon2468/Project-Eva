package io.github.epicvon2468.project_eva.entity.custom

import net.minecraft.entity.*
import net.minecraft.entity.data.*
import net.minecraft.entity.projectile.*
import net.minecraft.nbt.NbtCompound
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.Identifier
import net.minecraft.util.math.*
import net.minecraft.world.World

import io.github.epicvon2468.project_eva.ProjectEva
import io.github.epicvon2468.project_eva.util.plus
import io.github.epicvon2468.project_eva.entity.ProjectEvaEntities
import io.github.epicvon2468.project_eva.item.custom.BaseSpear

import java.util.UUID

class ATFieldEntity(entityType: EntityType<out ATFieldEntity>, world: World) : Entity(entityType, world), Ownable {

	@JvmField
	var sizeModifier: Float = 2.0f

	constructor(world: World) : this(ProjectEvaEntities.AT_FIELD, world)

	constructor(world: World, owner: ATFieldOwner) : this(ProjectEvaEntities.AT_FIELD, world) {
		this.owner = owner
	}

	@get:JvmName("owner") // Default name conflicts with the getter method from the Ownable interface
	var owner: ATFieldOwner? = null
		set(value) {
			this.ownerUUID = value?.asEntity()?.uuid
			this.absoluteTerrorFieldStrength = value?.absoluteTerrorFieldStrength ?: -1
			field = value
		}

	var ownerUUID: UUID? = null

	override var absoluteTerrorField: ATFieldEntity?
		get() = this
		set(value) = throw IllegalArgumentException(
			"Attempt was made to reassign the AT Field of an AT Field! AT Field: '$this'; Passed value: '$value'."
		)

	override var absoluteTerrorFieldStrength: Int
		get() = this.dataTracker[AT_FIELD_STRENGTH]
		set(value) { this.dataTracker[AT_FIELD_STRENGTH] = value }

	// TODO: Fix me
	override fun tick() {
		super.tick()
		if (this.world.isClient) return
		// Use this?
		//this.boundingBox = this.calculateBoundingBox()
		val others = this._w.getOtherEntities(this, this.boundingBox + 1.5 * this.sizeModifier) { !it.isSpectator }
		if (others.isEmpty()) return
		for (other in others) {
			if (other !is ATFieldEntity) {
				if (other is ProjectileEntity) {
					val item: BaseSpear? = ((other as? TridentEntity)?.tridentStack?.item as? BaseSpear)
					// Tridents & projectiles pushed against the AT Field can get through... why didn't I document this?
					if (item !is BaseSpear && other.firstUpdate) other.discard()
					else item?.also { this.discard() }
				}
				continue
			}
			if (other.ownerUUID == this.ownerUUID && this.ownerUUID != null) continue
			this.discard()
			other.discard()
		}
	}

	private val _w: ServerWorld get() = this.world as ServerWorld

	override fun getOwner(): Entity? = this.owner?.asEntity()

	override fun initDataTracker() = this.dataTracker.startTracking(AT_FIELD_STRENGTH, -1)

	override fun readCustomDataFromNbt(nbt: NbtCompound) =
		if (KEY in nbt) this.owner = this._w.getEntity(nbt.getUuid(KEY)) else Unit

	override fun writeCustomDataToNbt(nbt: NbtCompound) =
		if (this.ownerUUID != null) nbt.putUuid(KEY, this.ownerUUID) else Unit

	override fun canBeHitByProjectile(): Boolean = true

	override fun canHit(): Boolean = true

	override fun isCollidable(): Boolean = true

	override fun collidesWith(other: Entity): Boolean = true

	override fun canUsePortals(): Boolean = false

	override fun canAvoidTraps(): Boolean = true

	override fun hasNoGravity(): Boolean = true

	override fun isImmuneToExplosion(): Boolean = true

	override fun isFireImmune(): Boolean = true

	override fun calculateBoundingBox(): Box {
		val x = this.x
		val y = this.y
		val z = this.z
		val width = (this.width + 3.0f) * this.sizeModifier
		val height = (this.height + 3.0f) * this.sizeModifier
		return when (this.horizontalFacing) {
			Direction.SOUTH, Direction.NORTH -> Box(x - width, y, z, x + width, y + height, z).expand(0.0, 0.0, 0.1)
			Direction.WEST, Direction.EAST -> Box(x, y, z - width, x, y + height, z + width).expand(0.1, 0.0, 0.0)
			else -> Box(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
		}
	}

	companion object {

		@JvmField
		val AT_FIELD_STRENGTH: TrackedData<Int> =
			DataTracker.registerData(ATFieldEntity::class.java, TrackedDataHandlerRegistry.INTEGER)
		@JvmField
		val AT_FIELD_ID = Identifier(ProjectEva.MOD_ID, "at_field")
		const val KEY = "OwnerUUID"
	}
}
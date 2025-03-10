package wiiu.mavity.project_eva.entity.custom

import net.minecraft.entity.*
import net.minecraft.nbt.NbtCompound
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.Identifier
import net.minecraft.util.math.*
import net.minecraft.world.World

import wiiu.mavity.project_eva.ProjectEva
import wiiu.mavity.project_eva.entity.ProjectEvaEntities

import java.util.UUID

// TODO: Stop players from being able to get projectiles through if they are pushed directly against an AT Field.
class ATFieldEntity(entityType: EntityType<out ATFieldEntity>, world: World) : Entity(entityType, world), Ownable {

    constructor(world: World) : this(ProjectEvaEntities.AT_FIELD, world)

    constructor(world: World, owner: ATFieldOwner) : this(ProjectEvaEntities.AT_FIELD, world) {
        this.owner = owner
    }

    @get:JvmName("owner") // Default name conflicts with the getter method from the Ownable interface
    var owner: ATFieldOwner? = null
        set(value) {
            field = value
            this.ownerUUID = value?.asEntity()?.uuid
        }

    var ownerUUID: UUID? = null

    override fun getOwner(): Entity? = this.owner?.asEntity()

    override fun initDataTracker() {}

    override fun readCustomDataFromNbt(nbt: NbtCompound) = if (nbt.contains(KEY)) this.owner = (this.world as ServerWorld).getEntity(nbt.getUuid(KEY)) else Unit

    override fun writeCustomDataToNbt(nbt: NbtCompound) = if (this.ownerUUID != null) nbt.putUuid(KEY, this.ownerUUID) else Unit

    override fun canBeHitByProjectile(): Boolean = true

    override fun canHit(): Boolean = true

    override fun isCollidable(): Boolean = true

    override fun collidesWith(other: Entity): Boolean {
        // We can implement logic for if the other is an AT Field entity here :O
        return true
    }

    override fun canUsePortals(): Boolean = false

    override fun canAvoidTraps(): Boolean = true

    override fun hasNoGravity(): Boolean = true

    override fun isImmuneToExplosion(): Boolean = true

    override fun calculateBoundingBox(): Box {
        val x = this.x
        val y = this.y
        val z = this.z
        val width = (this.width + 3.0f) * AT_FIELD_SIZE_MODIFIER
        val height = (this.height + 3.0f) * AT_FIELD_SIZE_MODIFIER
        return when (this.horizontalFacing) {
            Direction.SOUTH, Direction.NORTH -> Box(x - width, y, z, x + width, y + height, z).expand(0.0, 0.0, 0.1)
            Direction.WEST, Direction.EAST -> Box(x, y, z - width, x, y + height, z + width).expand(0.1, 0.0, 0.0)
            else -> Box(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
        }
    }

    companion object {

        val AT_FIELD_ID = Identifier(ProjectEva.MOD_ID, "at_field")
        const val AT_FIELD_SIZE_MODIFIER = 2.0f
        const val KEY = "OwnerUUID"
    }
}
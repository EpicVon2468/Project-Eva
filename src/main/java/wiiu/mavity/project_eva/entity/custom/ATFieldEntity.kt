package wiiu.mavity.project_eva.entity.custom

import net.minecraft.entity.*
import net.minecraft.nbt.NbtCompound
import net.minecraft.util.Identifier
import net.minecraft.util.math.*
import net.minecraft.world.World

import wiiu.mavity.project_eva.ProjectEva
import wiiu.mavity.project_eva.entity.ProjectEvaEntities

class ATFieldEntity(entityType: EntityType<out ATFieldEntity>, world: World) : Entity(entityType, world) {

    constructor(world: World) : this(ProjectEvaEntities.AT_FIELD, world)

    override fun initDataTracker() {}

    override fun readCustomDataFromNbt(nbt: NbtCompound) {}

    override fun writeCustomDataToNbt(nbt: NbtCompound) {}

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
    }
}
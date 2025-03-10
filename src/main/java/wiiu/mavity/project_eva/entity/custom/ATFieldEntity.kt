package wiiu.mavity.project_eva.entity.custom

import net.minecraft.entity.*
import net.minecraft.nbt.NbtCompound
import net.minecraft.util.math.*
import net.minecraft.world.World

import wiiu.mavity.project_eva.entity.EvaEntities

class ATFieldEntity(entityType: EntityType<out ATFieldEntity>, world: World) : Entity(entityType, world) {

    constructor(world: World) : this(EvaEntities.AT_FIELD, world)

    override fun initDataTracker() {}

    override fun readCustomDataFromNbt(nbt: NbtCompound) {}

    override fun writeCustomDataToNbt(nbt: NbtCompound) {}

    override fun canHit(): Boolean = !this.isRemoved

    override fun isCollidable(): Boolean = true

    override fun isPushable(): Boolean = false

    override fun calculateBoundingBox(): Box {
        val x = this.x
        val y = this.y
        val z = this.z
        val width = (this.width + 3.0f) * AT_FIELD_SIZE_MODIFIER
        val height = (this.height + 3.0f) * AT_FIELD_SIZE_MODIFIER
        return when (this.horizontalFacing) {
            Direction.SOUTH, Direction.NORTH -> Box(x - width, y, z, x + width, y + height, z)
            Direction.WEST, Direction.EAST -> Box(x, y, z - width, x, y + height, z + width)
            else -> Box(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
        }
    }

    companion object {

        const val AT_FIELD_SIZE_MODIFIER = 2.0f
    }
}
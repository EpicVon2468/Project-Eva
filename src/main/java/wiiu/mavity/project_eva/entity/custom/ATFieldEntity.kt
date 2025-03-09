package wiiu.mavity.project_eva.entity.custom

import net.minecraft.entity.*
import net.minecraft.nbt.NbtCompound
import net.minecraft.world.World

class ATFieldEntity(entityType: EntityType<out ATFieldEntity>, world: World) : Entity(entityType, world) {

    override fun initDataTracker() {}

    override fun readCustomDataFromNbt(nbt: NbtCompound) {}

    override fun writeCustomDataToNbt(nbt: NbtCompound) {}

    override fun canHit(): Boolean = !this.isRemoved

    override fun isCollidable(): Boolean = true

    override fun isPushable(): Boolean = false
}
package wiiu.mavity.project_eva.util

import net.minecraft.util.math.*

fun Box.expand(direction: Direction, by: Number, bothWays: Boolean = false): Box {
    val amount = by.toDouble()
    return if (bothWays) when (direction) {
        Direction.NORTH, Direction.SOUTH -> this.offset(0.0, 0.0, amount)
        Direction.EAST, Direction.WEST -> this.offset(amount, 0.0, 0.0)
        Direction.UP, Direction.DOWN -> this.offset(0.0, amount, 0.0)
    } else when (direction) {
        Direction.NORTH -> this.withMinZ(this.minZ - amount)
        Direction.SOUTH -> this.withMaxZ(this.maxZ + amount)
        Direction.EAST -> this.withMaxX(this.maxX + amount)
        Direction.WEST -> Box(this.minX - amount, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ)
        Direction.UP -> Box(this.minX, this.minY, this.minZ, this.maxX, this.maxY + amount, this.maxZ)
        Direction.DOWN -> Box(this.minX, this.minY - amount, this.minZ, this.maxX, this.maxY, this.maxZ)
    }
}

infix fun Direction.thisOrOppositeEquals(other: Direction): Boolean = this == other || this.opposite == other
package wiiu.mavity.project_eva.util

import net.minecraft.util.math.*

fun Box.expand(direction: Direction, by: Number = 1, bothWays: Boolean = false): Box {
    val amount = by.toDouble()
    return if (amount == 0.0) this else if (bothWays) when (direction) {
        Direction.NORTH, Direction.SOUTH -> this.offset(0.0, 0.0, amount)
        Direction.EAST, Direction.WEST -> this.offset(amount, 0.0, 0.0)
        Direction.UP, Direction.DOWN -> this.offset(0.0, amount, 0.0)
    } else when (direction) {
        Direction.NORTH -> this.withMinZ(this.minZ - amount)
        Direction.SOUTH -> this.withMaxZ(this.maxZ + amount)
        Direction.EAST -> this.withMaxX(this.maxX + amount)
        Direction.WEST -> this.withMinX(this.minX - amount)
        Direction.UP -> this.withMaxY(this.maxY + amount)
        Direction.DOWN -> this.withMinY(this.minY - amount)
    }
}

infix fun Direction.thisOrOppositeEquals(other: Direction): Boolean = this == other || this.opposite == other
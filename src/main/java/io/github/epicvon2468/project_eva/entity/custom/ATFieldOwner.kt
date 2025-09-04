package io.github.epicvon2468.project_eva.entity.custom

import net.minecraft.entity.Entity

// Actual word spelling takes precedent over naming conventions.
// Might make it harder to read if you're in a text editor without highlighting, but anyone doing that is a masochist.
@Suppress("PropertyName")
interface ATFieldOwner {

	var ATField: ATFieldEntity?
		get() = TODO()
		set(value) = TODO()

	fun asEntity(): Entity = TODO()

	var ATFieldStrength: Int
		get() = TODO()
		set(value) = TODO()
}
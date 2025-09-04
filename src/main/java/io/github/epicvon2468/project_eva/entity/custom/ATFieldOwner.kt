package io.github.epicvon2468.project_eva.entity.custom

import net.minecraft.entity.Entity

interface ATFieldOwner {

	var absoluteTerrorField: ATFieldEntity?
		get() = TODO()
		set(value) = TODO()

	fun asEntity(): Entity = TODO()

	var absoluteTerrorFieldStrength: Int
		get() = TODO()
		set(value) = TODO()
}
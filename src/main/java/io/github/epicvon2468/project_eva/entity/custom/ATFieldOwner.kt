package io.github.epicvon2468.project_eva.entity.custom

import net.minecraft.entity.Entity

/**
 * Access to AT Field related properties & function(s).
 * @see [ATFieldEntity]
 * @author Mavity The Madity (EpicVon2468)
 */
interface ATFieldOwner {

	/**
	 * The [ATFieldEntity] owned by this entity. May be null.
	 * @see [ATFieldEntity]
	 * @return Access to the [ATFieldEntity] instance of this object.
	 */
	var absoluteTerrorField: ATFieldEntity?
		get() = TODO()
		set(value) = TODO()

	/**
	 * The strength of the [ATFieldEntity] owned by this entity.
	 * @see [ATFieldEntity]
	 * @see [absoluteTerrorField]
	 * @return Access to the strength of the [ATFieldEntity] instance of this object.
	 */
	var absoluteTerrorFieldStrength: Int
		get() = TODO()
		set(value) = TODO()

	fun asEntity(): Entity = TODO()
}
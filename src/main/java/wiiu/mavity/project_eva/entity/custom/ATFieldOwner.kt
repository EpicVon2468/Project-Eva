package wiiu.mavity.project_eva.entity.custom

import net.minecraft.entity.Entity

interface ATFieldOwner {

	@Suppress("PropertyName") // Fight me
	var ATField: ATFieldEntity?
		get() = TODO()
		set(value) = TODO()

	fun asEntity(): Entity = TODO()

	var proportionalHealth: Int
		get() = TODO()
		set(value) = TODO()
}
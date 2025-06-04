package wiiu.mavity.project_eva.entity.custom

import net.minecraft.entity.Entity

interface ATFieldOwner {

	var ATField: ATFieldEntity?
		get() = TODO()
		set(value) = TODO()

	fun asEntity(): Entity = TODO()
}
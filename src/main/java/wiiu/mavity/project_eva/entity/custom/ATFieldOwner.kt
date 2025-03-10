package wiiu.mavity.project_eva.entity.custom

import net.minecraft.entity.Entity

interface ATFieldOwner {

    var ATField: ATFieldEntity?

    fun asEntity(): Entity
}
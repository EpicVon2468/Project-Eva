package wiiu.mavity.project_eva.item

import net.minecraft.item.Item
import net.minecraft.registry.*
import net.minecraft.util.Identifier

import wiiu.mavity.project_eva.ProjectEva
import wiiu.mavity.project_eva.item.custom.BaseSpear

object ProjectEvaItems {

    init {
        ProjectEva.LOGGER.info("Registering Items for Project Eva!")
    }

    val SPEAR_LONGINUS = this.registerItem("spear_longinus", BaseSpear())

    val SPEAR_CASSIUS = this.registerItem("spear_cassius", BaseSpear())

    fun <T : Item> registerItem(name: String, item: T): T = Registry.register(Registries.ITEM, Identifier(ProjectEva.MOD_ID, name), item)
}
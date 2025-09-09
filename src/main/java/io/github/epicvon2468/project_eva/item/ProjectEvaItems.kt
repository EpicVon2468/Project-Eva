package io.github.epicvon2468.project_eva.item

import com.oroarmor.multiitemlib.api.UniqueItemRegistry

import net.minecraft.item.Item
import net.minecraft.registry.*
import net.minecraft.util.Identifier

import io.github.epicvon2468.project_eva.ProjectEva
import io.github.epicvon2468.project_eva.item.custom.BaseSpear

object ProjectEvaItems {

	init {
		ProjectEva.LOGGER.info("Registering Items for Project Eva!")
	}

	@JvmField
	val SPEAR_LONGINUS = this.registerSpearItem("spear_longinus", BaseSpear())

	@JvmField
	val SPEAR_CASSIUS = this.registerSpearItem("spear_cassius", BaseSpear())

	@JvmField
	val SPEAR_GAIUS = this.registerSpearItem("spear_gaius", BaseSpear())

	inline fun <reified T : Item> registerItem(name: String, item: T): T =
		Registry.register(Registries.ITEM, Identifier(ProjectEva.MOD_ID, name), item)

	inline fun <reified T : BaseSpear> registerSpearItem(name: String, item: T): T =
		this.registerItem(name, item).also { UniqueItemRegistry.TRIDENT.addItemToRegistry(it) }
}
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
	val SPEAR_LONGINUS = this.registerItem("spear_longinus", BaseSpear()).also {
		UniqueItemRegistry.TRIDENT.addItemToRegistry(it)
	}

	@JvmField
	val SPEAR_CASSIUS = this.registerItem("spear_cassius", BaseSpear()).also {
		UniqueItemRegistry.TRIDENT.addItemToRegistry(it)
	}

	inline fun <reified T : Item> registerItem(name: String, item: T): T =
		Registry.register(Registries.ITEM, Identifier(ProjectEva.MOD_ID, name), item)
}
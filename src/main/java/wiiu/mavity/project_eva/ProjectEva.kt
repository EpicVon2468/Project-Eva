package wiiu.mavity.project_eva

import net.fabricmc.api.ModInitializer

import org.slf4j.*

import wiiu.mavity.project_eva.entity.ProjectEvaEntities
import wiiu.mavity.project_eva.item.ProjectEvaItems

object ProjectEva : ModInitializer {

	@Suppress("UnusedExpression") // Silence. We're calling the initialiser.
	override fun onInitialize() {
		LOGGER.info("ProjectEva initialising!")
		ProjectEvaEntities
		ProjectEvaItems
	}

	const val MOD_ID: String = "project_eva"

	@JvmField
	val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
}
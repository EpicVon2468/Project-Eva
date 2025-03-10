package wiiu.mavity.project_eva

import net.fabricmc.api.ModInitializer

import org.slf4j.*

import wiiu.mavity.project_eva.entity.ProjectEvaEntities

object ProjectEva : ModInitializer {

    override fun onInitialize() {
        LOGGER.info("ProjectEva initializing!")
        ProjectEvaEntities
    }

    const val MOD_ID: String = "project_eva"

    val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
}
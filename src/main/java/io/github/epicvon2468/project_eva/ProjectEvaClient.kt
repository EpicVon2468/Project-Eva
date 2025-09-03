package io.github.epicvon2468.project_eva

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.*

import io.github.epicvon2468.project_eva.entity.ProjectEvaEntities
import io.github.epicvon2468.project_eva.entity.model.ATFieldEntityModel
import io.github.epicvon2468.project_eva.entity.renderer.ATFieldEntityRenderer

object ProjectEvaClient : ClientModInitializer {

	override fun onInitializeClient() {
		EntityModelLayerRegistry.registerModelLayer(ATFieldEntityModel.LAYER_LOCATION, ATFieldEntityModel::getTexturedModelData)
		EntityRendererRegistry.register(ProjectEvaEntities.AT_FIELD, ::ATFieldEntityRenderer)
	}
}
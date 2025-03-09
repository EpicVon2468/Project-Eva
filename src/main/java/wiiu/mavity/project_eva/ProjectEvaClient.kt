package wiiu.mavity.project_eva

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.*

import wiiu.mavity.project_eva.entity.EvaEntities
import wiiu.mavity.project_eva.entity.model.ATFieldEntityModel
import wiiu.mavity.project_eva.entity.renderer.ATFieldEntityRenderer

object ProjectEvaClient : ClientModInitializer {

    override fun onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ATFieldEntityModel.LAYER_LOCATION, ATFieldEntityModel::getTexturedModelData)
        EntityRendererRegistry.register(EvaEntities.AT_FIELD, ::ATFieldEntityRenderer)
    }
}
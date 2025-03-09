package wiiu.mavity.project_eva.entity.renderer

import net.minecraft.client.render.*
import net.minecraft.client.render.entity.*
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier

import wiiu.mavity.project_eva.ProjectEva
import wiiu.mavity.project_eva.entity.custom.ATFieldEntity
import wiiu.mavity.project_eva.entity.model.ATFieldEntityModel

class ATFieldEntityRenderer(ctx: EntityRendererFactory.Context) : EntityRenderer<ATFieldEntity>(ctx) {

    private val entityModel: ATFieldEntityModel = ATFieldEntityModel(ctx.getPart(ATFieldEntityModel.LAYER_LOCATION));

    override fun render(entity: ATFieldEntity, yaw: Float, tickDelta: Float, matrices: MatrixStack, vertexConsumers: VertexConsumerProvider, light: Int) {
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light)
        val vertexConsumer = vertexConsumers.getBuffer(this.entityModel.getLayer(this.getTexture(entity)))
        this.entityModel.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f)
    }

    override fun getTexture(entity: ATFieldEntity): Identifier = Identifier(ProjectEva.MOD_ID, "textures/entity/at_field.png")
}
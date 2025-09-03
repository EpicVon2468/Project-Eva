package io.github.epicvon2468.project_eva.entity.renderer

import net.fabricmc.api.*

import net.minecraft.client.render.*
import net.minecraft.client.render.entity.*
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.math.RotationAxis
import net.minecraft.util.Identifier

import io.github.epicvon2468.project_eva.ProjectEva
import io.github.epicvon2468.project_eva.entity.custom.ATFieldEntity
import io.github.epicvon2468.project_eva.entity.model.ATFieldEntityModel

@Environment(EnvType.CLIENT)
class ATFieldEntityRenderer(ctx: EntityRendererFactory.Context) : EntityRenderer<ATFieldEntity>(ctx) {

	private val entityModel: ATFieldEntityModel = ATFieldEntityModel(ctx.getPart(ATFieldEntityModel.LAYER_LOCATION))

	override fun render(entity: ATFieldEntity, yaw: Float, tickDelta: Float, matrices: MatrixStack, vertexConsumers: VertexConsumerProvider, light: Int) {
		super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light)
		val vertexConsumer = vertexConsumers.getBuffer(this.entityModel.getLayer(this.getTexture(entity)))
		matrices.push()
		val modifier = 2.0f * entity.sizeModifier
		matrices.scale(modifier, modifier, modifier)
		matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-entity.yaw))
		this.entityModel.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f)
		matrices.pop()
	}

	override fun getTexture(entity: ATFieldEntity): Identifier = Identifier(ProjectEva.MOD_ID, "textures/entity/at_field.png")
}
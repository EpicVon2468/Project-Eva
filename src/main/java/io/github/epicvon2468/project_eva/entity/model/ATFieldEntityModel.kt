package io.github.epicvon2468.project_eva.entity.model

import net.fabricmc.api.*

import net.minecraft.client.model.*
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.*
import net.minecraft.client.util.math.MatrixStack

import io.github.epicvon2468.project_eva.entity.custom.ATFieldEntity

@Environment(EnvType.CLIENT)
class ATFieldEntityModel(root: ModelPart) : EntityModel<ATFieldEntity>() {

	private val main: ModelPart = root.getChild("main")

	override fun setAngles(entity: ATFieldEntity, limbSwing: Float, limbSwingAmount: Float, ageInTicks: Float, netHeadYaw: Float, headPitch: Float) = Unit

	override fun render(matrices: MatrixStack, vertexConsumer: VertexConsumer, light: Int, overlay: Int, red: Float, green: Float, blue: Float, alpha: Float) =
		main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha)

	companion object {

		val LAYER_LOCATION: EntityModelLayer = EntityModelLayer(ATFieldEntity.AT_FIELD_ID, "main")

		fun getTexturedModelData(): TexturedModelData {
			val modelData = ModelData()
			modelData.root.addChild(
				"main",
				ModelPartBuilder.create().cuboid(-24.0f, 0.0f, 0.0f, 48.0f, 48.0f, 0.0f, Dilation.NONE),
				ModelTransform.NONE
			)
			return TexturedModelData.of(modelData, 128, 128)
		}
	}
}
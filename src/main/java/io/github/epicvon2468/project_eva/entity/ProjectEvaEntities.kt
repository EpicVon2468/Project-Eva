package io.github.epicvon2468.project_eva.entity

import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder

import net.minecraft.entity.*
import net.minecraft.registry.*

import io.github.epicvon2468.project_eva.ProjectEva
import io.github.epicvon2468.project_eva.entity.custom.ATFieldEntity

object ProjectEvaEntities {

	init {
		ProjectEva.LOGGER.info("Registering Entities for Project Eva!")
	}

	@JvmField
	val AT_FIELD: EntityType<ATFieldEntity> = Registry.register(Registries.ENTITY_TYPE, ATFieldEntity.AT_FIELD_ID,
		FabricEntityTypeBuilder.create(SpawnGroup.MISC, ::ATFieldEntity)
			.dimensions(EntityDimensions.changing(0.1f, 3.0f))
			.fireImmune()
			.trackRangeBlocks(5000)
			.spawnableFarFromPlayer()
			.build()
	)
}
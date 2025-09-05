package io.github.epicvon2468.project_eva.mixin

import io.github.epicvon2468.project_eva.entity.custom.*

import net.minecraft.entity.Entity

import org.spongepowered.asm.mixin.*

@Mixin(Entity::class)
@Suppress("NonJavaMixin") // You can (not) stop me
class ATFieldOwnerImpl : ATFieldOwner {

	@Unique
	override var absoluteTerrorField: ATFieldEntity? = null
		set(value) {
			field?.owner = null // The old AT Field needs to know we're not the owner any more.
			field = value
			field?.owner = this
		}

	override var absoluteTerrorFieldStrength: Int
		get() = this.absoluteTerrorField?.absoluteTerrorFieldStrength ?: -1
		// How does this compile... I thought assignment wasn't an expression in Kotlin???
		set(value) = this.absoluteTerrorField?.absoluteTerrorFieldStrength = value

	// It's not actually going to fail to cast, despite what static analysis thinks
	@Suppress("KotlinConstantConditions")
	override fun asEntity(): Entity = (this as Any) as Entity
}
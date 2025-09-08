package io.github.epicvon2468.project_eva.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.world.explosion.Explosion;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;

import io.github.epicvon2468.project_eva.entity.custom.ATFieldEntity;

import java.util.*;

@Mixin(Explosion.class)
public class ExplosionMixin {

	@Unique
	public List<Entity> protectedEntities = new ArrayList<>();

	@ModifyReturnValue(
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/entity/Entity;isImmuneToExplosion()Z"
		),
		method = "collectBlocksAndDamageEntities"
	)
	public boolean protectATFieldOwners(boolean original, @Local Entity entity) {
		if (entity instanceof ATFieldEntity entity1) return this.protectedEntities.add(entity1.getOwner());
		if (this.protectedEntities.contains(entity)) return false;
		else return original;
	}

	@Inject(
		at = @At("RETURN"),
		method = "collectBlocksAndDamageEntities"
	)
	public void clearList(CallbackInfo ci) {
		this.protectedEntities.clear();
	}
}
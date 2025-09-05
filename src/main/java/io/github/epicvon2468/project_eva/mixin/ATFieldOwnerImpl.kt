package io.github.epicvon2468.project_eva.mixin;

import net.minecraft.entity.Entity;

import org.jetbrains.annotations.*;

import org.spongepowered.asm.mixin.*;

import io.github.epicvon2468.project_eva.entity.custom.*;

@Mixin(Entity.class)
@SuppressWarnings("AddedMixinMembersNamePattern")
public class ATFieldOwnerImpl implements ATFieldOwner {

	@Unique
	@Nullable
	private ATFieldEntity absoluteTerrorField;

	@Nullable
	@Override
	public ATFieldEntity getAbsoluteTerrorField() {
		return this.absoluteTerrorField;
	}

	@Override
	public void setAbsoluteTerrorField(@Nullable ATFieldEntity value) {
		this.updateOwner(null); // The old AT Field needs to know we're not the owner any more.
		this.absoluteTerrorField = value;
		this.updateOwner(this);
	}

	@Unique
	private void updateOwner(@Nullable ATFieldOwner newOwner) {
		if (this.absoluteTerrorField != null) this.absoluteTerrorField.setOwner(newOwner);
	}

	@Override
	public int getAbsoluteTerrorFieldStrength() {
		if (this.absoluteTerrorField == null) return -1;
		return this.absoluteTerrorField.getAbsoluteTerrorFieldStrength();
	}

	@Override
	public void setAbsoluteTerrorFieldStrength(int value) {
		if (this.absoluteTerrorField == null) return;
		this.absoluteTerrorField.setAbsoluteTerrorFieldStrength(value);
	}

	@NotNull
	@Override
	public Entity asEntity() {
		return (Entity) (Object) this;
	}
}
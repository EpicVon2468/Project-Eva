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
	private ATFieldEntity theATField;

	@Nullable
	@Override
	public ATFieldEntity getATField() {
		return this.theATField;
	}

	@Override
	public void setATField(@Nullable ATFieldEntity atFieldEntity) {
		this.handleNullableOwner(null);
		this.theATField = atFieldEntity;
		this.handleNullableOwner(this);
	}

	@Unique
	private void handleNullableOwner(@Nullable ATFieldOwner newOwner) {
		if (this.theATField != null) this.theATField.setOwner(newOwner);
	}

	@Override
	public int getATFieldStrength() {
		if (this.theATField == null) return -1;
		return this.theATField.getATFieldStrength();
	}

	@Override
	public void setATFieldStrength(int value) {
		if (this.theATField == null) return;
		this.theATField.setATFieldStrength(value);
	}

	@NotNull
	@Override
	public Entity asEntity() {
		return (Entity) (Object) this;
	}
}
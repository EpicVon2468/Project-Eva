package wiiu.mavity.project_eva.mixin;

import net.minecraft.entity.Entity;

import org.jetbrains.annotations.*;

import org.spongepowered.asm.mixin.*;

import wiiu.mavity.project_eva.entity.custom.*;

@Mixin(Entity.class)
@SuppressWarnings("AddedMixinMembersNamePattern")
public class ATFieldOwnerImpl implements ATFieldOwner {

	@Unique
	@Nullable
	private ATFieldEntity atFieldEntity;

	@Nullable
	@Override
	public ATFieldEntity getATField() {
		return this.atFieldEntity;
	}

	@Override
	public void setATField(@Nullable ATFieldEntity atFieldEntity) {
		this.handleNullableOwner(null);
		this.atFieldEntity = atFieldEntity;
		this.handleNullableOwner(this);
	}

	@Unique
	private void handleNullableOwner(@Nullable ATFieldOwner newOwner) {
		if (this.atFieldEntity != null) this.atFieldEntity.setOwner(newOwner);
	}

	@Unique
	private int proportionalHealth = 20;

	@Override
	public int getProportionalHealth() {
		return this.proportionalHealth;
	}

	@Override
	public void setProportionalHealth(int value) {
		this.proportionalHealth = value;
	}

	@NotNull
	@Override
	public Entity asEntity() {
		return (Entity) (Object) this;
	}
}
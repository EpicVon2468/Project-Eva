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
        this.atFieldEntity = atFieldEntity;
    }

    @NotNull
    @Override
    public Entity asEntity() {
        return (Entity) (Object) this;
    }
}
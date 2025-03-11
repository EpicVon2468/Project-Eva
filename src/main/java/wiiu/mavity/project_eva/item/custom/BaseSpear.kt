package wiiu.mavity.project_eva.item.custom

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.projectile.*
import net.minecraft.item.*
import net.minecraft.sound.*
import net.minecraft.stat.Stats
import net.minecraft.util.*
import net.minecraft.world.World

class BaseSpear : TridentItem(Settings()) {

    override fun onStoppedUsing(stack: ItemStack, world: World, user: LivingEntity, remainingUseTicks: Int) {
        if (user !is PlayerEntity) return
        if (!world.isClient) {
            val tridentEntity = TridentEntity(world, user, stack)
            tridentEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 3.0f, 0.0f)
            if (user.abilities.creativeMode) tridentEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY
            world.spawnEntity(tridentEntity)
            world.playSoundFromEntity(
                null,
                tridentEntity,
                SoundEvents.ITEM_TRIDENT_THROW,
                SoundCategory.PLAYERS,
                1.0f,
                1.0f
            )
            if (!user.abilities.creativeMode) user.inventory.removeOne(stack)
            user.incrementStat(Stats.USED.getOrCreateStat(this))
        }
    }

    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        user.setCurrentHand(hand)
        return TypedActionResult.consume(user.mainHandStack)
    }

    override fun getEnchantability(): Int = 0

    override fun getMaxUseTime(stack: ItemStack): Int = Int.MAX_VALUE
}
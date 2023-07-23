package org.mineplugin.locusazzurro.semishigure.chargedrifle;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public class ChargeRifleItem extends ProjectileWeaponItem {

    public ChargeRifleItem() {
        super(new Properties());
    }

    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn){
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        ItemStack ammo = playerIn.getProjectile(itemstack);

        if (!playerIn.isCreative() && ammo.isEmpty()){
            return InteractionResultHolder.pass(itemstack);
        }

        ChargeRifleTrackerEntity tracker = new ChargeRifleTrackerEntity(worldIn, playerIn);
        worldIn.addFreshEntity(tracker);

        if (!worldIn.isClientSide()) {
            itemstack.hurtAndBreak(1, playerIn, (player) -> {
                player.broadcastBreakEvent(playerIn.getUsedItemHand());
            });
        }

        if (!playerIn.isCreative()) {
            ammo.shrink(1);
            if (ammo.isEmpty()) {
                playerIn.getInventory().removeItem(ammo);
            }
            playerIn.getCooldowns().addCooldown(this, 80);
        }

        playerIn.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.sidedSuccess(itemstack, worldIn.isClientSide());
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return i -> i.is(Items.IRON_NUGGET);
    }

    @Override
    public int getDefaultProjectileRange() {
        return 100;
    }
}

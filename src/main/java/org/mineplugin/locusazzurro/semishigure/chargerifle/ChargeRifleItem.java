package org.mineplugin.locusazzurro.semishigure.chargerifle;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import org.mineplugin.locusazzurro.semishigure.registry.ItemRegistry;

import java.util.function.Predicate;

public class ChargeRifleItem extends ProjectileWeaponItem {

    public ChargeRifleItem() {
        super(new Properties());
    }

    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn){
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        ItemStack ammo = playerIn.getProjectile(itemstack);
        boolean unbreakable = itemstack.hasTag() && itemstack.getTag().getBoolean("Unbreakable");

        if (!playerIn.isCreative() && ammo.isEmpty() && !unbreakable){
            return InteractionResultHolder.pass(itemstack);
        }

        ChargeRifleTrackerEntity tracker = new ChargeRifleTrackerEntity(worldIn, playerIn);
        worldIn.addFreshEntity(tracker);

        if (!worldIn.isClientSide()) {
            if (!(playerIn.isCreative() || unbreakable)) {
                ammo.hurtAndBreak(1, playerIn, player -> {});
                if (ammo.isEmpty()) {
                    playerIn.getInventory().removeItem(ammo);
                }
            }
            playerIn.getCooldowns().addCooldown(this, 20);
        }



        playerIn.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.sidedSuccess(itemstack, worldIn.isClientSide());
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return i -> i.is(ItemRegistry.SNIPER_AMMO.get());
    }

    @Override
    public int getDefaultProjectileRange() {
        return 100;
    }
}

package org.mineplugin.locusazzurro.semishigure;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class Taiko extends Item{

    public Taiko() {
        super(new Item.Properties().tab(Semishigure.CREATIVE_TAB).stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!player.isCrouching()){
            level.addParticle(ParticleTypeRegistry.DON.get(), player.getX(), player.getEyeY() + 0.5, player.getZ() ,0,0,0);
            level.playSound(null, player, SoundEventRegistry.TAIKO_DON.get(), SoundSource.PLAYERS, 3.0f, 1.0f);
        }
        else {
            level.addParticle(ParticleTypeRegistry.KATSU.get(), player.getX(), player.getEyeY() + 0.5, player.getZ() ,0,0,0);
            level.playSound(null, player, SoundEventRegistry.TAIKO_KATSU.get(), SoundSource.PLAYERS, 3.0f, 1.0f);
        }
        return InteractionResultHolder.fail(player.getItemInHand(hand));
    }
}

package org.mineplugin.locusazzurro.semishigure;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TaikoBlock extends Block {

    public TaikoBlock() {
        super(Properties.of().sound(SoundType.WOOD).strength(1.5f));
    }

    private void playDonNote(Level level, BlockPos pos, boolean big) {
        level.addParticle(ParticleTypeRegistry.DON.get(), pos.getX() + 0.5, pos.getY() + 1.1, pos.getZ() + 0.5 ,0,0,0);
        level.playSound(null, pos, big ? SoundEventRegistry.TAIKO_DON_BIG.get() : SoundEventRegistry.TAIKO_DON.get(), SoundSource.BLOCKS, 10.0f, 1.0f);
    }

    private void playKatsuNote(Level level, BlockPos pos, boolean big) {
        level.addParticle(ParticleTypeRegistry.KATSU.get(), pos.getX() + 0.5, pos.getY() + 1.1, pos.getZ() + 0.5 ,0,0,0);
        level.playSound(null, pos, big ? SoundEventRegistry.TAIKO_KATSU_BIG.get() : SoundEventRegistry.TAIKO_KATSU.get(), SoundSource.BLOCKS, 10.0f, 1.0f);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult ray) {
        this.playKatsuNote(level, pos, player.isCrouching());
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    public void attack(BlockState state, Level level, BlockPos pos, Player player) {
        this.playDonNote(level, pos, player.isCrouching());
    }
}

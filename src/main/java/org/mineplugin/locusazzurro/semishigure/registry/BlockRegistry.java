package org.mineplugin.locusazzurro.semishigure.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.mineplugin.locusazzurro.semishigure.Semishigure;
import org.mineplugin.locusazzurro.semishigure.summerfestival.TaikoBlock;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Semishigure.MOD_ID);
    public static final RegistryObject<Block> TAIKO_BLOCK = BLOCKS.register("taiko_block", TaikoBlock::new);

    public static final RegistryObject<Block> OPERA_FIGURE = BLOCKS.register("opera_figure", () -> new Block(BlockBehaviour.Properties.of().noOcclusion().noCollission().noParticlesOnBreak().noLootTable()));
}

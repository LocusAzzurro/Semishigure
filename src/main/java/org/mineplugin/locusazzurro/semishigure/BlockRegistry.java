package org.mineplugin.locusazzurro.semishigure;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Semishigure.MOD_ID);

    public static final RegistryObject<Block> TAIKO_BLOCK = BLOCKS.register("taiko_block", TaikoBlock::new);
}

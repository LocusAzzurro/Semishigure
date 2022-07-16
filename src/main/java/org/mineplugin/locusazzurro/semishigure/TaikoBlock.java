package org.mineplugin.locusazzurro.semishigure;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class TaikoBlock extends Block {

    public TaikoBlock() {
        super(Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(1.5f));
    }
}

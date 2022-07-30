package org.mineplugin.locusazzurro.semishigure;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class CreativeTabs {

    public static class CreativeTab extends CreativeModeTab {

        public CreativeTab() {
            super(Semishigure.MOD_ID);
        }
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.MUSIC_DISC_5.get());
        }
    }
}
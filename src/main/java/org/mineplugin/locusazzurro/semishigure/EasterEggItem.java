package org.mineplugin.locusazzurro.semishigure;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class EasterEggItem extends Item {
    public EasterEggItem() {
        super(new Properties().tab(Semishigure.CREATIVE_TAB).stacksTo(1).rarity(Rarity.EPIC));
    }
}

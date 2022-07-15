package org.mineplugin.locusazzurro.semishigure;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class Taiko extends Item{

    public Taiko() {
        super(new Item.Properties().tab(Semishigure.CREATIVE_TAB).stacksTo(1).rarity(Rarity.UNCOMMON));
    }
}

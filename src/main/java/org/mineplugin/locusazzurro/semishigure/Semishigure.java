package org.mineplugin.locusazzurro.semishigure;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static org.mineplugin.locusazzurro.semishigure.Semishigure.MOD_ID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MOD_ID)
public class Semishigure {

    public static final String MOD_ID = "semishigure";
    public static final CreativeTabs.CreativeTab CREATIVE_TAB = new CreativeTabs.CreativeTab();
    public Semishigure() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemRegistry.ITEMS.register(bus);
        SoundEventRegistry.SOUNDS.register(bus);

    }
}

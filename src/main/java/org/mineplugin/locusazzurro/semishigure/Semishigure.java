package org.mineplugin.locusazzurro.semishigure;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static org.mineplugin.locusazzurro.semishigure.Semishigure.MOD_ID;

@Mod(MOD_ID)
public class Semishigure {

    public static final String MOD_ID = "semishigure";
    public static final CreativeTabs.CreativeTab CREATIVE_TAB = new CreativeTabs.CreativeTab();
    public Semishigure() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemRegistry.ITEMS.register(bus);
        BlockRegistry.BLOCKS.register(bus);
        SoundEventRegistry.SOUNDS.register(bus);
        ParticleTypeRegistry.PARTICLES.register(bus);

    }
}

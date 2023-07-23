package org.mineplugin.locusazzurro.semishigure.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.mineplugin.locusazzurro.semishigure.Semishigure;

@Mod.EventBusSubscriber(modid = Semishigure.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabRegistry {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Semishigure.MOD_ID);
    public static RegistryObject<CreativeModeTab> FIREWORKS = CREATIVE_TABS.register("semishigure",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.semishigure"))
                    .icon(ItemRegistry.MUSIC_DISC_5.get()::getDefaultInstance)
                    .displayItems((displayParameters, output) -> ItemRegistry.ITEMS.getEntries().stream().map(RegistryObject::get).forEach(output::accept))
                    .build());

    @SubscribeEvent
    public static void buildCreativeTab(BuildCreativeModeTabContentsEvent event){

    }
}

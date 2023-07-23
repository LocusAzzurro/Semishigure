package org.mineplugin.locusazzurro.semishigure.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.mineplugin.locusazzurro.semishigure.chargedrifle.ChargedRifleTrackerRenderer;
import org.mineplugin.locusazzurro.semishigure.registry.EntityTypeRegistry;
import org.mineplugin.locusazzurro.semishigure.registry.ParticleTypeRegistry;
import org.mineplugin.locusazzurro.semishigure.summerfestival.TaikoParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {

    @SubscribeEvent
    public static void onParticleFactoryRegister(RegisterParticleProvidersEvent event){
        ParticleEngine particleEngine = Minecraft.getInstance().particleEngine;
        particleEngine.register(ParticleTypeRegistry.DON.get(), TaikoParticle.Factory::new);
        particleEngine.register(ParticleTypeRegistry.KATSU.get(), TaikoParticle.Factory::new);
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent e){
        registerEntityRenderer(EntityTypeRegistry.CHARGED_RIFLE_TRACKER.get(), ChargedRifleTrackerRenderer::new);
    }

    private static <T extends Entity> void registerEntityRenderer(EntityType<T> type, EntityRendererProvider<T> renderer){
        EntityRenderers.register(type, renderer);
    }
}

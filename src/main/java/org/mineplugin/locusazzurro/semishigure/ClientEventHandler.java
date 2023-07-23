package org.mineplugin.locusazzurro.semishigure;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {

    @SubscribeEvent
    public static void onParticleFactoryRegister(RegisterParticleProvidersEvent event){
        ParticleEngine particleEngine = Minecraft.getInstance().particleEngine;
        particleEngine.register(ParticleTypeRegistry.DON.get(), TaikoParticle.Factory::new);
        particleEngine.register(ParticleTypeRegistry.KATSU.get(), TaikoParticle.Factory::new);
    }
}

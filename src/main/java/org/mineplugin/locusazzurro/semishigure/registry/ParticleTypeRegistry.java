package org.mineplugin.locusazzurro.semishigure.registry;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.mineplugin.locusazzurro.semishigure.Semishigure;

public class ParticleTypeRegistry {

    public static DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Semishigure.MOD_ID);

    public static RegistryObject<SimpleParticleType> DON = PARTICLES.register("don",
            () -> new SimpleParticleType(false));
    public static RegistryObject<SimpleParticleType> KATSU = PARTICLES.register("katsu",
            () -> new SimpleParticleType(false));

}

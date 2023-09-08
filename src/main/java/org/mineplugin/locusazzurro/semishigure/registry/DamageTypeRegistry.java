package org.mineplugin.locusazzurro.semishigure.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import org.mineplugin.locusazzurro.semishigure.Semishigure;

public class DamageTypeRegistry {

    public static final ResourceKey<DamageType> CHARGE_RIFLE = register("charge_rifle");

    private static ResourceKey<DamageType> register(String name)
    {
        return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Semishigure.MOD_ID, name));
    }

}

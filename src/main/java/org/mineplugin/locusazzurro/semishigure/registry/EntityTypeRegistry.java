package org.mineplugin.locusazzurro.semishigure.registry;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.mineplugin.locusazzurro.semishigure.Semishigure;
import org.mineplugin.locusazzurro.semishigure.chargerifle.ChargeRifleTrackerEntity;

import java.util.function.Supplier;

public class EntityTypeRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Semishigure.MOD_ID);


    public static final RegistryObject<EntityType<ChargeRifleTrackerEntity>> CHARGED_RIFLE_TRACKER =
            register("charged_rifle_tracker", () -> EntityType.Builder
                    .<ChargeRifleTrackerEntity>of(ChargeRifleTrackerEntity::new, MobCategory.MISC)
                    .sized(0.1F, 0.1F)
                    .setUpdateInterval(1)
                    .build("charged_rifle_tracker"));


    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, Supplier<EntityType<T>> type) {
        return ENTITIES.register(name, type);
    }

}
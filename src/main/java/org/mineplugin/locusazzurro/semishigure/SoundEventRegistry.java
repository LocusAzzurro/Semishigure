package org.mineplugin.locusazzurro.semishigure;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundEventRegistry {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Semishigure.MOD_ID);

    public static final RegistryObject<SoundEvent> TRACK_NATSUMATSURI = SOUNDS.register("track.natsumatsuri",
            () -> new SoundEvent(new ResourceLocation(Semishigure.MOD_ID, "track.natsumatsuri")));
    public static final RegistryObject<SoundEvent> TRACK_UCHIAGE_HANABI = SOUNDS.register("track.uchiage_hanabi",
            () -> new SoundEvent(new ResourceLocation(Semishigure.MOD_ID, "track.uchiage_hanabi")));
    public static final RegistryObject<SoundEvent> TRACK_NATSUREMBO = SOUNDS.register("track.natsurembo",
            () -> new SoundEvent(new ResourceLocation(Semishigure.MOD_ID, "track.natsurembo")));
    public static final RegistryObject<SoundEvent> TRACK_HANBUNKO_HANABI = SOUNDS.register("track.hanbunko_hanabi",
            () -> new SoundEvent(new ResourceLocation(Semishigure.MOD_ID, "track.hanbunko_hanabi")));
    public static final RegistryObject<SoundEvent> TRACK_SEMISHIGURE = SOUNDS.register("track.semishigure",
            () -> new SoundEvent(new ResourceLocation(Semishigure.MOD_ID, "track.semishigure")));

    public static final RegistryObject<SoundEvent> TAIKO_DON = SOUNDS.register("taiko.don",
            () -> new SoundEvent(new ResourceLocation(Semishigure.MOD_ID, "taiko.don")));
    public static final RegistryObject<SoundEvent> TAIKO_KATSU = SOUNDS.register("taiko.katsu",
            () -> new SoundEvent(new ResourceLocation(Semishigure.MOD_ID, "taiko.katsu")));
    public static final RegistryObject<SoundEvent> TAIKO_DON_BIG = SOUNDS.register("taiko.don_big",
            () -> new SoundEvent(new ResourceLocation(Semishigure.MOD_ID, "taiko.don_big")));
    public static final RegistryObject<SoundEvent> TAIKO_KATSU_BIG = SOUNDS.register("taiko.katsu_big",
            () -> new SoundEvent(new ResourceLocation(Semishigure.MOD_ID, "taiko.katsu_big")));

}

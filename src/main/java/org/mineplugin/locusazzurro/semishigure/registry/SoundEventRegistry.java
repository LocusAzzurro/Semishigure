package org.mineplugin.locusazzurro.semishigure.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.mineplugin.locusazzurro.semishigure.Semishigure;

public class SoundEventRegistry {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Semishigure.MOD_ID);

    public static final RegistryObject<SoundEvent> TRACK_NATSUMATSURI = SOUNDS.register("track.natsumatsuri",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Semishigure.MOD_ID, "track.natsumatsuri")));
    public static final RegistryObject<SoundEvent> TRACK_UCHIAGE_HANABI = SOUNDS.register("track.uchiage_hanabi",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Semishigure.MOD_ID, "track.uchiage_hanabi")));
    public static final RegistryObject<SoundEvent> TRACK_NATSUREMBO = SOUNDS.register("track.natsurembo",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Semishigure.MOD_ID, "track.natsurembo")));
    public static final RegistryObject<SoundEvent> TRACK_HANBUNKO_HANABI = SOUNDS.register("track.hanbunko_hanabi",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Semishigure.MOD_ID, "track.hanbunko_hanabi")));
    public static final RegistryObject<SoundEvent> TRACK_SEMISHIGURE = SOUNDS.register("track.semishigure",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Semishigure.MOD_ID, "track.semishigure")));

    public static final RegistryObject<SoundEvent> TAIKO_DON = SOUNDS.register("taiko.don",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Semishigure.MOD_ID, "taiko.don")));
    public static final RegistryObject<SoundEvent> TAIKO_KATSU = SOUNDS.register("taiko.katsu",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Semishigure.MOD_ID, "taiko.katsu")));
    public static final RegistryObject<SoundEvent> TAIKO_DON_BIG = SOUNDS.register("taiko.don_big",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Semishigure.MOD_ID, "taiko.don_big")));
    public static final RegistryObject<SoundEvent> TAIKO_KATSU_BIG = SOUNDS.register("taiko.katsu_big",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Semishigure.MOD_ID, "taiko.katsu_big")));

    public static final RegistryObject<SoundEvent> BACKROOM_AMBIENT = SOUNDS.register("ambient.backroom",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Semishigure.MOD_ID, "ambient.backroom")));

}

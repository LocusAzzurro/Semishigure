package org.mineplugin.locusazzurro.semishigure;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Semishigure.MOD_ID);

    public static final RegistryObject<Item> MUSIC_DISC_1 = ITEMS.register("summer_disc_1",
            () -> new SummerMusicDisc(SummerMusicDisc.Track.NATSUMATSURI));
    public static final RegistryObject<Item> MUSIC_DISC_2 = ITEMS.register("summer_disc_2",
            () -> new SummerMusicDisc(SummerMusicDisc.Track.UCHIAGE_HANABI));
    public static final RegistryObject<Item> MUSIC_DISC_3 = ITEMS.register("summer_disc_3",
            () -> new SummerMusicDisc(SummerMusicDisc.Track.NATSUREMBO));
    public static final RegistryObject<Item> MUSIC_DISC_4 = ITEMS.register("summer_disc_4",
            () -> new SummerMusicDisc(SummerMusicDisc.Track.HANBUNKO_HANABI));
    public static final RegistryObject<Item> MUSIC_DISC_5 = ITEMS.register("summer_disc_5",
            () -> new SummerMusicDisc(SummerMusicDisc.Track.SEMISHIGURE));

}

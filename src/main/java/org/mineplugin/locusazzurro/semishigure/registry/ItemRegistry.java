package org.mineplugin.locusazzurro.semishigure.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.mineplugin.locusazzurro.semishigure.chargerifle.ChargeRifleItem;
import org.mineplugin.locusazzurro.semishigure.chargerifle.SniperAmmo;
import org.mineplugin.locusazzurro.semishigure.nocaet.EasterEggItem;
import org.mineplugin.locusazzurro.semishigure.Semishigure;
import org.mineplugin.locusazzurro.semishigure.summerfestival.SummerMusicDisc;
import org.mineplugin.locusazzurro.semishigure.summerfestival.Taiko;

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
    public static final RegistryObject<Item> TAIKO = ITEMS.register("taiko", Taiko::new);
    public static final RegistryObject<Item> FLAME_ICARUSWINGS = ITEMS.register("flame_icaruswings",
            () -> new EasterEggItem(EasterEggItem.ModID.ICARUSWINGS));
    public static final RegistryObject<Item> FLAME_PYROTECHNICRAFT = ITEMS.register("flame_pyrotechnicraft",
            () -> new EasterEggItem(EasterEggItem.ModID.PYROTECHNICRAFT));
    public static final RegistryObject<Item> FLAME_SEMISHIGURE = ITEMS.register("flame_semishigure",
            () -> new EasterEggItem(EasterEggItem.ModID.SEMISHIGURE));
    public static final RegistryObject<Item> TAIKO_BLOCK = fromBlock(BlockRegistry.TAIKO_BLOCK);
    public static final RegistryObject<Item> CHARGE_RIFLE = ITEMS.register("charge_rifle", ChargeRifleItem::new);
    public static final RegistryObject<Item> SNIPER_AMMO = ITEMS.register("sniper_ammo", SniperAmmo::new);

    private static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }
}

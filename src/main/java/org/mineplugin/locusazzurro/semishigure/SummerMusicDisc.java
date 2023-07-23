package org.mineplugin.locusazzurro.semishigure;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;
import java.time.Duration;

import net.minecraft.world.item.Item.Properties;

public class SummerMusicDisc extends RecordItem {

    private Track track;
    public SummerMusicDisc(Track track) {
        super(track.trackNum, track.getMusic(), new Properties().stacksTo(1).rarity(Rarity.RARE), 1);
        this.track = track;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level p_43044_, List<Component> tooltip, TooltipFlag p_43046_) {
        SummerMusicDisc disc = (SummerMusicDisc)stack.getItem();
        tooltip.add(disc.getDisplayName().withStyle(ChatFormatting.GRAY));
    }

    @Override
    public MutableComponent getDisplayName() {
        return Component.literal(this.getTrack().getAuthor() + " - " + this.getTrack().getTrackName());
    }

    public Track getTrack(){
        return this.track;
    }

    public enum Track{
        NATSUMATSURI(1, SoundEventRegistry.TRACK_NATSUMATSURI, "夏祭り", "ジッタリン・ジン", (int) Duration.ofSeconds(232).getSeconds() * 20),
        UCHIAGE_HANABI(2, SoundEventRegistry.TRACK_UCHIAGE_HANABI, "打上花火", "DAOKO × 米津玄師", (int) Duration.ofSeconds(292).getSeconds() * 20),
        NATSUREMBO(3, SoundEventRegistry.TRACK_NATSUREMBO, "夏恋慕 feat. 春茶", "KOBASOLO", (int) Duration.ofSeconds(266).getSeconds() * 20),
        HANBUNKO_HANABI(4, SoundEventRegistry.TRACK_HANBUNKO_HANABI, "はんぶんこ花火", "ハッピーくるくる", (int) Duration.ofSeconds(230).getSeconds() * 20),
        SEMISHIGURE(5, SoundEventRegistry.TRACK_SEMISHIGURE, "蝉時雨 feat. 福原遥", "Yunomi", (int) Duration.ofSeconds(189).getSeconds() * 20);
        private final int trackNum;
        private final Supplier<SoundEvent> trackMusic;
        private final String trackName;
        private final String author;
        private final int length;

        private Track(int trackNum, Supplier<SoundEvent> trackMusic, String trackName, String author, int length) {
            this.trackNum = trackNum;
            this.trackMusic = trackMusic;
            this.trackName = trackName;
            this.author = author;
            this.length = length;
        }

        private Supplier<SoundEvent> getMusic() {return this.trackMusic;}
        private String getTrackName() {return this.trackName;}
        private String getAuthor() {return this.author;}

        private int getLength() {
            return this.length;
        }
    }

}

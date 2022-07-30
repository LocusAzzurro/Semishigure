package org.mineplugin.locusazzurro.semishigure;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class SummerMusicDisc extends RecordItem {

    private Track track;
    public SummerMusicDisc(Track track) {
        super(track.trackNum, track.getMusic(), new Properties().tab(Semishigure.CREATIVE_TAB).stacksTo(1).rarity(Rarity.RARE));
        this.track = track;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level p_43044_, List<Component> tooltip, TooltipFlag p_43046_) {
        SummerMusicDisc disc = (SummerMusicDisc)stack.getItem();
        tooltip.add(disc.getDisplayName().withStyle(ChatFormatting.GRAY));
    }

    @Override
    public MutableComponent getDisplayName() {
        return new TextComponent(this.getTrack().getAuthor() + " - " + this.getTrack().getTrackName());
    }

    public Track getTrack(){
        return this.track;
    }

    public enum Track{
        NATSUMATSURI(1, SoundEventRegistry.TRACK_NATSUMATSURI, "夏祭り", "ジッタリン・ジン"),
        UCHIAGE_HANABI(2, SoundEventRegistry.TRACK_UCHIAGE_HANABI, "打上花火", "DAOKO × 米津玄師"),
        NATSUREMBO(3, SoundEventRegistry.TRACK_NATSUREMBO, "夏恋慕 feat. 春茶", "KOBASOLO"),
        HANBUNKO_HANABI(4, SoundEventRegistry.TRACK_HANBUNKO_HANABI, "はんぶんこ花火", "ハッピーくるくる"),
        SEMISHIGURE(5, SoundEventRegistry.TRACK_SEMISHIGURE, "蝉時雨 feat. 福原遥", "Yunomi");
        private final int trackNum;
        private final Supplier<SoundEvent> trackMusic;
        private final String trackName;
        private final String author;

        private Track(int trackNum, Supplier<SoundEvent> trackMusic, String trackName, String author) {
            this.trackNum = trackNum;
            this.trackMusic = trackMusic;
            this.trackName = trackName;
            this.author = author;
        }

        private Supplier<SoundEvent> getMusic() {return this.trackMusic;}
        private String getTrackName() {return this.trackName;}
        private String getAuthor() {return this.author;}
    }

}

package org.mineplugin.locusazzurro.semishigure;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

import java.util.function.Supplier;

public class SummerMusicDisc extends RecordItem {

    public SummerMusicDisc(Track track) {
        super(track.trackNum, track.getMusic(), new Properties().tab(Semishigure.CREATIVE_TAB).stacksTo(1).rarity(Rarity.RARE));
    }

    public enum Track{
        NATSUMATSURI(1, SoundEventRegistry.TRACK_NATSUMATSURI, "夏祭り", "ジッタリン・ジン"),
        UCHIAGE_HANABI(2, SoundEventRegistry.TRACK_UCHIAGE_HANABI, "打上花火", "DAOKO × 米津玄师"),
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

        private int getTrackNum() {return this.trackNum;}
        private Supplier<SoundEvent> getMusic() {return this.trackMusic;}
        private String getTrackName() {return this.trackName;}
        private String getAuthor() {return this.author;}
    }

}

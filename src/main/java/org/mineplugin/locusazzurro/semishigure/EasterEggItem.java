package org.mineplugin.locusazzurro.semishigure;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class EasterEggItem extends Item {

    public static final String ICARUS_TEXT = """
            "Never regret thy fall,
            O Icarus of the fearless flight,
            For the greatest tragedy of them all,
            Is never to feel the burning light."
            - Oscar Wilde
            """;
    public static final String FIREWORK_TEXT = """
            "Fireworks, please shine on the moment I've drawn in my dreams
            So that I won't be separated from your hand
            I muttered with a voice nobody could hear: 'Please don't disappear'
            Softly, the petals rain down into the future we both spend together"
            - Natsukoi Hanabi
            """;
    private final ModID ID;
    public EasterEggItem(ModID id) {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC));
        this.ID = id;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        Item item = stack.getItem();
        if (item instanceof EasterEggItem flame){
            ModID id = flame.getID();
            switch (id) {
                case ICARUSWINGS ->
                        tooltip.add(Component.literal(ICARUS_TEXT).setStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.GRAY)));
                case PYROTECHNICRAFT ->
                        tooltip.add(Component.literal(FIREWORK_TEXT).withStyle(ChatFormatting.LIGHT_PURPLE));
                case SEMISHIGURE -> {}
            }
        }
    }

    public ModID getID(){
        return ID;
    }
    enum ModID {
        ICARUSWINGS, PYROTECHNICRAFT, SEMISHIGURE
    }
}

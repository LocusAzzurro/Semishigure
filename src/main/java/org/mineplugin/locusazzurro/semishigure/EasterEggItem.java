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

import net.minecraft.world.item.Item.Properties;

public class EasterEggItem extends Item {

    private ModID ID;
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
                        tooltip.add(Component.literal(
                                """
                                        "Never regret thy fall,
                                        O Icarus of the fearless flight,
                                        For the greatest tragedy of them all,
                                        Is never to feel the burning light."
                                        - Oscar Wilde
                                        """)
                                .setStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.GRAY)));
                case PYROTECHNICRAFT ->
                        tooltip.add(Component.literal(
                                """
                                        「夢に描いた一瞬を照らし出してよ 花火
                                        繋いだあなたのその手見失わないように
                                        誰にも聞こえぬ声で呟いた『消えないで』
                                        そっと、ふたりが過ごす未来に降り注ぐ花びら」
                                        - 夏恋花火
                                        """)
                                .withStyle(ChatFormatting.LIGHT_PURPLE));
                case SEMISHIGURE -> {}
            }
        }
    }

    public ModID getID(){
        return ID;
    }
    enum ModID {
        ICARUSWINGS, PYROTECHNICRAFT, SEMISHIGURE;
    }
}

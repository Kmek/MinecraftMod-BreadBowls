package com.example.breadbowls;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BreadBowlSoupItem extends Item {
    public BreadBowlSoupItem(Properties p_41383_) {
        super(p_41383_);
    }

    public BreadBowlSoupItem(int nutrition, float saturation) {
        super(new Item.Properties()
                .stacksTo(16)
                .food(new FoodProperties.Builder()
                        .alwaysEat()
                        .nutrition(nutrition)
                        .saturationMod(saturation)
                        .build()));
    }

    public BreadBowlSoupItem(FoodProperties props) {
        super(new Item.Properties()
                .stacksTo(16)
                .food(props));
    }

//    @Override
//    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
//        tooltip.add(Component.translatable("tooltip.breadbowls.item_description")
//                .withStyle(ChatFormatting.GRAY));
//        super.appendHoverText(stack, level, tooltip, flag);
//    }
}

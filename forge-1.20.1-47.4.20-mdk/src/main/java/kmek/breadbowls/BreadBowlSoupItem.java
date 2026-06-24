package kmek.breadbowls;

import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BreadBowlSoupItem extends Item {
    private String tooltipTranslatable = null;

    public BreadBowlSoupItem(Properties p_41383_) {
        super(p_41383_);
    }

    public BreadBowlSoupItem(int nutrition, float saturation) {
        super(new Item.Properties()
                .stacksTo(16)
                .food(new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationMod(saturation)
                        .build()));
    }

    public BreadBowlSoupItem(FoodProperties props) {
        super(new Item.Properties()
                .stacksTo(16)
                .food(modifyFoodProperties(props)));
    }

    private static FoodProperties modifyFoodProperties(FoodProperties props) {
        var builder = new FoodProperties.Builder()
                .nutrition(props.getNutrition() + 5) // +5 sat for the bread
                .saturationMod(props.getSaturationModifier());

        if (props.canAlwaysEat())
            builder = builder.alwaysEat();
        if (props.isFastFood())
            builder = builder.fast();
        if (props.isMeat())
            builder = builder.meat();

        for (Pair<MobEffectInstance, Float> pair : props.getEffects()) {
            builder = builder.effect(pair::getFirst, pair.getSecond());
        }

        return builder.build();
    }

    public BreadBowlSoupItem(FoodProperties props, String tooltip) {
        this(props);
        this.tooltipTranslatable = tooltip;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if (this.tooltipTranslatable != null) {
            tooltip.add(Component.translatable(this.tooltipTranslatable)
                    .withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(stack, level, tooltip, flag);
    }
}

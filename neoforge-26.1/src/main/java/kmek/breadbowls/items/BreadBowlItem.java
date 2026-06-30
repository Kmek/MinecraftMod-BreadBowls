package kmek.breadbowls.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class BreadBowlItem extends Item {
    private String tooltipTranslatable = null;

    public BreadBowlItem(FoodProperties props) {
        super(BreadBowlPropsUtils.ItemAndFoodProps(props));
    }

    public BreadBowlItem(FoodProperties props, String tooltip) {
        this(props);
        this.tooltipTranslatable = tooltip;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        if (this.tooltipTranslatable != null) {
            builder.accept(
                    Component.translatable(this.tooltipTranslatable)
                    .withStyle(ChatFormatting.BLUE));
        }
//        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}

package kmek.breadbowls.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

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
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (this.tooltipTranslatable != null) {
            tooltipComponents.add(Component.translatable(this.tooltipTranslatable)
                    .withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}

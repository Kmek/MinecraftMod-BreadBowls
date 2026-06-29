package kmek.breadbowls.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BreadBowlItem extends Item {
    private String tooltipTranslatable = null;

    public BreadBowlItem(FoodProperties props) {
        super(BreadBowlPropsUtils.ItemAndFoodProps(props));
    }

    public BreadBowlItem(FoodProperties props, CreativeModeTab tab) {
        super(BreadBowlPropsUtils.ItemAndFoodProps(props, tab));
    }

    public BreadBowlItem(FoodProperties props, String tooltip) {
        this(props);
        this.tooltipTranslatable = tooltip;
    }

    public BreadBowlItem(FoodProperties props, CreativeModeTab tab, String tooltip) {
        this(props, tab);
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

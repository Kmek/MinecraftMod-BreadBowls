package kmek.breadbowls.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class BreadBowlPropsUtils {

    public static FoodProperties FoodProps(FoodProperties props) {
        var builder = new FoodProperties.Builder()
                .nutrition(props.nutrition() + 5) // +5 sat for the bread
                .saturationModifier(props.saturation() / props.nutrition() / 2);

        if (props.canAlwaysEat())
            builder = builder.alwaysEdible();
        if (props.eatSeconds() == 0.8F)
            builder = builder.fast();

        for (FoodProperties.PossibleEffect e : props.effects()) {
            builder = builder.effect(e.effectSupplier(), e.probability());
        }

        return builder.build();
    }

    public static FoodProperties FoodProps(int nutrition, float saturation) {
        return new FoodProperties.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturation)
                .build();
    }

    public static Item.Properties ItemProps(FoodProperties food) {
        return new Item.Properties()
                .food(food)
                .stacksTo(16);
    }

    public static Item.Properties ItemAndFoodProps(FoodProperties food) {
        return ItemProps(FoodProps(food));
    }
}

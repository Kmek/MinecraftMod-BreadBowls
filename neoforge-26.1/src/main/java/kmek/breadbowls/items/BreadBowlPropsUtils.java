package kmek.breadbowls.items;

import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;

public class BreadBowlPropsUtils {

    public static FoodProperties FoodProps(FoodProperties props) {
        var builder = new FoodProperties.Builder()
                .nutrition(props.nutrition() + 5) // +5 sat for the bread
                .saturationModifier(props.saturation() / props.nutrition() / 2);

        if (props.canAlwaysEat())
            builder = builder.alwaysEdible();

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

    // todo copy over food effects somehow
//    public static Item.Properties ItemAndFoodProps(FoodProperties food, Item item) {
//        var builder = ItemProps(FoodProps(food));
//
////        for (DataComponentMap.Entry<?> entry  : item.components().get(Consumable)) {
////            builder.
////        }
//
//        return builder;
//    }
}

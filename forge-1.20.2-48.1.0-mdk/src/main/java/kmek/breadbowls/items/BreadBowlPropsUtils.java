package kmek.breadbowls.items;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class BreadBowlPropsUtils {

    public static FoodProperties FoodProps(FoodProperties props) {
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

    public static FoodProperties FoodProps(int nutrition, float saturation) {
        return new FoodProperties.Builder()
                .nutrition(nutrition)
                .saturationMod(saturation)
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

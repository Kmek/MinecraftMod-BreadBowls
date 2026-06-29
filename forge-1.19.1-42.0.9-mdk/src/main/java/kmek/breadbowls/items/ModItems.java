package kmek.breadbowls.items;

import kmek.breadbowls.BreadBowlsMod;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BreadBowlsMod.MODID);

    public static final RegistryObject<Item> BREAD_BOWL = ITEMS.register("bread_bowl",
            () -> new Item(new Item.Properties()
                    .food(Foods.BREAD)
                    .tab(ModCreativeTab.instance)));
    public static final RegistryObject<Item> BEETROOT_SOUP = ITEMS.register("beetroot_soup",
            () -> new BreadBowlItem(Foods.BEETROOT_SOUP, ModCreativeTab.instance));
    public static final RegistryObject<Item> MUSHROOM_STEW = ITEMS.register("mushroom_stew",
            () -> new BreadBowlItem(Foods.MUSHROOM_STEW, ModCreativeTab.instance));
    public static final RegistryObject<Item> RABBIT_STEW = ITEMS.register("rabbit_stew",
            () -> new BreadBowlItem(Foods.RABBIT_STEW, ModCreativeTab.instance));
    public static final RegistryObject<Item> SUSPICIOUS_STEW = ITEMS.register("suspicious_stew",
            () -> new BreadBowlItem(Foods.SUSPICIOUS_STEW, ModCreativeTab.instance, "tooltip.breadbowls.suspicious_stew"));
}

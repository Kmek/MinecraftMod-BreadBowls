package kmek.breadbowls.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static kmek.breadbowls.items.ModItems.BREAD_BOWL;

public class ModCreativeTab extends CreativeModeTab {
    private ModCreativeTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(BREAD_BOWL.get());
    }

    public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, "breadbowls.creative_tab");
}

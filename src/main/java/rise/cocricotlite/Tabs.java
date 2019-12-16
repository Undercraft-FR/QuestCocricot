package rise.cocricotlite;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import rise.cocricotlite.init.CBlocks;

public class Tabs {

    public static CreativeTabs TAB_DISH = new CreativeTabs("tab_dish")
    {
        public ItemStack getTabIconItem()
        {
            return new ItemStack(CBlocks.PIZZA, 1, 0);
        }
    };

    public static CreativeTabs TAB_NATURE = new CreativeTabs("tab_nature")
    {
        public ItemStack getTabIconItem()
        {
            return new ItemStack(CBlocks.FLOWER_POT, 1, 3);
        }
    };

    public static CreativeTabs TAB_INTERIOR = new CreativeTabs("tab_interior")
    {
        public ItemStack getTabIconItem()
        {
            return new ItemStack(CBlocks.WHOLE_CAKE, 1, 0);
        }
    };
}

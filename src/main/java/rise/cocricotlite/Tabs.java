package rise.cocricotlite;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import rise.cocricotlite.init.CBlocks;

public class Tabs {

    public static CreativeTabs TAB_DISH = new CreativeTabs("tab_dish")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(CBlocks.PIZZA, 1, 0);
        }
    };

    public static CreativeTabs TAB_NATURE = new CreativeTabs("tab_nature")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(CBlocks.WHOLE_CAKE, 1, 0);
        }
    };
}

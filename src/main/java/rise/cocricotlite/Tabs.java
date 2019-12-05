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
}

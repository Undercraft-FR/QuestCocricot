package rise.cocricotlite.init;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import rise.cocricotlite.CocricotLite;
import rise.cocricotlite.Tabs;
import rise.cocricotlite.block.BaseFacing;
import rise.cocricotlite.block.dish.*;
import rise.cocricotlite.util.AABBList;

public class BlockRegistry {

    public static void load()
    {
        CBlocks.COFFEE = new BlockCoffee();
        CBlocks.CAFE_GLASS = new BlockCafeGlass();
        CBlocks.TAPIOCA = new BlockTapioca();
        CBlocks.CHAMPAGNE = new BlockChampagne();
        CBlocks.WINE = new BlockWine();
        CBlocks.BREAKFAST = new BlockBreakfast();
        CBlocks.PIZZA = new BlockPizza();
        CBlocks.WHOLE_CAKE = new BaseFacing("whole_cake", Material.WOOD, Tabs.TAB_DISH, SoundType.WOOD, 0.5F, 1F)
        {
            public void registerModels()
            {
                CocricotLite.proxy.registerItemModel(Item.getItemFromBlock(this), 0, new ModelResourceLocation("cocricotlite:dish/whole_cake", "inventory"));
            }

            public boolean isFullCube(IBlockState state)
            {
                return false;
            }

            public boolean isOpaqueCube(IBlockState state)
            {
                return false;
            }
        }.setBoundingBox(AABBList.AABB_CUBE_SMALL).register();
        CBlocks.PANCAKE = new BlockPancake();

    }
}

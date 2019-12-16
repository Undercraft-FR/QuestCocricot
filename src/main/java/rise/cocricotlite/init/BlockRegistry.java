package rise.cocricotlite.init;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rise.cocricotlite.CocricotLite;
import rise.cocricotlite.Tabs;
import rise.cocricotlite.block.BaseFacing;
import rise.cocricotlite.block.dish.*;
import rise.cocricotlite.block.interior.*;
import rise.cocricotlite.block.nature.*;
import rise.cocricotlite.tileentity.TileEntityBook;
import rise.cocricotlite.tileentity.TileEntityWindoxBox;
import rise.cocricotlite.util.AABBList;
import rise.cocricotlite.util.Helper;

public class BlockRegistry {

    public static void load()
    {
        //DISH
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
                Helper.registerItemModel(this, "dish", "whole_cake");
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

        //NATURE
        CBlocks.DROOPING_LEAVES = new BlockDroopingLeaves();
        CBlocks.WALL_LEAVES = new BlockWallLeaves();
        CBlocks.PLANTING_GREEN = new BlockPlantingGreen();
        CBlocks.FLOWER_POT = new BlockFlowerPot("flower_pot");
        CBlocks.FLOWER_POT_BIG = new BlockFlowerPot("flower_pot_big");
        CBlocks.VASE = new BlockVase();
        CBlocks.WINDOW_BOX = new BlockWindowBox();
        CBlocks.HANGING_PLANT = new BlockHangingPlant();
        CBlocks.MINI_TREE = new BlockMiniTree();

        //INTERIOR
        CBlocks.BOOK = new BlockBook();
        CBlocks.MENU = new BlockMenu();
        CBlocks.SAMPLE = new BlockSample();
        CBlocks.JAR = new BlockJar();
        CBlocks.COOKING_POT = new BlockCookingPot();
        CBlocks.GLOBE = new BlockGlobe();
        CBlocks.ELECTRIC = new BlockElectric();
        CBlocks.RECORD_PLAYER = new BlockRecordPlayer();

    }
}

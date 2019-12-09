package rise.cocricotlite.init;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.GameData;
import rise.cocricotlite.CocricotLite;
import rise.cocricotlite.util.LogHelper;
import rise.cocricotlite.util.type.EnumFlowerPot;

public class Recipes {

    public static void load()
    {
        dish();
    }

    public static void dish()
    {
        addShapedRecipe(new ItemStack(CBlocks.COFFEE, 1, 0), "X", "B", 'X', new ItemStack(Items.DYE, 1, 3), 'B', Items.BOWL);
        addShapelessRecipe(new ItemStack(CBlocks.COFFEE, 2, 0), new ItemStack(CBlocks.COFFEE, 1, 1));
        addShapelessRecipe(new ItemStack(CBlocks.COFFEE, 1, 1), new ItemStack(CBlocks.COFFEE, 1, 0), new ItemStack(CBlocks.COFFEE, 1, 0));
        addShapedRecipe(new ItemStack(CBlocks.CAFE_GLASS, 1, 0), "X", "B", 'X', new ItemStack(Items.DYE, 1, 3), 'B', Items.GLASS_BOTTLE);
        addShapelessRecipe(new ItemStack(CBlocks.CAFE_GLASS, 1, 0), new ItemStack(CBlocks.CAFE_GLASS, 1, 1));
        addShapelessRecipe(new ItemStack(CBlocks.CAFE_GLASS, 1, 1), new ItemStack(CBlocks.CAFE_GLASS, 1, 0));
        addShapedRecipe(new ItemStack(CBlocks.TAPIOCA, 1, 0), " S ", "WBW", " S ", 'S', Items.SUGAR, 'W', Items.WHEAT, 'B', Items.POTIONITEM);
        addShapelessRecipe(new ItemStack(CBlocks.TAPIOCA, 1, 0), new ItemStack(CBlocks.TAPIOCA, 1, 4));
        addShapelessRecipe(new ItemStack(CBlocks.TAPIOCA, 1, 1), new ItemStack(CBlocks.TAPIOCA, 1, 0));
        addShapelessRecipe(new ItemStack(CBlocks.TAPIOCA, 1, 2), new ItemStack(CBlocks.TAPIOCA, 1, 1));
        addShapelessRecipe(new ItemStack(CBlocks.TAPIOCA, 1, 3), new ItemStack(CBlocks.TAPIOCA, 1, 2));
        addShapelessRecipe(new ItemStack(CBlocks.TAPIOCA, 1, 4), new ItemStack(CBlocks.TAPIOCA, 1, 3));
        addShapedRecipe(new ItemStack(CBlocks.CHAMPAGNE, 1, 0), "A", "X", 'A', new ItemStack(Items.DYE, 1, 15), 'X', Items.POTIONITEM);
        addShapelessRecipe(new ItemStack(CBlocks.CHAMPAGNE, 2, 0), new ItemStack(CBlocks.CHAMPAGNE, 1, 1));
        addShapelessRecipe(new ItemStack(CBlocks.CHAMPAGNE, 1, 1), new ItemStack(CBlocks.CHAMPAGNE, 1, 0), new ItemStack(CBlocks.CHAMPAGNE, 1, 0));
        addShapedRecipe(new ItemStack(CBlocks.CHAMPAGNE, 1, 2), "A", "X", 'A', new ItemStack(Items.DYE, 1, 1), 'X', Items.POTIONITEM);
        addShapelessRecipe(new ItemStack(CBlocks.CHAMPAGNE, 2, 2), new ItemStack(CBlocks.CHAMPAGNE, 1, 3));
        addShapelessRecipe(new ItemStack(CBlocks.CHAMPAGNE, 1, 3), new ItemStack(CBlocks.CHAMPAGNE, 1, 2), new ItemStack(CBlocks.CHAMPAGNE, 1, 2));
        addShapedRecipe(new ItemStack(CBlocks.WINE, 1, 0), "A", "W", 'A', new ItemStack(Items.DYE, 1, 1), 'W', Items.GLASS_BOTTLE);
        addShapelessRecipe(new ItemStack(CBlocks.WINE, 2, 0), new ItemStack(CBlocks.WINE, 1, 1));
        addShapelessRecipe(new ItemStack(CBlocks.WINE, 1, 1), new ItemStack(CBlocks.WINE, 1, 0), new ItemStack(CBlocks.WINE, 1, 0));
        addShapedRecipe(new ItemStack(CBlocks.WINE, 1, 2), "A", "W", 'A', new ItemStack(Items.DYE, 1, 15), 'W', Items.GLASS_BOTTLE);
        addShapelessRecipe(new ItemStack(CBlocks.WINE, 2, 2), new ItemStack(CBlocks.WINE, 1, 3));
        addShapelessRecipe(new ItemStack(CBlocks.WINE, 1, 3), new ItemStack(CBlocks.WINE, 1, 2), new ItemStack(CBlocks.WINE, 1, 2));
        addShapedRecipe(new ItemStack(CBlocks.WINE, 1, 4), "PAP", 'P', Items.PAPER, 'A', Items.POTIONITEM);
        addShapedRecipe(new ItemStack(CBlocks.BREAKFAST, 1, 0), "BAM"," W ", 'B', Items.BREAD, 'A', Items.APPLE, 'M', Items.PORKCHOP, 'W', Items.BOWL);
        addShapedRecipe(new ItemStack(CBlocks.BREAKFAST, 1, 1), "BAM"," W ", 'B', Items.BREAD, 'A', Items.SUGAR, 'M', Items.EGG, 'W', Items.BOWL);
        addShapedRecipe(new ItemStack(CBlocks.PIZZA, 1, 0), "BMB","WWW"," C ", 'B', Items.BEETROOT, 'M', Items.MILK_BUCKET, 'W', Items.WHEAT, 'C', Items.BOWL);
        addShapedRecipe(new ItemStack(CBlocks.PIZZA, 1, 1), "MMM","WWW"," C ", 'M', Items.MILK_BUCKET, 'W', Items.WHEAT, 'C', Items.BOWL);
        addShapedRecipe(new ItemStack(CBlocks.WHOLE_CAKE, 1, 0), "X", "C", 'X', Items.CAKE, 'C', Items.BOWL);
        addShapedRecipe(new ItemStack(CBlocks.PANCAKE, 1, 0), "PC", "BB", 'P', Items.BREAD, 'C', Items.CAKE, 'B', Items.BOWL);
        addShapelessRecipe(new ItemStack(CBlocks.PANCAKE, 1, 0), new ItemStack(CBlocks.PANCAKE, 1, 3));
        addShapelessRecipe(new ItemStack(CBlocks.PANCAKE, 1, 1), new ItemStack(CBlocks.PANCAKE, 1, 0));
        addShapelessRecipe(new ItemStack(CBlocks.PANCAKE, 1, 2), new ItemStack(CBlocks.PANCAKE, 1, 1));
        addShapelessRecipe(new ItemStack(CBlocks.PANCAKE, 1, 3), new ItemStack(CBlocks.PANCAKE, 1, 2));

        //PlantingGreen
        addPlantingGreenRecipe(0, new ItemStack(Blocks.SAPLING, 1, 0));
        addPlantingGreenRecipe(1, new ItemStack(Blocks.SAPLING, 1, 3));
        addPlantingGreenRecipe(2, new ItemStack(Blocks.TALLGRASS, 1, 1));
        addPlantingGreenRecipe(3, new ItemStack(Blocks.SAPLING, 1, 4));
        addPlantingGreenRecipe(4, new ItemStack(Blocks.SAPLING, 1, 5));
        addPlantingGreenRecipe(5, new ItemStack(Blocks.TALLGRASS, 1, 2));
        addPlantingGreenRecipe(6, new ItemStack(Blocks.SAPLING, 1, 1));
        addPlantingGreenRecipe(7, new ItemStack(Blocks.SAPLING, 1, 2));
        addPlantingGreenRecipe(8, new ItemStack(Items.REEDS));
        addPlantingGreenRecipe(9, new ItemStack(Blocks.DEADBUSH));
        addPlantingGreenRecipe(10, new ItemStack(Blocks.CACTUS));

        addFlowerPotRecipe();
    }

    private static void addFlowerPotRecipe()
    {
        addShapedRecipe(new ItemStack(CBlocks.FLOWER_POT, 1, 0), "XCX"," X ", 'C', Items.FLOWER_POT, 'X', Items.BRICK);
        addShapedRecipe(new ItemStack(CBlocks.FLOWER_POT_BIG, 1, 0), "XCX","XXX", 'C', Items.FLOWER_POT, 'X', Items.BRICK);

        for(int outMeta = 0; outMeta < EnumFlowerPot.values().length; ++outMeta)
        {
            int inMeta = outMeta - 1;

            if(inMeta < 0)
                inMeta = EnumFlowerPot.values().length - 1;

            addShapelessRecipe(new ItemStack(CBlocks.FLOWER_POT, 1, outMeta), new ItemStack(CBlocks.FLOWER_POT, 1, inMeta));
            addShapelessRecipe(new ItemStack(CBlocks.FLOWER_POT_BIG, 1, outMeta), new ItemStack(CBlocks.FLOWER_POT_BIG, 1, inMeta));
        }
    }

    private static void addPlantingGreenRecipe(int meta, ItemStack material)
    {
        addShapedRecipe(new ItemStack(CBlocks.PLANTING_GREEN, 1, meta), "X", "C", 'X', material, 'C', Blocks.LOG);
        addShapedRecipe(new ItemStack(CBlocks.PLANTING_GREEN, 1, meta), "X", "C", 'X', material, 'C', Blocks.LOG2);
    }

    /**
     * レシピのカウント
     * 名前設定がめんどくさいので数字を増やす形式にした
     */
    private static int RECIPE_COUNT;

    /**
     * 定形レシピを追加する
     * @param output 完成品
     * @param params パラメータ
     */
    private static void addShapedRecipe(ItemStack output, Object ... params)
    {
        GameRegistry.addShapedRecipe(new ResourceLocation(CocricotLite.MOD_ID, "cocricotlite_recipe_" + RECIPE_COUNT), new ResourceLocation(CocricotLite.MOD_ID), output, params);
        ++RECIPE_COUNT;
    }

    /**
     * 不定形レシピを追加する
     * @param output 完成品
     * @param params パラメータ
     */
    private static void addShapelessRecipe(ItemStack output, Object ... params)
    {
        NonNullList<Ingredient> list = NonNullList.create();

        for(Object content : params)
        {
            if(content instanceof ItemStack)
            {
                list.add(Ingredient.fromStacks(((ItemStack) content).copy()));
            }

            if(content instanceof Item)
            {
                list.add(Ingredient.fromStacks(new ItemStack((Item) content)));
            }

            if(content instanceof Block)
            {
                list.add(Ingredient.fromStacks(new ItemStack((Block) content)));
            }
        }

        ShapelessRecipes recipes = new ShapelessRecipes(CocricotLite.MOD_ID, output, list);
        GameData.register_impl(recipes.setRegistryName(new ResourceLocation(CocricotLite.MOD_ID, "cocricotlite_recipe_" + RECIPE_COUNT)));
        ++RECIPE_COUNT;
    }
}

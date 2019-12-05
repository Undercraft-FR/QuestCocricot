package rise.cocricotlite.init;

import net.minecraft.block.Block;
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
        addShapedRecipe(new ItemStack(CBlocks.TAPIOCA, 1, 0), " S ", "WBW", " S ", 'S', Items.SUGAR, 'W', Items.WHEAT, 'B', new ItemStack(Items.POTIONITEM, 1, 0));
        addShapelessRecipe(new ItemStack(CBlocks.TAPIOCA, 1, 0), new ItemStack(CBlocks.TAPIOCA, 1, 4));
        addShapelessRecipe(new ItemStack(CBlocks.TAPIOCA, 1, 1), new ItemStack(CBlocks.TAPIOCA, 1, 0));
        addShapelessRecipe(new ItemStack(CBlocks.TAPIOCA, 1, 2), new ItemStack(CBlocks.TAPIOCA, 1, 1));
        addShapelessRecipe(new ItemStack(CBlocks.TAPIOCA, 1, 3), new ItemStack(CBlocks.TAPIOCA, 1, 2));
        addShapelessRecipe(new ItemStack(CBlocks.TAPIOCA, 1, 4), new ItemStack(CBlocks.TAPIOCA, 1, 3));
        addShapedRecipe(new ItemStack(CBlocks.CHAMPAGNE, 1, 0), "A", "X", 'A', new ItemStack(Items.DYE, 1, 15), 'X', new ItemStack(Items.POTIONITEM, 1, 0));
        addShapelessRecipe(new ItemStack(CBlocks.CHAMPAGNE, 2, 0), new ItemStack(CBlocks.CHAMPAGNE, 1, 1));
        addShapelessRecipe(new ItemStack(CBlocks.CHAMPAGNE, 1, 1), new ItemStack(CBlocks.CHAMPAGNE, 1, 0), new ItemStack(CBlocks.CHAMPAGNE, 1, 0));

        addShapedRecipe(new ItemStack(CBlocks.CHAMPAGNE, 1, 2), "A", "X", 'A', new ItemStack(Items.DYE, 1, 1), 'X', new ItemStack(Items.POTIONITEM, 1, 0));
        addShapelessRecipe(new ItemStack(CBlocks.CHAMPAGNE, 2, 2), new ItemStack(CBlocks.CHAMPAGNE, 1, 3));
        addShapelessRecipe(new ItemStack(CBlocks.CHAMPAGNE, 1, 3), new ItemStack(CBlocks.CHAMPAGNE, 1, 2), new ItemStack(CBlocks.CHAMPAGNE, 1, 2));

    }

    private static int RECIPE_COUNT;

    private static void addShapedRecipe(ItemStack output, Object ... params)
    {
        GameRegistry.addShapedRecipe(new ResourceLocation(CocricotLite.MOD_ID, "cocricotlite_recipe_" + RECIPE_COUNT), new ResourceLocation(CocricotLite.MOD_ID), output, params);
        ++RECIPE_COUNT;
    }

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
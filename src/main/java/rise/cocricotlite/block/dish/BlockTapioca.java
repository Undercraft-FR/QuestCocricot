package rise.cocricotlite.block.dish;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import rise.cocricotlite.Tabs;
import rise.cocricotlite.block.BaseBlock;
import rise.cocricotlite.item.CommonItemBlock;
import rise.cocricotlite.util.AABBList;
import rise.cocricotlite.util.Helper;
import rise.cocricotlite.util.type.EnumTapioca;
import rise.cocricotlite.util.type.PropertyList;

public class BlockTapioca extends BaseBlock {

    public BlockTapioca()
    {
        super("tapioca", Material.GLASS, Tabs.TAB_DISH, SoundType.GLASS, 0.5F, 1F);
        this.setBoundingBox(AABBList.AABB_CUBE_SMALL);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(PropertyList.TAPIOCA_TYPE, EnumTapioca.CAFE_LATTE));
        this.register(new CommonItemBlock(this, itemStack -> EnumTapioca.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, 4, "dish", new String[] { "cafe_latte", "milk_tea", "matcha", "matcha_tea", "strawberry_milk" });
    }

    public int damageDropped(IBlockState state)
    {
        return state.getValue(PropertyList.TAPIOCA_TYPE).getMetadata();
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Item item = Item.getItemFromBlock(this);

        for(int meta = 0; meta < EnumTapioca.values().length; ++meta)
        {
            list.add(new ItemStack(item, 1, meta));
        }
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(PropertyList.TAPIOCA_TYPE, EnumTapioca.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(PropertyList.TAPIOCA_TYPE).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, PropertyList.TAPIOCA_TYPE);
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
}

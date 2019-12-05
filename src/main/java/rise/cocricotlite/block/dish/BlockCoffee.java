package rise.cocricotlite.block.dish;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import rise.cocricotlite.Tabs;
import rise.cocricotlite.block.BaseFacing;
import rise.cocricotlite.item.CommonItemBlock;
import rise.cocricotlite.util.AABBList;
import rise.cocricotlite.util.Helper;
import rise.cocricotlite.util.type.EnumSingleDouble;
import rise.cocricotlite.util.type.PropertyList;

public class BlockCoffee extends BaseFacing {

    public BlockCoffee()
    {
        super("coffee", Material.GLASS, Tabs.TAB_DISH, SoundType.GLASS, 0.5F, 1F);
        this.setBoundingBox(AABBList.AABB_CUBE_SMALL);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(PropertyList.SINGLE_DOUBLE_TYPE, EnumSingleDouble.SINGLE).withProperty(FACING, EnumFacing.NORTH));
        this.register(new CommonItemBlock(this, itemStack -> EnumSingleDouble.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, 1, "dish", new String[] { "coffee_single", "coffee_double" });
    }

    public int damageDropped(IBlockState state)
    {
        return state.getValue(PropertyList.SINGLE_DOUBLE_TYPE).getMetadata();
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Item item = Item.getItemFromBlock(this);

        for(int meta = 0; meta < EnumSingleDouble.values().length; ++meta)
        {
            list.add(new ItemStack(item, 1, meta));
        }
    }

    //保存時にBlockStateを返す
    public IBlockState getStateFromMeta(int meta)
    {
//        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta)).withProperty(PropertyList.SINGLE_DOUBLE_TYPE, EnumSingleDouble.byMetadata(3 + (meta >> 1)));
        return this.getDefaultState().withProperty(PropertyList.SINGLE_DOUBLE_TYPE, EnumSingleDouble.byMetadata(meta));
    }

    //読み込み時にメタデータを返す
    public int getMetaFromState(IBlockState state)
    {
//        //ここの代入の仕方がほんまわからん
//        int i = 0;
//        i = i | state.getValue(FACING).getHorizontalIndex();
//        i = i | state.getValue(PropertyList.SINGLE_DOUBLE_TYPE).getMetadata() + 1 << 1;
//        LogHelper.debugInfoLog(this.getUnlocalizedName() + "Current Meta: " + i);
//        return i;
        return state.getValue(PropertyList.SINGLE_DOUBLE_TYPE).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, PropertyList.SINGLE_DOUBLE_TYPE, FACING);
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

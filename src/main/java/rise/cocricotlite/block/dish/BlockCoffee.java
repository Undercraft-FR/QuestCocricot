package rise.cocricotlite.block.dish;

import net.minecraft.block.BlockPlanks;
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
import sun.reflect.annotation.EnumConstantNotPresentExceptionProxy;

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

    /*
    原木
    4bit で3 => 後ろの数字とってる
    左2bit => XYZの情報 右2bitが原木の種類メタ
    */

    //保存時にBlockStateを返す
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState state = this.getDefaultState().withProperty(PropertyList.SINGLE_DOUBLE_TYPE, EnumSingleDouble.byMetadata((meta & 3)));

        switch (meta & 7)
        {
            case 0:
                state = state.withProperty(FACING, EnumFacing.NORTH);
                break;
            case 2:
                state = state.withProperty(FACING, EnumFacing.SOUTH);
                break;
            case 4:
                state = state.withProperty(FACING, EnumFacing.WEST);
                break;
            case 6:
                state = state.withProperty(FACING, EnumFacing.EAST);
                break;
        }

        return state;
    }

    //読み込み時にメタデータを返す
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | state.getValue(PropertyList.SINGLE_DOUBLE_TYPE).getMetadata();

        switch (state.getValue(FACING))
        {
            case NORTH:
                i |= 0;
                break;
            case SOUTH:
                i |= 2;
                break;
            case WEST:
                i |= 4;
                break;
            case EAST:
                i |= 6;
                break;
        }

        return i;
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

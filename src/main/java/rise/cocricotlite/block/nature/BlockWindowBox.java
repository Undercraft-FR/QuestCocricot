package rise.cocricotlite.block.nature;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import rise.cocricotlite.Tabs;
import rise.cocricotlite.block.BaseFacing;
import rise.cocricotlite.item.CommonItemBlock;
import rise.cocricotlite.util.Helper;
import rise.cocricotlite.util.LogHelper;
import rise.cocricotlite.util.type.EnumWindowBox;
import rise.cocricotlite.util.type.PropertyList;

public class BlockWindowBox extends BaseFacing {

    public BlockWindowBox()
    {
        super("window_box", Material.WOOD, Tabs.TAB_NATURE, SoundType.WOOD, 1.5F, 3F);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(PropertyList.WINDOW_BOX_TYPE, EnumWindowBox.WHITE).withProperty(FACING, EnumFacing.NORTH));
        this.register(new CommonItemBlock(this, itemStack -> EnumWindowBox.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, "nature", EnumWindowBox.class, EnumWindowBox.values().length);
    }

    public int damageDropped(IBlockState state)
    {
        return state.getValue(PropertyList.WINDOW_BOX_TYPE).getMetadata();
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Item item = Item.getItemFromBlock(this);

        for(int meta = 0; meta < EnumWindowBox.values().length; ++meta)
        {
            list.add(new ItemStack(item, 1, meta));
        }
    }

    /** ブロック設置時にbit作る */
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
    {
        int horizontal = placer.getHorizontalFacing().getOpposite().getIndex() - 2;

        LogHelper.debugInfoLog("getStateForPlacement:: " + meta + ", Horizontal Facing: " + horizontal) ;

        meta = meta << 2 + horizontal;
        return super.getStateForPlacement(world, pos, placer.getHorizontalFacing().getOpposite(), hitX, hitY, hitZ, meta, placer, hand);

    }

    /** 保存時にBlockStateにメタを突っ込む */
    public IBlockState getStateFromMeta(int meta)
    {
        LogHelper.debugInfoLog("getStateFromMeta ::  meta:"+ meta);
        IBlockState state = this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 3));

        state = state.withProperty(PropertyList.WINDOW_BOX_TYPE, EnumWindowBox.byMetadata((meta & 12) >> 2));
        LogHelper.debugInfoLog("getStateFromMeta :: " + state);

        return state;
    }

    /** 読み込み時にメタからBlockStateを剥ぎ取る */
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i += state.getValue(FACING).getHorizontalIndex();
        i += state.getValue(PropertyList.WINDOW_BOX_TYPE).getMetadata() << 2;

        LogHelper.debugInfoLog("getMetaFromState " + ":: FACING: " + state.getValue(FACING).getHorizontalIndex() + ", Type: " + state.getValue(PropertyList.WINDOW_BOX_TYPE).getMetadata() + ", Current Meta: " + i);

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, PropertyList.WINDOW_BOX_TYPE, FACING);
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

package rise.cocricotlite.block.interior;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
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
import rise.cocricotlite.util.type.PropertyList;
import rise.cocricotlite.util.type.interior.EnumElectric;

public class BlockElectric extends BaseFacing {

    public BlockElectric()
    {
        super("electric", Material.ROCK, Tabs.TAB_INTERIOR, SoundType.STONE, 3F, 13F);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(PropertyList.ELECTRIC_PROPERTY_ENUM, EnumElectric.CAMERA).withProperty(FACING, EnumFacing.NORTH));
        this.register(new CommonItemBlock(this, itemStack -> EnumElectric.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, "interior", EnumElectric.class, EnumElectric.values().length);
    }

    public int damageDropped(IBlockState state)
    {
        return state.getValue(PropertyList.ELECTRIC_PROPERTY_ENUM).getMetadata();
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Helper.forCreativeTab(this, list, EnumElectric.values().length);
    }

    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
    {
        int horizontal = placer.getHorizontalFacing().getOpposite().getIndex() - 2;
        meta = (meta << 2) + horizontal;

        return super.getStateForPlacement(world, pos, placer.getHorizontalFacing().getOpposite(), hitX, hitY, hitZ, meta, placer, hand);

    }

    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState state = this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 3));
        state = state.withProperty(PropertyList.ELECTRIC_PROPERTY_ENUM, EnumElectric.byMetadata((meta & 12) >> 2));

        return state;
    }

    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i += state.getValue(FACING).getHorizontalIndex();
        i += state.getValue(PropertyList.ELECTRIC_PROPERTY_ENUM).getMetadata() << 2;

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, PropertyList.ELECTRIC_PROPERTY_ENUM, FACING);
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

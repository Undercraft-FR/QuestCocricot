package rise.cocricotlite.block.nature;

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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import rise.cocricotlite.Tabs;
import rise.cocricotlite.block.BaseFacing;
import rise.cocricotlite.item.CommonItemBlock;
import rise.cocricotlite.util.AABBList;
import rise.cocricotlite.util.Helper;
import rise.cocricotlite.util.type.nature.EnumWallLeaves;
import rise.cocricotlite.util.type.PropertyList;

public class BlockWallLeaves extends BaseFacing {

    public BlockWallLeaves()
    {
        super("wall_leaves", Material.GRASS, Tabs.TAB_NATURE, SoundType.PLANT, 0.2F, 1F);
        this.setCollisionBox(AABBList.AABB_NONE);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(PropertyList.WALL_LEAVES_TYPE, EnumWallLeaves.CLIMBING).withProperty(FACING, EnumFacing.NORTH));
        this.register(new CommonItemBlock(this, itemStack -> EnumWallLeaves.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, "nature", EnumWallLeaves.class, EnumWallLeaves.values().length);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        AxisAlignedBB aabb;

        switch (state.getValue(FACING))
        {
            case NORTH:
            default:
                aabb = new AxisAlignedBB(0.0D, 1.0D, 0.5D, 1.0D, 0.0D, 1.0D);
                break;
            case SOUTH:
                aabb = new AxisAlignedBB(0.0D, 1.0D, 0.0D, 1.0D, 0.0D, 0.5D);
                break;
            case WEST:
                aabb = new AxisAlignedBB(0.5D, 1.0D, 0.0D, 1.0D, 0.0D, 1.0D);
                break;
            case EAST:
                aabb = new AxisAlignedBB(0.0D, 1.0D, 0.0D, 0.5D, 0.0D, 1.0D);
        }

        return aabb;
    }

    public int damageDropped(IBlockState state)
    {
        return state.getValue(PropertyList.WALL_LEAVES_TYPE).getMetadata();
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Helper.forCreativeTab(this, list, EnumWallLeaves.values().length);
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
        state = state.withProperty(PropertyList.WALL_LEAVES_TYPE, EnumWallLeaves.byMetadata((meta & 12) >> 2));

        return state;
    }

    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i += state.getValue(FACING).getHorizontalIndex();
        i += state.getValue(PropertyList.WALL_LEAVES_TYPE).getMetadata() << 2;

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, PropertyList.WALL_LEAVES_TYPE, FACING);
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

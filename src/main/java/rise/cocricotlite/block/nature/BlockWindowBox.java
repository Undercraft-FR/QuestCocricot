package rise.cocricotlite.block.nature;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import rise.cocricotlite.Tabs;
import rise.cocricotlite.block.BaseFacingTile;
import rise.cocricotlite.item.CommonItemBlock;
import rise.cocricotlite.tileentity.TileEntityWindoxBox;
import rise.cocricotlite.util.Helper;
import rise.cocricotlite.util.type.EnumWindowBox;
import rise.cocricotlite.util.type.PropertyList;

import javax.annotation.Nullable;

public class BlockWindowBox extends BaseFacingTile {

    public BlockWindowBox()
    {
        super("window_box", Material.WOOD, Tabs.TAB_NATURE, SoundType.WOOD, 1.5F, 3F);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.register(new CommonItemBlock(this, itemStack -> EnumWindowBox.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, "nature", EnumWindowBox.class, EnumWindowBox.values().length);
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Helper.forCreativeTab(this, list, EnumWindowBox.values().length);
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

    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        TileEntity tile = world.getTileEntity(pos);

        if(tile instanceof TileEntityWindoxBox)
        {
            return state.withProperty(PropertyList.WINDOW_BOX_TYPE, ((TileEntityWindoxBox) tile).getType());
        }

        return state;
    }

    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity tileEntity, ItemStack stack)
    {
        if(tileEntity instanceof TileEntityWindoxBox)
        {
            TileEntityWindoxBox tile = (TileEntityWindoxBox) tileEntity;
            ItemStack itemStack = new ItemStack(this, 1, tile.getType().getMetadata());
            spawnAsEntity(worldIn, pos, itemStack);
        }
        else
        {
            super.harvestBlock(worldIn, player, pos, state, tileEntity, stack);
        }
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        TileEntity tile = worldIn.getTileEntity(pos);

        if(tile instanceof TileEntityWindoxBox)
        {
            ((TileEntityWindoxBox) tile).setType(EnumWindowBox.byMetadata(stack.getMetadata()));
        }
    }

    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityWindoxBox();
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

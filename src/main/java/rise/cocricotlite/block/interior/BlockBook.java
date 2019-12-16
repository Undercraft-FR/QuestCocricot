package rise.cocricotlite.block.interior;

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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import rise.cocricotlite.Tabs;
import rise.cocricotlite.block.BaseFacingTile;
import rise.cocricotlite.item.CommonItemBlock;
import rise.cocricotlite.tileentity.TileEntityBook;
import rise.cocricotlite.util.AABBList;
import rise.cocricotlite.util.Helper;
import rise.cocricotlite.util.type.PropertyList;
import rise.cocricotlite.util.type.interior.EnumBook;

import javax.annotation.Nullable;

public class BlockBook extends BaseFacingTile {

    public BlockBook()
    {
        super("book", Material.WOOD, Tabs.TAB_INTERIOR, SoundType.WOOD, 1.5F, 5F, TileEntityBook.class);
        this.setBoundingBox(AABBList.AABB_CUBE_SMALL);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.register(new CommonItemBlock(this, itemStack -> EnumBook.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, "interior", EnumBook.class, EnumBook.values().length);
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Helper.forCreativeTab(this, list, EnumBook.values().length);
    }

    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        TileEntity tile = world.getTileEntity(pos);

        if(tile instanceof TileEntityBook)
        {
            return state.withProperty(PropertyList.BOOK_PROPERTY_ENUM, ((TileEntityBook) tile).getType());
        }

        return state;
    }

    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity tileEntity, ItemStack stack)
    {
        if(tileEntity instanceof TileEntityBook)
        {
            TileEntityBook tile = (TileEntityBook) tileEntity;
            ItemStack itemStack = new ItemStack(this, 1, tile.getType().getMetadata());
            spawnAsEntity(world, pos, itemStack);
        }
        else
        {
            super.harvestBlock(world, player, pos, state, tileEntity, stack);
        }
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        TileEntity tile = worldIn.getTileEntity(pos);

        if(tile instanceof TileEntityBook)
        {
            ((TileEntityBook) tile).setType(EnumBook.byMetadata(stack.getMetadata()));
        }
    }

    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityBook();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, PropertyList.BOOK_PROPERTY_ENUM, FACING);
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

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
import rise.cocricotlite.tileentity.TileEntityClassic;
import rise.cocricotlite.util.Helper;
import rise.cocricotlite.util.type.PropertyList;
import rise.cocricotlite.util.type.interior.EnumClassic;

public class BlockClassic extends BaseFacingTile {

    public BlockClassic()
    {
        super("classic", Material.WOOD, Tabs.TAB_INTERIOR, SoundType.WOOD, 3F, 20F, TileEntityClassic.class);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.register(new CommonItemBlock(this, itemStack -> EnumClassic.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, "interior", EnumClassic.class, EnumClassic.values().length);
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Helper.forCreativeTab(this, list, EnumClassic.values().length);
    }

    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        TileEntity tile = world.getTileEntity(pos);

        if(tile instanceof TileEntityClassic)
        {
            return state.withProperty(PropertyList.CLASSIC_PROPERTY_ENUM, ((TileEntityClassic) tile).getType());
        }

        return state;
    }

    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity tileEntity, ItemStack stack)
    {
        if(tileEntity instanceof TileEntityClassic)
        {
            TileEntityClassic tile = (TileEntityClassic) tileEntity;
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

        if(tile instanceof TileEntityClassic)
        {
            ((TileEntityClassic) tile).setType(EnumClassic.byMetadata(stack.getMetadata()));
        }
    }

    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityClassic();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, PropertyList.CLASSIC_PROPERTY_ENUM, FACING);
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

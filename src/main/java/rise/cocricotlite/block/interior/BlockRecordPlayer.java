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
import rise.cocricotlite.tileentity.TileEntityRecordPlayer;
import rise.cocricotlite.util.Helper;
import rise.cocricotlite.util.type.PropertyList;
import rise.cocricotlite.util.type.interior.EnumRecordPlayer;

public class BlockRecordPlayer extends BaseFacingTile {

    public BlockRecordPlayer()
    {
        super("record_player", Material.WOOD, Tabs.TAB_INTERIOR, SoundType.WOOD, 2F, 15F, TileEntityRecordPlayer.class);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.register(new CommonItemBlock(this, itemStack -> EnumRecordPlayer.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, "interior", EnumRecordPlayer.class, EnumRecordPlayer.values().length);
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Helper.forCreativeTab(this, list, EnumRecordPlayer.values().length);
    }

    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        TileEntity tile = world.getTileEntity(pos);

        if(tile instanceof TileEntityRecordPlayer)
        {
            return state.withProperty(PropertyList.RECORD_PLAYER_PROPERTY_ENUM, ((TileEntityRecordPlayer) tile).getType());
        }

        return state;
    }

    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity tileEntity, ItemStack stack)
    {
        if(tileEntity instanceof TileEntityRecordPlayer)
        {
            TileEntityRecordPlayer tile = (TileEntityRecordPlayer) tileEntity;
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

        if(tile instanceof TileEntityRecordPlayer)
        {
            ((TileEntityRecordPlayer) tile).setType(EnumRecordPlayer.byMetadata(stack.getMetadata()));
        }
    }

    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityRecordPlayer();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, PropertyList.RECORD_PLAYER_PROPERTY_ENUM, FACING);
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
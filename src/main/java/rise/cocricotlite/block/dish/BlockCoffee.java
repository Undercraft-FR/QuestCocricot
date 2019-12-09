package rise.cocricotlite.block.dish;

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
import rise.cocricotlite.util.AABBList;
import rise.cocricotlite.util.Helper;
import rise.cocricotlite.util.type.EnumSingleDouble;
import rise.cocricotlite.util.type.PropertyList;

public class BlockCoffee extends BaseFacing
{

    public BlockCoffee()
    {
        super("coffee", Material.GLASS, Tabs.TAB_DISH, SoundType.GLASS, 0.5F, 1F);
        this.setBoundingBox(AABBList.AABB_CUBE_SMALL);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(PropertyList.SINGLE_DOUBLE_TYPE, EnumSingleDouble.SINGLE).withProperty(FACING, EnumFacing.NORTH));
        this.register(new CommonItemBlock(this, itemStack -> EnumSingleDouble.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
    {
        int horizontal = placer.getHorizontalFacing().getOpposite().getIndex() - 2;
        meta = meta * 4 + horizontal;
        return super.getStateForPlacement(world, pos, placer.getHorizontalFacing().getOpposite(), hitX, hitY, hitZ, meta, placer, hand);
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, "dish", EnumSingleDouble.class, EnumSingleDouble.values().length);
    }

    public int damageDropped(IBlockState state)
    {
        return state.getValue(PropertyList.SINGLE_DOUBLE_TYPE).getMetadata();
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Helper.forCreativeTab(this, list, EnumSingleDouble.values().length);

    }

    //ブロックに与えられたメタが帰ってくる(0~7 getStateForPlacement)
    //3bit: 右2つfacing値(FACINGはNEWSで4つ => 2bitで表せる) 左がenum(single,doubleで2つ =>1bitでいける)
    public IBlockState getStateFromMeta(int meta)
    {
        //右2bit(ex:001 => meta & 3 001と011のAND =>> 001 <<= FACINGの値
        //ex: 101と011 のAND =>> 001
        //AND: どちらも1(true)の時に1(true)が帰ってくる
        IBlockState iBlockState = this.getDefaultState().withProperty(FACING,EnumFacing.getHorizontal(meta & 3));

        // 101(double, facing:1) と 4(3bit 100)でANDとる 100 => 4帰ってくる => 4でわる => 1 = enumは1 == double
        // 001(single, facing;1) と 4(3bit 100)でAND 000 => 0が帰ってくる => 4でわって => 0 = enumは0 == single
        iBlockState = iBlockState.withProperty(PropertyList.SINGLE_DOUBLE_TYPE,EnumSingleDouble.byMetadata((meta & 4) / 4));

        return iBlockState;
    }

    //getStateFromMetaの真逆やってる
    public int getMetaFromState(IBlockState state)
    {
        int meta = 0;
        meta += state.getValue(FACING).getHorizontalIndex(); //0,1,2,3

        //3bitで3ケタめに置きたい
        //なんで4かけんの？ => シフト演算(1をずらす演算)で "meta << 2" は "meta * 4"と同じ値が出る
        meta += state.getValue(PropertyList.SINGLE_DOUBLE_TYPE).getMetadata() * 4; // 0, 4

        return meta;
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

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
import rise.cocricotlite.util.type.EnumBreakfast;
import rise.cocricotlite.util.type.PropertyList;

public class BlockBreakfast extends BaseFacing {

    public BlockBreakfast()
    {
        super("breakfast", Material.WOOD, Tabs.TAB_DISH, SoundType.WOOD, 0.5F, 1F);
        this.setBoundingBox(AABBList.AABB_CUBE_SMALL);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(PropertyList.BREAKFAST_TYPE, EnumBreakfast.TOAST).withProperty(FACING, EnumFacing.NORTH));
        this.register(new CommonItemBlock(this, itemStack -> EnumBreakfast.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, "dish", EnumBreakfast.class, EnumBreakfast.values().length);
    }

    public int damageDropped(IBlockState state)
    {
        return state.getValue(PropertyList.BREAKFAST_TYPE).getMetadata();
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Helper.forCreativeTab(this, list, EnumBreakfast.values().length);

    }
    /** ブロック設置時にbit作る */
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
    {
        int horizontal = placer.getHorizontalFacing().getOpposite().getIndex() - 2;
        //3bit 3ケタ目にEnum判定
        //シフト演算: "<< 2"は左に2つ移動
        meta = meta * 4 + horizontal;
        return super.getStateForPlacement(world, pos, placer.getHorizontalFacing().getOpposite(), hitX, hitY, hitZ, meta, placer, hand);

    }

    /** 保存時にBlockStateにメタを突っ込む */
    public IBlockState getStateFromMeta(int meta)
    {
        //ビット演算: ここでFACINGはNEWSの4つ = 0～3の値 → 3のAND(2bit)をとる
        IBlockState state = this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 3));

        //ビット演算: ブロックに保持されたmetaは3bitなので、３桁目を取りたい = 4のAND(3bit)をとればいい
        //シフト演算: Enumのmetaをもらいたいので、getStateForPlacement()でずらしたのを戻す
        state = state.withProperty(PropertyList.BREAKFAST_TYPE, EnumBreakfast.byMetadata((meta & 4) / 4));

        return state;
    }

    /** 読み込み時にメタからBlockStateを剥ぎ取る */
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i += state.getValue(FACING).getHorizontalIndex();

        //シフト演算: 3bitより3桁目の値にEnumの値をセットしたい → 左に2移動させる
        i += state.getValue(PropertyList.BREAKFAST_TYPE).getMetadata() * 4;

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, PropertyList.BREAKFAST_TYPE, FACING);
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

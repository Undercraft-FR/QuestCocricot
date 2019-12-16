package rise.cocricotlite.block.interior;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import rise.cocricotlite.Tabs;
import rise.cocricotlite.block.BaseBlock;
import rise.cocricotlite.item.CommonItemBlock;
import rise.cocricotlite.util.AABBList;
import rise.cocricotlite.util.Helper;
import rise.cocricotlite.util.type.PropertyList;
import rise.cocricotlite.util.type.interior.EnumSample;

public class BlockSample extends BaseBlock {

    public BlockSample()
    {
        super("sample", Material.GLASS, Tabs.TAB_INTERIOR, SoundType.GLASS, 0.8F, 0.5F);
        this.setBoundingBox(AABBList.AABB_CUBE_SMALL);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(PropertyList.SAMPLE_PROPERTY_ENUM, EnumSample.COOKIE));
        this.register(new CommonItemBlock(this, itemStack -> EnumSample.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, "interior", EnumSample.class, EnumSample.values().length);
    }

    public int damageDropped(IBlockState state)
    {
        return state.getValue(PropertyList.SAMPLE_PROPERTY_ENUM).getMetadata();
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Helper.forCreativeTab(this, list, EnumSample.values().length);

    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(PropertyList.SAMPLE_PROPERTY_ENUM, EnumSample.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(PropertyList.SAMPLE_PROPERTY_ENUM).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, PropertyList.SAMPLE_PROPERTY_ENUM);
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
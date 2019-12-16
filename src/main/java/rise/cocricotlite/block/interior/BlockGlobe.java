package rise.cocricotlite.block.interior;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import rise.cocricotlite.Tabs;
import rise.cocricotlite.block.BaseBlock;
import rise.cocricotlite.item.CommonItemBlock;
import rise.cocricotlite.util.AABBList;
import rise.cocricotlite.util.Helper;
import rise.cocricotlite.util.type.PropertyList;
import rise.cocricotlite.util.type.interior.EnumGlobe;

public class BlockGlobe extends BaseBlock {

    public BlockGlobe()
    {
        super("globe", Material.WOOD, Tabs.TAB_INTERIOR, SoundType.WOOD, 2F, 9F);
        this.setBoundingBox(AABBList.AABB_CUBE_SMALL);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(PropertyList.GLOBE_PROPERTY_ENUM, EnumGlobe.WHITE));
        this.register(new CommonItemBlock(this, itemStack -> EnumGlobe.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, "interior", EnumGlobe.class, EnumGlobe.values().length);
    }

    public int damageDropped(IBlockState state)
    {
        return state.getValue(PropertyList.GLOBE_PROPERTY_ENUM).getMetadata();
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Helper.forCreativeTab(this, list, EnumGlobe.values().length);

    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(PropertyList.GLOBE_PROPERTY_ENUM, EnumGlobe.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(PropertyList.GLOBE_PROPERTY_ENUM).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, PropertyList.GLOBE_PROPERTY_ENUM);
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

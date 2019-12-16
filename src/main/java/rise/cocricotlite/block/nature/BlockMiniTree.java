package rise.cocricotlite.block.nature;

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
import rise.cocricotlite.util.type.nature.EnumMiniTree;
import rise.cocricotlite.util.type.PropertyList;

public class BlockMiniTree extends BaseBlock {

    public BlockMiniTree()
    {
        super("mini_tree", Material.GRASS, Tabs.TAB_NATURE, SoundType.PLANT, 0.2F, 1F);
        this.setCollisionBox(AABBList.AABB_NONE);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(PropertyList.MINI_TREE_TYPE, EnumMiniTree.LIMP));
        this.register(new CommonItemBlock(this, itemStack -> EnumMiniTree.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, "nature", EnumMiniTree.class, EnumMiniTree.values().length);
    }

    public int damageDropped(IBlockState state)
    {
        return state.getValue(PropertyList.MINI_TREE_TYPE).getMetadata();
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Helper.forCreativeTab(this, list, EnumMiniTree.values().length);

    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(PropertyList.MINI_TREE_TYPE, EnumMiniTree.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(PropertyList.MINI_TREE_TYPE).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, PropertyList.MINI_TREE_TYPE);
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
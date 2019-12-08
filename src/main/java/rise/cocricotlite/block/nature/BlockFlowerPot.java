package rise.cocricotlite.block.nature;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import rise.cocricotlite.Tabs;
import rise.cocricotlite.block.BaseBlock;
import rise.cocricotlite.item.CommonItemBlock;
import rise.cocricotlite.util.AABBList;
import rise.cocricotlite.util.Helper;
import rise.cocricotlite.util.type.EnumFlowerPot;
import rise.cocricotlite.util.type.PropertyList;

public class BlockFlowerPot extends BaseBlock {

    public BlockFlowerPot(String name)
    {
        super(name, Material.ROCK, Tabs.TAB_NATURE, SoundType.STONE, 0.15F, 1F);
        this.setBoundingBox(AABBList.AABB_CUBE_SMALL);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(PropertyList.FLOWER_POT_PROPERTY_TYPE, EnumFlowerPot.WHITE));
        this.register(new CommonItemBlock(this, itemStack -> EnumFlowerPot.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, 6, "nature", new String[]{ "white", "light_brown", "brown", "dark_orange", "black", "basket_light", "basket" });
    }

    public int damageDropped(IBlockState state)
    {
        return state.getValue(PropertyList.FLOWER_POT_PROPERTY_TYPE).getMetadata();
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Item item = Item.getItemFromBlock(this);

        for (int meta = 0; meta < EnumFlowerPot.values().length; ++meta)
        {
            list.add(new ItemStack(item, 1, meta));
        }
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(PropertyList.FLOWER_POT_PROPERTY_TYPE, EnumFlowerPot.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(PropertyList.FLOWER_POT_PROPERTY_TYPE).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, PropertyList.FLOWER_POT_PROPERTY_TYPE);
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
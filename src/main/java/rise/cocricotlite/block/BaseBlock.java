package rise.cocricotlite.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rise.cocricotlite.CocricotLite;
import rise.cocricotlite.util.AABBList;
import rise.cocricotlite.util.Helper;
import rise.cocricotlite.util.IContent;

public class BaseBlock extends Block implements IContent {

    private AxisAlignedBB boundingBox = AABBList.AABB_FULL;

    public BaseBlock(String name, Material material, CreativeTabs tab, SoundType sound, float hardness, float resistance)
    {
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(CocricotLite.MOD_ID, name);
        this.setCreativeTab(tab);
        this.setSoundType(sound);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    public BaseBlock register(ItemBlock itemBlock)
    {
        Helper.registerBlock(this, itemBlock);
        return this;
    }

    public BaseBlock register()
    {
        Helper.registerBlock(this);
        return this;
    }

    @Override
    public void registerModels()
    {
        CocricotLite.proxy.registerItemModel(Item.getItemFromBlock(this), 0);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    public BaseBlock setBoundingBox(AxisAlignedBB aabb)
    {
        this.boundingBox = aabb;
        return this;
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return this.boundingBox;
    }
}

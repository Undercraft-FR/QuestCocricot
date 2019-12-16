package rise.cocricotlite.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import rise.cocricotlite.util.Helper;

public abstract class BaseFacingTile extends BaseFacing implements ITileEntityProvider {

    public BaseFacingTile(String name, Material material, CreativeTabs tab, SoundType sound, float hardness, float resistance, Class<? extends TileEntity> cls)
    {
        super(name, material, tab, sound, hardness, resistance);
        this.hasTileEntity = true;
        Helper.registerTileEntity(cls, name);
    }

    @Override
    public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int id, int param)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity != null && tileentity.receiveClientEvent(id, param);
    }
}

package rise.cocricotlite.block.nature;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import rise.cocricotlite.Tabs;
import rise.cocricotlite.block.BaseFacing;
import rise.cocricotlite.util.Helper;

public class BlockWallLeaves extends BaseFacing {

    public BlockWallLeaves()
    {
        super("wall_leaves", Material.GRASS, Tabs.TAB_NATURE, SoundType.PLANT, 0.2F, 1F);
//        this.setDefaultState(this.getBlockState().getBaseState().withProperty(proper));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, 2, "nature", new String[] { "climbing", "ivy_up", "ivy_down" });
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        AxisAlignedBB aabb;

        switch (state.getValue(FACING))
        {
            case NORTH:
            default:
                aabb = new AxisAlignedBB(0.0D, 1.0D, 0.5D, 1.0D, 0.0D, 1.0D);
                break;
            case SOUTH:
                aabb = new AxisAlignedBB(0.0D, 1.0D, 0.0D, 1.0D, 0.0D, 0.5D);
                break;
            case WEST:
                aabb = new AxisAlignedBB(0.5D, 1.0D, 0.0D, 1.0D, 0.0D, 1.0D);
                break;
            case EAST:
                aabb = new AxisAlignedBB(0.0D, 1.0D, 0.0D, 0.5D, 0.0D, 1.0D);
        }

        return aabb;
    }
}

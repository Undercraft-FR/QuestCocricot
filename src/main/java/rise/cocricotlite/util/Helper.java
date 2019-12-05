package rise.cocricotlite.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import rise.cocricotlite.CocricotLite;

import javax.annotation.Nullable;
import java.util.Objects;

public class Helper {

    public static void registerBlock(Block block)
    {
        registerBlock(block, new ItemBlock(block));
    }

    public static void registerBlock(Block block, ItemBlock itemBlock)
    {
        if(block == null)
            return;

        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName())));

        if(block instanceof IContent )
        {
            ((IContent) block).registerModels();
        }
    }

    public static void registerItem(Item item)
    {
        if(item == null)
            return;

        ForgeRegistries.ITEMS.register(item);

        if(item instanceof IContent)
        {
            ((IContent) item).registerModels();
        }
    }

    /**
     * メタの分だけアイテムのモデルを追加する処理を繰り返す。
     * @param block ブロック
     * @param maxMeta 最大メタ値(個数ではない! 最高15まで)
     * @param category モデルが格納されたフォルダパス
     * @param typeName メタごとに振り分けられた名前
     */
    public static void forItemModels(Block block, int maxMeta, String category, String[] typeName)
    {
        for(int i = 0; i < maxMeta + 1; ++i)
        {
            CocricotLite.proxy.registerItemModel(Item.getItemFromBlock(block), i, new ModelResourceLocation("cocricotlite:" + category + "/" + typeName[i], "inventory"));
        }
    }

    public static void updateBlock(@Nullable World world, BlockPos pos)
    {
        if(world != null)
        {
            IBlockState state = world.getBlockState(pos);
            world.notifyBlockUpdate(pos, state, state, 1 | 2);
        }
    }
}

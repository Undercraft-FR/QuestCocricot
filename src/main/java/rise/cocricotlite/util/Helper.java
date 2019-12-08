package rise.cocricotlite.util;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import rise.cocricotlite.CocricotLite;

import java.util.Arrays;
import java.util.Objects;

public class Helper {

    /**
     * ブロックを登録する
     * @param block ブロック
     */
    public static void registerBlock(Block block)
    {
        registerBlock(block, new ItemBlock(block));
    }

    /**
     * ブロックを登録する メタを持つ場合はこちらを使う
     * @param block ブロック
     * @param itemBlock アイテムブロック
     */
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

    /**
     * アイテムを追加する
     * @param item アイテム
     */
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
    @Deprecated
    public static void forItemModels(Block block, int maxMeta, String category, String[] typeName)
    {
        for(int i = 0; i < maxMeta + 1; ++i)
        {
            CocricotLite.proxy.registerItemModel(Item.getItemFromBlock(block), i, new ModelResourceLocation("cocricotlite:" + category + "/" + block.getUnlocalizedName().substring(5) + "_" + typeName[i], "inventory"));
        }
    }

    /**
     * 指定したenumの数だけアイテムのモデルを追加する処理を繰り返す。
     * @param block ブロック
     * @param category モデルが格納されたフォルダパス
     * @param target 使いたいenum
     * @param maxMeta 最大メタ値(<E>.values().lengthで取得するのが基本)
     * @param <E> IMetadataとIStringSerializableを継承したenumクラス
     */
    public static <E extends Enum & IMetadata & IStringSerializable> void forItemModels(Block block, String category, Class<E> target, int maxMeta)
    {
        for(int i = 0; i < maxMeta; ++i)
        {
            String name = valueOf(target, i).getName();
            CocricotLite.proxy.registerItemModel(Item.getItemFromBlock(block), i, new ModelResourceLocation("cocricotlite:" + category + "/" + block.getUnlocalizedName().substring(5) + "_" + name, "inventory"));
        }
    }

    /**
     * 指定したenumから値を逆引きする
     * @param target 使いたいenum
     * @param meta 値を取得するためのメタ
     * @param <E> IMetadataを継承したenumクラス
     * @return 各種パラメータを追加したenum
     */
    private static <E extends Enum & IMetadata> E valueOf(Class<E> target, int meta) {

        return Arrays.stream(target.getEnumConstants())
                .filter(data -> data.getMetadata() == meta)
                .findFirst()
                .orElse(null);
    }
}

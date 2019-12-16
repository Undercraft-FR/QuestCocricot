package rise.cocricotlite.util.type.interior;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumRecordPlayer implements IStringSerializable, IMetadata {

    WOOD_CLEAR(0, "wood_clear"),
    WOOD_NATURE(1, "wood_nature"),
    WOOD_ANTIQUE(2, "wood_antique"),
    WOOD_DARK(3, "wood_dark"),
    WHITE(4, "white"),
    PINK(5, "pink"),
    RED(6, "red"),
    BROWN(7, "brown"),
    YELLOW(8, "yellow"),
    GREEN(9, "green"),
    MINT(10, "mint"),
    BLACK(11, "black"),
    GRAMOPHONE(12, "gramophone");


    private static final EnumRecordPlayer[] META_LOOKUP = new EnumRecordPlayer[values().length];
    private final int meta;
    private final String name;

    EnumRecordPlayer(int meta, String name)
    {
        this.meta = meta;
        this.name = name;
    }

    public int getMetadata()
    {
        return this.meta;
    }

    public String toString()
    {
        return this.name;
    }

    public static EnumRecordPlayer byMetadata(int meta)
    {
        if(meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public String getName()
    {
        return this.name;
    }

    static
    {
        EnumRecordPlayer[] var = values();

        for(EnumRecordPlayer type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
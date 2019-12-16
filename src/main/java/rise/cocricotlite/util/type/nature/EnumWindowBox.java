package rise.cocricotlite.util.type.nature;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumWindowBox implements IStringSerializable, IMetadata {

    WHITE(0, "white"),
    SEA_DRIFT(1, "sea_drift"),
    NATURAL(2, "natural"),
    BROWN(3, "brown"),
    DARK(4, "dark");

    private static final EnumWindowBox[] META_LOOKUP = new EnumWindowBox[values().length];
    private final int meta;
    private final String name;

    EnumWindowBox(int meta, String name)
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

    public static EnumWindowBox byMetadata(int meta)
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
        EnumWindowBox[] var = values();

        for(EnumWindowBox type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
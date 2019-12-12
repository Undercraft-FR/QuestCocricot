package rise.cocricotlite.util.type;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumWindowBoxOld implements IStringSerializable, IMetadata {

    WHITE(0, "white"),
    SEA_DRIFT(1, "sea_drift"),
    NATURAL(2, "natural"),
    BROWN(3, "brown");
//    DARK(4, "dark");

    private static final EnumWindowBoxOld[] META_LOOKUP = new EnumWindowBoxOld[values().length];
    private final int meta;
    private final String name;

    EnumWindowBoxOld(int meta, String name)
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

    public static EnumWindowBoxOld byMetadata(int meta)
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
        EnumWindowBoxOld[] var = values();

        for(EnumWindowBoxOld type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
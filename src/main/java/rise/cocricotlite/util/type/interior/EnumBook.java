package rise.cocricotlite.util.type.interior;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumBook implements IStringSerializable, IMetadata {

    MODERN(0, "modern"),
    ANTIQUE(1, "antique"),
    OPEN_MODERN(2, "open_modern"),
    OPEN_ANTIQUE(3, "open_antique"),
    LINE_MODERN(4, "line_modern"),
    LINE_ANTIQUE(5, "line_antique");

    private static final EnumBook[] META_LOOKUP = new EnumBook[values().length];
    private final int meta;
    private final String name;

    EnumBook(int meta, String name)
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

    public static EnumBook byMetadata(int meta)
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
        EnumBook[] var = values();

        for(EnumBook type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
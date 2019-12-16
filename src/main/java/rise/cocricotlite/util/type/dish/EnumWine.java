package rise.cocricotlite.util.type.dish;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumWine implements IStringSerializable, IMetadata {

    RED_SINGLE(0, "red_single"),
    RED_DOUBLE(1, "red_double"),
    WHITE_SINGLE(2, "white_single"),
    WHITE_DOUBLE(3, "white_double"),
    BOTTLE(4, "bottle");

    private static final EnumWine[] META_LOOKUP = new EnumWine[values().length];
    private final int meta;
    private final String name;

    EnumWine(int meta, String name)
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

    public static EnumWine byMetadata(int meta)
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
        EnumWine[] var = values();

        for(EnumWine type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}

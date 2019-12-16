package rise.cocricotlite.util.type.dish;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumSingleDouble implements IStringSerializable, IMetadata {

    SINGLE(0, "single"),
    DOUBLE(1, "double");

    private static final EnumSingleDouble[] META_LOOKUP = new EnumSingleDouble[values().length];
    private final int meta;
    private final String name;

    EnumSingleDouble(int meta, String name)
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

    public static EnumSingleDouble byMetadata(int meta)
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
        EnumSingleDouble[] var = values();

        for(EnumSingleDouble type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}

package rise.cocricotlite.util.type.dish;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumChampagne implements IStringSerializable, IMetadata {

    SINGLE(0, "single"),
    DOUBLE(1, "double"),
    ROSE_SINGLE(2, "rose_single"),
    ROSE_DOUBLE(3, "rose_double");

    private static final EnumChampagne[] META_LOOKUP = new EnumChampagne[values().length];
    private final int meta;
    private final String name;

    EnumChampagne(int meta, String name)
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

    public static EnumChampagne byMetadata(int meta)
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
        EnumChampagne[] var = values();

        for(EnumChampagne type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
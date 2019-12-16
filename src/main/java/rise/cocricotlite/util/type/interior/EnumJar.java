package rise.cocricotlite.util.type.interior;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumJar implements IStringSerializable, IMetadata {

    WHITE(0, "white"),
    RED(1, "red"),
    BROWN(2, "brown"),
    YELLOW(3, "yellow");

    private static final EnumJar[] META_LOOKUP = new EnumJar[values().length];
    private final int meta;
    private final String name;

    EnumJar(int meta, String name)
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

    public static EnumJar byMetadata(int meta)
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
        EnumJar[] var = values();

        for(EnumJar type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
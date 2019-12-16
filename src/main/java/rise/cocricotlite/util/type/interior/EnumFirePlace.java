package rise.cocricotlite.util.type.interior;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumFirePlace implements IStringSerializable, IMetadata {

    WHITE(0, "white"),
    GRAY(1, "gray"),
    BROWN(2, "brown"),
    BLACK(3, "black");

    private static final EnumFirePlace[] META_LOOKUP = new EnumFirePlace[values().length];
    private final int meta;
    private final String name;

    EnumFirePlace(int meta, String name)
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

    public static EnumFirePlace byMetadata(int meta)
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
        EnumFirePlace[] var = values();

        for(EnumFirePlace type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
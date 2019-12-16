package rise.cocricotlite.util.type.interior;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumTelephone implements IStringSerializable, IMetadata {

    PINK(0, "pink"),
    RED(1, "red"),
    YELLOW(2, "yellow"),
    MINT(3, "mint"),
    BLACK(4, "black");

    private static final EnumTelephone[] META_LOOKUP = new EnumTelephone[values().length];
    private final int meta;
    private final String name;

    EnumTelephone(int meta, String name)
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

    public static EnumTelephone byMetadata(int meta)
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
        EnumTelephone[] var = values();

        for(EnumTelephone type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
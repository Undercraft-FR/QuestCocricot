package rise.cocricotlite.util.type.dish;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumBreakfast implements IStringSerializable, IMetadata {

    TOAST(0, "toast"),
    CROISSANT(1, "croissant");

    private static final EnumBreakfast[] META_LOOKUP = new EnumBreakfast[values().length];
    private final int meta;
    private final String name;

    EnumBreakfast(int meta, String name)
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

    public static EnumBreakfast byMetadata(int meta)
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
        EnumBreakfast[] var = values();

        for(EnumBreakfast type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}

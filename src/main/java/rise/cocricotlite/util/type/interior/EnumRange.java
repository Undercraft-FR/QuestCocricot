package rise.cocricotlite.util.type.interior;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumRange implements IStringSerializable, IMetadata {

    SILVER(0, "silver"),
    WHITE(1, "white"),
    PINK(2, "pink"),
    RED(3, "red"),
    BROWN(4, "brown"),
    LIGHT_BROWN(5, "light_brown"),
    YELLOW(6, "yellow"),
    MINT(7, "mint"),
    LIGHT_GREEN(8, "light_green"),
    GREEN(9, "green"),
    BLUE(10, "blue"),
    BLACK(11, "black"),
    RANGE_HOOD(12, "range_hood"),
    RANGE_PLATE(13, "range_plate");

    private static final EnumRange[] META_LOOKUP = new EnumRange[values().length];
    private final int meta;
    private final String name;

    EnumRange(int meta, String name)
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

    public static EnumRange byMetadata(int meta)
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
        EnumRange[] var = values();

        for(EnumRange type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}

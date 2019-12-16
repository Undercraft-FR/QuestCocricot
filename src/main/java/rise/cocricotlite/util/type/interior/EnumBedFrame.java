package rise.cocricotlite.util.type.interior;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumBedFrame implements IStringSerializable, IMetadata {

    WHITE_WOOD(0, "white_wood"),
    CLEAR_WOOD(1, "clear_wood"),
    NATURAL_WOOD(2, "natural_wood"),
    BROWN_WOOD(3, "brown_wood"),
    DARK_WOOD(4, "dark_wood"),
    IRON_FRAME(5, "iron_frame"),
    WHITE_FRAME(6, "white_frame");

    private static final EnumBedFrame[] META_LOOKUP = new EnumBedFrame[values().length];
    private final int meta;
    private final String name;

    EnumBedFrame(int meta, String name)
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

    public static EnumBedFrame byMetadata(int meta)
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
        EnumBedFrame[] var = values();

        for(EnumBedFrame type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
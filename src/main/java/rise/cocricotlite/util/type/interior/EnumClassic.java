package rise.cocricotlite.util.type.interior;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumClassic implements IStringSerializable, IMetadata {

    WHITE_PIANO(0, "white_piano"),
    ANTIQUE_PIANO(1, "antique_piano"),
    BLACK_PIANO(2, "black_piano"),
    BROWN_LUGGAGE(3, "brown_luggage"),
    WHITE_LUGGAGE(4, "white_luggage"),
    TROPHY(5, "trophy");

    private static final EnumClassic[] META_LOOKUP = new EnumClassic[values().length];
    private final int meta;
    private final String name;

    EnumClassic(int meta, String name)
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

    public static EnumClassic byMetadata(int meta)
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
        EnumClassic[] var = values();

        for(EnumClassic type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
package rise.cocricotlite.util.type.interior;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumSample implements IStringSerializable, IMetadata {

    COOKIE(0, "cookie"),
    RED_TART_CAKE(1, "red_tart"),
    YELLOW_TART_CAKE(2, "yellow_tart"),
    CUP_CAKE(3, "cup_cake");

    private static final EnumSample[] META_LOOKUP = new EnumSample[values().length];
    private final int meta;
    private final String name;

    EnumSample(int meta, String name)
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

    public static EnumSample byMetadata(int meta)
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
        EnumSample[] var = values();

        for(EnumSample type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
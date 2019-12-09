package rise.cocricotlite.util.type;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumHangingPlant implements IStringSerializable, IMetadata {

    BASKET(0, "basket"),
    FLOWER(1, "flower");

    private static final EnumHangingPlant[] META_LOOKUP = new EnumHangingPlant[values().length];
    private final int meta;
    private final String name;

    EnumHangingPlant(int meta, String name)
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

    public static EnumHangingPlant byMetadata(int meta)
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
        EnumHangingPlant[] var = values();

        for(EnumHangingPlant type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
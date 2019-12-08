package rise.cocricotlite.util.type;

import net.minecraft.util.IStringSerializable;

public enum EnumVase implements IStringSerializable {

    WHITE(0, "white"),
    LIGHT_BROWN(1, "light_brown"),
    BROWN(2, "brown"),
    DARK_ORANGE(3, "dark_orange"),
    BLACK(4, "black"),
    BASKET_LIGHT(5, "marine_blue");

    private static final EnumVase[] META_LOOKUP = new EnumVase[values().length];
    private final int meta;
    private final String name;

    EnumVase(int meta, String name)
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

    public static EnumVase byMetadata(int meta)
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
        EnumVase[] var = values();

        for(EnumVase type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
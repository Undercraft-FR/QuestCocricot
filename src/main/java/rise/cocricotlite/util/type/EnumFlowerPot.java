package rise.cocricotlite.util.type;

import net.minecraft.util.IStringSerializable;

public enum EnumFlowerPot implements IStringSerializable {

    WHITE(0, "white"),
    LIGHT_BROWN(1, "light_brown"),
    BROWN(2, "brown"),
    DARK_ORANGE(3, "dark_orange"),
    BLACK(4, "black"),
    BASKET_LIGHT(5, "basket_light"),
    BASKET(6, "basket");

    private static final EnumFlowerPot[] META_LOOKUP = new EnumFlowerPot[values().length];
    private final int meta;
    private final String name;

    EnumFlowerPot(int meta, String name)
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

    public static EnumFlowerPot byMetadata(int meta)
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
        EnumFlowerPot[] var = values();

        for(EnumFlowerPot type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
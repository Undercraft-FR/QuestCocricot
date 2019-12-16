package rise.cocricotlite.util.type.interior;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumCookingPot implements IStringSerializable, IMetadata {

    WHITE(0, "white"),
    RED(1, "red"),
    ORANGE(2, "orange"),
    YELLOW(3, "yellow"),
    GREEN(4, "green"),
    BLUE(5, "blue"),
    BLACK(6, "black");

    private static final EnumCookingPot[] META_LOOKUP = new EnumCookingPot[values().length];
    private final int meta;
    private final String name;

    EnumCookingPot(int meta, String name)
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

    public static EnumCookingPot byMetadata(int meta)
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
        EnumCookingPot[] var = values();

        for(EnumCookingPot type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
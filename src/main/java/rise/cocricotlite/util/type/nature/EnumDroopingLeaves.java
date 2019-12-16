package rise.cocricotlite.util.type.nature;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumDroopingLeaves implements IStringSerializable, IMetadata {

    GREEN(0, "green"),
    LIGHT_GREEN(1, "light_green"),
    DARK_GREEN(2, "dark_green");

    private static final EnumDroopingLeaves[] META_LOOKUP = new EnumDroopingLeaves[values().length];
    private final int meta;
    private final String name;

    EnumDroopingLeaves(int meta, String name)
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

    public static EnumDroopingLeaves byMetadata(int meta)
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
        EnumDroopingLeaves[] var = values();

        for(EnumDroopingLeaves type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
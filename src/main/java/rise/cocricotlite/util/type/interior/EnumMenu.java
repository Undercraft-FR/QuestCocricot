package rise.cocricotlite.util.type.interior;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumMenu implements IStringSerializable, IMetadata {

    EASEL(0, "easel"),
    EASEL_WHITE(1, "easel_white"),
    EASEL_BLACK(2, "easel_black"),
    STAND_FRAME(3, "stand_frame");

    private static final EnumMenu[] META_LOOKUP = new EnumMenu[values().length];
    private final int meta;
    private final String name;

    EnumMenu(int meta, String name)
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

    public static EnumMenu byMetadata(int meta)
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
        EnumMenu[] var = values();

        for(EnumMenu type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
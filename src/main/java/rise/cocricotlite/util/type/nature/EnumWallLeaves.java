package rise.cocricotlite.util.type.nature;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumWallLeaves implements IStringSerializable, IMetadata {

    CLIMBING(0, "climbing"),
    IVY_UP(1, "ivy_up"),
    IVY_DOWN(2, "ivy_down");

    private static final EnumWallLeaves[] META_LOOKUP = new EnumWallLeaves[values().length];
    private final int meta;
    private final String name;

    EnumWallLeaves(int meta, String name)
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

    public static EnumWallLeaves byMetadata(int meta)
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
        EnumWallLeaves[] var = values();

        for(EnumWallLeaves type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}

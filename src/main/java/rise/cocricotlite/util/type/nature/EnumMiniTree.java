package rise.cocricotlite.util.type.nature;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumMiniTree implements IStringSerializable, IMetadata {

    LIMP(0, "limp"),
    LIMP_LEAVES(1, "limp_leaves"),
    STRAIGHT(2, "straight"),
    STRAIGHT_LEAVES(3, "straight_leaves");

    private static final EnumMiniTree[] META_LOOKUP = new EnumMiniTree[values().length];
    private final int meta;
    private final String name;

    EnumMiniTree(int meta, String name)
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

    public static EnumMiniTree byMetadata(int meta)
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
        EnumMiniTree[] var = values();

        for(EnumMiniTree type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
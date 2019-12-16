package rise.cocricotlite.util.type.interior;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumGlobe implements IStringSerializable, IMetadata {

    WHITE(0, "white"),
    ANTIQUE(1, "antique"),
    BLUE(2, "blue"),
    BLACK(3, "black"),
    GOLD_CELESTIAL(4, "gold_celestial"),
    ANTIQUE_CELESTIAL(5, "antique_celestial"),
    COLONIAL(6, "colonial");

    private static final EnumGlobe[] META_LOOKUP = new EnumGlobe[values().length];
    private final int meta;
    private final String name;

    EnumGlobe(int meta, String name)
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

    public static EnumGlobe byMetadata(int meta)
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
        EnumGlobe[] var = values();

        for(EnumGlobe type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
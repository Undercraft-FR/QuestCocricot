package rise.cocricotlite.util.type;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumPancake implements IStringSerializable, IMetadata {

    BUTTER(0, "butter"),
    BERRY(1, "berry"),
    CHOCOLATE_BANANA(2, "chocolate_banana"),
    CHOCOLATE_BERRY(3, "chocolate_berry");

    private static final EnumPancake[] META_LOOKUP = new EnumPancake[values().length];
    private final int meta;
    private final String name;

    EnumPancake(int meta, String name)
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

    public static EnumPancake byMetadata(int meta)
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
        EnumPancake[] var = values();

        for(EnumPancake type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}

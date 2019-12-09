package rise.cocricotlite.util.type;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumTapioca implements IStringSerializable, IMetadata {

    CAFE_LATTE(0, "cafe_latte"),
    MILK_TEA(1, "milk_tea"),
    MATCHA(2, "matcha"),
    MATCHA_TEA(3, "matcha_tea"),
    STRAWBERRY_MILK(4, "strawberry_milk");

    private static final EnumTapioca[] META_LOOKUP = new EnumTapioca[values().length];
    private final int meta;
    private final String name;

    EnumTapioca(int meta, String name)
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

    public static EnumTapioca byMetadata(int meta)
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
        EnumTapioca[] var = values();

        for(EnumTapioca type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
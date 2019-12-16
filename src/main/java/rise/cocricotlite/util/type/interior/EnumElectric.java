package rise.cocricotlite.util.type.interior;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumElectric implements IStringSerializable, IMetadata {

    CAMERA(0, "camera"),
    LAPTOP(1, "laptop"),
    WHITE_REGISTER(2, "white_register"),
    BLACK_REGISTER(3, "black_register");

    private static final EnumElectric[] META_LOOKUP = new EnumElectric[values().length];
    private final int meta;
    private final String name;

    EnumElectric(int meta, String name)
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

    public static EnumElectric byMetadata(int meta)
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
        EnumElectric[] var = values();

        for(EnumElectric type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
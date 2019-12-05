package rise.cocricotlite.util.type;

import net.minecraft.util.IStringSerializable;

public enum EnumPizza implements IStringSerializable {

    MARGHERITA(0, "margherita"),
    QUATTRO_FORMAGGI(1, "quattro_formaggi");

    private static final EnumPizza[] META_LOOKUP = new EnumPizza[values().length];
    private final int meta;
    private final String name;

    EnumPizza(int meta, String name)
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

    public static EnumPizza byMetadata(int meta)
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
        EnumPizza[] var = values();

        for(EnumPizza type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}

package rise.cocricotlite.util.type;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumCafeGlass implements IStringSerializable, IMetadata {

    LATTE(0, "latte"),
    CHOCO_MINT(1, "choco_mint");

    private static final EnumCafeGlass[] META_LOOKUP = new EnumCafeGlass[values().length];
    private final int meta;
    private final String name;

    EnumCafeGlass(int meta, String name)
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

    public static EnumCafeGlass byMetadata(int meta)
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
        EnumCafeGlass[] var = values();

        for(EnumCafeGlass type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}

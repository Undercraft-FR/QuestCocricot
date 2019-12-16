package rise.cocricotlite.util.type.interior;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumSundry implements IStringSerializable, IMetadata {

    FISH_BOWL(0, "fish_bowl"),
    DRIED_FLOWER(1, "dried_flower"),
    STARFISH(2, "starfish"),
    GEOMETRIC(3, "geometric"),
    TEDDY_BEAR(4, "teddy_bear"),
    EIFFEL_TOWER(5, "eiffel_tower"),
    SHIP(6, "ship"),
    CAGE(7, "cage"),
    QUILL_PEN(8, "quill_pen"),
    KETCHUP(9, "ketchup"),
    COFFEE_MILL(10, "coffee_mill"),
    COSMETIC(11, "cosmetic"),
    YUTABON(12, "yutabon");

    private static final EnumSundry[] META_LOOKUP = new EnumSundry[values().length];
    private final int meta;
    private final String name;

    EnumSundry(int meta, String name)
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

    public static EnumSundry byMetadata(int meta)
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
        EnumSundry[] var = values();

        for(EnumSundry type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
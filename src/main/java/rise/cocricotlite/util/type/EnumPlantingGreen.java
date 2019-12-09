package rise.cocricotlite.util.type;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumPlantingGreen implements IStringSerializable, IMetadata {

    UMBELLATA(0, "umbellata"),
    TUPIDANTHUS(1, "tupidanthus"),
    SANSEVIERIA(2, "sansevieria"),
    OLIVE(3, "olive"),
    BENJAMIN(4, "benjamin"),
    GOLD_CREST(5, "gold_crest"),
    WILD_BANANA(6, "wild_banana"),
    PACHIRA(7, "pachira"),
    YUCCA(8, "yucca"),
    DYPSIS_LUTESCENS(9, "dypsis_lutescens"),
    CACTUS(10, "cactus");

    private static final EnumPlantingGreen[] META_LOOKUP = new EnumPlantingGreen[values().length];
    private final int meta;
    private final String name;

    EnumPlantingGreen(int meta, String name)
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

    public static EnumPlantingGreen byMetadata(int meta)
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
        EnumPlantingGreen[] var = values();

        for(EnumPlantingGreen type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
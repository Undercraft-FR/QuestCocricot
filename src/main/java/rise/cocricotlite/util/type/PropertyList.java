package rise.cocricotlite.util.type;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.type.dish.*;
import rise.cocricotlite.util.type.interior.*;
import rise.cocricotlite.util.type.nature.*;

public class PropertyList {

    //DISH
    public static final PropertyEnum<EnumSingleDouble> SINGLE_DOUBLE_TYPE = PropertyEnum.create("type", EnumSingleDouble.class);
    public static final PropertyEnum<EnumCafeGlass> CAFE_GLASS_TYPE = PropertyEnum.create("type", EnumCafeGlass.class);
    public static final PropertyEnum<EnumTapioca> TAPIOCA_TYPE = PropertyEnum.create("type", EnumTapioca.class);
    public static final PropertyEnum<EnumChampagne> CHAMPAGNE_TYPE = PropertyEnum.create("type", EnumChampagne.class);
    public static final PropertyEnum<EnumWine> WINE_TYPE = PropertyEnum.create("type", EnumWine.class);
    public static final PropertyEnum<EnumBreakfast> BREAKFAST_TYPE = PropertyEnum.create("type", EnumBreakfast.class);
    public static final PropertyEnum<EnumPizza> PIZZA_TYPE = PropertyEnum.create("type", EnumPizza.class);
    public static final PropertyEnum<EnumPancake> PANCAKE_TYPE = PropertyEnum.create("type", EnumPancake.class);

    //NATURE
    public static final PropertyEnum<EnumDroopingLeaves> DROOPING_LEAVES_TYPE = PropertyEnum.create("type", EnumDroopingLeaves.class);
    public static final PropertyEnum<EnumWallLeaves> WALL_LEAVES_TYPE = PropertyEnum.create("type", EnumWallLeaves.class);
    public static final PropertyEnum<EnumPlantingGreen> PLANTING_GREEN_TYPE = PropertyEnum.create("type", EnumPlantingGreen.class);
    public static final PropertyEnum<EnumFlowerPot> FLOWER_POT_PROPERTY_TYPE = PropertyEnum.create("type", EnumFlowerPot.class);
    public static final PropertyEnum<EnumVase> VASE_TYPE = PropertyEnum.create("type", EnumVase.class);
    public static final PropertyEnum<EnumWindowBox> WINDOW_BOX_TYPE = PropertyEnum.create("type", EnumWindowBox.class);
    public static final PropertyEnum<EnumHangingPlant> HANGING_PLANT_TYPE = PropertyEnum.create("type", EnumHangingPlant.class);
    public static final PropertyEnum<EnumMiniTree> MINI_TREE_TYPE = createEnum(EnumMiniTree.class);


    //INTERIOR
    public static final PropertyEnum<EnumBook> BOOK_PROPERTY_ENUM = createEnum(EnumBook.class);
    public static final PropertyEnum<EnumMenu> MENU_PROPERTY_ENUM = createEnum(EnumMenu.class);
    public static final PropertyEnum<EnumSample> SAMPLE_PROPERTY_ENUM = createEnum(EnumSample.class);
    public static final PropertyEnum<EnumJar> JAR_PROPERTY_ENUM = createEnum(EnumJar.class);
    public static final PropertyEnum<EnumCookingPot> COOKING_POT_PROPERTY_ENUM = createEnum(EnumCookingPot.class);
    public static final PropertyEnum<EnumSundry> SUNDRY_PROPERTY_ENUM = createEnum(EnumSundry.class);
    public static final PropertyEnum<EnumGlobe> GLOBE_PROPERTY_ENUM = createEnum(EnumGlobe.class);
    public static final PropertyEnum<EnumElectric> ELECTRIC_PROPERTY_ENUM = createEnum(EnumElectric.class);
    public static final PropertyEnum<EnumRecordPlayer> RECORD_PLAYER_PROPERTY_ENUM = createEnum(EnumRecordPlayer.class);
    public static final PropertyEnum<EnumClassic> CLASSIC_PROPERTY_ENUM = createEnum(EnumClassic.class);
    public static final PropertyEnum<EnumTelephone> TELEPHONE_PROPERTY_ENUM = createEnum(EnumTelephone.class);
    public static final PropertyEnum<EnumBedFrame> BED_FRAME_PROPERTY_ENUM = createEnum(EnumBedFrame.class);
    public static final PropertyEnum<EnumBedMattress> BED_MATTRESS_PROPERTY_ENUM = createEnum(EnumBedMattress.class);
    public static final PropertyEnum<EnumBedPillow> BED_PILLOW_PROPERTY_ENUM = createEnum(EnumBedPillow.class);
    public static final PropertyEnum<EnumFirePlace> FIRE_PLACE_PROPERTY_ENUM = createEnum(EnumFirePlace.class);
    public static final PropertyEnum<EnumRange> RANGE_PROPERTY_ENUM = createEnum(EnumRange.class);


    private static <T extends Enum<T> & IStringSerializable> PropertyEnum<T> createEnum(Class<T> cls)
    {
        return PropertyEnum.create("type", cls);
    }
}

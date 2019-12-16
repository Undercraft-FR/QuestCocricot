package rise.cocricotlite.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;
import rise.cocricotlite.util.type.interior.EnumBook;

public class TileEntityBook extends BaseTileEntity  {

    private EnumBook type = EnumBook.MODERN;

    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);

        if(tag.hasKey("type", Constants.NBT.TAG_BYTE))
        {
            this.type = EnumBook.byMetadata(tag.getByte("type"));
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setByte("type", (byte) type.getMetadata());
        return tag;
    }

    public EnumBook getType()
    {
        return this.type;
    }

    public void setType(EnumBook type)
    {
        this.type = type;
    }
}

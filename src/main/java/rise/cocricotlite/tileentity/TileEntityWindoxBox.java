package rise.cocricotlite.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;
import rise.cocricotlite.util.type.EnumWindowBox;

public class TileEntityWindoxBox extends BaseTileEntity {

    private EnumWindowBox type = EnumWindowBox.WHITE;

    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);

        if(tag.hasKey("type", Constants.NBT.TAG_BYTE))
        {
            this.type = EnumWindowBox.byMetadata(tag.getByte("type"));
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setByte("type", (byte) type.getMetadata());
        return tag;
    }

    public EnumWindowBox getType()
    {
        return this.type;
    }

    public void setType(EnumWindowBox type)
    {
        this.type = type;
    }
}

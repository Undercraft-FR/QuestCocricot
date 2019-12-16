package rise.cocricotlite.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;
import rise.cocricotlite.util.type.interior.EnumRecordPlayer;

public class TileEntityRecordPlayer extends BaseTileEntity  {

    private EnumRecordPlayer type = EnumRecordPlayer.WOOD_CLEAR;

    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);

        if(tag.hasKey("type", Constants.NBT.TAG_BYTE))
        {
            this.type = EnumRecordPlayer.byMetadata(tag.getByte("type"));
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setByte("type", (byte) type.getMetadata());
        return tag;
    }

    public EnumRecordPlayer getType()
    {
        return this.type;
    }

    public void setType(EnumRecordPlayer type)
    {
        this.type = type;
    }
}

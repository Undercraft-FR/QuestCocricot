package rise.cocricotlite.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class CommonItemBlock extends ItemBlock {

    private final IType nameFunction;

    public CommonItemBlock(Block block, IType map)
    {
        super(block);
        this.nameFunction = map;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public CommonItemBlock(Block block, final String[] namesByMeta)
    {
        this(block, itemStack ->
        {
            int i = itemStack.getMetadata();
            if(i < 0 || i >= namesByMeta.length)
            {
                i = 0;
            }

            return namesByMeta[i];
        });
    }

    public String getUnlocalizedName(ItemStack itemStack)
    {
        return super.getUnlocalizedName() + "." + this.nameFunction.apply(itemStack);
    }

    public int getMetadata(int meta)
    {
        return meta;
    }

    public interface IType
    {
        String apply(ItemStack itemStack);
    }
}

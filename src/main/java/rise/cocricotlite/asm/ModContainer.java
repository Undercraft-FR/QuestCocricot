package rise.cocricotlite.asm;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;

/**
 * Original code was quoted from AppleMilkCore by defeatedcrow.
 */
public class ModContainer extends DummyModContainer {

    public ModContainer()
    {
        super(new ModMetadata());
        ModMetadata meta = this.getMetadata();
        meta.modId = "cocricotlitecore";
        meta.name = "CocricotLiteCore";
        meta.version = "1.12.2-r1";
        meta.authorList = Lists.newArrayList("RiSE4");
        meta.description = "This code is required by CocricotLite";
    }

    public boolean registerBus(EventBus bus, LoadController controller)
    {
        bus.register(this);
        return true;
    }
}

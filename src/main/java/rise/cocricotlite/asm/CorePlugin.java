package rise.cocricotlite.asm;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * Original code was quoted from AppleMilkCore by defeatedcrow.
 */
public class CorePlugin implements IFMLLoadingPlugin {

    public static Logger logger = LogManager.getLogger("CocricotLiteCore");

    static
    {
        logger.info("The loading is complete!");
    }

    @Override
    public String[] getASMTransformerClass()
    {
        return new String[] {"rise.cocricotlite.asm.MaxMetadataTransformer"};
    }

    @Override
    public String getModContainerClass()
    {
        return "rise.cocricotlite.asm.ModContainer";
    }

    @Nullable
    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data)
    {

    }

    @Override
    public String getAccessTransformerClass()
    {
        return null;
    }
}

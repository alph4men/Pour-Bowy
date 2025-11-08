package cpw.mods.fml.common.event;

import java.io.File;

public class FMLPreInitializationEvent {
    private final File suggestedConfigurationFile;

    public FMLPreInitializationEvent(File suggestedConfigurationFile) {
        this.suggestedConfigurationFile = suggestedConfigurationFile;
    }

    public File getSuggestedConfigurationFile() {
        return suggestedConfigurationFile;
    }
}

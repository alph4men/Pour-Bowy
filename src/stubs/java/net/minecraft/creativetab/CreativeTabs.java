package net.minecraft.creativetab;

public class CreativeTabs {
    public static final CreativeTabs tabBlock = new CreativeTabs("tabBlock");

    private final String label;

    protected CreativeTabs(String label) {
        this.label = label;
    }

    public String getTabLabel() {
        return label;
    }
}

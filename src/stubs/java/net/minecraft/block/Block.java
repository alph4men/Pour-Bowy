package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class Block {
    protected static final Object soundGravelFootstep = new Object();
    private final int id;
    private final Material material;

    public Block(int id, Material material) {
        this.id = id;
        this.material = material;
    }

    public Block setCreativeTab(CreativeTabs tab) {
        return this;
    }

    public Block setHardness(float hardness) {
        return this;
    }

    public Block setStepSound(Object sound) {
        return this;
    }

    public Block setUnlocalizedName(String name) {
        return this;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
    }

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        return null;
    }

    public int getId() {
        return id;
    }

    public Material getMaterial() {
        return material;
    }
}

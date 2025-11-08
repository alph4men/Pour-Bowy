package com.pourbowy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PourBowySoilBlock extends Block {
    @SideOnly(Side.CLIENT)
    private Icon icon;

    public PourBowySoilBlock(int id, String name) {
        super(id, Material.ground);
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(0.6F);
        setStepSound(soundGravelFootstep);
        setUnlocalizedName(PourBowyMod.MOD_ID + ":" + name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
        this.icon = register.registerIcon("minecraft:dirt");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        return icon;
    }
}

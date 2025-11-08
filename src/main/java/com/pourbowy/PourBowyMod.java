package com.pourbowy;

import net.minecraft.block.Block;

import net.minecraftforge.common.Configuration;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = PourBowyMod.MOD_ID, name = PourBowyMod.MOD_NAME, version = PourBowyMod.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class PourBowyMod {
    public static final String MOD_ID = "pourbowy";
    public static final String MOD_NAME = "Pour Bowy";
    public static final String VERSION = "1.0.0";

    @Instance(MOD_ID)
    public static PourBowyMod instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        try {
            registerEarthVariant(config, "packed_dirt", 3000, "Packed Dirt");
            registerEarthVariant(config, "mossy_dirt", 3001, "Mossy Dirt");
            registerEarthVariant(config, "rich_dirt", 3002, "Rich Dirt");
            registerEarthVariant(config, "dry_dirt", 3003, "Dry Dirt");
            registerEarthVariant(config, "fertile_dirt", 3004, "Fertile Dirt");
            registerEarthVariant(config, "porous_dirt", 3005, "Porous Dirt");
            registerEarthVariant(config, "dense_dirt", 3006, "Dense Dirt");
            registerEarthVariant(config, "soft_dirt", 3007, "Soft Dirt");
            registerEarthVariant(config, "silted_dirt", 3008, "Silted Dirt");
            registerEarthVariant(config, "crusted_dirt", 3009, "Crusted Dirt");
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }

    private void registerEarthVariant(Configuration config, String name, int defaultId, String defaultDisplayName) {
        int blockId = config.get("block", name, defaultId).getInt(defaultId);
        if (blockId < 3000 || blockId > 3500) {
            throw new IllegalArgumentException("Block ID for " + name + " must be between 3000 and 3500 but was " + blockId);
        }

        Block block = new PourBowySoilBlock(blockId, name);
        GameRegistry.registerBlock(block, name);
        LanguageRegistry.addName(block, defaultDisplayName);
    }
}

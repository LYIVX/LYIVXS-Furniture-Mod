package net.lyivx.ls_furniture.config;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;

/**
 * Registry class for configuration-related functionality.
 * Safe to be called from both client and server environments.
 */
public class ConfigRegistry {
    
    /**
     * Called during mod initialization to set up configuration.
     */
    public static void init() {
        LYIVXsFurnitureMod.LOGGER.info("Initializing config registry for Furnection");
        
        // ConfigProvider is loaded via ServiceLoader
        // We just need to make sure it exists in META-INF/services/
    }
} 
package net.lyivx.ls_furniture.client;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;

/**
 * Client-side initialization code that is only run on the client.
 * This is the safe place to reference client-only classes.
 */
public class ClientInit {
    
    public static void init() {
        LYIVXsFurnitureMod.LOGGER.info("Initializing client-side components for Furnection");
        
        // Register client-specific handlers, renderers, etc. here
        // This method is called by platform-specific client initializers
    }
} 
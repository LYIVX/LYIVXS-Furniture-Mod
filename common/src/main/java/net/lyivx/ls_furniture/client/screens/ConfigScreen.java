package net.lyivx.ls_furniture.client.screens;

import dev.architectury.platform.Platform;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.config.Configs;
import net.lyivx.ls_furniture.common.config.CustomConfigSpec;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigScreen {
    private static CustomConfigSpec CONFIG_SPEC;
    private static final Logger LOGGER = LogManager.getLogger();

    public static void initConfig() {
        Path configFolder;
        try {
            configFolder = Platform.getConfigFolder();
        } catch (AssertionError e) {
            LOGGER.warn("Failed to get config folder from Platform, using fallback", e);
            configFolder = Paths.get(Minecraft.getInstance().gameDirectory.getPath(), "config");
        }

        try {
            // Initialize the CustomConfigCloth instance
            CONFIG_SPEC = new CustomConfigSpec(configFolder, "ls_furniture-client");

            // Register and load config
            CONFIG_SPEC.loadConfig();
            Configs.setConfigSpec(CONFIG_SPEC);

            // Sync the in-memory config values with what's stored
            updateConfigValues();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize config", e);
            setDefaultConfigValues();
        }
    }


    public static void reloadConfig() {
        if (CONFIG_SPEC != null) {
            CONFIG_SPEC.loadConfig();
            updateConfigValues();
        } else {
            LOGGER.warn("Attempted to reload config, but CONFIG_SPEC is null");
        }
    }

    private static void updateConfigValues() {
        if (CONFIG_SPEC != null) {
            // Update in-memory values from the config
            Configs.SORT_RECIPES = CONFIG_SPEC.getSortRecipes();
            Configs.SEARCH_MODE = CONFIG_SPEC.getSearchMode();
            Configs.SEARCH_BAR_THRESHOLD = CONFIG_SPEC.getSearchBarThreshold();
        } else {
            LOGGER.warn("Attempted to update config values, but CONFIG_SPEC is null");
        }
    }

    private static void setDefaultConfigValues() {
        // Set default values for your config in case of failure
        Configs.SORT_RECIPES = true;
        Configs.SEARCH_MODE = Configs.SearchMode.AUTOMATIC;
        Configs.SEARCH_BAR_THRESHOLD = 32;
        LOGGER.info("Using default config values due to initialization failure");
    }
}
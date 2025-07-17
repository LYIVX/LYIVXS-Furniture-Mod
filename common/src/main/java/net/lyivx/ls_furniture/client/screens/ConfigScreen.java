package net.lyivx.ls_furniture.client.screens;

import dev.architectury.platform.Platform;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.config.Configs;
import net.lyivx.ls_furniture.common.config.CustomConfigSpec;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.mehvahdjukaar.moonlight.api.platform.configs.ConfigType;
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
            CONFIG_SPEC = new CustomConfigSpec(
                    LYIVXsFurnitureMod.MOD_ID,
                    "ls_furniture-client.json",
                    configFolder,
                    ConfigType.CLIENT,
                    false
            );

            CONFIG_SPEC.register();
            Configs.setConfigSpec(CONFIG_SPEC);

            // Load the config
            CONFIG_SPEC.loadFromFile();
            updateConfigValues();
        } catch (Exception e) {
            LOGGER.error("Failed to initialize config", e);
            // Set default values or handle the error as appropriate for your mod
            setDefaultConfigValues();
        }
    }

    public static Screen createConfigScreen(Screen parent) {
        return CONFIG_SPEC != null ? CONFIG_SPEC.makeScreen(parent, null) : null;
    }

    // Method to reload config from file
    public static void reloadConfig() {
        if (CONFIG_SPEC != null) {
            CONFIG_SPEC.loadFromFile();
            updateConfigValues();
        } else {
            LOGGER.warn("Attempted to reload config, but CONFIG_SPEC is null");
        }
    }

    private static void updateConfigValues() {
        if (CONFIG_SPEC != null) {
            Configs.SORT_RECIPES = CONFIG_SPEC.getSortRecipes();
            Configs.SEARCH_MODE = CONFIG_SPEC.getSearchMode();
            Configs.SEARCH_BAR_THRESHOLD = CONFIG_SPEC.getSearchBarThreshold();
        } else {
            LOGGER.warn("Attempted to update config values, but CONFIG_SPEC is null");
        }
    }

    private static void setDefaultConfigValues() {
        // Set default values for your config
        Configs.SORT_RECIPES = true;
        Configs.SEARCH_MODE = Configs.SearchMode.AUTOMATIC;
        Configs.SEARCH_BAR_THRESHOLD = 32;
        LOGGER.info("Using default config values due to initialization failure");
    }
}
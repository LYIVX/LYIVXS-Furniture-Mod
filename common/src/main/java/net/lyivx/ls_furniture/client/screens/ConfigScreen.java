package net.lyivx.ls_furniture.client.screens;

import dev.architectury.platform.Platform;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.config.Configs;
import net.lyivx.ls_furniture.common.config.CustomConfigSpec;
import net.minecraft.client.gui.screens.Screen;
import net.mehvahdjukaar.moonlight.api.platform.configs.ConfigType;

public class ConfigScreen {
    private static CustomConfigSpec CONFIG_SPEC;

    public static void initConfig() {
        CONFIG_SPEC = new CustomConfigSpec(
                LYIVXsFurnitureMod.MOD_ID,
                "ls_furniture-client.json",
                Platform.getConfigFolder(), // Get config folder
                ConfigType.CLIENT,
                false
        );

        CONFIG_SPEC.register();
        Configs.setConfigSpec(CONFIG_SPEC);

        // Load the config
        CONFIG_SPEC.loadFromFile();
        updateConfigValues();
    }

    public static Screen createConfigScreen(Screen parent) {
        return CONFIG_SPEC.makeScreen(parent, null);
    }

    // Method to reload config from file
    public static void reloadConfig() {
        CONFIG_SPEC.loadFromFile();
        updateConfigValues();
    }

    private static void updateConfigValues() {
        Configs.SORT_RECIPES = CONFIG_SPEC.getSortRecipes();
        Configs.SEARCH_MODE = CONFIG_SPEC.getSearchMode();
        Configs.SEARCH_BAR_THRESHOLD = CONFIG_SPEC.getSearchBarThreshold();
    }
}
package net.lyivx.ls_furniture.common.config;

import net.mehvahdjukaar.moonlight.api.platform.configs.ConfigBuilder;
import net.mehvahdjukaar.moonlight.api.platform.configs.ConfigSpec;

public class Configs {
    public static Boolean SORT_RECIPES = true; // Default value
    public static SearchMode SEARCH_MODE = SearchMode.AUTOMATIC; // Default value
    public static Integer SEARCH_BAR_THRESHOLD = 32; // Default value

    private static CustomConfigSpec CONFIG_SPEC;

    public enum SearchMode {
        OFF("Off"),
        ON("On"),
        AUTOMATIC("Automatic"),
        DYNAMIC("Dynamic");

        private final String displayName;

        SearchMode(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return this.displayName;
        }
    }

    public static boolean hasSearchBar(int recipeCount) {
        return switch (SEARCH_MODE) {
            case ON -> true;
            case OFF -> false;
            case AUTOMATIC, DYNAMIC -> recipeCount > SEARCH_BAR_THRESHOLD;
        };
    }

    public static void setConfigSpec(ConfigSpec spec) {
        CONFIG_SPEC = (CustomConfigSpec) spec;
    }

    public static void saveConfig() {
        if (CONFIG_SPEC != null) {
            // Update values in CustomConfigSpec based on current settings
            CONFIG_SPEC.setSortRecipes(SORT_RECIPES);
            CONFIG_SPEC.setSearchMode(SEARCH_MODE);
            CONFIG_SPEC.setSearchBarThreshold(SEARCH_BAR_THRESHOLD);

            // Save the updated config to file
            CONFIG_SPEC.saveConfig();  // Ensure this method writes to the file
        }
    }
}
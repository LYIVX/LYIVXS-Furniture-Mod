package net.lyivx.ls_furniture.common.config;

public class Configs {
    public static Boolean SORT_RECIPES = true; // Default value
    public static Boolean PREVIEW = true; // Default value
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
            case AUTOMATIC -> recipeCount > 25;
            case DYNAMIC -> recipeCount > SEARCH_BAR_THRESHOLD;
        };
    }

    // Set the configuration handler object
    public static void setConfigSpec(CustomConfigSpec spec) {
        CONFIG_SPEC = spec;

        if (CONFIG_SPEC != null) {
            SORT_RECIPES = CONFIG_SPEC.getSortRecipes();
            PREVIEW = CONFIG_SPEC.getPreview();
            SEARCH_MODE = CONFIG_SPEC.getSearchMode();
            SEARCH_BAR_THRESHOLD = CONFIG_SPEC.getSearchBarThreshold();
        }

        // Save current in-memory settings to the config file
        saveConfig();
    }

    // Save current in-memory settings to the config file via CustomConfigCloth
    public static void saveConfig() {
        if (CONFIG_SPEC != null) {
            // Update values in the CustomConfigCloth object based on current settings
            CONFIG_SPEC.setSortRecipes(SORT_RECIPES);
            CONFIG_SPEC.setPreview(PREVIEW);
            CONFIG_SPEC.setSearchMode(SEARCH_MODE);
            CONFIG_SPEC.setSearchBarThreshold(SEARCH_BAR_THRESHOLD);

            // Save the updated config to file
            CONFIG_SPEC.saveConfig();  // Ensure this method writes to the file
        }
    }
}

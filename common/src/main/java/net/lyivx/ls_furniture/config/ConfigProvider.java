package net.lyivx.ls_furniture.config;

import com.google.gson.JsonObject;
import net.lyivx.ls_core.client.screens.ModConfigScreen;
import net.lyivx.ls_core.client.screens.widgets.CustomOptionsList;
import net.lyivx.ls_core.common.config.CustomConfigSpec;
import net.lyivx.ls_core.common.config.ILyivxConfigProvider;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import org.jetbrains.annotations.NotNull;

public class ConfigProvider implements ILyivxConfigProvider {

    // Use the furniture mod's ID
    public static final String PROVIDER_ID = LYIVXsFurnitureMod.MOD_ID;
    private static CustomConfigSpec configSpecInstance = null;

    /**
     * No-arg constructor required by ServiceLoader
     */
    public ConfigProvider() {
        // Required empty constructor for ServiceLoader
    }

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
            // Use the display name for user-facing strings if needed,
            // but use .name() for saving/loading the enum constant name.
            return this.displayName;
        }

        // Optional: Add a method to get by name safely, defaulting if needed
        public static SearchMode safeValueOf(String name) {
            try {
                return valueOf(name);
            } catch (IllegalArgumentException | NullPointerException e) {
                return AUTOMATIC; // Default value
            }
        }
    }

    // --- Static Access ---
    @NotNull
    public static CustomConfigSpec getConfigSpec() {
        if (configSpecInstance == null) {
            LYIVXsFurnitureMod.LOGGER.error("Furnection ConfigProvider accessed before configSpec was registered!");
            // Return null and handle it in getters, or implement a dummy spec
            return null;
        }
        return configSpecInstance;
    }

    public static boolean shouldSortRecipes() {
        CustomConfigSpec spec = getConfigSpec();
        return spec != null ? spec.getBoolean("sort_recipes", true) : true;
    }

    public static boolean shouldShowPreview() {
        CustomConfigSpec spec = getConfigSpec();
        return spec != null ? spec.getBoolean("show_preview", true) : true;
    }

    public static SearchMode getSearchMode() {
        CustomConfigSpec spec = getConfigSpec();
        // Use the local safeValueOf if implemented, or handle default directly
        return spec != null ? spec.getEnum("search_bar_mode", SearchMode.AUTOMATIC, SearchMode.class) : SearchMode.AUTOMATIC;
    }

    public static int getSearchBarThreshold() {
        CustomConfigSpec spec = getConfigSpec();
        return spec != null ? spec.getInt("search_bar_threshold", 32) : 32;
    }

    public static boolean hasSearchBar(int recipeCount) {
        return switch (getSearchMode()) {
            case ON -> true;
            case OFF -> false;
            case AUTOMATIC -> recipeCount > 25;
            case DYNAMIC -> recipeCount > getSearchBarThreshold();
        };
    }

    public static boolean isSinkUniversal() {
        CustomConfigSpec spec = getConfigSpec();
        return spec != null ? spec.getBoolean("sink_allow_all_liquids", false) : false;
    }

    public static int getSinkCapacityBuckets() {
        CustomConfigSpec spec = getConfigSpec();
        return spec != null ? spec.getInt("sink_capacity_buckets", 3) : 3;
    }

    @Override
    public String getModId() {
        return PROVIDER_ID;
    }

    @Override
    public String getModName() { return "Furnection"; }

    @Override
    public String getConfigCategoryName() {
        return "Furnection";  // Hardcoded for server compatibility
    }

    @Override
    public JsonObject getDefaultConfig() {
        JsonObject defaults = new JsonObject();
        defaults.addProperty("sort_recipes", true);
        defaults.addProperty("show_preview", true);
        defaults.addProperty("search_bar_mode", SearchMode.AUTOMATIC.name());
        defaults.addProperty("search_bar_threshold", 32);
        // Add new defaults
        defaults.addProperty("sink_allow_all_liquids", false);
        defaults.addProperty("sink_capacity_buckets", 3);
        return defaults;
    }

    @Override
    public void registerConfigSpec(CustomConfigSpec spec) {
        ConfigProvider.configSpecInstance = spec;
        LYIVXsFurnitureMod.LOGGER.info("Registered config spec for LYIVX's Furniture.");
    }

    @Override
    public void addConfigOptions(ModConfigScreen screen, CustomOptionsList list) {
        // Defer to ClientConfigHelper on client side
        if (screen != null && list != null) {
            ClientConfigHelper.addConfigOptions(this, screen, list);
        }
    }

    @Override
    public void resetConfigDefaults() {
        CustomConfigSpec spec = ConfigProvider.configSpecInstance;
        if (spec != null) {
            JsonObject defaults = getDefaultConfig();
            defaults.entrySet().forEach(entry -> {
                spec.set(entry.getKey(), entry.getValue());
            });
        }
    }
}
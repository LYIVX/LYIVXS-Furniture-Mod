package net.lyivx.ls_furniture.config;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import net.lyivx.ls_core.client.screens.ModConfigScreen;
import net.lyivx.ls_core.client.screens.widgets.CustomOptionsList;
import net.lyivx.ls_core.common.config.CustomConfigSpec;
import net.lyivx.ls_core.common.config.ILyivxConfigProvider;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.minecraft.client.OptionInstance;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static net.lyivx.ls_core.LYIVXsCore.MOD_ID;

public class ConfigProvider implements ILyivxConfigProvider {

    // Use the furniture mod's ID
    public static final String PROVIDER_ID = LYIVXsFurnitureMod.MOD_ID;
    private static CustomConfigSpec configSpecInstance = null;

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
            LYIVXsFurnitureMod.LOGGER.error(MOD_ID + " ConfigProvider accessed before configSpec was registered!");
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
        return Component.translatable("config." + PROVIDER_ID + ".category").getString();
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
        CustomConfigSpec spec = ConfigProvider.configSpecInstance;
        if (spec == null) {
            list.addTitle(Component.literal("Error: Config not loaded for " + getModId()));
            return;
        }

        // --- Create Option Instances ---

        list.addTitle(Component.translatable("config." + PROVIDER_ID + ".group.workstation"));

        // Sort Recipes Toggle
        OptionInstance<Boolean> sortRecipesOption = OptionInstance.createBoolean(
                "config." + PROVIDER_ID + ".sort_recipes",
                OptionInstance.cachedConstantTooltip(Component.translatable("config." + PROVIDER_ID + ".sort_recipes.tooltip")),
                spec.getBoolean("sort_recipes", true),
                (value) -> spec.setBoolean("sort_recipes", value)
        );

        // Show Preview Toggle
        OptionInstance<Boolean> previewOption = OptionInstance.createBoolean(
                "config." + PROVIDER_ID + ".show_preview",
                OptionInstance.cachedConstantTooltip(Component.translatable("config." + PROVIDER_ID + ".show_preview.tooltip")),
                spec.getBoolean("show_preview", true),
                (value) -> spec.setBoolean("show_preview", value)
        );

        // Search Mode Cycle Button
        OptionInstance<SearchMode> searchModeOption = new OptionInstance<>(
                "config." + PROVIDER_ID + ".search_bar_mode",
                OptionInstance.cachedConstantTooltip(Component.translatable("config." + PROVIDER_ID + ".search_bar_mode.tooltip")),
                // Now uses local enum's toString() or a specific translation key
                (component, value) -> Component.translatable("config." + PROVIDER_ID + ".search_mode." + value.name().toLowerCase()),
                new OptionInstance.Enum<>(
                        Arrays.asList(SearchMode.values()), // Use local enum
                        Codec.STRING.xmap(
                                // Use local safeValueOf or try/catch
                                name -> SearchMode.safeValueOf(name),
                                Enum::name
                        )
                ),
                spec.getEnum("search_bar_mode", SearchMode.AUTOMATIC, SearchMode.class), // Use local enum
                (value) -> spec.setEnum("search_bar_mode", value) // Use local enum
        );

        // Search Bar Threshold Slider
        OptionInstance<Integer> searchBarThresholdOption = new OptionInstance<>(
                "config." + PROVIDER_ID + ".search_bar_threshold",
                OptionInstance.cachedConstantTooltip(Component.translatable("config." + PROVIDER_ID + ".search_bar_threshold.tooltip")),
                (component, value) -> Component.translatable("options.generic_value", component, Component.literal(Integer.toString(value))),
                new OptionInstance.IntRange(0, 100), // Or another appropriate range
                spec.getInt("search_bar_threshold", 32),
                (value) -> spec.setInt("search_bar_threshold", value)
        );

        // --- Add options to the list ---
        list.addBig(sortRecipesOption);
        list.addBig(previewOption);
        list.addSmall(searchModeOption, searchBarThresholdOption);

        // --- Sink Settings --- (New group)
        list.addTitle(Component.translatable("config." + PROVIDER_ID + ".group.sink"));

        // Sink Universal Toggle
        OptionInstance<Boolean> sinkUniversalOption = OptionInstance.createBoolean(
                "config." + PROVIDER_ID + ".sink_allow_all_liquids",
                OptionInstance.cachedConstantTooltip(Component.translatable("config." + PROVIDER_ID + ".sink_allow_all_liquids.tooltip")),
                spec.getBoolean("sink_allow_all_liquids", false),
                (value) -> spec.setBoolean("sink_allow_all_liquids", value)
        );

        // Sink Capacity Slider
        OptionInstance<Integer> sinkCapacityOption = new OptionInstance<>(
                "config." + PROVIDER_ID + ".sink_capacity_buckets",
                OptionInstance.cachedConstantTooltip(Component.translatable("config." + PROVIDER_ID + ".sink_capacity_buckets.tooltip")),
                (component, value) -> Component.translatable("options.generic_value", component, Component.literal(value + " " + (value == 1 ? "bucket" : "buckets"))),
                new OptionInstance.IntRange(1, 16), // Example range: 1 to 16 buckets
                spec.getInt("sink_capacity_buckets", 3),
                (value) -> spec.setInt("sink_capacity_buckets", value)
        );

        // Add new sink options to the list
        list.addSmall(sinkUniversalOption, sinkCapacityOption);
    }

    @Override
    public void resetConfigDefaults() {
        CustomConfigSpec spec = ConfigProvider.configSpecInstance;
        if (spec != null) {
            JsonObject defaults = getDefaultConfig();
            defaults.entrySet().forEach(entry -> {
                spec.set(entry.getKey(), entry.getValue());
            });
            // spec.saveConfig(); // If needed
        }
    }
}
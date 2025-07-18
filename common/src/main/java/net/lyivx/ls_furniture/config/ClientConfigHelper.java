package net.lyivx.ls_furniture.config;

import com.mojang.serialization.Codec;
import net.lyivx.ls_core.client.screens.ModConfigScreen;
import net.lyivx.ls_core.client.screens.widgets.CustomOptionsList;
import net.lyivx.ls_core.common.config.CustomConfigSpec;
import net.minecraft.client.OptionInstance;
import net.minecraft.network.chat.Component;

import java.util.Arrays;

/**
 * Helper class to handle client-side config UI.
 * This class is only loaded on the client side.
 */
public class ClientConfigHelper {

    /**
     * Adds config options to the config screen
     * @param provider The ConfigProvider instance
     * @param screen The ModConfigScreen instance
     * @param list The CustomOptionsList to add options to
     */
    public static void addConfigOptions(ConfigProvider provider, ModConfigScreen screen, CustomOptionsList list) {
        CustomConfigSpec spec = ConfigProvider.getConfigSpec();
        if (spec == null) {
            list.addTitle(Component.literal("Error: Config not loaded for " + provider.getModId()));
            return;
        }

        String modId = provider.getModId();

        // --- Create Option Instances ---
        list.addTitle(Component.translatable("config." + modId + ".group.workstation"));

        // Sort Recipes Toggle
        OptionInstance<Boolean> sortRecipesOption = OptionInstance.createBoolean(
                "config." + modId + ".sort_recipes",
                OptionInstance.cachedConstantTooltip(Component.translatable("config." + modId + ".sort_recipes.tooltip")),
                spec.getBoolean("sort_recipes", true),
                (value) -> spec.setBoolean("sort_recipes", value)
        );

        // Show Preview Toggle
        OptionInstance<Boolean> previewOption = OptionInstance.createBoolean(
                "config." + modId + ".show_preview",
                OptionInstance.cachedConstantTooltip(Component.translatable("config." + modId + ".show_preview.tooltip")),
                spec.getBoolean("show_preview", true),
                (value) -> spec.setBoolean("show_preview", value)
        );

        // Search Mode Cycle Button
        OptionInstance<ConfigProvider.SearchMode> searchModeOption = new OptionInstance<>(
                "config." + modId + ".search_bar_mode",
                OptionInstance.cachedConstantTooltip(Component.translatable("config." + modId + ".search_bar_mode.tooltip")),
                (component, value) -> Component.translatable("config." + modId + ".search_mode." + value.name().toLowerCase()),
                new OptionInstance.Enum<>(
                        Arrays.asList(ConfigProvider.SearchMode.values()),
                        Codec.STRING.xmap(
                                ConfigProvider.SearchMode::safeValueOf,
                                Enum::name
                        )
                ),
                spec.getEnum("search_bar_mode", ConfigProvider.SearchMode.AUTOMATIC, ConfigProvider.SearchMode.class),
                (value) -> spec.setEnum("search_bar_mode", value)
        );

        // Search Bar Threshold Slider
        OptionInstance<Integer> searchBarThresholdOption = new OptionInstance<>(
                "config." + modId + ".search_bar_threshold",
                OptionInstance.cachedConstantTooltip(Component.translatable("config." + modId + ".search_bar_threshold.tooltip")),
                (component, value) -> Component.translatable("options.generic_value", component, Component.literal(Integer.toString(value))),
                new OptionInstance.IntRange(0, 100),
                spec.getInt("search_bar_threshold", 32),
                (value) -> spec.setInt("search_bar_threshold", value)
        );

        // --- Add options to the list ---
        list.addBig(sortRecipesOption);
        list.addBig(previewOption);
        list.addSmall(searchModeOption, searchBarThresholdOption);

        // --- Sink Settings --- (New group)
        list.addTitle(Component.translatable("config." + modId + ".group.sink"));

        // Sink Universal Toggle
        OptionInstance<Boolean> sinkUniversalOption = OptionInstance.createBoolean(
                "config." + modId + ".sink_allow_all_liquids",
                OptionInstance.cachedConstantTooltip(Component.translatable("config." + modId + ".sink_allow_all_liquids.tooltip")),
                spec.getBoolean("sink_allow_all_liquids", false),
                (value) -> spec.setBoolean("sink_allow_all_liquids", value)
        );

        // Sink Capacity Slider
        OptionInstance<Integer> sinkCapacityOption = new OptionInstance<>(
                "config." + modId + ".sink_capacity_buckets",
                OptionInstance.cachedConstantTooltip(Component.translatable("config." + modId + ".sink_capacity_buckets.tooltip")),
                (component, value) -> Component.translatable("options.generic_value", component, Component.literal(value + " " + (value == 1 ? "bucket" : "buckets"))),
                new OptionInstance.IntRange(1, 16),
                spec.getInt("sink_capacity_buckets", 3),
                (value) -> spec.setInt("sink_capacity_buckets", value)
        );

        // Add new sink options to the list
        list.addSmall(sinkUniversalOption, sinkCapacityOption);
    }
} 
package net.lyivx.ls_furniture.common.config;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.client.LYIVXsFurnitureModClient;
import net.mehvahdjukaar.moonlight.api.platform.configs.ConfigBuilder;
import net.mehvahdjukaar.moonlight.api.platform.configs.ConfigType;

import java.util.function.Supplier;

public class Configs {

    public static final Supplier<SearchMode> SEARCH_MODE;
    public static final Supplier<Integer> SEARCH_BAR_THRESHOLD;
    public static final Supplier<Boolean> SORT_RECIPES;

    static {
        ConfigBuilder builder = ConfigBuilder.create(LYIVXsFurnitureMod.MOD_ID, ConfigType.CLIENT);

        builder.push("general");
        SORT_RECIPES = builder.comment("Sort recipes following cretive tab order. Could cause issue in the case when, for whatever reason, creative other would differ from server to client.")
                .define("sort_recipes", true);
        SEARCH_MODE = builder
                .comment("Determines if GUI will have search bar or not. Automatic only enables the bar statically when you have enough mods that add wood recipes. Dynamic changes the gui dynamically depending on how many recipe its displaying")
                .define("search_bar_mode", SearchMode.AUTOMATIC);
        SEARCH_BAR_THRESHOLD = builder.comment("At how many recipes the search bar should appear")
                .define("search_bar_threshold", 32, 0, 200);
        builder.pop();

        builder.buildAndRegister().loadFromFile();
    }

    public static void init() {
    }

    public static boolean hasSearchBar(int recipeCount) {
        var s = SEARCH_MODE.get();
        return switch (s) {
            case ON -> true;
            case OFF -> false;
            case AUTOMATIC -> LYIVXsFurnitureModClient.hasManyRecipes();
            case DYNAMIC -> recipeCount > SEARCH_BAR_THRESHOLD.get();
        };
    }

    public enum SearchMode {
        OFF, ON, AUTOMATIC, DYNAMIC
    }
}
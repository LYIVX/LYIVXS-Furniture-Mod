package net.lyivx.ls_furniture.common.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.mehvahdjukaar.moonlight.api.platform.configs.ConfigSpec;
import net.mehvahdjukaar.moonlight.api.platform.configs.ConfigType;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomConfigSpec extends ConfigSpec {
    private final Gson gson;
    private JsonObject config;

    public CustomConfigSpec(String modId, String fileName, Path configDirectory, ConfigType type, boolean synced) {
        super(modId, fileName, configDirectory, type, synced, null);
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.config = new JsonObject();
    }

    @Override
    public Component getName() {
        return Component.translatable("config.ls_furniture.title");
    }

    @Override
    public void loadFromFile() {
        try (Reader reader = Files.newBufferedReader(this.getFullPath())) {
            this.config = gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void register() {
        if (!Files.exists(this.getFullPath())) {
            JsonObject general = new JsonObject();
            general.addProperty("sort_recipes", Configs.SORT_RECIPES);
            general.addProperty("search_bar_mode", Configs.SEARCH_MODE.name());
            general.addProperty("search_bar_threshold", Configs.SEARCH_BAR_THRESHOLD);

            config.add("general", general);

            saveConfig();
        }
    }

    @Override
    public void loadFromBytes(InputStream inputStream) {
        try (Reader reader = new InputStreamReader(inputStream)) {
            this.config = gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Screen makeScreen(Screen parent, ResourceLocation backgroundLocation) {
        // You might want to implement a custom screen here
        return null;
    }

    @Override
    public boolean hasConfigScreen() {
        return true;
    }

    public boolean getSortRecipes() {
        return config.getAsJsonObject("general").get("sort_recipes").getAsBoolean();
    }

    public Configs.SearchMode getSearchMode() {
        String mode = config.getAsJsonObject("general").get("search_bar_mode").getAsString();
        return Configs.SearchMode.valueOf(mode);
    }

    public int getSearchBarThreshold() {
        return config.getAsJsonObject("general").get("search_bar_threshold").getAsInt();
    }

    public void setSortRecipes(boolean value) {
        config.getAsJsonObject("general").addProperty("sort_recipes", value);
        saveConfig();
    }

    public void setSearchMode(Configs.SearchMode mode) {
        config.getAsJsonObject("general").addProperty("search_bar_mode", mode.name());
        saveConfig();
    }

    public void setSearchBarThreshold(int threshold) {
        config.getAsJsonObject("general").addProperty("search_bar_threshold", threshold);
        saveConfig();
    }

    public void saveConfig() {
        Path configPath = this.getFullPath();  // Get the full path of the config file
        try (Writer writer = Files.newBufferedWriter(configPath)) {
            gson.toJson(config, writer);  // Write the config JSON to the file
        } catch (IOException e) {
            e.printStackTrace();  // Log any errors during file saving
        }
    }
}
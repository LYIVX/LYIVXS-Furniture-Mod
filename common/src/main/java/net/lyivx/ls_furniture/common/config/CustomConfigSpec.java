package net.lyivx.ls_furniture.common.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomConfigSpec {
    private final Gson gson;
    private JsonObject config;
    private final Path configPath;

    public CustomConfigSpec(Path configDirectory, String fileName) {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.config = new JsonObject();
        this.configPath = configDirectory.resolve(fileName + ".json");
        loadConfig();  // Load config at initialization
    }

    public void loadConfig() {
        try (Reader reader = Files.newBufferedReader(configPath)) {
            this.config = gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveConfig() {
        try (Writer writer = Files.newBufferedWriter(configPath)) {
            gson.toJson(config, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getSortRecipes() {
        JsonObject general = config.getAsJsonObject("general");
        if (general == null) {
            // Handle the case where "general" doesn't exist
            return false; // Or any default value you want
        }
        return general.get("sort_recipes").getAsBoolean();
    }

    public Configs.SearchMode getSearchMode() {
        JsonObject general = config.getAsJsonObject("general");
        if (general == null) {
            // Handle the case where "general" doesn't exist
            return Configs.SearchMode.AUTOMATIC; // Replace with your default mode
        }
        String mode = general.get("search_bar_mode").getAsString();
        return Configs.SearchMode.valueOf(mode);
    }

    public int getSearchBarThreshold() {
        JsonObject general = config.getAsJsonObject("general");
        if (general == null) {
            // Handle the case where "general" doesn't exist
            return 0; // Or your default threshold
        }
        return general.get("search_bar_threshold").getAsInt();
    }

    public void setSortRecipes(boolean value) {
        JsonObject general = config.getAsJsonObject("general");
        if (general == null) {
            general = new JsonObject(); // Initialize if null
            config.add("general", general); // Add it to the main config
        }
        general.addProperty("sort_recipes", value);
        saveConfig();
    }

    public void setSearchMode(Configs.SearchMode mode) {
        JsonObject general = config.getAsJsonObject("general");
        if (general == null) {
            general = new JsonObject();
            config.add("general", general);
        }
        general.addProperty("search_bar_mode", mode.name());
        saveConfig();
    }

    public void setSearchBarThreshold(int threshold) {
        JsonObject general = config.getAsJsonObject("general");
        if (general == null) {
            general = new JsonObject();
            config.add("general", general);
        }
        general.addProperty("search_bar_threshold", threshold);
        saveConfig();
    }
}

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
        this.configPath = configDirectory.resolve(fileName);
    }

    public void loadFromFile() {
        try (Reader reader = Files.newBufferedReader(this.configPath)) {
            this.config = gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void register() {
        if (!Files.exists(this.configPath)) {
            JsonObject general = new JsonObject();
            general.addProperty("sort_recipes", Configs.SORT_RECIPES);
            general.addProperty("search_bar_mode", Configs.SEARCH_MODE.name());
            general.addProperty("search_bar_threshold", Configs.SEARCH_BAR_THRESHOLD);

            config.add("general", general);

            saveConfig();
        }
    }

    public void saveConfig() {
        try (Writer writer = Files.newBufferedWriter(this.configPath)) {
            gson.toJson(config, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implement getter and setter methods as needed
}
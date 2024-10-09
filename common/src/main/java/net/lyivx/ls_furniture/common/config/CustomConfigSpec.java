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
        System.out.println("Config will be saved to: " + this.configPath.toAbsolutePath());
        loadOrCreateConfig();  // Load config at initialization
    }

    private void loadOrCreateConfig() {
        if (Files.exists(configPath)) {
            loadConfig();
        } else {
            createDefaultConfig();
            saveConfig();
        }
    }

    public void loadConfig() {
        try (Reader reader = Files.newBufferedReader(configPath)) {
            this.config = gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createDefaultConfig() {
        this.config = new JsonObject();
        JsonObject workstation = new JsonObject();
        workstation.addProperty("sort_recipes", true);
        workstation.addProperty("preview", true);
        workstation.addProperty("search_bar_mode", Configs.SearchMode.AUTOMATIC.name());
        workstation.addProperty("search_bar_threshold", 32);
        config.add("workstation", workstation);
    }

    public void saveConfig() {
        try {
            Files.createDirectories(configPath.getParent());  // Ensure the directory exists
            try (Writer writer = Files.newBufferedWriter(configPath)) {
                gson.toJson(config, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JsonObject getOrCreateWorkstation() {
        JsonObject workstation = config.getAsJsonObject("workstation");
        if (workstation == null) {
            workstation = new JsonObject();
            config.add("workstation", workstation);
        }
        return workstation;
    }

    public boolean getSortRecipes() {
        JsonObject workstation = config.getAsJsonObject("workstation");
        if (!workstation.has("sort_recipes")) {
            workstation.addProperty("sort_recipes", true);
            saveConfig();
        }
        return workstation.get("sort_recipes").getAsBoolean();
    }

    public boolean getPreview() {
        JsonObject workstation = config.getAsJsonObject("workstation");
        if (!workstation.has("preview")) {
            workstation.addProperty("preview", true);
            saveConfig();
        }
        return workstation.get("preview").getAsBoolean();
    }

    public Configs.SearchMode getSearchMode() {
        JsonObject workstation = config.getAsJsonObject("workstation");
        if (!workstation.has("search_bar_mode")) {
            workstation.addProperty("search_bar_mode", Configs.SearchMode.AUTOMATIC.name());
            saveConfig();
        }
        String mode = workstation.get("search_bar_mode").getAsString();
        return Configs.SearchMode.valueOf(mode);
    }

    public int getSearchBarThreshold() {
        JsonObject workstation = config.getAsJsonObject("workstation");
        if (!workstation.has("search_bar_threshold")) {
            workstation.addProperty("search_bar_threshold", 32);
            saveConfig();
        }
        return workstation.get("search_bar_threshold").getAsInt();
    }

    public void setSortRecipes(boolean value) {
        JsonObject workstation = getOrCreateWorkstation();
        workstation.addProperty("sort_recipes", value);
        saveConfig();
    }

    public void setPreview(boolean value) {
        JsonObject workstation = getOrCreateWorkstation();
        workstation.addProperty("preview", value);
        saveConfig();
    }

    public void setSearchMode(Configs.SearchMode mode) {
        JsonObject workstation = getOrCreateWorkstation();
        workstation.addProperty("search_bar_mode", mode.name());
        saveConfig();
    }

    public void setSearchBarThreshold(int threshold) {
        JsonObject workstation = getOrCreateWorkstation();
        workstation.addProperty("search_bar_threshold", threshold);
        saveConfig();
    }
}

package net.lyivx.ls_furniture.client.screens;

import net.lyivx.ls_furniture.common.config.Configs;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ConfigurationScreen extends Screen {
    private final Screen lastScreen;
    private CycleButton<Configs.SearchMode> searchModeButton;
    private CycleButton<Boolean> sortRecipesButton;
    private EditBox thresholdBox;

    private static final int MAX_THRESHOLD = 200; // Max threshold

    public ConfigurationScreen(Screen lastScreen) {
        super(Component.translatable("config.ls_furniture.title"));
        this.lastScreen = lastScreen;
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        // Sort Recipes Toggle Button
        this.sortRecipesButton = CycleButton.onOffBuilder(Configs.SORT_RECIPES)
                .create(centerX - 100, centerY - 60, 200, 20,
                        Component.translatable("config.ls_furniture.sort_recipes"),
                        (button, value) -> Configs.SORT_RECIPES = value);
        sortRecipesButton.setTooltip(Tooltip.create(Component.translatable("config.ls_furniture.sort_recipes.tooltip")));
        this.addRenderableWidget(sortRecipesButton);

        // Search Mode Cycle Button
        this.searchModeButton = CycleButton.<Configs.SearchMode>builder(mode ->
                        Component.translatable("config.ls_furniture.search_mode." + mode.name().toLowerCase()))
                .withValues(Configs.SearchMode.values())
                .withInitialValue(Configs.SEARCH_MODE)
                .create(centerX - 100, centerY - 30, 200, 20,
                        Component.translatable("config.ls_furniture.search_bar_mode"),
                        (button, value) -> Configs.SEARCH_MODE = value);
        this.addRenderableWidget(this.searchModeButton);

        // Threshold Edit Box
        this.thresholdBox = new EditBox(this.font, centerX - 100, centerY, 200, 20,
                Component.translatable("config.ls_furniture.search_bar_threshold"));
        this.thresholdBox.setValue(String.valueOf(Configs.SEARCH_BAR_THRESHOLD));
        this.thresholdBox.setFilter(s -> s.matches("\\d*"));
        this.addRenderableWidget(this.thresholdBox);

        // Save Button
        Button saveButton = Button.builder(Component.translatable("gui.done"), button -> {
            saveConfig();
            this.minecraft.setScreen(this.lastScreen);
        }).bounds(centerX - 100, centerY + 30, 200, 20).build();
        this.addRenderableWidget(saveButton);
    }

    private void saveConfig() {
        try {
            int threshold = Integer.parseInt(this.thresholdBox.getValue());
            Configs.SEARCH_BAR_THRESHOLD = Math.max(0, Math.min(threshold, 200));
        } catch (NumberFormatException e) {
            System.err.println("Invalid threshold value: " + this.thresholdBox.getValue());
        }

        Configs.saveConfig();  // Save the config
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFF);

        // Render tooltips manually based on mouse hover status
        if (this.sortRecipesButton.isHovered()) {
            sortRecipesButton.setTooltip(Tooltip.create(Component.translatable("config.ls_furniture.sort_recipes.tooltip")));
        }

        if (this.searchModeButton.isHovered()) {
            searchModeButton.setTooltip(Tooltip.create(Component.translatable("config.ls_furniture.search_bar_mode.tooltip")));
        }
        // Get the current value from the thresholdBox and check if it's over the max limit
        try {
            int threshold = Integer.parseInt(this.thresholdBox.getValue());
            if (threshold > MAX_THRESHOLD) {
                // Turn text red if the value exceeds the max limit
                this.thresholdBox.setTextColor(0xFF5555); // Red color for invalid input
            } else {
                this.thresholdBox.setTextColor(0xFFFFFF); // White color for valid input
            }
        } catch (NumberFormatException e) {
            // In case of invalid input (non-number), reset the text color to default
            this.thresholdBox.setTextColor(0xFF5555); // Keep it red for invalid input
        }

        // Render tooltip for the threshold box
        if (this.thresholdBox.isHovered()) {
            thresholdBox.setTooltip(Tooltip.create(Component.translatable("config.ls_furniture.search_bar_threshold.tooltip")));
        }
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(this.lastScreen);
    }
}
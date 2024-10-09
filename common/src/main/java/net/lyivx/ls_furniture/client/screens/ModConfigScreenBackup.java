package net.lyivx.ls_furniture.client.screens;

import net.lyivx.ls_furniture.client.screens.widgets.CategoryButton;
import net.lyivx.ls_furniture.client.screens.widgets.CustomCheckbox;
import net.lyivx.ls_furniture.client.screens.widgets.ThresholdSlider;
import net.lyivx.ls_furniture.common.config.Configs;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public class ModConfigScreenBackup extends Screen {
    private static final Component TITLE = Component.translatable("options.videoTitle");
    private final Screen parent;
    private List<CategoryButton> categoryButtons;
    private ConfigPanel currentPanel;
    private Button doneButton;
    private Button saveButton;
    private Button resetButton;
    private CategoryType currentCategory = CategoryType.GENERAL;

    public ModConfigScreenBackup(Screen parent) {
        super(Component.literal("Mod Configuration"));
        this.parent = parent;
        this.categoryButtons = new ArrayList<>(); // Initialize the list in the constructor
    }

    private enum CategoryType {
        GENERAL, WORKSTATION, MISC
    }

    @Override
    protected void init() {
        this.clearWidgets();

        int buttonWidth = 100;
        int buttonHeight = 20;
        int startX = 10;
        int startY = 50;

        // Create category buttons
        this.categoryButtons.clear();
        this.categoryButtons.add(new CategoryButton(
                startX, startY, buttonWidth, buttonHeight,
                Component.literal("General"), button -> switchCategory(CategoryType.GENERAL),
                currentCategory == CategoryType.GENERAL));
        this.categoryButtons.add(new CategoryButton(
                startX, startY + buttonHeight + 5, buttonWidth, buttonHeight,
                Component.literal("Workstation"), button -> switchCategory(CategoryType.WORKSTATION),
                currentCategory == CategoryType.WORKSTATION));
        this.categoryButtons.add(new CategoryButton(
                startX, startY + (buttonHeight + 5) * 2, buttonWidth, buttonHeight,
                Component.literal("Misc"), button -> switchCategory(CategoryType.MISC),
                currentCategory == CategoryType.MISC));

        for (CategoryButton button : this.categoryButtons) {
            this.addRenderableWidget(button);
        }

        this.doneButton = (Button.builder(Component.literal("Done"),
                        button -> this.minecraft.setScreen(this.parent))
                .bounds(startX, this.height - 30, 90, 20).build());
        this.addWidget(doneButton);

        this.saveButton = (Button.builder(Component.literal("Save"),
                        button -> saveConfig())
                .bounds(startX + 47, this.height - 55, 43, 20).build());
        this.addWidget(saveButton);

        this.resetButton = (Button.builder(Component.literal("Reset"),
                button -> {
                    if (this.currentPanel != null) {
                        this.currentPanel.resetToDefaults();
                    }
                    saveConfig();
                })
                .bounds(startX, this.height - 55, 43, 20).build());
        this.addWidget(resetButton);

        if (this.currentPanel == null) {
            switchCategory(CategoryType.GENERAL);
        } else {
            this.currentPanel.init(this);
        }
    }

    private void switchCategory(CategoryType category) {
        this.currentCategory = category; // Update the current category
        updateSelectedButton();
        switch (category) {
            case GENERAL:
                this.currentPanel = new GeneralConfigPanel();
                break;
            case WORKSTATION:
                this.currentPanel = new WorkstationConfigPanel();
                break;
            case MISC:
                this.currentPanel = new MiscConfigPanel();
                break;
        }
        updateCurrentPanel();
    }

    private void updateSelectedButton() {
        for (int i = 0; i < this.categoryButtons.size(); i++) {
            this.categoryButtons.get(i).setSelected(CategoryType.values()[i] == currentCategory);
        }
    }

    private void updateCurrentPanel() {
        this.clearWidgets();
        this.init();
    }

    private void saveConfig() {
        if (this.currentPanel != null) {
            this.currentPanel.saveConfig();
        }
        Configs.saveConfig();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        if (this.currentPanel != null) {
            this.currentPanel.render(guiGraphics, mouseX, mouseY, partialTick);
        }
        this.doneButton.render(guiGraphics, mouseX, mouseY, partialTick);
        this.saveButton.render(guiGraphics, mouseX, mouseY, partialTick);
        this.resetButton.render(guiGraphics, mouseX, mouseY, partialTick);
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFF);
    }

    private abstract class ConfigPanel {
        protected final List<AbstractWidget> widgets = new ArrayList<>();

        public abstract void init(ModConfigScreenBackup parent);

        public abstract void resetToDefaults();

        public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            for (AbstractWidget widget : this.widgets) {
                widget.render(guiGraphics, mouseX, mouseY, partialTick);
            }
        }

        protected void addWidget(AbstractWidget widget) {
            this.widgets.add(widget);
            ModConfigScreenBackup.this.addRenderableWidget(widget);
        }

        public abstract void saveConfig();
    }

    private class GeneralConfigPanel extends ConfigPanel {
        @Override
        public void init(ModConfigScreenBackup parent) {
            this.widgets.clear();
            this.addWidget(Button.builder(Component.literal("General Config Option"), b -> {})
                    .bounds(130, 50, 200, 20).build());
        }

        @Override
        public void resetToDefaults() {
            // Reset general config options to their defaults
            // Update UI components
            this.init(ModConfigScreenBackup.this);
        }

        @Override
        public void saveConfig() {
            // Save general config
        }
    }

    public class WorkstationConfigPanel extends ConfigPanel {
        private CycleButton<Configs.SearchMode> searchModeButton;
        private CustomCheckbox sortRecipesButton;
        private ThresholdSlider thresholdSlider;
        private static final int MAX_THRESHOLD = ThresholdSlider.MAX_THRESHOLD;

        @Override
        public void init(ModConfigScreenBackup parent) {
            int startX = 130;
            int startY = 50;

            this.sortRecipesButton = new CustomCheckbox.Builder()
                    .pos(startX, startY)
                    .size(20, 20)
                    .message(Component.translatable("config.ls_furniture.sort_recipes"))
                    .selected(Configs.SORT_RECIPES)
                    .onValueChange((checkbox, selected) -> Configs.SORT_RECIPES = selected)
                    .build();
            this.sortRecipesButton.setTooltip(Tooltip.create(Component.translatable("config.ls_furniture.sort_recipes.tooltip")));
            this.addWidget(this.sortRecipesButton);

            this.searchModeButton = CycleButton.<Configs.SearchMode>builder(
                            mode -> Component.translatable("config.ls_furniture.search_mode." + mode.name().toLowerCase()))
                    .withInitialValue(Configs.SEARCH_MODE)
                    .withValues(List.of(Configs.SearchMode.values()))
                    .create(startX, startY + 25, 200, 20,
                            Component.translatable("config.ls_furniture.search_bar_mode"),
                            (button, value) -> Configs.SEARCH_MODE = value
                    );
            this.addWidget(this.searchModeButton);

            this.thresholdSlider = new ThresholdSlider(
                    startX, startY + 50, 200, 20,
                    Component.translatable("config.ls_furniture.search_bar_threshold"),
                    (double) Configs.SEARCH_BAR_THRESHOLD / MAX_THRESHOLD
            );
            this.addWidget(this.thresholdSlider);
        }

        @Override
        public void resetToDefaults() {
            Configs.SORT_RECIPES = true;
            Configs.SEARCH_MODE = Configs.SearchMode.AUTOMATIC;
            Configs.SEARCH_BAR_THRESHOLD = 32;

            // Update UI components
            this.sortRecipesButton.setSelected(Configs.SORT_RECIPES);
            this.searchModeButton.setValue(Configs.SEARCH_MODE);
            this.thresholdSlider.setValueFromThreshold(Configs.SEARCH_BAR_THRESHOLD);
        }

        @Override
        public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            super.render(guiGraphics, mouseX, mouseY, partialTick);

            if (this.sortRecipesButton.isHovered()) {
                sortRecipesButton.setTooltip(Tooltip.create(Component.translatable("config.ls_furniture.sort_recipes.tooltip")));
            }

            if (this.searchModeButton.isHovered()) {
                searchModeButton.setTooltip(Tooltip.create(Component.translatable("config.ls_furniture.search_bar_mode.tooltip")));
            }

            if (this.thresholdSlider.isHovered()) {
                thresholdSlider.setTooltip(Tooltip.create(Component.translatable("config.ls_furniture.search_bar_threshold.tooltip")));
            }
        }

        @Override
        public void saveConfig() {
            Configs.SEARCH_BAR_THRESHOLD = this.thresholdSlider.getThreshold();
        }
    }

    private class MiscConfigPanel extends ConfigPanel {
        @Override
        public void init(ModConfigScreenBackup parent) {
            this.widgets.clear();
            this.addWidget(Button.builder(Component.literal("Misc Config Option"), b -> {})
                    .bounds(130, 50, 200, 20).build());
        }

        @Override
        public void resetToDefaults() {
            // Reset misc config options to their defaults
            // Update UI components
            this.init(ModConfigScreenBackup.this);
        }

        @Override
        public void saveConfig() {
            // Save misc config
        }
    }
}
package net.lyivx.ls_furniture.client.screens;

import com.mojang.serialization.Codec;
import net.lyivx.ls_furniture.client.screens.widgets.CustomOptionsList;
import net.minecraft.ChatFormatting;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import net.minecraft.network.chat.Component;
import net.lyivx.ls_furniture.common.config.Configs;
import net.lyivx.ls_furniture.client.screens.widgets.CustomCheckbox;
import net.lyivx.ls_furniture.client.screens.widgets.ThresholdSlider;
import net.minecraft.client.Options;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static net.minecraft.util.CommonColors.*;

public class ModConfigScreen extends OptionsSubScreen {
    private static final Component TITLE = Component.translatable("config.ls_furniture.title");
    private List<Button> categoryButtons;
    private CustomOptionsList list;
    private Button doneButton;
    private Button resetButton;
    private CategoryType currentCategory;

    public ModConfigScreen(Screen lastScreen, Options options, CategoryType initialCategory) {
        super(lastScreen, options, TITLE);
        this.categoryButtons = new ArrayList<>();
        this.currentCategory = initialCategory;
    }

    public enum CategoryType {
        GENERAL, WORKSTATION, MISC
    }

    @Override
    protected void init() {
        super.init();

        this.list = new CustomOptionsList(this.minecraft, this.width - 155, this);
        this.list.setX(155);
        this.addWidget(this.list);

        addOptions();
        switchCategory(this.currentCategory);
        addFooter();

    }

    @Override
    protected void addOptions() {
        createCategoryButtons();
    }

    private void createCategoryButtons() {
        int buttonWidth = 125;
        int buttonHeight = 20;
        int startX = 20;
        int startY = 40;

        // Create category buttons
        this.categoryButtons.clear();
        this.categoryButtons.add(this.addRenderableWidget(Button.builder(Component.literal("General"),
                        button -> switchCategory(CategoryType.GENERAL))
                .bounds(startX, startY, buttonWidth, buttonHeight).build()));
        this.categoryButtons.add(this.addRenderableWidget(Button.builder(Component.literal("Workstation"),
                        button -> switchCategory(CategoryType.WORKSTATION))
                .bounds(startX, startY + buttonHeight + 5, buttonWidth, buttonHeight).build()));
        this.categoryButtons.add(this.addRenderableWidget(Button.builder(Component.literal("Misc"),
                        button -> switchCategory(CategoryType.MISC))
                .bounds(startX, startY + (buttonHeight + 5) * 2, buttonWidth, buttonHeight).build()));
    }

    protected void addFooter() {
        LinearLayout linearLayout = (LinearLayout)this.layout.addToFooter(LinearLayout.horizontal().spacing(8));
        linearLayout.addChild(Button.builder(Component.literal("Reset"), button -> resetConfig()).build());
        linearLayout.addChild(Button.builder(Component.translatable("gui.done"), button -> this.minecraft.setScreen(this.lastScreen)).build());
    }

    private void switchCategory(CategoryType category) {
        this.currentCategory = category;
        this.list.children().clear();
        switch (category) {
            case GENERAL:
                addGeneralOptions();
                break;
            case WORKSTATION:
                addWorkstationOptions();
                break;
            case MISC:
                addMiscOptions();
                break;
        }
    }

    private void addGeneralOptions() {
        this.list.addTitle(Component.translatable("config.ls_furniture.category.general"));

    }

    private void addWorkstationOptions() {
        this.list.addTitle(Component.translatable("config.ls_furniture.category.workstation"));

        // Button For Sort Recipes
        OptionInstance<Boolean> sortRecipesOption = OptionInstance.createBoolean(
                "config.ls_furniture.sort_recipes",
                OptionInstance.cachedConstantTooltip(Component.translatable("config.ls_furniture.sort_recipes.tooltip")),
                Configs.SORT_RECIPES,
                (value) -> {
                    Configs.SORT_RECIPES = value;
                    saveConfig();
                }
        );

        // Button For Preview
        OptionInstance<Boolean> previewOption = OptionInstance.createBoolean(
                "config.ls_furniture.preview",
                OptionInstance.cachedConstantTooltip(Component.translatable("config.ls_furniture.preview.tooltip")),
                Configs.PREVIEW,
                (value) -> {
                    Configs.PREVIEW = value;
                    saveConfig();
                }
        );

        // Button For Search Mode
        OptionInstance<Configs.SearchMode> searchModeOption = new OptionInstance<>(
                "config.ls_furniture.search_bar_mode",
                OptionInstance.cachedConstantTooltip(Component.translatable("config.ls_furniture.search_bar_mode.tooltip")),
                (component, value) -> Component.literal(value.toString()),
                new OptionInstance.Enum<>(
                        Arrays.asList(Configs.SearchMode.values()),
                        Codec.INT.xmap(
                                id -> Configs.SearchMode.values()[id],
                                mode -> Arrays.asList(Configs.SearchMode.values()).indexOf(mode)
                        )
                ),
                Configs.SEARCH_MODE,
                (value) -> {
                    Configs.SEARCH_MODE = value;
                    Configs.saveConfig();
                }
        );

        // Slider For Search Bar Threshold
        OptionInstance<Integer> searchBarThresholdOption = new OptionInstance<>(
                "config.ls_furniture.search_bar_threshold",
                OptionInstance.cachedConstantTooltip(Component.translatable("config.ls_furniture.search_bar_threshold.tooltip")),
                (component, value) -> Component.literal(component.getString() + ": " + value),
                new OptionInstance.IntRange(0, 100),
                Configs.SEARCH_BAR_THRESHOLD,
                (value) -> {
                    Configs.SEARCH_BAR_THRESHOLD = value;
                    saveConfig();
                }
        );

        this.list.addSmall(searchModeOption, searchBarThresholdOption, sortRecipesOption, previewOption);
    }

    private void addMiscOptions() {
        this.list.addTitle(Component.translatable("config.ls_furniture.category.misc"));

    }

    private void saveConfig() {
        Configs.saveConfig();
    }

    private void resetConfig() {
        switch (this.currentCategory) {
            case GENERAL:
                resetGeneralConfig();
                break;
            case WORKSTATION:
                resetWorkstationConfig();
                break;
            case MISC:
                resetMiscConfig();
                break;
        }
        switchCategory(this.currentCategory); // Refresh the current category
        saveConfig();
    }

    private void resetGeneralConfig() {
        // Reset general config options to their defaults
        // For example:
        // Configs.GENERAL_OPTION = Configs.DEFAULT_GENERAL_OPTION;
    }

    private void resetWorkstationConfig() {
        Configs.SORT_RECIPES = true; // Assuming true is the default
        Configs.PREVIEW = true; // Assuming true is the default
        Configs.SEARCH_MODE = Configs.SearchMode.AUTOMATIC; // Assuming AUTOMATIC is the default
        Configs.SEARCH_BAR_THRESHOLD = 32; // Assuming 32 is the default
    }

    private void resetMiscConfig() {
        // Reset misc config options to their defaults
        // For example:
        // Configs.MISC_OPTION = Configs.DEFAULT_MISC_OPTION;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.list.render(guiGraphics, mouseX, mouseY, partialTick);

        guiGraphics.fill(155 - 1, 32, 155, this.height - 32, GRAY);

        for (Button button : this.categoryButtons) {
            button.render(guiGraphics, mouseX, mouseY, partialTick);
        }
    }
}
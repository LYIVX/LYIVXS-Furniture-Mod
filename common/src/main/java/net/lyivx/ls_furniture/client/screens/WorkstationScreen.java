package net.lyivx.ls_furniture.client.screens;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.client.screens.widgets.HoverImageButton;
import net.lyivx.ls_furniture.common.config.Configs;
import net.lyivx.ls_furniture.common.menus.WorkstationMenu;
import net.lyivx.ls_furniture.common.recipes.FilterableRecipe;
import net.lyivx.ls_furniture.registry.ModSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class WorkstationScreen extends AbstractContainerScreen<WorkstationMenu> {
    private static final ResourceLocation BACKGROUND = LYIVXsFurnitureMod.res("textures/gui/container/workstation.png");
    private static final ResourceLocation BACKGROUND_SEARCH = LYIVXsFurnitureMod.res("textures/gui/container/workstation_search.png");
    private static final ResourceLocation RECIPE_BUTTON_LOCATION = new ResourceLocation("textures/gui/recipe_button.png");
    private static final ResourceLocation CONFIG_ICON = LYIVXsFurnitureMod.res("textures/gui/workstation_config_button.png");

    private final RecipeBookComponent recipeBookComponent = new RecipeBookComponent();

    private float scrollOffs;
    private boolean scrolling;
    private int startIndex;
    private boolean displayRecipes;

    private EditBox searchBox;

    private final List<FilterableRecipe> filteredRecipes = new ArrayList<>();
    private int filteredIndex = -1;

    private HoverImageButton gearButton;

    public WorkstationScreen(WorkstationMenu workstationMenu, Inventory inventory, Component component) {
        super(workstationMenu, inventory, component);
        workstationMenu.registerUpdateListener(this::containerChanged);
        --this.titleLabelY;
    }

    @Override
    protected void init() {
        super.init();

        int boxX = this.leftPos + (41);
        int boxY = this.topPos + 15;
        this.searchBox = new EditBox(this.font, boxX, boxY, 69, 9, Component.translatable("itemGroup.search"));
        this.searchBox.setMaxLength(50);
        this.searchBox.setBordered(false);
        this.searchBox.setFocused(false);
        this.searchBox.setEditable(false);
        this.searchBox.setTextColor(16777215);
        this.searchBox.setResponder(s -> this.refreshSearchResults());
        this.addRenderableWidget(this.searchBox);

        this.gearButton = this.addRenderableWidget(new HoverImageButton(
                this.leftPos + 158, //144
                this.topPos + this.imageHeight - 160, //110
                12, 10,
                0, 0, 12,
                CONFIG_ICON,
                24, 10,
                12, 10,
                button -> {
                    // Open configuration screen
                    this.minecraft.setScreen(new ConfigurationScreen(this));
                }
                ));


        updateSearchBarVisibility();
    }

    private void updateSearchBarVisibility() {
        boolean hasSearch = Configs.hasSearchBar(menu.getRecipes().size());
        this.searchBox.visible = hasSearch;
        this.searchBox.active = hasSearch;
    }

    @Override
    protected void containerTick() {
        super.containerTick();
        if (searchBox.visible) this.searchBox.tick();

    }

    private void refreshSearchResults() {
        int oldSize = filteredRecipes.size();
        this.filteredRecipes.clear();
        boolean isFiltered = searchBox.visible && !searchBox.getValue().equals("");
        for (var r : this.menu.getRecipes()) {
            if (!isFiltered || r.matchFilter(searchBox.getValue())) {
                this.filteredRecipes.add(r);
            }
        }
        if (oldSize != filteredRecipes.size()) {
            //only reset if the filtered list changed
            this.scrollOffs = 0;
            this.startIndex = 0;
        }

        updateSelectedIndex();
        // this makes it so after we typed something, the current result is reset as we are unselecting all clicked stuff
        // only clear if we cant keep selecting the old one
        if (filteredIndex == -1 && this.menu.getSelectedRecipeIndex() != -1
                && this.menu.clickMenuButton(minecraft.player, -1)) {
            //also send a packet to servers to unselect
            this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, -1);
        }

        updateSearchBarVisibility();
    }

    private void updateSelectedIndex() {
        filteredIndex = -1;
        int selectedInd = this.menu.getSelectedRecipeIndex();
        var recipes = this.menu.getRecipes();
        if (selectedInd > -1 && selectedInd < recipes.size()) {
            filteredIndex = filteredRecipes.indexOf(recipes.get(selectedInd));
        }
    }

    @Override
    public void resize(Minecraft minecraft, int width, int height) {
        // same as creative tab one
        String string = this.searchBox.getValue();
        this.init(minecraft, width, height);
        this.searchBox.setValue(string);
        this.containerChanged();
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        String string = this.searchBox.getValue();
        if (this.searchBox.visible && this.searchBox.keyPressed(keyCode, scanCode, modifiers)) {
            if (!Objects.equals(string, this.searchBox.getValue())) {
                this.refreshSearchResults();
            }

            return true;
        } else {
            return this.searchBox.isFocused() && this.searchBox.isVisible() && keyCode != 256 ? true : super.keyPressed(keyCode, scanCode, modifiers);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        this.renderBackground(guiGraphics);

        ResourceLocation bgLocation = getBgLocation();
        guiGraphics.blit(bgLocation, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        // scrollbar
        int barH = scrollBarHeight();
        int scrollY = minScrollY();
        float barSpan = maxScrollY() - scrollY - barH;
        int barPos = (int) (barSpan * this.scrollOffs);

        guiGraphics.blit(bgLocation, minScrollX(), scrollY + barPos, 176 + (this.isScrollBarActive() ? 0 : 12), 0, 12, barH);

        if (!displayRecipes) return;

        // buttons
        forEachButton((index, buttonX, buttonY) -> {
            int textureY = this.imageHeight;
            if (index == filteredIndex) {
                textureY += 18;
            } else if (mouseX >= buttonX && mouseY >= buttonY && mouseX < buttonX + 16 && mouseY < buttonY + 18) {
                textureY += 36;
            }
            guiGraphics.blit(BACKGROUND, buttonX, buttonY, 0, textureY, 16, 18);
        });

        // items
        forEachButton((index, buttonX, buttonY) -> {
            ItemStack item = filteredRecipes.get(index).recipe().getResultItem(this.minecraft.level.registryAccess());
            guiGraphics.renderFakeItem(item, buttonX, buttonY + 1);
            guiGraphics.renderItemDecorations(font, item, buttonX, buttonY + 1);
        });
    }

    @NotNull
    private ResourceLocation getBgLocation() {
        return searchBox.visible ? BACKGROUND_SEARCH : BACKGROUND;
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderTooltip(guiGraphics, mouseX, mouseY);
        if (this.displayRecipes) {
            forEachButton((index, buttonX, buttonY) -> {
                if (mouseX >= buttonX && mouseX < buttonX + 16 && mouseY >= buttonY && mouseY < buttonY + 18) {
                    guiGraphics.renderTooltip(this.font, (filteredRecipes.get(index)).recipe()
                            .getResultItem(this.minecraft.level.registryAccess()), mouseX, mouseY);
                }
            });
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderLabels(guiGraphics, mouseX, mouseY);
        if (filteredIndex >= 0 && filteredIndex < filteredRecipes.size()) {
            int input = filteredRecipes.get(filteredIndex).recipe().getInputCount();
            if (input != 1) {
                String multiplier = input + "x";
                int labelX = this.titleLabelX + (-4);
                guiGraphics.drawString(this.font, multiplier, labelX, this.titleLabelY + 37, 4210752, false);
            }
        }
    }

    private int buttonCount() {
        return getRows() * buttonsPerRow();
    }

    private int buttonsPerRow() {
        return 5;
    }

    private int getRows() {
        return searchBox.visible ? 2 : 3;
    }

    private int minScrollX() {
        return this.leftPos + (123);
    }

    private int maxScrollX() {
        return minScrollX() + 12;
    }

    private int minScrollY() {
        return this.topPos + (searchBox.visible ? 29 : 15);
    }

    private int maxScrollY() {
        return this.topPos + (searchBox.visible ? 29 + 36 : 15 + 55);
    }

    private int scrollBarHeight() {
        return searchBox.visible ? 11 : 15;
    }

    private void forEachButton(ButtonConsumer buttonConsumer) {
        int buttonBoxX = this.leftPos + (40);
        int buttonBoxY = this.topPos + (searchBox.visible ? 27 : 13);
        int lastVisibleElementIndex = this.startIndex + buttonCount();
        int buttonsPerRow = buttonsPerRow();
        for (int index = this.startIndex; index < lastVisibleElementIndex && index < filteredRecipes.size(); ++index) {
            int visualIndex = index - this.startIndex;
            int buttonX = buttonBoxX + (visualIndex % buttonsPerRow) * 16;
            int buttonY = buttonBoxY + (visualIndex / buttonsPerRow) * 18 + 2;
            buttonConsumer.accept(index, buttonX, buttonY);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.scrolling = false;
        if (this.displayRecipes) {
            AtomicReference<Boolean> success = new AtomicReference<>(false);
            forEachButton((index, buttonX, buttonY) -> {
                if (success.get()) return;
                int actualIndex = menu.getRecipes().indexOf(filteredRecipes.get(index));
                if (mouseX >= buttonX && mouseX < buttonX + 16 && mouseY >= buttonY && mouseY < buttonY + 18) {
                    if (this.menu.clickMenuButton(this.minecraft.player, actualIndex)) {
                        Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(ModSoundEvents.WORKSTATION_SELECT.get(), 1.0F));
                        this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, actualIndex);
                        updateSelectedIndex();
                    }
                    success.set(true);
                }
            });

            if (success.get()) return true;

            if (mouseX >= minScrollX() && mouseX < maxScrollX() && mouseY >= minScrollY() && mouseY < maxScrollY()) {
                this.scrolling = true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    protected boolean hasClickedOutside(double mouseX, double mouseY, int left, int top, int button) {
        boolean flag = mouseX < (double)left || mouseY < (double)top || mouseX >= (double)(left + this.imageWidth) || mouseY >= (double)(top + this.imageHeight);
        return this.recipeBookComponent.hasClickedOutside(mouseX, mouseY, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, button) && flag;
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (this.scrolling && this.isScrollBarActive()) {
            int min = minScrollY();
            int max = maxScrollY();
            this.scrollOffs = ((float) mouseY - min - 7.5F) / ((max - min) - 15.0F);
            this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0F, 1.0F);
            this.startIndex = (int) ((this.scrollOffs * this.getOffscreenRows()) + 0.5) * 5;
            return true;
        } else {
            return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        if (this.isScrollBarActive()) {
            int offscreenRows = this.getOffscreenRows();
            float f = (float) delta / offscreenRows;
            this.scrollOffs = Mth.clamp(this.scrollOffs - f, 0.0F, 1.0F);
            this.startIndex = (int) ((this.scrollOffs * offscreenRows) + 0.5) * 5;
        }

        return true;
    }

    private boolean isScrollBarActive() {
        return this.displayRecipes && filteredRecipes.size() > buttonCount();
    }

    protected int getOffscreenRows() {
        return (filteredRecipes.size() + 4 - 1) / 4 - getRows();
    }

    private void containerChanged() {
        this.displayRecipes = this.menu.hasInputItem();
        if (!this.displayRecipes) {
            this.scrollOffs = 0.0F;
            this.startIndex = 0;
            this.searchBox.setValue("");
        } else this.setFocused(searchBox);
        this.searchBox.setEditable(displayRecipes);
        this.searchBox.setFocused(displayRecipes);

        //recipes could have changed here so we need to refresh
        this.refreshSearchResults();
    }

    private interface ButtonConsumer {
        void accept(int index, int buttonX, int buttonY);
    }
}
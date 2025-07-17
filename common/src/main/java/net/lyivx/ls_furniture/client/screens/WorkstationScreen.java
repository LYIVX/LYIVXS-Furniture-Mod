package net.lyivx.ls_furniture.client.screens;

import com.mojang.blaze3d.vertex.PoseStack;
import net.lyivx.ls_core.client.screens.ModConfigScreen;
import net.lyivx.ls_furniture.client.screens.widgets.FakeLevel;
import net.lyivx.ls_furniture.client.screens.widgets.HoverImageButton;
import net.lyivx.ls_furniture.client.screens.widgets.RenderWindowWidget;
import net.lyivx.ls_furniture.common.blocks.ModBedBlock;
import net.lyivx.ls_furniture.common.blocks.WardrobeBlock;
import net.lyivx.ls_furniture.common.menus.WorkstationMenu;
import net.lyivx.ls_furniture.common.recipes.FilterableRecipe;
import net.lyivx.ls_furniture.config.ConfigProvider;
import net.lyivx.ls_furniture.registry.ModSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;
import static net.minecraft.util.CommonColors.WHITE;

public class WorkstationScreen extends AbstractContainerScreen<WorkstationMenu> {
    private static final ResourceLocation BACKGROUND = createResourceLocation("textures/gui/container/workstation.png");
    private static final ResourceLocation BACKGROUND_SEARCH = createResourceLocation("textures/gui/container/workstation_search.png");
    private static final ResourceLocation PREVIEW_TAB = createResourceLocation("textures/gui/container/widgets/workstation_preview.png");
    private static final ResourceLocation NO_PREVIEW_TAB = createResourceLocation("textures/gui/container/widgets/workstation_no_preview.png");
    private static final ResourceLocation RECIPE_BUTTON_LOCATION = createResourceLocation("textures/gui/recipe_button.png");
    private static final ResourceLocation CONFIG_ICON_BUTTON = createResourceLocation("textures/gui/container/widgets/workstation_config_button.png");
    private static final ResourceLocation ARROW_ICON_BUTTON = createResourceLocation("textures/gui/container/widgets/workstation_arrow_button.png");
    public static final ResourceLocation SINGLE_BLOCK_BUTTON = (createResourceLocation("textures/gui/container/widgets/workstation_single_block_button.png"));
    public static final ResourceLocation L_SHAPE_BLOCK_BUTTON = (createResourceLocation("textures/gui/container/widgets/workstation_l_shape_block_button.png"));
    public static final ResourceLocation VERTICAL_BLOCK_BUTTON = (createResourceLocation("textures/gui/container/widgets/workstation_vertical_block_button.png"));
    public static final ResourceLocation HORIZONTAL_BLOCK = (createResourceLocation("textures/gui/container/widgets/workstation_horizontal_block_button.png"));
    public static final ResourceLocation TWO_BY_TWO_BLOCK_BUTTON = (createResourceLocation("textures/gui/container/widgets/workstation_two_by_two_block_button.png"));

    private static final Component CONFIG_TEXT = Component.translatable("container.ls_furniture.workstation.config");
    private static final Component PREVIEW_TEXT_OPEN = Component.translatable("container.ls_furniture.workstation.preview.open");
    private static final Component PREVIEW_TEXT_CLOSE = Component.translatable("container.ls_furniture.workstation.preview.close");
    private static final Component PREVIEW_TITLE_TEXT = Component.translatable("container.ls_furniture.workstation.preview.title");
    private static final Component NO_PREVIEW_TITLE_TEXT = Component.translatable("container.ls_furniture.workstation.no_preview.title");
    private static final Component SINGLE_BLOCK_TEXT = Component.translatable("container.ls_furniture.workstation.single_block");
    private static final Component L_SHAPE_BLOCK_TEXT = Component.translatable("container.ls_furniture.workstation.l_shape_block");
    private static final Component VERTICAL_BLOCK_TEXT = Component.translatable("container.ls_furniture.workstation.vertical_block");
    private static final Component HORIZONTAL_BLOCK_TEXT = Component.translatable("container.ls_furniture.workstation.horizontal_block");
    private static final Component TWO_BY_TWO_BLOCK_TEXT = Component.translatable("container.ls_furniture.workstation.two_by_two_block");

    private float scrollOffs;
    private boolean scrolling;
    private int startIndex;
    private boolean displayRecipes;
    private boolean showPreview = true;

    private EditBox searchBox;

    private final List<FilterableRecipe> filteredRecipes = new ArrayList<>();
    private int filteredIndex = -1;

    private HoverImageButton gearButton;
    private HoverImageButton previewButton;
    private HoverImageButton singleBlockButton;
    private HoverImageButton lShapeBlockButton;
    private HoverImageButton verticalBlockButton;
    private HoverImageButton horizontalBlockButton;
    private HoverImageButton twoByTwoBlockButton;

    public static RenderWindowWidget.Mode currentMode = RenderWindowWidget.Mode.SINGLE_BLOCK;
    public static boolean showPreviewStatic = true; // Add this new static field
    private RenderWindowWidget renderWindowWidget;
    private final FakeLevel fakeLevel = new FakeLevel();

    public WorkstationScreen(WorkstationMenu workstationMenu, Inventory inventory, Component component) {
        super(workstationMenu, inventory, component);
        workstationMenu.registerUpdateListener(this::containerChanged);
        --this.titleLabelY;
        this.showPreview = showPreviewStatic; // Initialize instance variable from static
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
                this.leftPos + 158,
                this.topPos + this.imageHeight - 160,
                12, 10,
                0, 0, 12,
                CONFIG_ICON_BUTTON,
                24, 10,
                12, 10,
                button -> {
                    // Open configuration screen
                    this.minecraft.setScreen(new ModConfigScreen(this, this.minecraft.options, ConfigProvider.PROVIDER_ID));
                },
                false,
                false
        ));
        this.gearButton.setTooltip(Tooltip.create(CONFIG_TEXT));

        if (ConfigProvider.shouldShowPreview()) {
            int buttonWidth = 20;
            int buttonHeight = 21;
            int textureWidth = 80;

            this.previewButton = this.addRenderableWidget(new HoverImageButton(
                    0, 0, buttonWidth, buttonHeight, 0, 0, buttonWidth,
                    ARROW_ICON_BUTTON,
                    textureWidth, buttonHeight,
                    buttonWidth, buttonHeight,
                    button -> {
                        this.showPreview = !this.showPreview;  // Toggle the state
                        showPreviewStatic = this.showPreview;  // Update the static state
                        this.previewButton.setStayClicked(this.showPreview);  // Update button state
                        updatePreviewVisibility();  // Update UI based on new state
                        assert this.minecraft != null;
                        this.minecraft.setScreen(this);
                    },
                    this.showPreview,
                    true
            ));
            if (!showPreview) {
                this.previewButton.setTooltip(Tooltip.create(PREVIEW_TEXT_OPEN));
            } else {
                this.previewButton.setTooltip(Tooltip.create(PREVIEW_TEXT_CLOSE));
            }

            updatePreviewButtonPosition(); // Set the initial position
            updatePreviewVisibility();
        }
        updateSearchBarVisibility();
    }

    private void updatePreviewButtonPosition() {
        int baseX = this.showPreview ? this.leftPos - 131 : this.leftPos - 20;
        int baseY = this.topPos + 5;
        this.previewButton.setX(baseX);
        this.previewButton.setY(baseY);
    }

    private void updatePreviewVisibility() {
        if (this.showPreview) {
            previewTab();
        } else {
            hidePreviewTab();
        }
        updateSearchBarVisibility();
    }

    private void hidePreviewTab() {
        this.removeWidget(this.singleBlockButton);
        this.removeWidget(this.lShapeBlockButton);
        this.removeWidget(this.verticalBlockButton);
        this.removeWidget(this.horizontalBlockButton);
        this.removeWidget(this.twoByTwoBlockButton);
        this.removeWidget(this.renderWindowWidget);
    }

    private void previewTab() {
        int baseX = this.leftPos - 22;
        int baseY = this.topPos + 93;
        int buttonWidth = 20;
        int buttonHeight = 21;
        int textureWidth = 60;

        this.singleBlockButton = this.addRenderableWidget(new HoverImageButton(
                baseX,
                baseY,
                buttonWidth, buttonHeight,
                0, 0, buttonWidth,
                SINGLE_BLOCK_BUTTON,
                textureWidth, buttonHeight,
                buttonWidth, buttonHeight,
                button -> {
                    setMode(RenderWindowWidget.Mode.SINGLE_BLOCK);
                    updateBlockPreview();
                    this.rebuildWidgets();
                },
                currentMode == RenderWindowWidget.Mode.SINGLE_BLOCK,
                false
        ));
        this.singleBlockButton.setTooltip(Tooltip.create(SINGLE_BLOCK_TEXT));

        this.lShapeBlockButton = this.addRenderableWidget(new HoverImageButton(
                baseX - buttonWidth - 1,
                baseY,
                buttonWidth, buttonHeight,
                0, 0, buttonWidth,
                L_SHAPE_BLOCK_BUTTON,
                textureWidth, buttonHeight,
                buttonWidth, buttonHeight,
                button -> {
                    setMode(RenderWindowWidget.Mode.L_SHAPE_BLOCK);
                    updateBlockPreview();
                    this.rebuildWidgets();
                },
                currentMode == RenderWindowWidget.Mode.L_SHAPE_BLOCK,
                false
        ));
        this.lShapeBlockButton.setTooltip(Tooltip.create(L_SHAPE_BLOCK_TEXT));

        this.verticalBlockButton = this.addRenderableWidget(new HoverImageButton(
                baseX - (buttonWidth + 1 ) * 2,
                baseY,
                buttonWidth, buttonHeight,
                0, 0, buttonWidth,
                VERTICAL_BLOCK_BUTTON,
                textureWidth, buttonHeight,
                buttonWidth, buttonHeight,
                button -> {
                    setMode(RenderWindowWidget.Mode.VERTICAL_BLOCK);
                    updateBlockPreview();
                    this.rebuildWidgets();
                },
                currentMode == RenderWindowWidget.Mode.VERTICAL_BLOCK,
                false
        ));
        this.verticalBlockButton.setTooltip(Tooltip.create(VERTICAL_BLOCK_TEXT));

        this.horizontalBlockButton = this.addRenderableWidget(new HoverImageButton(
                baseX - (buttonWidth + 1 ) * 3,
                baseY,
                buttonWidth, buttonHeight,
                0, 0, buttonWidth,
                HORIZONTAL_BLOCK,
                textureWidth, buttonHeight,
                buttonWidth, buttonHeight,
                button -> {
                    setMode(RenderWindowWidget.Mode.HORIZONTAL_BLOCK);
                    updateBlockPreview();
                    this.rebuildWidgets();
                },
                currentMode == RenderWindowWidget.Mode.HORIZONTAL_BLOCK,
                false
        ));
        this.horizontalBlockButton.setTooltip(Tooltip.create(HORIZONTAL_BLOCK_TEXT));

        this.twoByTwoBlockButton = this.addRenderableWidget(new HoverImageButton(
                baseX - (buttonWidth + 1 ) * 4,
                baseY,
                buttonWidth, buttonHeight,
                0, 0, buttonWidth,
                TWO_BY_TWO_BLOCK_BUTTON,
                textureWidth, buttonHeight,
                buttonWidth, buttonHeight,
                button -> {
                    setMode(RenderWindowWidget.Mode.TWO_BY_TWO_BLOCK);
                    updateBlockPreview();
                    this.rebuildWidgets();
                },
                currentMode == RenderWindowWidget.Mode.TWO_BY_TWO_BLOCK,
                false
        ));
        this.twoByTwoBlockButton.setTooltip(Tooltip.create(TWO_BY_TWO_BLOCK_TEXT));

        this.singleBlockButton.addToGroup(
                this.lShapeBlockButton,
                this.verticalBlockButton,
                this.horizontalBlockButton,
                this.twoByTwoBlockButton
        );
        this.lShapeBlockButton.addToGroup(
                this.singleBlockButton,
                this.verticalBlockButton,
                this.horizontalBlockButton,
                this.twoByTwoBlockButton
        );
        this.verticalBlockButton.addToGroup(
                this.lShapeBlockButton,
                this.singleBlockButton,
                this.horizontalBlockButton,
                this.twoByTwoBlockButton
        );
        this.horizontalBlockButton.addToGroup(
                this.lShapeBlockButton,
                this.singleBlockButton,
                this.verticalBlockButton,
                this.twoByTwoBlockButton
        );
        this.twoByTwoBlockButton.addToGroup(
                this.lShapeBlockButton,
                this.verticalBlockButton,
                this.horizontalBlockButton,
                this.singleBlockButton
        );

        this.renderWindowWidget = this.addRenderableWidget(new RenderWindowWidget(
                this.leftPos - 96, // Adjust X position as needed
                this.topPos + 14 ,  // Adjust Y position as needed
                83, 74,            // Adjust width and height as needed
                () -> fakeLevel,
                this::onBlockStateChange

        ));

        updateRenderWindowWidget();
    }

    private void onBlockStateChange(BlockState newState) {
        updateBlockPreview(newState);
    }

    private void renderPreviewTab(GuiGraphics guiGraphics) {
        guiGraphics.blit(loc -> RenderType.gui(), PREVIEW_TAB, this.leftPos - 111, this.topPos, 0.0F, 0.0F, 113, 122, 113, 122);
        guiGraphics.drawString(this.font, PREVIEW_TITLE_TEXT, (this.width / 2) - 191, this.topPos + 5, 4210752, false);
    }
    private void renderNoPreviewTab(GuiGraphics guiGraphics) {

    }

    private void updateRenderWindowWidget() {
        int x, y, width, height;

        x = this.leftPos - 96;
        y = this.topPos + 14;

        width = 83;
        height = 74;

        if (this.renderWindowWidget != null) {
            this.removeWidget(this.renderWindowWidget);
        }

        this.renderWindowWidget = this.addRenderableWidget(new RenderWindowWidget(
                x, y, width, height, () -> fakeLevel, this::onBlockStateChange
        ));

        if (!this.showPreview) {
            this.removeWidget(this.singleBlockButton);
            this.removeWidget(this.lShapeBlockButton);
            this.removeWidget(this.verticalBlockButton);
            this.removeWidget(this.twoByTwoBlockButton);
            this.removeWidget(this.renderWindowWidget);
        }
    }


    private void setMode(RenderWindowWidget.Mode newMode) {
        if (currentMode != newMode) {
            currentMode = newMode;
        }
    }

    private void updateBlockPreview() {
        updateBlockPreview(null);
    }

    private void updateBlockPreview(BlockState overrideState) {
        int selectedIndex = this.menu.getSelectedRecipeIndex();
        if (selectedIndex >= 0 && selectedIndex < this.menu.getRecipes().size()) {
            FilterableRecipe recipe = this.menu.getRecipes().get(selectedIndex);

            BlockState state = overrideState != null ? overrideState : currentBlockState(recipe);
            if (state != null && !state.isAir()) {
                List<BlockPos> positions = getPositionsForMode(currentMode);
                List<Direction> facings = getFacingForMode(currentMode);

                if (state.getBlock() instanceof FenceBlock) {
                    fakeLevel.setBlocksWithConnections(state, positions);
                } else {
                    fakeLevel.setBlocksWithRotation(state, positions, facings);
                }
                if (renderWindowWidget != null) {
                    renderWindowWidget.setCurrentState(state);
                }
            } else {
                fakeLevel.clear();
                if (renderWindowWidget != null) {
                    renderWindowWidget.setCurrentState(null);
                }
            }
        } else {
            fakeLevel.clear();
            if (renderWindowWidget != null) {
                renderWindowWidget.setCurrentState(null);
            }
        }
    }

    private List<BlockPos> getPositionsForMode(RenderWindowWidget.Mode mode) {
        switch (mode) {
            case SINGLE_BLOCK:
                return List.of(BlockPos.ZERO);
            case L_SHAPE_BLOCK:
                return List.of(BlockPos.ZERO, BlockPos.ZERO.north(), BlockPos.ZERO.east());
            case VERTICAL_BLOCK:
                return List.of(BlockPos.ZERO, BlockPos.ZERO.above());
            case HORIZONTAL_BLOCK:
                return List.of(BlockPos.ZERO, BlockPos.ZERO.east());
            case TWO_BY_TWO_BLOCK:
                return List.of(BlockPos.ZERO, BlockPos.ZERO.east(), BlockPos.ZERO.above(), BlockPos.ZERO.east().above());
            default:
                return List.of(BlockPos.ZERO);
        }
    }

    private List<Direction> getFacingForMode(RenderWindowWidget.Mode mode) {
        switch (mode) {
            case L_SHAPE_BLOCK:
                return List.of(Direction.EAST, Direction.EAST, Direction.NORTH);
            default:
                return List.of(Direction.NORTH);
        }
    }

    private void updateSearchBarVisibility() {
        boolean hasSearch = ConfigProvider.hasSearchBar(menu.getRecipes().size());
        this.searchBox.visible = hasSearch;
        this.searchBox.active = hasSearch;
    }

    @Override
    protected void containerTick() {
        super.containerTick();
        //if (searchBox.visible) this.searchBox.tick();

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

        int selectedIndex = this.menu.getSelectedRecipeIndex();
        if (selectedIndex >= 0 && selectedIndex < this.menu.getRecipes().size()) {
            FilterableRecipe recipe = this.menu.getRecipes().get(selectedIndex);
            ItemStack resultItem = recipe.output();
            Block block = Block.byItem(resultItem.getItem());

            if (ConfigProvider.shouldShowPreview()) {
                if (showPreviewStatic) {
                    if (block instanceof WardrobeBlock || block instanceof ModBedBlock || block instanceof DoorBlock) {
                        renderSmallerText(guiGraphics, NO_PREVIEW_TITLE_TEXT, (this.width / 2) - 180, this.topPos + 45, WHITE, 0.75F);
                        this.removeWidget(renderWindowWidget);
                        this.removeWidget(singleBlockButton);
                        this.removeWidget(lShapeBlockButton);
                        this.removeWidget(verticalBlockButton);
                        this.removeWidget(horizontalBlockButton);
                        this.removeWidget(twoByTwoBlockButton);
                    } else {
                        this.addRenderableWidget(renderWindowWidget);
                        this.addRenderableWidget(singleBlockButton);
                        this.addRenderableWidget(lShapeBlockButton);
                        this.addRenderableWidget(verticalBlockButton);
                        this.addRenderableWidget(horizontalBlockButton);
                        this.addRenderableWidget(twoByTwoBlockButton);
                    }
                }
            }
        }
    }

    private void renderSmallerText(GuiGraphics guiGraphics, Component text, int x, int y, int color, float scale) {
        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();
        poseStack.translate(x, y, 0);
        poseStack.scale(scale, scale, 1.0f);
        guiGraphics.drawString(this.font, text, 0, 0, color, true);
        poseStack.popPose();
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {

        ResourceLocation bgLocation = getBgLocation();
        guiGraphics.blit(loc -> RenderType.gui(), bgLocation, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

        // scrollbar
        int barH = scrollBarHeight();
        int scrollY = minScrollY();
        float barSpan = maxScrollY() - scrollY - barH;
        int barPos = (int) (barSpan * this.scrollOffs);

        guiGraphics.blit(loc -> RenderType.gui(), bgLocation, minScrollX(), scrollY + barPos, 176.0F, (this.isScrollBarActive() ? 0.0F : 12.0F), 12, barH, 256, 256);

        if (ConfigProvider.shouldShowPreview()) {
            if (this.showPreview) {
                renderPreviewTab(guiGraphics);
            }
        }

        if (!displayRecipes) return;

        // buttons
        forEachButton((index, buttonX, buttonY) -> {
            int textureY = this.imageHeight;
            if (index == filteredIndex) {
                textureY += 18;
            } else if (mouseX >= buttonX && mouseY >= buttonY && mouseX < buttonX + 16 && mouseY < buttonY + 18) {
                textureY += 36;
            }
            guiGraphics.blit(loc -> RenderType.gui(), BACKGROUND, buttonX, buttonY, 0.0F, (float)textureY, 16, 18, 256, 256);
        });

        // items
        forEachButton((index, buttonX, buttonY) -> {
            ItemStack item = filteredRecipes.get(index).output();
            guiGraphics.renderFakeItem(item, buttonX, buttonY + 1);
            guiGraphics.renderItemDecorations(font, item, buttonX, buttonY + 1);
        });
    }

    private FilterableRecipe getSelectedRecipe() {
        int selectedIndex = this.menu.getSelectedRecipeIndex();
        if (selectedIndex >= 0 && selectedIndex < this.menu.getRecipes().size()) {
            return this.menu.getRecipes().get(selectedIndex);
        }
        return null;
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
                    guiGraphics.renderTooltip(this.font, (filteredRecipes.get(index)).output(), mouseX, mouseY);
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
        return this.topPos + (searchBox.visible ? 30 : 15);
    }

    private int maxScrollY() {
        return this.topPos + (searchBox.visible ? 30 + 36 : 15 + 55);
    }

    private int scrollBarHeight() {
        return searchBox.visible ? 11 : 15;
    }

    private void forEachButton(ButtonConsumer buttonConsumer) {
        int buttonBoxX = this.leftPos + (40);
        int buttonBoxY = this.topPos + (searchBox.visible ? 28 : 13);
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
        if (this.renderWindowWidget != null && this.renderWindowWidget.isMouseOver(mouseX, mouseY)) {
            boolean result = this.renderWindowWidget.mouseClicked(mouseX, mouseY, button);
            if (result) {
                return true;
            }
        }
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
                        updateBlockPreview();
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
        if (this.renderWindowWidget != null && this.renderWindowWidget.isMouseOver(mouseX, mouseY)) {
            return false;
        }
        boolean flag = mouseX < (double)left || mouseY < (double)top || mouseX >= (double)(left + this.imageWidth) || mouseY >= (double)(top + this.imageHeight);
        return flag;
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (this.renderWindowWidget != null) {
            boolean result = this.renderWindowWidget.mouseDragged(mouseX, mouseY, button, dragX, dragY);
            if (result) {
                return true;
            }
        }
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
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (this.renderWindowWidget != null) {
            boolean result = this.renderWindowWidget.mouseReleased(mouseX, mouseY, button);
            if (result) {
                return true;
            }
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double xDelta, double yDelta) {
        if (this.renderWindowWidget != null && this.renderWindowWidget.isMouseOver(mouseX, mouseY)) {
            boolean result = this.renderWindowWidget.mouseScrolled(mouseX, mouseY,  xDelta, yDelta);
            if (result) {
                return true;
            }
        }

        if (this.isScrollBarActive()) {
            int offscreenRows = this.getOffscreenRows();
            float f = (float) yDelta / offscreenRows;
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

    public RenderWindowWidget.Mode currentMode() {
        return currentMode;
    }

    private BlockState currentBlockState(FilterableRecipe recipe) {
        ItemStack resultItem = recipe.output();
        Block block = Block.byItem(resultItem.getItem());
        BlockState state = block.defaultBlockState();
        return state.isAir() ? null : state;
    }
}
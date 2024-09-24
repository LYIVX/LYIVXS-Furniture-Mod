package net.lyivx.ls_furniture.client.screens;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.blocks.entity.TombstoneBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.font.TextFieldHelper;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Quaternionf;

import java.util.NavigableMap;
import java.util.TreeMap;

public class TombstoneScreen extends Screen {
    private static final Component SCREEN_NAME = Component.translatable("container.ls_furniture.tombstone.edit");

    private final TombstoneBlockEntity tombstoneBlockEntity;
    private int selectedLine = 0;
    private TextFieldHelper[] textFieldHelpers;
    private String[] lines;
    private float[] textSizes;

    private static final int DECIMAL_PLACES = 1;
    private static final float MAX_TEXT_SIZE = 2.0f;
    private static final float MIN_TEXT_SIZE = 0.5f;

    private static final NavigableMap<Float, Integer> SIZE_TO_MAX_LENGTH = new TreeMap<>();
    static {
        SIZE_TO_MAX_LENGTH.put(2.0f, 6);
        SIZE_TO_MAX_LENGTH.put(1.9f, 6);
        SIZE_TO_MAX_LENGTH.put(1.8f, 6);
        SIZE_TO_MAX_LENGTH.put(1.7f, 7);
        SIZE_TO_MAX_LENGTH.put(1.6f, 7);
        SIZE_TO_MAX_LENGTH.put(1.5f, 8);
        SIZE_TO_MAX_LENGTH.put(1.4f, 8);
        SIZE_TO_MAX_LENGTH.put(1.3f, 9);
        SIZE_TO_MAX_LENGTH.put(1.2f, 10);
        SIZE_TO_MAX_LENGTH.put(1.1f, 11);
        SIZE_TO_MAX_LENGTH.put(1.0f, 12);
        SIZE_TO_MAX_LENGTH.put(0.9f, 13);
        SIZE_TO_MAX_LENGTH.put(0.8f, 15);
        SIZE_TO_MAX_LENGTH.put(0.7f, 17);
        SIZE_TO_MAX_LENGTH.put(0.6f, 20);
        SIZE_TO_MAX_LENGTH.put(0.5f, 24);
    }

    public TombstoneScreen(TombstoneBlockEntity tombstoneBlockEntity) {
        super(SCREEN_NAME);
        this.tombstoneBlockEntity = tombstoneBlockEntity;
        this.lines = tombstoneBlockEntity.getLines().clone();
        this.textSizes = tombstoneBlockEntity.getTextSizes().clone();
    }

    @Override
    protected void init() {
        super.init();
        this.textFieldHelpers = new TextFieldHelper[4];
        for (int i = 0; i < 4; i++) {
            int lineIndex = i;
            this.textFieldHelpers[i] = new TextFieldHelper(
                    () -> lines[lineIndex],
                    (s) -> {
                        int maxLength = getMaxLengthForSize(textSizes[lineIndex]);
                        if (s.length() > maxLength) {
                            s = s.substring(0, maxLength);
                        }
                        lines[lineIndex] = s;
                        updateTombstone();
                    },
                    TextFieldHelper.createClipboardGetter(this.minecraft),
                    TextFieldHelper.createClipboardSetter(this.minecraft),
                    (s) -> s.length() <= getMaxLengthForSize(textSizes[lineIndex])
            );

            // Add buttons for increasing and decreasing text size
            this.addRenderableWidget(Button.builder(Component.literal("+"), (button) -> {
                changeTextSize(lineIndex, 0.1f);
            }).bounds(this.width / 2 + 60, 65 + i * 20, 20, 20).build());

            this.addRenderableWidget(Button.builder(Component.literal("-"), (button) -> {
                changeTextSize(lineIndex, -0.1f);
            }).bounds(this.width / 2 + 105, 65 + i * 20, 20, 20).build());
        }

        this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, (button) -> {
            this.onDone();
        }).bounds(this.width / 2 - 100, this.height / 4 + 120, 200, 20).build());
    }

    private int getMaxLengthForSize(float size) {
        return SIZE_TO_MAX_LENGTH.ceilingEntry(size).getValue();
    }

    private void changeTextSize(int lineIndex, float delta) {
        float newSize = Math.max(MIN_TEXT_SIZE, Math.min(MAX_TEXT_SIZE, textSizes[lineIndex] + delta));
        int newMaxLength = getMaxLengthForSize(newSize);
        lines[lineIndex] = truncateString(lines[lineIndex], newMaxLength);
        textFieldHelpers[lineIndex].setCursorToEnd();
        textSizes[lineIndex] = newSize;
        updateTombstone();
    }

    private void updateTombstone() {
        tombstoneBlockEntity.setLines(lines);
        for (int i = 0; i < 4; i++) {
            tombstoneBlockEntity.setTextSize(i, textSizes[i]);
        }
        tombstoneBlockEntity.setChanged();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {

        // Render the block first
        renderBlock(guiGraphics);

        // Now render the GUI elements (text and buttons)
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 35, 16777215);

        // Render lines
        for (int i = 0; i < 4; ++i) {
            renderLine(guiGraphics, i);
            String sizeText = String.format("%." + 1 + "f", textSizes[i]);
            int x = this.width / 2 + 93;
            int y = (72 + i * 20);
            guiGraphics.drawCenteredString(this.font, sizeText, x, y, 0xFFFFFF);
        }

        // Render cursor
        renderCursor(guiGraphics);

        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    private void renderBlock(GuiGraphics guiGraphics) {
        BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();
        BlockState blockState = tombstoneBlockEntity.getBlockState();

        if (!blockState.isAir()) {
            guiGraphics.pose().pushPose();

            // Adjust the position to render the block lower on the screen
            float blockX = this.width / 1.7325f;
            float blockY = this.height * 0.1875f; // Move the block lower
            float blockZ = 100; // Positive Z value to ensure it's behind GUI elements

            guiGraphics.pose().translate(blockX, blockY, blockZ);


            // Adjust the scale to make the block smaller
            float scale = 100.0f; // Reduced from 175.0f
            guiGraphics.pose().scale(scale, scale, scale);

            // Rotate the block so that it's facing straight on
            Quaternionf rotation = new Quaternionf().rotateXYZ(0f, (float) Math.toRadians(180f), (float) Math.toRadians(180));
            Quaternionf northRotation = new Quaternionf().rotateXYZ(0f, 0f, 0f);
            Quaternionf southRotation = new Quaternionf().rotateXYZ(0f, (float) Math.toRadians(180f), 0f);
            Quaternionf westRotation = new Quaternionf().rotateXYZ(0f, (float) Math.toRadians(270f), 0f);
            Quaternionf eastRotation = new Quaternionf().rotateXYZ(0f, (float) Math.toRadians(90f), 0f);
            guiGraphics.pose().mulPose(rotation);

            Direction side = blockState.getValue(HorizontalDirectionalBlock.FACING);

            switch (side) {
                case NORTH:
                    guiGraphics.pose().mulPose(northRotation);
                    guiGraphics.pose().translate(-1, -1, 0);
                    break;
                case SOUTH:
                    guiGraphics.pose().mulPose(southRotation);
                    guiGraphics.pose().translate(-0, -1, 0);
                    break;
                case WEST:
                    guiGraphics.pose().mulPose(westRotation);
                    guiGraphics.pose().translate(0, -1, 0);
                    break;
                case EAST:
                    guiGraphics.pose().mulPose(eastRotation);
                    guiGraphics.pose().translate(0, -1, -1);
                    break;
            }

            try {
                blockRenderer.renderSingleBlock(blockState, guiGraphics.pose(), guiGraphics.bufferSource(), 15728880, OverlayTexture.NO_OVERLAY);
            } catch (Exception e) {
                System.out.println("Error rendering block: " + e.getMessage());
            }
            guiGraphics.pose().popPose();
        }
    }

    private void renderLine(GuiGraphics guiGraphics, int lineIndex) {
        String line = this.lines[lineIndex];
        if (line != null) {
            float scale = textSizes[lineIndex];
            int lineWidth = this.font.width(line);
            int centerX = this.width / 2;
            int x = centerX - (int) ((lineWidth * scale) / 2);
            int y = 70 + lineIndex * 20;

            guiGraphics.pose().pushPose();
            guiGraphics.pose().translate(x, y, 200);  // Higher Z-value to ensure text is above the block

            guiGraphics.pose().scale(scale, scale, 1.0f);
            guiGraphics.drawString(this.font, line, 0, 0, tombstoneBlockEntity.getColor().getTextColor(), false);
            guiGraphics.pose().popPose();
        }
    }

    private void renderCursor(GuiGraphics guiGraphics) {
        if (this.tombstoneBlockEntity.isEditable() && (this.minecraft.player.tickCount / 6) % 2 == 0) {
            String currentLine = this.lines[this.selectedLine];
            float scale = textSizes[this.selectedLine];
            int lineWidth = this.font.width(currentLine);
            int centerX = this.width / 2;
            int y = 70 + this.selectedLine * 20;

            TextFieldHelper currentHelper = this.textFieldHelpers[this.selectedLine];
            int cursorPosition = Math.min(currentHelper.getCursorPos(), currentLine.length());

            guiGraphics.pose().pushPose();
            guiGraphics.pose().translate(centerX, y, 200);  // Ensure cursor is above the block
            guiGraphics.pose().scale(scale, scale, 1.0f);

            String textUpToCursor = currentLine.substring(0, cursorPosition);
            int unscaledTextWidthUpToCursor = this.font.width(textUpToCursor);
            int centeredTextX = -lineWidth / 2;
            int cursorX = centeredTextX + unscaledTextWidthUpToCursor;

            guiGraphics.drawString(this.font, "_", cursorX, 0, tombstoneBlockEntity.getColor().getTextColor(), false);
            guiGraphics.pose().popPose();
        }
    }

    private String truncateString(String input, int maxLength) {
        return input.length() > maxLength ? input.substring(0, maxLength) : input;
    }

    @Override
    public boolean charTyped(char c, int modifiers) {
        if (this.tombstoneBlockEntity.isEditable() && this.textFieldHelpers != null) {
            TextFieldHelper currentHelper = this.textFieldHelpers[this.selectedLine];
            int maxLength = getMaxLengthForSize(textSizes[this.selectedLine]);
            if (lines[this.selectedLine].length() >= maxLength) {
                return false;
            }
            boolean result = currentHelper.charTyped(c);
            if (result) {
                lines[this.selectedLine] = truncateString(lines[this.selectedLine], maxLength);
                updateTombstone();
            }
            return result;
        }
        return false;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {  // Left mouse button
            for (int i = 0; i < 4; i++) {
                int y = 70 + i * 20;
                if (mouseY >= y && mouseY < y + 20 && mouseX >= this.width / 2 - 90 && mouseX < this.width / 2 + 60) {
                    setSelectedLine(i);
                    return true;
                }
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    private void setSelectedLine(int line) {
        this.selectedLine = line;
        // Reset cursor position for the newly selected line
        this.textFieldHelpers[this.selectedLine].setCursorToEnd();
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (this.tombstoneBlockEntity.isEditable() && this.textFieldHelpers != null) {
            TextFieldHelper currentHelper = this.textFieldHelpers[this.selectedLine];

            if (keyCode == 257 || keyCode == 335) {  // Enter or numpad Enter
                setSelectedLine((this.selectedLine + 1) % 4);
                return true;
            }

            boolean result = currentHelper.keyPressed(keyCode);
            if (result) {
                int maxLength = getMaxLengthForSize(textSizes[this.selectedLine]);
                lines[this.selectedLine] = truncateString(lines[this.selectedLine], maxLength);
                updateTombstone();
            }
            return result || super.keyPressed(keyCode, scanCode, modifiers);
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    private void onDone() {
        this.tombstoneBlockEntity.setEditable(true);
        updateTombstone();
        this.minecraft.setScreen(null);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
package net.lyivx.ls_furniture.client.screens.widgets;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.lyivx.ls_furniture.client.screens.WorkstationScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.joml.Quaternionf;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class RenderWindowWidget extends AbstractWidget {
    private final Supplier<FakeLevel> fakeLevelSupplier;
    private final Consumer<BlockState> onStateChange;
    private BlockState currentState;
    private boolean isDragging = false;
    private boolean isDraggingStarted = false;
    private int lastMouseX, lastMouseY;
    private float rotationX = 0f, rotationY = 0f;
    private long mouseDownTime;
    private static final long CLICK_TIME_THRESHOLD = 100; // milliseconds
    private float scale = 20f; // Initial scale
    private static final float MIN_SCALE = 5f;
    private static final float MAX_SCALE = 40f;
    private static final float SCROLL_SENSITIVITY = 0.5f;
    private boolean isRightDragging = false;
    private double translateX = 0;
    private double translateY = 0;
    private static final double TRANSLATION_SENSITIVITY = 0.01;

    public RenderWindowWidget(int x, int y, int width, int height, Supplier<FakeLevel> fakeLevelSupplier, Consumer<BlockState> onStateChange) {
        super(x, y, width, height, CommonComponents.EMPTY);
        this.fakeLevelSupplier = fakeLevelSupplier;
        this.onStateChange = onStateChange;
    }

    @Override
    public void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        FakeLevel fakeLevel = fakeLevelSupplier.get();
        if (fakeLevel == null) return;

        PoseStack poseStack = graphics.pose();
        poseStack.pushPose();

        Window window = Minecraft.getInstance().getWindow();
        double guiScale = window.getGuiScale();

        // Convert widget position to screen coordinates
        int scissorX = (int) ((this.getX() + 1) * guiScale);
        // Convert Y coordinate from top-left to bottom-left
        int scissorY = (int) (window.getHeight() - ((this.getY() - 1) + this.getHeight()) * guiScale);
        // Scale the width and height
        int scissorWidth = (int) ((this.getWidth() - 2) * guiScale);
        int scissorHeight = (int) ((this.getHeight() - 2) * guiScale);

        RenderSystem.enableScissor(
                scissorX,
                scissorY,
                scissorWidth,
                scissorHeight
        );

        // Center the render area
        poseStack.translate(this.getX() + this.getWidth() / 2.0, this.getY() + this.getHeight() / 2.0, 100);

        poseStack.translate(translateX * scale, translateY * scale, 0);

        poseStack.mulPose(Axis.YP.rotationDegrees(rotationY));
        poseStack.mulPose(Axis.XN.rotationDegrees(rotationX));

        poseStack.scale(scale, -scale, scale);

        // Rotate the view
        poseStack.mulPose(new Quaternionf().rotationXYZ(
                (float) Math.toRadians(25),  // Tilt down slightly
                (float) Math.toRadians(225),  // Rotate 225 degrees (face north-west corner)
                0
        ));

        // Center the blocks
        poseStack.translate(-0.5, -0.5, -0.5);

        if (WorkstationScreen.currentMode == Mode.SINGLE_BLOCK) {
            poseStack.scale(2, 2, 2);
            poseStack.translate(-0.25, -0.25, -0.25);
        } else if (WorkstationScreen.currentMode == Mode.TWO_BY_TWO_BLOCK) {
            poseStack.translate(-0.25, -0.25, -0.25);
        } else if (WorkstationScreen.currentMode == Mode.VERTICAL_BLOCK) {
            poseStack.translate(0, -0.5, 0);
        } else if (WorkstationScreen.currentMode == Mode.HORIZONTAL_BLOCK) {
            poseStack.translate(-0.5, -0.375, 0);
        }

        fakeLevel.renderBlocks(poseStack);

        poseStack.popPose();

        // Disable scissor test
        RenderSystem.disableScissor();

    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        if (currentState == null) {
            FakeLevel fakeLevel = fakeLevelSupplier.get();
            if (fakeLevel != null) {
                currentState = fakeLevel.getBlockState(BlockPos.ZERO);
            }
        }
        if (currentState != null) {
            cycleBlockState();
        }
        super.onClick(mouseX, mouseY);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (isMouseOver(mouseX, mouseY)) {
            if (button == 0) { // Left click
                isDragging = true;
                isDraggingStarted = false;
            } else if (button == 1) { // Right click
                isRightDragging = true;
            }
            lastMouseX = (int) mouseX;
            lastMouseY = (int) mouseY;
            mouseDownTime = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0 && isDragging) {
            isDragging = false;
            long clickDuration = System.currentTimeMillis() - mouseDownTime;
            if (!isDraggingStarted && clickDuration < CLICK_TIME_THRESHOLD && isMouseOver(mouseX, mouseY)) {
                onClick(mouseX, mouseY);
            }
            isDraggingStarted = false;
            return true;
        } else if (button == 1 && isRightDragging) {
            isRightDragging = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (isDragging && button == 0) { // Left click drag for rotation
            int deltaX = (int) (mouseX - lastMouseX);
            int deltaY = (int) (mouseY - lastMouseY);

                rotationY += deltaX * 2f;
                rotationX += deltaY * 2f;
                rotationY = rotationY % 360;
                rotationX = Mth.clamp(rotationX, -45, 0);
                if (rotationY < 0) rotationY += 360;

            lastMouseX = (int) mouseX;
            lastMouseY = (int) mouseY;
            return true;
        } else if (isRightDragging && button == 1) { // Right click drag for translation
            double deltaX = mouseX - lastMouseX;
            double deltaY = mouseY - lastMouseY;

            translateX += deltaX * TRANSLATION_SENSITIVITY;
            translateY += deltaY * TRANSLATION_SENSITIVITY; // Inverted Y for more intuitive movement

            lastMouseX = (int) mouseX;
            lastMouseY = (int) mouseY;
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollY) {
        if (isMouseOver(mouseX, mouseY)) {
            scale += (float) (scrollY * SCROLL_SENSITIVITY);
            scale = Mth.clamp(scale, MIN_SCALE, MAX_SCALE);
            return true;
        }
        return super.mouseScrolled(mouseX, mouseY, scrollY);
    }

    private void cycleBlockState() {
        if (currentState != null) {
            if (currentState.hasProperty(BlockStateProperties.OPEN)) {
                boolean isOpen = currentState.getValue(BlockStateProperties.OPEN);
                BlockState newState = currentState.setValue(BlockStateProperties.OPEN, !isOpen);
                currentState = newState;
                onStateChange.accept(newState);
            }
        }
    }

    public void setCurrentState(BlockState state) {
        this.currentState = state;

    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {}

    public enum Mode {
        SINGLE_BLOCK(
                new BlockPos[]{BlockPos.ZERO},
                new Direction[]{Direction.NORTH}
        ),
        L_SHAPE_BLOCK(
                new BlockPos[]{BlockPos.ZERO, BlockPos.ZERO.north(), BlockPos.ZERO.east()},
                new Direction[]{Direction.NORTH, Direction.EAST, Direction.NORTH}
        ),
        VERTICAL_BLOCK(
                new BlockPos[]{BlockPos.ZERO, BlockPos.ZERO.above()},
                new Direction[]{Direction.NORTH, Direction.NORTH}
        ),
        HORIZONTAL_BLOCK(
                new BlockPos[]{BlockPos.ZERO, BlockPos.ZERO.east()},
                new Direction[]{Direction.NORTH, Direction.NORTH}
        ),
        TWO_BY_TWO_BLOCK(
                new BlockPos[]{BlockPos.ZERO, BlockPos.ZERO.east(), BlockPos.ZERO.above(), BlockPos.ZERO.east().above()},
                new Direction[]{Direction.NORTH, Direction.NORTH, Direction.NORTH, Direction.NORTH}
        );

        private final List<BlockPos> positions;
        private final List<Direction> directions;

        Mode(BlockPos[] positions, Direction[] directions) {
            this.positions = List.of(positions);
            this.directions = List.of(directions);
        }

        public List<BlockPos> getPositions() {
            return positions;
        }

        public List<Direction> getDirections() {
            return directions;
        }
    }

    public enum FenceConfiguration {
        SINGLE(EnumSet.noneOf(Direction.class)),
        NORTH_SOUTH(EnumSet.of(Direction.NORTH, Direction.SOUTH)),
        EAST_WEST(EnumSet.of(Direction.EAST, Direction.WEST)),
        CORNER_NE(EnumSet.of(Direction.NORTH, Direction.EAST)),
        CORNER_NW(EnumSet.of(Direction.NORTH, Direction.WEST)),
        CORNER_SE(EnumSet.of(Direction.SOUTH, Direction.EAST)),
        CORNER_SW(EnumSet.of(Direction.SOUTH, Direction.WEST)),
        T_SHAPE_N(EnumSet.of(Direction.NORTH, Direction.EAST, Direction.WEST)),
        T_SHAPE_S(EnumSet.of(Direction.SOUTH, Direction.EAST, Direction.WEST)),
        T_SHAPE_E(EnumSet.of(Direction.NORTH, Direction.SOUTH, Direction.EAST)),
        T_SHAPE_W(EnumSet.of(Direction.NORTH, Direction.SOUTH, Direction.WEST)),
        CROSS(EnumSet.allOf(Direction.class));

        private final EnumSet<Direction> connections;

        FenceConfiguration(EnumSet<Direction> connections) {
            this.connections = connections;
        }

        public BlockState applyToBlockState(BlockState state) {

            return state;
        }
    }
}
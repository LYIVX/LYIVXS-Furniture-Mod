package net.lyivx.ls_furniture.client.screens.widgets;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.WidgetSprites;

public class HoverImageButton extends ImageButton {
    private final ResourceLocation texture;
    private final int xTexStart;
    private final int yTexStart;
    private final int xDiffTex;
    private final int textureWidth;
    private final int textureHeight;
    private final int sourceWidth;
    private final int sourceHeight;

    public HoverImageButton(int x, int y, int width, int height, int xTexStart, int yTexStart, int xDiffTex,
                            ResourceLocation texture, int textureWidth, int textureHeight,
                            int sourceWidth, int sourceHeight, OnPress onPress) {
        super(x, y, width, height,
                new WidgetSprites(texture, texture),  // Using the same texture for both states
                onPress,
                Component.empty());
        this.texture = texture;
        this.xTexStart = xTexStart;
        this.yTexStart = yTexStart;
        this.xDiffTex = xDiffTex;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.sourceWidth = sourceWidth;
        this.sourceHeight = sourceHeight;
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        int xTex = this.xTexStart;
        if (this.isHovered()) {
            xTex += this.xDiffTex;
        }

        guiGraphics.blit(this.texture, this.getX(), this.getY(), this.width, this.height,
                xTex, this.yTexStart, this.sourceWidth, this.sourceHeight,
                this.textureWidth, this.textureHeight);
    }
}
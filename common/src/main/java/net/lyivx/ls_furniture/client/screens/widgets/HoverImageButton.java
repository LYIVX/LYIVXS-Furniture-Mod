package net.lyivx.ls_furniture.client.screens.widgets;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class HoverImageButton extends ImageButton {
    private final ResourceLocation texture;
    private final int xTexStart;
    private final int yTexStart;
    private final int xDiffTex;
    private final int textureWidth;
    private final int textureHeight;
    private final int sourceWidth;
    private final int sourceHeight;
    private boolean stayClicked;
    private boolean stayClickedHover;
    private List<HoverImageButton> group;

    public HoverImageButton(int x, int y, int width, int height, int xTexStart, int yTexStart, int xDiffTex,
                            ResourceLocation texture, int textureWidth, int textureHeight,
                            int sourceWidth, int sourceHeight, OnPress onPress, boolean stayClicked, boolean stayClickedHover) {
        super(x, y, width, height, xTexStart, yTexStart, sourceWidth, texture, onPress);
        this.texture = texture;
        this.xTexStart = xTexStart;
        this.yTexStart = yTexStart;
        this.xDiffTex = xDiffTex;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.sourceWidth = sourceWidth;
        this.sourceHeight = sourceHeight;
        this.stayClicked = stayClicked;
        this.stayClickedHover = stayClickedHover;
        this.group = new ArrayList<>();
    }

    public void setStayClicked(boolean stayClicked) {
        this.stayClicked = stayClicked;
        if (stayClicked) {
            for (HoverImageButton button : group) {
                if (button != this) {
                    button.setStayClicked(false);
                }
            }
        }
    }

    public boolean isStayClicked() {
        return this.stayClicked;
    }

    public void addToGroup(HoverImageButton... buttons) {
        for (HoverImageButton button : buttons) {
            if (!this.group.contains(button)) {
                this.group.add(button);
                button.addToGroup(this);
            }
        }
    }

    @Override
    public void onPress() {
        setStayClicked(true);
        super.onPress();
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        int xTex = this.xTexStart;
        if (this.stayClicked && !this.isHovered()) {
            xTex += (this.xDiffTex * 2);
        } else if (this.stayClicked && this.isHovered() && this.stayClickedHover) {
            xTex += (this.xDiffTex * 3);
        } else if (this.stayClicked && this.isHovered() && !this.stayClickedHover) {
            xTex += (this.xDiffTex * 2);
        } else if (!this.stayClicked && !this.isHovered()) {
            xTex += 0;
        } else if (!this.stayClicked && this.isHovered()) {
            xTex += this.xDiffTex;
        }

        guiGraphics.blit(this.texture, this.getX(), this.getY(), this.width, this.height,
                xTex, this.yTexStart, this.sourceWidth, this.sourceHeight,
                this.textureWidth, this.textureHeight);
    }
}
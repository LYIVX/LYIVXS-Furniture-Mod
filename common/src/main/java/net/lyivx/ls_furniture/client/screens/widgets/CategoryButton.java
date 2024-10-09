package net.lyivx.ls_furniture.client.screens.widgets;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

public class CategoryButton extends Button {
    private boolean isSelected;

    public CategoryButton(int x, int y, int width, int height, Component message, OnPress onPress, boolean isSelected) {
        super(x, y, width, height, message, onPress, DEFAULT_NARRATION);
        this.isSelected = isSelected;
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.isHovered = this.isSelected || this.isHovered();
        super.renderWidget(guiGraphics, mouseX, mouseY, partialTick);
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }
}
package net.lyivx.ls_furniture.client.screens.widgets;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

public class CustomCheckbox extends AbstractButton {
    private static final ResourceLocation CHECKBOX_SELECTED_HIGHLIGHTED = ResourceLocation.withDefaultNamespace("textures/gui/sprites/widget/checkbox_selected_highlighted.png");
    private static final ResourceLocation CHECKBOX_SELECTED = ResourceLocation.withDefaultNamespace("textures/gui/sprites/widget/checkbox_selected.png");
    private static final ResourceLocation CHECKBOX_HIGHLIGHTED = ResourceLocation.withDefaultNamespace("textures/gui/sprites/widget/checkbox_highlighted.png");
    private static final ResourceLocation CHECKBOX = ResourceLocation.withDefaultNamespace("textures/gui/sprites/widget/checkbox.png");

    private boolean selected;
    private final OnValueChange onValueChange;

    public CustomCheckbox(int x, int y, int width, int height, Component message, boolean selected, OnValueChange onValueChange) {
        super(x, y, width, height, message);
        this.selected = selected;
        this.onValueChange = onValueChange;
    }

    @Override
    public void onPress() {
        this.selected = !this.selected;
        this.onValueChange.onValueChange(this, this.selected);
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        Minecraft minecraft = Minecraft.getInstance();
        ResourceLocation texture;
        if (this.selected) {
            texture = this.isHovered() ? CHECKBOX_SELECTED_HIGHLIGHTED : CHECKBOX_SELECTED;
        } else {
            texture = this.isHovered() ? CHECKBOX_HIGHLIGHTED : CHECKBOX;
        }

        guiGraphics.blit(texture, this.getX(), this.getY(), 0, 0, this.width, this.height, this.width, this.height);
        guiGraphics.drawString(minecraft.font, this.getMessage(), this.getX() + this.width + 4, this.getY() + (this.height - 8) / 2, 14737632);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {
        this.defaultButtonNarrationText(narrationElementOutput);
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public interface OnValueChange {
        void onValueChange(CustomCheckbox checkbox, boolean selected);
    }

    public static class Builder {
        private int x, y, width, height;
        private Component message;
        private boolean selected;
        private OnValueChange onValueChange;

        public Builder pos(int x, int y) {
            this.x = x;
            this.y = y;
            return this;
        }

        public Builder size(int width, int height) {
            this.width = width;
            this.height = height;
            return this;
        }

        public Builder message(Component message) {
            this.message = message;
            return this;
        }

        public Builder selected(boolean selected) {
            this.selected = selected;
            return this;
        }

        public Builder onValueChange(OnValueChange onValueChange) {
            this.onValueChange = onValueChange;
            return this;
        }

        public CustomCheckbox build() {
            return new CustomCheckbox(x, y, width, height, message, selected, onValueChange);
        }
    }
}
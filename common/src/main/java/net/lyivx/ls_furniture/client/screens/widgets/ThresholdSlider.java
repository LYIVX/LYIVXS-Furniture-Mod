package net.lyivx.ls_furniture.client.screens.widgets;

import net.lyivx.ls_furniture.client.screens.ModConfigScreen;
import net.lyivx.ls_furniture.common.config.Configs;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;

public class ThresholdSlider extends AbstractSliderButton {

    public static final int MAX_THRESHOLD = 200;

    public ThresholdSlider(int x, int y, int width, int height, Component message, double value) {
        super(x, y, width, height, message, value);
        this.updateMessage();
    }

    @Override
    protected void updateMessage() {
        this.setMessage(Component.literal("Threshold: " + getThreshold()));
    }

    @Override
    protected void applyValue() {
        Configs.SEARCH_BAR_THRESHOLD = getThreshold();
    }

    public int getThreshold() {
        return (int) (this.value * MAX_THRESHOLD);
    }

    public void setValueFromThreshold(int threshold) {
        this.value = Mth.clamp( (double) threshold / MAX_THRESHOLD, 0.0, 1.0);
        this.updateMessage();
        this.applyValue();
    }
}
package net.lyivx.ls_furniture.common.blocks.properties;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public enum ColorType implements StringRepresentable {
    WHITE(DyeColor.WHITE),
    LIGHT_GRAY(DyeColor.LIGHT_GRAY),
    GRAY(DyeColor.GRAY),
    BLACK(DyeColor.BLACK),
    BROWN(DyeColor.BROWN),
    RED(DyeColor.RED),
    ORANGE(DyeColor.ORANGE),
    YELLOW(DyeColor.YELLOW),
    LIME(DyeColor.LIME),
    GREEN(DyeColor.GREEN),
    CYAN(DyeColor.CYAN),
    LIGHT_BLUE(DyeColor.LIGHT_BLUE),
    BLUE(DyeColor.BLUE),
    MAGENTA(DyeColor.MAGENTA),
    PURPLE(DyeColor.PURPLE),
    PINK(DyeColor.PINK);

    private final DyeColor dyeColor;

    ColorType(DyeColor dyeColor) {
        this.dyeColor = dyeColor;
    }

    public DyeColor getDyeColor() {
        return dyeColor;
    }

    @Override
    public String getSerializedName() {
        return dyeColor.getName();
    }

    public static ColorType fromDyeColor(DyeColor dyeColor) {
        for (ColorType colorType : values()) {
            if (colorType.getDyeColor() == dyeColor) {
                return colorType;
            }
        }
        return WHITE; // Default or fallback value
    }

    // This method is used to convert from an integer id to ColorType
    public static ColorType fromId(int id) {
        for (ColorType colorType : values()) {
            if (colorType.getDyeColor().getId() == id) {
                return colorType;
            }
        }
        return WHITE; // Default or fallback value
    }

    public ItemStack getDyeItemStack() {
        switch (dyeColor) {
            case WHITE: return new ItemStack(Items.WHITE_DYE);
            case ORANGE: return new ItemStack(Items.ORANGE_DYE);
            case MAGENTA: return new ItemStack(Items.MAGENTA_DYE);
            case LIGHT_BLUE: return new ItemStack(Items.LIGHT_BLUE_DYE);
            case YELLOW: return new ItemStack(Items.YELLOW_DYE);
            case LIME: return new ItemStack(Items.LIME_DYE);
            case PINK: return new ItemStack(Items.PINK_DYE);
            case GRAY: return new ItemStack(Items.GRAY_DYE);
            case LIGHT_GRAY: return new ItemStack(Items.LIGHT_GRAY_DYE);
            case CYAN: return new ItemStack(Items.CYAN_DYE);
            case PURPLE: return new ItemStack(Items.PURPLE_DYE);
            case BLUE: return new ItemStack(Items.BLUE_DYE);
            case BROWN: return new ItemStack(Items.BROWN_DYE);
            case GREEN: return new ItemStack(Items.GREEN_DYE);
            case RED: return new ItemStack(Items.RED_DYE);
            case BLACK: return new ItemStack(Items.BLACK_DYE);
            default: return ItemStack.EMPTY;
        }
    }
}
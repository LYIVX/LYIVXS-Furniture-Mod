package net.lyivx.ls_furniture.common.blocks.properties;

import net.minecraft.util.StringRepresentable;

public enum LeafType implements StringRepresentable {
    OAK("oak"),
    SPRUCE("spruce"),
    BIRCH("birch"),
    JUNGLE("jungle"),
    ACACIA("acacia"),
    DARK_OAK("dark_oak"),
    MANGROVE("mangrove"),
    CHERRY("cherry"),
    CRIMSON("crimson"),
    WARPED("warepd"),
    FLOWERING_AZALEA("flowering_azalea"),
    AZALEA("azalea");

    private final String name;

    private LeafType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}
package net.lyivx.ls_furniture.registry.neoforge;

import net.lyivx.ls_furniture.registry.ModMenus;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class ModMenusImpl {
    public static <T extends AbstractContainerMenu> MenuType<T> create(ModMenus.MenuCreator<T> creator) {
        return new MenuType<>(creator::create, FeatureFlags.DEFAULT_FLAGS);
    }
}

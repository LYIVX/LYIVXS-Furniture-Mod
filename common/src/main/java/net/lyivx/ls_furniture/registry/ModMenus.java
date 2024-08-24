package net.lyivx.ls_furniture.registry;

import com.teamresourceful.resourcefullib.common.exceptions.NotImplementedException;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.menus.WorkstationMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class ModMenus {
    public static final ResourcefulRegistry<MenuType<?>> MENUS = ResourcefulRegistries.create(BuiltInRegistries.MENU, LYIVXsFurnitureMod.MOD_ID);

    public static final RegistryEntry<MenuType<WorkstationMenu>> WORKSTATION_MENU = MENUS.register("workstation",
            () -> create(WorkstationMenu::new));

    @ExpectPlatform
    public static <T extends AbstractContainerMenu> MenuType<T> create(MenuCreator<T> creator) {
        throw new NotImplementedException();
    }

    @FunctionalInterface
    public interface MenuCreator<T extends AbstractContainerMenu> {
        T create(int id, Inventory inventory);
    }

}

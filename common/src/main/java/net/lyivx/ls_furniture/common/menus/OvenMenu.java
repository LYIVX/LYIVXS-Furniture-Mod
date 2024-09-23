package net.lyivx.ls_furniture.common.menus;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class OvenMenu extends AbstractFurnaceMenu {

    public static Container container;

    public OvenMenu(int windowId, Level level, BlockPos blockPos, Inventory inv, Player player, Container container) {
        super(MenuType.SMOKER, RecipeType.SMOKING, RecipeBookType.SMOKER, windowId, inv);
        OvenMenu.container = container;
        container.startOpen(inv.player);
    }
    public OvenMenu(int containerId, Inventory playerInventory, Container furnaceContainer, ContainerData furnaceData, Container container) {
        super(MenuType.SMOKER, RecipeType.SMOKING, RecipeBookType.SMOKER, containerId, playerInventory, furnaceContainer, furnaceData);
        OvenMenu.container = furnaceContainer;
        container.startOpen(playerInventory.player);

    }

    @Override
    public boolean stillValid(Player player) {
        return super.stillValid(player);
    }

    public Container getContainer() {
        return this.container;
    }
}


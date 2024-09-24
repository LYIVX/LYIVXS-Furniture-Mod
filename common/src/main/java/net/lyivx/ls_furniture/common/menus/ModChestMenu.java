//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.lyivx.ls_furniture.common.menus;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class ModChestMenu extends AbstractContainerMenu {
    private static final int SLOTS_PER_ROW = 9;
    private final Container container;
    private final int containerRows;

    private ModChestMenu(MenuType<?> type, int containerId, Inventory playerInventory, int rows) {
        this(type, containerId, playerInventory, new SimpleContainer(9 * rows), rows);
    }

    public static ModChestMenu oneRow(int containerId, Inventory playerInventory) {
        return new ModChestMenu(MenuType.GENERIC_9x1, containerId, playerInventory, 1);
    }

    public static ModChestMenu twoRows(int containerId, Inventory playerInventory) {
        return new ModChestMenu(MenuType.GENERIC_9x2, containerId, playerInventory, 2);
    }

    public static ModChestMenu threeRows(int containerId, Inventory playerInventory) {
        return new ModChestMenu(MenuType.GENERIC_9x3, containerId, playerInventory, 3);
    }

    public static ModChestMenu fourRows(int containerId, Inventory playerInventory) {
        return new ModChestMenu(MenuType.GENERIC_9x4, containerId, playerInventory, 4);
    }

    public static ModChestMenu fiveRows(int containerId, Inventory playerInventory) {
        return new ModChestMenu(MenuType.GENERIC_9x5, containerId, playerInventory, 5);
    }

    public static ModChestMenu sixRows(int containerId, Inventory playerInventory) {
        return new ModChestMenu(MenuType.GENERIC_9x6, containerId, playerInventory, 6);
    }

    public static ModChestMenu oneRows(int containerId, Inventory playerInventory, Container container) {
        return new ModChestMenu(MenuType.GENERIC_9x1, containerId, playerInventory, container, 1);
    }

    public static ModChestMenu twoRows(int containerId, Inventory playerInventory, Container container) {
        return new ModChestMenu(MenuType.GENERIC_9x2, containerId, playerInventory, container, 2);
    }

    public static ModChestMenu threeRows(int containerId, Inventory playerInventory, Container container) {
        return new ModChestMenu(MenuType.GENERIC_9x3, containerId, playerInventory, container, 3);
    }

    public static ModChestMenu fourRows(int containerId, Inventory playerInventory, Container container) {
        return new ModChestMenu(MenuType.GENERIC_9x4, containerId, playerInventory, container, 4);
    }

    public static ModChestMenu fiveRows(int containerId, Inventory playerInventory, Container container) {
        return new ModChestMenu(MenuType.GENERIC_9x5, containerId, playerInventory, container, 5);
    }

    public static ModChestMenu sixRows(int containerId, Inventory playerInventory, Container container) {
        return new ModChestMenu(MenuType.GENERIC_9x6, containerId, playerInventory, container, 6);
    }

    public ModChestMenu(MenuType<?> type, int containerId, Inventory playerInventory, Container container, int rows) {
        super(type, containerId);
        checkContainerSize(container, rows * 9);
        this.container = container;
        this.containerRows = rows;
        container.startOpen(playerInventory.player);
        int i = (this.containerRows - 4) * 18;

        int j;
        int k;
        for(j = 0; j < this.containerRows; ++j) {
            for(k = 0; k < 9; ++k) {
                this.addSlot(new Slot(container, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        for(j = 0; j < 3; ++j) {
            for(k = 0; k < 9; ++k) {
                this.addSlot(new Slot(playerInventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
            }
        }

        for(j = 0; j < 9; ++j) {
            this.addSlot(new Slot(playerInventory, j, 8 + j * 18, 161 + i));
        }

    }

    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = (Slot)this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemStack2 = slot.getItem();
            itemStack = itemStack2.copy();
            if (index < this.containerRows * 9) {
                if (!this.moveItemStackTo(itemStack2, this.containerRows * 9, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemStack2, 0, this.containerRows * 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemStack;
    }

    public void removed(Player player) {
        super.removed(player);
        this.container.stopOpen(player);
    }

    public Container getContainer() {
        return this.container;
    }

    public int getRowCount() {
        return this.containerRows;
    }
}

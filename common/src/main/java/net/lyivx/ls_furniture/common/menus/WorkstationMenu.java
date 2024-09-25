package net.lyivx.ls_furniture.common.menus;

import com.google.common.collect.Lists;
import net.lyivx.ls_furniture.common.recipes.FilterableRecipe;
import net.lyivx.ls_furniture.common.recipes.RecipeSorter;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModMenus;
import net.lyivx.ls_furniture.registry.ModRecipes;
import net.lyivx.ls_furniture.registry.ModSoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

import java.util.List;

public class WorkstationMenu extends AbstractContainerMenu  {
    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipeIndex;
    private final Level level;
    public final Container container;
    private final Slot inputSlot;
    private final Slot resultSlot;

    private List<FilterableRecipe> recipes;
    private ItemStack input;
    private long lastSoundTime;
    private final ResultContainer resultContainer;
    private Runnable slotUpdateListener;
    private FilterableRecipe lastSelectedRecipe = null;


    public WorkstationMenu(int i, Inventory inventory) {
        this(i, inventory, ContainerLevelAccess.NULL);
    }

    public WorkstationMenu(int i, Inventory inventory, final ContainerLevelAccess containerLevelAccess) {
        super(ModMenus.WORKSTATION_MENU.get(), i);
        this.selectedRecipeIndex = DataSlot.standalone();
        this.recipes = Lists.newArrayList();
        this.input = ItemStack.EMPTY;
        this.slotUpdateListener = () -> {
        };
        this.container = new SimpleContainer(1) {
            @Override
            public void setChanged() {
                super.setChanged();
                slotsChanged(this);
                slotUpdateListener.run();
            }
        };
        this.resultContainer = new ResultContainer();
        this.access = containerLevelAccess;
        this.level = inventory.player.level();
        this.inputSlot = this.addSlot(new Slot(this.container, 0, 17, 33));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1, 146, 33) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level(), player, stack.getCount());
                resultContainer.awardUsedRecipes(player, this.getRelevantItems());
                ItemStack itemStack = inputSlot.remove(recipes.get(selectedRecipeIndex.get())
                        .recipe().getInputCount());
                if (!itemStack.isEmpty()) {
                    setupResultSlot();
                }

                containerLevelAccess.execute((level, blockPos) -> {
                    long l = level.getGameTime();
                    if (lastSoundTime != l) {
                        level.playSound(null, blockPos, ModSoundEvents.WORKSTATION_TAKE.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
                        lastSoundTime = l;
                    }

                });
                super.onTake(player, stack);
            }

            private List<ItemStack> getRelevantItems() {
                return List.of(inputSlot.getItem());
            }
        });

        int j;
        for (j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(inventory, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
            }
        }

        for (j = 0; j < 9; ++j) {
            this.addSlot(new Slot(inventory, j, 8 + j * 18, 142));
        }

        this.addDataSlot(this.selectedRecipeIndex);
    }


    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    public List<FilterableRecipe> getRecipes() {
        return this.recipes;
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, ModBlocks.WORKSTATION.get());
    }

    @Override
    public boolean clickMenuButton(Player player, int id) {
        // hack since the freaking packet sends a byte not an int
        id = Byte.toUnsignedInt((byte)id);
        if (this.isValidRecipeIndex(id) || id == 255) {
            this.selectedRecipeIndex.set(id);
            this.setupResultSlot();
        }
        return true;
    }

    private boolean isValidRecipeIndex(int recipeIndex) {
        return recipeIndex >= 0 && recipeIndex < this.recipes.size();
    }

    @Override
    public void slotsChanged(Container container) {
        ItemStack itemStack = this.inputSlot.getItem();
        ItemStack old = this.input;
        boolean sameStack = itemStack.is(old.getItem());
        int maxItemsThatCanBeConsumed = 5; //I made it the f up
        if (!sameStack || itemStack.getCount() < maxItemsThatCanBeConsumed || old.getCount() < maxItemsThatCanBeConsumed) {
            this.input = itemStack.copy();
            this.setupRecipeList(container, itemStack);
        }

    }

    private static SingleRecipeInput createRecipeInput(Container container) {
        return new SingleRecipeInput(container.getItem(0));
    }

    private void setupRecipeList(Container container, ItemStack stack) {
        this.selectedRecipeIndex.set(-1);

        this.resultSlot.set(ItemStack.EMPTY);
        if (!stack.isEmpty()) {
            var matching = this.level.getRecipeManager()
                    .getRecipesFor(ModRecipes.WORKSTATION_RECIPE.get(), createRecipeInput(container), this.level);

            RecipeSorter.sort(matching, this.level);

            recipes = matching.stream().map(FilterableRecipe::of).toList();
            // at most 256 recipes
            recipes = recipes.subList(0, Math.min(recipes.size(), 255));

            //preserve last clicked recipe on recipe change
            if (lastSelectedRecipe != null) {
                int newInd = this.recipes.indexOf(lastSelectedRecipe);
                if (newInd != -1) {
                    this.selectedRecipeIndex.set(newInd);
                }
            }
        }

        lastSelectedRecipe = null;
    }

    void setupResultSlot() {
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            FilterableRecipe selected = this.recipes.get(this.selectedRecipeIndex.get());
            this.lastSelectedRecipe = selected;
            ItemStack itemStack = selected.recipe().assemble(createRecipeInput(container), this.level.registryAccess());
            if (itemStack.isItemEnabled(this.level.enabledFeatures())) {
                this.resultContainer.setRecipeUsed(selected.recipeHolder());
                this.resultSlot.set(itemStack);
            } else {
                this.resultSlot.set(ItemStack.EMPTY);
            }
        } else {
            this.resultSlot.set(ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    @Override
    public MenuType<?> getType() {
        return ModMenus.WORKSTATION_MENU.get();
    }

    public void registerUpdateListener(Runnable listener) {
        this.slotUpdateListener = listener;
    }

    @Override
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.resultContainer && super.canTakeItemForPickAll(stack, slot);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack itemStack2 = slot.getItem();
            Item item = itemStack2.getItem();
            itemStack = itemStack2.copy();
            if (index == 1) {
                item.onCraftedBy(itemStack2, player.level(), player);
                if (!this.moveItemStackTo(itemStack2, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemStack2, itemStack);
            } else if (index == 0) {
                if (!this.moveItemStackTo(itemStack2, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(ModRecipes.WORKSTATION_RECIPE.get(), new SingleRecipeInput(itemStack2), this.level).isPresent()) {
                if (!this.moveItemStackTo(itemStack2, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 2 && index < 29) {
                if (!this.moveItemStackTo(itemStack2, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 29 && index < 38 && !this.moveItemStackTo(itemStack2, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemStack2);
            this.broadcastChanges();
        }

        return itemStack;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((level, blockPos) -> {
            this.clearContainer(player, this.container);
        });
    }
}
package net.lyivx.ls_furniture.common.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.placement.HorizontalAlignment;
import mezz.jei.api.gui.placement.VerticalAlignment;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.library.util.RecipeUtil;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.recipes.WorkstationRecipe;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.MOD_ID;
import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;

public class WorkstationRecipeCategory extends AbstractRecipeCategory<List<WorkstationRecipe>> {

    public static final ResourceLocation ID = createResourceLocation("workstation");
    public static final RecipeType<List<WorkstationRecipe>> WORKSTATION_RECIPE_TYPE = new RecipeType<>(ID, (Class<List<WorkstationRecipe>>) (Class<?>) List.class);

    public static final int width = 106;
    public static final int height = 74;

    public WorkstationRecipeCategory(IGuiHelper guiHelper) {
        super(
                WORKSTATION_RECIPE_TYPE,
                Component.translatable("gui.ls_furniture.jei.workstation"),
                guiHelper.createDrawableItemLike(ModItems.WORKSTATION.get()),
                width,
                height
        );
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, List<WorkstationRecipe> recipes, IFocusGroup focuses) {
        if (recipes.isEmpty()) {
            return;
        }

        // Use the first recipe for the input slot
        WorkstationRecipe firstRecipe = recipes.get(0);

        // Add the input ingredient in the middle of the top area
        builder.addInputSlot(0, 0)
                .setStandardSlotBackground()
                .setPosition(0,1, getWidth(), getHeight(), HorizontalAlignment.CENTER, VerticalAlignment.TOP)
                .addIngredients(firstRecipe.ingredient())
                .setSlotName("input");

        // Add all possible outputs in a grid
        List<ItemStack> results = recipes.stream()
                .map(WorkstationRecipe::result)
                .collect(Collectors.toList());

        for (ItemStack result : results) {
            builder.addOutputSlot()
                    .setStandardSlotBackground()
                    .addItemStack(result)
                    .setSlotName("outputs");
        }
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, List<WorkstationRecipe> recipes, IFocusGroup focuses) {
        if (recipes.isEmpty()) {
            return;
        }

        // Get the first recipe to display input count if needed
        WorkstationRecipe firstRecipe = recipes.get(0);

        // Add text showing input count if more than 1, to the right of the input
        if (firstRecipe.getInputCount() > 1) {
            builder.addDrawable(new IDrawable() {
                @Override
                public int getWidth() {
                    return 30;
                }

                @Override
                public int getHeight() {
                    return 20;
                }

                @Override
                public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
                    String countText = "x" + firstRecipe.getInputCount();
                    guiGraphics.drawString(
                            Minecraft.getInstance().font,
                            countText,
                            xOffset,
                            yOffset + 5,
                            0xFF404040,
                            false
                    );
                }
            }, getWidth() / 2 + 10, 0);
        }

        // Get all output slots and add them to a grid below the input
        List<IRecipeSlotDrawable> outputs = builder.getRecipeSlots().getSlots(RecipeIngredientRole.OUTPUT);

        builder.addScrollGridWidget(outputs, 5, 3)
                .setPosition(0, 0, getWidth(), getHeight(), HorizontalAlignment.CENTER, VerticalAlignment.BOTTOM);
    }
}
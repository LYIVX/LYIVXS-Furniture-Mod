package net.lyivx.ls_furniture.common.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
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
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class WorkstationRecipeCategory extends BaseCategory<WorkstationRecipe> {

    private static final ItemStack WORKSTATION = new ItemStack(ModBlocks.WORKSTATION.get());
    public static final ResourceLocation ID = new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "workstation");
    public static final RecipeType<WorkstationRecipe> WORKSTATION_RECIPE_TYPE = new RecipeType<>(ID, WorkstationRecipe.class);

    private final IGuiHelper guiHelper;

    public static final int width = 82;
    public static final int height = 34;


    public WorkstationRecipeCategory(IGuiHelper guiHelper) {
        super(guiHelper, WORKSTATION_RECIPE_TYPE,
                Component.translatable("gui.ls_furniture.jei.workstation"),
                guiHelper.createBlankDrawable(width, height),
                guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(WORKSTATION.getItem())));
        this.guiHelper = guiHelper;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull WorkstationRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 9)
                .setStandardSlotBackground()
                .addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 9)
                .setOutputSlotBackground().
                addItemStack(RecipeUtil.getResultItem(recipe));
    }

    @Override
    public void draw(WorkstationRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {

        guiGraphics.renderItemDecorations(Minecraft.getInstance().font,
                new ItemStack(ModItems.WORKSTATION.get(), recipe.getInputCount()), 1,9);

        IDrawableStatic recipeArrow = guiHelper.getRecipeArrow();
        recipeArrow.draw(guiGraphics, 26, 9);
    }
}
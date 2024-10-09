package net.lyivx.ls_furniture.common.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.recipes.ChoppingBoardRecipe;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;


public class ChoppingBoardCategory extends BaseCategory<ChoppingBoardRecipe> {

    private static final ItemStack CHOPPING_BOARD = new ItemStack(ModBlocks.CHOPPING_BOARD.get());
    public static final ResourceLocation ID = createResourceLocation("chopping_board");
    public static final RecipeType<ChoppingBoardRecipe> CHOPPING_BOARD_RECIPE_TYPE = new RecipeType<>(ID, ChoppingBoardRecipe.class);
    public static final ResourceLocation GUI_BACK = createResourceLocation("textures/gui/container/chopping_board.png");


    public ChoppingBoardCategory(IGuiHelper guiHelper) {
        super(guiHelper, CHOPPING_BOARD_RECIPE_TYPE,
                Component.translatable("gui.ls_furniture.jei.chopping_board"),
                guiHelper.drawableBuilder(GUI_BACK, 0, 0, 74, 108).build(),
                guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CHOPPING_BOARD.get())));
    }

    @Override
    @SuppressWarnings("removal")
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull ChoppingBoardRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 29, 6)
                .addIngredients(recipe.ingredient())
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank")))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("gui.ls_furniture.jei.chopping_board.chops", recipe.getUses())))
                .setSlotName("input");

        builder.addSlot(RecipeIngredientRole.OUTPUT, 29, 82)
                .addIngredient(VanillaTypes.ITEM_STACK, recipe.result())
                .setSlotName("output");

        builder.addSlot(RecipeIngredientRole.CATALYST, 56, 42)
                .addIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Items.DIAMOND_AXE))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank")))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("gui.ls_furniture.jei.chopping_board.chops", recipe.getUses())))
                .setSlotName("axe");

        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 29, 42)
                .addIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CHOPPING_BOARD.get(), recipe.getUses()))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank")))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("gui.ls_furniture.jei.chopping_board.chops", recipe.getUses())))
                .setSlotName("chopping_board");

    }
}
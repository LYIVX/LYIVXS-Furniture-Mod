package net.lyivx.ls_furniture.common.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.lyivx.ls_furniture.common.recipes.CuttingBoardRecipe;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;


public class CuttingBoardCategory extends BaseCategory<CuttingBoardRecipe> {

    private static final ItemStack CUTTING_BOARD = new ItemStack(ModBlocks.CUTTING_BOARD.get());
    public static final ResourceLocation ID = createResourceLocation("cutting_board");
    public static final RecipeType<CuttingBoardRecipe> CUTTING_BOARD_RECIPE_TYPE = new RecipeType<>(ID, CuttingBoardRecipe.class);
    public static final ResourceLocation GUI_BACK = createResourceLocation("textures/gui/container/cutting_board.png");


    public CuttingBoardCategory(IGuiHelper guiHelper) {
        super(guiHelper, CUTTING_BOARD_RECIPE_TYPE,
                Component.translatable("gui.ls_furniture.jei.cutting_board"),
                guiHelper.drawableBuilder(GUI_BACK, 0, 0, 74, 108).build(),
                guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CUTTING_BOARD.get())));
    }

    @Override
    @SuppressWarnings("removal")
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull CuttingBoardRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 29, 6)
                .addIngredients(recipe.input())
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank")))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("gui.ls_furniture.jei.chopping_board.chops", recipe.getUses())))
                .setSlotName("input");

        builder.addSlot(RecipeIngredientRole.OUTPUT, 29, 82)
                .addIngredient(VanillaTypes.ITEM_STACK, recipe.getResultItem())
                .setSlotName("output");

        builder.addSlot(RecipeIngredientRole.CATALYST, 56, 42)
                .addIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModItems.KNIFE.get()))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank")))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("gui.ls_furniture.jei.chopping_board.chops", recipe.getUses())))
                .setSlotName("axe");

        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 29, 42)
                .addIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CUTTING_BOARD.get(), recipe.getUses()))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank")))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("gui.ls_furniture.jei.chopping_board.chops", recipe.getUses())))
                .setSlotName("cutting_board");

    }
}
package net.lyivx.ls_furniture.common.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.recipes.WorldInteractionRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class WorldInteractionRecipeCategory extends BaseCategory<WorldInteractionRecipe> {

    private static final ItemStack WORLD_INTERACTION = new ItemStack(Blocks.GRASS_BLOCK);
    public static final ResourceLocation ID = new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "world_interaction");
    public static final RecipeType<WorldInteractionRecipe> WORLD_INTERACTION_RECIPE_TYPE = new RecipeType<>(ID, WorldInteractionRecipe.class);
    public static final ResourceLocation GUI_BACK = new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "textures/gui/container/world_interaction.png");


    public WorldInteractionRecipeCategory(IGuiHelper guiHelper) {
        super(guiHelper, WORLD_INTERACTION_RECIPE_TYPE,
                Component.translatable("gui.ls_furniture.jei.world_interaction"),
                guiHelper.drawableBuilder(GUI_BACK, 0, 0, 74, 72).build(),
                guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Blocks.GRASS_BLOCK)));
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull WorldInteractionRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 11, 6)
                .addIngredients(recipe.input())
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank")))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("gui.ls_furniture.jei.world_interaction.use", recipe.uses())))
                .setSlotName("input");

        builder.addSlot(RecipeIngredientRole.CATALYST, 47, 6)
                .addIngredients(recipe.input2())
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank")))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("gui.ls_furniture.jei.world_interaction.use_on", recipe.uses())))
                .setSlotName("tool");

        builder.addSlot(RecipeIngredientRole.OUTPUT, 29, 46)
                .addIngredient(VanillaTypes.ITEM_STACK, recipe.output())
                .setSlotName("output");
    }
}
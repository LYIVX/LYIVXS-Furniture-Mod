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
import org.jetbrains.annotations.Nullable;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;

public class WorkstationRecipeCategory implements IRecipeCategory<WorkstationRecipe> {

    public static final ResourceLocation ID = createResourceLocation("workstation");
    public static final RecipeType<WorkstationRecipe> WORKSTATION_RECIPE_TYPE = new RecipeType<>(ID, WorkstationRecipe.class);
    public static final ResourceLocation GUI_BACK = createResourceLocation("textures/gui/container/workstation_jei.png");

    public static final int width = 82;
    public static final int height = 34;

    private final IDrawable icon;
    private final Component localizedName;
    private final IGuiHelper guiHelper;
    private final IDrawable components;


    public WorkstationRecipeCategory(IGuiHelper guiHelper) {
        this.guiHelper = guiHelper;
        icon = guiHelper.createDrawableItemStack(ModBlocks.WORKSTATION.get().asItem().getDefaultInstance());
        localizedName = Component.translatable("gui.ls_furniture.jei.workstation");
        components = guiHelper.drawableBuilder(GUI_BACK, 0, 0, width, height)
                .setTextureSize(width, height)
                .build();
    }

    @Override
    public RecipeType<WorkstationRecipe> getRecipeType() {
        return WORKSTATION_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return localizedName;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull WorkstationRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 6, 9)
                .addIngredients(recipe.ingredient());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 57, 9)
                .addItemStack(recipe.result());
    }

    @Override
    public void draw(WorkstationRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        components.draw(guiGraphics, 0, 0);

        guiGraphics.renderItemDecorations(Minecraft.getInstance().font,
                new ItemStack(ModItems.WORKSTATION.get(), recipe.getInputCount()), 6,9);
    }
}
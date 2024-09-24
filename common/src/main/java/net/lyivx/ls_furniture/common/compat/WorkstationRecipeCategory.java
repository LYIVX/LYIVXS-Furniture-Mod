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

public class WorkstationRecipeCategory implements IRecipeCategory<WorkstationRecipe> {

    public static final ResourceLocation ID = new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "workstation");
    public static final RecipeType<WorkstationRecipe> WORKSTATION_RECIPE_TYPE = new RecipeType<>(ID, WorkstationRecipe.class);

    public static final int width = 82;
    public static final int height = 34;

    private final IDrawable background;
    private final IDrawable icon;
    private final Component localizedName;
    private final IGuiHelper guiHelper;
    private final IDrawable arrow;


    public WorkstationRecipeCategory(IGuiHelper guiHelper) {
        this.guiHelper = guiHelper;
        background = guiHelper.createBlankDrawable(width, height);
        icon = guiHelper.createDrawableItemStack(ModBlocks.WORKSTATION.get().asItem().getDefaultInstance());
        localizedName = Component.translatable("gui.ls_furniture.jei.workstation");
        arrow = guiHelper.drawableBuilder(new ResourceLocation("jei", "textures/gui/gui_vanilla.png"), 82, 128, 24, 17)
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
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull WorkstationRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 9)
                .addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 9)
                .addItemStack(RecipeUtil.getResultItem(recipe));
    }

    @Override
    public void draw(WorkstationRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {

        guiGraphics.renderItemDecorations(Minecraft.getInstance().font,
                new ItemStack(ModItems.WORKSTATION.get(), recipe.getInputCount()), 1,9);

        arrow.draw(guiGraphics, 26, 9);
    }
}
package net.mcreator.lsfurniture;


import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.mcreator.lsfurniture.init.LsFurnitureModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class CarpentryRecipeCategory implements IRecipeCategory<CarpentryRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(LsFurnitureMod.MODID, "carpentry");
    public final static ResourceLocation TEXTURE = new ResourceLocation(LsFurnitureMod.MODID, "textures/screens/furniture_crafter_gui.png");

    private final IDrawableBuilder background;
    private final IDrawable icon;


    public CarpentryRecipeCategory(IGuiHelper helper) {
        this.background = helper.drawableBuilder(TEXTURE, 0, 0, 88, 72).setTextureSize(88,72);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(LsFurnitureModBlocks.FURNITURE_CRAFTER.get()));
    }

    @Override
    public RecipeType<CarpentryRecipe> getRecipeType() {
        return JeiPlugin.CARPENTRY_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Carpentry");
    }


    public IDrawable getBackground() {
        return this.background.build();
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CarpentryRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 8, 8).addIngredients(recipe.getIngredients().get(0)).setSlotName("Primary");
        builder.addSlot(RecipeIngredientRole.INPUT, 28, 8).addIngredients(recipe.getIngredients().get(1)).setSlotName("Secondary");
        builder.addSlot(RecipeIngredientRole.INPUT, 8, 28).addIngredients(recipe.getIngredients().get(2)).setSlotName("Bark");
        builder.addSlot(RecipeIngredientRole.INPUT, 28, 28).addIngredients(recipe.getIngredients().get(3)).setSlotName("Dye");
        builder.addSlot(RecipeIngredientRole.INPUT, 28, 48).addIngredients(recipe.getIngredients().get(4)).setSlotName("Tool");

        builder.addSlot(RecipeIngredientRole.OUTPUT, 64, 28).addItemStack(recipe.getResultItem(null));

    }
}
/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.lsfurniture as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
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

public class MasonryTickRecipeCategory implements IRecipeCategory<MasonryTickRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(LsFurnitureMod.MODID, "masonry_tick");
    public final static ResourceLocation TEXTURE = new ResourceLocation(LsFurnitureMod.MODID, "textures/screens/furniture_crafter_gui_tick.png");

    private final IDrawableBuilder background;
    private final IDrawable icon;


    public MasonryTickRecipeCategory(IGuiHelper helper) {
        this.background = helper.drawableBuilder(TEXTURE, 0, 0, 88, 72).setTextureSize(88,72);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(LsFurnitureModBlocks.FURNITURE_CRAFTER.get()));
    }

    @Override
    public RecipeType<MasonryTickRecipe> getRecipeType() {
        return JeiPlugin.MASONRY_TICK_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Masonry");
    }


    public IDrawable getBackground() {
    return this.background.build();
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, MasonryTickRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 8, 8).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 28, 8).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 8, 28).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 28, 28).addIngredients(recipe.getIngredients().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 28, 48).addIngredients(recipe.getIngredients().get(4));


        builder.addSlot(RecipeIngredientRole.OUTPUT, 64, 28).addItemStack(recipe.getResultItem(null));

    }
}
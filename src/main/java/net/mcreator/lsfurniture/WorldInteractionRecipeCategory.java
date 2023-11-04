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
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.GrassBlock;

public class WorldInteractionRecipeCategory implements IRecipeCategory<WorldInteractionRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(LsFurnitureMod.MODID, "world_interaction");
    public final static ResourceLocation TEXTURE = new ResourceLocation(LsFurnitureMod.MODID, "textures/screens/world_interaction.png");

    private final IDrawableBuilder background;
    private final IDrawable icon;


    public WorldInteractionRecipeCategory(IGuiHelper helper) {
        this.background = helper.drawableBuilder(TEXTURE, 0, 0, 125, 18).setTextureSize(125,18);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Items.GRASS_BLOCK));
    }

    @Override
    public RecipeType<WorldInteractionRecipe> getRecipeType() {
        return JeiPlugin.WORLD_INTERACTION_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("World Interaction");
    }


    public IDrawable getBackground() {
        return this.background.build();
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, WorldInteractionRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1).addIngredients(recipe.getIngredients().get(0)).setSlotName("Primary");
        builder.addSlot(RecipeIngredientRole.INPUT, 50, 1).addIngredients(recipe.getIngredients().get(1)).setSlotName("Tool");


        builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 1).addItemStack(recipe.getResultItem());
    }
}
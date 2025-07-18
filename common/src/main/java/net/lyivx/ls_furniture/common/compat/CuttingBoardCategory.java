package net.lyivx.ls_furniture.common.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.recipes.CuttingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.WorldInteractionRecipe;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;


public class CuttingBoardCategory extends AbstractRecipeCategory<CuttingBoardRecipe> {

    private static final ItemStack CUTTING_BOARD = new ItemStack(ModBlocks.CUTTING_BOARD.get());
    public static final ResourceLocation ID = createResourceLocation("cutting_board");
    public static final RecipeType<CuttingBoardRecipe> CUTTING_BOARD_RECIPE_TYPE = new RecipeType<>(ID, CuttingBoardRecipe.class);
    public static final ResourceLocation CUTTING_BOARD_ICON = createResourceLocation("textures/gui/icons/cutting_board.png");
    public static final ResourceLocation LEFT_ARROW = createResourceLocation("textures/gui/icons/left_arrow.png");
    public static final ResourceLocation DOWN_ARROW = createResourceLocation("textures/gui/icons/down_arrow.png");

    public static final int width = 54;
    public static final int height = 98;

    public CuttingBoardCategory(IGuiHelper guiHelper) {
        super(
                CUTTING_BOARD_RECIPE_TYPE,
                Component.translatable("gui.ls_furniture.jei.cutting_board"),
                guiHelper.createDrawableItemLike(CUTTING_BOARD.getItem()),
                width,
                height
        );
    }

    @Override
    @SuppressWarnings("removal")
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull CuttingBoardRecipe recipe, @NotNull IFocusGroup focuses) {
        // First input (left side)
        builder.addInputSlot(19, 10)
                .addIngredients(recipe.getIngredients().get(0))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank")))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("gui.ls_furniture.jei.chopping_board.chops", recipe.getUses())))
                .setSlotName("input");

        // Remove the RENDER_ONLY slot - will be replaced with a drawable

        // Knife
        builder.addInputSlot(0, 0)
                .addIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModItems.KNIFE.get()))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank")))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("gui.ls_furniture.jei.chopping_board.chops", recipe.getUses())))
                .setSlotName("knife");

        // Output (bottom center)
        builder.addOutputSlot(19, 77)
                .setOutputSlotBackground()
                .addItemStack(recipe.result())
                .setSlotName("output");
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, CuttingBoardRecipe recipe, IFocusGroup focuses) {

        IDrawable cutting_board = new IDrawable() {
            @Override
            public int getWidth() {
                return 42;
            }

            @Override
            public int getHeight() {
                return 42;
            }

            @Override
            public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
                guiGraphics.blit(CUTTING_BOARD_ICON, xOffset, yOffset, 0, 0, 50, 50, 50, 50);
            }
        };

        // Add arrow textures to indicate the crafting process
        IDrawable leftArrow = new IDrawable() {
            @Override
            public int getWidth() {
                return 24;
            }

            @Override
            public int getHeight() {
                return 24;
            }

            @Override
            public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
                guiGraphics.blit(LEFT_ARROW, xOffset, yOffset, 0, 0, 22, 22, 22, 22);
            }
        };

        IDrawable downArrow = new IDrawable() {
            @Override
            public int getWidth() {
                return 22;
            }

            @Override
            public int getHeight() {
                return 22;
            }

            @Override
            public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
                guiGraphics.blit(DOWN_ARROW, xOffset, yOffset, 0, 0, 22, 22, 22, 22);
            }
        };

        IDrawable chopsText = new IDrawable() {
            @Override
            public int getWidth() {
                return 22;
            }

            @Override
            public int getHeight() {
                return 22;
            }

            @Override
            public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
                Component text = Component.translatable("gui.ls_furniture.jei.chopping_board.chops", recipe.getUses());
                
                // Save the current transformation state
                guiGraphics.pose().pushPose();
                
                // Apply scale transformation (0.75f = 75% of original size)
                guiGraphics.pose().scale(0.6f, 0.6f, 1.0f);
                
                // Draw the text with adjusted position to account for scaling
                guiGraphics.drawString(
                        Minecraft.getInstance().font,
                        text,
                        Math.round(xOffset / 0.6f),
                        Math.round(yOffset / 0.6f),
                        0xFF808080,
                        false
                );
                
                // Restore the original transformation state
                guiGraphics.pose().popPose();
            }
        };

        // Adds Cutting board icon
        builder.addDrawable(cutting_board, 2, -10);
        // Place the arrows to connect the ingredients and output
        builder.addDrawable(downArrow, 16, 47);
        // Add chops text
        builder.addDrawable(chopsText, 1, 39);
    }
}
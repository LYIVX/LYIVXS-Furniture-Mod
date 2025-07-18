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
import net.lyivx.ls_furniture.common.recipes.ChoppingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.WorldInteractionRecipe;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;


public class ChoppingBoardCategory extends AbstractRecipeCategory<ChoppingBoardRecipe> {

    private static final ItemStack CHOPPING_BOARD = new ItemStack(ModBlocks.CHOPPING_BOARD.get());
    public static final ResourceLocation ID = createResourceLocation("chopping_board");
    public static final RecipeType<ChoppingBoardRecipe> CHOPPING_BOARD_RECIPE_TYPE = new RecipeType<>(ID, ChoppingBoardRecipe.class);
    public static final ResourceLocation CHOPPING_BOARD_ICON = createResourceLocation("textures/gui/icons/chopping_board.png");
    public static final ResourceLocation LEFT_ARROW = createResourceLocation("textures/gui/icons/left_arrow.png");
    public static final ResourceLocation DOWN_ARROW = createResourceLocation("textures/gui/icons/down_arrow.png");

    public static final int width = 54;
    public static final int height = 98;

    public ChoppingBoardCategory(IGuiHelper guiHelper) {
        super(
                CHOPPING_BOARD_RECIPE_TYPE,
                Component.translatable("gui.ls_furniture.jei.chopping_board"),
                guiHelper.createDrawableItemLike(CHOPPING_BOARD.getItem()),
                width,
                height
        );
    }

    @Override
    @SuppressWarnings("removal")
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull ChoppingBoardRecipe recipe, @NotNull IFocusGroup focuses) {
        // First input (left side)
        builder.addInputSlot(19, 2)
                .addIngredients(recipe.getIngredients().get(0))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank")))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("gui.ls_furniture.jei.chopping_board.chops", recipe.getUses())))
                .setSlotName("input");

        // Get all items from the axe tag
        List<ItemStack> axeStacks = new ArrayList<>();
        
        // Get all items from the axe tag
        Ingredient axeIngredient = Ingredient.of(ItemTags.AXES);
        ItemStack[] axesFromTag = axeIngredient.getItems();
        
        // Add all axes from the tag to our list
        for (ItemStack axe : axesFromTag) {
            axeStacks.add(axe);
        }
        
        builder.addInputSlot(0, 0)
                .addItemStacks(axeStacks)
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("tooltip.ls_furniture.screen.blank")))
                .addTooltipCallback((view, tooltip) -> tooltip.add(Component.translatable("gui.ls_furniture.jei.chopping_board.chops", recipe.getUses())))
                .setSlotName("axe");

        // Output (bottom center)
        builder.addOutputSlot(19, 77)
                .setOutputSlotBackground()
                .addItemStack(recipe.result())
                .setSlotName("output");
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, ChoppingBoardRecipe recipe, IFocusGroup focuses) {

        IDrawable chopping_board = new IDrawable() {
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
                guiGraphics.blit(CHOPPING_BOARD_ICON, xOffset, yOffset, 0, 0, 50, 50, 50, 50);
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

        // Adds Chopping board icon
        builder.addDrawable(chopping_board, 2, -12);
        // Place the arrows to connect the ingredients and output
        builder.addDrawable(downArrow, 16, 47);
        // Add chops text
        builder.addDrawable(chopsText, 1, 39);
    }
}
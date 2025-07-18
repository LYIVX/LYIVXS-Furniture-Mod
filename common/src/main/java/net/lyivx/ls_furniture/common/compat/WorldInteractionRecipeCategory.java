package net.lyivx.ls_furniture.common.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.lyivx.ls_furniture.common.recipes.WorldInteractionRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;

public class WorldInteractionRecipeCategory extends AbstractRecipeCategory<WorldInteractionRecipe> {

    private static final ItemStack WORLD_INTERACTION = new ItemStack(Blocks.GRASS_BLOCK);
    public static final ResourceLocation ID = createResourceLocation("world_interaction");
    public static final RecipeType<WorldInteractionRecipe> WORLD_INTERACTION_RECIPE_TYPE = new RecipeType<>(ID, WorldInteractionRecipe.class);
    public static final ResourceLocation LEFT_ARROW = createResourceLocation("textures/gui/icons/left_arrow.png");
    public static final ResourceLocation DOWN_ARROW = createResourceLocation("textures/gui/icons/down_arrow.png");

    public static final int width = 62;
    public static final int height = 86;
    
    // Store calculated scales for each recipe
    private final Map<WorldInteractionRecipe, Float> recipeTextScales = new HashMap<>();

    public WorldInteractionRecipeCategory(IGuiHelper guiHelper) {
        super(
                WORLD_INTERACTION_RECIPE_TYPE,
                Component.translatable("gui.ls_furniture.jei.world_interaction"),
                guiHelper.createDrawableItemLike(WORLD_INTERACTION.getItem()),
                width,
                height
        );
    }
    
    // Calculate the text scale needed to fit text on two lines
    private void calculateTextScale(WorldInteractionRecipe recipe) {
        if (recipeTextScales.containsKey(recipe)) {
            return; // Already calculated
        }
        
        // Create formatted component for text measurement
        Component text = getFormattedText(recipe);
        
        // Start with base scale and find the right scale to fit on two lines
        float scale = 0.6f; // Starting scale
        float minScale = 0.4f; // Don't go smaller than this for readability
        
        // Calculate how many lines we need at current scale
        int availableWidth = (int)(56 / scale);
        int lineCount = Minecraft.getInstance().font.split(text, availableWidth).size();
        
        // If text is too long, reduce scale until it fits on two lines
        while (lineCount > 2 && scale > minScale) {
            scale -= 0.05f; // Reduce scale incrementally
            availableWidth = (int)(56 / scale);
            lineCount = Minecraft.getInstance().font.split(text, availableWidth).size();
        }
        
        // Store the calculated scale
        recipeTextScales.put(recipe, scale);
    }
    
    // Create formatted component with yellow ingredient names
    private Component getFormattedText(WorldInteractionRecipe recipe) {
        // Get ingredient names
        String firstIngredientName = "Block";
        String secondIngredientName = "Item";
        boolean isAxeRecipe = false;
        
        // Get first ingredient name
        if (recipe.getIngredient1().getItems().length > 0) {
            ItemStack firstItem = recipe.getIngredient1().getItems()[0];
            firstIngredientName = firstItem.getHoverName().getString();
        }
        
        // Get second ingredient name and check if it's an axe
        if (recipe.getIngredient2().getItems().length > 0) {
            ItemStack secondItem = recipe.getIngredient2().getItems()[0];
            secondIngredientName = secondItem.getHoverName().getString();
            
            // Check if it's in the axe tag
            isAxeRecipe = secondItem.is(ItemTags.AXES);
            if (isAxeRecipe) {
                secondIngredientName = "Axe";
            }
        }
        
        // Style for yellow text
        Style yellowStyle = Style.EMPTY.withColor(0xFFFF55);
        
        // Create highlighted ingredient components without hover events
        Component firstIngredient = Component.literal(firstIngredientName).withStyle(yellowStyle);
        Component secondIngredient = Component.literal(secondIngredientName).withStyle(yellowStyle);
        
        // Create the complete text with translation and highlighted ingredients
        String translationKey = isAxeRecipe ? 
            "gui.ls_furniture.jei.world_interaction.use_on_strip" : 
            "gui.ls_furniture.jei.world_interaction.use_on";
            
        return Component.translatable(translationKey, firstIngredient, secondIngredient);
    }

    @Override
    @SuppressWarnings("removal")
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull WorldInteractionRecipe recipe, @NotNull IFocusGroup focuses) {
        // Calculate text scale for this recipe
        calculateTextScale(recipe);
        
        // First input (left side)
        builder.addInputSlot(1, 1)
                .setStandardSlotBackground()
                .addIngredients(recipe.getIngredient1())
                .setSlotName("input");

        // Second input (right side)
        builder.addInputSlot(45, 1)
                .setStandardSlotBackground()
                .addIngredients(recipe.getIngredient2())
                .setSlotName("axe");

        // Output (bottom center) - fixed position
        builder.addOutputSlot(23, 65)
                .setOutputSlotBackground()
                .addItemStack(recipe.result())
                .setSlotName("output");
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, WorldInteractionRecipe recipe, IFocusGroup focuses) {
        // Calculate text scale for this recipe
        calculateTextScale(recipe);
        
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
                return 24;
            }

            @Override
            public int getHeight() {
                return 24;
            }

            @Override
            public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
                guiGraphics.blit(DOWN_ARROW, xOffset, yOffset, 0, 0, 22, 22, 22, 22);
            }
        };

        IDrawable text = new IDrawable() {
            @Override
            public int getWidth() {
                return 62;
            }

            @Override
            public int getHeight() {
                return 22;
            }

            @Override
            public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
                // Get formatted component
                Component textComponent = getFormattedText(recipe);
                
                // Save the current transformation state
                guiGraphics.pose().pushPose();

                // Get the calculated scale for this recipe
                float scale = recipeTextScales.getOrDefault(recipe, 0.6f);
                
                // Apply scale transformation
                guiGraphics.pose().scale(scale, scale, 1.0f);

                // Calculate available width
                int availableWidth = (int)(56 / scale);
                
                // Split the text into lines
                var wrappedText = Minecraft.getInstance().font.split(textComponent, availableWidth);
                
                // Calculate line height based on scale - reduced for closer spacing
                float lineHeight = 8f * (scale / 0.6f);
                
                // Draw the text lines
                int linesToDraw = Math.min(2, wrappedText.size());
                
                // If there's only one line, center it vertically
                if (linesToDraw == 1) {
                    guiGraphics.drawString(
                        Minecraft.getInstance().font,
                        wrappedText.get(0),
                        Math.round(xOffset / scale),
                        Math.round((yOffset + 5) / scale),
                        0xFF808080, // Gray color, component has its own styling for yellow parts
                        false
                    );
                }
                // Otherwise draw up to two lines
                else {
                    for (int i = 0; i < linesToDraw; i++) {
                        guiGraphics.drawString(
                            Minecraft.getInstance().font,
                            wrappedText.get(i),
                            Math.round(xOffset / scale),
                            Math.round((yOffset + i * lineHeight) / scale),
                            0xFF808080, // Gray color, component has its own styling for yellow parts
                            false
                        );
                    }
                }

                // Restore the original transformation state
                guiGraphics.pose().popPose();
            }
        };

        // Place the elements with fixed positions
        builder.addDrawable(leftArrow, 20, -2);
        builder.addDrawable(downArrow, 20, 35);
        builder.addDrawable(text, 0, 20);
    }
}
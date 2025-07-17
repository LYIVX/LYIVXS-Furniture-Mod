package net.lyivx.ls_furniture.registry;

import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeSerializer;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeType;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.recipes.ChoppingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.CuttingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.WorkstationRecipe;
import net.lyivx.ls_furniture.common.recipes.WorldInteractionRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;


public class ModRecipes {

    public static final ResourcefulRegistry<RecipeType<?>> RECIPE_TYPES = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_TYPE, LYIVXsFurnitureMod.MOD_ID);
    public static final ResourcefulRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_SERIALIZER, LYIVXsFurnitureMod.MOD_ID);


    public static final Supplier<CodecRecipeType<ChoppingBoardRecipe>> CHOPPING_BOARD_RECIPE = RECIPE_TYPES.register("chopping_board", () -> CodecRecipeType.of("chopping_board"));
    public static final Supplier<CodecRecipeSerializer<ChoppingBoardRecipe>> CHOPPING_BOARD_SERIALIZER = RECIPE_SERIALIZERS.register("chopping_board", () -> new CodecRecipeSerializer<>(CHOPPING_BOARD_RECIPE.get(), ChoppingBoardRecipe::codec));

    public static final Supplier<CodecRecipeType<CuttingBoardRecipe>> CUTTING_BOARD_RECIPE = RECIPE_TYPES.register("cutting_board", () -> CodecRecipeType.of("cutting_board"));
    public static final Supplier<CodecRecipeSerializer<CuttingBoardRecipe>> CUTTING_BOARD_SERIALIZER = RECIPE_SERIALIZERS.register("cutting_board", () -> new CodecRecipeSerializer<>(CUTTING_BOARD_RECIPE.get(), CuttingBoardRecipe::codec));


    public static final Supplier<CodecRecipeType<WorldInteractionRecipe>> WORLD_INTERACTION_RECIPE = RECIPE_TYPES.register("world_interaction", () -> CodecRecipeType.of("world_interaction"));
    public static final Supplier<CodecRecipeSerializer<WorldInteractionRecipe>> WORLD_INTERACTION_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("world_interaction", () -> new CodecRecipeSerializer<>(WORLD_INTERACTION_RECIPE.get(), WorldInteractionRecipe::codec));

    public static final Supplier<RecipeType<WorkstationRecipe>> WORKSTATION_RECIPE = RECIPE_TYPES.register("workstation", () -> CodecRecipeType.of("workstation"));
    public static final Supplier<RecipeSerializer<WorkstationRecipe>> WORKSTATION_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("workstation", () -> new CodecRecipeSerializer<>(WORKSTATION_RECIPE.get(), WorkstationRecipe::codec));
}
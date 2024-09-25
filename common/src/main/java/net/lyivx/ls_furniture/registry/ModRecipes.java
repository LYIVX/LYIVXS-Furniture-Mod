package net.lyivx.ls_furniture.registry;

import com.mojang.serialization.MapCodec;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeSerializer;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeType;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.recipes.ChoppingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.CuttingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.WorkstationRecipe;
import net.lyivx.ls_furniture.common.recipes.WorldInteractionRecipe;
import net.mehvahdjukaar.moonlight.api.platform.RegHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;

public class ModRecipes {

    public static final ResourcefulRegistry<RecipeType<?>> RECIPES = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_TYPE, LYIVXsFurnitureMod.MOD_ID);
    public static final ResourcefulRegistry<RecipeSerializer<?>> SERIALIZERS = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_SERIALIZER, LYIVXsFurnitureMod.MOD_ID);

    public static final Supplier<CodecRecipeType<ChoppingBoardRecipe>> CHOPPING_BOARD_RECIPE = RECIPES.register("chopping_board", () -> CodecRecipeType.of("chopping_board"));
    public static final Supplier<CodecRecipeSerializer<ChoppingBoardRecipe>> CHOPPING_BOARD_SERIALIZER = SERIALIZERS.register("chopping_board",
            () -> new CodecRecipeSerializer<>(
                    CHOPPING_BOARD_RECIPE.get(),
                    (MapCodec) ChoppingBoardRecipe.codec(createResourceLocation("chopping_board")),
                    ChoppingBoardRecipe.byteCodec()
            ));

    public static final Supplier<CodecRecipeType<CuttingBoardRecipe>> CUTTING_BOARD_RECIPE = RECIPES.register("cutting_board", () -> CodecRecipeType.of("cutting_board"));
    public static final Supplier<CodecRecipeSerializer<CuttingBoardRecipe>> CUTTING_BOARD_SERIALIZER = SERIALIZERS.register("cutting_board",
            () -> new CodecRecipeSerializer<>(
                    CUTTING_BOARD_RECIPE.get(),
                    (MapCodec) CuttingBoardRecipe.codec(createResourceLocation("cutting_board")),
                    CuttingBoardRecipe.byteCodec()
            ));

    public static final Supplier<CodecRecipeType<WorldInteractionRecipe>> WORLD_INTERACTION_RECIPE = RECIPES.register("world_interaction", () -> CodecRecipeType.of("world_interaction"));
    public static final Supplier<CodecRecipeSerializer<WorldInteractionRecipe>> WORLD_INTERACTION_RECIPE_SERIALIZER = SERIALIZERS.register("world_interaction",
            () -> new CodecRecipeSerializer<>(
                    WORLD_INTERACTION_RECIPE.get(),
                    (MapCodec) WorldInteractionRecipe.codec(createResourceLocation("world_interaction")),
                    WorldInteractionRecipe.byteCodec()
            ));

    public static final Supplier<RecipeType<WorkstationRecipe>> WORKSTATION_RECIPE = RegHelper.registerRecipeType(createResourceLocation("workstation"));
    public static final Supplier<RecipeSerializer<WorkstationRecipe>> WORKSTATION_RECIPE_SERIALIZER = RegHelper.registerRecipeSerializer(createResourceLocation("workstation"), WorkstationRecipe.Serializer::new);
}
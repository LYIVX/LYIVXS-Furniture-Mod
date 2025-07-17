package net.lyivx.ls_furniture.registry;

import com.mojang.serialization.MapCodec;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.recipes.ChoppingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.CuttingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.WorkstationRecipe;
import net.lyivx.ls_furniture.common.recipes.WorldInteractionRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipes {

    public static final ResourcefulRegistry<RecipeType<?>> RECIPE_TYPES = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_TYPE, LYIVXsFurnitureMod.MOD_ID);
    public static final ResourcefulRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_SERIALIZER, LYIVXsFurnitureMod.MOD_ID);

    public static final RegistryEntry<RecipeType<ChoppingBoardRecipe>> CHOPPING_BOARD_RECIPE = RECIPE_TYPES.register("chopping_board",
            () -> new RecipeType<ChoppingBoardRecipe>() {
                public String toString() { return "chopping_board"; }
            });
    public static final RegistryEntry<RecipeSerializer<ChoppingBoardRecipe>> CHOPPING_BOARD_SERIALIZER = RECIPE_SERIALIZERS.register("chopping_board",
            ChoppingBoardRecipe.Serializer::new);


    public static final RegistryEntry<RecipeType<CuttingBoardRecipe>> CUTTING_BOARD_RECIPE = RECIPE_TYPES.register("cutting_board",
            () -> new RecipeType<CuttingBoardRecipe>() {
                public String toString() { return "cutting_board"; }
            });
    public static final RegistryEntry<RecipeSerializer<CuttingBoardRecipe>> CUTTING_BOARD_SERIALIZER = RECIPE_SERIALIZERS.register("cutting_board",
            CuttingBoardRecipe.Serializer::new);


    public static final RegistryEntry<RecipeType<WorldInteractionRecipe>> WORLD_INTERACTION_RECIPE = RECIPE_TYPES.register("world_interaction",
            () -> new RecipeType<WorldInteractionRecipe>() {
                public String toString() { return "world_interaction"; }
            });
    public static final RegistryEntry<RecipeSerializer<WorldInteractionRecipe>> WORLD_INTERACTION_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("world_interaction",
            WorldInteractionRecipe.Serializer::new);

    public static final RegistryEntry<RecipeType<WorkstationRecipe>> WORKSTATION_RECIPE = RECIPE_TYPES.register("workstation",
            () -> new RecipeType<WorkstationRecipe>() {
                public String toString() { return "workstation"; }
            });
    public static final RegistryEntry<RecipeSerializer<WorkstationRecipe>> WORKSTATION_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("workstation",
            WorkstationRecipe.Serializer::new);

    public static void Register()  {
        ModRecipes.RECIPE_TYPES.init();
        ModRecipes.RECIPE_SERIALIZERS.init();
    }
}
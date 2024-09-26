package net.lyivx.ls_furniture.registry;

import com.mojang.serialization.Codec;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.architectury.registry.registries.Registrar;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.recipes.ChoppingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.CuttingBoardRecipe;
import net.lyivx.ls_furniture.common.recipes.WorkstationRecipe;
import net.lyivx.ls_furniture.common.recipes.WorldInteractionRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
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
            () -> new RecipeSerializer<ChoppingBoardRecipe>() {
                @Override
                public Codec<ChoppingBoardRecipe> codec() {
                    return ChoppingBoardRecipe.codec(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "chopping_board"));
                }

                @Override
                public ChoppingBoardRecipe fromNetwork(FriendlyByteBuf buffer) {
                    ResourceLocation id = buffer.readResourceLocation();
                    Ingredient ingredient = Ingredient.fromNetwork(buffer);
                    ItemStack itemStack = buffer.readItem();
                    int intCount = buffer.readVarInt();
                    return new ChoppingBoardRecipe(id, intCount, ingredient, itemStack);
                }

                @Override
                public void toNetwork(FriendlyByteBuf buffer, ChoppingBoardRecipe recipe) {
                    buffer.writeResourceLocation(recipe.id());
                    buffer.writeUtf(recipe.getGroup());
                    recipe.input().toNetwork(buffer);
                    buffer.writeItem(recipe.output());
                    buffer.writeVarInt(recipe.uses());

                }
                // Implement serializer methods here
            });

    public static final RegistryEntry<RecipeType<CuttingBoardRecipe>> CUTTING_BOARD_RECIPE = RECIPE_TYPES.register("cutting_board",
            () -> new RecipeType<CuttingBoardRecipe>() {
                public String toString() { return "cutting_board"; }
            });
    public static final RegistryEntry<RecipeSerializer<CuttingBoardRecipe>> CUTTING_BOARD_SERIALIZER = RECIPE_SERIALIZERS.register("cutting_board",
            () -> new RecipeSerializer<CuttingBoardRecipe>() {
                @Override
                public Codec<CuttingBoardRecipe> codec() {
                    return CuttingBoardRecipe.codec(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "cutting_board"));
                }

                @Override
                public CuttingBoardRecipe fromNetwork(FriendlyByteBuf buffer) {
                    ResourceLocation id = buffer.readResourceLocation();
                    Ingredient ingredient = Ingredient.fromNetwork(buffer);
                    ItemStack itemStack = buffer.readItem();
                    int intCount = buffer.readVarInt();
                    return new CuttingBoardRecipe(id, intCount, ingredient, itemStack);
                }

                @Override
                public void toNetwork(FriendlyByteBuf buffer, CuttingBoardRecipe recipe) {
                    buffer.writeResourceLocation(recipe.id());
                    buffer.writeUtf(recipe.getGroup());
                    recipe.input().toNetwork(buffer);
                    buffer.writeItem(recipe.output());
                    buffer.writeVarInt(recipe.uses());

                }
                // Implement serializer methods here
            });

    public static final RegistryEntry<RecipeType<WorldInteractionRecipe>> WORLD_INTERACTION_RECIPE = RECIPE_TYPES.register("world_interaction",
            () -> new RecipeType<WorldInteractionRecipe>() {
                public String toString() { return "world_interaction"; }
            });
    public static final RegistryEntry<RecipeSerializer<WorldInteractionRecipe>> WORLD_INTERACTION_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("world_interaction",
            () -> new RecipeSerializer<WorldInteractionRecipe>() {
                @Override
                public Codec<WorldInteractionRecipe> codec() {
                    return WorldInteractionRecipe.codec(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "world_interaction"));
                }

                @Override
                public WorldInteractionRecipe fromNetwork(FriendlyByteBuf buffer) {
                    ResourceLocation id = buffer.readResourceLocation();
                    Ingredient ingredient = Ingredient.fromNetwork(buffer);
                    Ingredient ingredient2 = Ingredient.fromNetwork(buffer);
                    ItemStack itemStack = buffer.readItem();
                    int intCount = buffer.readVarInt();
                    return new WorldInteractionRecipe(id, intCount, ingredient, ingredient2, itemStack);
                }

                @Override
                public void toNetwork(FriendlyByteBuf buffer, WorldInteractionRecipe recipe) {
                    buffer.writeResourceLocation(recipe.id());
                    recipe.input().toNetwork(buffer);
                    recipe.input2().toNetwork(buffer);
                    buffer.writeItem(recipe.output());
                    buffer.writeVarInt(recipe.uses());

                }
                // Implement serializer methods here
            });

    public static final RegistryEntry<RecipeType<WorkstationRecipe>> WORKSTATION_RECIPE = RECIPE_TYPES.register("workstation",
            () -> new RecipeType<WorkstationRecipe>() {
                public String toString() { return "workstation"; }
            });
    public static final RegistryEntry<RecipeSerializer<WorkstationRecipe>> WORKSTATION_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("workstation",
            () -> new RecipeSerializer<WorkstationRecipe>() {
                @Override
                public Codec<WorkstationRecipe> codec() {
                    return WorkstationRecipe.codec(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "workstation"));
                }

                @Override
                public WorkstationRecipe fromNetwork(FriendlyByteBuf buffer) {
                    ResourceLocation id = buffer.readResourceLocation();
                    String string = buffer.readUtf();
                    Ingredient ingredient = Ingredient.fromNetwork(buffer);
                    ItemStack itemStack = buffer.readItem();
                    int intCount = buffer.readVarInt();
                    return new WorkstationRecipe(id, string, ingredient, itemStack, intCount);
                }

                @Override
                public void toNetwork(FriendlyByteBuf buffer, WorkstationRecipe recipe) {
                    buffer.writeResourceLocation(recipe.id());
                    buffer.writeUtf(recipe.group());
                    recipe.input().toNetwork(buffer);
                    buffer.writeItem(recipe.output());
                    buffer.writeVarInt(recipe.inputCount());
                }
                // Implement serializer methods here
            });
}
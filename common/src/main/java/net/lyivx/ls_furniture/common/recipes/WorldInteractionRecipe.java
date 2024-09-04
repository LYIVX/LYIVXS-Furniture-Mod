package net.lyivx.ls_furniture.common.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamresourceful.resourcefullib.common.codecs.recipes.IngredientCodec;
import com.teamresourceful.resourcefullib.common.codecs.recipes.ItemStackCodec;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipe;
import net.lyivx.ls_furniture.registry.ModRecipes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public record WorldInteractionRecipe(ResourceLocation id, int uses, boolean copyNbt, Ingredient input, Ingredient input2, ItemStack output) implements CodecRecipe<Container> {

    public static Codec<WorldInteractionRecipe> codec(ResourceLocation id) {
        return RecordCodecBuilder.create(instance -> instance.group(
                RecordCodecBuilder.point(id),
                Codec.INT.fieldOf("uses").forGetter(WorldInteractionRecipe::uses),
                Codec.BOOL.fieldOf("copyNbt").orElse(false).forGetter(WorldInteractionRecipe::copyNbt),
                IngredientCodec.CODEC.fieldOf("input").forGetter(WorldInteractionRecipe::input),
                IngredientCodec.CODEC.fieldOf("input2").forGetter(WorldInteractionRecipe::input2),
                ItemStackCodec.CODEC.fieldOf("output").forGetter(WorldInteractionRecipe::output)
        ).apply(instance, WorldInteractionRecipe::new));
    }

    @Override
    public boolean matches(@NotNull Container container, @NotNull Level level) {
        return input.test(container.getItem(0));
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.WORLD_INTERACTION_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.WORLD_INTERACTION_RECIPE.get();
    }
}
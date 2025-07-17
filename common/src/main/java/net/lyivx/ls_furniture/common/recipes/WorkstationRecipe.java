package net.lyivx.ls_furniture.common.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModRecipes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class WorkstationRecipe extends SingleItemRecipe {
    private final int inputCount;

    public WorkstationRecipe(String group, Ingredient ingredient, int inputCount, ItemStack result) {
        super(group, ingredient, result);
        this.inputCount = inputCount;
    }

    public int getInputCount() {
        return inputCount;
    }

    @Override
    public RecipeSerializer<? extends SingleItemRecipe> getSerializer() {
        return ModRecipes.WORKSTATION_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends SingleItemRecipe> getType() {
        return ModRecipes.WORKSTATION_RECIPE.get();
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return null;
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        ItemStack item = input.getItem(0);
        return this.input().test(item) &&
                item.getCount() >= inputCount;
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.WORKSTATION.get());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public ItemStack result() {
        return super.result().copy();
    }

    public static class Serializer<T extends SingleItemRecipe> implements RecipeSerializer<WorkstationRecipe> {

        private final MapCodec<WorkstationRecipe> mapCodec;
        private final StreamCodec<RegistryFriendlyByteBuf, WorkstationRecipe> streamCodec;

        public Serializer() {
            this.mapCodec = RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(WorkstationRecipe::group),
                                    Ingredient.CODEC.fieldOf("ingredient").forGetter(WorkstationRecipe::input),
                                    ExtraCodecs.POSITIVE_INT.optionalFieldOf("ingredient_count", 1).forGetter(WorkstationRecipe::getInputCount),
                                    ItemStack.STRICT_CODEC.fieldOf("result").forGetter(WorkstationRecipe::result)
                            )
                            .apply(instance, WorkstationRecipe::new)
            );
            this.streamCodec = StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, WorkstationRecipe::group,
                    Ingredient.CONTENTS_STREAM_CODEC, WorkstationRecipe::input,
                    ByteBufCodecs.VAR_INT, WorkstationRecipe::getInputCount,
                    ItemStack.STREAM_CODEC, WorkstationRecipe::result,
                    WorkstationRecipe::new
            );
        }

        @Override
        public MapCodec<WorkstationRecipe> codec() {
            return this.mapCodec;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, WorkstationRecipe> streamCodec() {
            return this.streamCodec;
        }
    }
}
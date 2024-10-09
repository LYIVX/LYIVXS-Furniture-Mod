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

    public WorkstationRecipe(String group, Ingredient ingredient,  int inputCount, ItemStack result) {
        super(ModRecipes.WORKSTATION_RECIPE.get(), ModRecipes.WORKSTATION_RECIPE_SERIALIZER.get(), group, ingredient, result);
        this.inputCount = inputCount;
    }

    public int getInputCount() {
        return inputCount;
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        ItemStack item = input.getItem(0);
        return this.ingredient.test(item) &&
                item.getCount() >= inputCount;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.WORKSTATION.get());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public Ingredient ingredient() {
        return ingredient;
    }

    public ItemStack result() {
        return result;
    }

    public static class Serializer<T extends SingleItemRecipe> implements RecipeSerializer<WorkstationRecipe> {

        private final MapCodec<WorkstationRecipe> mapCodec;
        private final StreamCodec<RegistryFriendlyByteBuf, WorkstationRecipe> streamCodec;

        public Serializer() {

            this.mapCodec = RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(arg -> arg.group),
                                    Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(arg -> arg.ingredient),
                                    ExtraCodecs.POSITIVE_INT.optionalFieldOf("ingredient_count", 1).forGetter(arg -> arg.inputCount),
                                    ItemStack.STRICT_CODEC.fieldOf("result").forGetter(arg -> arg.result)
                            )
                            .apply(instance, WorkstationRecipe::new)
            );
            this.streamCodec = StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, arg -> arg.group,
                    Ingredient.CONTENTS_STREAM_CODEC, arg -> arg.ingredient,
                    ByteBufCodecs.VAR_INT, arg -> arg.inputCount,
                    ItemStack.STREAM_CODEC, arg -> arg.result,
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
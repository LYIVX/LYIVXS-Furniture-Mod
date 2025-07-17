package net.lyivx.ls_furniture.common.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class ChoppingBoardRecipe extends SingleItemRecipe {
    private final int uses;

    public ChoppingBoardRecipe(String group, Ingredient ingredient, ItemStack result, int uses) {
        super(group, ingredient, result);
        this.uses = uses;
    }

    public int getUses() {
        return uses;
    }

    @Override
    public RecipeSerializer<? extends SingleItemRecipe> getSerializer() {
        return ModRecipes.CHOPPING_BOARD_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends SingleItemRecipe> getType() {
        return ModRecipes.CHOPPING_BOARD_RECIPE.get();
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return null;
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        return this.input().test(input.getItem(0));
    }

    @Override
    public ItemStack assemble(SingleRecipeInput input, HolderLookup.Provider registries) {
        return result().copy();
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.CHOPPING_BOARD.get());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    // Add a public method to get the result for JEI
    public ItemStack getResultItem() {
        return super.result().copy();
    }

    public static class Serializer implements RecipeSerializer<ChoppingBoardRecipe> {

        private final MapCodec<ChoppingBoardRecipe> mapCodec;
        private final StreamCodec<RegistryFriendlyByteBuf, ChoppingBoardRecipe> streamCodec;

        public Serializer() {
            this.mapCodec = RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(ChoppingBoardRecipe::group),
                                    Ingredient.CODEC.fieldOf("input").forGetter(ChoppingBoardRecipe::input),
                                    ItemStack.STRICT_CODEC.fieldOf("result").forGetter(ChoppingBoardRecipe::result),
                                    ExtraCodecs.POSITIVE_INT.fieldOf("uses").orElse(5).forGetter(ChoppingBoardRecipe::getUses)
                            )
                            .apply(instance, ChoppingBoardRecipe::new)
            );
            this.streamCodec = StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, ChoppingBoardRecipe::group,
                    Ingredient.CONTENTS_STREAM_CODEC, ChoppingBoardRecipe::input,
                    ItemStack.STREAM_CODEC, ChoppingBoardRecipe::result,
                    ByteBufCodecs.VAR_INT, ChoppingBoardRecipe::getUses,
                    ChoppingBoardRecipe::new
            );
        }

        @Override
        public MapCodec<ChoppingBoardRecipe> codec() {
            return mapCodec;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ChoppingBoardRecipe> streamCodec() {
            return streamCodec;
        }
    }
}
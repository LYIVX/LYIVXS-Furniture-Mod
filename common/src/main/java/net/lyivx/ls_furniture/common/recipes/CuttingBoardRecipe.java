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

public class CuttingBoardRecipe extends SingleItemRecipe {
    private final int uses;

    public CuttingBoardRecipe(String group, Ingredient ingredient, ItemStack result, int uses) {
        super(ModRecipes.CUTTING_BOARD_RECIPE.get(), ModRecipes.CUTTING_BOARD_SERIALIZER.get(), group, ingredient, result);
        this.uses = uses;
    }

    public int getUses() {
        return uses;
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        return this.ingredient.test(input.getItem(0));
    }

    @Override
    public ItemStack assemble(SingleRecipeInput input, HolderLookup.Provider registries) {
        return result.copy();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.CHOPPING_BOARD.get());
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

    public static class Serializer implements RecipeSerializer<CuttingBoardRecipe> {

        private final MapCodec<CuttingBoardRecipe> mapCodec;
        private final StreamCodec<RegistryFriendlyByteBuf, CuttingBoardRecipe> streamCodec;

        public Serializer() {
            this.mapCodec = RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(arg -> arg.group),
                                    Ingredient.CODEC_NONEMPTY.fieldOf("input").forGetter(arg -> arg.ingredient),
                                    ItemStack.STRICT_CODEC.fieldOf("result").forGetter(arg -> arg.result),
                                    ExtraCodecs.POSITIVE_INT.fieldOf("uses").orElse(5).forGetter(arg -> arg.uses)
                            )
                            .apply(instance, CuttingBoardRecipe::new)
            );
            this.streamCodec = StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, arg -> arg.group,
                    Ingredient.CONTENTS_STREAM_CODEC, arg -> arg.ingredient,
                    ItemStack.STREAM_CODEC, arg -> arg.result,
                    ByteBufCodecs.VAR_INT, arg -> arg.uses,
                    CuttingBoardRecipe::new
            );
        }

        @Override
        public MapCodec<CuttingBoardRecipe> codec() {
            return mapCodec;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CuttingBoardRecipe> streamCodec() {
            return streamCodec;
        }
    }
}
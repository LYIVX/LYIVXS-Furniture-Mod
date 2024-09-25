package net.lyivx.ls_furniture.common.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModMenus;
import net.lyivx.ls_furniture.registry.ModRecipes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.Container;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class WorkstationRecipe extends SingleItemRecipe {
    private final int inputCount;

    public WorkstationRecipe(String group, Ingredient ingredient, ItemStack result, int inputCount) {
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

    public static class Serializer implements RecipeSerializer<WorkstationRecipe> {

        private final MapCodec<WorkstationRecipe> codec;
        private final StreamCodec<RegistryFriendlyByteBuf, WorkstationRecipe> streamCodec;

        public Serializer() {

            this.codec = RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(arg -> arg.group),
                                    Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(arg -> arg.ingredient),
                                    ItemStack.STRICT_CODEC.fieldOf("result").forGetter(arg -> arg.result),
                                    ExtraCodecs.POSITIVE_INT.optionalFieldOf("ingredient_count", 1).forGetter(arg -> arg.inputCount)
                            )
                            .apply(instance, WorkstationRecipe::new)
            );
            this.streamCodec = StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, arg -> arg.group,
                    Ingredient.CONTENTS_STREAM_CODEC, arg -> arg.ingredient,
                    ItemStack.STREAM_CODEC, arg -> arg.result,
                    ByteBufCodecs.VAR_INT, arg -> arg.inputCount,
                    WorkstationRecipe::new
            );
        }

        @Override
        public MapCodec<WorkstationRecipe> codec() {
            return codec;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, WorkstationRecipe> streamCodec() {
            return streamCodec;
        }
    }
}
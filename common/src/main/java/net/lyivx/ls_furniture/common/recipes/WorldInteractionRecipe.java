package net.lyivx.ls_furniture.common.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.lyivx.ls_furniture.registry.ModRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class WorldInteractionRecipe implements Recipe<RecipeInput> {
    private final String group;
    private final Ingredient ingredient1;
    private final Ingredient ingredient2;
    private final ItemStack result;
    private final int uses;

    public WorldInteractionRecipe(String group, Ingredient ingredient1, Ingredient ingredient2, ItemStack result, int uses) {
        this.group = group;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.result = result;
        this.uses = uses;
    }

    public int getUses() {
        return uses;
    }

    @Override
    public boolean matches(RecipeInput input, Level level) {
        return this.ingredient1.test(input.getItem(0)) && this.ingredient2.test(input.getItem(1));
    }

    @Override
    public ItemStack assemble(RecipeInput input, HolderLookup.Provider registries) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider pProvider) {
        return this.result;
    }

    public ItemStack result() {
        return result;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(Blocks.GRASS_BLOCK);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public Ingredient getIngredient1() {
        return ingredient1;
    }

    public Ingredient getIngredient2() {
        return ingredient2;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.WORLD_INTERACTION_RECIPE.get();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.WORLD_INTERACTION_RECIPE_SERIALIZER.get();
    }

    public static class Serializer implements RecipeSerializer<WorldInteractionRecipe> {

        private final MapCodec<WorldInteractionRecipe> mapCodec;
        private final StreamCodec<RegistryFriendlyByteBuf, WorldInteractionRecipe> streamCodec;

        public Serializer() {
            this.mapCodec = RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                            Codec.STRING.optionalFieldOf("group", "").forGetter(WorldInteractionRecipe::getGroup),
                            Ingredient.CODEC_NONEMPTY.fieldOf("input1").forGetter(WorldInteractionRecipe::getIngredient1),
                            Ingredient.CODEC_NONEMPTY.fieldOf("input2").forGetter(WorldInteractionRecipe::getIngredient2),
                            ItemStack.CODEC.fieldOf("result").forGetter(recipe -> recipe.result),
                            ExtraCodecs.POSITIVE_INT.fieldOf("uses").orElse(5).forGetter(WorldInteractionRecipe::getUses)
                    ).apply(instance, WorldInteractionRecipe::new)
            );
            this.streamCodec = StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, arg -> arg.group,
                    Ingredient.CONTENTS_STREAM_CODEC, arg -> arg.ingredient1,
                    Ingredient.CONTENTS_STREAM_CODEC, arg -> arg.ingredient2,
                    ItemStack.STREAM_CODEC, arg -> arg.result,
                    ByteBufCodecs.VAR_INT, arg -> arg.uses,
                    WorldInteractionRecipe::new
            );
        }

        @Override
        public MapCodec<WorldInteractionRecipe> codec() {
            return mapCodec;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, WorldInteractionRecipe> streamCodec() {
            return streamCodec;
        }
    }
}
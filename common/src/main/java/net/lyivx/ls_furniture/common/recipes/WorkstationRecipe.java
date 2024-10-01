package net.lyivx.ls_furniture.common.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamresourceful.bytecodecs.base.ByteCodec;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipe;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeSerializer;
import io.netty.buffer.ByteBuf;
import net.lyivx.ls_furniture.registry.ModRecipes;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public record WorkstationRecipe(ResourceLocation id, String group, Ingredient input, ItemStack output, int inputCount) implements CodecRecipe<Container> {

    public static Codec<WorkstationRecipe> codec(ResourceLocation id) {
        return RecordCodecBuilder.create(instance -> instance.group(
                RecordCodecBuilder.point(id),
                Codec.STRING.fieldOf("group").orElse("").forGetter(WorkstationRecipe::group),
                Ingredient.CODEC.fieldOf("ingredient").forGetter(WorkstationRecipe::input),
                ItemStack.CODEC.fieldOf("result").forGetter(WorkstationRecipe::output),
                Codec.INT.optionalFieldOf("ingredient_count", 1).forGetter(WorkstationRecipe::inputCount)
        ).apply(instance, WorkstationRecipe::new));
    }

    @Override
    public boolean matches(@NotNull Container container, @NotNull Level level) {
        ItemStack item = container.getItem(0);
        return this.input.test(item) && item.getCount() >= inputCount;
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.WORKSTATION_RECIPE.get();
    }

    @Override
    public CodecRecipeSerializer<? extends CodecRecipe<Container>> serializer() {
        return (CodecRecipeSerializer<? extends CodecRecipe<Container>>) ModRecipes.WORKSTATION_RECIPE_SERIALIZER.get();
    }
}
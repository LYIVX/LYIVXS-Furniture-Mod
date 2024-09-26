package net.lyivx.ls_furniture.common.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamresourceful.bytecodecs.base.ByteCodec;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipe;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeSerializer;
import io.netty.buffer.ByteBuf;
import net.lyivx.ls_furniture.registry.ModRecipes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import net.minecraft.network.FriendlyByteBuf;

public record WorldInteractionRecipe(ResourceLocation id, int uses, Ingredient input, Ingredient input2, ItemStack output) implements CodecRecipe<Container> {

    public static Codec<WorldInteractionRecipe> codec(ResourceLocation id) {
        return RecordCodecBuilder.create(instance -> instance.group(
                RecordCodecBuilder.point(id),
                Codec.INT.fieldOf("uses").forGetter(WorldInteractionRecipe::uses),
                Ingredient.CODEC.fieldOf("input").forGetter(WorldInteractionRecipe::input),
                Ingredient.CODEC.fieldOf("input2").forGetter(WorldInteractionRecipe::input2),
                ItemStack.CODEC.fieldOf("output").forGetter(WorldInteractionRecipe::output)
        ).apply(instance, WorldInteractionRecipe::new));
    }

    public static ByteCodec<WorldInteractionRecipe> byteCodec() {
        return new ByteCodec<>() {
            @Override
            public void encode(WorldInteractionRecipe value, ByteBuf buf) {
                FriendlyByteBuf friendlyBuf = new FriendlyByteBuf(buf);
                friendlyBuf.writeResourceLocation(value.id());
                friendlyBuf.writeVarInt(value.uses());
                value.input().toNetwork(friendlyBuf);
                value.input2().toNetwork(friendlyBuf);
                friendlyBuf.writeItem(value.output());
            }

            @Override
            public WorldInteractionRecipe decode(ByteBuf buf) {
                FriendlyByteBuf friendlyBuf = new FriendlyByteBuf(buf);
                ResourceLocation id = friendlyBuf.readResourceLocation();
                int uses = friendlyBuf.readVarInt();
                Ingredient input = Ingredient.fromNetwork(friendlyBuf);
                Ingredient input2 = Ingredient.fromNetwork(friendlyBuf);
                ItemStack output = friendlyBuf.readItem();
                return new WorldInteractionRecipe(id, uses,  input, input2, output);
            }
        };
    }

    @Override
    public boolean matches(@NotNull Container container, @NotNull Level level) {
        return input.test(container.getItem(0));
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.WORLD_INTERACTION_RECIPE.get();
    }

    @Override
    public CodecRecipeSerializer<? extends CodecRecipe<Container>> serializer() {
        return (CodecRecipeSerializer<? extends CodecRecipe<Container>>) ModRecipes.WORLD_INTERACTION_RECIPE_SERIALIZER.get();
    }
}
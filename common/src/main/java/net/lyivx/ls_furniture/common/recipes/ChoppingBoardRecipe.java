package net.lyivx.ls_furniture.common.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamresourceful.bytecodecs.base.ByteCodec;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipe;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeSerializer;
import io.netty.buffer.ByteBuf;
import net.lyivx.ls_furniture.registry.ModRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import com.teamresourceful.bytecodecs.utils.ByteBufUtils;
import net.minecraft.network.FriendlyByteBuf;


public record ChoppingBoardRecipe(ResourceLocation id, int uses, boolean copyNbt, Ingredient input, ItemStack output) implements CodecRecipe<Container> {

    public static Codec<ChoppingBoardRecipe> codec(ResourceLocation id) {
        return RecordCodecBuilder.create(instance -> instance.group(
                RecordCodecBuilder.point(id),
                Codec.INT.fieldOf("uses").orElse(5).forGetter(ChoppingBoardRecipe::uses),
                Codec.BOOL.fieldOf("copyNbt").orElse(false).forGetter(ChoppingBoardRecipe::copyNbt),
                Ingredient.CODEC.fieldOf("input").forGetter(ChoppingBoardRecipe::input),
                ItemStack.CODEC.fieldOf("output").forGetter(ChoppingBoardRecipe::output)
        ).apply(instance, ChoppingBoardRecipe::new));
    }

    public static ByteCodec<ChoppingBoardRecipe> byteCodec() {
        return new ByteCodec<>() {
            @Override
            public void encode(ChoppingBoardRecipe value, ByteBuf buf) {
                FriendlyByteBuf friendlyBuf = new FriendlyByteBuf(buf);
                friendlyBuf.writeResourceLocation(value.id());
                friendlyBuf.writeVarInt(value.uses());
                friendlyBuf.writeBoolean(value.copyNbt());
                value.input().toNetwork(friendlyBuf);
                friendlyBuf.writeItem(value.output());
            }

            @Override
            public ChoppingBoardRecipe decode(ByteBuf buf) {
                FriendlyByteBuf friendlyBuf = new FriendlyByteBuf(buf);
                ResourceLocation id = friendlyBuf.readResourceLocation();
                int uses = friendlyBuf.readVarInt();
                boolean copyNbt = friendlyBuf.readBoolean();
                Ingredient input = Ingredient.fromNetwork(friendlyBuf);
                ItemStack output = friendlyBuf.readItem();
                return new ChoppingBoardRecipe(id, uses, copyNbt, input, output);
            }
        };
    }

    @Override
    public boolean matches(@NotNull Container container, @NotNull Level level) {
        return input.test(container.getItem(0));
    }

    @Override
    public ItemStack assemble(Container container, HolderLookup.Provider provider) {
        ItemStack result = output.copy();
        if (copyNbt) {
            result.setTag(container.getItem(0).getTag());
        }
        return result;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.CHOPPING_BOARD_RECIPE.get();
    }

    @Override
    public CodecRecipeSerializer<? extends CodecRecipe<Container>> serializer() {
        return ModRecipes.CHOPPING_BOARD_SERIALIZER.get();
    }

}
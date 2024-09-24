package net.lyivx.ls_furniture.common.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModMenus;
import net.lyivx.ls_furniture.registry.ModRecipes;
import net.mehvahdjukaar.moonlight.api.misc.StrOpt;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.RegistryAccess;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.Container;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

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
    public boolean matches(Container container, Level level) {
        ItemStack item = container.getItem(0);
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
        private final Codec<WorkstationRecipe> codec;

        public Serializer() {
            this.codec = RecordCodecBuilder.create((instance) -> instance.group(
                            ExtraCodecs.strictOptionalField(Codec.STRING, "group", "").forGetter((singleItemRecipe) -> singleItemRecipe.group),
                            Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter((singleItemRecipe) -> singleItemRecipe.ingredient),
                            ItemStack.RESULT_CODEC.forGetter((singleItemRecipe) -> singleItemRecipe.result),
                            StrOpt.of(ExtraCodecs.POSITIVE_INT, "ingredient_count", 1).forGetter(r -> r.inputCount)
                    )
                    .apply(instance, WorkstationRecipe::new));
        }

        @Override
        public Codec<WorkstationRecipe> codec() {
            return this.codec; // Fixed: return the codec field instead of calling the method
        }

        @Override
        public WorkstationRecipe fromNetwork(FriendlyByteBuf buffer) {
            String string = buffer.readUtf();
            Ingredient ingredient = Ingredient.fromNetwork(buffer);
            ItemStack itemStack = buffer.readItem();
            int intCount = buffer.readVarInt();
            return new WorkstationRecipe(string, ingredient, itemStack, intCount);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, WorkstationRecipe recipe) {
            buffer.writeUtf(recipe.group);
            recipe.ingredient.toNetwork(buffer);
            buffer.writeItem(recipe.result);
            buffer.writeVarInt(recipe.inputCount);
        }
    }
}
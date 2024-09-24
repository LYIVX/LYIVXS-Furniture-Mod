package net.lyivx.ls_furniture.common.recipes;

import com.google.gson.JsonObject;
import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModRecipes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

public class WorkstationRecipe extends SingleItemRecipe {
    private final int inputCount;
    public WorkstationRecipe(ResourceLocation resourceLocation, String string,
                             Ingredient ingredient, ItemStack itemStack, int inputCount) {
        super(ModRecipes.WORKSTATION_RECIPE.get(), ModRecipes.WORKSTATION_RECIPE_SERIALIZER.get(), resourceLocation, string, ingredient, itemStack);
        this.inputCount = inputCount;
    }

    public int getInputCount() {
        return inputCount;
    }

    @Override
    public boolean matches(Container container, Level level) {
        ItemStack item = container.getItem(0);
        return this.ingredient.test(item) && item.getCount() >= inputCount;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.WORKSTATION.get());
    }

    @Override
    public boolean isSpecial() {
        return true; //for recipe book
    }

    public static class Serializer implements RecipeSerializer<WorkstationRecipe> {

        @Override
        public WorkstationRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            String string = GsonHelper.getAsString(json, "group", "");
            Ingredient ingredient;
            if (GsonHelper.isArrayNode(json, "ingredient")) {
                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(json, "ingredient"), false);
            } else {
                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient"), false);
            }
            int inCount = GsonHelper.getAsInt(json, "ingredient_count", 1);
            String string2 = GsonHelper.getAsString(json, "result");
            int i = GsonHelper.getAsInt(json, "count");
            ItemStack itemStack = new ItemStack( BuiltInRegistries.ITEM.get(new ResourceLocation(string2)), i);
            return new WorkstationRecipe(recipeId, string, ingredient, itemStack, inCount);
        }

        @Override
        public WorkstationRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            String string = buffer.readUtf();
            Ingredient ingredient = Ingredient.fromNetwork(buffer);
            ItemStack itemStack = buffer.readItem();
            int intCount = buffer.readVarInt();
            return new WorkstationRecipe(recipeId, string, ingredient, itemStack, intCount);
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
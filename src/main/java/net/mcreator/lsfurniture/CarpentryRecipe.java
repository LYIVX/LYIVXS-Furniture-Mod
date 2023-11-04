package net.mcreator.lsfurniture;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class CarpentryRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public CarpentryRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer p_44002_, Level p_44003_) {
        if(p_44003_.isClientSide()){
            return false;
        }

        return recipeItems.get(0).test(p_44002_.getItem(0)) && recipeItems.get(1).test(p_44002_.getItem(1)) && recipeItems.get(2).test(p_44002_.getItem(2)) && recipeItems.get(3).test(p_44002_.getItem(3)) && recipeItems.get(4).test(p_44002_.getItem(4));
    }

    @Override
    public ItemStack assemble(SimpleContainer p_44001_) {
        return output;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    public ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {

        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<CarpentryRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "carpentry";
    }


    public static class Serializer implements RecipeSerializer<CarpentryRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(LsFurnitureMod.MODID, "carpentry");

        @Override
        public CarpentryRecipe fromJson(ResourceLocation p_44103_, JsonObject p_44104_) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(p_44104_, "output"));
//pSeralizedRecipe = p_44104
//pRecipeId = p_44104
            JsonArray ingredients = GsonHelper.getAsJsonArray(p_44104_, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(5, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new CarpentryRecipe(p_44103_, output, inputs);
        }

        @Override
        public @Nullable CarpentryRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new CarpentryRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, CarpentryRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }
    }
}

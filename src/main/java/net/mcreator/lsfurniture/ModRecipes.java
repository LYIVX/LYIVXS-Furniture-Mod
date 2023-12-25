package net.mcreator.lsfurniture;


import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister <RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, LsFurnitureMod.MODID);

    public static final RegistryObject<RecipeSerializer<CarpentryRecipe>> CARPENTRY_SERIALIZER =
            SERIALIZERS.register("carpentry", () -> CarpentryRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<CarpentryTickRecipe>> CARPENTRY_TICK_SERIALIZER =
            SERIALIZERS.register("carpentry_tick", () -> CarpentryTickRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<MasonryRecipe>> MASONRY_SERIALIZER =
            SERIALIZERS.register("masonry", () -> MasonryRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<MetallurgyRecipe>> METALLURGY_SERIALIZER =
            SERIALIZERS.register("metallurgy", () -> MetallurgyRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<BotanistRecipe>> BOTANIST_SERIALIZER =
            SERIALIZERS.register("botanist", () -> BotanistRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<EngineeringRecipe>> ENGINEERING_SERIALIZER =
            SERIALIZERS.register("engineering", () -> EngineeringRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<WeaveryRecipe>> WEAVERY_SERIALIZER =
            SERIALIZERS.register("weavery", () -> WeaveryRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<GlassblowerRecipe>> Glassblower_SERIALIZER =
            SERIALIZERS.register("glassblower", () -> GlassblowerRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<WorldInteractionRecipe>> WORLD_INTERACTION_SERIALIZER =
            SERIALIZERS.register("world_interaction", () -> WorldInteractionRecipe.Serializer.INSTANCE);


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }

}

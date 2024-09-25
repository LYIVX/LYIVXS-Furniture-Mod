package net.lyivx.ls_furniture.registry;

import com.google.common.collect.ImmutableSet;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.entity.SeatEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.flag.FeatureFlags;

import java.util.function.Supplier;

public class ModEntities {

    public static final ResourcefulRegistry<EntityType<?>> ENTITIES = ResourcefulRegistries.create(
            BuiltInRegistries.ENTITY_TYPE, LYIVXsFurnitureMod.MOD_ID);


    public static final Supplier<EntityType<SeatEntity>> SEAT = ENTITIES.register("seat", () -> new EntityType<>(
            SeatEntity::new,
            MobCategory.MISC,
            false,
            false,
            true,
            true,
            ImmutableSet.of(),
            EntityDimensions.scalable(0.875F, 0.625F),
            5, 3, 1,
            FeatureFlags.DEFAULT_FLAGS
    ));
}


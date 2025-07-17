package net.lyivx.ls_furniture.registry;

import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.entity.SeatEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class ModEntities {

    public static final ResourcefulRegistry<EntityType<?>> ENTITIES = ResourcefulRegistries.create(
            BuiltInRegistries.ENTITY_TYPE, LYIVXsFurnitureMod.MOD_ID);

    public static final Supplier<EntityType<SeatEntity>> SEAT = ENTITIES.register("seat",
        () -> EntityType.Builder.<SeatEntity>of(SeatEntity::new, MobCategory.MISC)
            .sized(0.875F, 0.625F)
            .clientTrackingRange(5)
            .updateInterval(3)
            .build(ResourceKey.create(BuiltInRegistries.ENTITY_TYPE.key(), 
                LYIVXsFurnitureMod.createResourceLocation("seat"))));
}




package net.lyivx.ls_furniture.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

import static net.lyivx.ls_furniture.LYIVXsFurnitureMod.createResourceLocation;

public class ModEntitiesTypeTags {

    public static final TagKey<EntityType<?>> CAN_SIT_IN_SEATS = entityTypeTag("can_sit_in_seats");

    private static TagKey<EntityType<?>> entityTypeTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, createResourceLocation(name));
    }

    public static void init() {}
}
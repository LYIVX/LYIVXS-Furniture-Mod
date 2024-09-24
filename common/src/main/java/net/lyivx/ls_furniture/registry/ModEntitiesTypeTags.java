package net.lyivx.ls_furniture.registry;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ModEntitiesTypeTags {

    public static final TagKey<EntityType<?>> CAN_SIT_IN_SEATS = entityTypeTag("can_sit_in_seats");

    private static TagKey<EntityType<?>> entityTypeTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, name));
    }

    public static void init() {}
}

/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lsfurniture.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.lsfurniture.entity.StoolEntity;
import net.mcreator.lsfurniture.entity.SofaEntity;
import net.mcreator.lsfurniture.entity.SeatEntity;
import net.mcreator.lsfurniture.entity.ChairEntity;
import net.mcreator.lsfurniture.LsFurnitureMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LsFurnitureModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, LsFurnitureMod.MODID);
	public static final RegistryObject<EntityType<SeatEntity>> SEAT = register("seat",
			EntityType.Builder.<SeatEntity>of(SeatEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(SeatEntity::new).fireImmune().sized(0.95f, 0.01f));
	public static final RegistryObject<EntityType<SofaEntity>> SOFA = register("sofa",
			EntityType.Builder.<SofaEntity>of(SofaEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(SofaEntity::new).fireImmune().sized(0.88f, 0.63f));
	public static final RegistryObject<EntityType<ChairEntity>> CHAIR = register("chair",
			EntityType.Builder.<ChairEntity>of(ChairEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(ChairEntity::new).fireImmune().sized(0.6f, 0.01f));
	public static final RegistryObject<EntityType<StoolEntity>> STOOL = register("stool",
			EntityType.Builder.<StoolEntity>of(StoolEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(StoolEntity::new).fireImmune().sized(0.6f, 0.01f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			SeatEntity.init();
			SofaEntity.init();
			ChairEntity.init();
			StoolEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SEAT.get(), SeatEntity.createAttributes().build());
		event.put(SOFA.get(), SofaEntity.createAttributes().build());
		event.put(CHAIR.get(), ChairEntity.createAttributes().build());
		event.put(STOOL.get(), StoolEntity.createAttributes().build());
	}
}

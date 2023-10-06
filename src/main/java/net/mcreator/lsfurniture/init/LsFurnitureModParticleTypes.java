
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lsfurniture.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.lsfurniture.LsFurnitureMod;

public class LsFurnitureModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, LsFurnitureMod.MODID);
	public static final RegistryObject<SimpleParticleType> KETTLE_PARTICLE = REGISTRY.register("kettle_particle", () -> new SimpleParticleType(true));
}

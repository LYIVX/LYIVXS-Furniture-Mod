
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lsfurniture.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.lsfurniture.LsFurnitureMod;

public class LsFurnitureModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, LsFurnitureMod.MODID);
	public static final RegistryObject<SoundEvent> MICROWAVE = REGISTRY.register("microwave", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("ls_furniture", "microwave")));
}


/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lsfurniture.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.lsfurniture.client.model.ModelSeat;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class LsFurnitureModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelSeat.LAYER_LOCATION, ModelSeat::createBodyLayer);
	}
}

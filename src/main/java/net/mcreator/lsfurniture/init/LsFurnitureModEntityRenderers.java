
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lsfurniture.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.lsfurniture.client.renderer.StoolRenderer;
import net.mcreator.lsfurniture.client.renderer.SofaRenderer;
import net.mcreator.lsfurniture.client.renderer.SeatRenderer;
import net.mcreator.lsfurniture.client.renderer.ChairRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LsFurnitureModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(LsFurnitureModEntities.SEAT.get(), SeatRenderer::new);
		event.registerEntityRenderer(LsFurnitureModEntities.SOFA.get(), SofaRenderer::new);
		event.registerEntityRenderer(LsFurnitureModEntities.CHAIR.get(), ChairRenderer::new);
		event.registerEntityRenderer(LsFurnitureModEntities.STOOL.get(), StoolRenderer::new);
	}
}

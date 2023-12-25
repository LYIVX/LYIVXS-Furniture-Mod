package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleDeskDisplayModel;
import net.mcreator.lsfurniture.block.display.JungleDeskDisplayItem;

public class JungleDeskDisplayItemRenderer extends GeoItemRenderer<JungleDeskDisplayItem> {
	public JungleDeskDisplayItemRenderer() {
		super(new JungleDeskDisplayModel());
	}

	@Override
	public RenderType getRenderType(JungleDeskDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

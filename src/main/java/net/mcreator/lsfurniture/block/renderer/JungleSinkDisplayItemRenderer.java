package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.JungleSinkDisplayItem;

public class JungleSinkDisplayItemRenderer extends GeoItemRenderer<JungleSinkDisplayItem> {
	public JungleSinkDisplayItemRenderer() {
		super(new JungleSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(JungleSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

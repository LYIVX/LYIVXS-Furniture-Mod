package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.JungleCounterDisplayItem;

public class JungleCounterDisplayItemRenderer extends GeoItemRenderer<JungleCounterDisplayItem> {
	public JungleCounterDisplayItemRenderer() {
		super(new JungleCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(JungleCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

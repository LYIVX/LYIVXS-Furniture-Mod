package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleNetherBricksCounterDisplayModel;
import net.mcreator.lsfurniture.block.display.JungleNetherBricksCounterDisplayItem;

public class JungleNetherBricksCounterDisplayItemRenderer extends GeoItemRenderer<JungleNetherBricksCounterDisplayItem> {
	public JungleNetherBricksCounterDisplayItemRenderer() {
		super(new JungleNetherBricksCounterDisplayModel());
	}

	@Override
	public RenderType getRenderType(JungleNetherBricksCounterDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleNetherBricksSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.JungleNetherBricksSinkDisplayItem;

public class JungleNetherBricksSinkDisplayItemRenderer extends GeoItemRenderer<JungleNetherBricksSinkDisplayItem> {
	public JungleNetherBricksSinkDisplayItemRenderer() {
		super(new JungleNetherBricksSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(JungleNetherBricksSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

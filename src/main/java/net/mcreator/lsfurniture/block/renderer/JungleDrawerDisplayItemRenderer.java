package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleDrawerDisplayModel;
import net.mcreator.lsfurniture.block.display.JungleDrawerDisplayItem;

public class JungleDrawerDisplayItemRenderer extends GeoItemRenderer<JungleDrawerDisplayItem> {
	public JungleDrawerDisplayItemRenderer() {
		super(new JungleDrawerDisplayModel());
	}

	@Override
	public RenderType getRenderType(JungleDrawerDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

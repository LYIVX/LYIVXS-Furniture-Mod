package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.SpruceDrawerDisplayModel;
import net.mcreator.lsfurniture.block.display.SpruceDrawerDisplayItem;

public class SpruceDrawerDisplayItemRenderer extends GeoItemRenderer<SpruceDrawerDisplayItem> {
	public SpruceDrawerDisplayItemRenderer() {
		super(new SpruceDrawerDisplayModel());
	}

	@Override
	public RenderType getRenderType(SpruceDrawerDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DeepslateOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.DeepslateOvenDisplayItem;

public class DeepslateOvenDisplayItemRenderer extends GeoItemRenderer<DeepslateOvenDisplayItem> {
	public DeepslateOvenDisplayItemRenderer() {
		super(new DeepslateOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(DeepslateOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

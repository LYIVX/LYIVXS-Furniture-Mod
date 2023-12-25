package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DioriteOvenDisplayModel;
import net.mcreator.lsfurniture.block.display.DioriteOvenDisplayItem;

public class DioriteOvenDisplayItemRenderer extends GeoItemRenderer<DioriteOvenDisplayItem> {
	public DioriteOvenDisplayItemRenderer() {
		super(new DioriteOvenDisplayModel());
	}

	@Override
	public RenderType getRenderType(DioriteOvenDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

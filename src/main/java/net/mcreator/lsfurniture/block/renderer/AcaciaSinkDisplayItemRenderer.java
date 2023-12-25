package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.AcaciaSinkDisplayItem;

public class AcaciaSinkDisplayItemRenderer extends GeoItemRenderer<AcaciaSinkDisplayItem> {
	public AcaciaSinkDisplayItemRenderer() {
		super(new AcaciaSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(AcaciaSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

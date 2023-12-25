package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.AcaciaDioriteSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.AcaciaDioriteSinkDisplayItem;

public class AcaciaDioriteSinkDisplayItemRenderer extends GeoItemRenderer<AcaciaDioriteSinkDisplayItem> {
	public AcaciaDioriteSinkDisplayItemRenderer() {
		super(new AcaciaDioriteSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(AcaciaDioriteSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

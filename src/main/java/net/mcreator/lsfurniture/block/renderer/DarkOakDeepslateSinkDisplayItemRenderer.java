package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakDeepslateSinkDisplayModel;
import net.mcreator.lsfurniture.block.display.DarkOakDeepslateSinkDisplayItem;

public class DarkOakDeepslateSinkDisplayItemRenderer extends GeoItemRenderer<DarkOakDeepslateSinkDisplayItem> {
	public DarkOakDeepslateSinkDisplayItemRenderer() {
		super(new DarkOakDeepslateSinkDisplayModel());
	}

	@Override
	public RenderType getRenderType(DarkOakDeepslateSinkDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleWardrobe1DisplayModel;
import net.mcreator.lsfurniture.block.display.JungleWardrobe1DisplayItem;

public class JungleWardrobe1DisplayItemRenderer extends GeoItemRenderer<JungleWardrobe1DisplayItem> {
	public JungleWardrobe1DisplayItemRenderer() {
		super(new JungleWardrobe1DisplayModel());
	}

	@Override
	public RenderType getRenderType(JungleWardrobe1DisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

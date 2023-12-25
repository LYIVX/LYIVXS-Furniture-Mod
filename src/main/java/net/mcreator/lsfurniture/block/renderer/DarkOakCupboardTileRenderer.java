package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.DarkOakCupboardBlockModel;
import net.mcreator.lsfurniture.block.entity.DarkOakCupboardTileEntity;

public class DarkOakCupboardTileRenderer extends GeoBlockRenderer<DarkOakCupboardTileEntity> {
	public DarkOakCupboardTileRenderer() {
		super(new DarkOakCupboardBlockModel());
	}

	@Override
	public RenderType getRenderType(DarkOakCupboardTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

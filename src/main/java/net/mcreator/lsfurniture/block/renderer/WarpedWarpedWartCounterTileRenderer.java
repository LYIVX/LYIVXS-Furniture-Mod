package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.WarpedWarpedWartCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.WarpedWarpedWartCounterTileEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class WarpedWarpedWartCounterTileRenderer extends GeoBlockRenderer<WarpedWarpedWartCounterTileEntity> {
	public WarpedWarpedWartCounterTileRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super(rendererDispatcherIn, new WarpedWarpedWartCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(WarpedWarpedWartCounterTileEntity animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

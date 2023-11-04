package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.CrimsonNetherWartCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.CrimsonNetherWartCounterTileEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CrimsonNetherWartCounterTileRenderer extends GeoBlockRenderer<CrimsonNetherWartCounterTileEntity> {
	public CrimsonNetherWartCounterTileRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super(rendererDispatcherIn, new CrimsonNetherWartCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(CrimsonNetherWartCounterTileEntity animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.JungleNetherBricksCounterBlockModel;
import net.mcreator.lsfurniture.block.entity.JungleNetherBricksCounterTileEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class JungleNetherBricksCounterTileRenderer extends GeoBlockRenderer<JungleNetherBricksCounterTileEntity> {
	public JungleNetherBricksCounterTileRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super(rendererDispatcherIn, new JungleNetherBricksCounterBlockModel());
	}

	@Override
	public RenderType getRenderType(JungleNetherBricksCounterTileEntity animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

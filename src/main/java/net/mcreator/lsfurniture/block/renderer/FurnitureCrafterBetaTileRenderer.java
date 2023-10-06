package net.mcreator.lsfurniture.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.lsfurniture.block.model.FurnitureCrafterBetaBlockModel;
import net.mcreator.lsfurniture.block.entity.FurnitureCrafterBetaTileEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FurnitureCrafterBetaTileRenderer extends GeoBlockRenderer<FurnitureCrafterBetaTileEntity> {
	public FurnitureCrafterBetaTileRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super(rendererDispatcherIn, new FurnitureCrafterBetaBlockModel());
	}

	@Override
	public RenderType getRenderType(FurnitureCrafterBetaTileEntity animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}

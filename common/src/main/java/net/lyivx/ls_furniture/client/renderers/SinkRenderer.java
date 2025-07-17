package net.lyivx.ls_furniture.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.lyivx.ls_furniture.client.util.SimpleFluidRenderer;
import net.lyivx.ls_furniture.common.blocks.entity.CounterSinkBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;

import java.util.Objects;

public class SinkRenderer implements BlockEntityRenderer<CounterSinkBlockEntity> {
    public SinkRenderer(BlockEntityRendererProvider.Context context) {
    }

    public void render(CounterSinkBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Fluid fluid = blockEntity.getFluid();
        if (fluid == Fluids.EMPTY || blockEntity.getLevel() == null) {
            return;
        }

        BlockState state = blockEntity.getBlockState();
        if (!state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
            return;
        }

        Direction direction = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        Level level = Objects.requireNonNull(blockEntity.getLevel());
        AABB box = SimpleFluidRenderer.createRotatedBox(direction, 2, 13, 2, 14, 15.9, 14);
        SimpleFluidRenderer.drawContainer(level, blockEntity.getBlockPos(), blockEntity, box, poseStack, bufferSource, packedLight);
    }
}

package net.lyivx.ls_furniture.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.lyivx.ls_furniture.common.blocks.entity.RailingBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import static net.lyivx.ls_furniture.common.blocks.RailingBlock.*;

public class RailingPreviewRenderer implements BlockEntityRenderer<RailingBlockEntity> {

    private final BlockRenderDispatcher blockRenderer;
    private static final float DEFAULT_REACH_DISTANCE = 5.0F;

    public RailingPreviewRenderer(BlockEntityRendererProvider.Context context) {
        this.blockRenderer = context.getBlockRenderDispatcher();
    }

    @Override
    public void render(@NotNull RailingBlockEntity blockEntity, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource source, int light, int overlay) {

        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        // Get the block position and player view vector
        BlockPos blockPos = blockEntity.getBlockPos();
        Minecraft mc = Minecraft.getInstance();
        Vec3 eyePosition = player.getEyePosition(partialTicks);
        Vec3 viewVector = player.getViewVector(1.0F);

        // Raycast from the player's eye position to check if they're looking at the block entity
        float reachDistance = (float) player.getAttributeValue(Attributes.BLOCK_INTERACTION_RANGE);
        if (reachDistance <= 0) {
            reachDistance = DEFAULT_REACH_DISTANCE;
        }

        Vec3 endVec = eyePosition.add(viewVector.scale(reachDistance));
        BlockHitResult hitResult = mc.level.clip(new ClipContext(eyePosition, endVec, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));


        InteractionHand hand = player.getUsedItemHand();
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();

        BlockState blockState = blockEntity.getBlockState();

        if (item.equals(blockState.getBlock().asItem())) {
            if (hitResult.getBlockPos().equals(blockPos)) {
                // Only render if the player is looking at the inside of the block
                Vec3 hitPosition = hitResult.getLocation();
                double xOffset = hitPosition.x - blockPos.getX();
                double zOffset = hitPosition.z - blockPos.getZ();

                // Ensure the hit position is within the inside part of the block (not too close to edges)
                if (xOffset > 0.01 && xOffset < 0.99 && zOffset > 0.01 && zOffset < 0.99) {
                    poseStack.pushPose();
                    poseStack.scale(1, 1, 1);

                    long time = Minecraft.getInstance().level.getGameTime();
                    float pulseFactor = (float) Math.sin(time / 5.0) * 0.5f/16f + 1.0f; // Adjust multiplier to control pulse intensity

                    poseStack.scale(1, pulseFactor, 1);

                    Direction hitFace = hitResult.getDirection();

                    // Handle the half of the face the player is looking at based on offsets
                    if (hitFace == Direction.SOUTH) {
                        if (zOffset < 0.5) {
                            if (xOffset < 0.5) {
                                if (blockState.getValue(WEST_RAILING).equals(false)) {
                                    poseStack.mulPose(Axis.YP.rotationDegrees(90)); // Left
                                    poseStack.translate(-1, 0, 0);
                                } else poseStack.scale(0, 0, 0);
                            } else {
                                if (blockState.getValue(EAST_RAILING).equals(false)) {
                                    poseStack.mulPose(Axis.YP.rotationDegrees(270)); // Right
                                    poseStack.translate(0, 0, -1);
                                } else poseStack.scale(0, 0, 0);
                            }
                        } else poseStack.scale(0, 0, 0);
                    }
                    if (hitFace == Direction.WEST) {
                        if (xOffset < 0.5) {
                            poseStack.scale(0, 0, 0);
                        } else {
                            if (zOffset < 0.5) {
                                if (blockState.getValue(NORTH_RAILING).equals(false)) {
                                    poseStack.mulPose(Axis.YP.rotationDegrees(0)); // Left
                                    poseStack.translate(0, 0, 0);
                                } else poseStack.scale(0, 0, 0);
                            } else {
                                if (blockState.getValue(SOUTH_RAILING).equals(false)) {
                                    poseStack.mulPose(Axis.YP.rotationDegrees(180)); // Right
                                    poseStack.translate(-1, 0, -1);
                                } else poseStack.scale(0, 0, 0);
                            }
                        }
                    }
                    if (hitFace == Direction.EAST) {
                        if (xOffset < 0.5) {
                            if (zOffset < 0.5) {
                                if (blockState.getValue(NORTH_RAILING).equals(false)) {
                                    poseStack.mulPose(Axis.YP.rotationDegrees(0)); // Right
                                    poseStack.translate(0, 0, 0);
                                } else poseStack.scale(0, 0, 0);
                            } else {
                                if (blockState.getValue(SOUTH_RAILING).equals(false)) {
                                    poseStack.mulPose(Axis.YP.rotationDegrees(180)); // Left
                                    poseStack.translate(-1, 0, -1);
                                } else poseStack.scale(0, 0, 0);
                            }
                        } else poseStack.scale(0, 0, 0);
                    }
                    if (hitFace == Direction.NORTH) {
                        if (zOffset < 0.5) {
                            poseStack.scale(0, 0, 0);
                        } else {
                            if (xOffset < 0.5) {
                                if (blockState.getValue(WEST_RAILING).equals(false)) {
                                    poseStack.mulPose(Axis.YP.rotationDegrees(90)); // Right
                                    poseStack.translate(-1, 0, 0);
                                } else poseStack.scale(0, 0, 0);
                            } else {
                                if (blockState.getValue(EAST_RAILING).equals(false)) {
                                    poseStack.mulPose(Axis.YP.rotationDegrees(270)); // Left
                                    poseStack.translate(0, 0, -1);
                                } else poseStack.scale(0, 0, 0);
                            }
                        }
                    }
                    if (hitFace == Direction.UP) {
                        poseStack.scale(0, 0, 0);
                    }
                    if (hitFace == Direction.DOWN) {
                        poseStack.scale(0, 0, 0);
                    }

                    blockRenderer.getModelRenderer().renderModel(
                            poseStack.last(),
                            source.getBuffer(Sheets.cutoutBlockSheet()),
                            blockEntity.getBlockState().getBlock().defaultBlockState(),
                            Minecraft.getInstance().getBlockRenderer().getBlockModel(blockState),
                            1.0f, 1.0f, 1.0f,
                            light,
                            OverlayTexture.NO_OVERLAY
                    );

                    // Apply the enchantment glint effect
                    blockRenderer.getModelRenderer().renderModel(
                            poseStack.last(),
                            source.getBuffer(RenderType.glint()),
                            blockEntity.getBlockState().getBlock().defaultBlockState(),
                            Minecraft.getInstance().getBlockRenderer().getBlockModel(blockState),
                            1.0f, 1.0f, 1.0f,
                            light,
                            OverlayTexture.NO_OVERLAY
                    );

                    poseStack.popPose();
                }
            }
        }
    }
}

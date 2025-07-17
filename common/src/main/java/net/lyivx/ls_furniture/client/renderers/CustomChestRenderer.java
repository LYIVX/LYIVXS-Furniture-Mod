package net.lyivx.ls_furniture.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.blocks.entity.CustomChestBlockEntity;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;

import java.util.Calendar;

@Environment(EnvType.CLIENT)
public class CustomChestRenderer<T extends BlockEntity & LidBlockEntity> implements BlockEntityRenderer<CustomChestBlockEntity> {
    private static final String BOTTOM = "bottom";
    private static final String LID = "lid";
    private static final String LOCK = "lock";
    private final ModelPart lid;
    private final ModelPart bottom;
    private final ModelPart lock;
    private final ModelPart doubleLeftLid;
    private final ModelPart doubleLeftBottom;
    private final ModelPart doubleLeftLock;
    private final ModelPart doubleRightLid;
    private final ModelPart doubleRightBottom;
    private final ModelPart doubleRightLock;
    private boolean christmas;
    private boolean starwarsday;

    public CustomChestRenderer(BlockEntityRendererProvider.Context context) {
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
            this.christmas = true;
        }
        if (calendar.get(2) + 1 == 5 && calendar.get(5) >= 3 && calendar.get(5) <= 5) {
            this.starwarsday = true;
        }

        ModelPart modelPart = context.bakeLayer(ModelLayers.CHEST);
        this.bottom = modelPart.getChild("bottom");
        this.lid = modelPart.getChild("lid");
        this.lock = modelPart.getChild("lock");
        ModelPart modelPart2 = context.bakeLayer(ModelLayers.DOUBLE_CHEST_LEFT);
        this.doubleLeftBottom = modelPart2.getChild("bottom");
        this.doubleLeftLid = modelPart2.getChild("lid");
        this.doubleLeftLock = modelPart2.getChild("lock");
        ModelPart modelPart3 = context.bakeLayer(ModelLayers.DOUBLE_CHEST_RIGHT);
        this.doubleRightBottom = modelPart3.getChild("bottom");
        this.doubleRightLid = modelPart3.getChild("lid");
        this.doubleRightLock = modelPart3.getChild("lock");
    }

    public static LayerDefinition createSingleBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 19).addBox(1.0F, 0.0F, 1.0F, 14.0F, 10.0F, 14.0F), PartPose.ZERO);
        partDefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, 0.0F, 0.0F, 14.0F, 5.0F, 14.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
        partDefinition.addOrReplaceChild("lock", CubeListBuilder.create().texOffs(0, 0).addBox(7.0F, -2.0F, 14.0F, 2.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public static LayerDefinition createDoubleBodyRightLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 19).addBox(1.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F), PartPose.ZERO);
        partDefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
        partDefinition.addOrReplaceChild("lock", CubeListBuilder.create().texOffs(0, 0).addBox(15.0F, -2.0F, 14.0F, 1.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public static LayerDefinition createDoubleBodyLeftLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 19).addBox(0.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F), PartPose.ZERO);
        partDefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
        partDefinition.addOrReplaceChild("lock", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, 14.0F, 1.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @SuppressWarnings("unchecked")
    public void render(CustomChestBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        Level level = blockEntity.getLevel();
        boolean bl = level != null;
        BlockState blockState = bl ? blockEntity.getBlockState() : (BlockState) Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.SOUTH);
        ChestType chestType = blockState.hasProperty(ChestBlock.TYPE) ? (ChestType)blockState.getValue(ChestBlock.TYPE) : ChestType.SINGLE;
        Block block = blockState.getBlock();
        if (block instanceof AbstractChestBlock<?> abstractChestBlock) {
            boolean bl2 = chestType != ChestType.SINGLE;
            poseStack.pushPose();
            float f = ((Direction)blockState.getValue(ChestBlock.FACING)).toYRot();
            poseStack.translate(0.5F, 0.5F, 0.5F);
            poseStack.mulPose(Axis.YP.rotationDegrees(-f));
            poseStack.translate(-0.5F, -0.5F, -0.5F);
            DoubleBlockCombiner.NeighborCombineResult neighborCombineResult;
            if (bl) {
                neighborCombineResult = abstractChestBlock.combine(blockState, level, blockEntity.getBlockPos(), true);
            } else {
                neighborCombineResult = DoubleBlockCombiner.Combiner::acceptNone;
            }

            float g = ((Float2FloatFunction)neighborCombineResult.apply(ChestBlock.opennessCombiner((LidBlockEntity)blockEntity))).get(partialTick);
            g = 1.0F - g;
            g = 1.0F - g * g * g;
            int i = ((Int2IntFunction)neighborCombineResult.apply(new BrightnessCombiner())).applyAsInt(packedLight);
            Material material = getChestMaterial(blockEntity, chestType);
            VertexConsumer vertexConsumer = material.buffer(buffer, RenderType::entityCutout);
            if (bl2) {
                if (chestType == ChestType.LEFT) {
                    this.render(poseStack, vertexConsumer, this.doubleLeftLid, this.doubleLeftLock, this.doubleLeftBottom, g, i, packedOverlay);
                } else {
                    this.render(poseStack, vertexConsumer, this.doubleRightLid, this.doubleRightLock, this.doubleRightBottom, g, i, packedOverlay);
                }
            } else {
                this.render(poseStack, vertexConsumer, this.lid, this.lock, this.bottom, g, i, packedOverlay);
            }

            poseStack.popPose();
        }
    }

    private void render(PoseStack poseStack, VertexConsumer consumer, ModelPart lidPart, ModelPart lockPart, ModelPart bottomPart, float lidAngle, int packedLight, int packedOverlay) {
        lidPart.xRot = -(lidAngle * 1.5707964F);
        lockPart.xRot = lidPart.xRot;
        lidPart.render(poseStack, consumer, packedLight, packedOverlay);
        lockPart.render(poseStack, consumer, packedLight, packedOverlay);
        bottomPart.render(poseStack, consumer, packedLight, packedOverlay);
    }

    public static Material chooseMaterial(ChestType type, Material left, Material right, Material single) {
        return switch (type) {
            case LEFT -> left;
            case RIGHT -> right;
            default -> single;
        };
    }

    public static Material getChestPath(String name) {

        return new Material(Sheets.CHEST_SHEET, LYIVXsFurnitureMod.createResourceLocation("entity/chest/" + name));
    }

    private Material getChestMaterial(CustomChestBlockEntity blockEntity, ChestType type) {
        if (christmas) {
            return Sheets.chooseMaterial(blockEntity, type, true);
        } else if (starwarsday) {
            return chooseMaterial(type, getChestPath("starwars_left"), getChestPath("starwars_right"), getChestPath("starwars"));
        } else {
            return chooseMaterial(type, getChestPath(blockEntity.getBlock().chestType + "_left"),
                    getChestPath(blockEntity.getBlock().chestType + "_right"), getChestPath(blockEntity.getBlock().chestType));
        }
    }
}

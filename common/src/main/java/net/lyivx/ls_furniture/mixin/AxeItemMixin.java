package net.lyivx.ls_furniture.mixin;

import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(AxeItem.class)
public class AxeItemMixin {
    @Shadow
    private Optional<BlockState> getStripped(BlockState unstrippedState) {
        // Used the original code from the AxeItem class
        return Optional.empty();
    }

    @Inject(method = "useOn", at = @At("HEAD"))
    private void onUseOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        // Do nothing on the client side
        if (context.getLevel().isClientSide || !(context.getPlayer() instanceof ServerPlayer serverPlayer)) {
            return;
        }

        // Dropping bark in creative is unnecessary
        if (serverPlayer.isCreative()) {
            return;
        }

        var blockState = context.getLevel().getBlockState(context.getClickedPos());
        var strippedBlockState = getStripped(blockState);

        // We actually check if the player actually does strip a log.
        if (strippedBlockState.isEmpty()) {
            return;
        }

        lYIVXS_Furniture_Mod$dropBark(context, blockState.getBlock());
    }

    @Unique
    private void lYIVXS_Furniture_Mod$dropBark(UseOnContext context, Block block) {
        ItemStack bark = ItemStack.EMPTY;

        // Determine which type of bark to drop based on the block registry name
        if (block == Blocks.OAK_LOG) {
            bark = new ItemStack(ModItems.OAK_BARK.get());
        } else if (block == Blocks.SPRUCE_LOG) {
            bark = new ItemStack(ModItems.SPRUCE_BARK.get());
        } else if (block == Blocks.BIRCH_LOG) {
            bark = new ItemStack(ModItems.BIRCH_BARK.get());
        } else if (block == Blocks.JUNGLE_LOG) {
            bark = new ItemStack(ModItems.JUNGLE_BARK.get());
        } else if (block == Blocks.ACACIA_LOG) {
            bark = new ItemStack(ModItems.ACACIA_BARK.get());
        } else if (block == Blocks.DARK_OAK_LOG) {
            bark = new ItemStack(ModItems.DARK_OAK_BARK.get());
        } else if (block == Blocks.MANGROVE_LOG) {
            bark = new ItemStack(ModItems.MANGROVE_BARK.get());
        } else if (block == Blocks.CHERRY_LOG) {
            bark = new ItemStack(ModItems.CHERRY_BARK.get());
        } else if (block == Blocks.BAMBOO_BLOCK) {
            bark = new ItemStack(ModItems.BAMBOO_BARK.get());
        } else if (block == Blocks.CRIMSON_STEM) {
            bark = new ItemStack(ModItems.CRIMSON_BARK.get());
        } else if (block == Blocks.WARPED_STEM) {
            bark = new ItemStack(ModItems.WARPED_BARK.get());
        } else if (block == Blocks.OAK_WOOD) {
            bark = new ItemStack(ModItems.OAK_BARK.get());
        } else if (block == Blocks.SPRUCE_WOOD) {
            bark = new ItemStack(ModItems.SPRUCE_BARK.get());
        } else if (block == Blocks.BIRCH_WOOD) {
            bark = new ItemStack(ModItems.BIRCH_BARK.get());
        } else if (block == Blocks.JUNGLE_WOOD) {
            bark = new ItemStack(ModItems.JUNGLE_BARK.get());
        } else if (block == Blocks.ACACIA_WOOD) {
            bark = new ItemStack(ModItems.ACACIA_BARK.get());
        } else if (block == Blocks.DARK_OAK_WOOD) {
            bark = new ItemStack(ModItems.DARK_OAK_BARK.get());
        } else if (block == Blocks.MANGROVE_WOOD) {
            bark = new ItemStack(ModItems.MANGROVE_BARK.get());
        } else if (block == Blocks.CHERRY_WOOD) {
            bark = new ItemStack(ModItems.CHERRY_BARK.get());
        } else if (block == Blocks.CRIMSON_HYPHAE) {
            bark = new ItemStack(ModItems.CRIMSON_BARK.get());
        } else if (block == Blocks.WARPED_HYPHAE) {
            bark = new ItemStack(ModItems.WARPED_BARK.get());
        }

        if (!bark.isEmpty()) {
            Vec3 dropPosition = Vec3.atBottomCenterOf(context.getClickedPos());
            ItemEntity itemEntity = new ItemEntity(context.getLevel(), dropPosition.x, dropPosition.y + 1, dropPosition.z, bark);
            context.getLevel().addFreshEntity(itemEntity);
        }
    }
}

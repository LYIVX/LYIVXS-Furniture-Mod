package net.lyivx.ls_furniture.mixin;

import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AxeItem.class)
public class AxeItemMixin {

    @Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
    private void onUseOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        if (context.getLevel().isClientSide) {
            return; // Do nothing on client side
        }

        BlockState clickedBlockState = context.getLevel().getBlockState(context.getClickedPos());
        Block clickedBlock = clickedBlockState.getBlock();

        if (clickedBlock == Blocks.OAK_LOG
                || clickedBlock == Blocks.SPRUCE_LOG
                || clickedBlock == Blocks.BIRCH_LOG
                || clickedBlock == Blocks.JUNGLE_LOG
                || clickedBlock == Blocks.ACACIA_LOG
                || clickedBlock == Blocks.DARK_OAK_LOG
                || clickedBlock == Blocks.MANGROVE_LOG
                || clickedBlock == Blocks.CHERRY_LOG
                || clickedBlock == Blocks.BAMBOO_BLOCK
                || clickedBlock == Blocks.CRIMSON_STEM
                || clickedBlock == Blocks.WARPED_STEM
                || clickedBlock == Blocks.OAK_WOOD
                || clickedBlock == Blocks.SPRUCE_WOOD
                || clickedBlock == Blocks.BIRCH_WOOD
                || clickedBlock == Blocks.JUNGLE_WOOD
                || clickedBlock == Blocks.ACACIA_WOOD
                || clickedBlock == Blocks.DARK_OAK_WOOD
                || clickedBlock == Blocks.MANGROVE_WOOD
                || clickedBlock == Blocks.CHERRY_WOOD
                || clickedBlock == Blocks.CRIMSON_HYPHAE
                || clickedBlock == Blocks.WARPED_HYPHAE) {
            System.out.println("Detected log block: " + clickedBlock.getDescriptionId());

            // Drop bark item
            dropBark(context, clickedBlockState);

            // Strip the log (replace with stripped log)
            BlockState strippedLogState = getStrippedLogState(clickedBlockState);
            context.getLevel().setBlockAndUpdate(context.getClickedPos(), strippedLogState);

            // Send block update to clients to synchronize changes
            sendBlockUpdate(context.getLevel(), context.getClickedPos());

            cir.setReturnValue(InteractionResult.SUCCESS); // Indicate success
        }
    }

    private void dropBark(UseOnContext context, BlockState blockState) {
        Block block = blockState.getBlock();
        ItemStack bark = ItemStack.EMPTY;

        String blockRegistryName = block.getName().toString();

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
            System.out.println("Dropping " + bark.getItem().getDescriptionId() + " at: " + dropPosition);
            ItemEntity itemEntity = new ItemEntity(context.getLevel(), dropPosition.x, dropPosition.y + 1, dropPosition.z, bark);
            context.getLevel().addFreshEntity(itemEntity);
        }
    }

    private BlockState getStrippedLogState(BlockState originalLogState) {
        Block block = originalLogState.getBlock();
        String blockRegistryName = block.getName().toString();

        if (block == Blocks.OAK_LOG) {
            return Blocks.STRIPPED_OAK_LOG.defaultBlockState();
        } else if (block == Blocks.SPRUCE_LOG) {
            return Blocks.STRIPPED_SPRUCE_LOG.defaultBlockState();
        } else if (block == Blocks.BIRCH_LOG) {
            return Blocks.STRIPPED_BIRCH_LOG.defaultBlockState();
        } else if (block == Blocks.JUNGLE_LOG) {
            return Blocks.STRIPPED_JUNGLE_LOG.defaultBlockState();
        } else if (block == Blocks.ACACIA_LOG) {
            return Blocks.STRIPPED_ACACIA_LOG.defaultBlockState();
        } else if (block == Blocks.DARK_OAK_LOG) {
            return Blocks.STRIPPED_DARK_OAK_LOG.defaultBlockState();
        } else if (block == Blocks.MANGROVE_LOG) {
            return Blocks.STRIPPED_MANGROVE_LOG.defaultBlockState();
        } else if (block == Blocks.CHERRY_LOG) {
            return Blocks.STRIPPED_CHERRY_LOG.defaultBlockState();
        } else if (block == Blocks.BAMBOO_BLOCK) {
            return Blocks.STRIPPED_BAMBOO_BLOCK.defaultBlockState();
        } else if (block == Blocks.CRIMSON_STEM) {
            return Blocks.STRIPPED_CRIMSON_STEM.defaultBlockState();
        } else if (block == Blocks.WARPED_STEM) {
            return Blocks.STRIPPED_WARPED_STEM.defaultBlockState();
        } else if (block == Blocks.OAK_WOOD) {
            return Blocks.STRIPPED_OAK_WOOD.defaultBlockState();
        } else if (block == Blocks.SPRUCE_WOOD) {
            return Blocks.STRIPPED_SPRUCE_WOOD.defaultBlockState();
        } else if (block == Blocks.BIRCH_WOOD) {
            return Blocks.STRIPPED_BIRCH_WOOD.defaultBlockState();
        } else if (block == Blocks.JUNGLE_WOOD) {
            return Blocks.STRIPPED_JUNGLE_WOOD.defaultBlockState();
        } else if (block == Blocks.ACACIA_WOOD) {
            return Blocks.STRIPPED_ACACIA_WOOD.defaultBlockState();
        } else if (block == Blocks.DARK_OAK_WOOD) {
            return Blocks.STRIPPED_DARK_OAK_WOOD.defaultBlockState();
        } else if (block == Blocks.MANGROVE_WOOD) {
            return Blocks.STRIPPED_MANGROVE_WOOD.defaultBlockState();
        } else if (block == Blocks.CHERRY_WOOD) {
            return Blocks.STRIPPED_CHERRY_WOOD.defaultBlockState();
        } else if (block == Blocks.CRIMSON_HYPHAE) {
            return Blocks.STRIPPED_CRIMSON_STEM.defaultBlockState();
        } else if (block == Blocks.WARPED_HYPHAE) {
            return Blocks.STRIPPED_WARPED_STEM.defaultBlockState();
        }

        return null; // Return null if no matching stripped log state found
    }

    private void sendBlockUpdate(Level level, BlockPos pos) {
        level.sendBlockUpdated(pos, level.getBlockState(pos), level.getBlockState(pos), 3); // Notify clients of block update
    }
}

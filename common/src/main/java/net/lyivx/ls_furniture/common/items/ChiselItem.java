package net.lyivx.ls_furniture.common.items;

import net.lyivx.ls_furniture.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static net.lyivx.ls_furniture.common.blocks.HollowLogBlock.AXIS;

public class ChiselItem extends Item {

    private static final Map<Block, Supplier<Block>> HOLLOW_BLOCKS = new HashMap<>();

    static {
        HOLLOW_BLOCKS.put(Blocks.OAK_LOG, ModBlocks.OAK_HOLLOW_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.SPRUCE_LOG, ModBlocks.SPRUCE_HOLLOW_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.BIRCH_LOG, ModBlocks.BIRCH_HOLLOW_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.JUNGLE_LOG, ModBlocks.JUNGLE_HOLLOW_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.ACACIA_LOG, ModBlocks.ACACIA_HOLLOW_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.DARK_OAK_LOG, ModBlocks.DARK_OAK_HOLLOW_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.MANGROVE_LOG, ModBlocks.MANGROVE_HOLLOW_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.CHERRY_LOG, ModBlocks.CHERRY_HOLLOW_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.BAMBOO_BLOCK, ModBlocks.BAMBOO_HOLLOW_BLOCK::get);
        HOLLOW_BLOCKS.put(Blocks.CRIMSON_STEM, ModBlocks.CRIMSON_HOLLOW_STEM::get);
        HOLLOW_BLOCKS.put(Blocks.WARPED_STEM, ModBlocks.WARPED_HOLLOW_STEM::get);
        HOLLOW_BLOCKS.put(Blocks.STRIPPED_OAK_LOG, ModBlocks.OAK_HOLLOW_STRIPPED_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.STRIPPED_SPRUCE_LOG, ModBlocks.SPRUCE_HOLLOW_STRIPPED_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.STRIPPED_BIRCH_LOG, ModBlocks.BIRCH_HOLLOW_STRIPPED_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.STRIPPED_JUNGLE_LOG, ModBlocks.JUNGLE_HOLLOW_STRIPPED_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.STRIPPED_ACACIA_LOG, ModBlocks.ACACIA_HOLLOW_STRIPPED_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.STRIPPED_DARK_OAK_LOG, ModBlocks.DARK_OAK_HOLLOW_STRIPPED_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.STRIPPED_MANGROVE_LOG, ModBlocks.MANGROVE_HOLLOW_STRIPPED_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.STRIPPED_CHERRY_LOG, ModBlocks.CHERRY_HOLLOW_STRIPPED_LOG::get);
        HOLLOW_BLOCKS.put(Blocks.STRIPPED_BAMBOO_BLOCK, ModBlocks.BAMBOO_HOLLOW_BLOCK::get);
        HOLLOW_BLOCKS.put(Blocks.STRIPPED_CRIMSON_STEM, ModBlocks.CRIMSON_HOLLOW_STEM::get);
        HOLLOW_BLOCKS.put(Blocks.STRIPPED_WARPED_STEM, ModBlocks.WARPED_HOLLOW_STEM::get);
    }

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        BlockState state = level.getBlockState(pos);
        ItemStack stack = player.getItemInHand(hand);

        Block block = state.getBlock();
        Supplier<Block> hollowBlockSupplier = HOLLOW_BLOCKS.get(block);
        if (hollowBlockSupplier != null) {
            level.setBlock(pos, hollowBlockSupplier.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS)), 3);
            return InteractionResult.SUCCESS;

        }

        return InteractionResult.PASS;
    }


    /*@Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.wrench.1"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.screen.shift"));
        }
        super.appendHoverText(stack, level, tooltipComponents, flag);
    }*/
}

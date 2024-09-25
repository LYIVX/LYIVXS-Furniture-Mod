package net.lyivx.ls_furniture.common.items;

import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static net.lyivx.ls_furniture.common.blocks.OvenVentBlock.FACING;

public class OvenModuleItem extends Item {

    private static final Map<Block, Supplier<Block>> COUNTER_BLOCKS = new HashMap<>();

    static {
        COUNTER_BLOCKS.put(ModBlocks.OAK_COUNTER.get(), ModBlocks.OAK_COUNTER_OVEN::get);
        COUNTER_BLOCKS.put(ModBlocks.SPRUCE_COUNTER.get(), ModBlocks.SPRUCE_COUNTER_OVEN::get);
        COUNTER_BLOCKS.put(ModBlocks.BIRCH_COUNTER.get(), ModBlocks.BIRCH_COUNTER_OVEN::get);
        COUNTER_BLOCKS.put(ModBlocks.JUNGLE_COUNTER.get(), ModBlocks.JUNGLE_COUNTER_OVEN::get);
        COUNTER_BLOCKS.put(ModBlocks.ACACIA_COUNTER.get(), ModBlocks.ACACIA_COUNTER_OVEN::get);
        COUNTER_BLOCKS.put(ModBlocks.DARK_OAK_COUNTER.get(), ModBlocks.DARK_OAK_COUNTER_OVEN::get);
        COUNTER_BLOCKS.put(ModBlocks.MANGROVE_COUNTER.get(), ModBlocks.MANGROVE_COUNTER_OVEN::get);
        COUNTER_BLOCKS.put(ModBlocks.CHERRY_COUNTER.get(), ModBlocks.CHERRY_COUNTER_OVEN::get);
        COUNTER_BLOCKS.put(ModBlocks.BAMBOO_COUNTER.get(), ModBlocks.BAMBOO_COUNTER_OVEN::get);
        COUNTER_BLOCKS.put(ModBlocks.CRIMSON_COUNTER.get(), ModBlocks.CRIMSON_COUNTER_OVEN::get);
        COUNTER_BLOCKS.put(ModBlocks.WARPED_COUNTER.get(), ModBlocks.WARPED_COUNTER_OVEN::get);
    }

    public OvenModuleItem(Properties properties) {
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
        Supplier<Block> ovenBlockSupplier = COUNTER_BLOCKS.get(block);
        if (ovenBlockSupplier != null) {
            level.setBlock(pos, ovenBlockSupplier.get().defaultBlockState().setValue(FACING, state.getValue(FACING)), 3);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
    
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.ls_furniture.oven"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
        super.appendHoverText(stack, context, tooltipComponents, flag);
    }
}

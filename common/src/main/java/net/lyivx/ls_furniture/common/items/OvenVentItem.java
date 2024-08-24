package net.lyivx.ls_furniture.common.items;

import net.lyivx.ls_furniture.registry.ModBlocks;
import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
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

public class OvenVentItem extends BlockItem {

    private static final Map<Block, Supplier<Block>> CABINET_BLOCKS = new HashMap<>();

    static {
        CABINET_BLOCKS.put(ModBlocks.OAK_CABINET.get(), ModBlocks.OAK_CABINET_OVEN_VENT::get);
        CABINET_BLOCKS.put(ModBlocks.SPRUCE_CABINET.get(), ModBlocks.SPRUCE_CABINET_OVEN_VENT::get);
        CABINET_BLOCKS.put(ModBlocks.BIRCH_CABINET.get(), ModBlocks.BIRCH_CABINET_OVEN_VENT::get);
        CABINET_BLOCKS.put(ModBlocks.JUNGLE_CABINET.get(), ModBlocks.JUNGLE_CABINET_OVEN_VENT::get);
        CABINET_BLOCKS.put(ModBlocks.ACACIA_CABINET.get(), ModBlocks.ACACIA_CABINET_OVEN_VENT::get);
        CABINET_BLOCKS.put(ModBlocks.DARK_OAK_CABINET.get(), ModBlocks.DARK_OAK_CABINET_OVEN_VENT::get);
        CABINET_BLOCKS.put(ModBlocks.MANGROVE_CABINET.get(), ModBlocks.MANGROVE_CABINET_OVEN_VENT::get);
        CABINET_BLOCKS.put(ModBlocks.CHERRY_CABINET.get(), ModBlocks.CHERRY_CABINET_OVEN_VENT::get);
        CABINET_BLOCKS.put(ModBlocks.BAMBOO_CABINET.get(), ModBlocks.BAMBOO_CABINET_OVEN_VENT::get);
        CABINET_BLOCKS.put(ModBlocks.CRIMSON_CABINET.get(), ModBlocks.CRIMSON_CABINET_OVEN_VENT::get);
        CABINET_BLOCKS.put(ModBlocks.WARPED_CABINET.get(), ModBlocks.WARPED_CABINET_OVEN_VENT::get);
    }

    public OvenVentItem(Block blockPlace, Properties properties) {
        super(blockPlace, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState state = level.getBlockState(pos);

        Block block = state.getBlock();
        Supplier<Block> cabinetBlockSupplier = CABINET_BLOCKS.get(block);

        if (cabinetBlockSupplier != null) {
            level.setBlock(pos, cabinetBlockSupplier.get().defaultBlockState().setValue(FACING, state.getValue(FACING)), 3);
            return InteractionResult.SUCCESS;
        } else {
            InteractionResult interactionResult = this.place(new BlockPlaceContext(context));

            if (!interactionResult.consumesAction() && this.isEdible()) {
                InteractionResult interactionResult2 = this.use(context.getLevel(), context.getPlayer(), context.getHand()).getResult();
                return interactionResult2 == InteractionResult.CONSUME ? InteractionResult.CONSUME_PARTIAL : interactionResult2;
            } else {
                return interactionResult;
            }
        }
    }
    
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.ls_furniture.oven_vent"));
            tooltipComponents.add(Component.translatable("tooltip.ls_furniture.screen.blank"));
            tooltipComponents.add(Component.translatable("tooltip.ls_furniture.screen.properties"));
            tooltipComponents.add(Component.translatable("tooltip.ls_furniture.wrenchable"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.ls_furniture.screen.shift"));
        }
        super.appendHoverText(stack, level, tooltipComponents, flag);
    }
}

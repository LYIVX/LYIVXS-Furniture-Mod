package net.lyivx.ls_furniture.common.blocks.entity;

import net.lyivx.ls_furniture.common.blocks.ToasterBlock;
import net.lyivx.ls_furniture.registry.ModBlockEntitys;
import net.lyivx.ls_furniture.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ToasterBlockEntity extends BlockEntity {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private int toastingProgress;


    public ToasterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntitys.TOASTER_ENTITY.get(), pos, state);
    }

    public void startToasting() {
        scheduler.schedule(() -> {
            if (level instanceof ServerLevel) {
                ServerLevel serverLevel = (ServerLevel) level;
                BlockState newState = this.getBlockState().setValue(ToasterBlock.TOASTING, false); // Back to non-toasting
                serverLevel.setBlock(getBlockPos(), newState, 3);
                dropToast(serverLevel, getBlockPos());
            }
        }, 5, TimeUnit.SECONDS); // Wait 5 seconds
    }

    private void dropToast(ServerLevel level, BlockPos pos) {
        Item toastItem = ModItems.TOAST.get(); // Replace with the actual toast item if different
        level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(toastItem)));
    }

    public int getToastingProgress() {
        // Example implementation; adjust as needed
        return this.toastingProgress;
    }

    public void setToastingProgress(int progress) {
        this.toastingProgress = progress;
    }
}
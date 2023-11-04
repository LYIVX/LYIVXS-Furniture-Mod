package net.mcreator.lsfurniture.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.init.LsFurnitureModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BarkProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:logs")))) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.OAK_LOG) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(LsFurnitureModItems.OAK_BARK.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DARK_OAK_LOG) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(LsFurnitureModItems.DARK_OAK_BARK.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.SPRUCE_LOG) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(LsFurnitureModItems.SPRUCE_BARK.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.ACACIA_LOG) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(LsFurnitureModItems.ACACIA_BARK.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.BIRCH_LOG) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(LsFurnitureModItems.BIRCH_BARK.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.JUNGLE_LOG) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(LsFurnitureModItems.JUNGLE_BARK.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.MANGROVE_LOG) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(LsFurnitureModItems.MANGROVE_BARK.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.CRIMSON_STEM) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(LsFurnitureModItems.CRIMSON_BARK.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.WARPED_STEM) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(LsFurnitureModItems.WARPED_BARK.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
		}
	}
}

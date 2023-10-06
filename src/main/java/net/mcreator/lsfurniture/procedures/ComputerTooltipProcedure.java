package net.mcreator.lsfurniture.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.lsfurniture.init.LsFurnitureModBlocks;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class ComputerTooltipProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getItem() == LsFurnitureModBlocks.COMPUTER_OFF.get().asItem() || itemstack.getItem() == LsFurnitureModBlocks.COMPUTER_ON.get().asItem() || itemstack.getItem() == LsFurnitureModBlocks.COMPUTER_MINECRAFT.get().asItem()
				|| itemstack.getItem() == LsFurnitureModBlocks.COMPUTER_COD.get().asItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Click The Computer To Switch Games"));
			} else {
				tooltip.add(Component.literal("Press \u00A7eShift \u00A7rFor More Information"));
			}
		}
	}
}

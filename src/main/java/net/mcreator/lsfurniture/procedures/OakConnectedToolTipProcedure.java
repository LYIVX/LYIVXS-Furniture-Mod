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
public class OakConnectedToolTipProcedure {
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
		String Wood = "";
		ItemStack SBC = ItemStack.EMPTY;
		ItemStack SBF = ItemStack.EMPTY;
		ItemStack SBN = ItemStack.EMPTY;
		ItemStack BBC = ItemStack.EMPTY;
		ItemStack BBF = ItemStack.EMPTY;
		ItemStack BBN = ItemStack.EMPTY;
		ItemStack CHC = ItemStack.EMPTY;
		ItemStack CHF = ItemStack.EMPTY;
		ItemStack CHN = ItemStack.EMPTY;
		ItemStack CHKC = ItemStack.EMPTY;
		ItemStack CHKF = ItemStack.EMPTY;
		ItemStack CHKN = ItemStack.EMPTY;
		ItemStack DIC = ItemStack.EMPTY;
		ItemStack DIF = ItemStack.EMPTY;
		ItemStack DIN = ItemStack.EMPTY;
		ItemStack DUC = ItemStack.EMPTY;
		ItemStack DUF = ItemStack.EMPTY;
		ItemStack DUN = ItemStack.EMPTY;
		ItemStack HSC = ItemStack.EMPTY;
		ItemStack HSF = ItemStack.EMPTY;
		ItemStack HSN = ItemStack.EMPTY;
		ItemStack VSC = ItemStack.EMPTY;
		ItemStack VCF = ItemStack.EMPTY;
		ItemStack VCN = ItemStack.EMPTY;
		ItemStack MOC = ItemStack.EMPTY;
		ItemStack MOF = ItemStack.EMPTY;
		ItemStack MON = ItemStack.EMPTY;
		ItemStack PLC = ItemStack.EMPTY;
		ItemStack PLF = ItemStack.EMPTY;
		ItemStack PLN = ItemStack.EMPTY;
		ItemStack SLC = ItemStack.EMPTY;
		ItemStack SLF = ItemStack.EMPTY;
		ItemStack SLN = ItemStack.EMPTY;
		ItemStack SWC = ItemStack.EMPTY;
		ItemStack SWF = ItemStack.EMPTY;
		ItemStack SWN = ItemStack.EMPTY;
		ItemStack WAC = ItemStack.EMPTY;
		ItemStack WAF = ItemStack.EMPTY;
		ItemStack WAN = ItemStack.EMPTY;
		Wood = "Oak";
		SBC = new ItemStack(LsFurnitureModBlocks.CONNECTING_OAK_BIG_BRICKS.get());
		SBF = new ItemStack(LsFurnitureModBlocks.FRAMED_OAK_SMALL_BRICKS.get());
		SBF = new ItemStack(LsFurnitureModBlocks.OAK_SMALL_BRICKS.get());
		BBC = new ItemStack(LsFurnitureModBlocks.CONNECTING_OAK_BIG_BRICKS.get());
		BBF = new ItemStack(LsFurnitureModBlocks.FRAMED_OAK_BIG_BRICKS.get());
		BBN = new ItemStack(LsFurnitureModBlocks.OAK_BIG_BRICKS.get());
		CHC = new ItemStack(LsFurnitureModBlocks.CONNECTING_OAK_CHECKERED.get());
		CHF = new ItemStack(LsFurnitureModBlocks.FRAMED_OAK_CHECKERED.get());
		CHN = new ItemStack(LsFurnitureModBlocks.OAK_CHECKERED.get());
		CHKC = new ItemStack(LsFurnitureModBlocks.CONNECTING_OAK_CHECKED.get());
		CHKF = new ItemStack(LsFurnitureModBlocks.FRAMED_OAK_CHECKED.get());
		CHKN = new ItemStack(LsFurnitureModBlocks.OAK_CHECKED.get());
		DIC = new ItemStack(LsFurnitureModBlocks.CONNECTING_OAK_DIAGONAL.get());
		DIF = new ItemStack(LsFurnitureModBlocks.FRAMED_OAK_DIAGONAL.get());
		DIN = new ItemStack(LsFurnitureModBlocks.OAK_DIAGONAL.get());
		DUC = new ItemStack(LsFurnitureModBlocks.CONNECTING_OAK_DUNES.get());
		DUF = new ItemStack(LsFurnitureModBlocks.FRAMED_OAK_DUNES.get());
		DUN = new ItemStack(LsFurnitureModBlocks.OAK_DUNES.get());
		HSC = new ItemStack(LsFurnitureModBlocks.CONNECTING_OAK_HORIZONTAL_STRIPES.get());
		HSF = new ItemStack(LsFurnitureModBlocks.FRAMED_OAK_HORIZONTAL_STRIPES.get());
		HSN = new ItemStack(LsFurnitureModBlocks.OAK_HORIZONTAL_STRIPES.get());
		VSC = new ItemStack(LsFurnitureModBlocks.CONNECTING_OAK_VERTICAL_STRIPES.get());
		VCF = new ItemStack(LsFurnitureModBlocks.FRAMED_OAK_VERTICAL_STRIPES.get());
		VCN = new ItemStack(LsFurnitureModBlocks.OAK_VERTICAL_STRIPES.get());
		MOC = new ItemStack(LsFurnitureModBlocks.CONNECTING_OAK_MOSAIC.get());
		MOF = new ItemStack(LsFurnitureModBlocks.FRAMED_OAK_MOSAIC.get());
		MON = new ItemStack(LsFurnitureModBlocks.OAK_MOSAIC.get());
		PLC = new ItemStack(LsFurnitureModBlocks.CONNECTING_OAK_PLUS.get());
		PLF = new ItemStack(LsFurnitureModBlocks.FRAMED_OAK_PLUS.get());
		PLN = new ItemStack(LsFurnitureModBlocks.OAK_PLUS.get());
		SLC = new ItemStack(LsFurnitureModBlocks.CONNECTING_OAK_SLASH.get());
		SLF = new ItemStack(LsFurnitureModBlocks.FRAMED_OAK_SLASH.get());
		SLN = new ItemStack(LsFurnitureModBlocks.OAK_SLASH.get());
		SWC = new ItemStack(LsFurnitureModBlocks.CONNECTING_OAK_SWIRL.get());
		SWF = new ItemStack(LsFurnitureModBlocks.FRAMED_OAK_SWIRL.get());
		SWN = new ItemStack(LsFurnitureModBlocks.OAK_SWIRL.get());
		WAC = new ItemStack(LsFurnitureModBlocks.CONNECTING_OAK_WAVEY.get());
		WAF = new ItemStack(LsFurnitureModBlocks.FRAMED_OAK_WAVEY.get());
		WAN = new ItemStack(LsFurnitureModBlocks.OAK_WAVEY.get());
		if (itemstack.getItem() == SBC.getItem() || itemstack.getItem() == SBF.getItem() || itemstack.getItem() == SBN.getItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Type:"));
				tooltip.add(Component.literal((Wood + " " + "Small Bricks")));
				tooltip.add(Component.literal("Click On A Block To Stop The Connected Textures"));
			} else {
				tooltip.add(Component.literal("Press \u00A7eShift \u00A7rFor More Information"));
			}
		}
		if (itemstack.getItem() == BBC.getItem() || itemstack.getItem() == BBF.getItem() || itemstack.getItem() == BBN.getItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Type:"));
				tooltip.add(Component.literal((Wood + " " + "Big Bricks")));
				tooltip.add(Component.literal("Click On A Block To Stop The Connected Textures"));
			} else {
				tooltip.add(Component.literal("Press \u00A7eShift \u00A7rFor More Information"));
			}
		}
		if (itemstack.getItem() == CHC.getItem() || itemstack.getItem() == CHF.getItem() || itemstack.getItem() == CHN.getItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Type:"));
				tooltip.add(Component.literal((Wood + " " + "Checkered")));
				tooltip.add(Component.literal("Click On A Block To Stop The Connected Textures"));
			} else {
				tooltip.add(Component.literal("Press \u00A7eShift \u00A7rFor More Information"));
			}
		}
		if (itemstack.getItem() == CHKC.getItem() || itemstack.getItem() == CHKF.getItem() || itemstack.getItem() == CHKN.getItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Type:"));
				tooltip.add(Component.literal((Wood + " " + "Checked")));
				tooltip.add(Component.literal("Click On A Block To Stop The Connected Textures"));
			} else {
				tooltip.add(Component.literal("Press \u00A7eShift \u00A7rFor More Information"));
			}
		}
		if (itemstack.getItem() == DIC.getItem() || itemstack.getItem() == DIF.getItem() || itemstack.getItem() == DIN.getItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Type:"));
				tooltip.add(Component.literal((Wood + " " + "Diagonal")));
				tooltip.add(Component.literal("Click On A Block To Stop The Connected Textures"));
			} else {
				tooltip.add(Component.literal("Press \u00A7eShift \u00A7rFor More Information"));
			}
		}
		if (itemstack.getItem() == DUC.getItem() || itemstack.getItem() == DUF.getItem() || itemstack.getItem() == DUN.getItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Type:"));
				tooltip.add(Component.literal((Wood + " " + "Dunes")));
				tooltip.add(Component.literal("Click On A Block To Stop The Connected Textures"));
			} else {
				tooltip.add(Component.literal("Press \u00A7eShift \u00A7rFor More Information"));
			}
		}
		if (itemstack.getItem() == HSC.getItem() || itemstack.getItem() == HSF.getItem() || itemstack.getItem() == HSN.getItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Type:"));
				tooltip.add(Component.literal((Wood + " " + "Horizontal Stripes")));
				tooltip.add(Component.literal("Click On A Block To Stop The Connected Textures"));
			} else {
				tooltip.add(Component.literal("Press \u00A7eShift \u00A7rFor More Information"));
			}
		}
		if (itemstack.getItem() == VSC.getItem() || itemstack.getItem() == VCF.getItem() || itemstack.getItem() == VCN.getItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Type:"));
				tooltip.add(Component.literal((Wood + " " + "Vertical Stripes")));
				tooltip.add(Component.literal("Click On A Block To Stop The Connected Textures"));
			} else {
				tooltip.add(Component.literal("Press \u00A7eShift \u00A7rFor More Information"));
			}
		}
		if (itemstack.getItem() == MOC.getItem() || itemstack.getItem() == MOF.getItem() || itemstack.getItem() == MON.getItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Type:"));
				tooltip.add(Component.literal((Wood + " " + "Mosaic")));
				tooltip.add(Component.literal("Click On A Block To Stop The Connected Textures"));
			} else {
				tooltip.add(Component.literal("Press \u00A7eShift \u00A7rFor More Information"));
			}
		}
		if (itemstack.getItem() == PLC.getItem() || itemstack.getItem() == PLF.getItem() || itemstack.getItem() == PLN.getItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Type:"));
				tooltip.add(Component.literal((Wood + " " + "Plus")));
				tooltip.add(Component.literal("Click On A Block To Stop The Connected Textures"));
			} else {
				tooltip.add(Component.literal("Press \u00A7eShift \u00A7rFor More Information"));
			}
		}
		if (itemstack.getItem() == SLC.getItem() || itemstack.getItem() == SLF.getItem() || itemstack.getItem() == SLN.getItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Type:"));
				tooltip.add(Component.literal((Wood + " " + "Slash")));
				tooltip.add(Component.literal("Click On A Block To Stop The Connected Textures"));
			} else {
				tooltip.add(Component.literal("Press \u00A7eShift \u00A7rFor More Information"));
			}
		}
		if (itemstack.getItem() == SWC.getItem() || itemstack.getItem() == SWF.getItem() || itemstack.getItem() == SWN.getItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Type:"));
				tooltip.add(Component.literal((Wood + " " + "Swirl")));
				tooltip.add(Component.literal("Click On A Block To Stop The Connected Textures"));
			} else {
				tooltip.add(Component.literal("Press \u00A7eShift \u00A7rFor More Information"));
			}
		}
		if (itemstack.getItem() == WAC.getItem() || itemstack.getItem() == WAF.getItem() || itemstack.getItem() == WAN.getItem()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Type:"));
				tooltip.add(Component.literal((Wood + " " + "Wavey")));
				tooltip.add(Component.literal("Click On A Block To Stop The Connected Textures"));
			} else {
				tooltip.add(Component.literal("Press \u00A7eShift \u00A7rFor More Information"));
			}
		}
	}
}

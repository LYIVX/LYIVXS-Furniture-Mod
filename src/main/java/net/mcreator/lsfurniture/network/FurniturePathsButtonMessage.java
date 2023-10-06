
package net.mcreator.lsfurniture.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.world.inventory.FurniturePathsMenu;
import net.mcreator.lsfurniture.procedures.TeddyButton1Procedure;
import net.mcreator.lsfurniture.procedures.PathButton9Procedure;
import net.mcreator.lsfurniture.procedures.PathButton8Procedure;
import net.mcreator.lsfurniture.procedures.PathButton7Procedure;
import net.mcreator.lsfurniture.procedures.PathButton6Procedure;
import net.mcreator.lsfurniture.procedures.PathButton5Procedure;
import net.mcreator.lsfurniture.procedures.PathButton4Procedure;
import net.mcreator.lsfurniture.procedures.PathButton3Procedure;
import net.mcreator.lsfurniture.procedures.PathButton2Procedure;
import net.mcreator.lsfurniture.procedures.PathButton19Procedure;
import net.mcreator.lsfurniture.procedures.PathButton18Procedure;
import net.mcreator.lsfurniture.procedures.PathButton17Procedure;
import net.mcreator.lsfurniture.procedures.PathButton16Procedure;
import net.mcreator.lsfurniture.procedures.PathButton15Procedure;
import net.mcreator.lsfurniture.procedures.PathButton14Procedure;
import net.mcreator.lsfurniture.procedures.PathButton13Procedure;
import net.mcreator.lsfurniture.procedures.PathButton12Procedure;
import net.mcreator.lsfurniture.procedures.PathButton11Procedure;
import net.mcreator.lsfurniture.procedures.PathButton10Procedure;
import net.mcreator.lsfurniture.procedures.PathButton0Procedure;
import net.mcreator.lsfurniture.procedures.OpenWoodMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenTeddysMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenStoneMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenMetalMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenExplainerMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenDecorationsMenuProcedure;
import net.mcreator.lsfurniture.LsFurnitureMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FurniturePathsButtonMessage {
	private final int buttonID, x, y, z;

	public FurniturePathsButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public FurniturePathsButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(FurniturePathsButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(FurniturePathsButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = FurniturePathsMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenStoneMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenMetalMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenWoodMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenWoodMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenStoneMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			OpenMetalMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			OpenExplainerMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			OpenTeddysMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			OpenTeddysMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			PathButton0Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			TeddyButton1Procedure.execute(x, y, z, entity);
		}
		if (buttonID == 11) {

			PathButton2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			PathButton3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 13) {

			PathButton4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 14) {

			PathButton5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 15) {

			PathButton6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 16) {

			PathButton7Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 17) {

			PathButton8Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 18) {

			PathButton9Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 19) {

			PathButton10Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 20) {

			PathButton11Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 21) {

			PathButton12Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 22) {

			PathButton12Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 23) {

			PathButton13Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 24) {

			PathButton14Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 25) {

			PathButton15Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 26) {

			PathButton16Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 27) {

			PathButton17Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 28) {

			PathButton18Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 29) {

			PathButton19Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 30) {

			OpenDecorationsMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 31) {

			OpenDecorationsMenuProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LsFurnitureMod.addNetworkMessage(FurniturePathsButtonMessage.class, FurniturePathsButtonMessage::buffer, FurniturePathsButtonMessage::new, FurniturePathsButtonMessage::handler);
	}
}

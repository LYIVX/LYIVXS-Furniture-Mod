
package net.mcreator.lsfurniture.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.world.inventory.FurnitureTeddysMenu;
import net.mcreator.lsfurniture.procedures.TeddyButton9Procedure;
import net.mcreator.lsfurniture.procedures.TeddyButton8Procedure;
import net.mcreator.lsfurniture.procedures.TeddyButton7Procedure;
import net.mcreator.lsfurniture.procedures.TeddyButton6Procedure;
import net.mcreator.lsfurniture.procedures.TeddyButton5Procedure;
import net.mcreator.lsfurniture.procedures.TeddyButton4Procedure;
import net.mcreator.lsfurniture.procedures.TeddyButton3Procedure;
import net.mcreator.lsfurniture.procedures.TeddyButton2Procedure;
import net.mcreator.lsfurniture.procedures.TeddyButton1Procedure;
import net.mcreator.lsfurniture.procedures.TeddyButton11Procedure;
import net.mcreator.lsfurniture.procedures.TeddyButton10Procedure;
import net.mcreator.lsfurniture.procedures.TeddyButton0Procedure;
import net.mcreator.lsfurniture.procedures.OpenWoodMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenMetalMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenExplainerMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenDecorationsMenuProcedure;
import net.mcreator.lsfurniture.LsFurnitureMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FurnitureTeddysButtonMessage {
	private final int buttonID, x, y, z;

	public FurnitureTeddysButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public FurnitureTeddysButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(FurnitureTeddysButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(FurnitureTeddysButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = FurnitureTeddysMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenMetalMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			TeddyButton0Procedure.execute(x, y, z, entity);
		}
		if (buttonID == 2) {

			TeddyButton1Procedure.execute(x, y, z, entity);
		}
		if (buttonID == 3) {

			TeddyButton2Procedure.execute(x, y, z, entity);
		}
		if (buttonID == 4) {

			TeddyButton3Procedure.execute(x, y, z, entity);
		}
		if (buttonID == 5) {

			TeddyButton4Procedure.execute(x, y, z, entity);
		}
		if (buttonID == 6) {

			TeddyButton5Procedure.execute(x, y, z, entity);
		}
		if (buttonID == 7) {

			TeddyButton6Procedure.execute(x, y, z, entity);
		}
		if (buttonID == 8) {

			TeddyButton7Procedure.execute(x, y, z, entity);
		}
		if (buttonID == 9) {

			TeddyButton8Procedure.execute(x, y, z, entity);
		}
		if (buttonID == 10) {

			TeddyButton9Procedure.execute(x, y, z, entity);
		}
		if (buttonID == 11) {

			TeddyButton10Procedure.execute(x, y, z, entity);
		}
		if (buttonID == 12) {

			OpenWoodMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 13) {

			OpenWoodMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 14) {

			OpenMetalMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 15) {

			OpenExplainerMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 16) {

			TeddyButton11Procedure.execute(x, y, z, entity);
		}
		if (buttonID == 17) {

			OpenDecorationsMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 18) {

			OpenDecorationsMenuProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LsFurnitureMod.addNetworkMessage(FurnitureTeddysButtonMessage.class, FurnitureTeddysButtonMessage::buffer, FurnitureTeddysButtonMessage::new, FurnitureTeddysButtonMessage::handler);
	}
}

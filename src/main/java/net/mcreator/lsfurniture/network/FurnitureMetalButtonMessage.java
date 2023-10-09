
package net.mcreator.lsfurniture.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.world.inventory.FurnitureMetalMenu;
import net.mcreator.lsfurniture.procedures.OpenWoodMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenTeddysMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenExplainerMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenDecorationsMenuProcedure;
import net.mcreator.lsfurniture.procedures.MetalButton9Procedure;
import net.mcreator.lsfurniture.procedures.MetalButton8Procedure;
import net.mcreator.lsfurniture.procedures.MetalButton7Procedure;
import net.mcreator.lsfurniture.procedures.MetalButton6Procedure;
import net.mcreator.lsfurniture.procedures.MetalButton5Procedure;
import net.mcreator.lsfurniture.procedures.MetalButton4Procedure;
import net.mcreator.lsfurniture.procedures.MetalButton3Procedure;
import net.mcreator.lsfurniture.procedures.MetalButton2Procedure;
import net.mcreator.lsfurniture.procedures.MetalButton1Procedure;
import net.mcreator.lsfurniture.procedures.MetalButton0Procedure;
import net.mcreator.lsfurniture.LsFurnitureMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FurnitureMetalButtonMessage {
	private final int buttonID, x, y, z;

	public FurnitureMetalButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public FurnitureMetalButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(FurnitureMetalButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(FurnitureMetalButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = FurnitureMetalMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenTeddysMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			MetalButton0Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			MetalButton1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			MetalButton2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			MetalButton3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			MetalButton4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			MetalButton5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			MetalButton6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			OpenWoodMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			OpenWoodMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			OpenTeddysMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			OpenExplainerMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			MetalButton7Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 13) {

			MetalButton8Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 14) {

			MetalButton9Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 15) {

			OpenDecorationsMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 16) {

			OpenDecorationsMenuProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LsFurnitureMod.addNetworkMessage(FurnitureMetalButtonMessage.class, FurnitureMetalButtonMessage::buffer, FurnitureMetalButtonMessage::new, FurnitureMetalButtonMessage::handler);
	}
}

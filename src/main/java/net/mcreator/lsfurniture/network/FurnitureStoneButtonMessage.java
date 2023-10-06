
package net.mcreator.lsfurniture.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.world.inventory.FurnitureStoneMenu;
import net.mcreator.lsfurniture.procedures.RequestFeaturesProcedure;
import net.mcreator.lsfurniture.procedures.OpenWoodMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenTeddysMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenPathsMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenMetalMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenExplainerMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenDecorationsMenuProcedure;
import net.mcreator.lsfurniture.LsFurnitureMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FurnitureStoneButtonMessage {
	private final int buttonID, x, y, z;

	public FurnitureStoneButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public FurnitureStoneButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(FurnitureStoneButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(FurnitureStoneButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = FurnitureStoneMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			RequestFeaturesProcedure.execute(entity);
		}
		if (buttonID == 1) {

			OpenMetalMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenTeddysMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenWoodMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenWoodMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			OpenMetalMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			OpenTeddysMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			OpenExplainerMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			OpenPathsMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			OpenPathsMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			OpenDecorationsMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			OpenDecorationsMenuProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LsFurnitureMod.addNetworkMessage(FurnitureStoneButtonMessage.class, FurnitureStoneButtonMessage::buffer, FurnitureStoneButtonMessage::new, FurnitureStoneButtonMessage::handler);
	}
}

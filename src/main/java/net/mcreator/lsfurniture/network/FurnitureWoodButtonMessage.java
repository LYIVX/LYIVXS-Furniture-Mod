
package net.mcreator.lsfurniture.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.world.inventory.FurnitureWoodMenu;
import net.mcreator.lsfurniture.procedures.WoodButton9Procedure;
import net.mcreator.lsfurniture.procedures.WoodButton8Procedure;
import net.mcreator.lsfurniture.procedures.WoodButton7Procedure;
import net.mcreator.lsfurniture.procedures.WoodButton6Procedure;
import net.mcreator.lsfurniture.procedures.WoodButton5Procedure;
import net.mcreator.lsfurniture.procedures.WoodButton4Procedure;
import net.mcreator.lsfurniture.procedures.WoodButton3Procedure;
import net.mcreator.lsfurniture.procedures.WoodButton2Procedure;
import net.mcreator.lsfurniture.procedures.WoodButton1Procedure;
import net.mcreator.lsfurniture.procedures.WoodButton12Procedure;
import net.mcreator.lsfurniture.procedures.WoodButton11Procedure;
import net.mcreator.lsfurniture.procedures.WoodButton10Procedure;
import net.mcreator.lsfurniture.procedures.WoodButton0Procedure;
import net.mcreator.lsfurniture.procedures.OpenTeddysMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenStoneMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenPathsMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenMetalMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenExplainerMenuProcedure;
import net.mcreator.lsfurniture.procedures.OpenDecorationsMenuProcedure;
import net.mcreator.lsfurniture.LsFurnitureMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FurnitureWoodButtonMessage {
	private final int buttonID, x, y, z;

	public FurnitureWoodButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public FurnitureWoodButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(FurnitureWoodButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(FurnitureWoodButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = FurnitureWoodMenu.guistate;
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

			OpenTeddysMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			WoodButton0Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			WoodButton1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			WoodButton2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			WoodButton3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			WoodButton4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			WoodButton5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			WoodButton6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			WoodButton7Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			WoodButton8Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			WoodButton9Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 13) {

			WoodButton10Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 14) {

			WoodButton11Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 15) {

			WoodButton12Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 16) {

			OpenStoneMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 17) {

			OpenMetalMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 18) {

			OpenTeddysMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 19) {

			OpenExplainerMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 20) {

			OpenPathsMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 21) {

			OpenPathsMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 22) {

			OpenDecorationsMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 23) {

			OpenDecorationsMenuProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LsFurnitureMod.addNetworkMessage(FurnitureWoodButtonMessage.class, FurnitureWoodButtonMessage::buffer, FurnitureWoodButtonMessage::new, FurnitureWoodButtonMessage::handler);
	}
}

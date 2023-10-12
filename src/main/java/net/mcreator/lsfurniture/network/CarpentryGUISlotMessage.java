
package net.mcreator.lsfurniture.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.world.inventory.CarpentryGUIMenu;
import net.mcreator.lsfurniture.procedures.FurnitureCrafterBetaPro2Procedure;
import net.mcreator.lsfurniture.LsFurnitureMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CarpentryGUISlotMessage {
	private final int slotID, x, y, z, changeType, meta;

	public CarpentryGUISlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
		this.slotID = slotID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.changeType = changeType;
		this.meta = meta;
	}

	public CarpentryGUISlotMessage(FriendlyByteBuf buffer) {
		this.slotID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.changeType = buffer.readInt();
		this.meta = buffer.readInt();
	}

	public static void buffer(CarpentryGUISlotMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}

	public static void handler(CarpentryGUISlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int slotID = message.slotID;
			int changeType = message.changeType;
			int meta = message.meta;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleSlotAction(entity, slotID, changeType, meta, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = CarpentryGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 5 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 6 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 7 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 8 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 9 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 10 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 11 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 12 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 13 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 14 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 15 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 16 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 17 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 18 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 19 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 20 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 21 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 22 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 23 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 24 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 25 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 26 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 27 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 28 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 29 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 30 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 31 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
		if (slot == 32 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LsFurnitureMod.addNetworkMessage(CarpentryGUISlotMessage.class, CarpentryGUISlotMessage::buffer, CarpentryGUISlotMessage::new, CarpentryGUISlotMessage::handler);
	}
}

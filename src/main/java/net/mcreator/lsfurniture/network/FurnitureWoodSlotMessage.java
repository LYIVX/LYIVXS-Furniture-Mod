
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
import net.mcreator.lsfurniture.procedures.FurnitureCrafterBetaPro4Procedure;
import net.mcreator.lsfurniture.procedures.FurnitureCrafterBetaPro2Procedure;
import net.mcreator.lsfurniture.LsFurnitureMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FurnitureWoodSlotMessage {
	private final int slotID, x, y, z, changeType, meta;

	public FurnitureWoodSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
		this.slotID = slotID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.changeType = changeType;
		this.meta = meta;
	}

	public FurnitureWoodSlotMessage(FriendlyByteBuf buffer) {
		this.slotID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.changeType = buffer.readInt();
		this.meta = buffer.readInt();
	}

	public static void buffer(FurnitureWoodSlotMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}

	public static void handler(FurnitureWoodSlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = FurnitureWoodMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 0 && changeType == 1) {

			FurnitureCrafterBetaPro4Procedure.execute(entity);
		}
		if (slot == 1 && changeType == 1) {

			FurnitureCrafterBetaPro4Procedure.execute(entity);
		}
		if (slot == 2 && changeType == 1) {

			FurnitureCrafterBetaPro4Procedure.execute(entity);
		}
		if (slot == 3 && changeType == 1) {

			FurnitureCrafterBetaPro4Procedure.execute(entity);
		}
		if (slot == 4 && changeType == 1) {

			FurnitureCrafterBetaPro4Procedure.execute(entity);
		}
		if (slot == 46 && changeType == 1) {

			FurnitureCrafterBetaPro2Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LsFurnitureMod.addNetworkMessage(FurnitureWoodSlotMessage.class, FurnitureWoodSlotMessage::buffer, FurnitureWoodSlotMessage::new, FurnitureWoodSlotMessage::handler);
	}
}

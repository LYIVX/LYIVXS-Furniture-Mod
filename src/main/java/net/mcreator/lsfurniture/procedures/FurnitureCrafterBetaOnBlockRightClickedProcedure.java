package net.mcreator.lsfurniture.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.lsfurniture.world.inventory.WeaveryGUIMenu;
import net.mcreator.lsfurniture.world.inventory.MetalurgyGUIMenu;
import net.mcreator.lsfurniture.world.inventory.MasonryGUIMenu;
import net.mcreator.lsfurniture.world.inventory.GlassblowerGUIMenu;
import net.mcreator.lsfurniture.world.inventory.EngineeringGUIMenu;
import net.mcreator.lsfurniture.world.inventory.CarpentryGUIMenu;
import net.mcreator.lsfurniture.world.inventory.BotanistGUIMenu;
import net.mcreator.lsfurniture.network.LsFurnitureModVariables;

import io.netty.buffer.Unpooled;

public class FurnitureCrafterBetaOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(LsFurnitureModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LsFurnitureModVariables.PlayerVariables())).Furniture_Crafter_Menu).equals("Carpentry")) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("CarpentryGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new CarpentryGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else if (((entity.getCapability(LsFurnitureModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LsFurnitureModVariables.PlayerVariables())).Furniture_Crafter_Menu).equals("Masonry")) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("MasonryGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new MasonryGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else if (((entity.getCapability(LsFurnitureModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LsFurnitureModVariables.PlayerVariables())).Furniture_Crafter_Menu).equals("Metallurgy")) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("MetalurgyGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new MetalurgyGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else if (((entity.getCapability(LsFurnitureModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LsFurnitureModVariables.PlayerVariables())).Furniture_Crafter_Menu).equals("Weavery")) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("WeaveryGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new WeaveryGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else if (((entity.getCapability(LsFurnitureModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LsFurnitureModVariables.PlayerVariables())).Furniture_Crafter_Menu).equals("Engineering")) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("EngineeringGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new EngineeringGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else if (((entity.getCapability(LsFurnitureModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LsFurnitureModVariables.PlayerVariables())).Furniture_Crafter_Menu).equals("Glass_Blower")) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("GlassblowerGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new GlassblowerGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else if (((entity.getCapability(LsFurnitureModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LsFurnitureModVariables.PlayerVariables())).Furniture_Crafter_Menu).equals("Botanist")) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("BotanistGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new BotanistGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}
}

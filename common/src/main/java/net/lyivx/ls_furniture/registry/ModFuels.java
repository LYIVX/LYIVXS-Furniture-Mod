package net.lyivx.ls_furniture.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import dev.architectury.registry.fuel.FuelRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModFuels {

    public static void init() {
        for (RegistryEntry<Item> entry : ModItems.INGREDIENTS_BURNABLE_200.getEntries()) {
            FuelRegistry.register(200, entry.get());
        }
        for (RegistryEntry<Item> entry : ModItems.INGREDIENTS_BURNABLE_100.getEntries()) {
            FuelRegistry.register(100, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.SOFAS.getEntries()) {
            FuelRegistry.register(400, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.CHAIRS.getEntries()) {
            FuelRegistry.register(400, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.BEDS.getEntries()) {
            FuelRegistry.register(800, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.STOOLS.getEntries()) {
            FuelRegistry.register(400, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.TABLES.getEntries()) {
            FuelRegistry.register(400, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.COUNTERS.getEntries()) {
            FuelRegistry.register(400, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.CABINETS.getEntries()) {
            FuelRegistry.register(400, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.DRAWERS.getEntries()) {
            FuelRegistry.register(400, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.SHELVES.getEntries()) {
            FuelRegistry.register(400, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.MAILBOX.getEntries()) {
            FuelRegistry.register(400, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.WARDROBE.getEntries()) {
            FuelRegistry.register(800, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.BLINDS.getEntries()) {
            FuelRegistry.register(400, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.STAIRS.getEntries()) {
            FuelRegistry.register(400, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.PLATFORMS.getEntries()) {
            FuelRegistry.register(400, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.RAILINGS.getEntries()) {
            FuelRegistry.register(200, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.UPGRADED_FENCES.getEntries()) {
            FuelRegistry.register(200, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.UPGRADED_FENCE_GATES.getEntries()) {
            FuelRegistry.register(200, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.LOG_FENCES.getEntries()) {
            FuelRegistry.register(200, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.LOG_FENCE_GATES.getEntries()) {
            FuelRegistry.register(200, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.STRIPPED_LOG_FENCES.getEntries()) {
            FuelRegistry.register(200, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.STRIPPED_LOG_FENCE_GATES.getEntries()) {
            FuelRegistry.register(200, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.HOLLOW_LOGS.getEntries()) {
            FuelRegistry.register(300, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.DOORS.getEntries()) {
            FuelRegistry.register(200, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.ROOFS.getEntries()) {
            FuelRegistry.register(200, entry.get());
        }
        for (RegistryEntry<Block> entry : ModBlocks.TOMBSTONES.getEntries()) {
            FuelRegistry.register(200, entry.get());
        }
    }
}

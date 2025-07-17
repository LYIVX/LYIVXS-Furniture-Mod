package net.lyivx.ls_furniture.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.blocks.*;
import net.lyivx.ls_furniture.common.blocks.BushBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

public class ModBlocks {

    public static final ResourcefulRegistry<Block> BLOCKS = ResourcefulRegistries.create
            (BuiltInRegistries.BLOCK, LYIVXsFurnitureMod.MOD_ID);

    public static final ResourcefulRegistry<Block> CHAIRS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> STOOLS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> SOFAS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> SHELVES = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> COUNTERS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> CABINETS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> DRAWERS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> TABLES = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> BLINDS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> MAILBOX = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> WARDROBE = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> LAMPS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> BUSHES = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> UPGRADED_FENCES = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> UPGRADED_FENCE_GATES = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> CHAIN_LINK_FENCES = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> CHAIN_LINK_FENCE_GATES = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> LOG_FENCES = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> LOG_FENCE_GATES = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> STRIPPED_LOG_FENCES = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> STRIPPED_LOG_FENCE_GATES = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> RUGS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> CHESTS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> STAIRS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> PLATFORMS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> BEDS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> HOLLOW_LOGS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> BARRELS = ResourcefulRegistries.create
            (BLOCKS);
    
    public static final ResourcefulRegistry<Block> DOORS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> CRATES = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> ROOFS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> RAILINGS = ResourcefulRegistries.create
            (BLOCKS);

    public static final ResourcefulRegistry<Block> TOMBSTONES = ResourcefulRegistries.create
            (BLOCKS);

    /**///////////////////////////////////// INTERACTIVE //////////////////////////////////////

    public static final RegistryEntry<WorkstationBlock> WORKSTATION = BLOCKS.register("workstation",
            () -> new WorkstationBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(LYIVXsFurnitureMod.MOD_ID, "workstation")))));

    public static final RegistryEntry<ChoppingBoardBlock> CHOPPING_BOARD = BLOCKS.register("chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("chopping_board")))));

    public static final RegistryEntry<CuttingBoardBlock> CUTTING_BOARD = BLOCKS.register("cutting_board",
            () -> new CuttingBoardBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cutting_board")))));

    public static final RegistryEntry<ToasterBlock> TOASTER = BLOCKS.register("toaster",
            () -> new ToasterBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("toaster")))));

    public static final RegistryEntry<KettleBlock> KETTLE = BLOCKS.register("kettle",
            () -> new KettleBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("kettle")))));

    public static final RegistryEntry<MicrowaveBlock> MICROWAVE = BLOCKS.register("microwave",
            () -> new MicrowaveBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("microwave")))));

    public static final RegistryEntry<FridgeFreezerBlock> FRIDGE_FREEZER = BLOCKS.register("fridge_freezer",
            () -> new FridgeFreezerBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("fridge_freezer")))));

    public static final RegistryEntry<DrainerBlock> DRAINER = BLOCKS.register("drainer",
            () -> new DrainerBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("drainer")))));

    public static final RegistryEntry<OvenVentBlock> OVEN_VENT = BLOCKS.register("oven_vent",
            () -> new OvenVentBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oven_vent")))));

    public static final RegistryEntry<OvenVentShaftBlock> OVEN_VENT_SHAFT = BLOCKS.register("oven_vent_shaft",
            () -> new OvenVentShaftBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oven_vent_shaft")))));

    public static final RegistryEntry<FirePlaceBlock> FIRE_PLACE = BLOCKS.register("fire_place",
            () -> new FirePlaceBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("fire_place")))));

    public static final RegistryEntry<FirePlaceChimneyShaftBlock> FIRE_PLACE_CHIMNEY_SHAFT = BLOCKS.register("fire_place_chimney_shaft",
            () -> new FirePlaceChimneyShaftBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("fire_place_chimney_shaft")))));

    public static final RegistryEntry<TVBlock> TV = BLOCKS.register("tv",
            () -> new TVBlock(1, BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("tv")))));

    public static final RegistryEntry<ComputerBlock> COMPUTER = BLOCKS.register("computer",
            () -> new ComputerBlock(1, BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("computer")))));

    ////////////////////////////////////// CHESTS //////////////////////////////////////

    public static final Supplier<ModChestBlock> OAK_CHEST = CHESTS.register("oak_chest",
            () -> new ModChestBlock(MapColor.WOOD, "oak", BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_chest")))));

    public static final Supplier<ModChestBlock> SPRUCE_CHEST = CHESTS.register("spruce_chest",
            () -> new ModChestBlock(MapColor.WOOD, "spruce", BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_chest")))));

    public static final Supplier<ModChestBlock> BIRCH_CHEST = CHESTS.register("birch_chest",
            () -> new ModChestBlock(MapColor.WOOD, "birch", BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_chest")))));

    public static final Supplier<ModChestBlock> JUNGLE_CHEST = CHESTS.register("jungle_chest",
            () -> new ModChestBlock(MapColor.WOOD, "jungle", BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_chest")))));

    public static final Supplier<ModChestBlock> ACACIA_CHEST = CHESTS.register("acacia_chest",
            () -> new ModChestBlock(MapColor.WOOD, "acacia", BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_chest")))));

    public static final Supplier<ModChestBlock> DARK_OAK_CHEST = CHESTS.register("dark_oak_chest",
            () -> new ModChestBlock(MapColor.WOOD, "dark_oak", BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_chest")))));

    public static final Supplier<ModChestBlock> MANGROVE_CHEST = CHESTS.register("mangrove_chest",
            () -> new ModChestBlock(MapColor.WOOD, "mangrove", BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_chest")))));

    public static final Supplier<ModChestBlock> CHERRY_CHEST = CHESTS.register("cherry_chest",
            () -> new ModChestBlock(MapColor.WOOD, "cherry", BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_chest")))));

    public static final Supplier<ModChestBlock> BAMBOO_CHEST = CHESTS.register("bamboo_chest",
            () -> new ModChestBlock(MapColor.WOOD, "bamboo", BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_chest")))));

    public static final Supplier<ModChestBlock> CRIMSON_CHEST = CHESTS.register("crimson_chest",
            () -> new ModChestBlock(MapColor.WOOD, "crimson", BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_chest")))));

    public static final Supplier<ModChestBlock> WARPED_CHEST = CHESTS.register("warped_chest",
            () -> new ModChestBlock(MapColor.WOOD, "warped", BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_chest")))));
    
    ////////////////////////////////////// BARRELS //////////////////////////////////////

    public static final Supplier<BarrelModBlock> OAK_BARREL = BARRELS.register("oak_barrel",
            () -> new BarrelModBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_barrel")))));

    public static final Supplier<BarrelModBlock> SPRUCE_BARREL = BARRELS.register("spruce_barrel",
            () -> new BarrelModBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_barrel")))));

    public static final Supplier<BarrelModBlock> BIRCH_BARREL = BARRELS.register("birch_barrel",
            () -> new BarrelModBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_barrel")))));

    public static final Supplier<BarrelModBlock> JUNGLE_BARREL = BARRELS.register("jungle_barrel",
            () -> new BarrelModBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_barrel")))));

    public static final Supplier<BarrelModBlock> ACACIA_BARREL = BARRELS.register("acacia_barrel",
            () -> new BarrelModBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_barrel")))));

    public static final Supplier<BarrelModBlock> DARK_OAK_BARREL = BARRELS.register("dark_oak_barrel",
            () -> new BarrelModBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_barrel")))));

    public static final Supplier<BarrelModBlock> MANGROVE_BARREL = BARRELS.register("mangrove_barrel",
            () -> new BarrelModBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_barrel")))));

    public static final Supplier<BarrelModBlock> CHERRY_BARREL = BARRELS.register("cherry_barrel",
            () -> new BarrelModBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_barrel")))));

    public static final Supplier<BarrelModBlock> BAMBOO_BARREL = BARRELS.register("bamboo_barrel",
            () -> new BarrelModBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_barrel")))));

    public static final Supplier<BarrelModBlock> CRIMSON_BARREL = BARRELS.register("crimson_barrel",
            () -> new BarrelModBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_barrel")))));

    public static final Supplier<BarrelModBlock> WARPED_BARREL = BARRELS.register("warped_barrel",
            () -> new BarrelModBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_barrel")))));

    ////////////////////////////////////// CRATES //////////////////////////////////////    

    public static final Supplier<CrateBlock> OAK_CRATE = CRATES.register("oak_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_crate")))));

    public static final Supplier<CrateBlock> SPRUCE_CRATE = CRATES.register("spruce_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_crate")))));

    public static final Supplier<CrateBlock> BIRCH_CRATE = CRATES.register("birch_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_crate")))));

    public static final Supplier<CrateBlock> JUNGLE_CRATE = CRATES.register("jungle_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_crate")))));

    public static final Supplier<CrateBlock> ACACIA_CRATE = CRATES.register("acacia_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_crate")))));

    public static final Supplier<CrateBlock> DARK_OAK_CRATE = CRATES.register("dark_oak_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_crate")))));

    public static final Supplier<CrateBlock> MANGROVE_CRATE = CRATES.register("mangrove_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_crate")))));

    public static final Supplier<CrateBlock> CHERRY_CRATE = CRATES.register("cherry_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_crate")))));

    public static final Supplier<CrateBlock> BAMBOO_CRATE = CRATES.register("bamboo_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_crate")))));

    public static final Supplier<CrateBlock> CRIMSON_CRATE = CRATES.register("crimson_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_crate")))));

    public static final Supplier<CrateBlock> WARPED_CRATE = CRATES.register("warped_crate",
            () -> new CrateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_crate")))));

    ////////////////////////////////////// FRAMES //////////////////////////////////////

    public static final Supplier<PlateBlock> PLATE = BLOCKS.register("plate",
            () -> new PlateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("plate")))));

    ////////////////////////////////////// STANDARD //////////////////////////////////////


    ////////////////////////////////////// SOFAS //////////////////////////////////////

    public static final Supplier<SofaBlock> OAK_SOFA = SOFAS.register("oak_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_sofa")))));

    public static final Supplier<SofaBlock> SPRUCE_SOFA = SOFAS.register("spruce_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_sofa")))));

    public static final Supplier<SofaBlock> BIRCH_SOFA = SOFAS.register("birch_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_sofa")))));

    public static final Supplier<SofaBlock> JUNGLE_SOFA = SOFAS.register("jungle_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_sofa")))));

    public static final Supplier<SofaBlock> ACACIA_SOFA = SOFAS.register("acacia_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_sofa")))));

    public static final Supplier<SofaBlock> DARK_OAK_SOFA = SOFAS.register("dark_oak_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_sofa")))));

    public static final Supplier<SofaBlock> MANGROVE_SOFA = SOFAS.register("mangrove_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_sofa")))));

    public static final Supplier<SofaBlock> CHERRY_SOFA = SOFAS.register("cherry_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_sofa")))));

    public static final Supplier<SofaBlock> BAMBOO_SOFA = SOFAS.register("bamboo_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_sofa")))));

    public static final Supplier<SofaBlock> CRIMSON_SOFA = SOFAS.register("crimson_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_sofa")))));

    public static final Supplier<SofaBlock> WARPED_SOFA = SOFAS.register("warped_sofa",
            () -> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_sofa")))));

    ////////////////////////////////////// BEDS ////////////////////////////////////

    public static final Supplier<ModBedBlock> OAK_BED = BEDS.register("oak_bed",
            () -> new ModBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_bed")))));

    public static final Supplier<ModBedBlock> SPRUCE_BED = BEDS.register("spruce_bed",
            () -> new ModBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_bed")))));

    public static final Supplier<ModBedBlock> BIRCH_BED = BEDS.register("birch_bed",
            () -> new ModBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_bed")))));

    public static final Supplier<ModBedBlock> JUNGLE_BED = BEDS.register("jungle_bed",
            () -> new ModBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_bed")))));

    public static final Supplier<ModBedBlock> ACACIA_BED = BEDS.register("acacia_bed",
            () -> new ModBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_bed")))));

    public static final Supplier<ModBedBlock> DARK_OAK_BED = BEDS.register("dark_oak_bed",
            () -> new ModBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_bed")))));

    public static final Supplier<ModBedBlock> MANGROVE_BED = BEDS.register("mangrove_bed",
            () -> new ModBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_bed")))));

    public static final Supplier<ModBedBlock> CHERRY_BED = BEDS.register("cherry_bed",
            () -> new ModBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_bed")))));

    public static final Supplier<ModBedBlock> BAMBOO_BED = BEDS.register("bamboo_bed",
            () -> new ModBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_bed")))));

    public static final Supplier<ModBedBlock> CRIMSON_BED = BEDS.register("crimson_bed",
            () -> new ModBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_bed")))));

    public static final Supplier<ModBedBlock> WARPED_BED = BEDS.register("warped_bed",
            () -> new ModBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_bed")))));

    ////////////////////////////////////// CHAIRS //////////////////////////////////////

    public static final Supplier<ChairBlock> OAK_CHAIR = CHAIRS.register("oak_chair",
            () -> new ChairBlock(1, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_chair")))));

    public static final Supplier<ChairBlock> SPRUCE_CHAIR = CHAIRS.register("spruce_chair",
            () -> new ChairBlock(1, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_chair")))));

    public static final Supplier<ChairBlock> BIRCH_CHAIR = CHAIRS.register("birch_chair",
            () -> new ChairBlock(1, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_chair")))));

    public static final Supplier<ChairBlock> JUNGLE_CHAIR = CHAIRS.register("jungle_chair",
            () -> new ChairBlock(1, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_chair")))));

    public static final Supplier<ChairBlock> ACACIA_CHAIR = CHAIRS.register("acacia_chair",
            () -> new ChairBlock(1, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_chair")))));

    public static final Supplier<ChairBlock> DARK_OAK_CHAIR = CHAIRS.register("dark_oak_chair",
            () -> new ChairBlock(1, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_chair")))));

    public static final Supplier<ChairBlock> MANGROVE_CHAIR = CHAIRS.register("mangrove_chair",
            () -> new ChairBlock(1, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_chair")))));

    public static final Supplier<ChairBlock> CHERRY_CHAIR = CHAIRS.register("cherry_chair",
            () -> new ChairBlock(1, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_chair")))));

    public static final Supplier<ChairBlock> BAMBOO_CHAIR = CHAIRS.register("bamboo_chair",
            () -> new ChairBlock(1, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_chair")))));

    public static final Supplier<ChairBlock> CRIMSON_CHAIR = CHAIRS.register("crimson_chair",
            () -> new ChairBlock(1, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_chair")))));

    public static final Supplier<ChairBlock> WARPED_CHAIR = CHAIRS.register("warped_chair",
            () -> new ChairBlock(1, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_chair")))));

    ////////////////////////////////////// STOOLS //////////////////////////////////////

    public static final Supplier<StoolBlock> OAK_STOOL = STOOLS.register("oak_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_stool")))));

    public static final Supplier<StoolBlock> SPRUCE_STOOL = STOOLS.register("spruce_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_stool")))));

    public static final Supplier<StoolBlock> BIRCH_STOOL = STOOLS.register("birch_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_stool")))));

    public static final Supplier<StoolBlock> JUNGLE_STOOL = STOOLS.register("jungle_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_stool")))));

    public static final Supplier<StoolBlock> ACACIA_STOOL = STOOLS.register("acacia_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_stool")))));

    public static final Supplier<StoolBlock> DARK_OAK_STOOL = STOOLS.register("dark_oak_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_stool")))));

    public static final Supplier<StoolBlock> MANGROVE_STOOL = STOOLS.register("mangrove_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_stool")))));

    public static final Supplier<StoolBlock> CHERRY_STOOL = STOOLS.register("cherry_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_stool")))));

    public static final Supplier<StoolBlock> BAMBOO_STOOL = STOOLS.register("bamboo_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_stool")))));

    public static final Supplier<StoolBlock> CRIMSON_STOOL = STOOLS.register("crimson_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_stool")))));

    public static final Supplier<StoolBlock> WARPED_STOOL = STOOLS.register("warped_stool",
            () -> new StoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_stool")))));

    ////////////////////////////////////// TABLES //////////////////////////////////////

    public static final Supplier<TableBlock> OAK_TABLE = TABLES.register("oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_table")))));

    public static final Supplier<TableBlock> SPRUCE_TABLE = TABLES.register("spruce_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_table")))));

    public static final Supplier<TableBlock> BIRCH_TABLE = TABLES.register("birch_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_table")))));

    public static final Supplier<TableBlock> JUNGLE_TABLE = TABLES.register("jungle_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_table")))));

    public static final Supplier<TableBlock> ACACIA_TABLE = TABLES.register("acacia_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_table")))));

    public static final Supplier<TableBlock> DARK_OAK_TABLE = TABLES.register("dark_oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_table")))));

    public static final Supplier<TableBlock> MANGROVE_TABLE = TABLES.register("mangrove_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_table")))));

    public static final Supplier<TableBlock> CHERRY_TABLE = TABLES.register("cherry_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_table")))));

    public static final Supplier<TableBlock> BAMBOO_TABLE = TABLES.register("bamboo_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_table")))));

    public static final Supplier<TableBlock> CRIMSON_TABLE = TABLES.register("crimson_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_table")))));

    public static final Supplier<TableBlock> WARPED_TABLE = TABLES.register("warped_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_table")))));

    ///////////////////////// COUNTERS + OVENS + SINKS + CABINETS //////////////////////

    public static final Supplier<CounterBlock> OAK_COUNTER = COUNTERS.register("oak_counter",
            () -> new CounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_counter")))));

    public static final Supplier<CounterIslandBlock> OAK_COUNTER_ISLAND = COUNTERS.register("oak_counter_island",
            () -> new CounterIslandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_counter_island")))));

    public static final Supplier<CounterCupboardBlock> OAK_COUNTER_CUPBOARD = COUNTERS.register("oak_counter_cupboard",
            () -> new CounterCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_counter_cupboard")))));

    public static final Supplier<CounterDrawerBlock> OAK_COUNTER_DRAWER = COUNTERS.register("oak_counter_drawer",
            () -> new CounterDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_counter_drawer")))));

    public static final Supplier<CounterOvenBlock> OAK_COUNTER_OVEN = COUNTERS.register("oak_counter_oven",
            () -> new CounterOvenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_counter_oven")))));

    public static final Supplier<CounterSinkBlock> OAK_COUNTER_SINK = COUNTERS.register("oak_counter_sink",
            () -> new CounterSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_counter_sink")))));

    public static final Supplier<CabinetBlock> OAK_CABINET = CABINETS.register("oak_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_cabinet")))));

    public static final Supplier<CabinetCupboardBlock> OAK_CABINET_CUPBOARD = CABINETS.register("oak_cabinet_cupboard",
            () -> new CabinetCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_cabinet_cupboard")))));

    public static final Supplier<CabinetOvenVentBlock> OAK_CABINET_OVEN_VENT = CABINETS.register("oak_cabinet_oven_vent",
            () -> new CabinetOvenVentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_cabinet_oven_vent")))));

    public static final Supplier<CounterBlock> SPRUCE_COUNTER = COUNTERS.register("spruce_counter",
            () -> new CounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_counter")))));

    public static final Supplier<CounterIslandBlock> SPRUCE_COUNTER_ISLAND = COUNTERS.register("spruce_counter_island",
            () -> new CounterIslandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_counter_island")))));

    public static final Supplier<CounterCupboardBlock> SPRUCE_COUNTER_CUPBOARD = COUNTERS.register("spruce_counter_cupboard",
            () -> new CounterCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_counter_cupboard")))));

    public static final Supplier<CounterDrawerBlock> SPRUCE_COUNTER_DRAWER = COUNTERS.register("spruce_counter_drawer",
            () -> new CounterDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_counter_drawer")))));

    public static final Supplier<CounterOvenBlock> SPRUCE_COUNTER_OVEN = COUNTERS.register("spruce_counter_oven",
            () -> new CounterOvenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_counter_oven")))));

    public static final Supplier<CounterSinkBlock> SPRUCE_COUNTER_SINK = COUNTERS.register("spruce_counter_sink",
            () -> new CounterSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_counter_sink")))));

    public static final Supplier<CabinetBlock> SPRUCE_CABINET = CABINETS.register("spruce_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_cabinet")))));

    public static final Supplier<CabinetCupboardBlock> SPRUCE_CABINET_CUPBOARD = CABINETS.register("spruce_cabinet_cupboard",
            () -> new CabinetCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_cabinet_cupboard")))));

    public static final Supplier<CabinetOvenVentBlock> SPRUCE_CABINET_OVEN_VENT = CABINETS.register("spruce_cabinet_oven_vent",
            () -> new CabinetOvenVentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_cabinet_oven_vent")))));

    public static final Supplier<CounterBlock> BIRCH_COUNTER = COUNTERS.register("birch_counter",
            () -> new CounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_counter")))));

    public static final Supplier<CounterIslandBlock> BIRCH_COUNTER_ISLAND = COUNTERS.register("birch_counter_island",
            () -> new CounterIslandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_counter_island")))));

    public static final Supplier<CounterCupboardBlock> BIRCH_COUNTER_CUPBOARD = COUNTERS.register("birch_counter_cupboard",
            () -> new CounterCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_counter_cupboard")))));

    public static final Supplier<CounterDrawerBlock> BIRCH_COUNTER_DRAWER = COUNTERS.register("birch_counter_drawer",
            () -> new CounterDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_counter_drawer")))));

    public static final Supplier<CounterOvenBlock> BIRCH_COUNTER_OVEN = COUNTERS.register("birch_counter_oven",
            () -> new CounterOvenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_counter_oven")))));

    public static final Supplier<CounterSinkBlock> BIRCH_COUNTER_SINK = COUNTERS.register("birch_counter_sink",
            () -> new CounterSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_counter_sink")))));

    public static final Supplier<CabinetBlock> BIRCH_CABINET = CABINETS.register("birch_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_cabinet")))));

    public static final Supplier<CabinetCupboardBlock> BIRCH_CABINET_CUPBOARD = CABINETS.register("birch_cabinet_cupboard",
            () -> new CabinetCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_cabinet_cupboard")))));

    public static final Supplier<CabinetOvenVentBlock> BIRCH_CABINET_OVEN_VENT = CABINETS.register("birch_cabinet_oven_vent",
            () -> new CabinetOvenVentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_cabinet_oven_vent")))));

    public static final Supplier<CounterBlock> JUNGLE_COUNTER = COUNTERS.register("jungle_counter",
            () -> new CounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_counter")))));

    public static final Supplier<CounterIslandBlock> JUNGLE_COUNTER_ISLAND = COUNTERS.register("jungle_counter_island",
            () -> new CounterIslandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_counter_island")))));

    public static final Supplier<CounterCupboardBlock> JUNGLE_COUNTER_CUPBOARD = COUNTERS.register("jungle_counter_cupboard",
            () -> new CounterCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_counter_cupboard")))));

    public static final Supplier<CounterDrawerBlock> JUNGLE_COUNTER_DRAWER = COUNTERS.register("jungle_counter_drawer",
            () -> new CounterDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_counter_drawer")))));

    public static final Supplier<CounterOvenBlock> JUNGLE_COUNTER_OVEN = COUNTERS.register("jungle_counter_oven",
            () -> new CounterOvenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_counter_oven")))));

    public static final Supplier<CounterSinkBlock> JUNGLE_COUNTER_SINK = COUNTERS.register("jungle_counter_sink",
            () -> new CounterSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_counter_sink")))));

    public static final Supplier<CabinetBlock> JUNGLE_CABINET = CABINETS.register("jungle_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_cabinet")))));

    public static final Supplier<CabinetCupboardBlock> JUNGLE_CABINET_CUPBOARD = CABINETS.register("jungle_cabinet_cupboard",
            () -> new CabinetCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_cabinet_cupboard")))));

    public static final Supplier<CabinetOvenVentBlock> JUNGLE_CABINET_OVEN_VENT = CABINETS.register("jungle_cabinet_oven_vent",
            () -> new CabinetOvenVentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_cabinet_oven_vent")))));

    public static final Supplier<CounterBlock> ACACIA_COUNTER = COUNTERS.register("acacia_counter",
            () -> new CounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_counter")))));

    public static final Supplier<CounterIslandBlock> ACACIA_COUNTER_ISLAND = COUNTERS.register("acacia_counter_island",
            () -> new CounterIslandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_counter_island")))));

    public static final Supplier<CounterCupboardBlock> ACACIA_COUNTER_CUPBOARD = COUNTERS.register("acacia_counter_cupboard",
            () -> new CounterCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_counter_cupboard")))));

    public static final Supplier<CounterDrawerBlock> ACACIA_COUNTER_DRAWER = COUNTERS.register("acacia_counter_drawer",
            () -> new CounterDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_counter_drawer")))));

    public static final Supplier<CounterOvenBlock> ACACIA_COUNTER_OVEN = COUNTERS.register("acacia_counter_oven",
            () -> new CounterOvenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_counter_oven")))));

    public static final Supplier<CounterSinkBlock> ACACIA_COUNTER_SINK = COUNTERS.register("acacia_counter_sink",
            () -> new CounterSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_counter_sink")))));

    public static final Supplier<CabinetBlock> ACACIA_CABINET = CABINETS.register("acacia_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_cabinet")))));

    public static final Supplier<CabinetCupboardBlock> ACACIA_CABINET_CUPBOARD = CABINETS.register("acacia_cabinet_cupboard",
            () -> new CabinetCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_cabinet_cupboard")))));

    public static final Supplier<CabinetOvenVentBlock> ACACIA_CABINET_OVEN_VENT = CABINETS.register("acacia_cabinet_oven_vent",
            () -> new CabinetOvenVentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_cabinet_oven_vent")))));

    public static final Supplier<CounterBlock> DARK_OAK_COUNTER = COUNTERS.register("dark_oak_counter",
            () -> new CounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_counter")))));

    public static final Supplier<CounterIslandBlock> DARK_OAK_COUNTER_ISLAND = COUNTERS.register("dark_oak_counter_island",
            () -> new CounterIslandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_counter_island")))));

    public static final Supplier<CounterCupboardBlock> DARK_OAK_COUNTER_CUPBOARD = COUNTERS.register("dark_oak_counter_cupboard",
            () -> new CounterCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_counter_cupboard")))));

    public static final Supplier<CounterDrawerBlock> DARK_OAK_COUNTER_DRAWER = COUNTERS.register("dark_oak_counter_drawer",
            () -> new CounterDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_counter_drawer")))));

    public static final Supplier<CounterOvenBlock> DARK_OAK_COUNTER_OVEN = COUNTERS.register("dark_oak_counter_oven",
            () -> new CounterOvenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_counter_oven")))));

    public static final Supplier<CounterSinkBlock> DARK_OAK_COUNTER_SINK = COUNTERS.register("dark_oak_counter_sink",
            () -> new CounterSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_counter_sink")))));

    public static final Supplier<CabinetBlock> DARK_OAK_CABINET = CABINETS.register("dark_oak_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_cabinet")))));

    public static final Supplier<CabinetCupboardBlock> DARK_OAK_CABINET_CUPBOARD = CABINETS.register("dark_oak_cabinet_cupboard",
            () -> new CabinetCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_cabinet_cupboard")))));

    public static final Supplier<CabinetOvenVentBlock> DARK_OAK_CABINET_OVEN_VENT = CABINETS.register("dark_oak_cabinet_oven_vent",
            () -> new CabinetOvenVentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_cabinet_oven_vent")))));

    public static final Supplier<CounterBlock> MANGROVE_COUNTER = COUNTERS.register("mangrove_counter",
            () -> new CounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_counter")))));

    public static final Supplier<CounterIslandBlock> MANGROVE_COUNTER_ISLAND = COUNTERS.register("mangrove_counter_island",
            () -> new CounterIslandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_counter_island")))));

    public static final Supplier<CounterCupboardBlock> MANGROVE_COUNTER_CUPBOARD = COUNTERS.register("mangrove_counter_cupboard",
            () -> new CounterCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_counter_cupboard")))));

    public static final Supplier<CounterDrawerBlock> MANGROVE_COUNTER_DRAWER = COUNTERS.register("mangrove_counter_drawer",
            () -> new CounterDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_counter_drawer")))));

    public static final Supplier<CounterOvenBlock> MANGROVE_COUNTER_OVEN = COUNTERS.register("mangrove_counter_oven",
            () -> new CounterOvenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_counter_oven")))));

    public static final Supplier<CounterSinkBlock> MANGROVE_COUNTER_SINK = COUNTERS.register("mangrove_counter_sink",
            () -> new CounterSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_counter_sink")))));

    public static final Supplier<CabinetBlock> MANGROVE_CABINET = CABINETS.register("mangrove_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_cabinet")))));

    public static final Supplier<CabinetCupboardBlock> MANGROVE_CABINET_CUPBOARD = CABINETS.register("mangrove_cabinet_cupboard",
            () -> new CabinetCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_cabinet_cupboard")))));

    public static final Supplier<CabinetOvenVentBlock> MANGROVE_CABINET_OVEN_VENT = CABINETS.register("mangrove_cabinet_oven_vent",
            () -> new CabinetOvenVentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_cabinet_oven_vent")))));

    public static final Supplier<CounterBlock> CHERRY_COUNTER = COUNTERS.register("cherry_counter",
            () -> new CounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_counter")))));

    public static final Supplier<CounterIslandBlock> CHERRY_COUNTER_ISLAND = COUNTERS.register("cherry_counter_island",
            () -> new CounterIslandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_counter_island")))));

    public static final Supplier<CounterCupboardBlock> CHERRY_COUNTER_CUPBOARD = COUNTERS.register("cherry_counter_cupboard",
            () -> new CounterCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_counter_cupboard")))));

    public static final Supplier<CounterDrawerBlock> CHERRY_COUNTER_DRAWER = COUNTERS.register("cherry_counter_drawer",
            () -> new CounterDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_counter_drawer")))));

    public static final Supplier<CounterOvenBlock> CHERRY_COUNTER_OVEN = COUNTERS.register("cherry_counter_oven",
            () -> new CounterOvenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_counter_oven")))));

    public static final Supplier<CounterSinkBlock> CHERRY_COUNTER_SINK = COUNTERS.register("cherry_counter_sink",
            () -> new CounterSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_counter_sink")))));

    public static final Supplier<CabinetBlock> CHERRY_CABINET = CABINETS.register("cherry_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_cabinet")))));

    public static final Supplier<CabinetCupboardBlock> CHERRY_CABINET_CUPBOARD = CABINETS.register("cherry_cabinet_cupboard",
            () -> new CabinetCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_cabinet_cupboard")))));

    public static final Supplier<CabinetOvenVentBlock> CHERRY_CABINET_OVEN_VENT = CABINETS.register("cherry_cabinet_oven_vent",
            () -> new CabinetOvenVentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_cabinet_oven_vent")))));

    public static final Supplier<CounterBlock> BAMBOO_COUNTER = COUNTERS.register("bamboo_counter",
            () -> new CounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_counter")))));

    public static final Supplier<CounterIslandBlock> BAMBOO_COUNTER_ISLAND = COUNTERS.register("bamboo_counter_island",
            () -> new CounterIslandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_counter_island")))));

    public static final Supplier<CounterCupboardBlock> BAMBOO_COUNTER_CUPBOARD = COUNTERS.register("bamboo_counter_cupboard",
            () -> new CounterCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_counter_cupboard")))));

    public static final Supplier<CounterDrawerBlock> BAMBOO_COUNTER_DRAWER = COUNTERS.register("bamboo_counter_drawer",
            () -> new CounterDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_counter_drawer")))));

    public static final Supplier<CounterOvenBlock> BAMBOO_COUNTER_OVEN = COUNTERS.register("bamboo_counter_oven",
            () -> new CounterOvenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_counter_oven")))));

    public static final Supplier<CounterSinkBlock> BAMBOO_COUNTER_SINK = COUNTERS.register("bamboo_counter_sink",
            () -> new CounterSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_counter_sink")))));

    public static final Supplier<CabinetBlock> BAMBOO_CABINET = CABINETS.register("bamboo_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_cabinet")))));

    public static final Supplier<CabinetCupboardBlock> BAMBOO_CABINET_CUPBOARD = CABINETS.register("bamboo_cabinet_cupboard",
            () -> new CabinetCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_cabinet_cupboard")))));

    public static final Supplier<CabinetOvenVentBlock> BAMBOO_CABINET_OVEN_VENT = CABINETS.register("bamboo_cabinet_oven_vent",
            () -> new CabinetOvenVentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_cabinet_oven_vent")))));

    public static final Supplier<CounterBlock> CRIMSON_COUNTER = COUNTERS.register("crimson_counter",
            () -> new CounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_counter")))));

    public static final Supplier<CounterIslandBlock> CRIMSON_COUNTER_ISLAND = COUNTERS.register("crimson_counter_island",
            () -> new CounterIslandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_counter_island")))));

    public static final Supplier<CounterCupboardBlock> CRIMSON_COUNTER_CUPBOARD = COUNTERS.register("crimson_counter_cupboard",
            () -> new CounterCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_counter_cupboard")))));

    public static final Supplier<CounterDrawerBlock> CRIMSON_COUNTER_DRAWER = COUNTERS.register("crimson_counter_drawer",
            () -> new CounterDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_counter_drawer")))));

    public static final Supplier<CounterOvenBlock> CRIMSON_COUNTER_OVEN = COUNTERS.register("crimson_counter_oven",
            () -> new CounterOvenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_counter_oven")))));

    public static final Supplier<CounterSinkBlock> CRIMSON_COUNTER_SINK = COUNTERS.register("crimson_counter_sink",
            () -> new CounterSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_counter_sink")))));

    public static final Supplier<CabinetBlock> CRIMSON_CABINET = CABINETS.register("crimson_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_cabinet")))));

    public static final Supplier<CabinetCupboardBlock> CRIMSON_CABINET_CUPBOARD = CABINETS.register("crimson_cabinet_cupboard",
            () -> new CabinetCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_cabinet_cupboard")))));

    public static final Supplier<CabinetOvenVentBlock> CRIMSON_CABINET_OVEN_VENT = CABINETS.register("crimson_cabinet_oven_vent",
            () -> new CabinetOvenVentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_cabinet_oven_vent")))));

    public static final Supplier<CounterBlock> WARPED_COUNTER = COUNTERS.register("warped_counter",
            () -> new CounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_counter")))));

    public static final Supplier<CounterIslandBlock> WARPED_COUNTER_ISLAND = COUNTERS.register("warped_counter_island",
            () -> new CounterIslandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_counter_island")))));

    public static final Supplier<CounterCupboardBlock> WARPED_COUNTER_CUPBOARD = COUNTERS.register("warped_counter_cupboard",
            () -> new CounterCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_counter_cupboard")))));

    public static final Supplier<CounterDrawerBlock> WARPED_COUNTER_DRAWER = COUNTERS.register("warped_counter_drawer",
            () -> new CounterDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_counter_drawer")))));

    public static final Supplier<CounterOvenBlock> WARPED_COUNTER_OVEN = COUNTERS.register("warped_counter_oven",
            () -> new CounterOvenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_counter_oven")))));

    public static final Supplier<CounterSinkBlock> WARPED_COUNTER_SINK = COUNTERS.register("warped_counter_sink",
            () -> new CounterSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_counter_sink")))));

    public static final Supplier<CabinetBlock> WARPED_CABINET = CABINETS.register("warped_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_cabinet")))));

    public static final Supplier<CabinetCupboardBlock> WARPED_CABINET_CUPBOARD = CABINETS.register("warped_cabinet_cupboard",
            () -> new CabinetCupboardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_cabinet_cupboard")))));

    public static final Supplier<CabinetOvenVentBlock> WARPED_CABINET_OVEN_VENT = CABINETS.register("warped_cabinet_oven_vent",
            () -> new CabinetOvenVentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_cabinet_oven_vent")))));

    ////////////////////////////////////// DRAWERS ////////////////////////////////////

    public static final Supplier<DrawerBlock> OAK_DRAWER = DRAWERS.register("oak_drawer",
            () -> new DrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_drawer")))));

    public static final Supplier<DrawerBlock> SPRUCE_DRAWER = DRAWERS.register("spruce_drawer",
            () -> new DrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_drawer")))));

    public static final Supplier<DrawerBlock> BIRCH_DRAWER = DRAWERS.register("birch_drawer",
            () -> new DrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_drawer")))));

    public static final Supplier<DrawerBlock> JUNGLE_DRAWER = DRAWERS.register("jungle_drawer",
            () -> new DrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_drawer")))));

    public static final Supplier<DrawerBlock> ACACIA_DRAWER = DRAWERS.register("acacia_drawer",
            () -> new DrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_drawer")))));

    public static final Supplier<DrawerBlock> DARK_OAK_DRAWER = DRAWERS.register("dark_oak_drawer",
            () -> new DrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_drawer")))));

    public static final Supplier<DrawerBlock> MANGROVE_DRAWER = DRAWERS.register("mangrove_drawer",
            () -> new DrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_drawer")))));

    public static final Supplier<DrawerBlock> CHERRY_DRAWER = DRAWERS.register("cherry_drawer",
            () -> new DrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_drawer")))));

    public static final Supplier<DrawerBlock> BAMBOO_DRAWER = DRAWERS.register("bamboo_drawer",
            () -> new DrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_drawer")))));

    public static final Supplier<DrawerBlock> CRIMSON_DRAWER = DRAWERS.register("crimson_drawer",
            () -> new DrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_drawer")))));

    public static final Supplier<DrawerBlock> WARPED_DRAWER = DRAWERS.register("warped_drawer",
            () -> new DrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_drawer")))));

    ////////////////////////////////////// DESKS ////////////////////////////////////

    ////////////////////////////////////// SHELVES ////////////////////////////////////

    public static final Supplier<ShelfBlock> OAK_SHELF = SHELVES.register("oak_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_shelf")))));

    public static final Supplier<ShelfBlock> SPRUCE_SHELF = SHELVES.register("spruce_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_shelf")))));

    public static final Supplier<ShelfBlock> BIRCH_SHELF = SHELVES.register("birch_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_shelf")))));

    public static final Supplier<ShelfBlock> JUNGLE_SHELF = SHELVES.register("jungle_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_shelf")))));

    public static final Supplier<ShelfBlock> ACACIA_SHELF = SHELVES.register("acacia_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_shelf")))));

    public static final Supplier<ShelfBlock> DARK_OAK_SHELF = SHELVES.register("dark_oak_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_shelf")))));

    public static final Supplier<ShelfBlock> MANGROVE_SHELF = SHELVES.register("mangrove_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_shelf")))));

    public static final Supplier<ShelfBlock> CHERRY_SHELF = SHELVES.register("cherry_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_shelf")))));

    public static final Supplier<ShelfBlock> BAMBOO_SHELF = SHELVES.register("bamboo_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_shelf")))));

    public static final Supplier<ShelfBlock> CRIMSON_SHELF = SHELVES.register("crimson_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_shelf")))));

    public static final Supplier<ShelfBlock> WARPED_SHELF = SHELVES.register("warped_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_shelf")))));

    ////////////////////////////////////// MAILBOXES ////////////////////////////////////

    public static final Supplier<MailboxBlock> OAK_MAILBOX = MAILBOX.register("oak_mailbox",
            () -> new MailboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_mailbox")))));

    public static final Supplier<MailboxBlock> SPRUCE_MAILBOX = MAILBOX.register("spruce_mailbox",
            () -> new MailboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_mailbox")))));

    public static final Supplier<MailboxBlock> BIRCH_MAILBOX = MAILBOX.register("birch_mailbox",
            () -> new MailboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_mailbox")))));

    public static final Supplier<MailboxBlock> JUNGLE_MAILBOX = MAILBOX.register("jungle_mailbox",
            () -> new MailboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_mailbox")))));

    public static final Supplier<MailboxBlock> ACACIA_MAILBOX = MAILBOX.register("acacia_mailbox",
            () -> new MailboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_mailbox")))));

    public static final Supplier<MailboxBlock> DARK_OAK_MAILBOX = MAILBOX.register("dark_oak_mailbox",
            () -> new MailboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_mailbox")))));

    public static final Supplier<MailboxBlock> MANGROVE_MAILBOX = MAILBOX.register("mangrove_mailbox",
            () -> new MailboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_mailbox")))));

    public static final Supplier<MailboxBlock> CHERRY_MAILBOX = MAILBOX.register("cherry_mailbox",
            () -> new MailboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_mailbox")))));

    public static final Supplier<MailboxBlock> BAMBOO_MAILBOX = MAILBOX.register("bamboo_mailbox",
            () -> new MailboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_mailbox")))));

    public static final Supplier<MailboxBlock> CRIMSON_MAILBOX = MAILBOX.register("crimson_mailbox",
            () -> new MailboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_mailbox")))));

    public static final Supplier<MailboxBlock> WARPED_MAILBOX = MAILBOX.register("warped_mailbox",
            () -> new MailboxBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_mailbox")))));

    ////////////////////////////////////// WARDROBES ////////////////////////////////////

    public static final Supplier<WardrobeBlock> OAK_WARDROBE = WARDROBE.register("oak_wardrobe",
            () -> new WardrobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_wardrobe")))));

    public static final Supplier<WardrobeBlock> SPRUCE_WARDROBE = WARDROBE.register("spruce_wardrobe",
            () -> new WardrobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_wardrobe")))));

    public static final Supplier<WardrobeBlock> BIRCH_WARDROBE = WARDROBE.register("birch_wardrobe",
            () -> new WardrobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_wardrobe")))));

    public static final Supplier<WardrobeBlock> JUNGLE_WARDROBE = WARDROBE.register("jungle_wardrobe",
            () -> new WardrobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_wardrobe")))));

    public static final Supplier<WardrobeBlock> ACACIA_WARDROBE = WARDROBE.register("acacia_wardrobe",
            () -> new WardrobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_wardrobe")))));

    public static final Supplier<WardrobeBlock> DARK_OAK_WARDROBE = WARDROBE.register("dark_oak_wardrobe",
            () -> new WardrobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_wardrobe")))));

    public static final Supplier<WardrobeBlock> MANGROVE_WARDROBE = WARDROBE.register("mangrove_wardrobe",
            () -> new WardrobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_wardrobe")))));

    public static final Supplier<WardrobeBlock> CHERRY_WARDROBE = WARDROBE.register("cherry_wardrobe",
            () -> new WardrobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_wardrobe")))));

    public static final Supplier<WardrobeBlock> BAMBOO_WARDROBE = WARDROBE.register("bamboo_wardrobe",
            () -> new WardrobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_wardrobe")))));

    public static final Supplier<WardrobeBlock> CRIMSON_WARDROBE = WARDROBE.register("crimson_wardrobe",
            () -> new WardrobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_wardrobe")))));

    public static final Supplier<WardrobeBlock> WARPED_WARDROBE = WARDROBE.register("warped_wardrobe",
            () -> new WardrobeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_wardrobe")))));

    ////////////////////////////////////// BLINDS ////////////////////////////////////

    public static final Supplier<BlindsBlock> OAK_BLINDS = BLINDS.register("oak_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_blinds")))));

    public static final Supplier<BlindsBlock> SPRUCE_BLINDS = BLINDS.register("spruce_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_blinds")))));

    public static final Supplier<BlindsBlock> BIRCH_BLINDS = BLINDS.register("birch_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_blinds")))));

    public static final Supplier<BlindsBlock> JUNGLE_BLINDS = BLINDS.register("jungle_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_blinds")))));

    public static final Supplier<BlindsBlock> ACACIA_BLINDS = BLINDS.register("acacia_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_blinds")))));

    public static final Supplier<BlindsBlock> DARK_OAK_BLINDS = BLINDS.register("dark_oak_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_blinds")))));

    public static final Supplier<BlindsBlock> MANGROVE_BLINDS = BLINDS.register("mangrove_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_blinds")))));

    public static final Supplier<BlindsBlock> CHERRY_BLINDS = BLINDS.register("cherry_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_blinds")))));

    public static final Supplier<BlindsBlock> BAMBOO_BLINDS = BLINDS.register("bamboo_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_blinds")))));

    public static final Supplier<BlindsBlock> CRIMSON_BLINDS = BLINDS.register("crimson_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_blinds")))));

    public static final Supplier<BlindsBlock> WARPED_BLINDS = BLINDS.register("warped_blinds",
            () -> new BlindsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_blinds")))));

    ////////////////////////////////////// TOMBSTONES ////////////////////////////////////

    public static final RegistryEntry<TombstoneBlock> OAK_TOMBSTONE = TOMBSTONES.register("oak_tombstone",
            () -> new TombstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_tombstone")))));

    public static final RegistryEntry<TombstoneBlock> SPRUCE_TOMBSTONE = TOMBSTONES.register("spruce_tombstone",
            () -> new TombstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_tombstone")))));

    public static final RegistryEntry<TombstoneBlock> BIRCH_TOMBSTONE = TOMBSTONES.register("birch_tombstone",
            () -> new TombstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_tombstone")))));

    public static final RegistryEntry<TombstoneBlock> JUNGLE_TOMBSTONE = TOMBSTONES.register("jungle_tombstone",
            () -> new TombstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_tombstone")))));

    public static final RegistryEntry<TombstoneBlock> ACACIA_TOMBSTONE = TOMBSTONES.register("acacia_tombstone",
            () -> new TombstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_tombstone")))));

    public static final RegistryEntry<TombstoneBlock> DARK_OAK_TOMBSTONE = TOMBSTONES.register("dark_oak_tombstone",
            () -> new TombstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_tombstone")))));

    public static final RegistryEntry<TombstoneBlock> MANGROVE_TOMBSTONE = TOMBSTONES.register("mangrove_tombstone",
            () -> new TombstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_tombstone")))));

    public static final RegistryEntry<TombstoneBlock> CHERRY_TOMBSTONE = TOMBSTONES.register("cherry_tombstone",
            () -> new TombstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_tombstone")))));

    public static final RegistryEntry<TombstoneBlock> BAMBOO_TOMBSTONE = TOMBSTONES.register("bamboo_tombstone",
            () -> new TombstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_tombstone")))));

    public static final RegistryEntry<TombstoneBlock> CRIMSON_TOMBSTONE = TOMBSTONES.register("crimson_tombstone",
            () -> new TombstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_tombstone")))));

    public static final RegistryEntry<TombstoneBlock> WARPED_TOMBSTONE = TOMBSTONES.register("warped_tombstone",
            () -> new TombstoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_tombstone")))));

    ////////////////////////////////////// STAIRS ////////////////////////////////////

    public static final Supplier<ModStairBlock> OAK_STAIR = STAIRS.register("oak_stair",
            () -> new ModStairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_stair")))));

    public static final Supplier<ModStairBlock> SPRUCE_STAIR = STAIRS.register("spruce_stair",
            () -> new ModStairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_stair")))));

    public static final Supplier<ModStairBlock> BIRCH_STAIR = STAIRS.register("birch_stair",
            () -> new ModStairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_stair")))));

    public static final Supplier<ModStairBlock> JUNGLE_STAIR = STAIRS.register("jungle_stair",
            () -> new ModStairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_stair")))));

    public static final Supplier<ModStairBlock> ACACIA_STAIR = STAIRS.register("acacia_stair",
            () -> new ModStairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_stair")))));

    public static final Supplier<ModStairBlock> DARK_OAK_STAIR = STAIRS.register("dark_oak_stair",
            () -> new ModStairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_stair")))));

    public static final Supplier<ModStairBlock> MANGROVE_STAIR = STAIRS.register("mangrove_stair",
            () -> new ModStairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_stair")))));

    public static final Supplier<ModStairBlock> CHERRY_STAIR = STAIRS.register("cherry_stair",
            () -> new ModStairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_stair")))));

    public static final Supplier<ModStairBlock> BAMBOO_STAIR = STAIRS.register("bamboo_stair",
            () -> new ModStairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_stair")))));

    public static final Supplier<ModStairBlock> CRIMSON_STAIR = STAIRS.register("crimson_stair",
            () -> new ModStairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_stair")))));

    public static final Supplier<ModStairBlock> WARPED_STAIR = STAIRS.register("warped_stair",
            () -> new ModStairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_stair")))));

    ////////////////////////////////////// PLATFORMS ////////////////////////////////////

    public static final Supplier<PlatformBlock> OAK_PLATFORM = PLATFORMS.register("oak_platform",
            () -> new PlatformBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_platform")))));

    public static final Supplier<PlatformBlock> SPRUCE_PLATFORM = PLATFORMS.register("spruce_platform",
            () -> new PlatformBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_platform")))));

    public static final Supplier<PlatformBlock> BIRCH_PLATFORM = PLATFORMS.register("birch_platform",
            () -> new PlatformBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_platform")))));

    public static final Supplier<PlatformBlock> JUNGLE_PLATFORM = PLATFORMS.register("jungle_platform",
            () -> new PlatformBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_platform")))));

    public static final Supplier<PlatformBlock> ACACIA_PLATFORM = PLATFORMS.register("acacia_platform",
            () -> new PlatformBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_platform")))));

    public static final Supplier<PlatformBlock> DARK_OAK_PLATFORM = PLATFORMS.register("dark_oak_platform",
            () -> new PlatformBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_platform")))));

    public static final Supplier<PlatformBlock> MANGROVE_PLATFORM = PLATFORMS.register("mangrove_platform",
            () -> new PlatformBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_platform")))));

    public static final Supplier<PlatformBlock> CHERRY_PLATFORM = PLATFORMS.register("cherry_platform",
            () -> new PlatformBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_platform")))));

    public static final Supplier<PlatformBlock> BAMBOO_PLATFORM = PLATFORMS.register("bamboo_platform",
            () -> new PlatformBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_platform")))));

    public static final Supplier<PlatformBlock> CRIMSON_PLATFORM = PLATFORMS.register("crimson_platform",
            () -> new PlatformBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_platform")))));

    public static final Supplier<PlatformBlock> WARPED_PLATFORM = PLATFORMS.register("warped_platform",
            () -> new PlatformBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_platform")))));
    
    ////////////////////////////////////// RAILINGS ////////////////////////////////////

    public static final Supplier<RailingBlock> OAK_RAILING = RAILINGS.register("oak_railing",
            () -> new RailingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_railing")))));

    public static final Supplier<RailingBlock> SPRUCE_RAILING = RAILINGS.register("spruce_railing",
            () -> new RailingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_railing")))));

    public static final Supplier<RailingBlock> BIRCH_RAILING = RAILINGS.register("birch_railing",
            () -> new RailingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_railing")))));

    public static final Supplier<RailingBlock> JUNGLE_RAILING = RAILINGS.register("jungle_railing",
            () -> new RailingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_railing")))));

    public static final Supplier<RailingBlock> ACACIA_RAILING = RAILINGS.register("acacia_railing",
            () -> new RailingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_railing")))));

    public static final Supplier<RailingBlock> DARK_OAK_RAILING = RAILINGS.register("dark_oak_railing",
            () -> new RailingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_railing")))));

    public static final Supplier<RailingBlock> MANGROVE_RAILING = RAILINGS.register("mangrove_railing",
            () -> new RailingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_railing")))));

    public static final Supplier<RailingBlock> CHERRY_RAILING = RAILINGS.register("cherry_railing",
            () -> new RailingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_railing")))));

    public static final Supplier<RailingBlock> BAMBOO_RAILING = RAILINGS.register("bamboo_railing",
            () -> new RailingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_railing")))));

    public static final Supplier<RailingBlock> CRIMSON_RAILING = RAILINGS.register("crimson_railing",
            () -> new RailingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_railing")))));

    public static final Supplier<RailingBlock> WARPED_RAILING = RAILINGS.register("warped_railing",
            () -> new RailingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_railing")))));

    //////////////////////////////////// ROOFS ////////////////////////////////////

    public static final Supplier<StairBlock> OAK_ROOF = ROOFS.register("oak_roof",
            () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_roof")))));

    public static final Supplier<RoofShallowBlock> OAK_ROOF_SHALLOW = ROOFS.register("oak_roof_shallow",
            () -> new RoofShallowBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_roof_shallow")))));

    public static final Supplier<RoofSteepBlock> OAK_ROOF_STEEP = ROOFS.register("oak_roof_steep",
            () -> new RoofSteepBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_roof_steep")))));

    public static final Supplier<StairBlock> SPRUCE_ROOF = ROOFS.register("spruce_roof",
            () -> new StairBlock(Blocks.SPRUCE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_roof")))));

    public static final Supplier<RoofShallowBlock> SPRUCE_ROOF_SHALLOW = ROOFS.register("spruce_roof_shallow",
            () -> new RoofShallowBlock(Blocks.SPRUCE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_roof_shallow")))));

    public static final Supplier<RoofSteepBlock> SPRUCE_ROOF_STEEP = ROOFS.register("spruce_roof_steep",
            () -> new RoofSteepBlock(Blocks.SPRUCE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_roof_steep")))));

    public static final Supplier<StairBlock> BIRCH_ROOF = ROOFS.register("birch_roof",
            () -> new StairBlock(Blocks.BIRCH_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_roof")))));

    public static final Supplier<RoofShallowBlock> BIRCH_ROOF_SHALLOW = ROOFS.register("birch_roof_shallow",
            () -> new RoofShallowBlock(Blocks.BIRCH_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_roof_shallow")))));

    public static final Supplier<RoofSteepBlock> BIRCH_ROOF_STEEP = ROOFS.register("birch_roof_steep",
            () -> new RoofSteepBlock(Blocks.BIRCH_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_roof_steep")))));

    public static final Supplier<StairBlock> JUNGLE_ROOF = ROOFS.register("jungle_roof",
            () -> new StairBlock(Blocks.JUNGLE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_roof")))));

    public static final Supplier<RoofShallowBlock> JUNGLE_ROOF_SHALLOW = ROOFS.register("jungle_roof_shallow",
            () -> new RoofShallowBlock(Blocks.JUNGLE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_roof_shallow")))));

    public static final Supplier<RoofSteepBlock> JUNGLE_ROOF_STEEP = ROOFS.register("jungle_roof_steep",
            () -> new RoofSteepBlock(Blocks.JUNGLE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_roof_steep")))));

    public static final Supplier<StairBlock> ACACIA_ROOF = ROOFS.register("acacia_roof",
            () -> new StairBlock(Blocks.ACACIA_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_roof")))));

    public static final Supplier<RoofShallowBlock> ACACIA_ROOF_SHALLOW = ROOFS.register("acacia_roof_shallow",
            () -> new RoofShallowBlock(Blocks.ACACIA_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_roof_shallow")))));

    public static final Supplier<RoofSteepBlock> ACACIA_ROOF_STEEP = ROOFS.register("acacia_roof_steep",
            () -> new RoofSteepBlock(Blocks.ACACIA_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_roof_steep")))));

    public static final Supplier<StairBlock> DARK_OAK_ROOF = ROOFS.register("dark_oak_roof",
            () -> new StairBlock(Blocks.DARK_OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_roof")))));

    public static final Supplier<RoofShallowBlock> DARK_OAK_ROOF_SHALLOW = ROOFS.register("dark_oak_roof_shallow",
            () -> new RoofShallowBlock(Blocks.DARK_OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_roof_shallow")))));

    public static final Supplier<RoofSteepBlock> DARK_OAK_ROOF_STEEP = ROOFS.register("dark_oak_roof_steep",
            () -> new RoofSteepBlock(Blocks.DARK_OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_roof_steep")))));

    public static final Supplier<StairBlock> MANGROVE_ROOF = ROOFS.register("mangrove_roof",
            () -> new StairBlock(Blocks.MANGROVE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_roof")))));

    public static final Supplier<RoofShallowBlock> MANGROVE_ROOF_SHALLOW = ROOFS.register("mangrove_roof_shallow",
            () -> new RoofShallowBlock(Blocks.MANGROVE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_roof_shallow")))));

    public static final Supplier<RoofSteepBlock> MANGROVE_ROOF_STEEP = ROOFS.register("mangrove_roof_steep",
            () -> new RoofSteepBlock(Blocks.MANGROVE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_roof_steep")))));

    public static final Supplier<StairBlock> CHERRY_ROOF = ROOFS.register("cherry_roof",
            () -> new StairBlock(Blocks.CHERRY_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_roof")))));

    public static final Supplier<RoofShallowBlock> CHERRY_ROOF_SHALLOW = ROOFS.register("cherry_roof_shallow",
            () -> new RoofShallowBlock(Blocks.CHERRY_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_roof_shallow")))));

    public static final Supplier<RoofSteepBlock> CHERRY_ROOF_STEEP = ROOFS.register("cherry_roof_steep",
            () -> new RoofSteepBlock(Blocks.CHERRY_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_roof_steep")))));

    public static final Supplier<StairBlock> BAMBOO_ROOF = ROOFS.register("bamboo_roof",
            () -> new StairBlock(Blocks.BAMBOO_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_roof")))));

    public static final Supplier<RoofShallowBlock> BAMBOO_ROOF_SHALLOW = ROOFS.register("bamboo_roof_shallow",
            () -> new RoofShallowBlock(Blocks.BAMBOO_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_roof_shallow")))));

    public static final Supplier<RoofSteepBlock> BAMBOO_ROOF_STEEP = ROOFS.register("bamboo_roof_steep",
            () -> new RoofSteepBlock(Blocks.BAMBOO_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_roof_steep")))));

    public static final Supplier<StairBlock> CRIMSON_ROOF = ROOFS.register("crimson_roof",
            () -> new StairBlock(Blocks.CRIMSON_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_roof")))));

    public static final Supplier<RoofShallowBlock> CRIMSON_ROOF_SHALLOW = ROOFS.register("crimson_roof_shallow",
            () -> new RoofShallowBlock(Blocks.CRIMSON_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_roof_shallow")))));

    public static final Supplier<RoofSteepBlock> CRIMSON_ROOF_STEEP = ROOFS.register("crimson_roof_steep",
            () -> new RoofSteepBlock(Blocks.CRIMSON_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_roof_steep")))));

    public static final Supplier<StairBlock> WARPED_ROOF = ROOFS.register("warped_roof",
            () -> new StairBlock(Blocks.WARPED_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_roof")))));

    public static final Supplier<RoofShallowBlock> WARPED_ROOF_SHALLOW = ROOFS.register("warped_roof_shallow",
            () -> new RoofShallowBlock(Blocks.WARPED_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_roof_shallow")))));

    public static final Supplier<RoofSteepBlock> WARPED_ROOF_STEEP = ROOFS.register("warped_roof_steep",
            () -> new RoofSteepBlock(Blocks.WARPED_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STAIRS).noOcclusion()
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_roof_steep")))));

    //////////////////////////////////// HIDDEN DOORS //////////////////////////////////// 

    public static final Supplier<DoorBlock> BOOKSHELF_HIDDEN_DOOR = DOORS.register("bookshelf_hidden_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bookshelf_hidden_door")))));

    public static final Supplier<DoorBlock> OAK_PLANKS_HIDDEN_DOOR = DOORS.register("oak_planks_hidden_door",
            () -> new DoorBlock(BlockSetType.SPRUCE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_planks_hidden_door")))));

    public static final Supplier<DoorBlock> SPRUCE_PLANKS_HIDDEN_DOOR = DOORS.register("spruce_planks_hidden_door",
            () -> new DoorBlock(BlockSetType.SPRUCE, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_DOOR)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_planks_hidden_door")))));

    public static final Supplier<DoorBlock> BIRCH_PLANKS_HIDDEN_DOOR = DOORS.register("birch_planks_hidden_door",
            () -> new DoorBlock(BlockSetType.BIRCH, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_DOOR)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_planks_hidden_door")))));

    public static final Supplier<DoorBlock> JUNGLE_PLANKS_HIDDEN_DOOR = DOORS.register("jungle_planks_hidden_door",
            () -> new DoorBlock(BlockSetType.JUNGLE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_DOOR)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_planks_hidden_door")))));

    public static final Supplier<DoorBlock> ACACIA_PLANKS_HIDDEN_DOOR = DOORS.register("acacia_planks_hidden_door",
            () -> new DoorBlock(BlockSetType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_DOOR)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_planks_hidden_door")))));

    public static final Supplier<DoorBlock> DARK_OAK_PLANKS_HIDDEN_DOOR = DOORS.register("dark_oak_planks_hidden_door",
            () -> new DoorBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_DOOR)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_planks_hidden_door")))));

    public static final Supplier<DoorBlock> MANGROVE_PLANKS_HIDDEN_DOOR = DOORS.register("mangrove_planks_hidden_door",
            () -> new DoorBlock(BlockSetType.MANGROVE, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_DOOR)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_planks_hidden_door")))));

    public static final Supplier<DoorBlock> CHERRY_PLANKS_HIDDEN_DOOR = DOORS.register("cherry_planks_hidden_door",
            () -> new DoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_DOOR)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_planks_hidden_door")))));

    public static final Supplier<DoorBlock> BAMBOO_PLANKS_HIDDEN_DOOR = DOORS.register("bamboo_planks_hidden_door",
            () -> new DoorBlock(BlockSetType.BAMBOO, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_DOOR)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_planks_hidden_door")))));

    public static final Supplier<DoorBlock> CRIMSON_PLANKS_HIDDEN_DOOR = DOORS.register("crimson_planks_hidden_door",
            () -> new DoorBlock(BlockSetType.CRIMSON, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_DOOR)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_planks_hidden_door")))));

    public static final Supplier<DoorBlock> WARPED_PLANKS_HIDDEN_DOOR = DOORS.register("warped_planks_hidden_door",
            () -> new DoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_DOOR)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_planks_hidden_door")))));

    ////////////////////////////////////// FENCES + GATES ////////////////////////////////////

    public static final Supplier<FenceBlock> OAK_UPGRADED_FENCE = UPGRADED_FENCES.register("oak_upgraded_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_upgraded_fence")))));

    public static final Supplier<FenceGateBlock> OAK_UPGRADED_FENCE_GATE = UPGRADED_FENCE_GATES.register("oak_upgraded_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_upgraded_fence_gate")))));

    public static final Supplier<FenceBlock> SPRUCE_UPGRADED_FENCE = UPGRADED_FENCES.register("spruce_upgraded_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_upgraded_fence")))));

    public static final Supplier<FenceGateBlock> SPRUCE_UPGRADED_FENCE_GATE = UPGRADED_FENCE_GATES.register("spruce_upgraded_fence_gate",
            () -> new FenceGateBlock(WoodType.SPRUCE, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_upgraded_fence_gate")))));

    public static final Supplier<FenceBlock> BIRCH_UPGRADED_FENCE = UPGRADED_FENCES.register("birch_upgraded_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_upgraded_fence")))));

    public static final Supplier<FenceGateBlock> BIRCH_UPGRADED_FENCE_GATE = UPGRADED_FENCE_GATES.register("birch_upgraded_fence_gate",
            () -> new FenceGateBlock(WoodType.BIRCH, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_upgraded_fence_gate")))));

    public static final Supplier<FenceBlock> JUNGLE_UPGRADED_FENCE = UPGRADED_FENCES.register("jungle_upgraded_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_upgraded_fence")))));

    public static final Supplier<FenceGateBlock> JUNGLE_UPGRADED_FENCE_GATE = UPGRADED_FENCE_GATES.register("jungle_upgraded_fence_gate",
            () -> new FenceGateBlock(WoodType.JUNGLE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_upgraded_fence_gate")))));

    public static final Supplier<FenceBlock> ACACIA_UPGRADED_FENCE = UPGRADED_FENCES.register("acacia_upgraded_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_upgraded_fence")))));

    public static final Supplier<FenceGateBlock> ACACIA_UPGRADED_FENCE_GATE = UPGRADED_FENCE_GATES.register("acacia_upgraded_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_upgraded_fence_gate")))));

    public static final Supplier<FenceBlock> DARK_OAK_UPGRADED_FENCE = UPGRADED_FENCES.register("dark_oak_upgraded_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_upgraded_fence")))));

    public static final Supplier<FenceGateBlock> DARK_OAK_UPGRADED_FENCE_GATE = UPGRADED_FENCE_GATES.register("dark_oak_upgraded_fence_gate",
            () -> new FenceGateBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_upgraded_fence_gate")))));

    public static final Supplier<FenceBlock> MANGROVE_UPGRADED_FENCE = UPGRADED_FENCES.register("mangrove_upgraded_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_upgraded_fence")))));

    public static final Supplier<FenceGateBlock> MANGROVE_UPGRADED_FENCE_GATE = UPGRADED_FENCE_GATES.register("mangrove_upgraded_fence_gate",
            () -> new FenceGateBlock(WoodType.MANGROVE, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_upgraded_fence_gate")))));

    public static final Supplier<FenceBlock> CHERRY_UPGRADED_FENCE = UPGRADED_FENCES.register("cherry_upgraded_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_upgraded_fence")))));

    public static final Supplier<FenceGateBlock> CHERRY_UPGRADED_FENCE_GATE = UPGRADED_FENCE_GATES.register("cherry_upgraded_fence_gate",
            () -> new FenceGateBlock(WoodType.CHERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_upgraded_fence_gate")))));

    public static final Supplier<FenceBlock> BAMBOO_UPGRADED_FENCE = UPGRADED_FENCES.register("bamboo_upgraded_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_upgraded_fence")))));

    public static final Supplier<FenceGateBlock> BAMBOO_UPGRADED_FENCE_GATE = UPGRADED_FENCE_GATES.register("bamboo_upgraded_fence_gate",
            () -> new FenceGateBlock(WoodType.BAMBOO, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_upgraded_fence_gate")))));

    public static final Supplier<FenceBlock> CRIMSON_UPGRADED_FENCE = UPGRADED_FENCES.register("crimson_upgraded_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_upgraded_fence")))));

    public static final Supplier<FenceGateBlock> CRIMSON_UPGRADED_FENCE_GATE = UPGRADED_FENCE_GATES.register("crimson_upgraded_fence_gate",
            () -> new FenceGateBlock(WoodType.CRIMSON, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_upgraded_fence_gate")))));

    public static final Supplier<FenceBlock> WARPED_UPGRADED_FENCE = UPGRADED_FENCES.register("warped_upgraded_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_upgraded_fence")))));

    public static final Supplier<FenceGateBlock> WARPED_UPGRADED_FENCE_GATE = UPGRADED_FENCE_GATES.register("warped_upgraded_fence_gate",
            () -> new FenceGateBlock(WoodType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_upgraded_fence_gate")))));

    public static final Supplier<FenceBlock> OAK_CHAIN_LINK_FENCE = CHAIN_LINK_FENCES.register("oak_chain_link_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_chain_link_fence")))));

    public static final Supplier<FenceGateBlock> OAK_CHAIN_LINK_FENCE_GATE = CHAIN_LINK_FENCE_GATES.register("oak_chain_link_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_chain_link_fence_gate")))));

    public static final Supplier<FenceBlock> SPRUCE_CHAIN_LINK_FENCE = CHAIN_LINK_FENCES.register("spruce_chain_link_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_chain_link_fence")))));

    public static final Supplier<FenceGateBlock> SPRUCE_CHAIN_LINK_FENCE_GATE = CHAIN_LINK_FENCE_GATES.register("spruce_chain_link_fence_gate",
            () -> new FenceGateBlock(WoodType.SPRUCE, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_chain_link_fence_gate")))));

    public static final Supplier<FenceBlock> BIRCH_CHAIN_LINK_FENCE = CHAIN_LINK_FENCES.register("birch_chain_link_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_chain_link_fence")))));

    public static final Supplier<FenceGateBlock> BIRCH_CHAIN_LINK_FENCE_GATE = CHAIN_LINK_FENCE_GATES.register("birch_chain_link_fence_gate",
            () -> new FenceGateBlock(WoodType.BIRCH, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_chain_link_fence_gate")))));

    public static final Supplier<FenceBlock> JUNGLE_CHAIN_LINK_FENCE = CHAIN_LINK_FENCES.register("jungle_chain_link_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_chain_link_fence")))));

    public static final Supplier<FenceGateBlock> JUNGLE_CHAIN_LINK_FENCE_GATE = CHAIN_LINK_FENCE_GATES.register("jungle_chain_link_fence_gate",
            () -> new FenceGateBlock(WoodType.JUNGLE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_chain_link_fence_gate")))));

    public static final Supplier<FenceBlock> ACACIA_CHAIN_LINK_FENCE = CHAIN_LINK_FENCES.register("acacia_chain_link_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_chain_link_fence")))));

    public static final Supplier<FenceGateBlock> ACACIA_CHAIN_LINK_FENCE_GATE = CHAIN_LINK_FENCE_GATES.register("acacia_chain_link_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_chain_link_fence_gate")))));

    public static final Supplier<FenceBlock> DARK_OAK_CHAIN_LINK_FENCE = CHAIN_LINK_FENCES.register("dark_oak_chain_link_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_chain_link_fence")))));

    public static final Supplier<FenceGateBlock> DARK_OAK_CHAIN_LINK_FENCE_GATE = CHAIN_LINK_FENCE_GATES.register("dark_oak_chain_link_fence_gate",
            () -> new FenceGateBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_chain_link_fence_gate")))));

    public static final Supplier<FenceBlock> MANGROVE_CHAIN_LINK_FENCE = CHAIN_LINK_FENCES.register("mangrove_chain_link_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_chain_link_fence")))));

    public static final Supplier<FenceGateBlock> MANGROVE_CHAIN_LINK_FENCE_GATE = CHAIN_LINK_FENCE_GATES.register("mangrove_chain_link_fence_gate",
            () -> new FenceGateBlock(WoodType.MANGROVE, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_chain_link_fence_gate")))));

    public static final Supplier<FenceBlock> CHERRY_CHAIN_LINK_FENCE = CHAIN_LINK_FENCES.register("cherry_chain_link_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_chain_link_fence")))));

    public static final Supplier<FenceGateBlock> CHERRY_CHAIN_LINK_FENCE_GATE = CHAIN_LINK_FENCE_GATES.register("cherry_chain_link_fence_gate",
            () -> new FenceGateBlock(WoodType.CHERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_chain_link_fence_gate")))));

    public static final Supplier<FenceBlock> BAMBOO_CHAIN_LINK_FENCE = CHAIN_LINK_FENCES.register("bamboo_chain_link_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_chain_link_fence")))));

    public static final Supplier<FenceGateBlock> BAMBOO_CHAIN_LINK_FENCE_GATE = CHAIN_LINK_FENCE_GATES.register("bamboo_chain_link_fence_gate",
            () -> new FenceGateBlock(WoodType.BAMBOO, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_chain_link_fence_gate")))));

    public static final Supplier<FenceBlock> CRIMSON_CHAIN_LINK_FENCE = CHAIN_LINK_FENCES.register("crimson_chain_link_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_chain_link_fence")))));

    public static final Supplier<FenceGateBlock> CRIMSON_CHAIN_LINK_FENCE_GATE = CHAIN_LINK_FENCE_GATES.register("crimson_chain_link_fence_gate",
            () -> new FenceGateBlock(WoodType.CRIMSON, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_chain_link_fence_gate")))));

    public static final Supplier<FenceBlock> WARPED_CHAIN_LINK_FENCE = CHAIN_LINK_FENCES.register("warped_chain_link_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_chain_link_fence")))));

    public static final Supplier<FenceGateBlock> WARPED_CHAIN_LINK_FENCE_GATE = CHAIN_LINK_FENCE_GATES.register("warped_chain_link_fence_gate",
            () -> new FenceGateBlock(WoodType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_chain_link_fence_gate")))));

    public static final Supplier<FenceBlock> OAK_LOG_FENCE = LOG_FENCES.register("oak_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_log_fence")))));

    public static final Supplier<FenceGateBlock> OAK_LOG_FENCE_GATE = LOG_FENCE_GATES.register("oak_log_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_log_fence_gate")))));

    public static final Supplier<FenceBlock> SPRUCE_LOG_FENCE = LOG_FENCES.register("spruce_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_log_fence")))));

    public static final Supplier<FenceGateBlock> SPRUCE_LOG_FENCE_GATE = LOG_FENCE_GATES.register("spruce_log_fence_gate",
            () -> new FenceGateBlock(WoodType.SPRUCE, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_log_fence_gate")))));

    public static final Supplier<FenceBlock> BIRCH_LOG_FENCE = LOG_FENCES.register("birch_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_log_fence")))));

    public static final Supplier<FenceGateBlock> BIRCH_LOG_FENCE_GATE = LOG_FENCE_GATES.register("birch_log_fence_gate",
            () -> new FenceGateBlock(WoodType.BIRCH, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_log_fence_gate")))));

    public static final Supplier<FenceBlock> JUNGLE_LOG_FENCE = LOG_FENCES.register("jungle_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_log_fence")))));

    public static final Supplier<FenceGateBlock> JUNGLE_LOG_FENCE_GATE = LOG_FENCE_GATES.register("jungle_log_fence_gate",
            () -> new FenceGateBlock(WoodType.JUNGLE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_log_fence_gate")))));

    public static final Supplier<FenceBlock> ACACIA_LOG_FENCE = LOG_FENCES.register("acacia_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_log_fence")))));

    public static final Supplier<FenceGateBlock> ACACIA_LOG_FENCE_GATE = LOG_FENCE_GATES.register("acacia_log_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_log_fence_gate")))));

    public static final Supplier<FenceBlock> DARK_OAK_LOG_FENCE = LOG_FENCES.register("dark_oak_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_log_fence")))));

    public static final Supplier<FenceGateBlock> DARK_OAK_LOG_FENCE_GATE = LOG_FENCE_GATES.register("dark_oak_log_fence_gate",
            () -> new FenceGateBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_log_fence_gate")))));

    public static final Supplier<FenceBlock> MANGROVE_LOG_FENCE = LOG_FENCES.register("mangrove_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_log_fence")))));

    public static final Supplier<FenceGateBlock> MANGROVE_LOG_FENCE_GATE = LOG_FENCE_GATES.register("mangrove_log_fence_gate",
            () -> new FenceGateBlock(WoodType.MANGROVE, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_log_fence_gate")))));

    public static final Supplier<FenceBlock> CHERRY_LOG_FENCE = LOG_FENCES.register("cherry_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_log_fence")))));

    public static final Supplier<FenceGateBlock> CHERRY_LOG_FENCE_GATE = LOG_FENCE_GATES.register("cherry_log_fence_gate",
            () -> new FenceGateBlock(WoodType.CHERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_log_fence_gate")))));

    public static final Supplier<FenceBlock> BAMBOO_LOG_FENCE = LOG_FENCES.register("bamboo_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_log_fence")))));

    public static final Supplier<FenceGateBlock> BAMBOO_LOG_FENCE_GATE = LOG_FENCE_GATES.register("bamboo_log_fence_gate",
            () -> new FenceGateBlock(WoodType.BAMBOO, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_log_fence_gate")))));

    public static final Supplier<FenceBlock> CRIMSON_LOG_FENCE = LOG_FENCES.register("crimson_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_log_fence")))));

    public static final Supplier<FenceGateBlock> CRIMSON_LOG_FENCE_GATE = LOG_FENCE_GATES.register("crimson_log_fence_gate",
            () -> new FenceGateBlock(WoodType.CRIMSON, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_log_fence_gate")))));

    public static final Supplier<FenceBlock> WARPED_LOG_FENCE = LOG_FENCES.register("warped_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_log_fence")))));

    public static final Supplier<FenceGateBlock> WARPED_LOG_FENCE_GATE = LOG_FENCE_GATES.register("warped_log_fence_gate",
            () -> new FenceGateBlock(WoodType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_log_fence_gate")))));

    public static final Supplier<FenceBlock> OAK_STRIPPED_LOG_FENCE = STRIPPED_LOG_FENCES.register("oak_stripped_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_stripped_log_fence")))));

    public static final Supplier<FenceGateBlock> OAK_STRIPPED_LOG_FENCE_GATE = STRIPPED_LOG_FENCE_GATES.register("oak_stripped_log_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_stripped_log_fence_gate")))));

    public static final Supplier<FenceBlock> SPRUCE_STRIPPED_LOG_FENCE = STRIPPED_LOG_FENCES.register("spruce_stripped_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_stripped_log_fence")))));

    public static final Supplier<FenceGateBlock> SPRUCE_STRIPPED_LOG_FENCE_GATE = STRIPPED_LOG_FENCE_GATES.register("spruce_stripped_log_fence_gate",
            () -> new FenceGateBlock(WoodType.SPRUCE, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_stripped_log_fence_gate")))));

    public static final Supplier<FenceBlock> BIRCH_STRIPPED_LOG_FENCE = STRIPPED_LOG_FENCES.register("birch_stripped_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_stripped_log_fence")))));

    public static final Supplier<FenceGateBlock> BIRCH_STRIPPED_LOG_FENCE_GATE = STRIPPED_LOG_FENCE_GATES.register("birch_stripped_log_fence_gate",
            () -> new FenceGateBlock(WoodType.BIRCH, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_stripped_log_fence_gate")))));

    public static final Supplier<FenceBlock> JUNGLE_STRIPPED_LOG_FENCE = STRIPPED_LOG_FENCES.register("jungle_stripped_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_stripped_log_fence")))));

    public static final Supplier<FenceGateBlock> JUNGLE_STRIPPED_LOG_FENCE_GATE = STRIPPED_LOG_FENCE_GATES.register("jungle_stripped_log_fence_gate",
            () -> new FenceGateBlock(WoodType.JUNGLE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_stripped_log_fence_gate")))));

    public static final Supplier<FenceBlock> ACACIA_STRIPPED_LOG_FENCE = STRIPPED_LOG_FENCES.register("acacia_stripped_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_stripped_log_fence")))));

    public static final Supplier<FenceGateBlock> ACACIA_STRIPPED_LOG_FENCE_GATE = STRIPPED_LOG_FENCE_GATES.register("acacia_stripped_log_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_stripped_log_fence_gate")))));

    public static final Supplier<FenceBlock> DARK_OAK_STRIPPED_LOG_FENCE = STRIPPED_LOG_FENCES.register("dark_oak_stripped_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_stripped_log_fence")))));

    public static final Supplier<FenceGateBlock> DARK_OAK_STRIPPED_LOG_FENCE_GATE = STRIPPED_LOG_FENCE_GATES.register("dark_oak_stripped_log_fence_gate",
            () -> new FenceGateBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_stripped_log_fence_gate")))));

    public static final Supplier<FenceBlock> MANGROVE_STRIPPED_LOG_FENCE = STRIPPED_LOG_FENCES.register("mangrove_stripped_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_stripped_log_fence")))));

    public static final Supplier<FenceGateBlock> MANGROVE_STRIPPED_LOG_FENCE_GATE = STRIPPED_LOG_FENCE_GATES.register("mangrove_stripped_log_fence_gate",
            () -> new FenceGateBlock(WoodType.MANGROVE, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_stripped_log_fence_gate")))));

    public static final Supplier<FenceBlock> CHERRY_STRIPPED_LOG_FENCE = STRIPPED_LOG_FENCES.register("cherry_stripped_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_stripped_log_fence")))));

    public static final Supplier<FenceGateBlock> CHERRY_STRIPPED_LOG_FENCE_GATE = STRIPPED_LOG_FENCE_GATES.register("cherry_stripped_log_fence_gate",
            () -> new FenceGateBlock(WoodType.CHERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_stripped_log_fence_gate")))));

    public static final Supplier<FenceBlock> BAMBOO_STRIPPED_LOG_FENCE = STRIPPED_LOG_FENCES.register("bamboo_stripped_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_stripped_log_fence")))));

    public static final Supplier<FenceGateBlock> BAMBOO_STRIPPED_LOG_FENCE_GATE = STRIPPED_LOG_FENCE_GATES.register("bamboo_stripped_log_fence_gate",
            () -> new FenceGateBlock(WoodType.BAMBOO, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_stripped_log_fence_gate")))));

    public static final Supplier<FenceBlock> CRIMSON_STRIPPED_LOG_FENCE = STRIPPED_LOG_FENCES.register("crimson_stripped_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_stripped_log_fence")))));

    public static final Supplier<FenceGateBlock> CRIMSON_STRIPPED_LOG_FENCE_GATE = STRIPPED_LOG_FENCE_GATES.register("crimson_stripped_log_fence_gate",
            () -> new FenceGateBlock(WoodType.CRIMSON, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_stripped_log_fence_gate")))));

    public static final Supplier<FenceBlock> WARPED_STRIPPED_LOG_FENCE = STRIPPED_LOG_FENCES.register("warped_stripped_log_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_stripped_log_fence")))));

    public static final Supplier<FenceGateBlock> WARPED_STRIPPED_LOG_FENCE_GATE = STRIPPED_LOG_FENCE_GATES.register("warped_stripped_log_fence_gate",
            () -> new FenceGateBlock(WoodType.WARPED, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FENCE_GATE)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_stripped_log_fence_gate")))));

    ////////////////////////////////////// BUSHES ////////////////////////////////////////

    public static final Supplier<BushBlock> OAK_BUSH = BUSHES.register("oak_bush",
            () -> new BushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_bush")))));

    public static final Supplier<BushBlock> SPRUCE_BUSH = BUSHES.register("spruce_bush",
            () -> new BushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_bush")))));

    public static final Supplier<BushBlock> BIRCH_BUSH = BUSHES.register("birch_bush",
            () -> new BushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_bush")))));

    public static final Supplier<BushBlock> JUNGLE_BUSH = BUSHES.register("jungle_bush",
            () -> new BushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_bush")))));

    public static final Supplier<BushBlock> ACACIA_BUSH = BUSHES.register("acacia_bush",
            () -> new BushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_bush")))));

    public static final Supplier<BushBlock> DARK_OAK_BUSH = BUSHES.register("dark_oak_bush",
            () -> new BushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_bush")))));

    public static final Supplier<BushBlock> MANGROVE_BUSH = BUSHES.register("mangrove_bush",
            () -> new BushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_LEAVES)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_bush")))));

    public static final Supplier<BushBlock> CHERRY_BUSH = BUSHES.register("cherry_bush",
            () -> new BushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LEAVES)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_bush")))));

    public static final Supplier<BushBlock> CRIMSON_BUSH = BUSHES.register("crimson_bush",
            () -> new BushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_WART_BLOCK)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_bush")))));

    public static final Supplier<BushBlock> WARPED_BUSH = BUSHES.register("warped_bush",
            () -> new BushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_WART_BLOCK)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_bush")))));

    public static final Supplier<BushBlock> AZALEA_BUSH = BUSHES.register("azalea_bush",
            () -> new BushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA_LEAVES)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("azalea_bush")))));

    public static final Supplier<BushBlock> FLOWERING_AZALEA_BUSH = BUSHES.register("flowering_azalea_bush",
            () -> new BushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWERING_AZALEA_LEAVES)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("flowering_azalea_bush")))));

    ////////////////////////////////////// HOLLOW LOGS ////////////////////////////////////

    public static final Supplier<HollowLogBlock> OAK_HOLLOW_LOG = HOLLOW_LOGS.register("oak_hollow_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_hollow_log")))));

    public static final Supplier<HollowLogBlock> OAK_HOLLOW_STRIPPED_LOG = HOLLOW_LOGS.register("oak_hollow_stripped_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_hollow_stripped_log")))));

    public static final Supplier<HollowLogBlock> SPRUCE_HOLLOW_LOG = HOLLOW_LOGS.register("spruce_hollow_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_hollow_log")))));

    public static final Supplier<HollowLogBlock> SPRUCE_HOLLOW_STRIPPED_LOG = HOLLOW_LOGS.register("spruce_hollow_stripped_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_hollow_stripped_log")))));

    public static final Supplier<HollowLogBlock> BIRCH_HOLLOW_LOG = HOLLOW_LOGS.register("birch_hollow_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_hollow_log")))));

    public static final Supplier<HollowLogBlock> BIRCH_HOLLOW_STRIPPED_LOG = HOLLOW_LOGS.register("birch_hollow_stripped_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_hollow_stripped_log")))));

    public static final Supplier<HollowLogBlock> JUNGLE_HOLLOW_LOG = HOLLOW_LOGS.register("jungle_hollow_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_hollow_log")))));

    public static final Supplier<HollowLogBlock> JUNGLE_HOLLOW_STRIPPED_LOG = HOLLOW_LOGS.register("jungle_hollow_stripped_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_JUNGLE_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_hollow_stripped_log")))));

    public static final Supplier<HollowLogBlock> ACACIA_HOLLOW_LOG = HOLLOW_LOGS.register("acacia_hollow_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_hollow_log")))));

    public static final Supplier<HollowLogBlock> ACACIA_HOLLOW_STRIPPED_LOG = HOLLOW_LOGS.register("acacia_hollow_stripped_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_hollow_stripped_log")))));

    public static final Supplier<HollowLogBlock> DARK_OAK_HOLLOW_LOG = HOLLOW_LOGS.register("dark_oak_hollow_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_hollow_log")))));

    public static final Supplier<HollowLogBlock> DARK_OAK_HOLLOW_STRIPPED_LOG = HOLLOW_LOGS.register("dark_oak_hollow_stripped_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_DARK_OAK_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_hollow_stripped_log")))));

    public static final Supplier<HollowLogBlock> MANGROVE_HOLLOW_LOG = HOLLOW_LOGS.register("mangrove_hollow_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_hollow_log")))));

    public static final Supplier<HollowLogBlock> MANGROVE_HOLLOW_STRIPPED_LOG = HOLLOW_LOGS.register("mangrove_hollow_stripped_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_MANGROVE_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_hollow_stripped_log")))));

    public static final Supplier<HollowLogBlock> CHERRY_HOLLOW_LOG = HOLLOW_LOGS.register("cherry_hollow_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_hollow_log")))));

    public static final Supplier<HollowLogBlock> CHERRY_HOLLOW_STRIPPED_LOG = HOLLOW_LOGS.register("cherry_hollow_stripped_log",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_LOG)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_hollow_stripped_log")))));

    public static final Supplier<HollowLogBlock> BAMBOO_HOLLOW_BLOCK = HOLLOW_LOGS.register("bamboo_hollow_block",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_BLOCK)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_hollow_block")))));

    public static final Supplier<HollowLogBlock> BAMBOO_HOLLOW_STRIPPED_BLOCK = HOLLOW_LOGS.register("bamboo_hollow_stripped_block",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BAMBOO_BLOCK)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_hollow_stripped_block")))));

    public static final Supplier<HollowLogBlock> CRIMSON_HOLLOW_STEM = HOLLOW_LOGS.register("crimson_hollow_stem",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STEM)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_hollow_stem")))));

    public static final Supplier<HollowLogBlock> CRIMSON_HOLLOW_STRIPPED_STEM = HOLLOW_LOGS.register("crimson_hollow_stripped_stem",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_STEM)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_hollow_stripped_stem")))));

    public static final Supplier<HollowLogBlock> WARPED_HOLLOW_STEM = HOLLOW_LOGS.register("warped_hollow_stem",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STEM)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_hollow_stem")))));

    public static final Supplier<HollowLogBlock> WARPED_HOLLOW_STRIPPED_STEM = HOLLOW_LOGS.register("warped_hollow_stripped_stem",
            () -> new HollowLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_STEM)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_hollow_stripped_stem")))));

    ////////////////////////////////////// POTTED ////////////////////////////////////

    ////////////////////////////////////// PLANTS ////////////////////////////////////

    ////////////////////////////////////// LAMPS //////////////////////////////////////

    public static final Supplier<LampBlock> OAK_LAMP = LAMPS.register("oak_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("oak_lamp")))));

    public static final Supplier<LampBlock> SPRUCE_LAMP = LAMPS.register("spruce_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("spruce_lamp")))));

    public static final Supplier<LampBlock> BIRCH_LAMP = LAMPS.register("birch_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("birch_lamp")))));

    public static final Supplier<LampBlock> JUNGLE_LAMP = LAMPS.register("jungle_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("jungle_lamp")))));

    public static final Supplier<LampBlock> ACACIA_LAMP = LAMPS.register("acacia_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("acacia_lamp")))));

    public static final Supplier<LampBlock> DARK_OAK_LAMP = LAMPS.register("dark_oak_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("dark_oak_lamp")))));

    public static final Supplier<LampBlock> MANGROVE_LAMP = LAMPS.register("mangrove_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("mangrove_lamp")))));

    public static final Supplier<LampBlock> CHERRY_LAMP = LAMPS.register("cherry_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cherry_lamp")))));

    public static final Supplier<LampBlock> BAMBOO_LAMP = LAMPS.register("bamboo_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("bamboo_lamp")))));

    public static final Supplier<LampBlock> CRIMSON_LAMP = LAMPS.register("crimson_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("crimson_lamp")))));

    public static final Supplier<LampBlock> WARPED_LAMP = LAMPS.register("warped_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("warped_lamp")))));

    ////////////////////////////////////// RUGS ////////////////////////////////////

    public static final Supplier<RotatableBlock> WHITE_RUG = RUGS.register("white_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("white_rug")))));

    public static final Supplier<RotatableBlock> LIGHT_GRAY_RUG = RUGS.register("light_gray_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("light_gray_rug")))));

    public static final Supplier<RotatableBlock> GRAY_RUG = RUGS.register("gray_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("gray_rug")))));

    public static final Supplier<RotatableBlock> BLACK_RUG = RUGS.register("black_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("black_rug")))));

    public static final Supplier<RotatableBlock> BROWN_RUG = RUGS.register("brown_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("brown_rug")))));

    public static final Supplier<RotatableBlock> RED_RUG = RUGS.register("red_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("red_rug")))));

    public static final Supplier<RotatableBlock> ORANGE_RUG = RUGS.register("orange_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("orange_rug")))));

    public static final Supplier<RotatableBlock> YELLOW_RUG = RUGS.register("yellow_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("yellow_rug")))));

    public static final Supplier<RotatableBlock> LIME_RUG = RUGS.register("lime_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("lime_rug")))));

    public static final Supplier<RotatableBlock> GREEN_RUG = RUGS.register("green_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("green_rug")))));

    public static final Supplier<RotatableBlock> CYAN_RUG = RUGS.register("cyan_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("cyan_rug")))));

    public static final Supplier<RotatableBlock> LIGHT_BLUE_RUG = RUGS.register("light_blue_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("light_blue_rug")))));

    public static final Supplier<RotatableBlock> BLUE_RUG = RUGS.register("blue_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("blue_rug")))));

    public static final Supplier<RotatableBlock> PURPLE_RUG = RUGS.register("purple_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("purple_rug")))));

    public static final Supplier<RotatableBlock> MAGENTA_RUG = RUGS.register("magenta_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("magenta_rug")))));

    public static final Supplier<RotatableBlock> PINK_RUG = RUGS.register("pink_rug",
            () -> new RotatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CARPET)
            .setId(ResourceKey.create(Registries.BLOCK, LYIVXsFurnitureMod.createResourceLocation("pink_rug")))));

    ////////////////////////////////////// TEDDYS ////////////////////////////////////

    //////////////////////////////////// STACKABLES ////////////////////////////////////

    ////////////////////////////////////// GRAVES ////////////////////////////////////


}

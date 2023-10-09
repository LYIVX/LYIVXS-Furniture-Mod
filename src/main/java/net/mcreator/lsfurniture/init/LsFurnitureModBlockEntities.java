
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lsfurniture.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.lsfurniture.block.entity.WarpedWardrobeTileEntity;
import net.mcreator.lsfurniture.block.entity.WarpedWardrobe2TileEntity;
import net.mcreator.lsfurniture.block.entity.WarpedWardrobe1TileEntity;
import net.mcreator.lsfurniture.block.entity.WarpedTableStraightBlockEntity;
import net.mcreator.lsfurniture.block.entity.WarpedTableNoneBlockEntity;
import net.mcreator.lsfurniture.block.entity.WarpedTableJunctionBlockEntity;
import net.mcreator.lsfurniture.block.entity.WarpedTableEndBlockEntity;
import net.mcreator.lsfurniture.block.entity.WarpedTableCrossBlockEntity;
import net.mcreator.lsfurniture.block.entity.WarpedTableCornerBlockEntity;
import net.mcreator.lsfurniture.block.entity.WarpedSinkTileEntity;
import net.mcreator.lsfurniture.block.entity.WarpedShelveBlockEntity;
import net.mcreator.lsfurniture.block.entity.WarpedOvenTileEntity;
import net.mcreator.lsfurniture.block.entity.WarpedMailBoxBlockEntity;
import net.mcreator.lsfurniture.block.entity.WarpedDrawerTileEntity;
import net.mcreator.lsfurniture.block.entity.WarpedDeskTileEntity;
import net.mcreator.lsfurniture.block.entity.WarpedCupboardTileEntity;
import net.mcreator.lsfurniture.block.entity.WarpedCounterTileEntity;
import net.mcreator.lsfurniture.block.entity.ToasterTileEntity;
import net.mcreator.lsfurniture.block.entity.TableStraightBlockEntity;
import net.mcreator.lsfurniture.block.entity.TableNoneBlockEntity;
import net.mcreator.lsfurniture.block.entity.TableJunctionBlockEntity;
import net.mcreator.lsfurniture.block.entity.TableEndBlockEntity;
import net.mcreator.lsfurniture.block.entity.TableCrossBlockEntity;
import net.mcreator.lsfurniture.block.entity.TableCornerBlockEntity;
import net.mcreator.lsfurniture.block.entity.SprucewardrobeTileEntity;
import net.mcreator.lsfurniture.block.entity.SpruceWardrobe2TileEntity;
import net.mcreator.lsfurniture.block.entity.SpruceWardrobe1TileEntity;
import net.mcreator.lsfurniture.block.entity.SpruceTableStraightBlockEntity;
import net.mcreator.lsfurniture.block.entity.SpruceTableNoneBlockEntity;
import net.mcreator.lsfurniture.block.entity.SpruceTableJunctionBlockEntity;
import net.mcreator.lsfurniture.block.entity.SpruceTableEndBlockEntity;
import net.mcreator.lsfurniture.block.entity.SpruceTableCrossBlockEntity;
import net.mcreator.lsfurniture.block.entity.SpruceTableCornerBlockEntity;
import net.mcreator.lsfurniture.block.entity.SpruceSinkTileEntity;
import net.mcreator.lsfurniture.block.entity.SpruceShelveBlockEntity;
import net.mcreator.lsfurniture.block.entity.SpruceOvenTileEntity;
import net.mcreator.lsfurniture.block.entity.SpruceMailBoxBlockEntity;
import net.mcreator.lsfurniture.block.entity.SpruceDrawerTileEntity;
import net.mcreator.lsfurniture.block.entity.SpruceDeskTileEntity;
import net.mcreator.lsfurniture.block.entity.SpruceCupboardTileEntity;
import net.mcreator.lsfurniture.block.entity.SpruceCounterTileEntity;
import net.mcreator.lsfurniture.block.entity.OakWardrobe2TileEntity;
import net.mcreator.lsfurniture.block.entity.OakWardrobe1TileEntity;
import net.mcreator.lsfurniture.block.entity.OakWardrobe0TileEntity;
import net.mcreator.lsfurniture.block.entity.OakSinkTileEntity;
import net.mcreator.lsfurniture.block.entity.OakShelveBlockEntity;
import net.mcreator.lsfurniture.block.entity.OakOvenTileEntity;
import net.mcreator.lsfurniture.block.entity.OakMailBoxBlockEntity;
import net.mcreator.lsfurniture.block.entity.OakDrawerTileEntity;
import net.mcreator.lsfurniture.block.entity.OakDeskTileEntity;
import net.mcreator.lsfurniture.block.entity.OakCupboardTileEntity;
import net.mcreator.lsfurniture.block.entity.OakCounterTileEntity;
import net.mcreator.lsfurniture.block.entity.MicrowaveTileEntity;
import net.mcreator.lsfurniture.block.entity.MangroveWardrobeTileEntity;
import net.mcreator.lsfurniture.block.entity.MangroveWardrobe2TileEntity;
import net.mcreator.lsfurniture.block.entity.MangroveWardrobe1TileEntity;
import net.mcreator.lsfurniture.block.entity.MangroveTableStraightBlockEntity;
import net.mcreator.lsfurniture.block.entity.MangroveTableNoneBlockEntity;
import net.mcreator.lsfurniture.block.entity.MangroveTableJunctionBlockEntity;
import net.mcreator.lsfurniture.block.entity.MangroveTableEndBlockEntity;
import net.mcreator.lsfurniture.block.entity.MangroveTableCrossBlockEntity;
import net.mcreator.lsfurniture.block.entity.MangroveTableCornerBlockEntity;
import net.mcreator.lsfurniture.block.entity.MangroveSinkTileEntity;
import net.mcreator.lsfurniture.block.entity.MangroveShelveBlockEntity;
import net.mcreator.lsfurniture.block.entity.MangroveOvenTileEntity;
import net.mcreator.lsfurniture.block.entity.MangroveMailBoxBlockEntity;
import net.mcreator.lsfurniture.block.entity.MangroveDrawerTileEntity;
import net.mcreator.lsfurniture.block.entity.MangroveDeskTileEntity;
import net.mcreator.lsfurniture.block.entity.MangroveCupboardTileEntity;
import net.mcreator.lsfurniture.block.entity.MangroveCounterTileEntity;
import net.mcreator.lsfurniture.block.entity.KettleTileEntity;
import net.mcreator.lsfurniture.block.entity.JungleWardrobeTileEntity;
import net.mcreator.lsfurniture.block.entity.JungleWardrobe2TileEntity;
import net.mcreator.lsfurniture.block.entity.JungleWardrobe1TileEntity;
import net.mcreator.lsfurniture.block.entity.JungleTableStraightBlockEntity;
import net.mcreator.lsfurniture.block.entity.JungleTableNoneBlockEntity;
import net.mcreator.lsfurniture.block.entity.JungleTableJunctionBlockEntity;
import net.mcreator.lsfurniture.block.entity.JungleTableEndBlockEntity;
import net.mcreator.lsfurniture.block.entity.JungleTableCrossBlockEntity;
import net.mcreator.lsfurniture.block.entity.JungleTableCornerBlockEntity;
import net.mcreator.lsfurniture.block.entity.JungleSinkTileEntity;
import net.mcreator.lsfurniture.block.entity.JungleShelveBlockEntity;
import net.mcreator.lsfurniture.block.entity.JungleOvenTileEntity;
import net.mcreator.lsfurniture.block.entity.JungleMailBoxBlockEntity;
import net.mcreator.lsfurniture.block.entity.JungleDrawerTileEntity;
import net.mcreator.lsfurniture.block.entity.JungleDeskTileEntity;
import net.mcreator.lsfurniture.block.entity.JungleCupboardTileEntity;
import net.mcreator.lsfurniture.block.entity.JungleCounterTileEntity;
import net.mcreator.lsfurniture.block.entity.IronStraightBlockEntity;
import net.mcreator.lsfurniture.block.entity.IronNoneBlockEntity;
import net.mcreator.lsfurniture.block.entity.IronJunctionBlockEntity;
import net.mcreator.lsfurniture.block.entity.IronEndBlockEntity;
import net.mcreator.lsfurniture.block.entity.IronCrossBlockEntity;
import net.mcreator.lsfurniture.block.entity.IronCornerBlockEntity;
import net.mcreator.lsfurniture.block.entity.FurnitureCrafterBetaTileEntity;
import net.mcreator.lsfurniture.block.entity.FridgeFreezerBlockTileEntity;
import net.mcreator.lsfurniture.block.entity.FridgeFreezerBlock2TileEntity;
import net.mcreator.lsfurniture.block.entity.FridgeFreezerBlock1TileEntity;
import net.mcreator.lsfurniture.block.entity.Darkoakwardrobe2TileEntity;
import net.mcreator.lsfurniture.block.entity.Darkoakwardrobe1TileEntity;
import net.mcreator.lsfurniture.block.entity.Darkoakwardrobe0TileEntity;
import net.mcreator.lsfurniture.block.entity.DarkoakDeskTileEntity;
import net.mcreator.lsfurniture.block.entity.DarkOakTableStraightBlockEntity;
import net.mcreator.lsfurniture.block.entity.DarkOakTableNoneBlockEntity;
import net.mcreator.lsfurniture.block.entity.DarkOakTableJunctionBlockEntity;
import net.mcreator.lsfurniture.block.entity.DarkOakTableEndBlockEntity;
import net.mcreator.lsfurniture.block.entity.DarkOakTableCrossBlockEntity;
import net.mcreator.lsfurniture.block.entity.DarkOakTableCornerBlockEntity;
import net.mcreator.lsfurniture.block.entity.DarkOakSinkTileEntity;
import net.mcreator.lsfurniture.block.entity.DarkOakShelveBlockEntity;
import net.mcreator.lsfurniture.block.entity.DarkOakOvenTileEntity;
import net.mcreator.lsfurniture.block.entity.DarkOakMailBoxBlockEntity;
import net.mcreator.lsfurniture.block.entity.DarkOakDrawerTileEntity;
import net.mcreator.lsfurniture.block.entity.DarkOakCupboardTileEntity;
import net.mcreator.lsfurniture.block.entity.DarkOakCounterTileEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonWardrobeTileEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonWardrobe2TileEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonWardrobe1TileEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonTableStraightBlockEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonTableNoneBlockEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonTableJunctionBlockEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonTableEndBlockEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonTableCrossBlockEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonTableCornerBlockEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonSinkTileEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonShelveBlockEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonOvenTileEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonMailBoxBlockEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonDrawerTileEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonDeskTileEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonCupboardTileEntity;
import net.mcreator.lsfurniture.block.entity.CrimsonCounterTileEntity;
import net.mcreator.lsfurniture.block.entity.BirchWardrobeTileEntity;
import net.mcreator.lsfurniture.block.entity.BirchWardrobe2TileEntity;
import net.mcreator.lsfurniture.block.entity.BirchWardrobe1TileEntity;
import net.mcreator.lsfurniture.block.entity.BirchTableStraightBlockEntity;
import net.mcreator.lsfurniture.block.entity.BirchTableNoneBlockEntity;
import net.mcreator.lsfurniture.block.entity.BirchTableJunctionBlockEntity;
import net.mcreator.lsfurniture.block.entity.BirchTableEndBlockEntity;
import net.mcreator.lsfurniture.block.entity.BirchTableCrossBlockEntity;
import net.mcreator.lsfurniture.block.entity.BirchTableCornerBlockEntity;
import net.mcreator.lsfurniture.block.entity.BirchSinkTileEntity;
import net.mcreator.lsfurniture.block.entity.BirchShelveBlockEntity;
import net.mcreator.lsfurniture.block.entity.BirchOvenTileEntity;
import net.mcreator.lsfurniture.block.entity.BirchMailBoxBlockEntity;
import net.mcreator.lsfurniture.block.entity.BirchDrawerTileEntity;
import net.mcreator.lsfurniture.block.entity.BirchDeskTileEntity;
import net.mcreator.lsfurniture.block.entity.BirchCupboardTileEntity;
import net.mcreator.lsfurniture.block.entity.BirchCounterTileEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaWardrobeTileEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaWardrobe2TileEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaWardrobe1TileEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaTableStraightBlockEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaTableNoneBlockEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaTableJunctionBlockEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaTableEndBlockEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaTableCrossBlockEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaTableCornerBlockEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaSinkTileEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaShelveBlockEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaOvenTileEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaMailBoxBlockEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaDrawerTileEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaDeskTileEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaCupboardTileEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaCounterTileEntity;
import net.mcreator.lsfurniture.block.entity.AcaciaChairBlockEntity;
import net.mcreator.lsfurniture.LsFurnitureMod;

public class LsFurnitureModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, LsFurnitureMod.MODID);
	public static final RegistryObject<BlockEntityType<FurnitureCrafterBetaTileEntity>> FURNITURE_CRAFTER_BETA = REGISTRY.register("furniture_crafter_beta",
			() -> BlockEntityType.Builder.of(FurnitureCrafterBetaTileEntity::new, LsFurnitureModBlocks.FURNITURE_CRAFTER_BETA.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> ACACIA_CHAIR = register("acacia_chair", LsFurnitureModBlocks.ACACIA_CHAIR, AcaciaChairBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TABLE_NONE = register("table_none", LsFurnitureModBlocks.TABLE_NONE, TableNoneBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DARK_OAK_TABLE_NONE = register("dark_oak_table_none", LsFurnitureModBlocks.DARK_OAK_TABLE_NONE, DarkOakTableNoneBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPRUCE_TABLE_NONE = register("spruce_table_none", LsFurnitureModBlocks.SPRUCE_TABLE_NONE, SpruceTableNoneBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ACACIA_TABLE_NONE = register("acacia_table_none", LsFurnitureModBlocks.ACACIA_TABLE_NONE, AcaciaTableNoneBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BIRCH_TABLE_NONE = register("birch_table_none", LsFurnitureModBlocks.BIRCH_TABLE_NONE, BirchTableNoneBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> JUNGLE_TABLE_NONE = register("jungle_table_none", LsFurnitureModBlocks.JUNGLE_TABLE_NONE, JungleTableNoneBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MANGROVE_TABLE_NONE = register("mangrove_table_none", LsFurnitureModBlocks.MANGROVE_TABLE_NONE, MangroveTableNoneBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CRIMSON_TABLE_NONE = register("crimson_table_none", LsFurnitureModBlocks.CRIMSON_TABLE_NONE, CrimsonTableNoneBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WARPED_TABLE_NONE = register("warped_table_none", LsFurnitureModBlocks.WARPED_TABLE_NONE, WarpedTableNoneBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IRON_NONE = register("iron_none", LsFurnitureModBlocks.IRON_NONE, IronNoneBlockEntity::new);
	public static final RegistryObject<BlockEntityType<OakWardrobe0TileEntity>> OAK_WARDROBE_0 = REGISTRY.register("oak_wardrobe_0",
			() -> BlockEntityType.Builder.of(OakWardrobe0TileEntity::new, LsFurnitureModBlocks.OAK_WARDROBE_0.get()).build(null));
	public static final RegistryObject<BlockEntityType<Darkoakwardrobe0TileEntity>> DARKOAKWARDROBE_0 = REGISTRY.register("darkoakwardrobe_0",
			() -> BlockEntityType.Builder.of(Darkoakwardrobe0TileEntity::new, LsFurnitureModBlocks.DARKOAKWARDROBE_0.get()).build(null));
	public static final RegistryObject<BlockEntityType<SprucewardrobeTileEntity>> SPRUCEWARDROBE = REGISTRY.register("sprucewardrobe",
			() -> BlockEntityType.Builder.of(SprucewardrobeTileEntity::new, LsFurnitureModBlocks.SPRUCEWARDROBE.get()).build(null));
	public static final RegistryObject<BlockEntityType<AcaciaWardrobeTileEntity>> ACACIA_WARDROBE = REGISTRY.register("acacia_wardrobe",
			() -> BlockEntityType.Builder.of(AcaciaWardrobeTileEntity::new, LsFurnitureModBlocks.ACACIA_WARDROBE.get()).build(null));
	public static final RegistryObject<BlockEntityType<BirchWardrobeTileEntity>> BIRCH_WARDROBE = REGISTRY.register("birch_wardrobe",
			() -> BlockEntityType.Builder.of(BirchWardrobeTileEntity::new, LsFurnitureModBlocks.BIRCH_WARDROBE.get()).build(null));
	public static final RegistryObject<BlockEntityType<JungleWardrobeTileEntity>> JUNGLE_WARDROBE = REGISTRY.register("jungle_wardrobe",
			() -> BlockEntityType.Builder.of(JungleWardrobeTileEntity::new, LsFurnitureModBlocks.JUNGLE_WARDROBE.get()).build(null));
	public static final RegistryObject<BlockEntityType<MangroveWardrobeTileEntity>> MANGROVE_WARDROBE = REGISTRY.register("mangrove_wardrobe",
			() -> BlockEntityType.Builder.of(MangroveWardrobeTileEntity::new, LsFurnitureModBlocks.MANGROVE_WARDROBE.get()).build(null));
	public static final RegistryObject<BlockEntityType<CrimsonWardrobeTileEntity>> CRIMSON_WARDROBE = REGISTRY.register("crimson_wardrobe",
			() -> BlockEntityType.Builder.of(CrimsonWardrobeTileEntity::new, LsFurnitureModBlocks.CRIMSON_WARDROBE.get()).build(null));
	public static final RegistryObject<BlockEntityType<WarpedWardrobeTileEntity>> WARPED_WARDROBE = REGISTRY.register("warped_wardrobe",
			() -> BlockEntityType.Builder.of(WarpedWardrobeTileEntity::new, LsFurnitureModBlocks.WARPED_WARDROBE.get()).build(null));
	public static final RegistryObject<BlockEntityType<OakDeskTileEntity>> OAK_DESK = REGISTRY.register("oak_desk", () -> BlockEntityType.Builder.of(OakDeskTileEntity::new, LsFurnitureModBlocks.OAK_DESK.get()).build(null));
	public static final RegistryObject<BlockEntityType<DarkoakDeskTileEntity>> DARKOAK_DESK = REGISTRY.register("darkoak_desk", () -> BlockEntityType.Builder.of(DarkoakDeskTileEntity::new, LsFurnitureModBlocks.DARKOAK_DESK.get()).build(null));
	public static final RegistryObject<BlockEntityType<SpruceDeskTileEntity>> SPRUCE_DESK = REGISTRY.register("spruce_desk", () -> BlockEntityType.Builder.of(SpruceDeskTileEntity::new, LsFurnitureModBlocks.SPRUCE_DESK.get()).build(null));
	public static final RegistryObject<BlockEntityType<AcaciaDeskTileEntity>> ACACIA_DESK = REGISTRY.register("acacia_desk", () -> BlockEntityType.Builder.of(AcaciaDeskTileEntity::new, LsFurnitureModBlocks.ACACIA_DESK.get()).build(null));
	public static final RegistryObject<BlockEntityType<BirchDeskTileEntity>> BIRCH_DESK = REGISTRY.register("birch_desk", () -> BlockEntityType.Builder.of(BirchDeskTileEntity::new, LsFurnitureModBlocks.BIRCH_DESK.get()).build(null));
	public static final RegistryObject<BlockEntityType<JungleDeskTileEntity>> JUNGLE_DESK = REGISTRY.register("jungle_desk", () -> BlockEntityType.Builder.of(JungleDeskTileEntity::new, LsFurnitureModBlocks.JUNGLE_DESK.get()).build(null));
	public static final RegistryObject<BlockEntityType<MangroveDeskTileEntity>> MANGROVE_DESK = REGISTRY.register("mangrove_desk", () -> BlockEntityType.Builder.of(MangroveDeskTileEntity::new, LsFurnitureModBlocks.MANGROVE_DESK.get()).build(null));
	public static final RegistryObject<BlockEntityType<CrimsonDeskTileEntity>> CRIMSON_DESK = REGISTRY.register("crimson_desk", () -> BlockEntityType.Builder.of(CrimsonDeskTileEntity::new, LsFurnitureModBlocks.CRIMSON_DESK.get()).build(null));
	public static final RegistryObject<BlockEntityType<WarpedDeskTileEntity>> WARPED_DESK = REGISTRY.register("warped_desk", () -> BlockEntityType.Builder.of(WarpedDeskTileEntity::new, LsFurnitureModBlocks.WARPED_DESK.get()).build(null));
	public static final RegistryObject<BlockEntityType<OakDrawerTileEntity>> OAK_DRAWER = REGISTRY.register("oak_drawer", () -> BlockEntityType.Builder.of(OakDrawerTileEntity::new, LsFurnitureModBlocks.OAK_DRAWER.get()).build(null));
	public static final RegistryObject<BlockEntityType<DarkOakDrawerTileEntity>> DARK_OAK_DRAWER = REGISTRY.register("dark_oak_drawer",
			() -> BlockEntityType.Builder.of(DarkOakDrawerTileEntity::new, LsFurnitureModBlocks.DARK_OAK_DRAWER.get()).build(null));
	public static final RegistryObject<BlockEntityType<SpruceDrawerTileEntity>> SPRUCE_DRAWER = REGISTRY.register("spruce_drawer", () -> BlockEntityType.Builder.of(SpruceDrawerTileEntity::new, LsFurnitureModBlocks.SPRUCE_DRAWER.get()).build(null));
	public static final RegistryObject<BlockEntityType<AcaciaDrawerTileEntity>> ACACIA_DRAWER = REGISTRY.register("acacia_drawer", () -> BlockEntityType.Builder.of(AcaciaDrawerTileEntity::new, LsFurnitureModBlocks.ACACIA_DRAWER.get()).build(null));
	public static final RegistryObject<BlockEntityType<BirchDrawerTileEntity>> BIRCH_DRAWER = REGISTRY.register("birch_drawer", () -> BlockEntityType.Builder.of(BirchDrawerTileEntity::new, LsFurnitureModBlocks.BIRCH_DRAWER.get()).build(null));
	public static final RegistryObject<BlockEntityType<JungleDrawerTileEntity>> JUNGLE_DRAWER = REGISTRY.register("jungle_drawer", () -> BlockEntityType.Builder.of(JungleDrawerTileEntity::new, LsFurnitureModBlocks.JUNGLE_DRAWER.get()).build(null));
	public static final RegistryObject<BlockEntityType<MangroveDrawerTileEntity>> MANGROVE_DRAWER = REGISTRY.register("mangrove_drawer",
			() -> BlockEntityType.Builder.of(MangroveDrawerTileEntity::new, LsFurnitureModBlocks.MANGROVE_DRAWER.get()).build(null));
	public static final RegistryObject<BlockEntityType<CrimsonDrawerTileEntity>> CRIMSON_DRAWER = REGISTRY.register("crimson_drawer",
			() -> BlockEntityType.Builder.of(CrimsonDrawerTileEntity::new, LsFurnitureModBlocks.CRIMSON_DRAWER.get()).build(null));
	public static final RegistryObject<BlockEntityType<WarpedDrawerTileEntity>> WARPED_DRAWER = REGISTRY.register("warped_drawer", () -> BlockEntityType.Builder.of(WarpedDrawerTileEntity::new, LsFurnitureModBlocks.WARPED_DRAWER.get()).build(null));
	public static final RegistryObject<BlockEntityType<OakCounterTileEntity>> OAK_COUNTER = REGISTRY.register("oak_counter", () -> BlockEntityType.Builder.of(OakCounterTileEntity::new, LsFurnitureModBlocks.OAK_COUNTER.get()).build(null));
	public static final RegistryObject<BlockEntityType<DarkOakCounterTileEntity>> DARK_OAK_COUNTER = REGISTRY.register("dark_oak_counter",
			() -> BlockEntityType.Builder.of(DarkOakCounterTileEntity::new, LsFurnitureModBlocks.DARK_OAK_COUNTER.get()).build(null));
	public static final RegistryObject<BlockEntityType<SpruceCounterTileEntity>> SPRUCE_COUNTER = REGISTRY.register("spruce_counter",
			() -> BlockEntityType.Builder.of(SpruceCounterTileEntity::new, LsFurnitureModBlocks.SPRUCE_COUNTER.get()).build(null));
	public static final RegistryObject<BlockEntityType<AcaciaCounterTileEntity>> ACACIA_COUNTER = REGISTRY.register("acacia_counter",
			() -> BlockEntityType.Builder.of(AcaciaCounterTileEntity::new, LsFurnitureModBlocks.ACACIA_COUNTER.get()).build(null));
	public static final RegistryObject<BlockEntityType<BirchCounterTileEntity>> BIRCH_COUNTER = REGISTRY.register("birch_counter", () -> BlockEntityType.Builder.of(BirchCounterTileEntity::new, LsFurnitureModBlocks.BIRCH_COUNTER.get()).build(null));
	public static final RegistryObject<BlockEntityType<JungleCounterTileEntity>> JUNGLE_COUNTER = REGISTRY.register("jungle_counter",
			() -> BlockEntityType.Builder.of(JungleCounterTileEntity::new, LsFurnitureModBlocks.JUNGLE_COUNTER.get()).build(null));
	public static final RegistryObject<BlockEntityType<MangroveCounterTileEntity>> MANGROVE_COUNTER = REGISTRY.register("mangrove_counter",
			() -> BlockEntityType.Builder.of(MangroveCounterTileEntity::new, LsFurnitureModBlocks.MANGROVE_COUNTER.get()).build(null));
	public static final RegistryObject<BlockEntityType<CrimsonCounterTileEntity>> CRIMSON_COUNTER = REGISTRY.register("crimson_counter",
			() -> BlockEntityType.Builder.of(CrimsonCounterTileEntity::new, LsFurnitureModBlocks.CRIMSON_COUNTER.get()).build(null));
	public static final RegistryObject<BlockEntityType<WarpedCounterTileEntity>> WARPED_COUNTER = REGISTRY.register("warped_counter",
			() -> BlockEntityType.Builder.of(WarpedCounterTileEntity::new, LsFurnitureModBlocks.WARPED_COUNTER.get()).build(null));
	public static final RegistryObject<BlockEntityType<OakSinkTileEntity>> OAK_SINK = REGISTRY.register("oak_sink", () -> BlockEntityType.Builder.of(OakSinkTileEntity::new, LsFurnitureModBlocks.OAK_SINK.get()).build(null));
	public static final RegistryObject<BlockEntityType<DarkOakSinkTileEntity>> DARK_OAK_SINK = REGISTRY.register("dark_oak_sink", () -> BlockEntityType.Builder.of(DarkOakSinkTileEntity::new, LsFurnitureModBlocks.DARK_OAK_SINK.get()).build(null));
	public static final RegistryObject<BlockEntityType<SpruceSinkTileEntity>> SPRUCE_SINK = REGISTRY.register("spruce_sink", () -> BlockEntityType.Builder.of(SpruceSinkTileEntity::new, LsFurnitureModBlocks.SPRUCE_SINK.get()).build(null));
	public static final RegistryObject<BlockEntityType<AcaciaSinkTileEntity>> ACACIA_SINK = REGISTRY.register("acacia_sink", () -> BlockEntityType.Builder.of(AcaciaSinkTileEntity::new, LsFurnitureModBlocks.ACACIA_SINK.get()).build(null));
	public static final RegistryObject<BlockEntityType<BirchSinkTileEntity>> BIRCH_SINK = REGISTRY.register("birch_sink", () -> BlockEntityType.Builder.of(BirchSinkTileEntity::new, LsFurnitureModBlocks.BIRCH_SINK.get()).build(null));
	public static final RegistryObject<BlockEntityType<JungleSinkTileEntity>> JUNGLE_SINK = REGISTRY.register("jungle_sink", () -> BlockEntityType.Builder.of(JungleSinkTileEntity::new, LsFurnitureModBlocks.JUNGLE_SINK.get()).build(null));
	public static final RegistryObject<BlockEntityType<MangroveSinkTileEntity>> MANGROVE_SINK = REGISTRY.register("mangrove_sink", () -> BlockEntityType.Builder.of(MangroveSinkTileEntity::new, LsFurnitureModBlocks.MANGROVE_SINK.get()).build(null));
	public static final RegistryObject<BlockEntityType<CrimsonSinkTileEntity>> CRIMSON_SINK = REGISTRY.register("crimson_sink", () -> BlockEntityType.Builder.of(CrimsonSinkTileEntity::new, LsFurnitureModBlocks.CRIMSON_SINK.get()).build(null));
	public static final RegistryObject<BlockEntityType<WarpedSinkTileEntity>> WARPED_SINK = REGISTRY.register("warped_sink", () -> BlockEntityType.Builder.of(WarpedSinkTileEntity::new, LsFurnitureModBlocks.WARPED_SINK.get()).build(null));
	public static final RegistryObject<BlockEntityType<OakOvenTileEntity>> OAK_OVEN = REGISTRY.register("oak_oven", () -> BlockEntityType.Builder.of(OakOvenTileEntity::new, LsFurnitureModBlocks.OAK_OVEN.get()).build(null));
	public static final RegistryObject<BlockEntityType<DarkOakOvenTileEntity>> DARK_OAK_OVEN = REGISTRY.register("dark_oak_oven", () -> BlockEntityType.Builder.of(DarkOakOvenTileEntity::new, LsFurnitureModBlocks.DARK_OAK_OVEN.get()).build(null));
	public static final RegistryObject<BlockEntityType<SpruceOvenTileEntity>> SPRUCE_OVEN = REGISTRY.register("spruce_oven", () -> BlockEntityType.Builder.of(SpruceOvenTileEntity::new, LsFurnitureModBlocks.SPRUCE_OVEN.get()).build(null));
	public static final RegistryObject<BlockEntityType<AcaciaOvenTileEntity>> ACACIA_OVEN = REGISTRY.register("acacia_oven", () -> BlockEntityType.Builder.of(AcaciaOvenTileEntity::new, LsFurnitureModBlocks.ACACIA_OVEN.get()).build(null));
	public static final RegistryObject<BlockEntityType<BirchOvenTileEntity>> BIRCH_OVEN = REGISTRY.register("birch_oven", () -> BlockEntityType.Builder.of(BirchOvenTileEntity::new, LsFurnitureModBlocks.BIRCH_OVEN.get()).build(null));
	public static final RegistryObject<BlockEntityType<JungleOvenTileEntity>> JUNGLE_OVEN = REGISTRY.register("jungle_oven", () -> BlockEntityType.Builder.of(JungleOvenTileEntity::new, LsFurnitureModBlocks.JUNGLE_OVEN.get()).build(null));
	public static final RegistryObject<BlockEntityType<MangroveOvenTileEntity>> MANGROVE_OVEN = REGISTRY.register("mangrove_oven", () -> BlockEntityType.Builder.of(MangroveOvenTileEntity::new, LsFurnitureModBlocks.MANGROVE_OVEN.get()).build(null));
	public static final RegistryObject<BlockEntityType<WarpedOvenTileEntity>> WARPED_OVEN = REGISTRY.register("warped_oven", () -> BlockEntityType.Builder.of(WarpedOvenTileEntity::new, LsFurnitureModBlocks.WARPED_OVEN.get()).build(null));
	public static final RegistryObject<BlockEntityType<CrimsonOvenTileEntity>> CRIMSON_OVEN = REGISTRY.register("crimson_oven", () -> BlockEntityType.Builder.of(CrimsonOvenTileEntity::new, LsFurnitureModBlocks.CRIMSON_OVEN.get()).build(null));
	public static final RegistryObject<BlockEntityType<OakCupboardTileEntity>> OAK_CUPBOARD = REGISTRY.register("oak_cupboard", () -> BlockEntityType.Builder.of(OakCupboardTileEntity::new, LsFurnitureModBlocks.OAK_CUPBOARD.get()).build(null));
	public static final RegistryObject<BlockEntityType<DarkOakCupboardTileEntity>> DARK_OAK_CUPBOARD = REGISTRY.register("dark_oak_cupboard",
			() -> BlockEntityType.Builder.of(DarkOakCupboardTileEntity::new, LsFurnitureModBlocks.DARK_OAK_CUPBOARD.get()).build(null));
	public static final RegistryObject<BlockEntityType<AcaciaCupboardTileEntity>> ACACIA_CUPBOARD = REGISTRY.register("acacia_cupboard",
			() -> BlockEntityType.Builder.of(AcaciaCupboardTileEntity::new, LsFurnitureModBlocks.ACACIA_CUPBOARD.get()).build(null));
	public static final RegistryObject<BlockEntityType<SpruceCupboardTileEntity>> SPRUCE_CUPBOARD = REGISTRY.register("spruce_cupboard",
			() -> BlockEntityType.Builder.of(SpruceCupboardTileEntity::new, LsFurnitureModBlocks.SPRUCE_CUPBOARD.get()).build(null));
	public static final RegistryObject<BlockEntityType<BirchCupboardTileEntity>> BIRCH_CUPBOARD = REGISTRY.register("birch_cupboard",
			() -> BlockEntityType.Builder.of(BirchCupboardTileEntity::new, LsFurnitureModBlocks.BIRCH_CUPBOARD.get()).build(null));
	public static final RegistryObject<BlockEntityType<JungleCupboardTileEntity>> JUNGLE_CUPBOARD = REGISTRY.register("jungle_cupboard",
			() -> BlockEntityType.Builder.of(JungleCupboardTileEntity::new, LsFurnitureModBlocks.JUNGLE_CUPBOARD.get()).build(null));
	public static final RegistryObject<BlockEntityType<MangroveCupboardTileEntity>> MANGROVE_CUPBOARD = REGISTRY.register("mangrove_cupboard",
			() -> BlockEntityType.Builder.of(MangroveCupboardTileEntity::new, LsFurnitureModBlocks.MANGROVE_CUPBOARD.get()).build(null));
	public static final RegistryObject<BlockEntityType<CrimsonCupboardTileEntity>> CRIMSON_CUPBOARD = REGISTRY.register("crimson_cupboard",
			() -> BlockEntityType.Builder.of(CrimsonCupboardTileEntity::new, LsFurnitureModBlocks.CRIMSON_CUPBOARD.get()).build(null));
	public static final RegistryObject<BlockEntityType<WarpedCupboardTileEntity>> WARPED_CUPBOARD = REGISTRY.register("warped_cupboard",
			() -> BlockEntityType.Builder.of(WarpedCupboardTileEntity::new, LsFurnitureModBlocks.WARPED_CUPBOARD.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> OAK_SHELVE = register("oak_shelve", LsFurnitureModBlocks.OAK_SHELVE, OakShelveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DARK_OAK_SHELVE = register("dark_oak_shelve", LsFurnitureModBlocks.DARK_OAK_SHELVE, DarkOakShelveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPRUCE_SHELVE = register("spruce_shelve", LsFurnitureModBlocks.SPRUCE_SHELVE, SpruceShelveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ACACIA_SHELVE = register("acacia_shelve", LsFurnitureModBlocks.ACACIA_SHELVE, AcaciaShelveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BIRCH_SHELVE = register("birch_shelve", LsFurnitureModBlocks.BIRCH_SHELVE, BirchShelveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> JUNGLE_SHELVE = register("jungle_shelve", LsFurnitureModBlocks.JUNGLE_SHELVE, JungleShelveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MANGROVE_SHELVE = register("mangrove_shelve", LsFurnitureModBlocks.MANGROVE_SHELVE, MangroveShelveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CRIMSON_SHELVE = register("crimson_shelve", LsFurnitureModBlocks.CRIMSON_SHELVE, CrimsonShelveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WARPED_SHELVE = register("warped_shelve", LsFurnitureModBlocks.WARPED_SHELVE, WarpedShelveBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> OAK_MAIL_BOX = register("oak_mail_box", LsFurnitureModBlocks.OAK_MAIL_BOX, OakMailBoxBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DARK_OAK_MAIL_BOX = register("dark_oak_mail_box", LsFurnitureModBlocks.DARK_OAK_MAIL_BOX, DarkOakMailBoxBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPRUCE_MAIL_BOX = register("spruce_mail_box", LsFurnitureModBlocks.SPRUCE_MAIL_BOX, SpruceMailBoxBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ACACIA_MAIL_BOX = register("acacia_mail_box", LsFurnitureModBlocks.ACACIA_MAIL_BOX, AcaciaMailBoxBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BIRCH_MAIL_BOX = register("birch_mail_box", LsFurnitureModBlocks.BIRCH_MAIL_BOX, BirchMailBoxBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> JUNGLE_MAIL_BOX = register("jungle_mail_box", LsFurnitureModBlocks.JUNGLE_MAIL_BOX, JungleMailBoxBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MANGROVE_MAIL_BOX = register("mangrove_mail_box", LsFurnitureModBlocks.MANGROVE_MAIL_BOX, MangroveMailBoxBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CRIMSON_MAIL_BOX = register("crimson_mail_box", LsFurnitureModBlocks.CRIMSON_MAIL_BOX, CrimsonMailBoxBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WARPED_MAIL_BOX = register("warped_mail_box", LsFurnitureModBlocks.WARPED_MAIL_BOX, WarpedMailBoxBlockEntity::new);
	public static final RegistryObject<BlockEntityType<FridgeFreezerBlockTileEntity>> FRIDGE_FREEZER_BLOCK = REGISTRY.register("fridge_freezer_block",
			() -> BlockEntityType.Builder.of(FridgeFreezerBlockTileEntity::new, LsFurnitureModBlocks.FRIDGE_FREEZER_BLOCK.get()).build(null));
	public static final RegistryObject<BlockEntityType<MicrowaveTileEntity>> MICROWAVE = REGISTRY.register("microwave", () -> BlockEntityType.Builder.of(MicrowaveTileEntity::new, LsFurnitureModBlocks.MICROWAVE.get()).build(null));
	public static final RegistryObject<BlockEntityType<KettleTileEntity>> KETTLE = REGISTRY.register("kettle", () -> BlockEntityType.Builder.of(KettleTileEntity::new, LsFurnitureModBlocks.KETTLE.get()).build(null));
	public static final RegistryObject<BlockEntityType<ToasterTileEntity>> TOASTER = REGISTRY.register("toaster", () -> BlockEntityType.Builder.of(ToasterTileEntity::new, LsFurnitureModBlocks.TOASTER.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> TABLE_STRAIGHT = register("table_straight", LsFurnitureModBlocks.TABLE_STRAIGHT, TableStraightBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TABLE_CORNER = register("table_corner", LsFurnitureModBlocks.TABLE_CORNER, TableCornerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TABLE_JUNCTION = register("table_junction", LsFurnitureModBlocks.TABLE_JUNCTION, TableJunctionBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TABLE_CROSS = register("table_cross", LsFurnitureModBlocks.TABLE_CROSS, TableCrossBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TABLE_END = register("table_end", LsFurnitureModBlocks.TABLE_END, TableEndBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DARK_OAK_TABLE_STRAIGHT = register("dark_oak_table_straight", LsFurnitureModBlocks.DARK_OAK_TABLE_STRAIGHT, DarkOakTableStraightBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DARK_OAK_TABLE_CORNER = register("dark_oak_table_corner", LsFurnitureModBlocks.DARK_OAK_TABLE_CORNER, DarkOakTableCornerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DARK_OAK_TABLE_JUNCTION = register("dark_oak_table_junction", LsFurnitureModBlocks.DARK_OAK_TABLE_JUNCTION, DarkOakTableJunctionBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DARK_OAK_TABLE_CROSS = register("dark_oak_table_cross", LsFurnitureModBlocks.DARK_OAK_TABLE_CROSS, DarkOakTableCrossBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DARK_OAK_TABLE_END = register("dark_oak_table_end", LsFurnitureModBlocks.DARK_OAK_TABLE_END, DarkOakTableEndBlockEntity::new);
	public static final RegistryObject<BlockEntityType<FridgeFreezerBlock1TileEntity>> FRIDGE_FREEZER_BLOCK_1 = REGISTRY.register("fridge_freezer_block_1",
			() -> BlockEntityType.Builder.of(FridgeFreezerBlock1TileEntity::new, LsFurnitureModBlocks.FRIDGE_FREEZER_BLOCK_1.get()).build(null));
	public static final RegistryObject<BlockEntityType<FridgeFreezerBlock2TileEntity>> FRIDGE_FREEZER_BLOCK_2 = REGISTRY.register("fridge_freezer_block_2",
			() -> BlockEntityType.Builder.of(FridgeFreezerBlock2TileEntity::new, LsFurnitureModBlocks.FRIDGE_FREEZER_BLOCK_2.get()).build(null));
	public static final RegistryObject<BlockEntityType<OakWardrobe1TileEntity>> OAK_WARDROBE_1 = REGISTRY.register("oak_wardrobe_1",
			() -> BlockEntityType.Builder.of(OakWardrobe1TileEntity::new, LsFurnitureModBlocks.OAK_WARDROBE_1.get()).build(null));
	public static final RegistryObject<BlockEntityType<OakWardrobe2TileEntity>> OAK_WARDROBE_2 = REGISTRY.register("oak_wardrobe_2",
			() -> BlockEntityType.Builder.of(OakWardrobe2TileEntity::new, LsFurnitureModBlocks.OAK_WARDROBE_2.get()).build(null));
	public static final RegistryObject<BlockEntityType<Darkoakwardrobe1TileEntity>> DARKOAKWARDROBE_1 = REGISTRY.register("darkoakwardrobe_1",
			() -> BlockEntityType.Builder.of(Darkoakwardrobe1TileEntity::new, LsFurnitureModBlocks.DARKOAKWARDROBE_1.get()).build(null));
	public static final RegistryObject<BlockEntityType<Darkoakwardrobe2TileEntity>> DARKOAKWARDROBE_2 = REGISTRY.register("darkoakwardrobe_2",
			() -> BlockEntityType.Builder.of(Darkoakwardrobe2TileEntity::new, LsFurnitureModBlocks.DARKOAKWARDROBE_2.get()).build(null));
	public static final RegistryObject<BlockEntityType<SpruceWardrobe1TileEntity>> SPRUCE_WARDROBE_1 = REGISTRY.register("spruce_wardrobe_1",
			() -> BlockEntityType.Builder.of(SpruceWardrobe1TileEntity::new, LsFurnitureModBlocks.SPRUCE_WARDROBE_1.get()).build(null));
	public static final RegistryObject<BlockEntityType<SpruceWardrobe2TileEntity>> SPRUCE_WARDROBE_2 = REGISTRY.register("spruce_wardrobe_2",
			() -> BlockEntityType.Builder.of(SpruceWardrobe2TileEntity::new, LsFurnitureModBlocks.SPRUCE_WARDROBE_2.get()).build(null));
	public static final RegistryObject<BlockEntityType<AcaciaWardrobe1TileEntity>> ACACIA_WARDROBE_1 = REGISTRY.register("acacia_wardrobe_1",
			() -> BlockEntityType.Builder.of(AcaciaWardrobe1TileEntity::new, LsFurnitureModBlocks.ACACIA_WARDROBE_1.get()).build(null));
	public static final RegistryObject<BlockEntityType<AcaciaWardrobe2TileEntity>> ACACIA_WARDROBE_2 = REGISTRY.register("acacia_wardrobe_2",
			() -> BlockEntityType.Builder.of(AcaciaWardrobe2TileEntity::new, LsFurnitureModBlocks.ACACIA_WARDROBE_2.get()).build(null));
	public static final RegistryObject<BlockEntityType<BirchWardrobe1TileEntity>> BIRCH_WARDROBE_1 = REGISTRY.register("birch_wardrobe_1",
			() -> BlockEntityType.Builder.of(BirchWardrobe1TileEntity::new, LsFurnitureModBlocks.BIRCH_WARDROBE_1.get()).build(null));
	public static final RegistryObject<BlockEntityType<BirchWardrobe2TileEntity>> BIRCH_WARDROBE_2 = REGISTRY.register("birch_wardrobe_2",
			() -> BlockEntityType.Builder.of(BirchWardrobe2TileEntity::new, LsFurnitureModBlocks.BIRCH_WARDROBE_2.get()).build(null));
	public static final RegistryObject<BlockEntityType<JungleWardrobe1TileEntity>> JUNGLE_WARDROBE_1 = REGISTRY.register("jungle_wardrobe_1",
			() -> BlockEntityType.Builder.of(JungleWardrobe1TileEntity::new, LsFurnitureModBlocks.JUNGLE_WARDROBE_1.get()).build(null));
	public static final RegistryObject<BlockEntityType<JungleWardrobe2TileEntity>> JUNGLE_WARDROBE_2 = REGISTRY.register("jungle_wardrobe_2",
			() -> BlockEntityType.Builder.of(JungleWardrobe2TileEntity::new, LsFurnitureModBlocks.JUNGLE_WARDROBE_2.get()).build(null));
	public static final RegistryObject<BlockEntityType<MangroveWardrobe1TileEntity>> MANGROVE_WARDROBE_1 = REGISTRY.register("mangrove_wardrobe_1",
			() -> BlockEntityType.Builder.of(MangroveWardrobe1TileEntity::new, LsFurnitureModBlocks.MANGROVE_WARDROBE_1.get()).build(null));
	public static final RegistryObject<BlockEntityType<MangroveWardrobe2TileEntity>> MANGROVE_WARDROBE_2 = REGISTRY.register("mangrove_wardrobe_2",
			() -> BlockEntityType.Builder.of(MangroveWardrobe2TileEntity::new, LsFurnitureModBlocks.MANGROVE_WARDROBE_2.get()).build(null));
	public static final RegistryObject<BlockEntityType<CrimsonWardrobe1TileEntity>> CRIMSON_WARDROBE_1 = REGISTRY.register("crimson_wardrobe_1",
			() -> BlockEntityType.Builder.of(CrimsonWardrobe1TileEntity::new, LsFurnitureModBlocks.CRIMSON_WARDROBE_1.get()).build(null));
	public static final RegistryObject<BlockEntityType<CrimsonWardrobe2TileEntity>> CRIMSON_WARDROBE_2 = REGISTRY.register("crimson_wardrobe_2",
			() -> BlockEntityType.Builder.of(CrimsonWardrobe2TileEntity::new, LsFurnitureModBlocks.CRIMSON_WARDROBE_2.get()).build(null));
	public static final RegistryObject<BlockEntityType<WarpedWardrobe1TileEntity>> WARPED_WARDROBE_1 = REGISTRY.register("warped_wardrobe_1",
			() -> BlockEntityType.Builder.of(WarpedWardrobe1TileEntity::new, LsFurnitureModBlocks.WARPED_WARDROBE_1.get()).build(null));
	public static final RegistryObject<BlockEntityType<WarpedWardrobe2TileEntity>> WARPED_WARDROBE_2 = REGISTRY.register("warped_wardrobe_2",
			() -> BlockEntityType.Builder.of(WarpedWardrobe2TileEntity::new, LsFurnitureModBlocks.WARPED_WARDROBE_2.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> IRON_STRAIGHT = register("iron_straight", LsFurnitureModBlocks.IRON_STRAIGHT, IronStraightBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IRON_JUNCTION = register("iron_junction", LsFurnitureModBlocks.IRON_JUNCTION, IronJunctionBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IRON_CORNER = register("iron_corner", LsFurnitureModBlocks.IRON_CORNER, IronCornerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IRON_END = register("iron_end", LsFurnitureModBlocks.IRON_END, IronEndBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IRON_CROSS = register("iron_cross", LsFurnitureModBlocks.IRON_CROSS, IronCrossBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPRUCE_TABLE_STRAIGHT = register("spruce_table_straight", LsFurnitureModBlocks.SPRUCE_TABLE_STRAIGHT, SpruceTableStraightBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPRUCE_TABLE_CORNER = register("spruce_table_corner", LsFurnitureModBlocks.SPRUCE_TABLE_CORNER, SpruceTableCornerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPRUCE_TABLE_JUNCTION = register("spruce_table_junction", LsFurnitureModBlocks.SPRUCE_TABLE_JUNCTION, SpruceTableJunctionBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPRUCE_TABLE_CROSS = register("spruce_table_cross", LsFurnitureModBlocks.SPRUCE_TABLE_CROSS, SpruceTableCrossBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPRUCE_TABLE_END = register("spruce_table_end", LsFurnitureModBlocks.SPRUCE_TABLE_END, SpruceTableEndBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ACACIA_TABLE_STRAIGHT = register("acacia_table_straight", LsFurnitureModBlocks.ACACIA_TABLE_STRAIGHT, AcaciaTableStraightBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ACACIA_TABLE_CORNER = register("acacia_table_corner", LsFurnitureModBlocks.ACACIA_TABLE_CORNER, AcaciaTableCornerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ACACIA_TABLE_JUNCTION = register("acacia_table_junction", LsFurnitureModBlocks.ACACIA_TABLE_JUNCTION, AcaciaTableJunctionBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ACACIA_TABLE_CROSS = register("acacia_table_cross", LsFurnitureModBlocks.ACACIA_TABLE_CROSS, AcaciaTableCrossBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ACACIA_TABLE_END = register("acacia_table_end", LsFurnitureModBlocks.ACACIA_TABLE_END, AcaciaTableEndBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BIRCH_TABLE_STRAIGHT = register("birch_table_straight", LsFurnitureModBlocks.BIRCH_TABLE_STRAIGHT, BirchTableStraightBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BIRCH_TABLE_CORNER = register("birch_table_corner", LsFurnitureModBlocks.BIRCH_TABLE_CORNER, BirchTableCornerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BIRCH_TABLE_JUNCTION = register("birch_table_junction", LsFurnitureModBlocks.BIRCH_TABLE_JUNCTION, BirchTableJunctionBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BIRCH_TABLE_CROSS = register("birch_table_cross", LsFurnitureModBlocks.BIRCH_TABLE_CROSS, BirchTableCrossBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BIRCH_TABLE_END = register("birch_table_end", LsFurnitureModBlocks.BIRCH_TABLE_END, BirchTableEndBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> JUNGLE_TABLE_STRAIGHT = register("jungle_table_straight", LsFurnitureModBlocks.JUNGLE_TABLE_STRAIGHT, JungleTableStraightBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> JUNGLE_TABLE_CORNER = register("jungle_table_corner", LsFurnitureModBlocks.JUNGLE_TABLE_CORNER, JungleTableCornerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> JUNGLE_TABLE_JUNCTION = register("jungle_table_junction", LsFurnitureModBlocks.JUNGLE_TABLE_JUNCTION, JungleTableJunctionBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> JUNGLE_TABLE_CROSS = register("jungle_table_cross", LsFurnitureModBlocks.JUNGLE_TABLE_CROSS, JungleTableCrossBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> JUNGLE_TABLE_END = register("jungle_table_end", LsFurnitureModBlocks.JUNGLE_TABLE_END, JungleTableEndBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MANGROVE_TABLE_STRAIGHT = register("mangrove_table_straight", LsFurnitureModBlocks.MANGROVE_TABLE_STRAIGHT, MangroveTableStraightBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MANGROVE_TABLE_CORNER = register("mangrove_table_corner", LsFurnitureModBlocks.MANGROVE_TABLE_CORNER, MangroveTableCornerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MANGROVE_TABLE_JUNCTION = register("mangrove_table_junction", LsFurnitureModBlocks.MANGROVE_TABLE_JUNCTION, MangroveTableJunctionBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MANGROVE_TABLE_CROSS = register("mangrove_table_cross", LsFurnitureModBlocks.MANGROVE_TABLE_CROSS, MangroveTableCrossBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MANGROVE_TABLE_END = register("mangrove_table_end", LsFurnitureModBlocks.MANGROVE_TABLE_END, MangroveTableEndBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CRIMSON_TABLE_STRAIGHT = register("crimson_table_straight", LsFurnitureModBlocks.CRIMSON_TABLE_STRAIGHT, CrimsonTableStraightBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CRIMSON_TABLE_CORNER = register("crimson_table_corner", LsFurnitureModBlocks.CRIMSON_TABLE_CORNER, CrimsonTableCornerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CRIMSON_TABLE_JUNCTION = register("crimson_table_junction", LsFurnitureModBlocks.CRIMSON_TABLE_JUNCTION, CrimsonTableJunctionBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CRIMSON_TABLE_CROSS = register("crimson_table_cross", LsFurnitureModBlocks.CRIMSON_TABLE_CROSS, CrimsonTableCrossBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CRIMSON_TABLE_END = register("crimson_table_end", LsFurnitureModBlocks.CRIMSON_TABLE_END, CrimsonTableEndBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WARPED_TABLE_STRAIGHT = register("warped_table_straight", LsFurnitureModBlocks.WARPED_TABLE_STRAIGHT, WarpedTableStraightBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WARPED_TABLE_CORNER = register("warped_table_corner", LsFurnitureModBlocks.WARPED_TABLE_CORNER, WarpedTableCornerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WARPED_TABLE_JUNCTION = register("warped_table_junction", LsFurnitureModBlocks.WARPED_TABLE_JUNCTION, WarpedTableJunctionBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WARPED_TABLE_CROSS = register("warped_table_cross", LsFurnitureModBlocks.WARPED_TABLE_CROSS, WarpedTableCrossBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WARPED_TABLE_END = register("warped_table_end", LsFurnitureModBlocks.WARPED_TABLE_END, WarpedTableEndBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}

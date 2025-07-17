package net.lyivx.ls_furniture.registry;

import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.blocks.entity.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ModBlockEntitys {

    public static final ResourcefulRegistry<BlockEntityType<?>> BLOCK_ENTITIES = ResourcefulRegistries.create
            (BuiltInRegistries.BLOCK_ENTITY_TYPE, LYIVXsFurnitureMod.MOD_ID);
    

    public static final Supplier<BlockEntityType<PlateBlockEntity>> PLATE_ENTITY = BLOCK_ENTITIES.register("plate",
            () -> createBlockEntityType(PlateBlockEntity::new,
                    ModBlocks.PLATE.get()));

    public static final Supplier<BlockEntityType<ChoppingBoardBlockEntity>> CHOPPING_BOARD_ENTITY = BLOCK_ENTITIES.register("chopping_board",
            () -> createBlockEntityType(ChoppingBoardBlockEntity::new,
                    ModBlocks.CHOPPING_BOARD.get()));

    public static final Supplier<BlockEntityType<CuttingBoardBlockEntity>> CUTTING_BOARD_ENTITY = BLOCK_ENTITIES.register("cutting_board",
            () -> createBlockEntityType(CuttingBoardBlockEntity::new,
                    ModBlocks.CUTTING_BOARD.get()));

    public static final Supplier<BlockEntityType<ShelfBlockEntity>> SHELF_ENTITY = BLOCK_ENTITIES.register("shelf",
            () -> createBlockEntityType(ShelfBlockEntity::new,
                    ModBlocks.OAK_SHELF.get(),
                    ModBlocks.SPRUCE_SHELF.get(),
                    ModBlocks.BIRCH_SHELF.get(),
                    ModBlocks.JUNGLE_SHELF.get(),
                    ModBlocks.ACACIA_SHELF.get(),
                    ModBlocks.DARK_OAK_SHELF.get(),
                    ModBlocks.MANGROVE_SHELF.get(),
                    ModBlocks.CHERRY_SHELF.get(),
                    ModBlocks.BAMBOO_SHELF.get(),
                    ModBlocks.CRIMSON_SHELF.get(),
                    ModBlocks.WARPED_SHELF.get()));

    public static final Supplier<BlockEntityType<DrawerBlockEntity>> DRAWER_ENTITY = BLOCK_ENTITIES.register("drawer",
            () -> createBlockEntityType(DrawerBlockEntity::new,
                    ModBlocks.OAK_DRAWER.get(),
                    ModBlocks.SPRUCE_DRAWER.get(),
                    ModBlocks.BIRCH_DRAWER.get(),
                    ModBlocks.JUNGLE_DRAWER.get(),
                    ModBlocks.ACACIA_DRAWER.get(),
                    ModBlocks.DARK_OAK_DRAWER.get(),
                    ModBlocks.MANGROVE_DRAWER.get(),
                    ModBlocks.CHERRY_DRAWER.get(),
                    ModBlocks.BAMBOO_DRAWER.get(),
                    ModBlocks.CRIMSON_DRAWER.get(),
                    ModBlocks.WARPED_DRAWER.get()));

    public static final Supplier<BlockEntityType<CounterCupboardBlockEntity>> COUNTER_CUPBOARD_ENTITY = BLOCK_ENTITIES.register("counter_cupboard",
            () -> createBlockEntityType(CounterCupboardBlockEntity::new,
                    ModBlocks.OAK_COUNTER_CUPBOARD.get(),
                    ModBlocks.SPRUCE_COUNTER_CUPBOARD.get(),
                    ModBlocks.BIRCH_COUNTER_CUPBOARD.get(),
                    ModBlocks.JUNGLE_COUNTER_CUPBOARD.get(),
                    ModBlocks.ACACIA_COUNTER_CUPBOARD.get(),
                    ModBlocks.DARK_OAK_COUNTER_CUPBOARD.get(),
                    ModBlocks.MANGROVE_COUNTER_CUPBOARD.get(),
                    ModBlocks.CHERRY_COUNTER_CUPBOARD.get(),
                    ModBlocks.BAMBOO_COUNTER_CUPBOARD.get(),
                    ModBlocks.CRIMSON_COUNTER_CUPBOARD.get(),
                    ModBlocks.WARPED_COUNTER_CUPBOARD.get()));

    public static final Supplier<BlockEntityType<CounterDrawerBlockEntity>> COUNTER_DRAWER_ENTITY = BLOCK_ENTITIES.register("counter_drawer",
            () -> createBlockEntityType(CounterDrawerBlockEntity::new,
                    ModBlocks.OAK_COUNTER_DRAWER.get(),
                    ModBlocks.SPRUCE_COUNTER_DRAWER.get(),
                    ModBlocks.BIRCH_COUNTER_DRAWER.get(),
                    ModBlocks.JUNGLE_COUNTER_DRAWER.get(),
                    ModBlocks.ACACIA_COUNTER_DRAWER.get(),
                    ModBlocks.DARK_OAK_COUNTER_DRAWER.get(),
                    ModBlocks.MANGROVE_COUNTER_DRAWER.get(),
                    ModBlocks.CHERRY_COUNTER_DRAWER.get(),
                    ModBlocks.BAMBOO_COUNTER_DRAWER.get(),
                    ModBlocks.CRIMSON_COUNTER_DRAWER.get(),
                    ModBlocks.WARPED_COUNTER_DRAWER.get()));

    public static final Supplier<BlockEntityType<CounterOvenBlockEntity>> COUNTER_OVEN_ENTITY = BLOCK_ENTITIES.register("counter_oven",
            () -> createBlockEntityType(CounterOvenBlockEntity::new,
                    ModBlocks.OAK_COUNTER_OVEN.get(),
                    ModBlocks.SPRUCE_COUNTER_OVEN.get(),
                    ModBlocks.BIRCH_COUNTER_OVEN.get(),
                    ModBlocks.JUNGLE_COUNTER_OVEN.get(),
                    ModBlocks.ACACIA_COUNTER_OVEN.get(),
                    ModBlocks.DARK_OAK_COUNTER_OVEN.get(),
                    ModBlocks.MANGROVE_COUNTER_OVEN.get(),
                    ModBlocks.CHERRY_COUNTER_OVEN.get(),
                    ModBlocks.BAMBOO_COUNTER_OVEN.get(),
                    ModBlocks.CRIMSON_COUNTER_OVEN.get(),
                    ModBlocks.WARPED_COUNTER_OVEN.get()));

    public static final Supplier<BlockEntityType<CabinetCupboardBlockEntity>> CABINET_CUPBOARD_ENTITY = BLOCK_ENTITIES.register("cabinet_cupboard",
            () -> createBlockEntityType(CabinetCupboardBlockEntity::new,
                    ModBlocks.OAK_CABINET_CUPBOARD.get(),
                    ModBlocks.SPRUCE_CABINET_CUPBOARD.get(),
                    ModBlocks.BIRCH_CABINET_CUPBOARD.get(),
                    ModBlocks.JUNGLE_CABINET_CUPBOARD.get(),
                    ModBlocks.ACACIA_CABINET_CUPBOARD.get(),
                    ModBlocks.DARK_OAK_CABINET_CUPBOARD.get(),
                    ModBlocks.MANGROVE_CABINET_CUPBOARD.get(),
                    ModBlocks.CHERRY_CABINET_CUPBOARD.get(),
                    ModBlocks.BAMBOO_CABINET_CUPBOARD.get(),
                    ModBlocks.CRIMSON_CABINET_CUPBOARD.get(),
                    ModBlocks.WARPED_CABINET_CUPBOARD.get()));

    public static final Supplier<BlockEntityType<MailboxBlockEntity>> MAILBOX_ENTITY = BLOCK_ENTITIES.register("mailbox",
            () -> createBlockEntityType(MailboxBlockEntity::new,
                    ModBlocks.OAK_MAILBOX.get(),
                    ModBlocks.SPRUCE_MAILBOX.get(),
                    ModBlocks.BIRCH_MAILBOX.get(),
                    ModBlocks.JUNGLE_MAILBOX.get(),
                    ModBlocks.ACACIA_MAILBOX.get(),
                    ModBlocks.DARK_OAK_MAILBOX.get(),
                    ModBlocks.MANGROVE_MAILBOX.get(),
                    ModBlocks.CHERRY_MAILBOX.get(),
                    ModBlocks.BAMBOO_MAILBOX.get(),
                    ModBlocks.CRIMSON_MAILBOX.get(),
                    ModBlocks.WARPED_MAILBOX.get()));

    public static final Supplier<BlockEntityType<WardrobeBottomBlockEntity>> WARDROBE_ENTITY_BOTTOM = BLOCK_ENTITIES.register("wardrobe_bottom",
            () -> createBlockEntityType(WardrobeBottomBlockEntity::new,
                    ModBlocks.OAK_WARDROBE.get(),
                    ModBlocks.SPRUCE_WARDROBE.get(),
                    ModBlocks.BIRCH_WARDROBE.get(),
                    ModBlocks.JUNGLE_WARDROBE.get(),
                    ModBlocks.ACACIA_WARDROBE.get(),
                    ModBlocks.DARK_OAK_WARDROBE.get(),
                    ModBlocks.MANGROVE_WARDROBE.get(),
                    ModBlocks.CHERRY_WARDROBE.get(),
                    ModBlocks.BAMBOO_WARDROBE.get(),
                    ModBlocks.CRIMSON_WARDROBE.get(),
                    ModBlocks.WARPED_WARDROBE.get()));

    public static final Supplier<BlockEntityType<WardrobeTopBlockEntity>> WARDROBE_ENTITY_TOP = BLOCK_ENTITIES.register("wardrobe_top",
            () -> createBlockEntityType(WardrobeTopBlockEntity::new,
                    ModBlocks.OAK_WARDROBE.get(),
                    ModBlocks.SPRUCE_WARDROBE.get(),
                    ModBlocks.BIRCH_WARDROBE.get(),
                    ModBlocks.JUNGLE_WARDROBE.get(),
                    ModBlocks.ACACIA_WARDROBE.get(),
                    ModBlocks.DARK_OAK_WARDROBE.get(),
                    ModBlocks.MANGROVE_WARDROBE.get(),
                    ModBlocks.CHERRY_WARDROBE.get(),
                    ModBlocks.BAMBOO_WARDROBE.get(),
                    ModBlocks.CRIMSON_WARDROBE.get(),
                    ModBlocks.WARPED_WARDROBE.get()));

    public static final Supplier<BlockEntityType<CustomChestBlockEntity>> MOD_CHEST_ENTITY = BLOCK_ENTITIES.register("custom_chest",
            () -> createBlockEntityType(CustomChestBlockEntity::new,
                    ModBlocks.OAK_CHEST.get(),
                    ModBlocks.SPRUCE_CHEST.get(),
                    ModBlocks.BIRCH_CHEST.get(),
                    ModBlocks.JUNGLE_CHEST.get(),
                    ModBlocks.ACACIA_CHEST.get(),
                    ModBlocks.DARK_OAK_CHEST.get(),
                    ModBlocks.MANGROVE_CHEST.get(),
                    ModBlocks.CHERRY_CHEST.get(),
                    ModBlocks.BAMBOO_CHEST.get(),
                    ModBlocks.CRIMSON_CHEST.get(),
                    ModBlocks.WARPED_CHEST.get()));

    public static final Supplier<BlockEntityType<LockableBlockEntity>> LOCKED_ENTITY = BLOCK_ENTITIES.register("locked",
            () -> createBlockEntityType(LockableBlockEntity::new,
                    ModBlocks.OAK_PLATFORM.get(),
                    ModBlocks.SPRUCE_PLATFORM.get(),
                    ModBlocks.BIRCH_PLATFORM.get(),
                    ModBlocks.JUNGLE_PLATFORM.get(),
                    ModBlocks.ACACIA_PLATFORM.get(),
                    ModBlocks.DARK_OAK_PLATFORM.get(),
                    ModBlocks.MANGROVE_PLATFORM.get(),
                    ModBlocks.CHERRY_PLATFORM.get(),
                    ModBlocks.BAMBOO_PLATFORM.get(),
                    ModBlocks.CRIMSON_PLATFORM.get(),
                    ModBlocks.WARPED_PLATFORM.get(),
                    ModBlocks.OVEN_VENT_SHAFT.get(),
                    ModBlocks.FIRE_PLACE_CHIMNEY_SHAFT.get(),
                    // Chairs
                    ModBlocks.OAK_CHAIR.get(), ModBlocks.SPRUCE_CHAIR.get(), ModBlocks.BIRCH_CHAIR.get(),
                    ModBlocks.JUNGLE_CHAIR.get(), ModBlocks.ACACIA_CHAIR.get(), ModBlocks.DARK_OAK_CHAIR.get(),
                    ModBlocks.MANGROVE_CHAIR.get(), ModBlocks.CHERRY_CHAIR.get(), ModBlocks.BAMBOO_CHAIR.get(),
                    ModBlocks.CRIMSON_CHAIR.get(), ModBlocks.WARPED_CHAIR.get(),
                    // Stools
                    ModBlocks.OAK_STOOL.get(), ModBlocks.SPRUCE_STOOL.get(), ModBlocks.BIRCH_STOOL.get(),
                    ModBlocks.JUNGLE_STOOL.get(), ModBlocks.ACACIA_STOOL.get(), ModBlocks.DARK_OAK_STOOL.get(),
                    ModBlocks.MANGROVE_STOOL.get(), ModBlocks.CHERRY_STOOL.get(), ModBlocks.BAMBOO_STOOL.get(),
                    ModBlocks.CRIMSON_STOOL.get(), ModBlocks.WARPED_STOOL.get(),
                    // Sofas
                    ModBlocks.OAK_SOFA.get(), ModBlocks.SPRUCE_SOFA.get(), ModBlocks.BIRCH_SOFA.get(),
                    ModBlocks.JUNGLE_SOFA.get(), ModBlocks.ACACIA_SOFA.get(), ModBlocks.DARK_OAK_SOFA.get(),
                    ModBlocks.MANGROVE_SOFA.get(), ModBlocks.CHERRY_SOFA.get(), ModBlocks.BAMBOO_SOFA.get(),
                    ModBlocks.CRIMSON_SOFA.get(), ModBlocks.WARPED_SOFA.get(),
                    // Tables
                    ModBlocks.OAK_TABLE.get(), ModBlocks.SPRUCE_TABLE.get(), ModBlocks.BIRCH_TABLE.get(),
                    ModBlocks.JUNGLE_TABLE.get(), ModBlocks.ACACIA_TABLE.get(), ModBlocks.DARK_OAK_TABLE.get(),
                    ModBlocks.MANGROVE_TABLE.get(), ModBlocks.CHERRY_TABLE.get(), ModBlocks.BAMBOO_TABLE.get(),
                    ModBlocks.CRIMSON_TABLE.get(), ModBlocks.WARPED_TABLE.get(),
                    // Counters
                    ModBlocks.OAK_COUNTER.get(), ModBlocks.SPRUCE_COUNTER.get(), ModBlocks.BIRCH_COUNTER.get(),
                    ModBlocks.JUNGLE_COUNTER.get(), ModBlocks.ACACIA_COUNTER.get(), ModBlocks.DARK_OAK_COUNTER.get(),
                    ModBlocks.MANGROVE_COUNTER.get(), ModBlocks.CHERRY_COUNTER.get(), ModBlocks.BAMBOO_COUNTER.get(),
                    ModBlocks.CRIMSON_COUNTER.get(), ModBlocks.WARPED_COUNTER.get(),
                    // Counter Islands
                    ModBlocks.OAK_COUNTER_ISLAND.get(), ModBlocks.SPRUCE_COUNTER_ISLAND.get(), ModBlocks.BIRCH_COUNTER_ISLAND.get(),
                    ModBlocks.JUNGLE_COUNTER_ISLAND.get(), ModBlocks.ACACIA_COUNTER_ISLAND.get(), ModBlocks.DARK_OAK_COUNTER_ISLAND.get(),
                    ModBlocks.MANGROVE_COUNTER_ISLAND.get(), ModBlocks.CHERRY_COUNTER_ISLAND.get(), ModBlocks.BAMBOO_COUNTER_ISLAND.get(),
                    ModBlocks.CRIMSON_COUNTER_ISLAND.get(), ModBlocks.WARPED_COUNTER_ISLAND.get(),
                    // Cabinets
                    ModBlocks.OAK_CABINET.get(), ModBlocks.SPRUCE_CABINET.get(), ModBlocks.BIRCH_CABINET.get(),
                    ModBlocks.JUNGLE_CABINET.get(), ModBlocks.ACACIA_CABINET.get(), ModBlocks.DARK_OAK_CABINET.get(),
                    ModBlocks.MANGROVE_CABINET.get(), ModBlocks.CHERRY_CABINET.get(), ModBlocks.BAMBOO_CABINET.get(),
                    ModBlocks.CRIMSON_CABINET.get(), ModBlocks.WARPED_CABINET.get(),
                    // Beds
                    ModBlocks.OAK_BED.get(), ModBlocks.SPRUCE_BED.get(), ModBlocks.BIRCH_BED.get(),
                    ModBlocks.JUNGLE_BED.get(), ModBlocks.ACACIA_BED.get(), ModBlocks.DARK_OAK_BED.get(),
                    ModBlocks.MANGROVE_BED.get(), ModBlocks.CHERRY_BED.get(), ModBlocks.BAMBOO_BED.get(),
                    ModBlocks.CRIMSON_BED.get(), ModBlocks.WARPED_BED.get(),
                    // Mod stairs
                    ModBlocks.OAK_ROOF.get(), ModBlocks.SPRUCE_ROOF.get(), ModBlocks.BIRCH_ROOF.get(),
                    ModBlocks.JUNGLE_ROOF.get(), ModBlocks.ACACIA_ROOF.get(), ModBlocks.DARK_OAK_ROOF.get(),
                    ModBlocks.MANGROVE_ROOF.get(), ModBlocks.CHERRY_ROOF.get(), ModBlocks.BAMBOO_ROOF.get(),
                    ModBlocks.CRIMSON_ROOF.get(), ModBlocks.WARPED_ROOF.get(),
                    // Lamps
                    ModBlocks.OAK_LAMP.get(), ModBlocks.SPRUCE_LAMP.get(), ModBlocks.BIRCH_LAMP.get(),
                    ModBlocks.JUNGLE_LAMP.get(), ModBlocks.ACACIA_LAMP.get(), ModBlocks.DARK_OAK_LAMP.get(),
                    ModBlocks.MANGROVE_LAMP.get(), ModBlocks.CHERRY_LAMP.get(), ModBlocks.BAMBOO_LAMP.get(),
                    ModBlocks.CRIMSON_LAMP.get(), ModBlocks.WARPED_LAMP.get()));

    public static final Supplier<BlockEntityType<FridgeBlockEntity>> FRIDGE_ENTITY = BLOCK_ENTITIES.register("fridge",
            () -> createBlockEntityType(FridgeBlockEntity::new,
                    ModBlocks.FRIDGE_FREEZER.get()));

    public static final Supplier<BlockEntityType<FreezerBlockEntity>> FREEZER_ENTITY = BLOCK_ENTITIES.register("freezer",
            () -> createBlockEntityType(FreezerBlockEntity::new,
                    ModBlocks.FRIDGE_FREEZER.get()));

    public static final Supplier<BlockEntityType<BarrelModBlockEntity>> MOD_BARREL_ENTITY = BLOCK_ENTITIES.register("mod_barrel",
            () -> createBlockEntityType(BarrelModBlockEntity::new,
                    ModBlocks.OAK_BARREL.get(),
                    ModBlocks.SPRUCE_BARREL.get(),
                    ModBlocks.BIRCH_BARREL.get(),
                    ModBlocks.JUNGLE_BARREL.get(),
                    ModBlocks.ACACIA_BARREL.get(),
                    ModBlocks.DARK_OAK_BARREL.get(),
                    ModBlocks.MANGROVE_BARREL.get(),
                    ModBlocks.CHERRY_BARREL.get(),
                    ModBlocks.BAMBOO_BARREL.get(),
                    ModBlocks.CRIMSON_BARREL.get(),
                    ModBlocks.WARPED_BARREL.get()));

    public static final Supplier<BlockEntityType<ToasterBlockEntity>> TOASTER_ENTITY = BLOCK_ENTITIES.register("toaster",
            () -> createBlockEntityType(ToasterBlockEntity::new,
                    ModBlocks.TOASTER.get()));

    public static final Supplier<BlockEntityType<DrainerBlockEntity>> DRAINER_ENTITY = BLOCK_ENTITIES.register("drainer",
            () -> createBlockEntityType(DrainerBlockEntity::new,
                    ModBlocks.DRAINER.get()));

    public static final Supplier<BlockEntityType<CrateBlockEntity>> CRATE_ENTITY = BLOCK_ENTITIES.register("crate",
            () -> createBlockEntityType(CrateBlockEntity::new,
                    ModBlocks.OAK_CRATE.get(),
                    ModBlocks.SPRUCE_CRATE.get(),
                    ModBlocks.BIRCH_CRATE.get(),
                    ModBlocks.JUNGLE_CRATE.get(),
                    ModBlocks.ACACIA_CRATE.get(),
                    ModBlocks.DARK_OAK_CRATE.get(),
                    ModBlocks.MANGROVE_CRATE.get(),
                    ModBlocks.CHERRY_CRATE.get(),
                    ModBlocks.BAMBOO_CRATE.get(),
                    ModBlocks.CRIMSON_CRATE.get(),
                    ModBlocks.WARPED_CRATE.get()));

    public static final Supplier<BlockEntityType<RailingBlockEntity>> RAILING_ENTITY = BLOCK_ENTITIES.register("railing",
            () -> createBlockEntityType(RailingBlockEntity::new,
                    ModBlocks.OAK_RAILING.get(),
                    ModBlocks.SPRUCE_RAILING.get(),
                    ModBlocks.BIRCH_RAILING.get(),
                    ModBlocks.JUNGLE_RAILING.get(),
                    ModBlocks.ACACIA_RAILING.get(),
                    ModBlocks.DARK_OAK_RAILING.get(),
                    ModBlocks.MANGROVE_RAILING.get(),
                    ModBlocks.CHERRY_RAILING.get(),
                    ModBlocks.BAMBOO_RAILING.get(),
                    ModBlocks.CRIMSON_RAILING.get(),
                    ModBlocks.WARPED_RAILING.get()));



    public static final Supplier<BlockEntityType<TombstoneBlockEntity>> TOMBSTONE_ENTITY = BLOCK_ENTITIES.register("tombstone",
            () -> createBlockEntityType(TombstoneBlockEntity::new,
                    ModBlocks.OAK_TOMBSTONE.get(),
                    ModBlocks.SPRUCE_TOMBSTONE.get(),
                    ModBlocks.BIRCH_TOMBSTONE.get(),
                    ModBlocks.JUNGLE_TOMBSTONE.get(),
                    ModBlocks.ACACIA_TOMBSTONE.get(),
                    ModBlocks.DARK_OAK_TOMBSTONE.get(),
                    ModBlocks.MANGROVE_TOMBSTONE.get(),
                    ModBlocks.CHERRY_TOMBSTONE.get(),
                    ModBlocks.BAMBOO_TOMBSTONE.get(),
                    ModBlocks.CRIMSON_TOMBSTONE.get(),
                    ModBlocks.WARPED_TOMBSTONE.get()));

    ////////////////////////////////////////////////////////////////////////////

    @ExpectPlatform
    public static <T extends BlockEntity> BlockEntityType<T> createBlockEntityType(BlockEntityFactory<T> factory, Block... block) {
        throw new AssertionError();
    }

    @FunctionalInterface
    public interface BlockEntityFactory<T extends BlockEntity> {
        @NotNull
        T create(BlockPos pos, BlockState state);
    }

}

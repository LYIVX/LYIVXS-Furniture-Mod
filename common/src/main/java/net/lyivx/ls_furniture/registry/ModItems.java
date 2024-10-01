package net.lyivx.ls_furniture.registry;

import com.teamresourceful.resourcefullib.common.item.tabs.ResourcefulCreativeTab;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.lyivx.ls_furniture.common.items.*;
import net.lyivx.ls_furniture.common.recipes.RecipeSorter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModItems {

    // TODO: New Way Of Making Bark, Sticks And Furniture Packs Burnable

    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create
            (BuiltInRegistries.ITEM, LYIVXsFurnitureMod.MOD_ID);

    public static final ResourcefulRegistry<Item> MISC = ResourcefulRegistries.create
            (ITEMS);
    public static final ResourcefulRegistry<Item> DECO = ResourcefulRegistries.create
            (ITEMS);
    public static final ResourcefulRegistry<Item> TOOLS = ResourcefulRegistries.create
            (ITEMS);
    public static final ResourcefulRegistry<Item> INGREDIENTS = ResourcefulRegistries.create
            (ITEMS);
    public static final ResourcefulRegistry<Item> FOODS = ResourcefulRegistries.create
            (ITEMS);

    ////////////////////////////////////// CREATIVE TAB ////////////////////////////////////

    public static final Supplier<CreativeModeTab> ITEM_GROUP = new ResourcefulCreativeTab(new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, "tab"))
            .setItemIcon(ModBlocks.WORKSTATION)
            .addRegistry(ITEMS)
            .build();

    /////////////////////////////////// INTERACTIVE ////////////////////////////////////

    public static final Supplier<Item> WORKSTATION = DECO.register("workstation",
            () -> new BlockItem(ModBlocks.WORKSTATION.get(), new Item.Properties()));

    public static final Supplier<Item> CHOPPING_BOARD = DECO.register("chopping_board",
            () -> new BlockItem(ModBlocks.CHOPPING_BOARD.get(), new Item.Properties()));

    public static final Supplier<Item> CUTTING_BOARD = DECO.register("cutting_board",
            () -> new BlockItem(ModBlocks.CUTTING_BOARD.get(), new Item.Properties()));

    public static final Supplier<Item> PLATE = DECO.register("plate",
            () -> new BlockItem(ModBlocks.PLATE.get(), new Item.Properties()));

    public static final Supplier<Item> TOASTER = DECO.register("toaster",
            () -> new BlockItem(ModBlocks.TOASTER.get(), new Item.Properties()));

    public static final Supplier<Item> KETTLE = DECO.register("kettle",
            () -> new BlockItem(ModBlocks.KETTLE.get(), new Item.Properties()));

    public static final Supplier<Item> MICROWAVE = DECO.register("microwave",
            () -> new BlockItem(ModBlocks.MICROWAVE.get(), new Item.Properties()));

    public static final Supplier<Item> FRIDGE_FREEZER = DECO.register("fridge_freezer",
            () -> new BlockItem(ModBlocks.FRIDGE_FREEZER.get(), new Item.Properties()));

    public static final Supplier<Item> DRAINER = DECO.register("drainer",
            () -> new BlockItem(ModBlocks.DRAINER.get(), new Item.Properties()));

    public static final Supplier<OvenVentItem> OVEN_VENT = DECO.register("oven_vent",
            () -> new OvenVentItem(ModBlocks.OVEN_VENT.get(), new Item.Properties()));

    public static final Supplier<Item> OVEN_VENT_SHAFT = DECO.register("oven_vent_shaft",
            () -> new BlockItem(ModBlocks.OVEN_VENT_SHAFT.get(), new Item.Properties()));

    public static final Supplier<Item> FIRE_PLACE = DECO.register("fire_place",
            () -> new BlockItem(ModBlocks.FIRE_PLACE.get(), new Item.Properties()));

    public static final Supplier<Item> FIRE_PLACE_CHIMNEY_SHAFT = DECO.register("fire_place_chimney_shaft",
            () -> new BlockItem(ModBlocks.FIRE_PLACE_CHIMNEY_SHAFT.get(), new Item.Properties()));

    public static final Supplier<Item> TV = DECO.register("tv",
            () -> new BlockItem(ModBlocks.TV.get(), new Item.Properties()));

    public static final Supplier<Item> COMPUTER = DECO.register("computer",
            () -> new BlockItem(ModBlocks.COMPUTER.get(), new Item.Properties()));

    ////////////////////////////////////// MODULES ////////////////////////////////////

    public static final Supplier<SinkModuleItem> SINK_MODULE = INGREDIENTS.register("sink_module",
            () -> new SinkModuleItem(new Item.Properties()));

    public static final Supplier<OvenModuleItem> OVEN_MODULE = INGREDIENTS.register("oven_module",
            () -> new OvenModuleItem(new Item.Properties()));

    ////////////////////////////////////// ITEMS ////////////////////////////////////

    public static final Supplier<Item> WRENCH = TOOLS.register("wrench",
            () -> new WrenchItem(new Item.Properties().durability(1000)));

    public static final Supplier<Item> CHISEL = TOOLS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(1000)));

    public static final Supplier<Item> SAW = TOOLS.register("saw",
            () -> new SawItem(new Item.Properties().durability(1000)));

    public static final Supplier<Item> SHEARS = TOOLS.register("shears",
            () -> new ShearsItem(new Item.Properties().durability(1000)));

    public static final Supplier<Item> HAMMER = TOOLS.register("hammer",
            () -> new HammerItem(new Item.Properties().durability(1000)));

    public static final Supplier<Item> KNIFE = TOOLS.register("knife",
            () -> new KnifeItem(new Item.Properties().durability(1000)));

    public static final Supplier<LetterItem> LETTER = DECO.register("letter",
            () -> new LetterItem(new Item.Properties()));

    public static final Supplier<Item> SLICED_BREAD = FOODS.register("sliced_bread",
            () -> new Item(normal(ModFoodProperties.SLICED_BREAD)));

    public static final Supplier<Item> TOAST = FOODS.register("toast",
            () -> new Item(normal(ModFoodProperties.TOAST)));

    public static final Supplier<Item> OAK_BARK = INGREDIENTS.register("oak_bark",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> SPRUCE_BARK = INGREDIENTS.register("spruce_bark",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> BIRCH_BARK = INGREDIENTS.register("birch_bark",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> JUNGLE_BARK = INGREDIENTS.register("jungle_bark",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> ACACIA_BARK = INGREDIENTS.register("acacia_bark",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_BARK = INGREDIENTS.register("dark_oak_bark",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> MANGROVE_BARK = INGREDIENTS.register("mangrove_bark",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> CHERRY_BARK = INGREDIENTS.register("cherry_bark",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> BAMBOO_BARK = INGREDIENTS.register("bamboo_bark",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> CRIMSON_BARK = INGREDIENTS.register("crimson_bark",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> WARPED_BARK = INGREDIENTS.register("warped_bark",
            () -> new Item(new Item.Properties()));

    ///////////////////////////////// STICKS / RODS ////////////////////////////////////
    
    public static final Supplier<Item> IRON_ROD = INGREDIENTS.register("iron_rod",
            () -> new Item(new Item.Properties()));
    
    public static final Supplier<Item> OAK_STICK = INGREDIENTS.register("oak_stick",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> SPRUCE_STICK = INGREDIENTS.register("spruce_stick",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> BIRCH_STICK = INGREDIENTS.register("birch_stick",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> JUNGLE_STICK = INGREDIENTS.register("jungle_stick",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> ACACIA_STICK = INGREDIENTS.register("acacia_stick",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_STICK = INGREDIENTS.register("dark_oak_stick",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> MANGROVE_STICK = INGREDIENTS.register("mangrove_stick",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> CHERRY_STICK = INGREDIENTS.register("cherry_stick",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> BAMBOO_STICK = INGREDIENTS.register("bamboo_stick",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> CRIMSON_STICK = INGREDIENTS.register("crimson_stick",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> WARPED_STICK = INGREDIENTS.register("warped_stick",
            () -> new Item(new Item.Properties()));


    ///////////////////////////////// FURNITURE PACKS ////////////////////////////////////

    public static final Supplier<Item> ELECTRICAL_FURNITURE_PACK = INGREDIENTS.register("electrical_furniture_pack",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> CONSTRUCTION_FURNITURE_PACK = INGREDIENTS.register("construction_furniture_pack",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> OAK_FURNITURE_PACK = INGREDIENTS.register("oak_furniture_pack",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> SPRUCE_FURNITURE_PACK = INGREDIENTS.register("spruce_furniture_pack",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> BIRCH_FURNITURE_PACK = INGREDIENTS.register("birch_furniture_pack",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> JUNGLE_FURNITURE_PACK = INGREDIENTS.register("jungle_furniture_pack",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> ACACIA_FURNITURE_PACK = INGREDIENTS.register("acacia_furniture_pack",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_FURNITURE_PACK = INGREDIENTS.register("dark_oak_furniture_pack",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> MANGROVE_FURNITURE_PACK = INGREDIENTS.register("mangrove_furniture_pack",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> CHERRY_FURNITURE_PACK = INGREDIENTS.register("cherry_furniture_pack",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> BAMBOO_FURNITURE_PACK = INGREDIENTS.register("bamboo_furniture_pack",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> CRIMSON_FURNITURE_PACK = INGREDIENTS.register("crimson_furniture_pack",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> WARPED_FURNITURE_PACK = INGREDIENTS.register("warped_furniture_pack",
            () -> new Item(new Item.Properties()));


    /////////////////////////////////// CHESTS ////////////////////////////////////

    public static final Supplier<Item> OAK_CHEST = DECO.register("oak_chest",
            () -> new BlockItem(ModBlocks.OAK_CHEST.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_CHEST = DECO.register("spruce_chest",
            () -> new BlockItem(ModBlocks.SPRUCE_CHEST.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_CHEST = DECO.register("birch_chest",
            () -> new BlockItem(ModBlocks.BIRCH_CHEST.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_CHEST = DECO.register("jungle_chest",
            () -> new BlockItem(ModBlocks.JUNGLE_CHEST.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_CHEST = DECO.register("acacia_chest",
            () -> new BlockItem(ModBlocks.ACACIA_CHEST.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_CHEST = DECO.register("dark_oak_chest",
            () -> new BlockItem(ModBlocks.DARK_OAK_CHEST.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_CHEST = DECO.register("mangrove_chest",
            () -> new BlockItem(ModBlocks.MANGROVE_CHEST.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_CHEST = DECO.register("cherry_chest",
            () -> new BlockItem(ModBlocks.CHERRY_CHEST.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_CHEST = DECO.register("bamboo_chest",
            () -> new BlockItem(ModBlocks.BAMBOO_CHEST.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_CHEST = DECO.register("crimson_chest",
            () -> new BlockItem(ModBlocks.CRIMSON_CHEST.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_CHEST = DECO.register("warped_chest",
            () -> new BlockItem(ModBlocks.WARPED_CHEST.get(), new Item.Properties()));

    /////////////////////////////////// BARRELS ////////////////////////////////////

    public static final Supplier<Item> OAK_BARREL = DECO.register("oak_barrel",
            () -> new BlockItem(ModBlocks.OAK_BARREL.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_BARREL = DECO.register("spruce_barrel",
            () -> new BlockItem(ModBlocks.SPRUCE_BARREL.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_BARREL = DECO.register("birch_barrel",
            () -> new BlockItem(ModBlocks.BIRCH_BARREL.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_BARREL = DECO.register("jungle_barrel",
            () -> new BlockItem(ModBlocks.JUNGLE_BARREL.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_BARREL = DECO.register("acacia_barrel",
            () -> new BlockItem(ModBlocks.ACACIA_BARREL.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_BARREL = DECO.register("dark_oak_barrel",
            () -> new BlockItem(ModBlocks.DARK_OAK_BARREL.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_BARREL = DECO.register("mangrove_barrel",
            () -> new BlockItem(ModBlocks.MANGROVE_BARREL.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_BARREL = DECO.register("cherry_barrel",
            () -> new BlockItem(ModBlocks.CHERRY_BARREL.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_BARREL = DECO.register("bamboo_barrel",
            () -> new BlockItem(ModBlocks.BAMBOO_BARREL.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_BARREL = DECO.register("crimson_barrel",
            () -> new BlockItem(ModBlocks.CRIMSON_BARREL.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_BARREL = DECO.register("warped_barrel",
            () -> new BlockItem(ModBlocks.WARPED_BARREL.get(), new Item.Properties()));

    /////////////////////////////////// CRATES ////////////////////////////////////

    public static final Supplier<Item> OAK_CRATE = DECO.register("oak_crate",
            () -> new BlockItem(ModBlocks.OAK_CRATE.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_CRATE = DECO.register("spruce_crate",
            () -> new BlockItem(ModBlocks.SPRUCE_CRATE.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_CRATE = DECO.register("birch_crate",
            () -> new BlockItem(ModBlocks.BIRCH_CRATE.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_CRATE = DECO.register("jungle_crate",
            () -> new BlockItem(ModBlocks.JUNGLE_CRATE.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_CRATE = DECO.register("acacia_crate",
            () -> new BlockItem(ModBlocks.ACACIA_CRATE.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_CRATE = DECO.register("dark_oak_crate",
            () -> new BlockItem(ModBlocks.DARK_OAK_CRATE.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_CRATE = DECO.register("mangrove_crate",
            () -> new BlockItem(ModBlocks.MANGROVE_CRATE.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_CRATE = DECO.register("cherry_crate",
            () -> new BlockItem(ModBlocks.CHERRY_CRATE.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_CRATE = DECO.register("bamboo_crate",
            () -> new BlockItem(ModBlocks.BAMBOO_CRATE.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_CRATE = DECO.register("crimson_crate",
            () -> new BlockItem(ModBlocks.CRIMSON_CRATE.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_CRATE = DECO.register("warped_crate",
            () -> new BlockItem(ModBlocks.WARPED_CRATE.get(), new Item.Properties()));

    ////////////////////////////////////// BLOCKS ////////////////////////////////////

    ////////////////////////////////////// FRAMES ////////////////////////////////////

    ////////////////////////////////////// STANDARD ////////////////////////////////////

    /*
    public static final Supplier<Item> RAINBOW_WOOL = DECO.register("rainbow_wool",
            () -> new BlockItem(ModBlocks.RAINBOW_WOOL.get(), new Item.Properties()));
    */

    ////////////////////////////////////// SOFAS ////////////////////////////////////

    public static final Supplier<Item> OAK_SOFA = DECO.register("oak_sofa",
            () -> new BlockItem(ModBlocks.OAK_SOFA.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_SOFA = DECO.register("spruce_sofa",
            () -> new BlockItem(ModBlocks.SPRUCE_SOFA.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_SOFA = DECO.register("birch_sofa",
            () -> new BlockItem(ModBlocks.BIRCH_SOFA.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_SOFA = DECO.register("jungle_sofa",
            () -> new BlockItem(ModBlocks.JUNGLE_SOFA.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_SOFA = DECO.register("acacia_sofa",
            () -> new BlockItem(ModBlocks.ACACIA_SOFA.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_SOFA = DECO.register("dark_oak_sofa",
            () -> new BlockItem(ModBlocks.DARK_OAK_SOFA.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_SOFA = DECO.register("mangrove_sofa",
            () -> new BlockItem(ModBlocks.MANGROVE_SOFA.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_SOFA = DECO.register("cherry_sofa",
            () -> new BlockItem(ModBlocks.CHERRY_SOFA.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_SOFA = DECO.register("bamboo_sofa",
            () -> new BlockItem(ModBlocks.BAMBOO_SOFA.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_SOFA = DECO.register("crimson_sofa",
            () -> new BlockItem(ModBlocks.CRIMSON_SOFA.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_SOFA = DECO.register("warped_sofa",
            () -> new BlockItem(ModBlocks.WARPED_SOFA.get(), new Item.Properties()));

    ////////////////////////////////////// BEDS ////////////////////////////////////

    public static final Supplier<Item> OAK_BED = DECO.register("oak_bed",
            () -> new BlockItem(ModBlocks.OAK_BED.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_BED = DECO.register("spruce_bed",
            () -> new BlockItem(ModBlocks.SPRUCE_BED.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_BED = DECO.register("birch_bed",
            () -> new BlockItem(ModBlocks.BIRCH_BED.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_BED = DECO.register("jungle_bed",
            () -> new BlockItem(ModBlocks.JUNGLE_BED.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_BED = DECO.register("acacia_bed",
            () -> new BlockItem(ModBlocks.ACACIA_BED.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_BED = DECO.register("dark_oak_bed",
            () -> new BlockItem(ModBlocks.DARK_OAK_BED.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_BED = DECO.register("mangrove_bed",
            () -> new BlockItem(ModBlocks.MANGROVE_BED.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_BED = DECO.register("cherry_bed",
            () -> new BlockItem(ModBlocks.CHERRY_BED.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_BED = DECO.register("bamboo_bed",
            () -> new BlockItem(ModBlocks.BAMBOO_BED.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_BED = DECO.register("crimson_bed",
            () -> new BlockItem(ModBlocks.CRIMSON_BED.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_BED = DECO.register("warped_bed",
            () -> new BlockItem(ModBlocks.WARPED_BED.get(), new Item.Properties()));

    ////////////////////////////////////// CHAIRS ////////////////////////////////////

    public static final Supplier<Item> OAK_CHAIR = DECO.register("oak_chair",
            () -> new BlockItem(ModBlocks.OAK_CHAIR.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_CHAIR = DECO.register("spruce_chair",
            () -> new BlockItem(ModBlocks.SPRUCE_CHAIR.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_CHAIR = DECO.register("birch_chair",
            () -> new BlockItem(ModBlocks.BIRCH_CHAIR.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_CHAIR = DECO.register("jungle_chair",
            () -> new BlockItem(ModBlocks.JUNGLE_CHAIR.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_CHAIR = DECO.register("acacia_chair",
            () -> new BlockItem(ModBlocks.ACACIA_CHAIR.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_CHAIR = DECO.register("dark_oak_chair",
            () -> new BlockItem(ModBlocks.DARK_OAK_CHAIR.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_CHAIR = DECO.register("mangrove_chair",
            () -> new BlockItem(ModBlocks.MANGROVE_CHAIR.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_CHAIR = DECO.register("cherry_chair",
            () -> new BlockItem(ModBlocks.CHERRY_CHAIR.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_CHAIR = DECO.register("bamboo_chair",
            () -> new BlockItem(ModBlocks.BAMBOO_CHAIR.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_CHAIR = DECO.register("crimson_chair",
            () -> new BlockItem(ModBlocks.CRIMSON_CHAIR.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_CHAIR = DECO.register("warped_chair",
            () -> new BlockItem(ModBlocks.WARPED_CHAIR.get(), new Item.Properties()));

    ////////////////////////////////////// STOOLS ////////////////////////////////////

    public static final Supplier<Item> OAK_STOOL = DECO.register("oak_stool",
            () -> new BlockItem(ModBlocks.OAK_STOOL.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_STOOL = DECO.register("spruce_stool",
            () -> new BlockItem(ModBlocks.SPRUCE_STOOL.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_STOOL = DECO.register("birch_stool",
            () -> new BlockItem(ModBlocks.BIRCH_STOOL.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_STOOL = DECO.register("jungle_stool",
            () -> new BlockItem(ModBlocks.JUNGLE_STOOL.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_STOOL = DECO.register("acacia_stool",
            () -> new BlockItem(ModBlocks.ACACIA_STOOL.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_STOOL = DECO.register("dark_oak_stool",
            () -> new BlockItem(ModBlocks.DARK_OAK_STOOL.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_STOOL = DECO.register("mangrove_stool",
            () -> new BlockItem(ModBlocks.MANGROVE_STOOL.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_STOOL = DECO.register("cherry_stool",
            () -> new BlockItem(ModBlocks.CHERRY_STOOL.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_STOOL = DECO.register("bamboo_stool",
            () -> new BlockItem(ModBlocks.BAMBOO_STOOL.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_STOOL = DECO.register("crimson_stool",
            () -> new BlockItem(ModBlocks.CRIMSON_STOOL.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_STOOL = DECO.register("warped_stool",
            () -> new BlockItem(ModBlocks.WARPED_STOOL.get(), new Item.Properties()));

    ////////////////////////////////////// TABLES ////////////////////////////////////

    public static final Supplier<Item> OAK_TABLE = DECO.register("oak_table",
            () -> new BlockItem(ModBlocks.OAK_TABLE.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_TABLE = DECO.register("spruce_table",
            () -> new BlockItem(ModBlocks.SPRUCE_TABLE.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_TABLE = DECO.register("birch_table",
            () -> new BlockItem(ModBlocks.BIRCH_TABLE.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_TABLE = DECO.register("jungle_table",
            () -> new BlockItem(ModBlocks.JUNGLE_TABLE.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_TABLE = DECO.register("acacia_table",
            () -> new BlockItem(ModBlocks.ACACIA_TABLE.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_TABLE = DECO.register("dark_oak_table",
            () -> new BlockItem(ModBlocks.DARK_OAK_TABLE.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_TABLE = DECO.register("mangrove_table",
            () -> new BlockItem(ModBlocks.MANGROVE_TABLE.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_TABLE = DECO.register("cherry_table",
            () -> new BlockItem(ModBlocks.CHERRY_TABLE.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_TABLE = DECO.register("bamboo_table",
            () -> new BlockItem(ModBlocks.BAMBOO_TABLE.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_TABLE = DECO.register("crimson_table",
            () -> new BlockItem(ModBlocks.CRIMSON_TABLE.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_TABLE = DECO.register("warped_table",
            () -> new BlockItem(ModBlocks.WARPED_TABLE.get(), new Item.Properties()));

    ///////////////////////// COUNTERS + OVENS + SINKS + CABINETS  //////////////////////

    public static final Supplier<Item> OAK_COUNTER = DECO.register("oak_counter",
            () -> new BlockItem(ModBlocks.OAK_COUNTER.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_COUNTER_ISLAND = DECO.register("oak_counter_island",
            () -> new BlockItem(ModBlocks.OAK_COUNTER_ISLAND.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_COUNTER_CUPBOARD = DECO.register("oak_counter_cupboard",
            () -> new BlockItem(ModBlocks.OAK_COUNTER_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_COUNTER_DRAWER = DECO.register("oak_counter_drawer",
            () -> new BlockItem(ModBlocks.OAK_COUNTER_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_COUNTER_OVEN = DECO.register("oak_counter_oven",
            () -> new BlockItem(ModBlocks.OAK_COUNTER_OVEN.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_COUNTER_SINK = DECO.register("oak_counter_sink",
            () -> new BlockItem(ModBlocks.OAK_COUNTER_SINK.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_CABINET = DECO.register("oak_cabinet",
            () -> new BlockItem(ModBlocks.OAK_CABINET.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_CABINET_CUPBOARD = DECO.register("oak_cabinet_cupboard",
            () -> new BlockItem(ModBlocks.OAK_CABINET_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_CABINET_OVEN_VENT = DECO.register("oak_cabinet_oven_vent",
            () -> new BlockItem(ModBlocks.OAK_CABINET_OVEN_VENT.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_COUNTER = DECO.register("spruce_counter",
            () -> new BlockItem(ModBlocks.SPRUCE_COUNTER.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_COUNTER_ISLAND = DECO.register("spruce_counter_island",
            () -> new BlockItem(ModBlocks.SPRUCE_COUNTER_ISLAND.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_COUNTER_CUPBOARD = DECO.register("spruce_counter_cupboard",
            () -> new BlockItem(ModBlocks.SPRUCE_COUNTER_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_COUNTER_DRAWER = DECO.register("spruce_counter_drawer",
            () -> new BlockItem(ModBlocks.SPRUCE_COUNTER_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_COUNTER_OVEN = DECO.register("spruce_counter_oven",
            () -> new BlockItem(ModBlocks.SPRUCE_COUNTER_OVEN.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_COUNTER_SINK = DECO.register("spruce_counter_sink",
            () -> new BlockItem(ModBlocks.SPRUCE_COUNTER_SINK.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_CABINET = DECO.register("spruce_cabinet",
            () -> new BlockItem(ModBlocks.SPRUCE_CABINET.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_CABINET_CUPBOARD = DECO.register("spruce_cabinet_cupboard",
            () -> new BlockItem(ModBlocks.SPRUCE_CABINET_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_CABINET_OVEN_VENT = DECO.register("spruce_cabinet_oven_vent",
            () -> new BlockItem(ModBlocks.SPRUCE_CABINET_OVEN_VENT.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_COUNTER = DECO.register("birch_counter",
            () -> new BlockItem(ModBlocks.BIRCH_COUNTER.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_COUNTER_ISLAND = DECO.register("birch_counter_island",
            () -> new BlockItem(ModBlocks.BIRCH_COUNTER_ISLAND.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_COUNTER_CUPBOARD = DECO.register("birch_counter_cupboard",
            () -> new BlockItem(ModBlocks.BIRCH_COUNTER_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_COUNTER_DRAWER = DECO.register("birch_counter_drawer",
            () -> new BlockItem(ModBlocks.BIRCH_COUNTER_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_COUNTER_OVEN = DECO.register("birch_counter_oven",
            () -> new BlockItem(ModBlocks.BIRCH_COUNTER_OVEN.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_COUNTER_SINK = DECO.register("birch_counter_sink",
            () -> new BlockItem(ModBlocks.BIRCH_COUNTER_SINK.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_CABINET = DECO.register("birch_cabinet",
            () -> new BlockItem(ModBlocks.BIRCH_CABINET.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_CABINET_CUPBOARD = DECO.register("birch_cabinet_cupboard",
            () -> new BlockItem(ModBlocks.BIRCH_CABINET_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_CABINET_OVEN_VENT = DECO.register("birch_cabinet_oven_vent",
            () -> new BlockItem(ModBlocks.BIRCH_CABINET_OVEN_VENT.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_COUNTER = DECO.register("jungle_counter",
            () -> new BlockItem(ModBlocks.JUNGLE_COUNTER.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_COUNTER_ISLAND = DECO.register("jungle_counter_island",
            () -> new BlockItem(ModBlocks.JUNGLE_COUNTER_ISLAND.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_COUNTER_CUPBOARD = DECO.register("jungle_counter_cupboard",
            () -> new BlockItem(ModBlocks.JUNGLE_COUNTER_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_COUNTER_DRAWER = DECO.register("jungle_counter_drawer",
            () -> new BlockItem(ModBlocks.JUNGLE_COUNTER_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_COUNTER_OVEN = DECO.register("jungle_counter_oven",
            () -> new BlockItem(ModBlocks.JUNGLE_COUNTER_OVEN.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_COUNTER_SINK = DECO.register("jungle_counter_sink",
            () -> new BlockItem(ModBlocks.JUNGLE_COUNTER_SINK.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_CABINET = DECO.register("jungle_cabinet",
            () -> new BlockItem(ModBlocks.JUNGLE_CABINET.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_CABINET_CUPBOARD = DECO.register("jungle_cabinet_cupboard",
            () -> new BlockItem(ModBlocks.JUNGLE_CABINET_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_CABINET_OVEN_VENT = DECO.register("jungle_cabinet_oven_vent",
            () -> new BlockItem(ModBlocks.JUNGLE_CABINET_OVEN_VENT.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_COUNTER = DECO.register("acacia_counter",
            () -> new BlockItem(ModBlocks.ACACIA_COUNTER.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_COUNTER_ISLAND = DECO.register("acacia_counter_island",
            () -> new BlockItem(ModBlocks.ACACIA_COUNTER_ISLAND.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_COUNTER_CUPBOARD = DECO.register("acacia_counter_cupboard",
            () -> new BlockItem(ModBlocks.ACACIA_COUNTER_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_COUNTER_DRAWER = DECO.register("acacia_counter_drawer",
            () -> new BlockItem(ModBlocks.ACACIA_COUNTER_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_COUNTER_OVEN = DECO.register("acacia_counter_oven",
            () -> new BlockItem(ModBlocks.ACACIA_COUNTER_OVEN.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_COUNTER_SINK = DECO.register("acacia_counter_sink",
            () -> new BlockItem(ModBlocks.ACACIA_COUNTER_SINK.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_CABINET = DECO.register("acacia_cabinet",
            () -> new BlockItem(ModBlocks.ACACIA_CABINET.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_CABINET_CUPBOARD = DECO.register("acacia_cabinet_cupboard",
            () -> new BlockItem(ModBlocks.ACACIA_CABINET_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_CABINET_OVEN_VENT = DECO.register("acacia_cabinet_oven_vent",
            () -> new BlockItem(ModBlocks.ACACIA_CABINET_OVEN_VENT.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_COUNTER = DECO.register("dark_oak_counter",
            () -> new BlockItem(ModBlocks.DARK_OAK_COUNTER.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_COUNTER_ISLAND = DECO.register("dark_oak_counter_island",
            () -> new BlockItem(ModBlocks.DARK_OAK_COUNTER_ISLAND.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_COUNTER_CUPBOARD = DECO.register("dark_oak_counter_cupboard",
            () -> new BlockItem(ModBlocks.DARK_OAK_COUNTER_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_COUNTER_DRAWER = DECO.register("dark_oak_counter_drawer",
            () -> new BlockItem(ModBlocks.DARK_OAK_COUNTER_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_COUNTER_OVEN = DECO.register("dark_oak_counter_oven",
            () -> new BlockItem(ModBlocks.DARK_OAK_COUNTER_OVEN.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_COUNTER_SINK = DECO.register("dark_oak_counter_sink",
            () -> new BlockItem(ModBlocks.DARK_OAK_COUNTER_SINK.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_CABINET = DECO.register("dark_oak_cabinet",
            () -> new BlockItem(ModBlocks.DARK_OAK_CABINET.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_CABINET_CUPBOARD = DECO.register("dark_oak_cabinet_cupboard",
            () -> new BlockItem(ModBlocks.DARK_OAK_CABINET_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_CABINET_OVEN_VENT = DECO.register("dark_oak_cabinet_oven_vent",
            () -> new BlockItem(ModBlocks.DARK_OAK_CABINET_OVEN_VENT.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_COUNTER = DECO.register("mangrove_counter",
            () -> new BlockItem(ModBlocks.MANGROVE_COUNTER.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_COUNTER_ISLAND = DECO.register("mangrove_counter_island",
            () -> new BlockItem(ModBlocks.MANGROVE_COUNTER_ISLAND.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_COUNTER_CUPBOARD = DECO.register("mangrove_counter_cupboard",
            () -> new BlockItem(ModBlocks.MANGROVE_COUNTER_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_COUNTER_DRAWER = DECO.register("mangrove_counter_drawer",
            () -> new BlockItem(ModBlocks.MANGROVE_COUNTER_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_COUNTER_OVEN = DECO.register("mangrove_counter_oven",
            () -> new BlockItem(ModBlocks.MANGROVE_COUNTER_OVEN.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_COUNTER_SINK = DECO.register("mangrove_counter_sink",
            () -> new BlockItem(ModBlocks.MANGROVE_COUNTER_SINK.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_CABINET = DECO.register("mangrove_cabinet",
            () -> new BlockItem(ModBlocks.MANGROVE_CABINET.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_CABINET_CUPBOARD = DECO.register("mangrove_cabinet_cupboard",
            () -> new BlockItem(ModBlocks.MANGROVE_CABINET_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_CABINET_OVEN_VENT = DECO.register("mangrove_cabinet_oven_vent",
            () -> new BlockItem(ModBlocks.MANGROVE_CABINET_OVEN_VENT.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_COUNTER = DECO.register("cherry_counter",
            () -> new BlockItem(ModBlocks.CHERRY_COUNTER.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_COUNTER_ISLAND = DECO.register("cherry_counter_island",
            () -> new BlockItem(ModBlocks.CHERRY_COUNTER_ISLAND.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_COUNTER_CUPBOARD = DECO.register("cherry_counter_cupboard",
            () -> new BlockItem(ModBlocks.CHERRY_COUNTER_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_COUNTER_DRAWER = DECO.register("cherry_counter_drawer",
            () -> new BlockItem(ModBlocks.CHERRY_COUNTER_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_COUNTER_OVEN = DECO.register("cherry_counter_oven",
            () -> new BlockItem(ModBlocks.CHERRY_COUNTER_OVEN.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_COUNTER_SINK = DECO.register("cherry_counter_sink",
            () -> new BlockItem(ModBlocks.CHERRY_COUNTER_SINK.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_CABINET = DECO.register("cherry_cabinet",
            () -> new BlockItem(ModBlocks.CHERRY_CABINET.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_CABINET_CUPBOARD = DECO.register("cherry_cabinet_cupboard",
            () -> new BlockItem(ModBlocks.CHERRY_CABINET_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_CABINET_OVEN_VENT = DECO.register("cherry_cabinet_oven_vent",
            () -> new BlockItem(ModBlocks.CHERRY_CABINET_OVEN_VENT.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_COUNTER = DECO.register("bamboo_counter",
            () -> new BlockItem(ModBlocks.BAMBOO_COUNTER.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_COUNTER_ISLAND = DECO.register("bamboo_counter_island",
            () -> new BlockItem(ModBlocks.BAMBOO_COUNTER_ISLAND.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_COUNTER_CUPBOARD = DECO.register("bamboo_counter_cupboard",
            () -> new BlockItem(ModBlocks.BAMBOO_COUNTER_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_COUNTER_DRAWER = DECO.register("bamboo_counter_drawer",
            () -> new BlockItem(ModBlocks.BAMBOO_COUNTER_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_COUNTER_OVEN = DECO.register("bamboo_counter_oven",
            () -> new BlockItem(ModBlocks.BAMBOO_COUNTER_OVEN.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_COUNTER_SINK = DECO.register("bamboo_counter_sink",
            () -> new BlockItem(ModBlocks.BAMBOO_COUNTER_SINK.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_CABINET = DECO.register("bamboo_cabinet",
            () -> new BlockItem(ModBlocks.BAMBOO_CABINET.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_CABINET_CUPBOARD = DECO.register("bamboo_cabinet_cupboard",
            () -> new BlockItem(ModBlocks.BAMBOO_CABINET_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_CABINET_OVEN_VENT = DECO.register("bamboo_cabinet_oven_vent",
            () -> new BlockItem(ModBlocks.BAMBOO_CABINET_OVEN_VENT.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_COUNTER = DECO.register("crimson_counter",
            () -> new BlockItem(ModBlocks.CRIMSON_COUNTER.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_COUNTER_ISLAND = DECO.register("crimson_counter_island",
            () -> new BlockItem(ModBlocks.CRIMSON_COUNTER_ISLAND.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_COUNTER_CUPBOARD = DECO.register("crimson_counter_cupboard",
            () -> new BlockItem(ModBlocks.CRIMSON_COUNTER_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_COUNTER_DRAWER = DECO.register("crimson_counter_drawer",
            () -> new BlockItem(ModBlocks.CRIMSON_COUNTER_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_COUNTER_OVEN = DECO.register("crimson_counter_oven",
            () -> new BlockItem(ModBlocks.CRIMSON_COUNTER_OVEN.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_COUNTER_SINK = DECO.register("crimson_counter_sink",
            () -> new BlockItem(ModBlocks.CRIMSON_COUNTER_SINK.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_CABINET = DECO.register("crimson_cabinet",
            () -> new BlockItem(ModBlocks.CRIMSON_CABINET.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_CABINET_CUPBOARD = DECO.register("crimson_cabinet_cupboard",
            () -> new BlockItem(ModBlocks.CRIMSON_CABINET_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_CABINET_OVEN_VENT = DECO.register("crimson_cabinet_oven_vent",
            () -> new BlockItem(ModBlocks.CRIMSON_CABINET_OVEN_VENT.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_COUNTER = DECO.register("warped_counter",
            () -> new BlockItem(ModBlocks.WARPED_COUNTER.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_COUNTER_ISLAND = DECO.register("warped_counter_island",
            () -> new BlockItem(ModBlocks.WARPED_COUNTER_ISLAND.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_COUNTER_CUPBOARD = DECO.register("warped_counter_cupboard",
            () -> new BlockItem(ModBlocks.WARPED_COUNTER_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_COUNTER_DRAWER = DECO.register("warped_counter_drawer",
            () -> new BlockItem(ModBlocks.WARPED_COUNTER_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_COUNTER_OVEN = DECO.register("warped_counter_oven",
            () -> new BlockItem(ModBlocks.WARPED_COUNTER_OVEN.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_COUNTER_SINK = DECO.register("warped_counter_sink",
            () -> new BlockItem(ModBlocks.WARPED_COUNTER_SINK.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_CABINET = DECO.register("warped_cabinet",
            () -> new BlockItem(ModBlocks.WARPED_CABINET.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_CABINET_CUPBOARD = DECO.register("warped_cabinet_cupboard",
            () -> new BlockItem(ModBlocks.WARPED_CABINET_CUPBOARD.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_CABINET_OVEN_VENT = DECO.register("warped_cabinet_oven_vent",
            () -> new BlockItem(ModBlocks.WARPED_CABINET_OVEN_VENT.get(), new Item.Properties()));

    ////////////////////////////////////// DRAWERS ////////////////////////////////////

    public static final Supplier<Item> OAK_DRAWER = DECO.register("oak_drawer",
            () -> new BlockItem(ModBlocks.OAK_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_DRAWER = DECO.register("spruce_drawer",
            () -> new BlockItem(ModBlocks.SPRUCE_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_DRAWER = DECO.register("birch_drawer",
            () -> new BlockItem(ModBlocks.BIRCH_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_DRAWER = DECO.register("jungle_drawer",
            () -> new BlockItem(ModBlocks.JUNGLE_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_DRAWER = DECO.register("acacia_drawer",
            () -> new BlockItem(ModBlocks.ACACIA_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_DRAWER = DECO.register("dark_oak_drawer",
            () -> new BlockItem(ModBlocks.DARK_OAK_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_DRAWER = DECO.register("mangrove_drawer",
            () -> new BlockItem(ModBlocks.MANGROVE_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_DRAWER = DECO.register("cherry_drawer",
            () -> new BlockItem(ModBlocks.CHERRY_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_DRAWER = DECO.register("bamboo_drawer",
            () -> new BlockItem(ModBlocks.BAMBOO_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_DRAWER = DECO.register("crimson_drawer",
            () -> new BlockItem(ModBlocks.CRIMSON_DRAWER.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_DRAWER = DECO.register("warped_drawer",
            () -> new BlockItem(ModBlocks.WARPED_DRAWER.get(), new Item.Properties()));

    ////////////////////////////////////// DESKS ////////////////////////////////////

    ////////////////////////////////////// SHELFS ////////////////////////////////////

    public static final Supplier<Item> OAK_SHELF = DECO.register("oak_shelf",
            () -> new BlockItem(ModBlocks.OAK_SHELF.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_SHELF = DECO.register("spruce_shelf",
            () -> new BlockItem(ModBlocks.SPRUCE_SHELF.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_SHELF = DECO.register("birch_shelf",
            () -> new BlockItem(ModBlocks.BIRCH_SHELF.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_SHELF = DECO.register("jungle_shelf",
            () -> new BlockItem(ModBlocks.JUNGLE_SHELF.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_SHELF = DECO.register("acacia_shelf",
            () -> new BlockItem(ModBlocks.ACACIA_SHELF.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_SHELF = DECO.register("dark_oak_shelf",
            () -> new BlockItem(ModBlocks.DARK_OAK_SHELF.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_SHELF = DECO.register("mangrove_shelf",
            () -> new BlockItem(ModBlocks.MANGROVE_SHELF.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_SHELF = DECO.register("cherry_shelf",
            () -> new BlockItem(ModBlocks.CHERRY_SHELF.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_SHELF = DECO.register("bamboo_shelf",
            () -> new BlockItem(ModBlocks.BAMBOO_SHELF.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_SHELF = DECO.register("crimson_shelf",
            () -> new BlockItem(ModBlocks.CRIMSON_SHELF.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_SHELF = DECO.register("warped_shelf",
            () -> new BlockItem(ModBlocks.WARPED_SHELF.get(), new Item.Properties()));

    ////////////////////////////////////// MAILBOXES ////////////////////////////////////

    public static final Supplier<Item> OAK_MAILBOX = DECO.register("oak_mailbox",
            () -> new BlockItem(ModBlocks.OAK_MAILBOX.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_MAILBOX = DECO.register("spruce_mailbox",
            () -> new BlockItem(ModBlocks.SPRUCE_MAILBOX.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_MAILBOX = DECO.register("birch_mailbox",
            () -> new BlockItem(ModBlocks.BIRCH_MAILBOX.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_MAILBOX = DECO.register("jungle_mailbox",
            () -> new BlockItem(ModBlocks.JUNGLE_MAILBOX.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_MAILBOX = DECO.register("acacia_mailbox",
            () -> new BlockItem(ModBlocks.ACACIA_MAILBOX.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_MAILBOX = DECO.register("dark_oak_mailbox",
            () -> new BlockItem(ModBlocks.DARK_OAK_MAILBOX.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_MAILBOX = DECO.register("mangrove_mailbox",
            () -> new BlockItem(ModBlocks.MANGROVE_MAILBOX.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_MAILBOX = DECO.register("cherry_mailbox",
            () -> new BlockItem(ModBlocks.CHERRY_MAILBOX.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_MAILBOX = DECO.register("bamboo_mailbox",
            () -> new BlockItem(ModBlocks.BAMBOO_MAILBOX.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_MAILBOX = DECO.register("crimson_mailbox",
            () -> new BlockItem(ModBlocks.CRIMSON_MAILBOX.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_MAILBOX = DECO.register("warped_mailbox",
            () -> new BlockItem(ModBlocks.WARPED_MAILBOX.get(), new Item.Properties()));

    ////////////////////////////////////// WARDROBES ////////////////////////////////////

    public static final Supplier<Item> OAK_WARDROBE = DECO.register("oak_wardrobe",
            () -> new BlockItem(ModBlocks.OAK_WARDROBE.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_WARDROBE = DECO.register("spruce_wardrobe",
            () -> new BlockItem(ModBlocks.SPRUCE_WARDROBE.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_WARDROBE = DECO.register("birch_wardrobe",
            () -> new BlockItem(ModBlocks.BIRCH_WARDROBE.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_WARDROBE = DECO.register("jungle_wardrobe",
            () -> new BlockItem(ModBlocks.JUNGLE_WARDROBE.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_WARDROBE = DECO.register("acacia_wardrobe",
            () -> new BlockItem(ModBlocks.ACACIA_WARDROBE.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_WARDROBE = DECO.register("dark_oak_wardrobe",
            () -> new BlockItem(ModBlocks.DARK_OAK_WARDROBE.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_WARDROBE = DECO.register("mangrove_wardrobe",
            () -> new BlockItem(ModBlocks.MANGROVE_WARDROBE.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_WARDROBE = DECO.register("cherry_wardrobe",
            () -> new BlockItem(ModBlocks.CHERRY_WARDROBE.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_WARDROBE = DECO.register("bamboo_wardrobe",
            () -> new BlockItem(ModBlocks.BAMBOO_WARDROBE.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_WARDROBE = DECO.register("crimson_wardrobe",
            () -> new BlockItem(ModBlocks.CRIMSON_WARDROBE.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_WARDROBE = DECO.register("warped_wardrobe",
            () -> new BlockItem(ModBlocks.WARPED_WARDROBE.get(), new Item.Properties()));

    ////////////////////////////////////// BLINDS ////////////////////////////////////

    public static final Supplier<Item> OAK_BLINDS = DECO.register("oak_blinds",
            () -> new BlockItem(ModBlocks.OAK_BLINDS.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_BLINDS = DECO.register("spruce_blinds",
            () -> new BlockItem(ModBlocks.SPRUCE_BLINDS.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_BLINDS = DECO.register("birch_blinds",
            () -> new BlockItem(ModBlocks.BIRCH_BLINDS.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_BLINDS = DECO.register("jungle_blinds",
            () -> new BlockItem(ModBlocks.JUNGLE_BLINDS.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_BLINDS = DECO.register("acacia_blinds",
            () -> new BlockItem(ModBlocks.ACACIA_BLINDS.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_BLINDS = DECO.register("dark_oak_blinds",
            () -> new BlockItem(ModBlocks.DARK_OAK_BLINDS.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_BLINDS = DECO.register("mangrove_blinds",
            () -> new BlockItem(ModBlocks.MANGROVE_BLINDS.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_BLINDS = DECO.register("cherry_blinds",
            () -> new BlockItem(ModBlocks.CHERRY_BLINDS.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_BLINDS = DECO.register("bamboo_blinds",
            () -> new BlockItem(ModBlocks.BAMBOO_BLINDS.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_BLINDS = DECO.register("crimson_blinds",
            () -> new BlockItem(ModBlocks.CRIMSON_BLINDS.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_BLINDS = DECO.register("warped_blinds",
            () -> new BlockItem(ModBlocks.WARPED_BLINDS.get(), new Item.Properties()));

    ////////////////////////////////////// TOMBSTONES ////////////////////////////////////

    public static final Supplier<Item> OAK_TOMBSTONE = DECO.register("oak_tombstone",
            () -> new BlockItem(ModBlocks.OAK_TOMBSTONE.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_TOMBSTONE = DECO.register("spruce_tombstone",
            () -> new BlockItem(ModBlocks.SPRUCE_TOMBSTONE.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_TOMBSTONE = DECO.register("birch_tombstone",
            () -> new BlockItem(ModBlocks.BIRCH_TOMBSTONE.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_TOMBSTONE = DECO.register("jungle_tombstone",
            () -> new BlockItem(ModBlocks.JUNGLE_TOMBSTONE.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_TOMBSTONE = DECO.register("acacia_tombstone",
            () -> new BlockItem(ModBlocks.ACACIA_TOMBSTONE.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_TOMBSTONE = DECO.register("dark_oak_tombstone",
            () -> new BlockItem(ModBlocks.DARK_OAK_TOMBSTONE.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_TOMBSTONE = DECO.register("mangrove_tombstone",
            () -> new BlockItem(ModBlocks.MANGROVE_TOMBSTONE.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_TOMBSTONE = DECO.register("cherry_tombstone",
            () -> new BlockItem(ModBlocks.CHERRY_TOMBSTONE.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_TOMBSTONE = DECO.register("bamboo_tombstone",
            () -> new BlockItem(ModBlocks.BAMBOO_TOMBSTONE.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_TOMBSTONE = DECO.register("crimson_tombstone",
            () -> new BlockItem(ModBlocks.CRIMSON_TOMBSTONE.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_TOMBSTONE = DECO.register("warped_tombstone",
            () -> new BlockItem(ModBlocks.WARPED_TOMBSTONE.get(), new Item.Properties()));

    ////////////////////////////////////// STAIRS ////////////////////////////////////

    public static final Supplier<Item> OAK_STAIR = DECO.register("oak_stair",
            () -> new BlockItem(ModBlocks.OAK_STAIR.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_STAIR = DECO.register("spruce_stair",
            () -> new BlockItem(ModBlocks.SPRUCE_STAIR.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_STAIR = DECO.register("birch_stair",
            () -> new BlockItem(ModBlocks.BIRCH_STAIR.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_STAIR = DECO.register("jungle_stair",
            () -> new BlockItem(ModBlocks.JUNGLE_STAIR.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_STAIR = DECO.register("acacia_stair",
            () -> new BlockItem(ModBlocks.ACACIA_STAIR.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_STAIR = DECO.register("dark_oak_stair",
            () -> new BlockItem(ModBlocks.DARK_OAK_STAIR.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_STAIR = DECO.register("mangrove_stair",
            () -> new BlockItem(ModBlocks.MANGROVE_STAIR.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_STAIR = DECO.register("cherry_stair",
            () -> new BlockItem(ModBlocks.CHERRY_STAIR.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_STAIR = DECO.register("bamboo_stair",
            () -> new BlockItem(ModBlocks.BAMBOO_STAIR.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_STAIR = DECO.register("crimson_stair",
            () -> new BlockItem(ModBlocks.CRIMSON_STAIR.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_STAIR = DECO.register("warped_stair",
            () -> new BlockItem(ModBlocks.WARPED_STAIR.get(), new Item.Properties()));

    ////////////////////////////////////// PLATFORMS ////////////////////////////////////

    public static final Supplier<Item> OAK_PLATFORM = DECO.register("oak_platform",
            () -> new BlockItem(ModBlocks.OAK_PLATFORM.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_PLATFORM = DECO.register("spruce_platform",
            () -> new BlockItem(ModBlocks.SPRUCE_PLATFORM.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_PLATFORM = DECO.register("birch_platform",
            () -> new BlockItem(ModBlocks.BIRCH_PLATFORM.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_PLATFORM = DECO.register("jungle_platform",
            () -> new BlockItem(ModBlocks.JUNGLE_PLATFORM.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_PLATFORM = DECO.register("acacia_platform",
            () -> new BlockItem(ModBlocks.ACACIA_PLATFORM.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_PLATFORM = DECO.register("dark_oak_platform",
            () -> new BlockItem(ModBlocks.DARK_OAK_PLATFORM.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_PLATFORM = DECO.register("mangrove_platform",
            () -> new BlockItem(ModBlocks.MANGROVE_PLATFORM.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_PLATFORM = DECO.register("cherry_platform",
            () -> new BlockItem(ModBlocks.CHERRY_PLATFORM.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_PLATFORM = DECO.register("bamboo_platform",
            () -> new BlockItem(ModBlocks.BAMBOO_PLATFORM.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_PLATFORM = DECO.register("crimson_platform",
            () -> new BlockItem(ModBlocks.CRIMSON_PLATFORM.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_PLATFORM = DECO.register("warped_platform",
            () -> new BlockItem(ModBlocks.WARPED_PLATFORM.get(), new Item.Properties()));

    ////////////////////////////////////// RAILINGS ////////////////////////////////////

    public static final Supplier<Item> OAK_RAILING = DECO.register("oak_railing",
            () -> new BlockItem(ModBlocks.OAK_RAILING.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_RAILING = DECO.register("spruce_railing",
            () -> new BlockItem(ModBlocks.SPRUCE_RAILING.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_RAILING = DECO.register("birch_railing",
            () -> new BlockItem(ModBlocks.BIRCH_RAILING.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_RAILING = DECO.register("jungle_railing",
            () -> new BlockItem(ModBlocks.JUNGLE_RAILING.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_RAILING = DECO.register("acacia_railing",
            () -> new BlockItem(ModBlocks.ACACIA_RAILING.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_RAILING = DECO.register("dark_oak_railing",
            () -> new BlockItem(ModBlocks.DARK_OAK_RAILING.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_RAILING = DECO.register("mangrove_railing",
            () -> new BlockItem(ModBlocks.MANGROVE_RAILING.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_RAILING = DECO.register("cherry_railing",
            () -> new BlockItem(ModBlocks.CHERRY_RAILING.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_RAILING = DECO.register("bamboo_railing",
            () -> new BlockItem(ModBlocks.BAMBOO_RAILING.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_RAILING = DECO.register("crimson_railing",
            () -> new BlockItem(ModBlocks.CRIMSON_RAILING.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_RAILING = DECO.register("warped_railing",
            () -> new BlockItem(ModBlocks.WARPED_RAILING.get(), new Item.Properties()));

    ////////////////////////////////////// ROOFS ////////////////////////////////////

    public static final Supplier<Item> OAK_ROOF = DECO.register("oak_roof",
            () -> new BlockItem(ModBlocks.OAK_ROOF.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_ROOF_SHALLOW = DECO.register("oak_roof_shallow",
            () -> new BlockItem(ModBlocks.OAK_ROOF_SHALLOW.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_ROOF_STEEP = DECO.register("oak_roof_steep",
            () -> new BlockItem(ModBlocks.OAK_ROOF_STEEP.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_ROOF = DECO.register("spruce_roof",
            () -> new BlockItem(ModBlocks.SPRUCE_ROOF.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_ROOF_SHALLOW = DECO.register("spruce_roof_shallow",
            () -> new BlockItem(ModBlocks.SPRUCE_ROOF_SHALLOW.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_ROOF_STEEP = DECO.register("spruce_roof_steep",
            () -> new BlockItem(ModBlocks.SPRUCE_ROOF_STEEP.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_ROOF = DECO.register("birch_roof",
            () -> new BlockItem(ModBlocks.BIRCH_ROOF.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_ROOF_SHALLOW = DECO.register("birch_roof_shallow",
            () -> new BlockItem(ModBlocks.BIRCH_ROOF_SHALLOW.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_ROOF_STEEP = DECO.register("birch_roof_steep",
            () -> new BlockItem(ModBlocks.BIRCH_ROOF_STEEP.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_ROOF = DECO.register("jungle_roof",
            () -> new BlockItem(ModBlocks.JUNGLE_ROOF.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_ROOF_SHALLOW = DECO.register("jungle_roof_shallow",
            () -> new BlockItem(ModBlocks.JUNGLE_ROOF_SHALLOW.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_ROOF_STEEP = DECO.register("jungle_roof_steep",
            () -> new BlockItem(ModBlocks.JUNGLE_ROOF_STEEP.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_ROOF = DECO.register("acacia_roof",
            () -> new BlockItem(ModBlocks.ACACIA_ROOF.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_ROOF_SHALLOW = DECO.register("acacia_roof_shallow",
            () -> new BlockItem(ModBlocks.ACACIA_ROOF_SHALLOW.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_ROOF_STEEP = DECO.register("acacia_roof_steep",
            () -> new BlockItem(ModBlocks.ACACIA_ROOF_STEEP.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_ROOF = DECO.register("dark_oak_roof",
            () -> new BlockItem(ModBlocks.DARK_OAK_ROOF.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_ROOF_SHALLOW = DECO.register("dark_oak_roof_shallow",
            () -> new BlockItem(ModBlocks.DARK_OAK_ROOF_SHALLOW.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_ROOF_STEEP = DECO.register("dark_oak_roof_steep",
            () -> new BlockItem(ModBlocks.DARK_OAK_ROOF_STEEP.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_ROOF = DECO.register("mangrove_roof",
            () -> new BlockItem(ModBlocks.MANGROVE_ROOF.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_ROOF_SHALLOW = DECO.register("mangrove_roof_shallow",
            () -> new BlockItem(ModBlocks.MANGROVE_ROOF_SHALLOW.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_ROOF_STEEP = DECO.register("mangrove_roof_steep",
            () -> new BlockItem(ModBlocks.MANGROVE_ROOF_STEEP.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_ROOF = DECO.register("cherry_roof",
            () -> new BlockItem(ModBlocks.CHERRY_ROOF.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_ROOF_SHALLOW = DECO.register("cherry_roof_shallow",
            () -> new BlockItem(ModBlocks.CHERRY_ROOF_SHALLOW.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_ROOF_STEEP = DECO.register("cherry_roof_steep",
            () -> new BlockItem(ModBlocks.CHERRY_ROOF_STEEP.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_ROOF = DECO.register("bamboo_roof",
            () -> new BlockItem(ModBlocks.BAMBOO_ROOF.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_ROOF_SHALLOW = DECO.register("bamboo_roof_shallow",
            () -> new BlockItem(ModBlocks.BAMBOO_ROOF_SHALLOW.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_ROOF_STEEP = DECO.register("bamboo_roof_steep",
            () -> new BlockItem(ModBlocks.BAMBOO_ROOF_STEEP.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_ROOF = DECO.register("crimson_roof",
            () -> new BlockItem(ModBlocks.CRIMSON_ROOF.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_ROOF_SHALLOW = DECO.register("crimson_roof_shallow",
            () -> new BlockItem(ModBlocks.CRIMSON_ROOF_SHALLOW.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_ROOF_STEEP = DECO.register("crimson_roof_steep",
            () -> new BlockItem(ModBlocks.CRIMSON_ROOF_STEEP.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_ROOF = DECO.register("warped_roof",
            () -> new BlockItem(ModBlocks.WARPED_ROOF.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_ROOF_SHALLOW = DECO.register("warped_roof_shallow",
            () -> new BlockItem(ModBlocks.WARPED_ROOF_SHALLOW.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_ROOF_STEEP = DECO.register("warped_roof_steep",
            () -> new BlockItem(ModBlocks.WARPED_ROOF_STEEP.get(), new Item.Properties()));

    ////////////////////////////////////// DOORS ////////////////////////////////////

    public static final Supplier<Item> BOOKSHELF_HIDDEN_DOOR = DECO.register("bookshelf_hidden_door",
            () -> new BlockItem(ModBlocks.BOOKSHELF_HIDDEN_DOOR.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_HIDDEN_DOOR = DECO.register("oak_planks_hidden_door",
            () -> new BlockItem(ModBlocks.OAK_PLANKS_HIDDEN_DOOR.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_HIDDEN_DOOR = DECO.register("spruce_planks_hidden_door",
            () -> new BlockItem(ModBlocks.SPRUCE_PLANKS_HIDDEN_DOOR.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_HIDDEN_DOOR = DECO.register("birch_planks_hidden_door",
            () -> new BlockItem(ModBlocks.BIRCH_PLANKS_HIDDEN_DOOR.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_HIDDEN_DOOR = DECO.register("jungle_planks_hidden_door",
            () -> new BlockItem(ModBlocks.JUNGLE_PLANKS_HIDDEN_DOOR.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_HIDDEN_DOOR = DECO.register("acacia_planks_hidden_door",
            () -> new BlockItem(ModBlocks.ACACIA_PLANKS_HIDDEN_DOOR.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_HIDDEN_DOOR = DECO.register("dark_oak_planks_hidden_door",
            () -> new BlockItem(ModBlocks.DARK_OAK_PLANKS_HIDDEN_DOOR.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_HIDDEN_DOOR = DECO.register("mangrove_planks_hidden_door",
            () -> new BlockItem(ModBlocks.MANGROVE_PLANKS_HIDDEN_DOOR.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_HIDDEN_DOOR = DECO.register("cherry_planks_hidden_door",
            () -> new BlockItem(ModBlocks.CHERRY_PLANKS_HIDDEN_DOOR.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_HIDDEN_DOOR = DECO.register("bamboo_planks_hidden_door",
            () -> new BlockItem(ModBlocks.BAMBOO_PLANKS_HIDDEN_DOOR.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_HIDDEN_DOOR = DECO.register("crimson_planks_hidden_door",
            () -> new BlockItem(ModBlocks.CRIMSON_PLANKS_HIDDEN_DOOR.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_HIDDEN_DOOR = DECO.register("warped_planks_hidden_door",
            () -> new BlockItem(ModBlocks.WARPED_PLANKS_HIDDEN_DOOR.get(), new Item.Properties()));

    ////////////////////////////////////// FENCES ////////////////////////////////////

    public static final Supplier<Item> OAK_UPGRADED_FENCE = DECO.register("oak_upgraded_fence",
            () -> new BlockItem(ModBlocks.OAK_UPGRADED_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_UPGRADED_FENCE_GATE = DECO.register("oak_upgraded_fence_gate",
            () -> new BlockItem(ModBlocks.OAK_UPGRADED_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_UPGRADED_FENCE = DECO.register("spruce_upgraded_fence",
            () -> new BlockItem(ModBlocks.SPRUCE_UPGRADED_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_UPGRADED_FENCE_GATE = DECO.register("spruce_upgraded_fence_gate",
            () -> new BlockItem(ModBlocks.SPRUCE_UPGRADED_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_UPGRADED_FENCE = DECO.register("birch_upgraded_fence",
            () -> new BlockItem(ModBlocks.BIRCH_UPGRADED_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_UPGRADED_FENCE_GATE = DECO.register("birch_upgraded_fence_gate",
            () -> new BlockItem(ModBlocks.BIRCH_UPGRADED_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_UPGRADED_FENCE = DECO.register("jungle_upgraded_fence",
            () -> new BlockItem(ModBlocks.JUNGLE_UPGRADED_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_UPGRADED_FENCE_GATE = DECO.register("jungle_upgraded_fence_gate",
            () -> new BlockItem(ModBlocks.JUNGLE_UPGRADED_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_UPGRADED_FENCE = DECO.register("acacia_upgraded_fence",
            () -> new BlockItem(ModBlocks.ACACIA_UPGRADED_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_UPGRADED_FENCE_GATE = DECO.register("acacia_upgraded_fence_gate",
            () -> new BlockItem(ModBlocks.ACACIA_UPGRADED_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_UPGRADED_FENCE = DECO.register("dark_oak_upgraded_fence",
            () -> new BlockItem(ModBlocks.DARK_OAK_UPGRADED_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_UPGRADED_FENCE_GATE = DECO.register("dark_oak_upgraded_fence_gate",
            () -> new BlockItem(ModBlocks.DARK_OAK_UPGRADED_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_UPGRADED_FENCE = DECO.register("mangrove_upgraded_fence",
            () -> new BlockItem(ModBlocks.MANGROVE_UPGRADED_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_UPGRADED_FENCE_GATE = DECO.register("mangrove_upgraded_fence_gate",
            () -> new BlockItem(ModBlocks.MANGROVE_UPGRADED_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_UPGRADED_FENCE = DECO.register("cherry_upgraded_fence",
            () -> new BlockItem(ModBlocks.CHERRY_UPGRADED_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_UPGRADED_FENCE_GATE = DECO.register("cherry_upgraded_fence_gate",
            () -> new BlockItem(ModBlocks.CHERRY_UPGRADED_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_UPGRADED_FENCE = DECO.register("bamboo_upgraded_fence",
            () -> new BlockItem(ModBlocks.BAMBOO_UPGRADED_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_UPGRADED_FENCE_GATE = DECO.register("bamboo_upgraded_fence_gate",
            () -> new BlockItem(ModBlocks.BAMBOO_UPGRADED_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_UPGRADED_FENCE = DECO.register("crimson_upgraded_fence",
            () -> new BlockItem(ModBlocks.CRIMSON_UPGRADED_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_UPGRADED_FENCE_GATE = DECO.register("crimson_upgraded_fence_gate",
            () -> new BlockItem(ModBlocks.CRIMSON_UPGRADED_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_UPGRADED_FENCE = DECO.register("warped_upgraded_fence",
            () -> new BlockItem(ModBlocks.WARPED_UPGRADED_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_UPGRADED_FENCE_GATE = DECO.register("warped_upgraded_fence_gate",
            () -> new BlockItem(ModBlocks.WARPED_UPGRADED_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_CHAIN_LINK_FENCE = DECO.register("oak_chain_link_fence",
            () -> new BlockItem(ModBlocks.OAK_CHAIN_LINK_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_CHAIN_LINK_FENCE_GATE = DECO.register("oak_chain_link_fence_gate",
            () -> new BlockItem(ModBlocks.OAK_CHAIN_LINK_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_CHAIN_LINK_FENCE = DECO.register("spruce_chain_link_fence",
            () -> new BlockItem(ModBlocks.SPRUCE_CHAIN_LINK_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_CHAIN_LINK_FENCE_GATE = DECO.register("spruce_chain_link_fence_gate",
            () -> new BlockItem(ModBlocks.SPRUCE_CHAIN_LINK_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_CHAIN_LINK_FENCE = DECO.register("birch_chain_link_fence",
            () -> new BlockItem(ModBlocks.BIRCH_CHAIN_LINK_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_CHAIN_LINK_FENCE_GATE = DECO.register("birch_chain_link_fence_gate",
            () -> new BlockItem(ModBlocks.BIRCH_CHAIN_LINK_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_CHAIN_LINK_FENCE = DECO.register("jungle_chain_link_fence",
            () -> new BlockItem(ModBlocks.JUNGLE_CHAIN_LINK_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_CHAIN_LINK_FENCE_GATE = DECO.register("jungle_chain_link_fence_gate",
            () -> new BlockItem(ModBlocks.JUNGLE_CHAIN_LINK_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_CHAIN_LINK_FENCE = DECO.register("acacia_chain_link_fence",
            () -> new BlockItem(ModBlocks.ACACIA_CHAIN_LINK_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_CHAIN_LINK_FENCE_GATE = DECO.register("acacia_chain_link_fence_gate",
            () -> new BlockItem(ModBlocks.ACACIA_CHAIN_LINK_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_CHAIN_LINK_FENCE = DECO.register("dark_oak_chain_link_fence",
            () -> new BlockItem(ModBlocks.DARK_OAK_CHAIN_LINK_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_CHAIN_LINK_FENCE_GATE = DECO.register("dark_oak_chain_link_fence_gate",
            () -> new BlockItem(ModBlocks.DARK_OAK_CHAIN_LINK_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_CHAIN_LINK_FENCE = DECO.register("mangrove_chain_link_fence",
            () -> new BlockItem(ModBlocks.MANGROVE_CHAIN_LINK_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_CHAIN_LINK_FENCE_GATE = DECO.register("mangrove_chain_link_fence_gate",
            () -> new BlockItem(ModBlocks.MANGROVE_CHAIN_LINK_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_CHAIN_LINK_FENCE = DECO.register("cherry_chain_link_fence",
            () -> new BlockItem(ModBlocks.CHERRY_CHAIN_LINK_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_CHAIN_LINK_FENCE_GATE = DECO.register("cherry_chain_link_fence_gate",
            () -> new BlockItem(ModBlocks.CHERRY_CHAIN_LINK_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_CHAIN_LINK_FENCE = DECO.register("bamboo_chain_link_fence",
            () -> new BlockItem(ModBlocks.BAMBOO_CHAIN_LINK_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_CHAIN_LINK_FENCE_GATE = DECO.register("bamboo_chain_link_fence_gate",
            () -> new BlockItem(ModBlocks.BAMBOO_CHAIN_LINK_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_CHAIN_LINK_FENCE = DECO.register("crimson_chain_link_fence",
            () -> new BlockItem(ModBlocks.CRIMSON_CHAIN_LINK_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_CHAIN_LINK_FENCE_GATE = DECO.register("crimson_chain_link_fence_gate",
            () -> new BlockItem(ModBlocks.CRIMSON_CHAIN_LINK_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_CHAIN_LINK_FENCE = DECO.register("warped_chain_link_fence",
            () -> new BlockItem(ModBlocks.WARPED_CHAIN_LINK_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_CHAIN_LINK_FENCE_GATE = DECO.register("warped_chain_link_fence_gate",
            () -> new BlockItem(ModBlocks.WARPED_CHAIN_LINK_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_LOG_FENCE = DECO.register("oak_log_fence",
            () -> new BlockItem(ModBlocks.OAK_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_LOG_FENCE_GATE = DECO.register("oak_log_fence_gate",
            () -> new BlockItem(ModBlocks.OAK_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_LOG_FENCE = DECO.register("spruce_log_fence",
            () -> new BlockItem(ModBlocks.SPRUCE_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_LOG_FENCE_GATE = DECO.register("spruce_log_fence_gate",
            () -> new BlockItem(ModBlocks.SPRUCE_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_LOG_FENCE = DECO.register("birch_log_fence",
            () -> new BlockItem(ModBlocks.BIRCH_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_LOG_FENCE_GATE = DECO.register("birch_log_fence_gate",
            () -> new BlockItem(ModBlocks.BIRCH_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_LOG_FENCE = DECO.register("jungle_log_fence",
            () -> new BlockItem(ModBlocks.JUNGLE_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_LOG_FENCE_GATE = DECO.register("jungle_log_fence_gate",
            () -> new BlockItem(ModBlocks.JUNGLE_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_LOG_FENCE = DECO.register("acacia_log_fence",
            () -> new BlockItem(ModBlocks.ACACIA_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_LOG_FENCE_GATE = DECO.register("acacia_log_fence_gate",
            () -> new BlockItem(ModBlocks.ACACIA_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_LOG_FENCE = DECO.register("dark_oak_log_fence",
            () -> new BlockItem(ModBlocks.DARK_OAK_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_LOG_FENCE_GATE = DECO.register("dark_oak_log_fence_gate",
            () -> new BlockItem(ModBlocks.DARK_OAK_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_LOG_FENCE = DECO.register("mangrove_log_fence",
            () -> new BlockItem(ModBlocks.MANGROVE_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_LOG_FENCE_GATE = DECO.register("mangrove_log_fence_gate",
            () -> new BlockItem(ModBlocks.MANGROVE_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_LOG_FENCE = DECO.register("cherry_log_fence",
            () -> new BlockItem(ModBlocks.CHERRY_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_LOG_FENCE_GATE = DECO.register("cherry_log_fence_gate",
            () -> new BlockItem(ModBlocks.CHERRY_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_LOG_FENCE = DECO.register("bamboo_log_fence",
            () -> new BlockItem(ModBlocks.BAMBOO_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_LOG_FENCE_GATE = DECO.register("bamboo_log_fence_gate",
            () -> new BlockItem(ModBlocks.BAMBOO_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_LOG_FENCE = DECO.register("crimson_log_fence",
            () -> new BlockItem(ModBlocks.CRIMSON_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_LOG_FENCE_GATE = DECO.register("crimson_log_fence_gate",
            () -> new BlockItem(ModBlocks.CRIMSON_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_LOG_FENCE = DECO.register("warped_log_fence",
            () -> new BlockItem(ModBlocks.WARPED_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_LOG_FENCE_GATE = DECO.register("warped_log_fence_gate",
            () -> new BlockItem(ModBlocks.WARPED_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_STRIPPED_LOG_FENCE = DECO.register("oak_stripped_log_fence",
            () -> new BlockItem(ModBlocks.OAK_STRIPPED_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_STRIPPED_LOG_FENCE_GATE = DECO.register("oak_stripped_log_fence_gate",
            () -> new BlockItem(ModBlocks.OAK_STRIPPED_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_STRIPPED_LOG_FENCE = DECO.register("spruce_stripped_log_fence",
            () -> new BlockItem(ModBlocks.SPRUCE_STRIPPED_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_STRIPPED_LOG_FENCE_GATE = DECO.register("spruce_stripped_log_fence_gate",
            () -> new BlockItem(ModBlocks.SPRUCE_STRIPPED_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_STRIPPED_LOG_FENCE = DECO.register("birch_stripped_log_fence",
            () -> new BlockItem(ModBlocks.BIRCH_STRIPPED_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_STRIPPED_LOG_FENCE_GATE = DECO.register("birch_stripped_log_fence_gate",
            () -> new BlockItem(ModBlocks.BIRCH_STRIPPED_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_STRIPPED_LOG_FENCE = DECO.register("jungle_stripped_log_fence",
            () -> new BlockItem(ModBlocks.JUNGLE_STRIPPED_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_STRIPPED_LOG_FENCE_GATE = DECO.register("jungle_stripped_log_fence_gate",
            () -> new BlockItem(ModBlocks.JUNGLE_STRIPPED_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_STRIPPED_LOG_FENCE = DECO.register("acacia_stripped_log_fence",
            () -> new BlockItem(ModBlocks.ACACIA_STRIPPED_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_STRIPPED_LOG_FENCE_GATE = DECO.register("acacia_stripped_log_fence_gate",
            () -> new BlockItem(ModBlocks.ACACIA_STRIPPED_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_STRIPPED_LOG_FENCE = DECO.register("dark_oak_stripped_log_fence",
            () -> new BlockItem(ModBlocks.DARK_OAK_STRIPPED_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_STRIPPED_LOG_FENCE_GATE = DECO.register("dark_oak_stripped_log_fence_gate",
            () -> new BlockItem(ModBlocks.DARK_OAK_STRIPPED_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_STRIPPED_LOG_FENCE = DECO.register("mangrove_stripped_log_fence",
            () -> new BlockItem(ModBlocks.MANGROVE_STRIPPED_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_STRIPPED_LOG_FENCE_GATE = DECO.register("mangrove_stripped_log_fence_gate",
            () -> new BlockItem(ModBlocks.MANGROVE_STRIPPED_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_STRIPPED_LOG_FENCE = DECO.register("cherry_stripped_log_fence",
            () -> new BlockItem(ModBlocks.CHERRY_STRIPPED_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_STRIPPED_LOG_FENCE_GATE = DECO.register("cherry_stripped_log_fence_gate",
            () -> new BlockItem(ModBlocks.CHERRY_STRIPPED_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_STRIPPED_LOG_FENCE = DECO.register("bamboo_stripped_log_fence",
            () -> new BlockItem(ModBlocks.BAMBOO_STRIPPED_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_STRIPPED_LOG_FENCE_GATE = DECO.register("bamboo_stripped_log_fence_gate",
            () -> new BlockItem(ModBlocks.BAMBOO_STRIPPED_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_STRIPPED_LOG_FENCE = DECO.register("crimson_stripped_log_fence",
            () -> new BlockItem(ModBlocks.CRIMSON_STRIPPED_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_STRIPPED_LOG_FENCE_GATE = DECO.register("crimson_stripped_log_fence_gate",
            () -> new BlockItem(ModBlocks.CRIMSON_STRIPPED_LOG_FENCE_GATE.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_STRIPPED_LOG_FENCE = DECO.register("warped_stripped_log_fence",
            () -> new BlockItem(ModBlocks.WARPED_STRIPPED_LOG_FENCE.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_STRIPPED_LOG_FENCE_GATE = DECO.register("warped_stripped_log_fence_gate",
            () -> new BlockItem(ModBlocks.WARPED_STRIPPED_LOG_FENCE_GATE.get(), new Item.Properties()));

    ////////////////////////////////////// BUSHES ////////////////////////////////////

    public static final Supplier<Item> OAK_BUSH = DECO.register("oak_bush",
            () -> new BlockItem(ModBlocks.OAK_BUSH.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_BUSH = DECO.register("spruce_bush",
            () -> new BlockItem(ModBlocks.SPRUCE_BUSH.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_BUSH = DECO.register("birch_bush",
            () -> new BlockItem(ModBlocks.BIRCH_BUSH.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_BUSH = DECO.register("jungle_bush",
            () -> new BlockItem(ModBlocks.JUNGLE_BUSH.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_BUSH = DECO.register("acacia_bush",
            () -> new BlockItem(ModBlocks.ACACIA_BUSH.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_BUSH = DECO.register("dark_oak_bush",
            () -> new BlockItem(ModBlocks.DARK_OAK_BUSH.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_BUSH = DECO.register("mangrove_bush",
            () -> new BlockItem(ModBlocks.MANGROVE_BUSH.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_BUSH = DECO.register("cherry_bush",
            () -> new BlockItem(ModBlocks.CHERRY_BUSH.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_BUSH = DECO.register("crimson_bush",
            () -> new BlockItem(ModBlocks.CRIMSON_BUSH.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_BUSH = DECO.register("warped_bush",
            () -> new BlockItem(ModBlocks.WARPED_BUSH.get(), new Item.Properties()));

    public static final Supplier<Item> AZALEA_BUSH = DECO.register("azalea_bush",
            () -> new BlockItem(ModBlocks.AZALEA_BUSH.get(), new Item.Properties()));

    public static final Supplier<Item> FLOWERING_AZALEA_BUSH = DECO.register("flowering_azalea_bush",
            () -> new BlockItem(ModBlocks.FLOWERING_AZALEA_BUSH.get(), new Item.Properties()));

    ////////////////////////////////////// HOLLOW LOGS ////////////////////////////////////

    public static final Supplier<Item> OAK_HOLLOW_LOG = DECO.register("oak_hollow_log",
            () -> new BlockItem(ModBlocks.OAK_HOLLOW_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> OAK_HOLLOW_STRIPPED_LOG = DECO.register("oak_hollow_stripped_log",
            () -> new BlockItem(ModBlocks.OAK_HOLLOW_STRIPPED_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_HOLLOW_LOG = DECO.register("spruce_hollow_log",
            () -> new BlockItem(ModBlocks.SPRUCE_HOLLOW_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_HOLLOW_STRIPPED_LOG = DECO.register("spruce_hollow_stripped_log",
            () -> new BlockItem(ModBlocks.SPRUCE_HOLLOW_STRIPPED_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_HOLLOW_LOG = DECO.register("birch_hollow_log",
            () -> new BlockItem(ModBlocks.BIRCH_HOLLOW_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_HOLLOW_STRIPPED_LOG = DECO.register("birch_hollow_stripped_log",
            () -> new BlockItem(ModBlocks.BIRCH_HOLLOW_STRIPPED_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_HOLLOW_LOG = DECO.register("jungle_hollow_log",
            () -> new BlockItem(ModBlocks.JUNGLE_HOLLOW_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_HOLLOW_STRIPPED_LOG = DECO.register("jungle_hollow_stripped_log",
            () -> new BlockItem(ModBlocks.JUNGLE_HOLLOW_STRIPPED_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_HOLLOW_LOG = DECO.register("acacia_hollow_log",
            () -> new BlockItem(ModBlocks.ACACIA_HOLLOW_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_HOLLOW_STRIPPED_LOG = DECO.register("acacia_hollow_stripped_log",
            () -> new BlockItem(ModBlocks.ACACIA_HOLLOW_STRIPPED_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_HOLLOW_LOG = DECO.register("dark_oak_hollow_log",
            () -> new BlockItem(ModBlocks.DARK_OAK_HOLLOW_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_HOLLOW_STRIPPED_LOG = DECO.register("dark_oak_hollow_stripped_log",
            () -> new BlockItem(ModBlocks.DARK_OAK_HOLLOW_STRIPPED_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_HOLLOW_LOG = DECO.register("mangrove_hollow_log",
            () -> new BlockItem(ModBlocks.MANGROVE_HOLLOW_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_HOLLOW_STRIPPED_LOG = DECO.register("mangrove_hollow_stripped_log",
            () -> new BlockItem(ModBlocks.MANGROVE_HOLLOW_STRIPPED_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_HOLLOW_LOG = DECO.register("cherry_hollow_log",
            () -> new BlockItem(ModBlocks.CHERRY_HOLLOW_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_HOLLOW_STRIPPED_LOG = DECO.register("cherry_hollow_stripped_log",
            () -> new BlockItem(ModBlocks.CHERRY_HOLLOW_STRIPPED_LOG.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_HOLLOW_BLOCK = DECO.register("bamboo_hollow_block",
            () -> new BlockItem(ModBlocks.BAMBOO_HOLLOW_BLOCK.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_HOLLOW_STRIPPED_BLOCK = DECO.register("bamboo_hollow_stripped_block",
            () -> new BlockItem(ModBlocks.BAMBOO_HOLLOW_STRIPPED_BLOCK.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_HOLLOW_STEM = DECO.register("crimson_hollow_stem",
            () -> new BlockItem(ModBlocks.CRIMSON_HOLLOW_STEM.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_HOLLOW_STRIPPED_STEM = DECO.register("crimson_hollow_stripped_stem",
            () -> new BlockItem(ModBlocks.CRIMSON_HOLLOW_STRIPPED_STEM.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_HOLLOW_STEM = DECO.register("warped_hollow_stem",
            () -> new BlockItem(ModBlocks.WARPED_HOLLOW_STEM.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_HOLLOW_STRIPPED_STEM = DECO.register("warped_hollow_stripped_stem",
            () -> new BlockItem(ModBlocks.WARPED_HOLLOW_STRIPPED_STEM.get(), new Item.Properties()));

    ////////////////////////////////////// POTTED ////////////////////////////////////

    ////////////////////////////////////// PLANTS ////////////////////////////////////

    ////////////////////////////////////// LAMPS ////////////////////////////////////

    public static final Supplier<Item> OAK_LAMP = DECO.register("oak_lamp",
            () -> new BlockItem(ModBlocks.OAK_LAMP.get(), new Item.Properties()));

    public static final Supplier<Item> SPRUCE_LAMP = DECO.register("spruce_lamp",
            () -> new BlockItem(ModBlocks.SPRUCE_LAMP.get(), new Item.Properties()));

    public static final Supplier<Item> BIRCH_LAMP = DECO.register("birch_lamp",
            () -> new BlockItem(ModBlocks.BIRCH_LAMP.get(), new Item.Properties()));

    public static final Supplier<Item> JUNGLE_LAMP = DECO.register("jungle_lamp",
            () -> new BlockItem(ModBlocks.JUNGLE_LAMP.get(), new Item.Properties()));

    public static final Supplier<Item> ACACIA_LAMP = DECO.register("acacia_lamp",
            () -> new BlockItem(ModBlocks.ACACIA_LAMP.get(), new Item.Properties()));

    public static final Supplier<Item> DARK_OAK_LAMP = DECO.register("dark_oak_lamp",
            () -> new BlockItem(ModBlocks.DARK_OAK_LAMP.get(), new Item.Properties()));

    public static final Supplier<Item> MANGROVE_LAMP = DECO.register("mangrove_lamp",
            () -> new BlockItem(ModBlocks.MANGROVE_LAMP.get(), new Item.Properties()));

    public static final Supplier<Item> CHERRY_LAMP = DECO.register("cherry_lamp",
            () -> new BlockItem(ModBlocks.CHERRY_LAMP.get(), new Item.Properties()));

    public static final Supplier<Item> BAMBOO_LAMP = DECO.register("bamboo_lamp",
            () -> new BlockItem(ModBlocks.BAMBOO_LAMP.get(), new Item.Properties()));

    public static final Supplier<Item> CRIMSON_LAMP = DECO.register("crimson_lamp",
            () -> new BlockItem(ModBlocks.CRIMSON_LAMP.get(), new Item.Properties()));

    public static final Supplier<Item> WARPED_LAMP = DECO.register("warped_lamp",
            () -> new BlockItem(ModBlocks.WARPED_LAMP.get(), new Item.Properties()));

    ////////////////////////////////////// RUGS ////////////////////////////////////

    public static final Supplier<Item> WHITE_RUG = DECO.register("white_rug",
            () -> new BlockItem(ModBlocks.WHITE_RUG.get(), new Item.Properties()));

    public static final Supplier<Item> LIGHT_GRAY_RUG = DECO.register("light_gray_rug",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_RUG.get(), new Item.Properties()));

    public static final Supplier<Item> GRAY_RUG = DECO.register("gray_rug",
            () -> new BlockItem(ModBlocks.GRAY_RUG.get(), new Item.Properties()));

    public static final Supplier<Item> BLACK_RUG = DECO.register("black_rug",
            () -> new BlockItem(ModBlocks.BLACK_RUG.get(), new Item.Properties()));

    public static final Supplier<Item> BROWN_RUG = DECO.register("brown_rug",
            () -> new BlockItem(ModBlocks.BROWN_RUG.get(), new Item.Properties()));

    public static final Supplier<Item> RED_RUG = DECO.register("red_rug",
            () -> new BlockItem(ModBlocks.RED_RUG.get(), new Item.Properties()));

    public static final Supplier<Item> ORANGE_RUG = DECO.register("orange_rug",
            () -> new BlockItem(ModBlocks.ORANGE_RUG.get(), new Item.Properties()));

    public static final Supplier<Item> YELLOW_RUG = DECO.register("yellow_rug",
            () -> new BlockItem(ModBlocks.YELLOW_RUG.get(), new Item.Properties()));

    public static final Supplier<Item> LIME_RUG = DECO.register("lime_rug",
            () -> new BlockItem(ModBlocks.LIME_RUG.get(), new Item.Properties()));

    public static final Supplier<Item> GREEN_RUG = DECO.register("green_rug",
            () -> new BlockItem(ModBlocks.GREEN_RUG.get(), new Item.Properties()));

    public static final Supplier<Item> CYAN_RUG = DECO.register("cyan_rug",
            () -> new BlockItem(ModBlocks.CYAN_RUG.get(), new Item.Properties()));

    public static final Supplier<Item> LIGHT_BLUE_RUG = DECO.register("light_blue_rug",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_RUG.get(), new Item.Properties()));

    public static final Supplier<Item> BLUE_RUG = DECO.register("blue_rug",
            () -> new BlockItem(ModBlocks.BLUE_RUG.get(), new Item.Properties()));

    public static final Supplier<Item> PURPLE_RUG = DECO.register("purple_rug",
            () -> new BlockItem(ModBlocks.PURPLE_RUG.get(), new Item.Properties()));

    public static final Supplier<Item> MAGENTA_RUG = DECO.register("magenta_rug",
            () -> new BlockItem(ModBlocks.MAGENTA_RUG.get(), new Item.Properties()));

    public static final Supplier<Item> PINK_RUG = DECO.register("pink_rug",
            () -> new BlockItem(ModBlocks.PINK_RUG.get(), new Item.Properties()));

    ////////////////////////////////////// TEDDYS ////////////////////////////////////

    ////////////////////////////////////// STACKABLES ////////////////////////////////////

    ////////////////////////////////////// GRAVES ////////////////////////////////////

    private static Item.Properties normal(FoodProperties properties) {
        return new Item.Properties().food(properties);
    }
}

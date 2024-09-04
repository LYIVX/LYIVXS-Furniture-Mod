package net.lyivx.ls_furniture.registry;

import net.lyivx.ls_furniture.LYIVXsFurnitureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlocksTags {

    public static final TagKey<Block> CHAIRS_TUCKABLE_UNDER = blockTag("chairs_tuckable_under");
    public static final TagKey<Block> ABOVE_BYPASSES_SEAT_CHECK = blockTag("above_bypasses_seat_check");
    public static final TagKey<Block> TABLES_CONNECTABLE = blockTag("table_connectable");
    public static final TagKey<Block> PLATFORMS_CONNECTABLE = blockTag("platform_connectable");
    public static final TagKey<Block> DONT_CONNECT_TO_PANES = blockTag("dont_connect_to_panes");
    public static final TagKey<Block> CAN_USE_SHUTTERS_THROUGH = blockTag("can_use_shutters_through");
    public static final TagKey<Block> NON_OP_CREATIVE_CAN_DESTROY_TAG = blockTag("non_op_creative_can_destroy");
    public static final TagKey<Block> BYPASSES_MAIL_TAG_TAG  = blockTag("bypasses_mail_tag");

    private static TagKey<Block> blockTag(String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(LYIVXsFurnitureMod.MOD_ID, name));
    }

    public static void init() {}
}
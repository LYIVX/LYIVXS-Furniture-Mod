package net.lyivx.ls_furniture.common.blocks.properties;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.*;

public class ModBlockStateProperties {
    public static final EnumProperty<HorizontalConnectionType> HORIZONTAL_CONNECTION_TYPE = EnumProperty.create("horizontal", HorizontalConnectionType.class);
    public static final EnumProperty<VerticalConnectionType> VERTICAL_CONNECTION_TYPE = EnumProperty.create("vertical", VerticalConnectionType.class);
    public static final EnumProperty<LeafType> LEAF_TYPE = EnumProperty.create("type", LeafType.class);
    public static final EnumProperty<SofaType> SOFA_TYPE = EnumProperty.create("type", SofaType.class);
    public static final EnumProperty<CounterType> COUNTER_TYPE = EnumProperty.create("type", CounterType.class);
    public static final EnumProperty<CabinetType> CABINET_TYPE = EnumProperty.create("type", CabinetType.class);
    public static final EnumProperty<StairType> STAIR_TYPE = EnumProperty.create("type", StairType.class);
    public static final EnumProperty<VerticalConnectionType> VERTICAL_CONNECTION_NO_SINGLE_TYPE = EnumProperty.create("type", VerticalConnectionType.class, (type) -> type != VerticalConnectionType.SINGLE);
    public static final EnumProperty<SlabType> HALF = EnumProperty.create("half", SlabType.class);
    public static final EnumProperty<ColorType> COLOR = EnumProperty.create("color",ColorType.class );
    public static final DirectionProperty FACING_EXCEPT_DOWN = DirectionProperty.create("facing", (direction) -> direction != Direction.DOWN);
    public static final DirectionProperty VERTICAL_CONNECTION_TYPE_UP_DOWN = DirectionProperty.create("vertical", (direction) -> direction.getAxis().isVertical());
    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 1, 2);
    public static final BooleanProperty TUCKED = BooleanProperty.create("tucked");
    public static final BooleanProperty NORTH_TABLE = BooleanProperty.create("leg_1");
    public static final BooleanProperty EAST_TABLE = BooleanProperty.create("leg_2");
    public static final BooleanProperty SOUTH_TABLE = BooleanProperty.create("leg_3");
    public static final BooleanProperty WEST_TABLE = BooleanProperty.create("leg_4");
    public static final BooleanProperty NORTH_PLATFORM = BooleanProperty.create("north");
    public static final BooleanProperty EAST_PLATFORM = BooleanProperty.create("east");
    public static final BooleanProperty SOUTH_PLATFORM = BooleanProperty.create("south");
    public static final BooleanProperty WEST_PLATFORM = BooleanProperty.create("west");    
    public static final BooleanProperty NORTH_RAILING = BooleanProperty.create("north_railing");
    public static final BooleanProperty EAST_RAILING = BooleanProperty.create("east_railing");
    public static final BooleanProperty SOUTH_RAILING = BooleanProperty.create("south_railing");
    public static final BooleanProperty WEST_RAILING = BooleanProperty.create("west_railing");
    public static final BooleanProperty UPDATE = BooleanProperty.create("update");
    public static final BooleanProperty STAND = BooleanProperty.create("stand");
    public static final BooleanProperty HAS_MAIL = BooleanProperty.create("has_mail");
    public static final BooleanProperty HAS_WATER = BooleanProperty.create("has_water");
    public static final BooleanProperty HAS_DIRT = BooleanProperty.create("has_dirt");
    public static final BooleanProperty IS_DOUBLE = BooleanProperty.create("is_double");
}
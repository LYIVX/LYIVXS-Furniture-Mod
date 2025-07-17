package net.lyivx.ls_furniture.common.blocks.properties;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DirectionProperty extends Property<Direction> {
    private final EnumProperty<Direction> property;
    private final Predicate<Direction> filter;

    private DirectionProperty(String name, Collection<Direction> values, Predicate<Direction> filter) {
        super(name, Direction.class);
        List<Direction> filteredValues = values.stream().filter(filter).collect(Collectors.toList());
        this.property = EnumProperty.create(name, Direction.class, filteredValues);
        this.filter = filter;
    }

    public static DirectionProperty create(String name) {
        return create(name, direction -> true);
    }

    public static DirectionProperty create(String name, Predicate<Direction> filter) {
        return new DirectionProperty(name, List.of(Direction.values()), filter);
    }

    /**
     * Creates a DirectionProperty that only allows horizontal directions (NORTH, SOUTH, EAST, WEST)
     * @param name The name of the property
     * @return A DirectionProperty that only allows horizontal directions
     */
    public static DirectionProperty createHorizontal(String name) {
        return create(name, direction -> direction.getAxis().isHorizontal());
    }

    /**
     * Creates a DirectionProperty that allows all directions, including UP and DOWN
     * @param name The name of the property
     * @return A DirectionProperty that allows all directions
     */
    public static DirectionProperty createAll(String name) {
        return create(name, direction -> true);
    }

    @Override
    public List<Direction> getPossibleValues() {
        return property.getPossibleValues();
    }

    @Override
    public String getName(Direction value) {
        return property.getName(value);
    }

    @Override
    public Optional<Direction> getValue(String value) {
        return property.getValue(value);
    }

    @Override
    public String toString() {
        return property.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DirectionProperty)) return false;
        if (!super.equals(o)) return false;
        DirectionProperty that = (DirectionProperty) o;
        return property.equals(that.property) && filter.equals(that.filter);
    }

    @Override
    public int getInternalIndex(Direction value) {
        return property.getInternalIndex(value);
    }
} 
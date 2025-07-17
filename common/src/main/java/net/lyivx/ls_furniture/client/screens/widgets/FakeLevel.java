package net.lyivx.ls_furniture.client.screens.widgets;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.lyivx.ls_furniture.common.blocks.PlatformBlock;
import net.lyivx.ls_furniture.common.blocks.TableBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.TickRateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.chunk.ChunkSource;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.level.entity.LevelEntityGetter;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.world.level.storage.WritableLevelData;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.ticks.LevelTickAccess;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static net.minecraft.world.level.block.Block.isExceptionForConnection;

public class FakeLevel extends Level {
    private final Map<BlockPos, BlockState> blocks = new HashMap<>();

    public FakeLevel() {
        super(
                (WritableLevelData) new ClientLevel.ClientLevelData(Difficulty.NORMAL, false, false),
                Level.OVERWORLD,
                Minecraft.getInstance().level != null ? Minecraft.getInstance().level.registryAccess() : null,
                Minecraft.getInstance().level != null ? Minecraft.getInstance().level.dimensionTypeRegistration() : null,
                () -> null,
                true,
                false,
                0L,
                0
        );
    }

    @Override
    public RecipeManager getRecipeManager() {
        return null;
    }

    @Override
    public int getHeight() {
        return 256;
    }

    @Override
    public int getMinBuildHeight() {
        return 0;
    }

    @Override
    public int getMaxBuildHeight() {
        return getHeight() + getMinBuildHeight();
    }

    @Override
    public int getSkyDarken() {
        return 0;
    }

    @Override
    public boolean isUnobstructed(BlockState state, BlockPos pos, CollisionContext context) {
        return true;
    }

    @Override
    public float getPathfindingCostFromLightLevels(BlockPos pos) {
        return 0;
    }

    @Override
    public void blockUpdated(BlockPos pos, Block block) {
        BlockState state = getBlockState(pos);
        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = pos.relative(direction);
            BlockState neighborState = getBlockState(neighborPos);
            BlockState updatedState = neighborState.updateShape(direction.getOpposite(), state, this, neighborPos, pos);
            if (neighborState != updatedState) {
                setBlock(neighborPos, updatedState, 3, 512);
            }
        }
    }

    @Override
    public BlockState getBlockState(BlockPos pos) {
        return blocks.getOrDefault(pos, Blocks.AIR.defaultBlockState());
    }

    @Override
    public FluidState getFluidState(BlockPos pos) {
        BlockState blockState = getBlockState(pos);
        return blockState.getFluidState();
    }

    @Override
    public void playSeededSound(@Nullable Player player, double x, double y, double z, Holder<SoundEvent> sound, SoundSource source, float volume, float pitch, long seed) {

    }

    @Override
    public void playSeededSound(@Nullable Player player, Entity entity, Holder<SoundEvent> sound, SoundSource category, float volume, float pitch, long seed) {

    }

    @Override
    public boolean setBlock(BlockPos pos, BlockState state, int flags, int recursionLeft) {
        if (recursionLeft <= 0) return false;

        BlockState oldState = getBlockState(pos);
        if (oldState == state) return false;

        blocks.put(pos, state);

        if ((flags & 2) != 0) {
            for (Direction direction : Direction.values()) {
                BlockPos neighborPos = pos.relative(direction);
                BlockState neighborState = getBlockState(neighborPos);
                neighborState.neighborChanged(this, neighborPos, oldState.getBlock(), pos, false);
            }
        }

        return true;
    }

    public void renderBlocks(PoseStack poseStack) {
        Minecraft mc = Minecraft.getInstance();
        BlockRenderDispatcher dispatcher = mc.getBlockRenderer();
        MultiBufferSource.BufferSource bufferSource = mc.renderBuffers().bufferSource();

        for (Map.Entry<BlockPos, BlockState> entry : blocks.entrySet()) {
            BlockPos pos = entry.getKey();
            BlockState state = entry.getValue();

            RenderType renderType = ItemBlockRenderTypes.getChunkRenderType(state);
            VertexConsumer consumer = bufferSource.getBuffer(renderType);

            poseStack.pushPose();
            poseStack.translate(pos.getX(), pos.getY(), pos.getZ());

            RandomSource fixedRandom = RandomSource.create(42);
            dispatcher.renderBatched(state, pos, this, poseStack, consumer, true, fixedRandom);

            poseStack.popPose();
        }

        bufferSource.endBatch();
    }

    public void setBlocksWithConnections(BlockState state, List<BlockPos> positions) {
        clear();

        // First, place all blocks
        for (BlockPos pos : positions) {
            setBlock(pos, state, 3, 512);
        }

        // Then, update all blocks and their neighbors
        Set<BlockPos> updatePositions = new HashSet<>(positions);
        for (BlockPos pos : positions) {
            for (Direction direction : Direction.values()) {
                updatePositions.add(pos.relative(direction));
            }
        }

        for (BlockPos pos : updatePositions) {
            if (blocks.containsKey(pos)) {
                updateBlockState(pos);
            }
        }

        // Apply fence configurations if the block is a fence
        if (state.getBlock() instanceof FenceBlock) {
            applyFenceConfigurations(positions);
        } else if (state.getBlock() instanceof TableBlock) {
            applyTableConfigurations(positions);
        } else if (state.getBlock() instanceof PlatformBlock) {
            applyPlatformConfigurations(positions);
        }
    }

    private void applyFenceConfigurations(List<BlockPos> positions) {
        for (BlockPos pos : positions) {
            BlockState state = getBlockState(pos);
            if (state.getBlock() instanceof FenceBlock) {
                FenceConfiguration config = getFenceConfigurationForPosition(pos, positions);
                setBlock(pos, config.applyToBlockState(state), 3, 512);
            }
        }
    }

    private FenceConfiguration getFenceConfigurationForPosition(BlockPos pos, List<BlockPos> allPositions) {
        Set<Direction> connections = EnumSet.noneOf(Direction.class);
        for (Direction dir : Direction.Plane.HORIZONTAL) {
            if (allPositions.contains(pos.relative(dir))) {
                connections.add(dir);
            }
        }

        switch (connections.size()) {
            case 0:
                return FenceConfiguration.SINGLE;
            case 1:
                Direction dir = connections.iterator().next();
                return FenceConfiguration.valueOf("NORTH_SOUTH").connections.contains(dir) ?
                        FenceConfiguration.NORTH_SOUTH : FenceConfiguration.EAST_WEST;
            case 2:
                if (connections.contains(Direction.NORTH) && connections.contains(Direction.SOUTH)) {
                    return FenceConfiguration.NORTH_SOUTH;
                }
                if (connections.contains(Direction.EAST) && connections.contains(Direction.WEST)) {
                    return FenceConfiguration.EAST_WEST;
                }
                for (FenceConfiguration config : FenceConfiguration.values()) {
                    if (config.connections.equals(connections)) {
                        return config;
                    }
                }
                break;
            case 3:
                for (FenceConfiguration config : FenceConfiguration.values()) {
                    if (config.connections.equals(connections)) {
                        return config;
                    }
                }
                break;
            case 4:
                return FenceConfiguration.CROSS;
        }

        return FenceConfiguration.SINGLE; // Default case
    }

    private BlockState updateFenceState(BlockPos pos, BlockState fenceState) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos neighborPos = pos.relative(direction);
            BlockState neighborState = getBlockState(neighborPos);

            boolean shouldConnect = canFenceConnectTo(fenceState, neighborState, direction);
            fenceState = fenceState.setValue(getFenceProperty(direction), shouldConnect);
        }
        return fenceState;
    }

    static BooleanProperty getFenceProperty(Direction direction) {
        switch (direction) {
            case NORTH: return FenceBlock.NORTH;
            case EAST: return FenceBlock.EAST;
            case SOUTH: return FenceBlock.SOUTH;
            case WEST: return FenceBlock.WEST;
            default: throw new IllegalArgumentException("Invalid horizontal direction: " + direction);
        }
    }

    private enum FenceConfiguration {
        SINGLE(EnumSet.noneOf(Direction.class)),
        NORTH_SOUTH(EnumSet.of(Direction.NORTH, Direction.SOUTH)),
        EAST_WEST(EnumSet.of(Direction.EAST, Direction.WEST)),
        CORNER_NE(EnumSet.of(Direction.NORTH, Direction.EAST)),
        CORNER_NW(EnumSet.of(Direction.NORTH, Direction.WEST)),
        CORNER_SE(EnumSet.of(Direction.SOUTH, Direction.EAST)),
        CORNER_SW(EnumSet.of(Direction.SOUTH, Direction.WEST)),
        T_SHAPE_N(EnumSet.of(Direction.NORTH, Direction.EAST, Direction.WEST)),
        T_SHAPE_S(EnumSet.of(Direction.SOUTH, Direction.EAST, Direction.WEST)),
        T_SHAPE_E(EnumSet.of(Direction.NORTH, Direction.SOUTH, Direction.EAST)),
        T_SHAPE_W(EnumSet.of(Direction.NORTH, Direction.SOUTH, Direction.WEST)),
        CROSS(EnumSet.allOf(Direction.class));

        private final EnumSet<Direction> connections;

        FenceConfiguration(EnumSet<Direction> connections) {
            this.connections = connections;
        }

        public BlockState applyToBlockState(BlockState state) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                state = state.setValue(getFenceProperty(direction), connections.contains(direction));
            }
            return state;
        }
    }

    private void applyTableConfigurations(List<BlockPos> positions) {
        for (BlockPos pos : positions) {
            BlockState state = getBlockState(pos);
            if (state.getBlock() instanceof TableBlock) {
                setBlock(pos, updateTableState(pos, state), 3, 512);
            }
        }
    }

    private BlockState updateTableState(BlockPos pos, BlockState tableState) {
        boolean north = validTableConnection(getBlockState(pos.north()));
        boolean east = validTableConnection(getBlockState(pos.east()));
        boolean south = validTableConnection(getBlockState(pos.south()));
        boolean west = validTableConnection(getBlockState(pos.west()));

        boolean leg1 = (!north && !east) || (north && east && !validTableConnection(getBlockState(pos.north().east())));
        boolean leg2 = (!east && !south) || (east && south && !validTableConnection(getBlockState(pos.south().east())));
        boolean leg3 = (!south && !west) || (south && west && !validTableConnection(getBlockState(pos.south().west())));
        boolean leg4 = (!north && !west) || (north && west && !validTableConnection(getBlockState(pos.north().west())));

        return tableState
                .setValue(TableBlock.LEG1, leg1)
                .setValue(TableBlock.LEG2, leg2)
                .setValue(TableBlock.LEG3, leg3)
                .setValue(TableBlock.LEG4, leg4);
    }

    private boolean validTableConnection(BlockState state) {
        return state.getBlock() instanceof TableBlock;
    }

    private static BooleanProperty getTableProperty(Direction direction) {
        return switch (direction) {
            case NORTH -> TableBlock.LEG1;
            case EAST -> TableBlock.LEG2;
            case SOUTH -> TableBlock.LEG3;
            case WEST -> TableBlock.LEG4;
            default -> throw new IllegalArgumentException("Invalid horizontal direction: " + direction);
        };
    }

    private enum TableConfiguration {
        SINGLE(EnumSet.noneOf(Direction.class)),
        NORTH_SOUTH(EnumSet.of(Direction.NORTH, Direction.SOUTH)),
        EAST_WEST(EnumSet.of(Direction.EAST, Direction.WEST)),
        CORNER_NE(EnumSet.of(Direction.NORTH, Direction.EAST)),
        CORNER_NW(EnumSet.of(Direction.NORTH, Direction.WEST)),
        CORNER_SE(EnumSet.of(Direction.SOUTH, Direction.EAST)),
        CORNER_SW(EnumSet.of(Direction.SOUTH, Direction.WEST)),
        T_SHAPE_N(EnumSet.of(Direction.NORTH, Direction.EAST, Direction.WEST)),
        T_SHAPE_S(EnumSet.of(Direction.SOUTH, Direction.EAST, Direction.WEST)),
        T_SHAPE_E(EnumSet.of(Direction.NORTH, Direction.SOUTH, Direction.EAST)),
        T_SHAPE_W(EnumSet.of(Direction.NORTH, Direction.SOUTH, Direction.WEST)),
        CROSS(EnumSet.allOf(Direction.class));

        private final EnumSet<Direction> connections;

        TableConfiguration(EnumSet<Direction> connections) {
            this.connections = connections;
        }

        public BlockState applyToBlockState(BlockState state) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                state = state.setValue(getTableProperty(direction), !connections.contains(direction));
            }
            return state;
        }

        public static TableConfiguration fromConnections(Set<Direction> connections) {
            for (TableConfiguration config : values()) {
                if (config.connections.equals(connections)) {
                    return config;
                }
            }
            return SINGLE;
        }
    }

    private void applyPlatformConfigurations(List<BlockPos> positions) {
        for (BlockPos pos : positions) {
            BlockState state = getBlockState(pos);
            if (state.getBlock() instanceof PlatformBlock) {
                setBlock(pos, updatePlatformState(pos, state), 3, 512);
            }
        }
    }


    private BlockState updatePlatformState(BlockPos pos, BlockState platformState) {
        boolean north = validPlatformConnection(getBlockState(pos.north()));
        boolean east = validPlatformConnection(getBlockState(pos.east()));
        boolean south = validPlatformConnection(getBlockState(pos.south()));
        boolean west = validPlatformConnection(getBlockState(pos.west()));

        boolean northPlatform = !north || !validPlatformConnection(getBlockState(pos.north().south()));
        boolean eastPlatform = !east || !validPlatformConnection(getBlockState(pos.east().west()));
        boolean southPlatform = !south || !validPlatformConnection(getBlockState(pos.south().north()));
        boolean westPlatform = !west || !validPlatformConnection(getBlockState(pos.west().east()));

        return platformState
                .setValue(PlatformBlock.NORTH_PLATFORM, northPlatform)
                .setValue(PlatformBlock.EAST_PLATFORM, eastPlatform)
                .setValue(PlatformBlock.SOUTH_PLATFORM, southPlatform)
                .setValue(PlatformBlock.WEST_PLATFORM, westPlatform);
    }

    private boolean validPlatformConnection(BlockState state) {
        return state.getBlock() instanceof PlatformBlock;
    }

    private static BooleanProperty getPlatformProperty(Direction direction) {
        return switch (direction) {
            case NORTH -> PlatformBlock.NORTH_PLATFORM;
            case EAST -> PlatformBlock.EAST_PLATFORM;
            case SOUTH -> PlatformBlock.SOUTH_PLATFORM;
            case WEST -> PlatformBlock.WEST_PLATFORM;
            default -> throw new IllegalArgumentException("Invalid horizontal direction: " + direction);
        };
    }


    private enum PlatformConfiguration {
        SINGLE(EnumSet.noneOf(Direction.class)),
        NORTH_SOUTH(EnumSet.of(Direction.NORTH, Direction.SOUTH)),
        EAST_WEST(EnumSet.of(Direction.EAST, Direction.WEST)),
        CORNER_NE(EnumSet.of(Direction.NORTH, Direction.EAST)),
        CORNER_NW(EnumSet.of(Direction.NORTH, Direction.WEST)),
        CORNER_SE(EnumSet.of(Direction.SOUTH, Direction.EAST)),
        CORNER_SW(EnumSet.of(Direction.SOUTH, Direction.WEST)),
        T_SHAPE_N(EnumSet.of(Direction.NORTH, Direction.EAST, Direction.WEST)),
        T_SHAPE_S(EnumSet.of(Direction.SOUTH, Direction.EAST, Direction.WEST)),
        T_SHAPE_E(EnumSet.of(Direction.NORTH, Direction.SOUTH, Direction.EAST)),
        T_SHAPE_W(EnumSet.of(Direction.NORTH, Direction.SOUTH, Direction.WEST)),
        CROSS(EnumSet.allOf(Direction.class));

        private final EnumSet<Direction> connections;

        PlatformConfiguration(EnumSet<Direction> connections) {
            this.connections = connections;
        }

        public BlockState applyToBlockState(BlockState state) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                state = state.setValue(getPlatformProperty(direction), connections.contains(direction));
            }
            return state;
        }

        public static PlatformConfiguration fromConnections(Set<Direction> connections) {
            for (PlatformConfiguration config : values()) {
                if (config.connections.equals(connections)) {
                    return config;
                }
            }
            return SINGLE;
        }
    }

    public void setBlocksWithRotation(BlockState state, List<BlockPos> positions, List<Direction> facings) {
        clear();

        List<BlockPos> posList = new ArrayList<>(positions);


        for (int i = 0; i < posList.size(); i++) {
            BlockPos pos = posList.get(i);
            BlockState blockState = state;

            if (state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
                Direction facing = i < facings.size() ? facings.get(i) : facings.get(facings.size() - 1);
                blockState = state.setValue(BlockStateProperties.HORIZONTAL_FACING, facing);
            }

            setBlock(pos, blockState, 3, 512);
        }

        // Update all blocks and their neighbors
        Set<BlockPos> updatePositions = new HashSet<>(positions);
        for (BlockPos pos : positions) {
            for (Direction direction : Direction.values()) {
                updatePositions.add(pos.relative(direction));
            }
        }

        for (BlockPos pos : updatePositions) {
            if (blocks.containsKey(pos)) {
                updateBlockState(pos);
            }
        }
    }

    private void updateBlockState(BlockPos pos) {
        BlockState currentState = getBlockState(pos);
        BlockState newState = currentState;

        if (currentState.getBlock() instanceof FenceBlock) {
            newState = updateFenceState(pos, currentState);
        } else if (currentState.getBlock() instanceof TableBlock) {
            newState = updateTableState(pos, currentState);
        } else if (currentState.getBlock() instanceof PlatformBlock) {
            newState = updatePlatformState(pos, currentState);
        } else {
            for (Direction direction : Direction.values()) {
                BlockPos neighborPos = pos.relative(direction);
                BlockState neighborState = getBlockState(neighborPos);
                newState = newState.updateShape(direction, neighborState, this, pos, neighborPos);
            }
        }

        if (newState != currentState) {
            setBlock(pos, newState, 3, 512);
        }
    }

    private void updateBlockStateWithConnections(BlockPos pos) {
        BlockState currentState = getBlockState(pos);
        BlockState newState = currentState;

        Block block = currentState.getBlock();
        if (block instanceof FenceBlock) {
            newState = updateFenceState(pos, currentState);
        } else if (block instanceof TableBlock) {
            newState = updateTableState(pos, currentState);
        } else if (block instanceof PlatformBlock) {
            newState = updatePlatformState(pos, currentState);
        }

        if (newState != currentState) {
            setBlock(pos, newState, 3);
        }
    }

    private boolean canFenceConnectTo(BlockState fenceState, BlockState neighborState, Direction direction) {
        Block neighborBlock = neighborState.getBlock();
        boolean isSameFence = isSameFence(neighborState);
        boolean isFenceGate = neighborBlock instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(neighborState, direction.getOpposite());
        boolean isSideSolid = neighborState.isFaceSturdy(this, BlockPos.ZERO.relative(direction), direction.getOpposite());

        return !isExceptionForConnection(neighborState) && (isSideSolid || isSameFence || isFenceGate);
    }

    private boolean isSameFence(BlockState state) {
        return state.is(BlockTags.FENCES) && state.is(BlockTags.WOODEN_FENCES) == this.getBlockState(BlockPos.ZERO).is(BlockTags.WOODEN_FENCES);
    }

    private boolean checkTableConnection(BlockPos pos) {
        return getBlockState(pos).getBlock() instanceof TableBlock;
    }

    private boolean checkPlatformConnection(BlockPos pos) {
        return getBlockState(pos).getBlock() instanceof PlatformBlock;
    }

    public void clear() {
        blocks.clear();
    }

    // Required Level overrides
    @Override
    public void playSound(@Nullable Player player, double x, double y, double z, SoundEvent sound, SoundSource source, float volume, float pitch) {
    }

    @Override
    public void addParticle(ParticleOptions particleData, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
    }

    @Override
    public void levelEvent(@Nullable Player player, int type, BlockPos pos, int data) {
    }

    @Override
    public void gameEvent(GameEvent event, Vec3 position, GameEvent.Context context) {

    }

    @Override
    public List<? extends Player> players() {
        return Collections.emptyList();
    }

    @Override
    public float getShade(Direction direction, boolean shade) {
        if (!shade) return 1.0F;

        // Simplified shading based on direction
        switch (direction) {
            case DOWN:  return 0.5F;
            case UP:    return 1.0F;
            case NORTH: return 0.4F;
            case SOUTH: return 0.8F;
            case WEST:
            case EAST:  return 0.8F;
            default:    return 1.0F;
        }
    }

    @Override
    public ChunkSource getChunkSource() {
        return Minecraft.getInstance().level.getChunkSource();
    }

    @Override
    public void sendBlockUpdated(BlockPos pos, BlockState oldState, BlockState newState, int flags) {
    }

    @Override
    public MinecraftServer getServer() {
        return null;
    }

    public EntityTypeTest<Entity, ?> getTypeTest() {
        return EntityTypeTest.forClass(Entity.class);
    }

    @Override
    public void gameEvent(@Nullable Entity entity, GameEvent event, Vec3 pos) {
    }

    @Override
    public RegistryAccess registryAccess() {
        return Minecraft.getInstance().level != null ?
                Minecraft.getInstance().level.registryAccess() :
                null;
    }

    @Override
    public FeatureFlagSet enabledFeatures() {
        return null;
    }

    @Override
    public LevelTickAccess<Block> getBlockTicks() {
        return new NoOpTickAccess<>();  // Prevent block ticks from being scheduled
    }

    @Override
    public LevelTickAccess<Fluid> getFluidTicks() {
        return new NoOpTickAccess<>();  // Prevent block ticks from being scheduled
    }

    private boolean isPositionTicking(BlockPos pos) {
        return true; // Simplified for the fake level
    }

    @Override
    public float getSunAngle(float partialTick) {
        return 0.0F;
    }

    @Override
    public String gatherChunkSourceStats() {
        return "";
    }

    @Nullable
    @Override
    public Entity getEntity(int id) {
        return null;
    }

    @Override
    public TickRateManager tickRateManager() {
        return null;
    }

    @Nullable
    @Override
    public MapItemSavedData getMapData(String mapName) {
        return null;
    }

    @Override
    public void setMapData(String mapName, MapItemSavedData data) {

    }

    @Override
    public int getFreeMapId() {
        return 0;
    }

    @Override
    public void destroyBlockProgress(int breakerId, BlockPos pos, int progress) {

    }

    @Override
    public int getMoonPhase() {
        return 0;
    }

    @Override
    public float getMoonBrightness() {
        return 1.0F;
    }

    @Override
    public float getTimeOfDay(float partialTick) {
        return 0.5F;
    }

    @Override
    public int getBrightness(LightLayer type, BlockPos pos) {
        return 15;
    }

    @Override
    protected LevelEntityGetter<Entity> getEntities() {
        return null;
    }

    @Override
    public Scoreboard getScoreboard() {
        return null;
    }

    @Override
    public Holder<Biome> getBiome(BlockPos pos) {
        return null;
    }

    @Override
    public Holder<Biome> getUncachedNoiseBiome(int x, int y, int z) {
        return null;
    }
}
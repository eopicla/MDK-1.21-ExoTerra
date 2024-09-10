package com.ultricem.exoterra.block.custom;

import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.doubles.DoubleList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class MotorBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public MotorBlock(Properties properties) {
        super(properties.of().strength(2f).noOcclusion().strength(2f).sound(SoundType.METAL));

        registerDefaultState(getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }



    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        //return SHAPE;
        switch ((Direction) state.getValue(FACING)){
            case NORTH -> {
                return SHAPE_NORTH;
            }
            case EAST -> {
                return SHAPE_EAST;
            }
            case SOUTH -> {
                return SHAPE_SOUTH;
            }
            case WEST -> {
                return SHAPE_WEST;
            }
            default -> {
                return SHAPE_CUBE;
            }
        }
    }

    public static final VoxelShape SHAPE_CUBE =
            Block.box(0,0,0,16,16,16);

    public static final VoxelShape SHAPE_NORTH =
                Shapes.or(Block.box(0, 0, 0, 16, 1, 16),
                        Block.box(2, 2, 11, 14, 14, 14),
                        Block.box(3, 3, 4, 13, 13, 11),
                        Block.box(2, 2, 5, 14, 3, 6),
                        Block.box(7, 7, 0, 9, 9, 4),
                        Block.box(3, 3, 14, 13, 13, 15));

    public static final VoxelShape SHAPE_EAST =
                Shapes.or(Block.box(0, 0, 0, 16, 1, 16),
                        Block.box(2, 2, 2, 5, 14, 14),
                        Block.box(5, 3, 3, 12, 13, 13),
                        Block.box(10, 2, 2, 11, 3, 14),
                        Block.box(12, 7, 7, 16, 9, 9),
                        Block.box(1, 3, 3, 2, 13, 13));

    public static final VoxelShape SHAPE_SOUTH =
                Shapes.or(Block.box(0, 0, 0, 16, 1, 16),
                        Block.box(2, 2, 2, 14, 14, 5),
                        Block.box(3, 3, 5, 13, 13, 12),
                        Block.box(2, 2, 10, 14, 3, 11),
                        Block.box(7, 7, 12, 9, 9, 16),
                        Block.box(3, 3, 1, 13, 13, 2));

    public static final VoxelShape SHAPE_WEST =
                Shapes.or(Block.box(0, 0, 0, 16, 1, 16),
                        Block.box(11, 2, 2, 14, 14, 14),
                        Block.box(4, 3, 3, 11, 13, 13),
                        Block.box(5, 2, 2, 6, 3, 14),
                        Block.box(0, 7, 7, 4, 9, 9),
                        Block.box(14, 3, 3, 15, 13, 13));
}

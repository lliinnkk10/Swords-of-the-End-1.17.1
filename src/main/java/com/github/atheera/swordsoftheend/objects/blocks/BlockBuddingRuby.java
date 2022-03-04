package com.github.atheera.swordsoftheend.objects.blocks;

import com.github.atheera.swordsoftheend.inits.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;

import java.util.Random;

public class BlockBuddingRuby extends AmethystBlock {

    private static final Direction[] DIRECTIONS = Direction.values();

    public BlockBuddingRuby(Properties p_151999_) {
        super(p_151999_);
    }

    public PushReaction getPistonPushReaction(BlockState state) { return PushReaction.DESTROY; }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {

        if (pRandom.nextInt(5) == 0) {

            Direction direction = DIRECTIONS[pRandom.nextInt(DIRECTIONS.length)];
            BlockPos pos = pPos.relative(direction);
            BlockState state = pLevel.getBlockState(pos);
            Block block = null;



            if (canClusterGrowAtState(state)) {
                block = BlockInit.BLOCK_BUD_SMALL_RUBY.get();
            } else if (state.is(BlockInit.BLOCK_BUD_SMALL_RUBY.get()) && state.getValue(AmethystClusterBlock.FACING) == direction) {
                block = BlockInit.BLOCK_BUD_MEDIUM_RUBY.get();
            } else if (state.is(BlockInit.BLOCK_BUD_MEDIUM_RUBY.get()) && state.getValue(AmethystClusterBlock.FACING) == direction) {
                block = BlockInit.BLOCK_BUD_LARGE_RUBY.get();
            } else if (state.is(BlockInit.BLOCK_BUD_LARGE_RUBY.get()) && state.getValue(AmethystClusterBlock.FACING) == direction) {
                block = BlockInit.BLOCK_CLUSTER_RUBY.get();
            }

            if (block != null) {
                BlockState state1 = block.defaultBlockState().setValue(AmethystClusterBlock.FACING, direction).setValue(AmethystClusterBlock.WATERLOGGED, state.getFluidState().getType() == Fluids.WATER);
                pLevel.setBlockAndUpdate(pos, state1);
            }

        }

    }

    public static boolean canClusterGrowAtState(BlockState state) {
        return state.isAir() || state.is(Blocks.WATER) && state.getFluidState().getAmount() == 8;
    }

}
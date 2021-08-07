package com.github.atheera.swordsoftheend.objects.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BlockInfuser extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty LIT = BooleanProperty.create("lit");

    public BlockInfuser(Properties p_48687_) {
        super(p_48687_);
       // this.defaultBlockState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, false));
    }



}
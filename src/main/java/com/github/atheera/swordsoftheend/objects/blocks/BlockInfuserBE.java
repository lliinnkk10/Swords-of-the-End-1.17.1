package com.github.atheera.swordsoftheend.objects.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class BlockInfuserBE extends BlockEntity {

   //private final ItemStackHandler itemHandler = createHandler();
   // private final CustomEnergyStorage energyStorage = createEnergy();

    //private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
   // private final LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);

    private int counter;

    public BlockInfuserBE(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }



}
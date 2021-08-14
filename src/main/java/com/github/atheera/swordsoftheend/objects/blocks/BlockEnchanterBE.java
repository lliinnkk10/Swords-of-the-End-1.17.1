package com.github.atheera.swordsoftheend.objects.blocks;

import com.github.atheera.swordsoftheend.inits.EntityInit;
import com.github.atheera.swordsoftheend.materials.CustomEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BlockEnchanterBE extends BlockEntity {

    private final CustomEnergyStorage energyStorage = createEnergy();

    private final LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);

    private boolean hasPower = false;

    public BlockEnchanterBE(BlockPos pos, BlockState state) {
        super(EntityInit.BLOCK_ENCHANTER_BE.get(), pos, state);
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        energy.invalidate();
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        CompoundTag tag = new CompoundTag();
        tag.putBoolean("hasPower", hasPower);
        return new ClientboundBlockEntityDataPacket(worldPosition, 1 ,tag);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        CompoundTag tag = pkt.getTag();
        hasPower = tag.getBoolean("hasPower");
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        tag.putBoolean("hasPower", hasEnoughPowerToWork());
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
        hasPower = tag.getBoolean("hasPower");
    }

    public void tickServer(BlockState state) {
        if(hasEnoughPowerToWork()) {
            energyStorage.consumeEnergy(10);
        }
    }

    public void tickClient(BlockState state) {
        if(hasPower) {
            BlockPos p = this.worldPosition;
            level.addParticle(ParticleTypes.CLOUD, p.getX()+.5, p.getY() + 1.0, p.getZ()+.5, 0.0, 0.0, 0.0);
        }
    }

    private boolean hasEnoughPowerToWork() { return energyStorage.getEnergyStored() >= 10; }

    @Override
    public void load(CompoundTag tag) {
        if(tag.contains("energy")) {
            energyStorage.deserializeNBT(tag.get("energy"));
        }
        super.load(tag);
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        tag.put("energy", energyStorage.serializeNBT());
        return super.save(tag);
    }

    private CustomEnergyStorage createEnergy() {
        return new CustomEnergyStorage(1000, 20) {
            @Override
            protected void onEnergyChanged() {
                boolean newHasPower = hasEnoughPowerToWork();
                if (newHasPower != hasPower) {
                    hasPower = newHasPower;
                    level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
                }
                setChanged();
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityEnergy.ENERGY) {
            return energy.cast();
        }
        return super.getCapability(cap, side);
    }
}
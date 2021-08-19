package com.github.atheera.swordsoftheend.objects.blocks;

import com.github.atheera.swordsoftheend.inits.EntityInit;
import com.github.atheera.swordsoftheend.inits.ItemInit;
import com.github.atheera.swordsoftheend.materials.CustomEnergyStorage;
import com.github.atheera.swordsoftheend.materials.SOTEHooks;
import com.github.atheera.swordsoftheend.objects.items.ItemCore;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BlockEnchanterBE extends BlockEntity {

    private final ItemStackHandler coreHandler = createCoreHandler();
    private final ItemStackHandler swordHandler = createSwordHandler();
    private final CustomEnergyStorage energyStorage = createEnergy();

    private final LazyOptional<IItemHandler> cHandler = LazyOptional.of(() -> coreHandler);
    private final LazyOptional<IItemHandler> sHandler = LazyOptional.of(() -> swordHandler);
    private final LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> energyStorage);

    private boolean hasPower = false;

    public BlockEnchanterBE(BlockPos pos, BlockState state) {
        super(EntityInit.BLOCK_ENCHANTER_BE.get(), pos, state);
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        cHandler.invalidate();
        sHandler.invalidate();
        energy.invalidate();
    }

    private ItemStackHandler createCoreHandler() {
        return new ItemStackHandler(1) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return (SOTEHooks.isCoreValid(stack));
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if(!SOTEHooks.isCoreValid(stack)) {
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    private ItemStackHandler createSwordHandler() {
        return new ItemStackHandler(1) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return (stack.getItem() == ItemInit.ITEM_SWORD_BASE.get());
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if(!(stack.getItem() == ItemInit.ITEM_SWORD_BASE.get())) {
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
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
        //boolean swordCheck = swordHandler.getStackInSlot(0).equals(ItemInit.ITEM_SWORD_BASE.get().getDefaultInstance());
        //boolean coreCheck = SOTEHooks.isCoreValid(coreHandler.getStackInSlot(1));
        if(hasEnoughPowerToWork()) {
            energyStorage.consumeEnergy(10);
        }
    }

    public void tickClient(BlockState state) {
        if(hasPower && level != null) {
            BlockPos p = this.worldPosition;
            level.addParticle(ParticleTypes.PORTAL, p.getX()+.5, p.getY() + 1.0, p.getZ()+.5, 0.0, 0.0, 0.0);
        }
    }

    private boolean hasEnoughPowerToWork() {
        return energyStorage.getEnergyStored() >= 1000;
    }

    @Override
    public void load(CompoundTag tag) {
        if(tag.contains("energy"))
            energyStorage.deserializeNBT(tag.get("energy"));
        if(tag.contains("sword"))
            swordHandler.deserializeNBT((CompoundTag) tag.get("sword"));
        if(tag.contains("core")) coreHandler.deserializeNBT((CompoundTag) tag.get("core"));

        super.load(tag);
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        tag.put("energy", energyStorage.serializeNBT());
        tag.put("sword", swordHandler.serializeNBT());
        tag.put("core", coreHandler.serializeNBT());
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
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            cHandler.cast();
            return sHandler.cast();
        }
        return super.getCapability(cap, side);
    }
}
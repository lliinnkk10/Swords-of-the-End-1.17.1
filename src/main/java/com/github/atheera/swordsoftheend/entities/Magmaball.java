package com.github.atheera.swordsoftheend.entities;

import com.github.atheera.swordsoftheend.inits.ItemInit;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class Magmaball extends AbstractHurtingProjectile implements ItemSupplier {
    private static final EntityDataAccessor<ItemStack> STACK = SynchedEntityData.defineId(Magmaball.class, EntityDataSerializers.ITEM_STACK);

    protected Magmaball(EntityType<? extends Magmaball> entityType, Level world) {
        super(entityType, world);
    }

    public Magmaball(EntityType<? extends Magmaball> entity, double x, double y, double z, double accelX, double accelY, double accelZ, Level world) {
        super(entity, x, y, z, accelX, accelY, accelZ, world);
    }

    public Magmaball(EntityType<? extends Magmaball> entityType, LivingEntity entity, double x, double y, double z, Level world) {
        super(entityType, entity, x, y, z, world);
    }
/*
    public void setItem(ItemStack stack) {
        if(!stack.is(ItemInit.ITEM_TIER_RUBY.get()) || stack.hasTag()) {
            this,getEntityData().set(STACK, Util.make(stack.copy(), () -> {
                stack.setCount(1);
            }));
        }
    }
*/
    @Override
    public ItemStack getItem() {
        return ItemInit.ITEM_TIER_RUBY.get().getDefaultInstance();
    }

    @OnlyIn(Dist.CLIENT)
    public ItemStack getStack() {
        return (ItemStack)getEntityData().get(STACK);
    }

    public void setItem(ItemStack stack) {

    }
/*
    public void setStack(ItemStack stack) {
        if(stack.getItem() != ItemInit.ITEM_TIER_RUBY.get() || stack.hasTag())
            getEntityData().set(STACK, Util.make(stack.copy(), stack -> stack.setCount(1) ));
    }*/

    @Override
    protected void defineSynchedData() {
        getEntityData().define(STACK, ItemStack.EMPTY);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        ItemStack stack = getStack();
        if(!stack.isEmpty())
            nbt.put("Item", stack.save(new CompoundTag()));
    }
}

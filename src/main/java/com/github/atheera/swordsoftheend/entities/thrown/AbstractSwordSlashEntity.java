package com.github.atheera.swordsoftheend.entities.thrown;

import com.github.atheera.swordsoftheend.inits.ItemInit;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class AbstractSwordSlashEntity extends AbstractHurtingProjectile implements ItemSupplier {
    private static final EntityDataAccessor<ItemStack> STACK = SynchedEntityData.defineId(AbstractSwordSlashEntity.class, EntityDataSerializers.ITEM_STACK);

    public AbstractSwordSlashEntity(EntityType<? extends SwordSlashEntity> type, Level world) {
        super(type, world);
    }

    public AbstractSwordSlashEntity(EntityType<? extends LargeFireball> type, double x, double y, double z, double accelX, double accelY, double accelZ, Level world) {
        super(type, x, y, z, accelX, accelY, accelZ, world);
    }

    public AbstractSwordSlashEntity(EntityType<? extends LargeFireball> entityType, LivingEntity entity, double x, double y, double z, Level world) {
        super(entityType, entity, x, y, z, world);
    }

    @Override
    public ItemStack getItem() {
        ItemStack stack = this.getItemRaw();
        return stack.isEmpty() ? new ItemStack(ItemInit.ITEM_ENTITY_SWORDSLASH.get()) : stack;
    }

    public void setItem(ItemStack stack) {
        if(stack.getItem() != ItemInit.ITEM_ENTITY_SWORDSLASH.get() || stack.hasTag()) {
            this.getEntityData().set(STACK, Util.make(stack.copy(), (st) -> {
                st.setCount(1);
            }));
        }
    }

    public ItemStack getItemRaw() {
        return getEntityData().get(STACK);
    }

    protected void defineSynchedData() {
        this.getEntityData().define(STACK, ItemStack.EMPTY);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        ItemStack stack = this.getItemRaw();
        if(!stack.isEmpty())
            nbt.put("Item", stack.save(new CompoundTag()));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        ItemStack stack = ItemStack.of(nbt.getCompound("Item"));
        this.setItem(stack);
    }

    @Override
    public boolean shouldBlockExplode(Explosion p_19987_, BlockGetter p_19988_, BlockPos p_19989_, BlockState p_19990_, float p_19991_) {
        return false;
    }

    @Override
    protected boolean shouldBurn() {
        return false;
    }

    @Override
    protected boolean canHitEntity(Entity entity) {
        return true;
    }

}

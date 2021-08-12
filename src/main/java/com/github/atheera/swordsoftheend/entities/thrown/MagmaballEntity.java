package com.github.atheera.swordsoftheend.entities.thrown;

import com.github.atheera.swordsoftheend.entities.item.AbstractMagmaballEntity;
import com.github.atheera.swordsoftheend.inits.ItemInit;
import com.github.atheera.swordsoftheend.materials.ModDamageSource;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.ForgeEventFactory;

public class MagmaballEntity extends AbstractMagmaballEntity {

    private static final int explosionPower = 2;

    public MagmaballEntity(EntityType<? extends MagmaballEntity> entityType, Level world) {
        super(entityType, world);
    }

    public MagmaballEntity(LivingEntity entity, double x, double y, double z, double accelX, double accelY, double accelZ, Level world) {
        super(EntityType.FIREBALL, x, y, z, accelX, accelY, accelZ, world);
    }

    public MagmaballEntity(LivingEntity entity, double x, double y, double z, Level world) {
        super(EntityType.FIREBALL, entity, x, y, z, world);
    }

    public MagmaballEntity(Level world, LivingEntity shooter, double x, double y, double z) {
        super(EntityType.FIREBALL, shooter, x, y, z, world);
    }

    @Override
    public ItemStack getItem() {
        ItemStack stack = this.getItemRaw();
        return stack.isEmpty() ? new ItemStack(ItemInit.ITEM_TIER_RUBY.get()) : stack;
    }


    @Override
    public void setItem(ItemStack stack) {
        super.setItem(ItemInit.ITEM_TIER_RUBY.get().getDefaultInstance());
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
    protected void onHit(HitResult result) {
        super.onHit(result);
        if(!level.isClientSide) {
            boolean flag = ForgeEventFactory.getMobGriefingEvent(this.level, getOwner());
            this.level.explode((Entity)null, getX(), getY(), getZ(), explosionPower, flag, Explosion.BlockInteraction.NONE);
            this.discard();
        }
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

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if(!level.isClientSide) {
            Entity entity = result.getEntity();
            Entity owner = getOwner();
            if (owner instanceof Player player) {
                player.hurt(ModDamageSource.magmaBallSource(this, owner), 0.0f);
            } else {
                entity.hurt(ModDamageSource.magmaBallSource(this, owner), 15.0f);
            }

        }
    }

}

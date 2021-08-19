package com.github.atheera.swordsoftheend.entities.thrown;

import com.github.atheera.swordsoftheend.inits.EntityInit;
import com.github.atheera.swordsoftheend.inits.ItemInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class SwordSlashEntity extends AbstractSwordSlashEntity {

    public SwordSlashEntity(EntityType<? extends SwordSlashEntity> entity, Level world) {
        super(entity, world);
    }

    public SwordSlashEntity(LivingEntity entity, double x, double y, double z, double accelX, double accelY, double accelZ, Level world) {
        super(EntityType.FIREBALL, x, y, z, accelX, accelY, accelZ, world);
    }

    public SwordSlashEntity(Level world, LivingEntity entity, double x, double y, double z) {
        super(EntityType.FIREBALL, entity, x, y, z, world);
    }

    @Override
    public ItemStack getItem() {
        ItemStack stack = this.getItemRaw();
        return stack.isEmpty() ? new ItemStack(ItemInit.ITEM_ENTITY_SWORDSLASH.get()) : stack;
    }

    @Override
    public void setItem(ItemStack p_37447_) {
        super.setItem(ItemInit.ITEM_ENTITY_SWORDSLASH.get().getDefaultInstance());
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (!level.isClientSide) {
            result.getEntity().hurt(DamageSource.thrown(this, result.getEntity()), 6.0f);
            this.discard();
        }
    }

    @Override
    public void tick() {
        Entity entity = this.getOwner();
        if(entity instanceof Player && !entity.isAlive()) {
            this.discard();
        } else {
            super.tick();
        }
    }
}
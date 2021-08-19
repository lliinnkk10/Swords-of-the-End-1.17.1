package com.github.atheera.swordsoftheend.entities.thrown;

import com.github.atheera.swordsoftheend.inits.ItemInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ThrownSwordSlash extends ThrowableItemProjectile {

    public ThrownSwordSlash(EntityType<? extends ThrownEnderpearl> p_37442_, Level p_37443_) {
        super(p_37442_, p_37443_);
    }

    public ThrownSwordSlash(Level world, LivingEntity entity) {
        super(EntityType.ENDER_PEARL, entity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemInit.ITEM_ENTITY_SWORDSLASH.get();
    }

    @Override
    public void setItem(ItemStack stack) {
        super.setItem(ItemInit.ITEM_ENTITY_SWORDSLASH.get().getDefaultInstance());
    }

    @Override
    protected boolean canHitEntity(Entity p_37250_) {
        return true;
    }

    @Override
    protected void onHitEntity(EntityHitResult entity) {
        super.onHitEntity(entity);
        entity.getEntity().hurt(DamageSource.thrown(this, entity.getEntity()), 10.0f);
        this.discard();
    }

    @Override
    protected void onHit(HitResult hit) {
        super.onHit(hit);

        if(!this.level.isClientSide && !this.isRemoved()) {

            this.discard();

        }

    }

    @Override
    public void tick() {
        Entity entity = this.getOwner();
        if (entity instanceof Player && !entity.isAlive()) {
            this.discard();
        } else {
            super.tick();
        }
    }

}
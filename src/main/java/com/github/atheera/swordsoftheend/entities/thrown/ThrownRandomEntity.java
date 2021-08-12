package com.github.atheera.swordsoftheend.entities.thrown;

import com.github.atheera.swordsoftheend.entities.living.ShadeEntity;
import com.github.atheera.swordsoftheend.inits.EntityInit;
import com.github.atheera.swordsoftheend.inits.ItemInit;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class ThrownRandomEntity extends ThrowableItemProjectile {

    public ThrownRandomEntity(EntityType<? extends ThrownEnderpearl> p_37491_, Level p_37492_) {
        super(p_37491_, p_37492_);
    }

    public ThrownRandomEntity(Level world, LivingEntity entity) {
        super(EntityType.ENDER_PEARL, entity, world);
    }

    protected Item getDefaultItem() {
        return ItemInit.ITEM_SWORD_CHAOS.get();
    }

    protected void onHit(HitResult hit) {
        super.onHit(hit);

        if (!this.level.isClientSide && !this.isRemoved()) {

            Entity entity = getRandomEntity();
            entity.setPos(hit.getLocation());
            this.level.addFreshEntity(entity);

            System.out.println(entity.getDisplayName() + " entity spawned");

            this.discard();
        }

    }

    private Entity getRandomEntity() {
        int rand = new Random().nextInt(5);
        Entity entity = null;
        if(rand == 0) {
            entity = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
        }
        if(rand == 1) {
            entity = new Zombie(EntityType.ZOMBIE, this.level);
        }
        if(rand == 2) {
            entity = new MagmaCube(EntityType.MAGMA_CUBE, this.level);
        }
        if(rand == 3) {
            entity = new IronGolem(EntityType.IRON_GOLEM, this.level);
        }
        if(rand == 4) {
            int random = new Random().nextInt(20);
            if(random == 19) entity = new WitherBoss(EntityType.WITHER, this.level);
            else entity = new WitherSkeleton(EntityType.WITHER_SKELETON, this.level);
        }
        return entity;
    }

    public void tick() {
        Entity entity = this.getOwner();
        if (entity instanceof Player && !entity.isAlive()) {
            this.discard();
        } else {
            super.tick();
        }

    }
}
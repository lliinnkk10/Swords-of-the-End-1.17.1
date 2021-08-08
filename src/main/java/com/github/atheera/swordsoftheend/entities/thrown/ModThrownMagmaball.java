package com.github.atheera.swordsoftheend.entities.thrown;

import com.github.atheera.swordsoftheend.entities.MagmaballEntity;
import com.github.atheera.swordsoftheend.inits.EntityInit;
import com.github.atheera.swordsoftheend.inits.ItemInit;
import com.github.atheera.swordsoftheend.materials.ModDamageSource;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

import javax.annotation.Nullable;

public class ModThrownMagmaball extends ThrowableItemProjectile {

    ModThrownMagmaball thrownMagmaball;
    //EntityType<MagmaballEntity> mbe = EntityType.byString("magmaball_entity");

    public ModThrownMagmaball(EntityType<? extends ModThrownMagmaball> p_37442_, Level p_37443_) {
        super(p_37442_, p_37443_);
    }



    @Override
    protected Item getDefaultItem() {
        return null;
    }
}

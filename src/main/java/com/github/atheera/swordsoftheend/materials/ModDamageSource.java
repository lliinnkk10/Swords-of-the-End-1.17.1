package com.github.atheera.swordsoftheend.materials;

import com.github.atheera.swordsoftheend.entities.thrown.MagmaballEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

public class ModDamageSource extends EntityDamageSource {

    public ModDamageSource(String p_19394_, Entity p_19395_) {
        super(p_19394_, p_19395_);
    }

    public static DamageSource magmaBallSource(MagmaballEntity magmaball, @Nullable Entity entity) {
        return (entity == null)
                ?
            (new IndirectEntityDamageSource("onMagma", magmaball, magmaball).setProjectile())
                :
            (new IndirectEntityDamageSource("magmaBall", magmaball, entity).setIsFire().setProjectile());
    }

    public static DamageSource stupidity(@Nullable Entity entity) {
        return new EntityDamageSource("stupidity", entity);
    }

}
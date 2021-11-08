package com.github.atheera.swordsoftheend.objects.items;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class ItemSwordKing extends ItemSword {

    public ItemSwordKing(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if(target instanceof Mob mob) {
            mob.hurt(DamageSource.MAGIC, mob.getMaxHealth()*0.3f);
        }

        return true;
    }
}
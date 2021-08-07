package com.github.atheera.swordsoftheend.enchantments;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class Enderbane extends ModEnchant {
    public Enderbane(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots);
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }

    @Override
    protected String getOrCreateDescriptionId() {
        return "Enderbane";
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity target, int level) {
        if(target instanceof EnderMan || target instanceof Endermite) {
            switch (level) {
                case 1: ((Monster) target).addEffect(new MobEffectInstance(MobEffects.HARM, 1, 3));
                case 2: ((Monster) target).addEffect(new MobEffectInstance(MobEffects.HARM, 1, 6));
                case 3: ((Monster) target).addEffect(new MobEffectInstance(MobEffects.HARM, 1, 9));
                case 4: ((Monster) target).addEffect(new MobEffectInstance(MobEffects.HARM, 1, 12));
                case 5: ((Monster) target).addEffect(new MobEffectInstance(MobEffects.HARM, 1, 15));
            }
        } else if(target instanceof EnderDragon) {
            switch (level) {
                case 1: ((EnderDragon) target).addEffect(new MobEffectInstance(MobEffects.HARM, 1, 10));
                case 2: ((EnderDragon) target).addEffect(new MobEffectInstance(MobEffects.HARM, 1, 20));
                case 3: ((EnderDragon) target).addEffect(new MobEffectInstance(MobEffects.HARM, 1, 30));
                case 4: ((EnderDragon) target).addEffect(new MobEffectInstance(MobEffects.HARM, 1, 40));
                case 5: ((EnderDragon) target).addEffect(new MobEffectInstance(MobEffects.HARM, 1, 50));
            }
        }
        super.doPostHurt(user, target, level);
    }

}
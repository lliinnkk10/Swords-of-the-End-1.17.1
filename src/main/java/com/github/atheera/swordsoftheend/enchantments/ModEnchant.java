package com.github.atheera.swordsoftheend.enchantments;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.Set;

public class ModEnchant extends Enchantment {
    protected ModEnchant(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots);
    }

    @Override
    public Rarity getRarity() {
        return super.getRarity();
    }

    @Override
    public float getDamageBonus(int amount, MobType type) {
        return super.getDamageBonus(amount, type);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return super.canApplyAtEnchantingTable(stack);
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity target, int level) {
        super.doPostAttack(user, target, level);
    }

    @Override
    public void doPostHurt(LivingEntity user, Entity target, int level) {
        super.doPostHurt(user, target, level);
    }

    @Override
    public String getDescriptionId() {
        return super.getDescriptionId();
    }

    @Override
    public int getMaxLevel() {
        return super.getMaxLevel();
    }

    @Override
    public int getMinLevel() {
        return super.getMinLevel();
    }

    @Override
    public int getMaxCost(int cost) {
        return super.getMaxCost(cost);
    }

    @Override
    public int getMinCost(int cost) {
        return super.getMinCost(cost);
    }

    @Override
    public boolean isAllowedOnBooks() {
        return super.isAllowedOnBooks();
    }

    @Override
    protected String getOrCreateDescriptionId() {
        return super.getOrCreateDescriptionId();
    }

    @Override
    public Set<ResourceLocation> getTags() {
        return super.getTags();
    }
}
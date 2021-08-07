package com.github.atheera.swordsoftheend.enchantments;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class Lifesteal extends ModEnchant {
    public Lifesteal(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot[] p_44678_) {
        super(p_44676_, p_44677_, p_44678_);
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
        return "Lifesteal";
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity target, int level) {
        if(user instanceof Player) {
            switch (level) {
                case 1: user.heal(0.2f);
                case 2: user.heal(0.4f);
                case 3: user.heal(0.6f);
                case 4: user.heal(0.8f);
                case 5: user.heal(1.0f);
            }
        }
        super.doPostHurt(user, target, level);
    }
}
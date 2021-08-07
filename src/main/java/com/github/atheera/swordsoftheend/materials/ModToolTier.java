package com.github.atheera.swordsoftheend.materials;

import java.util.function.Supplier;

import com.github.atheera.swordsoftheend.inits.ItemInit;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

@SuppressWarnings("deprecation")
public enum ModToolTier implements Tier {

	BASE(1, 2420, 1.0f, 0.0f, 20, () -> {
		return Ingredient.of(Items.NETHERITE_INGOT);
	}),
	TIERONE(1, 3269, 1.0f, 0.0f, 0, () -> {
		return Ingredient.of(Items.NETHERITE_INGOT);
	}),
	TIERTWO(1, 1569, 1.0f, 0.0f, 0, () ->{
		return Ingredient.of(ItemInit.ITEM_CORE_LEVEL.get());
	});
	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyLoadedValue<Ingredient> repairMaterial;

	ModToolTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = new LazyLoadedValue<>(repairMaterial);
	}

	@Override public int getUses() { return this.maxUses; }
	@Override public float getSpeed() { return this.efficiency; }
	@Override public float getAttackDamageBonus() { return this.attackDamage; }
	@Override public int getLevel() { return this.harvestLevel; }
	@Override public int getEnchantmentValue() { return this.enchantability; }
	@Override public Ingredient getRepairIngredient() { return this.repairMaterial.get(); }
}
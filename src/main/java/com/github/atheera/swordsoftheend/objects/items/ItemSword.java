package com.github.atheera.swordsoftheend.objects.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class ItemSword extends SwordItem {
	
	public final int sec = 20;
	
	public ItemSword(Tier tier, int damage, float speed, Properties properties) {
		super(tier, damage, speed, properties);
	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, world, tooltip, flagIn);
	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		return super.hurtEnemy(stack, target, attacker);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, Level world, Entity entity, int time, boolean held) {
		super.inventoryTick(stack, world, entity, time, held);
	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		return super.getRarity(stack);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		return super.use(world, player, hand);
	}
	
	@Override public boolean isFoil(ItemStack stack) { return true; }
	@Override public boolean isEnchantable(ItemStack stack) { return false; }
	@Override public boolean isBookEnchantable(ItemStack stack, ItemStack book) { return false; }
	
}
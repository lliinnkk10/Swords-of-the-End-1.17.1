package com.github.atheera.swordsoftheend.objects.items;

import java.util.List;

import com.github.atheera.swordsoftheend.utils.KeyboardHelper;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class ItemSwordDiamond extends ItemSword {

	public ItemSwordDiamond(Tier tier, int damage, float speed, Properties prop) {
		super(tier, damage, speed, prop);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flagIn) {
		if(KeyboardHelper.isHoldingShift()) {
			tooltip.add(new TextComponent(ChatFormatting.AQUA + "YEEEEEEET!!!"));
			tooltip.add(new TextComponent(ChatFormatting.AQUA + "YEEEEEEET!!!"));
			tooltip.add(new TextComponent(ChatFormatting.AQUA + "Rightclick for temporary speed, jump boost and slow falling"));
		} else {
			tooltip.add(new TextComponent(ChatFormatting.WHITE + "Hold " + ChatFormatting.LIGHT_PURPLE + "SHIFT" + ChatFormatting.WHITE + " for description"));
		}
		super.appendHoverText(stack, world, tooltip, flagIn);
	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if(target instanceof Mob) 
			target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 15, 10));
		return super.hurtEnemy(stack, target, attacker);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, Level world, Entity entity, int time, boolean held) {
		if(!stack.isEnchanted())
			stack.enchant(Enchantments.KNOCKBACK, 7);
		super.inventoryTick(stack, world, entity, time, held);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		player.addEffect(new MobEffectInstance(MobEffects.JUMP, sec*15, 2));
		player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sec*15, 2));
		player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, sec*15));
		player.getCooldowns().addCooldown(this, sec*30);
		return super.use(world, player, hand);
	}
	
}
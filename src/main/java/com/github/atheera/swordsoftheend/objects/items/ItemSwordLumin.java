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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ItemSwordLumin extends ItemSword {

	public ItemSwordLumin(Tier tier, int damage, float speed, Properties prop) {
		super(tier, damage, speed, prop);
	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flagIn) {
		if(KeyboardHelper.isHoldingShift()) {
			tooltip.add(new TextComponent(ChatFormatting.AQUA + "Your best friend for cave exploring"));
			tooltip.add(new TextComponent(ChatFormatting.AQUA + "Tag mobs hit to easily track them"));
			tooltip.add(new TextComponent(ChatFormatting.AQUA + "Rightclick for temporary incredible mining abilities"));
		} else {
			tooltip.add(new TextComponent(ChatFormatting.WHITE + "Hold " + ChatFormatting.LIGHT_PURPLE + "SHIFT" + ChatFormatting.WHITE + " for description"));
		}
		super.appendHoverText(stack, world, tooltip, flagIn);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if(target instanceof Mob)
			target.addEffect(new MobEffectInstance(MobEffects.GLOWING, sec*30));
		return super.hurtEnemy(stack, target, attacker);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		player.addEffect(new MobEffectInstance(MobEffects.LUCK, sec*45, 1));
		player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, sec*45, 2));
		player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, sec*45));
		player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, sec*45));
		player.getCooldowns().addCooldown(this, sec*60);
		return super.use(world, player, hand);
	}

}
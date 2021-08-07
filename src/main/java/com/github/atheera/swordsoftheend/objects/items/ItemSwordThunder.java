package com.github.atheera.swordsoftheend.objects.items;

import com.github.atheera.swordsoftheend.utils.KeyboardHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

import net.minecraft.world.item.Item.Properties;

public class ItemSwordThunder extends ItemSword {

	public String tagActive = "active";
	public boolean active;

	public String tagTimer = "timer";
	public int timer;

	public ItemSwordThunder(Tier tier, int damage, float speed, Properties prop) {
		super(tier, damage, speed, prop);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flagIn) {
		if(KeyboardHelper.isHoldingShift()) {
			tooltip.add(new TextComponent(ChatFormatting.AQUA + "RAARRRRGGGGGGHHHHHHH!!!"));
			tooltip.add(new TextComponent(ChatFormatting.AQUA + "Rightclick for temporary berserker strength"));
			tooltip.add(new TextComponent(ChatFormatting.AQUA + "Short fatigue after"));
		} else {
			tooltip.add(new TextComponent(ChatFormatting.WHITE + "Hold " + ChatFormatting.LIGHT_PURPLE + "SHIFT" + ChatFormatting.WHITE + " for description"));
		}
		super.appendHoverText(stack, world, tooltip, flagIn);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level world, Entity entity, int time, boolean held) {
		CompoundTag nbt = stack.getOrCreateTag();
		this.active = nbt.getBoolean(this.tagActive);
		this.timer = nbt.getInt(this.tagTimer);
		Player player = (Player)entity;

		if(active) {
			nbt.putInt(tagTimer, timer + 1);
			if(timer == sec*30) {
				player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sec*8, 1));
				player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, sec*8, 1));
				player.addEffect(new MobEffectInstance(MobEffects.HUNGER, sec*8, 1));
				player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, sec*8, 1));
				nbt.putInt(tagTimer, 0);
				nbt.putBoolean(tagActive, false);
			}
		}
		super.inventoryTick(stack, world, entity, time, held);
	}

	public void rcEffect(ItemStack stack, Player player) {
		CompoundTag nbt = stack.getOrCreateTag();
		this.active = nbt.getBoolean(this.tagActive);
		this.timer = nbt.getInt(this.tagTimer);

		player.getCooldowns().addCooldown(this, sec*60);
		player.addEffect(new MobEffectInstance(MobEffects.JUMP, sec*30, 1));
		player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, sec*30, 1));
		player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sec*30, 2));
		player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, sec*30, 2));
		player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, sec*30, 1));
		nbt.putBoolean(this.tagActive, true);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ItemStack stack = player.getMainHandItem();
		rcEffect(stack, player);

		return super.use(world, player, hand);
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}
}
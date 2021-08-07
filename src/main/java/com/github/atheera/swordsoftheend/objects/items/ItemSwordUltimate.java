package com.github.atheera.swordsoftheend.objects.items;

import java.util.List;

import com.github.atheera.swordsoftheend.inits.EnchantInit;
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
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class ItemSwordUltimate extends ItemSword {

	public String tagActive = "active";
	public boolean active;

	public String tagTimer = "timer";
	public int timer;

	public ItemSwordUltimate(Tier tier, int damage, float speed, Properties prop) {
		super(tier, damage, speed, prop);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flagIn) {
		if(KeyboardHelper.isHoldingShift()) {
			tooltip.add(new TextComponent(ChatFormatting.AQUA + "Infused with the powers of The Old One"));
			tooltip.add(new TextComponent(ChatFormatting.AQUA + "Insane power pulsates through the sword"));
			tooltip.add(new TextComponent(ChatFormatting.AQUA + "Rightclick to temporarily become a God"));
		} else {
			tooltip.add(new TextComponent(ChatFormatting.WHITE + "Hold " + ChatFormatting.LIGHT_PURPLE + "SHIFT" + ChatFormatting.WHITE + " for description"));
		}
		super.appendHoverText(stack, world, tooltip, flagIn);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ItemStack stack = player.getMainHandItem();
		CompoundTag nbt = stack.getOrCreateTag();
		this.active = nbt.getBoolean(this.tagActive);
		this.timer = nbt.getInt(this.tagTimer);

		player.getCooldowns().addCooldown(this, sec*90);
		player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, sec*60));
		player.addEffect(new MobEffectInstance(MobEffects.JUMP, sec*60, 1));
		player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, sec*60, 4));
		player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sec*60, 2));
		player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, sec*60, 1));
		player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, sec*60, 1));
		player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, sec*60));
		nbt.putBoolean(this.tagActive, true);
		setCreative(player);

		return super.use(world, player, hand);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level world, Entity entity, int time, boolean held) {
		if(!stack.isEnchanted()) {
			stack.enchant(EnchantInit.LIFESTEAL.get(), 5);
			stack.enchant(Enchantments.MOB_LOOTING, 5);
			stack.enchant(Enchantments.KNOCKBACK, 2);
			stack.enchant(Enchantments.SWEEPING_EDGE, 5);
		}
		CompoundTag nbt = stack.getOrCreateTag();
		this.active = nbt.getBoolean(this.tagActive);
		this.timer = nbt.getInt(this.tagTimer);
		Player player = (Player)entity;

		if(active) {
			setCreative(player);
			nbt.putInt(tagTimer, timer + 1);
			if(timer == sec*60) {
				removeCreative(player);
				player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, sec*30));
				nbt.putInt(tagTimer, 0);
				nbt.putBoolean(tagActive, false);
				if(player.isCreative())
					setCreative(player);
			}
		}

		if(player.isOnGround() && player.hasEffect(MobEffects.SLOW_FALLING) && held)
			player.removeEffect(MobEffects.SLOW_FALLING);

		super.inventoryTick(stack, world, entity, time, held);
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack item, Player player) {
		if(player.isCreative())
			setCreative(player);
		if(!player.isCreative())
			removeCreative(player);
		return super.onDroppedByPlayer(item, player);
	}

	public void setCreative(Player player) {
		player.getAbilities().mayfly = true;
		player.onUpdateAbilities();
	}

	public void removeCreative(Player player) {
		player.getAbilities().flying = false;
		player.getAbilities().mayfly = false;
		player.onUpdateAbilities();
	}

	@Override
	public boolean isDamageable(ItemStack stack) {
		return false;
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}
}
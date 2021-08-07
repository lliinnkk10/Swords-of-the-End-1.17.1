package com.github.atheera.swordsoftheend.objects.items;

import java.util.List;

import com.github.atheera.swordsoftheend.entities.ModThrownEnderpearl;
import com.github.atheera.swordsoftheend.inits.EnchantInit;
import com.github.atheera.swordsoftheend.utils.KeyboardHelper;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ItemSwordEnd extends ItemSword {

	public ItemSwordEnd(Tier tier, int damage, float speed, Properties prop) {
		super(tier, damage, speed, prop);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flagIn) {
		if(KeyboardHelper.isHoldingShift()) {
			tooltip.add(new TextComponent(ChatFormatting.AQUA + "Ender? I barely know her"));
			tooltip.add(new TextComponent(ChatFormatting.AQUA + "Obliterate the ender creatures"));
			tooltip.add(new TextComponent(ChatFormatting.AQUA + "Rightclick to throw non self-harming ender pearl, that damages mobs hit and does not spawn endermites"));
		} else {
			tooltip.add(new TextComponent(ChatFormatting.WHITE + "Hold " + ChatFormatting.LIGHT_PURPLE + "SHIFT" + ChatFormatting.WHITE + " for description"));
		}
		super.appendHoverText(stack, world, tooltip, flagIn);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level world, Entity entity, int time, boolean held) {
		if(!stack.isEnchanted()) {
			stack.enchant(EnchantInit.ENDERBANE.get(), 5);
		}
		super.inventoryTick(stack, world, entity, time, held);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ItemStack stack = new ItemStack(Items.ENDER_PEARL);
		world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
		player.getCooldowns().addCooldown(this, 30);
		if(!world.isClientSide) {
			ModThrownEnderpearl thrownpearl = new ModThrownEnderpearl(world, player);
			thrownpearl.setItem(stack);
			thrownpearl.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 1.5f, 1.0f);
			world.addFreshEntity(thrownpearl);
		}
		return super.use(world, player, hand);
	}



}
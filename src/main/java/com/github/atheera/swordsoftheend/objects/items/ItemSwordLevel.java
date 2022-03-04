package com.github.atheera.swordsoftheend.objects.items;

import com.github.atheera.swordsoftheend.inits.EnchantInit;
import com.github.atheera.swordsoftheend.materials.Rarities;
import com.github.atheera.swordsoftheend.utils.KeyboardHelper;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.List;

public class ItemSwordLevel extends ItemSword {

	public String tagLevel = "level";
	public int level;
	//public int ms1 = 5, ms2 = 10, ms3 = 20, ms4 = 30, ms5 = 40, ms6 = 50, ms7 = 60, ms8 = 70, ms9 = 80, ms10 = 90;
	public int ms1 = 50, ms2 = 125, ms3 = 250, ms4 = 500, ms5 = 750, ms6 = 1000, ms7 = 1250, ms8 = 1500, ms9 = 2000, ms10 = 2500;

	public String tagDragon = "dragon";
	public boolean dragon;
	public String tagDragonLvl = "dragonLvl";
	public int dragonLvl;

	public String tagWither = "wither";
	public boolean wither;
	public String tagWitherLvl = "witherLvl";
	public int witherLvl;

	public String tagAdded = "added";
	public boolean added;

	public ItemSwordLevel(Tier tier, int damage, float speed, Properties prop) {
		super(tier, damage, speed, prop);
	}

	public void levelUp(ItemStack stack, EMobType type) {
		CompoundTag nbt = stack.getOrCreateTag();
		this.level = nbt.getInt(this.tagLevel);
		switch (type) { // Levels up and sets milestone tags
			case DRAGON -> {
				nbt.putInt(this.tagLevel, level + 25);
				nbt.putBoolean(this.tagDragon, true);
				nbt.putInt(this.tagDragonLvl, nbt.getInt(tagDragonLvl) + 1);
			}
			case WITHER -> {
				nbt.putInt(this.tagLevel, level + 10);
				nbt.putBoolean(this.tagWither, true);
				nbt.putInt(this.tagWitherLvl, nbt.getInt(tagWitherLvl) + 1);
			}
			case REGULAR -> nbt.putInt(this.tagLevel, level + 1);
		}
		setAbilities(stack);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if(target instanceof Mob) {
			if (checkMS(stack) == 10) {
				target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sec*5, 1));
				target.addEffect(new MobEffectInstance(MobEffects.POISON, sec*5, 2));
				target.addEffect(new MobEffectInstance(MobEffects.WITHER, sec*5, 1));
			} else if (checkMS(stack) == 9) {
				target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sec*5, 1));
				target.addEffect(new MobEffectInstance(MobEffects.POISON, sec*5, 1));
				target.addEffect(new MobEffectInstance(MobEffects.WITHER, sec*5, 1));
			} else if (checkMS(stack) == 8) {
				target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sec*5, 1));
				target.addEffect(new MobEffectInstance(MobEffects.POISON, sec*5, 1));
				target.addEffect(new MobEffectInstance(MobEffects.WITHER, sec*5, 1));
			} else if (checkMS(stack) == 7) {
				target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sec*5, 1));
				target.addEffect(new MobEffectInstance(MobEffects.POISON, sec*5, 1));
				target.addEffect(new MobEffectInstance(MobEffects.WITHER, sec*5, 1));
			} else if (checkMS(stack) == 6) {
				target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sec*5, 1));
				target.addEffect(new MobEffectInstance(MobEffects.POISON, sec*5));
			} else if (checkMS(stack) == 5) {
				target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sec*5, 1));
				target.addEffect(new MobEffectInstance(MobEffects.POISON, sec*5));
			} else if (checkMS(stack) == 4) {
				target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sec*5));
				target.addEffect(new MobEffectInstance(MobEffects.POISON, sec*5));
			} else if (checkMS(stack) == 3) {
				target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sec*5));
			} else if (checkMS(stack) == 2) {
				target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sec*5));
			} else if (checkMS(stack) == 1) {
				target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sec*5));
			}
		}
		return super.hurtEnemy(stack, target, attacker);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level world, Entity entity, int time, boolean held) {
		CompoundTag nbt = stack.getOrCreateTag();
		if(!nbt.getBoolean(this.tagAdded)) {
			this.dragon = nbt.getBoolean(this.tagDragon);
			nbt.putBoolean(this.tagDragon, false);
			this.wither = nbt.getBoolean(this.tagWither);
			nbt.putBoolean(this.tagWither, false);
			this.level = nbt.getInt(this.tagLevel);
			nbt.putInt(this.tagLevel, 0);
			this.dragonLvl = nbt.getInt(this.tagDragonLvl);
			nbt.putInt(this.tagDragonLvl, 0);
			this.witherLvl = nbt.getInt(this.tagWitherLvl);
			nbt.putInt(this.tagWitherLvl, 0);
			this.added = nbt.getBoolean(this.tagAdded);
			nbt.putBoolean(this.tagAdded, true);
		}

		if (checkMS(stack) == 10 && entity instanceof Player player && held) {
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sec, 2));
			player.addEffect(new MobEffectInstance(MobEffects.JUMP, sec, 1));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, sec, 2));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, sec, 1));
			player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, sec));
			player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, sec));
		}
		super.inventoryTick(stack, world, entity, time, held);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ItemStack stack = player.getMainHandItem();

		if(checkMS(stack) == 10) {
			player.getCooldowns().addCooldown(this, sec*30);
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sec*30, 2));
			player.addEffect(new MobEffectInstance(MobEffects.JUMP, sec*30, 1));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, sec*30, 2));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, sec*30, 1));
			player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, sec*30));
		} else if(checkMS(stack) == 9) {
			player.getCooldowns().addCooldown(this, sec*45);
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sec*30, 2));
			player.addEffect(new MobEffectInstance(MobEffects.JUMP, sec*30, 1));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, sec*30, 2));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, sec*30, 1));
			player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, sec*30));
		} else if(checkMS(stack) == 8) {
			player.getCooldowns().addCooldown(this, sec*45);
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sec*30, 2));
			player.addEffect(new MobEffectInstance(MobEffects.JUMP, sec*30, 1));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, sec*30, 2));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, sec*30));
		} else if(checkMS(stack) == 7) {
			player.getCooldowns().addCooldown(this, sec*45);
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.JUMP, sec*30, 1));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, sec*30));
		} else if(checkMS(stack) == 6) {
			player.getCooldowns().addCooldown(this, sec*45);
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.JUMP, sec*30, 1));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, sec*30));
		} else if(checkMS(stack) == 5) {
			player.getCooldowns().addCooldown(this, sec*45);
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.JUMP, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, sec*30));
		} else if(checkMS(stack) == 4) {
			player.getCooldowns().addCooldown(this, sec*45);
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.JUMP, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, sec*30));
		} else if(checkMS(stack) == 3) {
			player.getCooldowns().addCooldown(this, sec*45);
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.JUMP, sec*30));
		} else if(checkMS(stack) == 2) {
			player.getCooldowns().addCooldown(this, sec*45);
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sec*30));
			player.addEffect(new MobEffectInstance(MobEffects.JUMP, sec*30));
		} else {
			player.getCooldowns().addCooldown(this, 0);
		}
		return super.use(world, player, hand);
	}

	public void setAbilities(ItemStack stack) {
		CompoundTag nbt = stack.getOrCreateTag();
		this.level = nbt.getInt(this.tagLevel);

		stack.getEnchantmentTags().clear();
		if(checkMS(stack) == 10) {
			stack.enchant(EnchantInit.LIFESTEAL.get(), 5);
			stack.enchant(Enchantments.SWEEPING_EDGE, 3);
			stack.enchant(Enchantments.MOB_LOOTING, 3);
			stack.enchant(Enchantments.FIRE_ASPECT, 1);
			stack.enchant(Enchantments.MENDING, 1);
		} else if(checkMS(stack) == 9) {
			stack.enchant(EnchantInit.LIFESTEAL.get(), 4);
			stack.enchant(Enchantments.SWEEPING_EDGE, 3);
			stack.enchant(Enchantments.MOB_LOOTING, 2);
		} else if(checkMS(stack) == 8) {
			stack.enchant(EnchantInit.LIFESTEAL.get(), 3);
			stack.enchant(Enchantments.SWEEPING_EDGE, 2);
			stack.enchant(Enchantments.MOB_LOOTING, 1);
		} else if(checkMS(stack) == 7) {
			stack.enchant(EnchantInit.LIFESTEAL.get(), 3);
			stack.enchant(Enchantments.SWEEPING_EDGE, 2);
			stack.enchant(Enchantments.MOB_LOOTING, 1);
		} else if(checkMS(stack) == 6) {
			stack.enchant(EnchantInit.LIFESTEAL.get(), 3);
			stack.enchant(Enchantments.SWEEPING_EDGE, 2);
			stack.enchant(Enchantments.MOB_LOOTING, 1);
		} else if(checkMS(stack) == 5) {
			stack.enchant(EnchantInit.LIFESTEAL.get(), 3);
			stack.enchant(Enchantments.SWEEPING_EDGE, 2);
			stack.enchant(Enchantments.MOB_LOOTING, 1);
		} else if(checkMS(stack) == 4) {
			stack.enchant(EnchantInit.LIFESTEAL.get(), 2);
			stack.enchant(Enchantments.SWEEPING_EDGE, 1);
		} else if(checkMS(stack) == 3) {
			stack.enchant(EnchantInit.LIFESTEAL.get(), 2);
			stack.enchant(Enchantments.SWEEPING_EDGE, 1);
		} else if(checkMS(stack) == 2) {
			stack.enchant(EnchantInit.LIFESTEAL.get(), 1);
		} else if(checkMS(stack) == 1) {
			stack.enchant(EnchantInit.LIFESTEAL.get(), 1);
		}
	}

	// Checks the level of the stack and returns it as an int of the milestone
	public int checkMS(ItemStack stack) {
		CompoundTag nbt = stack.getOrCreateTag();
		int lvl = nbt.getInt(this.tagLevel);
		boolean wthr = nbt.getBoolean(this.tagWither);
		boolean drgn = nbt.getBoolean(this.tagDragon);

		boolean cWD = (wthr && drgn);
		boolean cwd = (!wthr && !drgn);

		if((lvl >= ms10) && cWD) { return 10; }
		else if(((lvl >= ms9 && lvl < ms10) && wthr) || ((lvl > ms10) && wthr)) { return 9; }
		else if(((lvl >= ms8 && lvl < ms9) && wthr) || ((lvl > ms9) && wthr)) { return 8; }
		else if(((lvl >= ms7 && lvl < ms8) && wthr) || ((lvl > ms8) && wthr)) { return 7; }
		else if(((lvl >= ms6 && lvl < ms7) && cwd) || ((lvl > ms6) && cwd)) { return 6; }
		else if(lvl >= ms5 && lvl < ms6) { return 5; }
		else if(lvl >= ms4 && lvl < ms5) { return 4; }
		else if(lvl >= ms3 && lvl < ms4) { return 3; }
		else if(lvl >= ms2 && lvl < ms3) { return 2; }
		else if(lvl >= ms1 && lvl < ms2) { return 1; }
		else if(lvl < ms1) return 0;
		else return 0;
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
		Multimap<Attribute, AttributeModifier> map = HashMultimap.create();

		if(slot == EquipmentSlot.MAINHAND) {
			if(checkMS(stack) == 0) {
				map.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.4f, AttributeModifier.Operation.ADDITION));
				map.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 9, AttributeModifier.Operation.ADDITION));
			} else if(checkMS(stack) == 1) {
				map.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.4f, AttributeModifier.Operation.ADDITION));
				map.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 10, AttributeModifier.Operation.ADDITION));
			} else if(checkMS(stack) == 2) {
				map.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.4f, AttributeModifier.Operation.ADDITION));
				map.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 11, AttributeModifier.Operation.ADDITION));
			} else if(checkMS(stack) == 3) {
				map.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.4f, AttributeModifier.Operation.ADDITION));
				map.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 12, AttributeModifier.Operation.ADDITION));
			} else if(checkMS(stack) == 4) {
				map.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.4f, AttributeModifier.Operation.ADDITION));
				map.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 13, AttributeModifier.Operation.ADDITION));
			} else if(checkMS(stack) == 5) {
				map.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.4f, AttributeModifier.Operation.ADDITION));
				map.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 14, AttributeModifier.Operation.ADDITION));
			} else if(checkMS(stack) == 6) {
				map.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.4f, AttributeModifier.Operation.ADDITION));
				map.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 15, AttributeModifier.Operation.ADDITION));
			} else if(checkMS(stack) == 7) {
				map.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.2f, AttributeModifier.Operation.ADDITION));
				map.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 16, AttributeModifier.Operation.ADDITION));
			} else if(checkMS(stack) == 8) {
				map.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.2f, AttributeModifier.Operation.ADDITION));
				map.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 17, AttributeModifier.Operation.ADDITION));
			} else if(checkMS(stack) == 9) {
				map.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.2f, AttributeModifier.Operation.ADDITION));
				map.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 18, AttributeModifier.Operation.ADDITION));
			} else if(checkMS(stack) == 10) {
				map.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.0f, AttributeModifier.Operation.ADDITION));
				map.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 19, AttributeModifier.Operation.ADDITION));
			} else {
				map.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.4f, AttributeModifier.Operation.ADDITION));
				map.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 9, AttributeModifier.Operation.ADDITION));
			}
		}

		return map;
	}

	public enum EMobType {
		WITHER,
		DRAGON,
		REGULAR
	}

	@Override
	public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flagIn) {
		ChatFormatting aqua = ChatFormatting.AQUA;
		ChatFormatting green = ChatFormatting.GREEN;
		ChatFormatting white = ChatFormatting.WHITE;
		ChatFormatting purple = ChatFormatting.LIGHT_PURPLE;
		CompoundTag nbt = stack.getOrCreateTag();
		int lvl = nbt.getInt(this.tagLevel);
		boolean wthr = nbt.getBoolean(this.tagWither);
		boolean drgn = nbt.getBoolean(this.tagDragon);

		tooltip.add(new TextComponent(aqua + "Currently absorbed " + green + lvl + aqua + " souls"));
		tooltip.add(new TextComponent(aqua + "Currently absorbed " + green + nbt.getInt(tagWitherLvl) + aqua + " wither souls"));
		tooltip.add(new TextComponent(aqua + "Currently absorbed " + green + nbt.getInt(tagDragonLvl) + aqua + " dragon souls"));
		if(KeyboardHelper.isHoldingShift()) { // SHIFT information
			if(lvl == 0) {
				tooltip.add(new TextComponent(aqua + "Crafted with a dull edge that can absorb souls from slain foes"));
				tooltip.add(new TextComponent(aqua + "Passing certain thresholds, the sword greatly increases in power, gaining damage every level"));
				tooltip.add(new TextComponent(aqua + "At maximum capacity, " + green + ms10 + aqua + ", the sword obliterates everything hit"));
			}
			if(checkMS(stack) == 0) {
				tooltip.add(new TextComponent(aqua + "Another " + green + (ms1 - lvl) + aqua + " souls is required for the next evolution:"));
				tooltip.add(new TextComponent(aqua + "Add " + green + "slowness and lifesteal" + aqua + " to attacks"));
			}
			if(checkMS(stack) == 1) {
				tooltip.add(new TextComponent(aqua + "Another " + green + (ms2 - lvl) + aqua + " souls is required for the next evolution:"));
				tooltip.add(new TextComponent(aqua + "Add " + green + "speed 1 and jump boost 1" + aqua + " to right click"));
			}
			if(checkMS(stack) == 2) {
				tooltip.add(new TextComponent(aqua + "Another " + green + (ms3 - lvl) + aqua + " souls is required for the next evolution:"));
				tooltip.add(new TextComponent(aqua + "Add " + green + "poison 1 and lifesteal 2" + aqua + " to attacks"));
			}
			if(checkMS(stack) == 3) {
				tooltip.add(new TextComponent(aqua + "Another " + green + (ms4 - lvl) + aqua + " souls is required for the next evolution:"));
				tooltip.add(new TextComponent(aqua + "Add " + green + "strength 1 and resistance 1" + aqua + " to right click"));
			}
			if(checkMS(stack) == 4) {
				tooltip.add(new TextComponent(aqua + "Another " + green + (ms5 - lvl) + aqua + " souls is required for the next evolution:"));
				tooltip.add(new TextComponent(aqua + "Add " + green + "slowness 2 and lifesteal 3" + aqua + " to attacks"));
			}
			if(checkMS(stack) == 5) {
				tooltip.add(new TextComponent(aqua + "Another " + green + (ms6 - lvl) + aqua + " souls is required for the next evolution:"));
				tooltip.add(new TextComponent(aqua + "Add " + green + "jump boost 2 and fire resistance" + aqua + " to right click"));
			}
			if(checkMS(stack) == 6) {
				int remaining = ms7 - lvl;
				String text = ("Another " + green + (ms7 - lvl) + aqua + " souls is required for the next evolution:");
				if(remaining <= 0) text = ("Enough souls acquired but the " + green + "wither boss" + aqua + " soul has not been absorbed yet");
				if(!wthr) tooltip.add(new TextComponent(aqua + "The sword also requires a " + green + "wither boss" + aqua + " soul to improve further"));
				tooltip.add(new TextComponent(aqua + text));
				tooltip.add(new TextComponent(aqua + "Add " + green + "poison 2 and wither 2" + aqua + " to attacks"));
				tooltip.add(new TextComponent(aqua + "And increased " + green + "attack speed"));
			}
			if(checkMS(stack) == 7) {
				tooltip.add(new TextComponent(aqua + "Another " + green + (ms8 - lvl) + aqua + " souls is required for the next evolution:"));
				tooltip.add(new TextComponent(aqua + "Add " + green + "speed 3 and strength 3" + aqua + " to right click"));
			}
			if(checkMS(stack) == 8) {
				tooltip.add(new TextComponent(aqua + "Another " + green + (ms9 - lvl) + aqua + " souls is required for the next evolution:"));
				tooltip.add(new TextComponent(aqua + "Add " + green + "lifesteal 4" + aqua + " to attacks"));
				tooltip.add(new TextComponent(aqua + "And " + green + "haste 1 and resistance 2" + aqua + " to right click"));
			}
			if(checkMS(stack) == 9) {
				int remaining = ms10 - lvl;
				String text = ("Another " + green + (ms10 - lvl) + aqua + " souls is required for the next evolution:");
				if(remaining <= 0) text = ("Enough souls acquired but the " + green + "dragon boss" + aqua + " soul has not been absorbed yet");
				if(!drgn) tooltip.add(new TextComponent(aqua + "The sword also requires a " + green + "dragon boss" + aqua + " soul to improve further"));
				tooltip.add(new TextComponent(aqua + text));
				tooltip.add(new TextComponent(aqua + "Add " + green + "poison 3, lifesteal 5 and fire aspect" + aqua + " to attacks"));
				tooltip.add(new TextComponent(aqua + "And " + green + "all right click effects" + aqua + " permanently when holding the sword"));
				tooltip.add(new TextComponent(aqua + "And increased " + green + "attack speed"));
			}
			if(checkMS(stack) == 10) {
				tooltip.add(new TextComponent(aqua + "No more buffs to acquire, fully evolved sword"));
				tooltip.add(new TextComponent(white + "Hold " + purple + "CTRL" + white + " to see all current buffs"));
			}
		} else if(KeyboardHelper.isHoldingCtrl()) { // CTRL information
			tooltip.add(new TextComponent(aqua + "The current buffs are:"));
			if(lvl == 0) {
				tooltip.add(new TextComponent(aqua + "You have not absorbed any souls yet"));
				tooltip.add(new TextComponent(aqua + "Kill something to absorb their power"));
				tooltip.add(new TextComponent(aqua + "and infuse the sword for powerful effects"));
			} else if(checkMS(stack) == 0) {
				tooltip.add(new TextComponent(aqua + "Not enough souls for improvement yet"));
			} else if(checkMS(stack) == 1) {
				tooltip.add(new TextComponent(aqua + "Attacks: " + green + "slowness 1 and lifesteal 1"));
			} else if(checkMS(stack) == 2) {
				tooltip.add(new TextComponent(aqua + "Attacks: " + green + "slowness 1 and lifesteal 1"));
				tooltip.add(new TextComponent(aqua + "Right click: " + green + "speed 1 and jump boost 1"));
			} else if(checkMS(stack) == 3) {
				tooltip.add(new TextComponent(aqua + "Attacks: " + green + "slowness 1 and lifesteal 2"));
				tooltip.add(new TextComponent(aqua + "Right click: " + green + "speed 1 and jump boost 1"));
			} else if(checkMS(stack) == 4) {
				tooltip.add(new TextComponent(aqua + "Attacks: " + green + "slowness 1, lifesteal 2 and poison 1"));
				tooltip.add(new TextComponent(aqua + "Right click: " + green + "speed 1, jump boost 1, strength 1 and resistance 1"));
			} else if(checkMS(stack) == 5) {
				tooltip.add(new TextComponent(aqua + "Attacks: " + green + "slowness 1, lifesteal 3 and poison 1"));
				tooltip.add(new TextComponent(aqua + "Right click: " + green + "speed 1, jump boost 1, strength 1 and resistance 1"));
			} else if(checkMS(stack) == 6) {
				tooltip.add(new TextComponent(aqua + "Attacks: " + green + "slowness 2, lifesteal 3 and poison 1"));
				tooltip.add(new TextComponent(aqua + "Right click: " + green + "speed 1, jump boost 2, strength 1, resistance 1 and fire resistance"));
			} else if(checkMS(stack) == 7) {
				tooltip.add(new TextComponent(aqua + "Attacks: " + green + "slowness 2, lifesteal 3, poison 2 and wither 2"));
				tooltip.add(new TextComponent(aqua + "Right click: " + green + "speed 1, jump boost 2, strength 1, resistance 1 and fire resistance"));
			} else if(checkMS(stack) == 8) {
				tooltip.add(new TextComponent(aqua + "Attacks: " + green + "slowness 2, lifesteal 3, poison 2 and wither 2"));
				tooltip.add(new TextComponent(aqua + "Right click: " + green + "speed 3, jump boost 2, strength 3, resistance 1 and fire resistance"));
			} else if(checkMS(stack) == 9) {
				tooltip.add(new TextComponent(aqua + "Attacks: " + green + "slowness 2, lifesteal 4, poison 2 and wither 2"));
				tooltip.add(new TextComponent(aqua + "Right click: " + green + "speed 3, jump boost 2, strength 3, resistance 2, fire resistance and haste 1"));
			} else if(checkMS(stack) == 10) {
				tooltip.add(new TextComponent(aqua + "Attacks: " + green + "slowness 2, lifesteal 5, poison 3, wither 2 and fire aspect"));
				tooltip.add(new TextComponent(aqua + "Holding sword: " + green + "speed 3, jump boost 2, strength 3, resistance 2, fire resistance and haste 1"));
			}
		} else {
			tooltip.add(new TextComponent(white + "Hold " + purple + "SHIFT" + white + " for more information"));
			tooltip.add(new TextComponent(white + "Hold " + purple + "CTRL" + white + " to see all current buffs"));
		}
		super.appendHoverText(stack, world, tooltip, flagIn);
	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		if(checkMS(stack) >= 2 && checkMS(stack) < 4) return Rarities.GREEN;
		else if(checkMS(stack) >= 4 && checkMS(stack) < 7) return Rarities.BLUE;
		else if(checkMS(stack) >= 7 && checkMS(stack) < 10) return Rarities.PURPLE;
		else if(checkMS(stack) == 10) return Rarities.GOLD;
		return Rarity.COMMON;
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return (checkMS(stack) == 10);
	}
}
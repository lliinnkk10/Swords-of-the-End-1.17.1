package com.github.atheera.swordsoftheend.objects.items;

import com.github.atheera.swordsoftheend.client.gui.LightsaberContainer;
import com.github.atheera.swordsoftheend.materials.Rarities;
import com.github.atheera.swordsoftheend.utils.KeyboardHelper;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.List;

public class ItemSwordSaber extends ItemSword {

    public String TAGACTIVE = "active";
    public boolean active;

    public String TAGCOLOR = "color";
    public String[] colors = new String[] { "red", "green", "blue", "purple", "black" };

    public String TAGENERGY = "energy";
    public int energy;

    public String TAGTICK = "tick";
    public int tick;

    public String TAGADDED = "added";
    public boolean added;

    public ItemSwordSaber(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int time, boolean held) {
        CompoundTag nbt = stack.getOrCreateTag();
        if(!nbt.getBoolean(this.TAGADDED)) {
            this.active = nbt.getBoolean(this.TAGACTIVE);
            nbt.putBoolean(this.TAGACTIVE, false);
            nbt.putString(this.TAGCOLOR, colors[0]);
            this.energy = nbt.getInt(this.TAGENERGY);
            nbt.putInt(this.TAGENERGY, 0);
            this.tick = nbt.getInt(this.TAGTICK);
            nbt.putInt(this.TAGTICK, 0);
            this.added = nbt.getBoolean(this.TAGADDED);
            nbt.putBoolean(this.TAGADDED, true);
        }

        boolean act = nbt.getBoolean(this.TAGACTIVE);
        if(!act) return;

        Player player = (Player)entity;
        if(player.isUnderWater()) {
            nbt.putBoolean(this.TAGACTIVE, false);
            return;
        }

        int nrg = nbt.getInt(this.TAGENERGY);
        int tick = nbt.getInt(this.TAGTICK);

        if(nrg >= 1) {
            nbt.putInt(this.TAGTICK, tick + 1);
            if(tick == 20) {
                nbt.putInt(this.TAGTICK, 0);
                nbt.putInt(this.TAGENERGY, nrg - 1);
            }
        } else {
            nbt.putInt(this.TAGENERGY, 0);
            nbt.putBoolean(this.TAGACTIVE, false);
            stack.getEnchantmentTags().clear();
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getMainHandItem();
        CompoundTag nbt = stack.getOrCreateTag();
        String clr = nbt.getString(this.TAGCOLOR);
        boolean act = nbt.getBoolean(this.TAGACTIVE);

        if(player.isShiftKeyDown()) {
            /*if(!world.isClientSide) {
                MenuProvider container = new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return new TextComponent("Lightsaber Inventory");
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int windowId, Inventory playerInv, Player player) {
                        return new LightsaberContainer(windowId, world, playerInv, player);
                    }
                };
                NetworkHooks.openGui((ServerPlayer) player, container);
            } else {
                throw new IllegalStateException("Our named container provider is missing!");
            }*/
            nbt.putInt(this.TAGENERGY, nbt.getInt(this.TAGENERGY) + 50);
            switch(clr) {
                case "red" -> nbt.putString(this.TAGCOLOR, colors[1]);
                case "green" -> nbt.putString(this.TAGCOLOR, colors[2]);
                case "blue" -> nbt.putString(this.TAGCOLOR, colors[3]);
                case "purple" -> nbt.putString(this.TAGCOLOR, colors[4]);
                case "black" -> nbt.putString(this.TAGCOLOR, colors[0]);
            }
        } else {
            player.getCooldowns().addCooldown(this, sec);
            if(act) {
                nbt.putBoolean(this.TAGACTIVE, false);
                stack.getEnchantmentTags().clear();
            } else {
                nbt.putBoolean(this.TAGACTIVE, true);
            }
        }
        return InteractionResultHolder.success(stack);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = HashMultimap.create();
        CompoundTag nbt = stack.getOrCreateTag();

        if(slot == EquipmentSlot.MAINHAND) {
            if(nbt.getBoolean(this.TAGACTIVE)) {
                map.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.4f, AttributeModifier.Operation.ADDITION));
                map.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 14, AttributeModifier.Operation.ADDITION));
            } else {
                map.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.4f, AttributeModifier.Operation.ADDITION));
                map.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", -Integer.MAX_VALUE, AttributeModifier.Operation.ADDITION));
            }
        }

        return map;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        CompoundTag nbt = stack.getOrCreateTag();
        boolean act = nbt.getBoolean(this.TAGACTIVE);
        if(!act) return false;

        String clr = nbt.getString(this.TAGCOLOR);
        Player player = (Player)attacker;
        Mob mob = (Mob)target;

        switch(clr) {
            case "red" -> {
                mob.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, sec*10, 1));
                mob.setSecondsOnFire(10);
            }
            case "green" -> {
                player.heal(2.5f);
            }
            case "blue" -> {
                mob.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sec*15, Integer.MAX_VALUE));
            }
            case "purple" -> {
                mob.addEffect(new MobEffectInstance(MobEffects.POISON, sec*8, 2));
                mob.addEffect(new MobEffectInstance(MobEffects.WITHER, sec*8, 2));
            }
            case "black" -> {
                mob.addEffect(new MobEffectInstance(MobEffects.HARM, 4));
            }
        };

        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flagIn) {
        ChatFormatting aqua = ChatFormatting.AQUA;
        ChatFormatting purple = ChatFormatting.LIGHT_PURPLE;
        ChatFormatting white = ChatFormatting.WHITE;
        CompoundTag nbt = stack.getOrCreateTag();
        int nrg = nbt.getInt(this.TAGENERGY);
        String clr = nbt.getString(this.TAGCOLOR);
        boolean act = nbt.getBoolean(this.TAGACTIVE);

        tooltip.add(new TextComponent(white + "Energy remaining: " + aqua + nrg));
        tooltip.add(new TextComponent(white + "Current source: " + aqua + clr));
        tooltip.add(new TextComponent(white + "Active: " + aqua + act));
        if(KeyboardHelper.isHoldingShift()) {
            tooltip.add(new TextComponent(white + "Shift+rightclick to change color and add energy"));
            tooltip.add(new TextComponent(white + "Rightclick to with/draw the saber"));
        } else {
            tooltip.add(new TextComponent(white + "Hold " + purple + "SHIFT" + white + " for more information"));
        }
        super.appendHoverText(stack, world, tooltip, flagIn);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return switch(stack.getOrCreateTag().getString(this.TAGCOLOR)) {
            case "green" -> Rarities.GREEN;
            case "blue" -> Rarities.BLUE;
            case "purple" -> Rarities.PURPLE;
            case "black" -> Rarities.BLACK;
            default -> Rarities.RED;
        };
    }

    @Override public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) { return false; }
    @Override public boolean isDamageable(ItemStack stack) { return false; }
    @Override public boolean isFoil(ItemStack stack) { return stack.getOrCreateTag().getBoolean(this.TAGACTIVE); }
}
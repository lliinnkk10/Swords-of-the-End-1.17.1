package com.github.atheera.swordsoftheend.objects.items;

import com.github.atheera.swordsoftheend.utils.KeyboardHelper;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemSwordMaster extends ItemSword {

    //NBT tags
    public String tagCharged = "charged";
    public boolean charged;

    public String tagDragon = "dragon";
    public boolean dragon;
    public String tagDragonLvl = "dragonLvl";
    public int dragonLvl;

    public String tagWither = "wither";
    public boolean wither;
    public String tagWitherLvl = "witherLvl";
    public int witherLvl;

    public String tagDurability = "durability";
    public int durability;

    public String tagLevel = "level";
    public int level;

    public String tagCharges = "charges";
    public int charges;

    public String tagTimer = "timer";
    public int timer;

    public String tagCounter = "count";
    public int counter;

    //Local variables
    private final int cooldown = 200;
    private final int milestone1 = 10;
    private final int milestone2 = 20;
    private final int milestone3 = 30;

    public ItemSwordMaster(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flagIn) {

        CompoundTag nbt = stack.getOrCreateTag();
        int taglevel = nbt.getInt(tagLevel);
        int tagtimer = nbt.getInt(tagTimer);
        boolean tagdragon = nbt.getBoolean(tagDragon);
        boolean tagwither = nbt.getBoolean(tagWither);
        boolean tagcharged = nbt.getBoolean(tagCharged);
        ChatFormatting white = ChatFormatting.WHITE;
        ChatFormatting purple = ChatFormatting.LIGHT_PURPLE;
        if(KeyboardHelper.isHoldingCtrl()) { //Adds info of how to level up the sword if CTRL is held down while hovering

            if(checkMS(stack) == 0) { //Less than milestone 1
                tooltip.add(new TextComponent(white + "The sword requires " + purple + (milestone1 - taglevel) + white + " kills to get the next upgrade."));

            } else if(checkMS(stack) == 1) { //Or more than milestone 2 but not killed the boss
                int remaining = milestone2 - taglevel;
                String text = ("The sword requires " + purple + remaining + white + " kills to get the next upgrade.");
                if(remaining <= 0) { text = ("You have enough kills for the upgrade but haven't killed the " + purple + "boss" + white + "."); }
                tooltip.add(new TextComponent(white + text));
                tooltip.add(new TextComponent(white + "The sword also requires the soul of the" + purple + " Wither" + white + " boss to evolve further."));
                tooltip.add(new TextComponent(white + "Soul collected: " + purple + tagwither));

            } else if(checkMS(stack) == 2) { //Or more than milestone 3 but not killed the boss
                int remaining = milestone3 - taglevel;
                String text = ("The sword requires " + purple + remaining + " kills to get the next upgrade.");
                if(remaining <= 0) { text = ("You have enough kills for the upgrade but haven't killed the " + purple + "boss" + white + "."); }
                tooltip.add(new TextComponent(white + text));
                tooltip.add(new TextComponent(white + "The sword also requires the soul of the " + purple + "Ender Dragon" + white + " to evolve further."));
                tooltip.add(new TextComponent(white + "Soul collected: " + purple + tagdragon));

            } else if(checkMS(stack) == 3) { //More than milestone 3
                tooltip.add(new TextComponent(white + "The sword has been fully upgraded and is at it's greatest power!"));

                //Error message
            } else { tooltip.add(new TextComponent(ChatFormatting.RED + "Something went horribly wrong!")); }

        } else if (KeyboardHelper.isHoldingShift()) { //Adds description from the game to the item if SHIFT is held down while hovering
            tooltip.add(new TextComponent(white + "The legendary sword that seals the darkness."));
            tooltip.add(new TextComponent(white + "Its blade gleams with a sacred luster that can oppose the Calamity."));
            tooltip.add(new TextComponent(white + "Only a hero chosen by the sword itself may wield it."));

        } else { //Regular info displayed when not holding SHIFT or CTRL
            if (!tagcharged) { tooltip.add(new TextComponent(ChatFormatting.RED + "Sword is broken! Time until repaired: " + (cooldown - tagtimer)));
                if (tagtimer >= cooldown && !tagcharged) { tooltip.remove(1); }
            }
            tooltip.add(new TextComponent(white + "Durability remaining: " + (nbt.getInt(tagDurability))));
            tooltip.add(new TextComponent(white + "Current level: " + taglevel));
            tooltip.add(new TextComponent(white + "Current " + purple + nbt.getInt(tagWitherLvl) + white + " withers slain"));
            tooltip.add(new TextComponent(white + "Current " + purple + nbt.getInt(tagDragonLvl) + white + " dragons slain"));
            tooltip.add(new TextComponent(white + "Slash charges remaining: " + nbt.getInt(tagCharges)));
            tooltip.add(new TextComponent(white + "Hold " + purple + "SHIFT" + white + " for description."));
            tooltip.add(new TextComponent(white + "Hold " + purple + "CTRL" + white + " for more information."));
        }

        super.appendHoverText(stack, world, tooltip, flagIn);
    }

    @Override
    public void inventoryTick(ItemStack stack, @Nonnull Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {
        CompoundTag nbt = stack.getOrCreateTag();
        int tagtimer = nbt.getInt(tagTimer);

        if(!nbt.getBoolean(tagCharged)) {
            nbt.putInt(tagTimer, tagtimer + 1);
        }
        if(!(tagtimer >= cooldown)) {
            super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
            return;
        }
        nbt.putInt(tagTimer, tagtimer = 0);
        if(checkMS(stack) == 0) { //Does V if first upgrade milestone not reached
            setNBT(nbt, stack, 19);

        } else if(checkMS(stack) == 1) { //Does V if first upgrade milestone is reached
            setNBT(nbt, stack, 19);

        } else if(checkMS(stack) == 2) { //Does V if second upgrade milestone is reached
            setNBT(nbt, stack, 29);

        } else if(checkMS(stack) == 3) { //Does V if third upgrade milestone is reached
            setNBT(nbt, stack, 39);
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    public enum EMobType {
        WITHER,
        DRAGON,
        REGULAR
    }

    //Method called in LevelupSwordsEvent to level up the sword as well as give it charges per 10 kills
    public void levelUp(ItemStack stack, EMobType type) {
        CompoundTag nbt = stack.getOrCreateTag();
        this.level = nbt.getInt(tagLevel);
        int counter = nbt.getInt(tagCounter);
        switch (type) {
            case DRAGON -> {
                nbt.putInt(tagLevel, level + 25);
                nbt.putBoolean(tagDragon, true);
                nbt.putInt(this.tagDragonLvl, nbt.getInt(tagDragonLvl) + 1);
            }
            case WITHER -> {
                nbt.putInt(tagLevel, level + 10);
                nbt.putBoolean(tagWither, true);
                nbt.putInt(this.tagWitherLvl, nbt.getInt(tagWitherLvl) + 1);
            }
            case REGULAR -> {
                nbt.putInt(tagLevel, level + 1);
            }
        }
        nbt.putInt(tagCounter, counter + 1);
        if (counter == 10) {
            nbt.putInt(tagCharges, nbt.getInt(tagCharges) + 1);
            nbt.putInt(tagCounter, counter = 0);
        }
    }

    private void setNBT(CompoundTag nbt, ItemStack stack, int durability) {
        nbt.putInt(tagDurability, durability);
        nbt.putBoolean(tagCharged, true);
        this.durability = durability;
        this.charged = true;
    }

    public int checkMS(ItemStack stack) {
        CompoundTag nbt = stack.getOrCreateTag();
        int lvl = nbt.getInt(this.tagLevel);
        boolean wthr = nbt.getBoolean(this.tagWither);
        boolean drgn = nbt.getBoolean(this.tagDragon);

        if(lvl >= milestone3 && wthr && drgn) return 3;
        else if(((lvl >= milestone2 && lvl < milestone3) && wthr) || ((lvl > milestone3 && (!drgn && wthr)))) return 2;
        else if(((lvl >= milestone1 && lvl < milestone2) && !wthr) || ((lvl > milestone2) && (!drgn && !wthr))) return 1;
        else if(lvl < milestone1) return 0;
        return 0;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        CompoundTag nbt = stack.getOrCreateTag();
        int taglevel = nbt.getInt(tagLevel);
        boolean tagwither = nbt.getBoolean(tagWither);
        boolean tagdragon = nbt.getBoolean(tagDragon);
        Multimap<Attribute, AttributeModifier> multimap = HashMultimap.create();

        if(slot == EquipmentSlot.MAINHAND) {
            if(nbt.getBoolean(tagCharged)) {
                if(taglevel < milestone1) {
                    multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier",(double)9, AttributeModifier.Operation.ADDITION ));
                } else if((taglevel >= milestone1 && taglevel < milestone2 && !tagwither) ||
                        (taglevel >= milestone1 && !tagwither)) {
                    multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier",(double)19, AttributeModifier.Operation.ADDITION ));
                } else if(((taglevel >= milestone2 && taglevel < milestone3) && tagwither) ||
                        ((taglevel >= milestone2 && tagwither) && !tagdragon)) {
                    multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier",(double)29, AttributeModifier.Operation.ADDITION ));
                } else if(taglevel >= milestone3 && tagdragon && tagwither) {
                    multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier",(double)39, AttributeModifier.Operation.ADDITION ));
                }
            } else {
                multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier",(double)-Integer.MAX_VALUE, AttributeModifier.Operation.ADDITION ));
            }
        }
        return multimap;
    }

    public void damageItem(ItemStack stack) {
        CompoundTag nbt = stack.getOrCreateTag();
        boolean tagcharged = nbt.getBoolean(tagCharged);
        int tagdurability = nbt.getInt(tagDurability);
        if (!tagcharged) {
            return;
        }
        if (!nbt.contains(tagDurability)) {
            return;
        }
        if (tagdurability >= 1) {
            nbt.putInt(tagDurability, tagdurability - 1);
        } else {
            this.charged = tagcharged;
            nbt.putBoolean(tagCharged, false);
            this.durability = tagdurability;
            nbt.putInt(tagDurability, 0);
            stack.getEnchantmentTags().clear();
        }
    }

    //Making the sword not enchantable and unbreakable, also giving it enchantment effect when it is not broken
    @Override public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) { return false; }
    @Override public boolean isEnchantable(ItemStack stack) { return false; }
    @Override public boolean isBookEnchantable(ItemStack stack, ItemStack book) { return false; }
    @Override public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) { return false; }
    @Override public boolean isDamageable(ItemStack stack) { return false; }
    @Override public boolean isFoil(ItemStack stack) { return stack.getOrCreateTag().getBoolean(tagCharged); }

}
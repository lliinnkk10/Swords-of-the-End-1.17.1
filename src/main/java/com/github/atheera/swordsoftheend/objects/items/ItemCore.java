package com.github.atheera.swordsoftheend.objects.items;

import com.github.atheera.swordsoftheend.inits.CreativeTabInit;
import com.github.atheera.swordsoftheend.inits.ItemInit;
import com.github.atheera.swordsoftheend.materials.Rarities;
import com.github.atheera.swordsoftheend.utils.KeyboardHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemCore extends Item {
    public ItemCore() {
        super(new Item.Properties().tab(CreativeTabInit.SOTE_I_CMT).rarity(Rarities.PURPLE));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flagIn) {
        Item item = stack.getItem();
        ChatFormatting aqua = ChatFormatting.AQUA;
        if(KeyboardHelper.isHoldingShift()) {

            if(item == ItemInit.ITEM_CORE_AMETHYST.get()) tooltip.add(new TextComponent(aqua + "Combine this item with the Base Sword to get Vampirical Blade"));
            if(item == ItemInit.ITEM_CORE_BASE.get()) tooltip.add(new TextComponent(aqua + "This item requires ingredients to charge the abilities for the swords"));
            if(item == ItemInit.ITEM_CORE_DIAMOND.get()) tooltip.add(new TextComponent(aqua + "Combine this item with the Base Sword to get YEEEEEEETCANNON!!!"));
            if(item == ItemInit.ITEM_CORE_EMERALD.get()) tooltip.add(new TextComponent(aqua + "Combine this item with the Base Sword to get Death"));
            if(item == ItemInit.ITEM_CORE_END.get()) tooltip.add(new TextComponent(aqua + "Combine this item with the Base Sword to get Ender Ender"));
            if(item == ItemInit.ITEM_CORE_LEVEL.get()) tooltip.add(new TextComponent(aqua + "Combine this item with the Base Sword to get Soul's Edge"));
            if(item == ItemInit.ITEM_CORE_LUMIN.get()) tooltip.add(new TextComponent(aqua + "Combine this item with the Base Sword to get Sting"));
            //if(item == ItemInit.ITEM_CORE_SABER.get()) tooltip.add(new TextComponent(aqua + "Combine this item with the Base Sword to get Lightsaber Hilt"));
            if(item == ItemInit.ITEM_CORE_RUBY.get()) tooltip.add(new TextComponent(aqua + "Combine this item with the Base Sword to get Hellsbane"));
            if(item == ItemInit.ITEM_CORE_SAPPHIRE.get()) tooltip.add(new TextComponent(aqua + "Combine this item with the Base Sword to get Everfrost"));
            if(item == ItemInit.ITEM_CORE_THUNDER.get()) tooltip.add(new TextComponent(aqua + "Combine this item with the Base Sword to get Berserker's Fury"));
            if(item == ItemInit.ITEM_CORE_ULTIMATE.get()) tooltip.add(new TextComponent(aqua + "Combine this item with the Base Sword to get Cthulhu's End"));
            //if(item == ItemInit.ITEM_CORE_SHADITE.get()) tooltip.add(new TextComponent(aqua + "Combine this item with the Base Sword to get Ethereal Blade"));
            if(item == ItemInit.ITEM_CORE_MASTER.get()) tooltip.add(new TextComponent(aqua + "Combine this item with the Base SWord to get Master Sword"));

        } else {
            tooltip.add(new TextComponent(ChatFormatting.WHITE + "Hold " + ChatFormatting.LIGHT_PURPLE + "SHIFT" + ChatFormatting.WHITE + " for description"));
        }
        super.appendHoverText(stack, world, tooltip, flagIn);
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }
}
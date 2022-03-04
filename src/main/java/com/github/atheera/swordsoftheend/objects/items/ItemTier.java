package com.github.atheera.swordsoftheend.objects.items;

import com.github.atheera.swordsoftheend.inits.ItemInit;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import net.minecraft.world.item.Item.Properties;

public class ItemTier extends Item {
    public ItemTier(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {

        Item item = stack.getItem();

        if(item == ItemInit.ITEM_TIER_THUNDER.get()) list.add(new TextComponent(ChatFormatting.AQUA + "This item is created when lightning strikes a blaze rod"));
        if(item == ItemInit.ITEM_TIER_AMETHYST.get()) list.add(new TextComponent(ChatFormatting.AQUA + "This item is dropped by bats"));
        if(item == ItemInit.ITEM_TIER_SHADITE.get()) list.add(new TextComponent(ChatFormatting.AQUA + "This item is dropped by Wither Skeletons"));

        super.appendHoverText(stack, level, list, flag);
    }
}

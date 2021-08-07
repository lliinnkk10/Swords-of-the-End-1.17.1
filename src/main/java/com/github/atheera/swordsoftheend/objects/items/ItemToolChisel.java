package com.github.atheera.swordsoftheend.objects.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.item.Item.Properties;

public class ItemToolChisel extends Item {

    public ItemToolChisel(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 50;
    }

    @Override
    public boolean canHarvestBlock(ItemStack stack, BlockState state) {



        return super.canHarvestBlock(stack, state);
    }


}
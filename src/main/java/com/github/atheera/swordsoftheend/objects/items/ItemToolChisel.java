package com.github.atheera.swordsoftheend.objects.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ItemToolChisel extends PickaxeItem {


    public ItemToolChisel(Tier tier, int damage, float speed, Properties prop) {
        super(tier, damage, speed, prop);
    }



}
package com.github.atheera.swordsoftheend.objects.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.item.Item.Properties;

public class BlockItemEnchanted extends BlockItem {
    public BlockItemEnchanted(Block p_40565_, Properties p_40566_) {
        super(p_40565_, p_40566_);
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }
}

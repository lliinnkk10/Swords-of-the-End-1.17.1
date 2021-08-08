package com.github.atheera.swordsoftheend.objects.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FireChargeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemMagmaball extends FireChargeItem {
    public ItemMagmaball(Properties p_41202_) {
        super(p_41202_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {

        return super.use(p_41432_, p_41433_, p_41434_);
    }
}

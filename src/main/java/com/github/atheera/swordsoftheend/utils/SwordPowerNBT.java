package com.github.atheera.swordsoftheend.utils;

import com.github.atheera.swordsoftheend.objects.items.ItemSwordLevel;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class SwordPowerNBT implements ItemPropertyFunction {
    @Override
    public float call(ItemStack stack, @Nullable ClientLevel worldIn, @Nullable LivingEntity entity, int num) {
        float MS0 = 0.0f;
        float MS1 = 0.25f;
        float MS2 = 0.5f;
        float MS3 = 0.75f;
        float MS4 = 1.0f;
        Item item = stack.getItem();
        int check = ((ItemSwordLevel)item).checkMS(stack);
        if(stack.hasTag()) {
            if(check < 2) return MS0;
            else if(check < 4) return MS1;
            else if(check < 7) return MS2;
            else if(check < 10) return MS3;
            else if(check == 10) return MS4;
        } else {
            return MS0;
        }
        return MS0;
    }
}

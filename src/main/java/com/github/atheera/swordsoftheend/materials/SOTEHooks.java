package com.github.atheera.swordsoftheend.materials;

import com.github.atheera.swordsoftheend.inits.BlockInit;
import com.github.atheera.swordsoftheend.inits.ItemInit;
import com.github.atheera.swordsoftheend.objects.items.ItemCrystal;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SOTEHooks {

    public static boolean getInfuser(ItemStack stack) {
        if(stack.isEmpty()) {
            return false;
        }
        return stack == BlockInit.ITEM_BLOCK_MAGIC.get().getDefaultInstance() ||
               stack == BlockInit.ITEM_BLOCK_ORE_MAGIC.get().getDefaultInstance() ||
               stack == BlockInit.ITEM_BLOCK_ORE_DEEP_MAGIC.get().getDefaultInstance() ||
               stack == ItemInit.ITEM_DUST_MAGIC_E.get().getDefaultInstance();
    }

    public static int getInfuserBurnTime(ItemStack stack) {
        if(stack.isEmpty()) {
            return 0;
        } else {
            Item item = stack.getItem();
            if (item == BlockInit.ITEM_BLOCK_MAGIC.get()) return 45;
            if (item == BlockInit.ITEM_BLOCK_ORE_MAGIC.get()) return 15;
            if (item == BlockInit.ITEM_BLOCK_ORE_DEEP_MAGIC.get()) return 15;
            if (item == ItemInit.ITEM_DUST_MAGIC_E.get()) return 5;
        }
        return 0;
    }

    public static boolean lsCrystalValid(ItemStack stack) {
        if(stack.isEmpty()) {
            return false;
        } else {
            Item item = stack.getItem();
            if (item instanceof ItemCrystal) {
                return true;
            }
        }
        return false;
    }

}
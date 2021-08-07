package com.github.atheera.swordsoftheend.events;

import com.github.atheera.swordsoftheend.inits.BlockInit;
import com.github.atheera.swordsoftheend.inits.ItemInit;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.event.brewing.PotionBrewEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.github.atheera.swordsoftheend.SOTE.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PotionEvent {

    @SubscribeEvent
    public static void potionBrewed(PotionBrewEvent e) {

        ItemStack strpot = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRONG_STRENGTH);

        if((e.getItem(3) == BlockInit.ITEM_BLOCK_SMELT_GOLD_E.get().getDefaultInstance())) {
            for(int i = 0; i < 3; i++) {
                if(e.getItem(i) == strpot) {
                   // e.setResult();
                }
            }
        }

        for (int i = 0; i < e.getLength(); i++) {
            System.out.println(e.getItem(i) + " " + e.getItem(i).getOrCreateTag() + " slot " + i);
        }
    }

}

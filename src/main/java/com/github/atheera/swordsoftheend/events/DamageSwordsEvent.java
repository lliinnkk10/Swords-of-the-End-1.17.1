package com.github.atheera.swordsoftheend.events;

import com.github.atheera.swordsoftheend.objects.items.ItemSwordMaster;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.github.atheera.swordsoftheend.SOTE.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DamageSwordsEvent {

    @SubscribeEvent
    public static void damageItem(LivingHurtEvent event) {
        DamageSource source = event.getSource();

        if(source.getEntity() instanceof Player player) {

            ItemStack stack = player.getMainHandItem();
            Item item = stack.getItem();

            if(item instanceof ItemSwordMaster ism) {

                ism.damageItem(stack);

            }

        }

    }

}

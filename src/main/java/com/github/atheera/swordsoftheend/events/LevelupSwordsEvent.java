package com.github.atheera.swordsoftheend.events;

import com.github.atheera.swordsoftheend.objects.items.ItemSwordLevel;
import com.github.atheera.swordsoftheend.objects.items.ItemSwordMaster;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.github.atheera.swordsoftheend.SOTE.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LevelupSwordsEvent {

    @SubscribeEvent
    public static void levelupEvent(LivingDeathEvent event) {

        DamageSource source = event.getSource();
        Entity entity = event.getEntity();

        if(source.getEntity() instanceof Player player) {
            ItemStack stack = player.getMainHandItem();
            Item sword = stack.getItem();

            if(sword instanceof ItemSwordLevel isl) {
                if (entity instanceof WitherBoss) isl.levelUp(stack, ItemSwordLevel.EMobType.WITHER);
                else if (entity instanceof EnderDragon) isl.levelUp(stack, ItemSwordLevel.EMobType.DRAGON);
                else isl.levelUp(stack, ItemSwordLevel.EMobType.REGULAR);
            }

            if(sword instanceof ItemSwordMaster ism) {
                if (entity instanceof WitherBoss) ism.levelUp(stack, ItemSwordMaster.EMobType.WITHER);
                else if (entity instanceof EnderDragon) ism.levelUp(stack, ItemSwordMaster.EMobType.DRAGON);
                else ism.levelUp(stack, ItemSwordMaster.EMobType.REGULAR);
            }

        }

    }

}

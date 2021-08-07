package com.github.atheera.swordsoftheend.events;

import com.github.atheera.swordsoftheend.inits.ItemInit;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.github.atheera.swordsoftheend.SOTE.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ThunderConvertEvent {

    @SubscribeEvent
    public static void itemStruck(EntityStruckByLightningEvent event) {

        if(event.getEntity() instanceof ItemEntity itemEntity) {

            Entity entity = event.getEntity();
            Level world = entity.level;
            LightningBolt bolt = event.getLightning();
            int x = bolt.getBlockX();
            int y = bolt.getBlockY();
            int z = bolt.getBlockZ();
            Item item = itemEntity.getItem().getItem();

            if(item == Items.BLAZE_ROD || item == ItemInit.ITEM_TIER_THUNDER.get()) {
                ItemEntity newItem = new ItemEntity(world, x, y, z, ItemInit.ITEM_TIER_THUNDER.get().getDefaultInstance());
                world.addFreshEntity(newItem);
            }
        }
    }
}
package com.github.atheera.swordsoftheend.events;

import com.github.atheera.swordsoftheend.SOTE;
import com.github.atheera.swordsoftheend.entities.living.ShadeEntity;
import com.github.atheera.swordsoftheend.inits.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SOTE.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {

        event.put(EntityInit.SHADE_ENTITY.get(), ShadeEntity.createAttributes().build());

    }

}

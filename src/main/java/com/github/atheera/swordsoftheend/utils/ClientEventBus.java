package com.github.atheera.swordsoftheend.utils;

import com.github.atheera.swordsoftheend.inits.ItemInit;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

import static com.github.atheera.swordsoftheend.SOTE.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ClientEventBus {

    public static void registerPropertyOverride() {
        ItemProperties.register(ItemInit.ITEM_SWORD_LEVEL.get(), new ResourceLocation(MOD_ID, "level"), new SwordPowerNBT());
    }

}

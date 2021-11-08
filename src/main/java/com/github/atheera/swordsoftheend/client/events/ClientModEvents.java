package com.github.atheera.swordsoftheend.client.events;

import com.github.atheera.swordsoftheend.SOTE;
import com.github.atheera.swordsoftheend.client.renderer.ShadeEntityRenderer;
import com.github.atheera.swordsoftheend.client.renderer.model.ShadeEntityModel;
import com.github.atheera.swordsoftheend.inits.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SOTE.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ShadeEntityModel.LAYER_LOCATION, ShadeEntityModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.SHADE_ENTITY.get(), ShadeEntityRenderer::new);
    }

}

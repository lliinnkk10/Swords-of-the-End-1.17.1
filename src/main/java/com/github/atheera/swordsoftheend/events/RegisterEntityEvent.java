package com.github.atheera.swordsoftheend.events;

import com.github.atheera.swordsoftheend.SOTE;
import com.github.atheera.swordsoftheend.entities.MagmaballEntity;
import com.github.atheera.swordsoftheend.entities.render.MagmaballEntityRender;
import com.github.atheera.swordsoftheend.inits.EntityInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.github.atheera.swordsoftheend.SOTE.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RegisterEntityEvent {

    @SubscribeEvent
    public static void registerEntity(RegistryEvent.Register<EntityType<?>> event) {

        event.getRegistry().register(EntityType.Builder.<MagmaballEntity>of
                (MagmaballEntity::new, MobCategory.MISC).build("magmaball_entity").setRegistryName("magmaball_entity"));
        System.out.println("registered");

        event.getRegistry().register(EntityInit.MAGMABALL.get());

        event.getRegistry().getValue(new ResourceLocation("magmaball_entity"));

    }

    @SubscribeEvent
    public static void renderEntity(EntityRenderersEvent.RegisterRenderers event) {
        System.out.println("should render");
        event.registerEntityRenderer(EntityInit.MAGMABALL.get(), MagmaballEntityRender::new);
        //event.registerEntityRenderer(EntityInit.MAGMABALL.get(), MagmaballEntity::new);

    }

}
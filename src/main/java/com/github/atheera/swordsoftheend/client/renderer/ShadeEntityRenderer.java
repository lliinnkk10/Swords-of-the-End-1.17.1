package com.github.atheera.swordsoftheend.client.renderer;

import com.github.atheera.swordsoftheend.SOTE;
import com.github.atheera.swordsoftheend.client.renderer.model.ShadeEntityModel;
import com.github.atheera.swordsoftheend.entities.living.ShadeEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;

public class ShadeEntityRenderer<Type extends ShadeEntity> extends MobRenderer<Type, EntityModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(SOTE.MOD_ID, "textures/entities/shade_entity.png");

    public ShadeEntityRenderer(EntityRendererProvider.Context provider) {
        super(provider, new ShadeEntityModel<>(provider.bakeLayer(ShadeEntityModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(ShadeEntity entity) {
        return TEXTURE;
    }
}

package com.github.atheera.swordsoftheend.entities.render;

import com.github.atheera.swordsoftheend.SOTE;
import com.github.atheera.swordsoftheend.entities.MagmaballEntity;
import com.github.atheera.swordsoftheend.entities.thrown.ModThrownMagmaball;
import com.github.atheera.swordsoftheend.inits.EntityInit;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class MagmaballEntityRender extends ThrownItemRenderer<MagmaballEntity> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(SOTE.MOD_ID, "textures/items/item_tier_ruby.png");

    public MagmaballEntityRender(EntityRendererProvider.Context render) {
        super(render);
    }

    @Override
    public void render(MagmaballEntity p_116085_, float p_116086_, float p_116087_, PoseStack p_116088_, MultiBufferSource p_116089_, int p_116090_) {
        super.render(p_116085_, p_116086_, p_116087_, p_116088_, p_116089_, p_116090_);
    }

    @Override
    public boolean shouldRender(MagmaballEntity p_114491_, Frustum p_114492_, double p_114493_, double p_114494_, double p_114495_) {
        return true;
    }


}

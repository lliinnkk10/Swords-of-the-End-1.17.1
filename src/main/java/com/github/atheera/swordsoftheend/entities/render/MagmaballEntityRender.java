package com.github.atheera.swordsoftheend.entities.render;

import com.github.atheera.swordsoftheend.entities.MagmaballEntity;
import com.github.atheera.swordsoftheend.entities.item.MagmaballItemEntity;
import com.github.atheera.swordsoftheend.inits.ItemInit;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.github.atheera.swordsoftheend.SOTE.MOD_ID;

@OnlyIn(Dist.CLIENT)
public class MagmaballEntityRender extends ThrownItemRenderer<MagmaballEntity> {

    public MagmaballEntityRender(EntityRendererProvider.Context p_174416_, float p_174417_, boolean p_174418_) {
        super(p_174416_, p_174417_, p_174418_);
    }

    public MagmaballEntityRender(EntityRendererProvider.Context p_174414_) {
        super(p_174414_);
    }
}

package com.github.atheera.swordsoftheend.entities.item;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

@OnlyIn(Dist.CLIENT)
public class MagmaballItemEntity extends ItemEntity {

    public MagmaballItemEntity(EntityType<? extends MagmaballItemEntity> p_31991_, Level p_31992_) {
        super(p_31991_, p_31992_);
    }

    public MagmaballItemEntity(Level p_32001_, double p_32002_, double p_32003_, double p_32004_, ItemStack p_32005_) {
        super(p_32001_, p_32002_, p_32003_, p_32004_, p_32005_);
    }

    public MagmaballItemEntity(Level p_149663_, double p_149664_, double p_149665_, double p_149666_, ItemStack p_149667_, double p_149668_, double p_149669_, double p_149670_) {
        super(p_149663_, p_149664_, p_149665_, p_149666_, p_149667_, p_149668_, p_149669_, p_149670_);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}

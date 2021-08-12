package com.github.atheera.swordsoftheend.utils;

import com.github.atheera.swordsoftheend.objects.items.ItemSwordSaber;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class LightsaberNBT implements ItemPropertyFunction {
    @Override
    public float call(ItemStack stack, @Nullable ClientLevel world, @Nullable LivingEntity entity, int num) {
        Item item = stack.getItem();

        float R1 = 0.0f, G1 = 0.2f, B1 = 0.4f, P1 = 0.6f, BL1 = 0.8f; // Retracted
        float R = 0.1f, G = 0.3f, B = 0.5f, P = 0.7f, BL = 0.9f; // Drawn

        CompoundTag nbt = stack.getOrCreateTag();
        String ACTIVE = ((ItemSwordSaber)item).TAGACTIVE;
        String[] colors = ((ItemSwordSaber)item).colors;
        String COLOR = ((ItemSwordSaber)item).TAGCOLOR;

        boolean act = nbt.getBoolean(ACTIVE);
        String clr = nbt.getString(COLOR);

        if(stack.hasTag()) {

            if(act) {
                switch (clr) {
                    case "red" -> {
                        nbt.putString(COLOR, colors[0]);
                        return R;
                    }
                    case "green" -> {
                        nbt.putString(COLOR, colors[1]);
                        return G;
                    }
                    case "blue" -> {
                        nbt.putString(COLOR, colors[2]);
                        return B;
                    }
                    case "purple" -> {
                        nbt.putString(COLOR, colors[3]);
                        return P;
                    }
                    case "black" -> {
                        nbt.putString(COLOR, colors[4]);
                        return BL;
                    }
                }
            } else {
                switch (clr) {
                    case "red" -> {
                        nbt.putString(COLOR, colors[0]);
                        return R1;
                    }
                    case "green" -> {
                        nbt.putString(COLOR, colors[1]);
                        return G1;
                    }
                    case "blue" -> {
                        nbt.putString(COLOR, colors[2]);
                        return B1;
                    }
                    case "purple" -> {
                        nbt.putString(COLOR, colors[3]);
                        return P1;
                    }
                    case "black" -> {
                        nbt.putString(COLOR, colors[4]);
                        return BL1;
                    }
                }
            }
        }
        return 0;
    }
}

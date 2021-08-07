package com.github.atheera.swordsoftheend.objects.items;

import com.github.atheera.swordsoftheend.utils.KeyboardHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

import net.minecraft.world.item.Item.Properties;

public class ItemSwordShadite extends ItemSword {
    public ItemSwordShadite(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flagIn) {
        if(KeyboardHelper.isHoldingShift()) {
            tooltip.add(new TextComponent(ChatFormatting.AQUA + "You can't kill what you can't see"));
            tooltip.add(new TextComponent(ChatFormatting.AQUA + "Shorter blade allows for rapid attacks but lower damage"));
            tooltip.add(new TextComponent(ChatFormatting.AQUA + "Rightclick to blend in with the shadows, dealing massive damage but moving slow"));
        } else {
            tooltip.add(new TextComponent(ChatFormatting.WHITE + "Hold " + ChatFormatting.LIGHT_PURPLE + "SHIFT" + ChatFormatting.WHITE + " for description"));
        }
        super.appendHoverText(stack, world, tooltip, flagIn);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sec*15, 1));
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, sec*15, 4));
        player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, sec*15));

        return super.use(world, player, hand);
    }
}
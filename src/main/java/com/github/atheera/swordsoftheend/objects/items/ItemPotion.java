package com.github.atheera.swordsoftheend.objects.items;

import com.github.atheera.swordsoftheend.inits.ItemInit;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;
import java.util.List;

public class ItemPotion extends Item {
    public ItemPotion(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public ItemStack getDefaultInstance() {
        return PotionUtils.setPotion(super.getDefaultInstance(), Potions.WATER);
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        Player player = entity instanceof Player ? (Player)entity : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
        }
        final int sec = 20;
        final int min = sec*60;
        Item item = stack.getItem();

        if (!level.isClientSide) {
            if(item == ItemInit.ITEM_POTION_DAMAGE.get()) player.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 4));
            if(item == ItemInit.ITEM_POTION_JUMP.get()) player.addEffect(new MobEffectInstance(MobEffects.JUMP, min*3, 4));
            if(item == ItemInit.ITEM_POTION_STRENGTH.get()) player.addEffect (new MobEffectInstance(MobEffects.DAMAGE_BOOST, min*3, 4));
            if(item == ItemInit.ITEM_POTION_POISON.get()) player.addEffect(new MobEffectInstance(MobEffects.POISON, min*3, 4));
            if(item == ItemInit.ITEM_POTION_SWIFTNESS.get()) player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, min*3, 4));
            if(item == ItemInit.ITEM_POTION_WATER.get()) player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, min*20));
            if(item == ItemInit.ITEM_POTION_SLOW.get()) player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, min*3, 4));
            if(item == ItemInit.ITEM_POTION_FALLING.get()) player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, min*10));
        }

        if (player == null || !player.getAbilities().instabuild) {
            if (stack.isEmpty()) {
                player.getInventory().getSelected().shrink(1);
                return new ItemStack(Items.GLASS_BOTTLE);
            }

            if (player != null) {
                player.getInventory().getSelected().shrink(1);
                player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
            }
        }

        level.gameEvent(entity, GameEvent.DRINKING_FINISH, entity.eyeBlockPosition());
        return stack;
    }

    public int getUseDuration(ItemStack stack) {
        return 32;
    }
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }


    public void appendHoverText(ItemStack stack, @Nullable Level p_42989_, List<Component> list, TooltipFlag flag) {
        Item item = stack.getItem();
        ChatFormatting blue = ChatFormatting.BLUE;
        ChatFormatting red = ChatFormatting.RED;
        ChatFormatting aqua = ChatFormatting.AQUA;

        if(item == ItemInit.ITEM_POTION_DAMAGE.get()) {
            list.add(new TextComponent(red + "Instant Damage 5"));
            list.add(new TextComponent(aqua + "Brew Strong Damage with Enchanted Block to get this item"));
        }
        if(item == ItemInit.ITEM_POTION_JUMP.get()) {
            list.add(new TextComponent(blue + "Jump Boost 5 (3:00)"));
            list.add(new TextComponent(aqua + "Brew Long Leaping with Enchanted Block to get this item"));
        }
        if(item == ItemInit.ITEM_POTION_STRENGTH.get()) {
            list.add(new TextComponent(blue + "Strength 5 (3:00)"));
            list.add(new TextComponent(aqua + "Brew Strong Strength with Enchanted Block to get this item"));
        }
        if(item == ItemInit.ITEM_POTION_POISON.get()) {
            list.add(new TextComponent(red + "Poison 5 (3:00)"));
            list.add(new TextComponent(aqua + "Brew Strong Poison with Enchanted Block to get this item"));
        }
        if(item == ItemInit.ITEM_POTION_SWIFTNESS.get()) {
            list.add(new TextComponent(blue + "Speed 5 (3:00)"));
            list.add(new TextComponent(aqua + "Brew Strong Swiftness with Enchanted Block to get this item"));
        }
        if(item == ItemInit.ITEM_POTION_WATER.get()) {
            list.add(new TextComponent(blue + "Water Breathing (20:00)"));
            list.add(new TextComponent(aqua + "Brew Long Water Breathing with Enchanted Block to get this item"));
        }
        if(item == ItemInit.ITEM_POTION_SLOW.get()) {
            list.add(new TextComponent(red + "Slowness 5 (3:00)"));
            list.add(new TextComponent(aqua + "Brew Strong Poison with Enchanted Block to get this item"));
        }
        if(item == ItemInit.ITEM_POTION_FALLING.get()) {
            list.add(new TextComponent(blue + "Slow Falling (10:00)"));
            list.add(new TextComponent(aqua + "Brew Long Slow Falling with Enchanted Block to get this item"));
        }

    }

    public boolean isFoil(ItemStack stack) {
        return super.isFoil(stack) || !PotionUtils.getMobEffects(stack).isEmpty();
    }

}
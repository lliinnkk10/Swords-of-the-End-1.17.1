package com.github.atheera.swordsoftheend.objects.items;

import com.github.atheera.swordsoftheend.entities.thrown.ModThrownEnderpearl;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemEnderpearlEnchanted extends Item {
    public ItemEnderpearlEnchanted(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> tooltip, TooltipFlag p_41424_) {
        tooltip.add(new TextComponent(ChatFormatting.AQUA + "Enchanted enderpearl that does not inflict self damage"));
        tooltip.add(new TextComponent(ChatFormatting.AQUA + "It also harms entities hit and does not spawn Endermites"));
        super.appendHoverText(p_41421_, p_41422_, tooltip, p_41424_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = new ItemStack(Items.ENDER_PEARL);
        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        player.getCooldowns().addCooldown(this, 30);
        if(!world.isClientSide) {
            ModThrownEnderpearl thrownpearl = new ModThrownEnderpearl(world, player);
            thrownpearl.setItem(stack);
            thrownpearl.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 1.5f, 1.0f);
            world.addFreshEntity(thrownpearl);
        }
        return super.use(world, player, hand);
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }
}
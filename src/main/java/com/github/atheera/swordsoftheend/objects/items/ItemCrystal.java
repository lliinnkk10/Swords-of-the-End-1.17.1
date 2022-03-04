package com.github.atheera.swordsoftheend.objects.items;

import com.github.atheera.swordsoftheend.inits.CreativeTabInit;
import com.github.atheera.swordsoftheend.materials.Rarities;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemCrystal extends Item {
    public ItemCrystal() {
        super(new Item.Properties()
                .tab(CreativeTabInit.SOTE_I_CMT)
                .rarity(Rarities.PURPLE)
                .stacksTo(1));
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(new TextComponent("Break the Enchanted Block version of respective gem with Chisel to receive"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}
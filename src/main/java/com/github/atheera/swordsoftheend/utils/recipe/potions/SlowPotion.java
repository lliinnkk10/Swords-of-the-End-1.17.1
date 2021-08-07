package com.github.atheera.swordsoftheend.utils.recipe.potions;

import com.github.atheera.swordsoftheend.inits.BlockInit;
import com.github.atheera.swordsoftheend.inits.ItemInit;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.brewing.IBrewingRecipe;

import javax.annotation.Nonnull;

public class SlowPotion implements IBrewingRecipe {

    private static final ItemStack INGREDIENT = new ItemStack(BlockInit.ITEM_BLOCK_MAGIC.get());
    private static final ItemStack OUTPUT = new ItemStack(ItemInit.ITEM_POTION_SLOW.get());

    public SlowPotion() { }

    @Override
    public boolean isInput(@Nonnull ItemStack bottles) {
        return PotionUtils.getPotion(bottles) == Potions.STRONG_SLOWNESS;
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
        return ingredient.getItem() == INGREDIENT.getItem();
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
        if(isInput(input) && isIngredient(ingredient)) return OUTPUT;
        return ItemStack.EMPTY;
    }
}

package com.github.atheera.swordsoftheend.utils.datagen;

import com.github.atheera.swordsoftheend.inits.ItemInit;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;

import java.util.Collection;
import java.util.function.Consumer;

public class RecipeGenerators extends RecipeProvider {
    public RecipeGenerators(DataGenerator p_125973_) {
        super(p_125973_);
    }

    private Item getPotion(String pot) {
        Potion pots = switch (pot) {
            case "STRONG_STRENGTH" -> Potions.STRONG_STRENGTH;
            case "STRONG_LEAPING" -> Potions.STRONG_LEAPING;
            case "STRONG_SWIFTNESS" -> Potions.STRONG_SWIFTNESS;
            default -> Potions.AWKWARD;
        };
        Item potion = Items.POTION;
        PotionUtils.setPotion(potion.getDefaultInstance(), pots);
        return potion;
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
/*
        ShapedRecipeBuilder.shaped(ItemInit.ITEM_TIER2_THUNDER.get())
            .pattern(" s ")
            .pattern("gtl")
            .pattern(" m ")
            .define('s', getPotion("STRONG_STRENGTH"))
            .define('g', Items.ENCHANTED_GOLDEN_APPLE)
            .define('t', ItemInit.ITEM_TIER_THUNDER.get())
            .define('l', getPotion("STRONG_LEAPING"))
            .define('m', getPotion("STRONG_SWIFTNESS"))
            .group("item_tier2_thunder")
            .unlockedBy("item_tier_thunder", InventoryChangeTrigger.TriggerInstance.hasItems(ItemInit.ITEM_TIER_THUNDER.get()))
            .save(consumer);

*/
    }
}

/*
        ShapedRecipeBuilder.shaped(ItemInit.ITEM_TIER2_THUNDER.get())
            .pattern("   ")
            .pattern("   ")
            .pattern("   ")
            .define('', )
            .define('', )
            .group("")
            .unlockedBy("", InventoryChangeTrigger.TriggerInstance.hasItems())
            .save(consumer);
 */
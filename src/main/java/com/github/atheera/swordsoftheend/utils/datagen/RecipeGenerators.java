package com.github.atheera.swordsoftheend.utils.datagen;

import com.github.atheera.swordsoftheend.inits.BlockInit;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class RecipeGenerators extends RecipeProvider {
    public RecipeGenerators(DataGenerator p_125973_) {
        super(p_125973_);
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

        ShapedRecipeBuilder.shaped(BlockInit.BLOCK_ENCHANT_INFUSER_GENERATOR.get())
                .pattern("MSM")
                .pattern("GFL")
                .pattern("MEM")
                .define('M', BlockInit.ITEM_BLOCK_MAGIC.get())
                .define('S', BlockInit.ITEM_BLOCK_SMELT_SHADITE_E.get())
                .define('G', BlockInit.ITEM_BLOCK_SMELT_GOLD_E.get())
                .define('F', Items.FURNACE)
                .define('L', BlockInit.ITEM_BLOCK_SMELT_LUMIN_E.get())
                .define('E', Items.ENCHANTING_TABLE)
                .group("swordsoftheend")
                .unlockedBy("magic", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.ITEM_BLOCK_MAGIC.get()))
                .save(consumer);

    }
}


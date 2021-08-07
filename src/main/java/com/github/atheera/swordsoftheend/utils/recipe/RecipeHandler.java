package com.github.atheera.swordsoftheend.utils.recipe;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.io.IOException;
import java.util.function.Consumer;

public class RecipeHandler extends RecipeProvider implements DataProvider {


    public RecipeHandler(DataGenerator p_125973_) {
        super(p_125973_);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> p_176532_) {



        super.buildCraftingRecipes(p_176532_);
    }

    @Override
    public void run(HashCache p_123925_) {

    }

    @Override
    public String getName() {
        return null;
    }
}

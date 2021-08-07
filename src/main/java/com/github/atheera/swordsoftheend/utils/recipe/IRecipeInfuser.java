package com.github.atheera.swordsoftheend.utils.recipe;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import com.github.atheera.swordsoftheend.SOTE;

import javax.annotation.Nonnull;
import java.util.Objects;

public interface IRecipeInfuser extends Recipe<RecipeWrapper> {

    ResourceLocation RECIPE_TYPE_ID = new ResourceLocation(SOTE.MOD_ID, "infuser");

    @Nonnull
    @Override
    default RecipeType<?> getType() {
        return Objects.requireNonNull(Registry.RECIPE_TYPE.get(RECIPE_TYPE_ID));
    }

    @Override
    default boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    Ingredient getInput();

}

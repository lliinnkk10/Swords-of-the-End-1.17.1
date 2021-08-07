package com.github.atheera.swordsoftheend.utils.recipe;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class InfuserRecipeSerializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<InfuserRecipe> {


    @Override
    public InfuserRecipe fromJson(ResourceLocation recipeID, JsonObject json) {
        ItemStack output = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "output"), true);
        Ingredient input = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "input"));
        return new InfuserRecipe(recipeID, input, output);
    }

    @Nullable
    @Override
    public InfuserRecipe fromNetwork(ResourceLocation recipeID, FriendlyByteBuf buffer) {
        ItemStack output = buffer.readItem();
        Ingredient input = Ingredient.fromNetwork(buffer);

        return new InfuserRecipe(recipeID, input, output);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer, InfuserRecipe recipe) {
        Ingredient input = recipe.getIngredients().get(0);
        input.toNetwork(buffer);

        buffer.writeItemStack(recipe.getResultItem(), false);
    }
}

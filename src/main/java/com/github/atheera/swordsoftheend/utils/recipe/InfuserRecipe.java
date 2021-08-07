package com.github.atheera.swordsoftheend.utils.recipe;

import com.github.atheera.swordsoftheend.inits.RecipeSerializerInit;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class InfuserRecipe implements IRecipeInfuser {

    private final ResourceLocation id;
    private Ingredient input;
    private final ItemStack output;

    public InfuserRecipe(ResourceLocation id, Ingredient input, ItemStack output) {
        this.id = id;
        this.input = input;
        this.output = output;
    }

    @Override
    public boolean matches(RecipeWrapper inv, Level world) {
        if(this.input.test(inv.getItem(0))) {
            return true;
        }
        return false;
    }

    @Override
    public ItemStack assemble(RecipeWrapper p_44001_) {
        return this.output;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResultItem() {
        return this.output;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializerInit.INFUSER_SERIALIZER.get();
    }

    @Override
    public Ingredient getInput() {
        return this.input;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(null, this.input);
    }
}
package com.github.atheera.swordsoftheend.inits;

import com.github.atheera.swordsoftheend.SOTE;
import com.github.atheera.swordsoftheend.utils.recipe.IRecipeInfuser;
import com.github.atheera.swordsoftheend.utils.recipe.InfuserRecipe;
import com.github.atheera.swordsoftheend.utils.recipe.InfuserRecipeSerializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import java.util.Objects;


public class RecipeSerializerInit {

    public static final RecipeSerializer<InfuserRecipe> INFUSER_RECIPE_SERIALIZER = new InfuserRecipeSerializer();
    public static final RecipeType<IRecipeInfuser> INFUSER_TYPE = Recipetype.registerType(IRecipeInfuser.RECIPE_TYPE_ID);

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SOTE.MOD_ID);

    public static final RegistryObject<RecipeSerializer<InfuserRecipe>> INFUSER_SERIALIZER = RECIPE_SERIALIZERS.register("infuser", () -> INFUSER_RECIPE_SERIALIZER);

    private static class Recipetype<T extends Recipe<?>> implements RecipeType<T> {

        @Override
        public String toString() {
            return Objects.requireNonNull(Registry.RECIPE_TYPE.getKey(this)).toString();
        }

        private static <T extends RecipeType> T registerType(ResourceLocation recipeTypeId) {
            return (T) Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new Recipetype<>());
        }


    }

}

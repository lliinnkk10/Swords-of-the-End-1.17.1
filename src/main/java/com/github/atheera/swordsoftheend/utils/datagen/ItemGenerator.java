package com.github.atheera.swordsoftheend.utils.datagen;

import com.github.atheera.swordsoftheend.SOTE;
import com.github.atheera.swordsoftheend.inits.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemGenerator extends ItemModelProvider {

    public ItemGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, SOTE.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        singleTexture(
            ItemInit.ITEM_TIER_TF_COURAGE.get().getRegistryName().getPath(),
            new ResourceLocation("item/handheld"),
            "layer0",
            new ResourceLocation(SOTE.MOD_ID, "items/item_tier_tf_courage"));
    }
}

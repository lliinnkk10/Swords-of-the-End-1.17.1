package com.github.atheera.swordsoftheend.utils.datagen;

import com.github.atheera.swordsoftheend.SOTE;
import com.github.atheera.swordsoftheend.inits.BlockInit;
import com.github.atheera.swordsoftheend.inits.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Objects;

import static com.github.atheera.swordsoftheend.SOTE.DISTANCE_PROPERTY;

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
/*
        getBuilder(BlockInit.ITEM_BLOCK_ENCHANT_INFUSER.get().getRegistryName().getPath())
                .parent(getExistingFile(mcLoc("item/handheld")))
                .texture("layer0", "item/firstitem0")
                .override().predicate(DISTANCE_PROPERTY, 0).model(createTestModel(0)).end()
                .override().predicate(DISTANCE_PROPERTY, 1).model(createTestModel(1)).end()
                .override().predicate(DISTANCE_PROPERTY, 2).model(createTestModel(2)).end()
                .override().predicate(DISTANCE_PROPERTY, 3).model(createTestModel(3)).end();*/

        withExistingParent(Objects.requireNonNull(BlockInit.ITEM_BLOCK_ENCHANT_INFUSER.get().getRegistryName()).getPath(), new ResourceLocation(SOTE.MOD_ID, "block/block_infuser"));

    }

    private ItemModelBuilder createTestModel(int suffix) {
        return getBuilder("block_infuser" + suffix).parent(getExistingFile(mcLoc("item/handheld")))
                .texture("layer0", "item/block_infuser" + suffix);
    }

}
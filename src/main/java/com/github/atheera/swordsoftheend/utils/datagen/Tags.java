package com.github.atheera.swordsoftheend.utils.datagen;

import com.github.atheera.swordsoftheend.SOTE;
import com.github.atheera.swordsoftheend.inits.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class Tags extends BlockTagsProvider {
    public Tags(DataGenerator generator, @Nullable ExistingFileHelper helper) {
        super(generator, SOTE.MOD_ID, helper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(BlockInit.BLOCK_ENCHANT_INFUSER.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
            .add(BlockInit.BLOCK_ENCHANT_INFUSER.get());
    }

    @Override
    public String getName() {
        return "SOTE Tags";
    }
}
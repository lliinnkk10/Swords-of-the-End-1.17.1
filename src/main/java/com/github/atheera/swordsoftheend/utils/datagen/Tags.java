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

    //.add(BlockInit..get())

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(BlockInit.BLOCK_ENCHANT_INFUSER.get())

            .add(BlockInit.BLOCK_ORE_DEEP_RUBY.get())
            .add(BlockInit.BLOCK_ORE_RUBY.get())
            .add(BlockInit.BLOCK_CRYSTAL_RUBY_E.get())

            .add(BlockInit.BLOCK_ORE_DEEP_SAPPHIRE.get())
            .add(BlockInit.BLOCK_ORE_SAPPHIRE.get())
            .add(BlockInit.BLOCK_CRYSTAL_SAPPHIRE_E.get())

            .add(BlockInit.BLOCK_CRYSTAL_AMETHYST_E.get())

            .add(BlockInit.BLOCK_ORE_SHADITE.get())
            .add(BlockInit.BLOCK_ORE_NETHER_SHADITE.get())
            .add(BlockInit.BLOCK_RAW_LUMIN.get())
            .add(BlockInit.BLOCK_SMELT_SHADITE.get())
            .add(BlockInit.BLOCK_SMELT_SHADITE_E.get())

            .add(BlockInit.BLOCK_ORE_GOLD.get())
            .add(BlockInit.BLOCK_ORE_DEEP_GOLD.get())
            .add(BlockInit.BLOCK_RAW_GOLD.get())
            .add(BlockInit.BLOCK_SMELT_GOLD.get())
            .add(BlockInit.BLOCK_SMELT_GOLD_E.get())

            .add(BlockInit.BLOCK_ORE_LUMIN.get())
            .add(BlockInit.BLOCK_ORE_DEEP_LUMIN.get())
            .add(BlockInit.BLOCK_RAW_LUMIN.get())
            .add(BlockInit.BLOCK_SMELT_LUMIN.get())
            .add(BlockInit.BLOCK_SMELT_LUMIN_E.get())

            .add(BlockInit.BLOCK_ORE_MAGIC.get())
            .add(BlockInit.BLOCK_ORE_DEEP_MAGIC.get())
            .add(BlockInit.BLOCK_MAGIC.get())

            .add(BlockInit.BLOCK_END_E.get())
            .add(BlockInit.BLOCK_GEM_DIAMOND_E.get())
            .add(BlockInit.BLOCK_GEM_EMERALD_E.get())
            .add(BlockInit.BLOCK_GEM_ULTIMATE.get())
            .add(BlockInit.BLOCK_INGOT_ULTIMATE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
            .add(BlockInit.BLOCK_ENCHANT_INFUSER.get())

            .add(BlockInit.BLOCK_ORE_DEEP_RUBY.get())
            .add(BlockInit.BLOCK_ORE_RUBY.get())
            .add(BlockInit.BLOCK_CRYSTAL_RUBY_E.get())

            .add(BlockInit.BLOCK_ORE_DEEP_SAPPHIRE.get())
            .add(BlockInit.BLOCK_ORE_SAPPHIRE.get())
            .add(BlockInit.BLOCK_CRYSTAL_SAPPHIRE_E.get())

            .add(BlockInit.BLOCK_CRYSTAL_AMETHYST_E.get())

            .add(BlockInit.BLOCK_ORE_SHADITE.get())
            .add(BlockInit.BLOCK_ORE_NETHER_SHADITE.get())
            .add(BlockInit.BLOCK_RAW_LUMIN.get())
            .add(BlockInit.BLOCK_SMELT_SHADITE.get())
            .add(BlockInit.BLOCK_SMELT_SHADITE_E.get())

            .add(BlockInit.BLOCK_ORE_GOLD.get())
            .add(BlockInit.BLOCK_ORE_DEEP_GOLD.get())
            .add(BlockInit.BLOCK_RAW_GOLD.get())
            .add(BlockInit.BLOCK_SMELT_GOLD.get())
            .add(BlockInit.BLOCK_SMELT_GOLD_E.get())

            .add(BlockInit.BLOCK_ORE_LUMIN.get())
            .add(BlockInit.BLOCK_ORE_DEEP_LUMIN.get())
            .add(BlockInit.BLOCK_RAW_LUMIN.get())
            .add(BlockInit.BLOCK_SMELT_LUMIN.get())
            .add(BlockInit.BLOCK_SMELT_LUMIN_E.get())

            .add(BlockInit.BLOCK_ORE_MAGIC.get())
            .add(BlockInit.BLOCK_ORE_DEEP_MAGIC.get())
            .add(BlockInit.BLOCK_MAGIC.get())

            .add(BlockInit.BLOCK_END_E.get())
            .add(BlockInit.BLOCK_GEM_DIAMOND_E.get())
            .add(BlockInit.BLOCK_GEM_EMERALD_E.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(BlockInit.BLOCK_GEM_ULTIMATE.get())
            .add(BlockInit.BLOCK_INGOT_ULTIMATE.get());
    }

    @Override
    public String getName() {
        return "SOTE Tags";
    }
}
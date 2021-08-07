package com.github.atheera.swordsoftheend.world;

import com.github.atheera.swordsoftheend.inits.BlockInit;
import com.github.atheera.swordsoftheend.utils.config.OregenConfig;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import static com.github.atheera.swordsoftheend.inits.BlockInit.*;
import static com.github.atheera.swordsoftheend.utils.config.OregenConfig.*;

public class OreGeneration {

    public static final RuleTest END_STONE = new BlockMatchTest(Blocks.END_STONE);

    public static void addFeaturesToBiomes(final BiomeLoadingEvent event) {

        // Only generates in The End
        if(event.getCategory().equals(Biome.BiomeCategory.THEEND)) {
            generateOre(event.getGeneration(),
                END_STONE,
                BlockInit.BLOCK_ORE_SHADITE.get().defaultBlockState(),
                shadite_size.get(),
                shadite_minHeight.get(),
                shadite_maxHeight.get(),
                shadite_count.get(),
                shadite_spawn.get());
        }

        // Only generates in The Nether
        if(event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            generateOre(event.getGeneration(),
                OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES,
                BLOCK_ORE_NETHER_SHADITE.get().defaultBlockState(),
                nether_shadite_size.get(),
                nether_shadite_minHeight.get(),
                nether_shadite_maxHeight.get(),
                nether_shadite_count.get(),
                nether_shadite_spawn.get());
        }

        // Only generates in The Overworld
        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND) && !event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            generateOre(event.getGeneration(),
                OreConfiguration.Predicates.NATURAL_STONE,
                BLOCK_ORE_LUMIN.get().defaultBlockState(),
                lumin_size.get(),
                lumin_minHeight.get(),
                lumin_maxHeight.get(),
                lumin_count.get(),
                lumin_spawn.get());
            generateOre(event.getGeneration(),
                OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES,
                BLOCK_ORE_LUMIN.get().defaultBlockState(),
                lumin_size.get(),
                deep_lumin_minHeight.get(),
                deep_lumin_maxHeight.get(),
                deep_lumin_count.get(),
                deep_lumin_spawn.get());
            generateOre(event.getGeneration(),
                OreConfiguration.Predicates.NATURAL_STONE,
                BLOCK_ORE_GOLD.get().defaultBlockState(),
                gold_size.get(),
                gold_minHeight.get(),
                gold_maxHeight.get(),
                gold_count.get(),
                lumin_spawn.get());
            generateOre(event.getGeneration(),
                OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES,
                BLOCK_ORE_GOLD.get().defaultBlockState(),
                deep_gold_size.get(),
                deep_gold_minHeight.get(),
                deep_gold_maxHeight.get(),
                deep_gold_count.get(),
                deep_lumin_spawn.get());
            generateOre(event.getGeneration(),
                OreConfiguration.Predicates.NATURAL_STONE,
                BLOCK_ORE_MAGIC.get().defaultBlockState(),
                enchant_size.get(),
                enchant_minHeight.get(),
                enchant_maxHeight.get(),
                enchant_count.get(),
                enchant_spawn.get());
            generateOre(event.getGeneration(),
                OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES,
                BLOCK_ORE_DEEP_MAGIC.get().defaultBlockState(),
                deep_enchant_size.get(),
                deep_enchant_minHeight.get(),
                deep_enchant_maxHeight.get(),
                deep_enchant_count.get(),
                deep_enchant_spawn.get());
            generateOre(event.getGeneration(),
                OreConfiguration.Predicates.NATURAL_STONE,
                BLOCK_ORE_RUBY.get().defaultBlockState(),
                4, 10, 30, 2, true);
            generateOre(event.getGeneration(),
                OreConfiguration.Predicates.NATURAL_STONE,
                BLOCK_ORE_DEEP_RUBY.get().defaultBlockState(),
                4, 10, 30, 2, true);
            generateOre(event.getGeneration(),
                OreConfiguration.Predicates.NATURAL_STONE,
                BLOCK_ORE_SAPPHIRE.get().defaultBlockState(),
                4, 10, 30, 2, true);
            generateOre(event.getGeneration(),
                OreConfiguration.Predicates.NATURAL_STONE,
                BLOCK_ORE_DEEP_SAPPHIRE.get().defaultBlockState(),
                4, 10, 30, 2, true);
        }
    }

    private static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest blockType, BlockState state, int veinSize, int minHeight, int maxHeight, int count, boolean enable) {
        if(enable) {
            settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreConfiguration(blockType, state, veinSize))
                     .rangeUniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight))
                     .squared().count(count));
        }
    }
}
package com.github.atheera.swordsoftheend.world;

import com.github.atheera.swordsoftheend.inits.BlockInit;
import com.github.atheera.swordsoftheend.utils.config.OregenConfig;
import com.google.common.collect.ImmutableList;
import net.minecraft.data.worldgen.Features;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Random;

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

            generateGeode(event.getGeneration(),
                BLOCK_CRYSTAL_SAPPHIRE.get().defaultBlockState(),
                BLOCK_BUDDING_SAPPHIRE.get().defaultBlockState(),
                Blocks.END_STONE_BRICKS.defaultBlockState(),
                Blocks.END_STONE.defaultBlockState(),
                BLOCK_BUD_SMALL_SAPPHIRE.get().defaultBlockState(),
                BLOCK_BUD_MEDIUM_SAPPHIRE.get().defaultBlockState(),
                BLOCK_BUD_LARGE_SAPPHIRE.get().defaultBlockState(),
                BLOCK_CLUSTER_SAPPHIRE.get().defaultBlockState(),
                10, 50, 69);
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

            generateGeode(event.getGeneration(),
                BLOCK_CRYSTAL_RUBY.get().defaultBlockState(),
                BLOCK_BUDDING_RUBY.get().defaultBlockState(),
                Blocks.NETHER_BRICKS.defaultBlockState(),
                Blocks.NETHERRACK.defaultBlockState(),
                BLOCK_BUD_SMALL_RUBY.get().defaultBlockState(),
                BLOCK_BUD_MEDIUM_RUBY.get().defaultBlockState(),
                BLOCK_BUD_LARGE_RUBY.get().defaultBlockState(),
                BLOCK_CLUSTER_RUBY.get().defaultBlockState(),
                90, 120, 36);
            generateGeode(event.getGeneration(),
                BLOCK_CRYSTAL_RUBY.get().defaultBlockState(),
                BLOCK_BUDDING_RUBY.get().defaultBlockState(),
                Blocks.NETHER_BRICKS.defaultBlockState(),
                Blocks.NETHERRACK.defaultBlockState(),
                BLOCK_BUD_SMALL_RUBY.get().defaultBlockState(),
                BLOCK_BUD_MEDIUM_RUBY.get().defaultBlockState(),
                BLOCK_BUD_LARGE_RUBY.get().defaultBlockState(),
                BLOCK_CLUSTER_RUBY.get().defaultBlockState(),
                4, 25, 53);
        }

        // Only generates in The Overworld
        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND) && !event.getCategory().equals(Biome.BiomeCategory.NETHER)) {

            generateGeode(event.getGeneration(),
                BLOCK_CRYSTAL_SAPPHIRE.get().defaultBlockState(),
                BLOCK_BUDDING_SAPPHIRE.get().defaultBlockState(),
                Blocks.CALCITE.defaultBlockState(),
                Blocks.SMOOTH_BASALT.defaultBlockState(),
                BLOCK_BUD_SMALL_SAPPHIRE.get().defaultBlockState(),
                BLOCK_BUD_MEDIUM_SAPPHIRE.get().defaultBlockState(),
                BLOCK_BUD_LARGE_SAPPHIRE.get().defaultBlockState(),
                BLOCK_CLUSTER_SAPPHIRE.get().defaultBlockState(),
                10, 30, 169);

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
                1, 10, 30, 1, true);
            generateOre(event.getGeneration(),
                OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES,
                BLOCK_ORE_DEEP_RUBY.get().defaultBlockState(),
                1, 2, 10, 1, true);
            generateOre(event.getGeneration(),
                OreConfiguration.Predicates.NATURAL_STONE,
                BLOCK_ORE_SAPPHIRE.get().defaultBlockState(),
                1, 10, 30, 1, true);
            generateOre(event.getGeneration(),
                OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES,
                BLOCK_ORE_DEEP_SAPPHIRE.get().defaultBlockState(),
                1, 2, 10, 1, true);
        }
    }

    private static void generateOre(BiomeGenerationSettingsBuilder builder, RuleTest blockType, BlockState state, int veinSize, int minHeight, int maxHeight, int count, boolean enable) {
        if(enable) {
            builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreConfiguration(blockType, state, veinSize))
                     .rangeUniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight))
                     .squared().count(count));
        }
    }

    private static void generateGeode(BiomeGenerationSettingsBuilder settings,
                                      BlockState crystal, BlockState budding,
                                      BlockState innerLayer, BlockState outerLayer,
                                      BlockState smallCrystal, BlockState mediumCrystal, BlockState largeCrystal, BlockState clusterCrystal,
                                      int minHeight, int maxHeight, int rarity) {

        settings.addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
            Feature.GEODE.configured(new GeodeConfiguration(new GeodeBlockSettings(
                new SimpleStateProvider(Blocks.AIR.defaultBlockState()),
                    new SimpleStateProvider(crystal), new SimpleStateProvider(budding),
                        new SimpleStateProvider(innerLayer), new SimpleStateProvider(outerLayer),
                            ImmutableList.of(smallCrystal, mediumCrystal, largeCrystal, clusterCrystal),
                                BlockTags.FEATURES_CANNOT_REPLACE.getName(), BlockTags.GEODE_INVALID_BLOCKS.getName()),
                                    new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                                        new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true,
                                                                UniformInt.of(4, 6), UniformInt.of(3, 4),
                                                                UniformInt.of(1, 2), -16, 16, 0.05D, 1))
                                            .rangeUniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)).squared().rarity(rarity));
    }

}
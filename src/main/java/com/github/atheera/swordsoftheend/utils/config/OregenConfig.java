package com.github.atheera.swordsoftheend.utils.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig {

    private final String name;
    private boolean enable;
    private int size;
    private int range;
    private int count;
    private int bottom;
    private int top;

    public OregenConfig(String name, boolean enable) {
        this.name = name;
        this.enable = enable;
        this.size = 0;
        this.range = 0;
        this.count = 0;
        this.bottom = 0;
        this.top = 0;
    }

    public static ForgeConfigSpec.IntValue shadite_size;
    public static ForgeConfigSpec.IntValue shadite_count;
    public static ForgeConfigSpec.IntValue shadite_maxHeight;
    public static ForgeConfigSpec.IntValue shadite_minHeight;
    public static ForgeConfigSpec.BooleanValue shadite_spawn;

    public static ForgeConfigSpec.IntValue nether_shadite_size;
    public static ForgeConfigSpec.IntValue nether_shadite_count;
    public static ForgeConfigSpec.IntValue nether_shadite_maxHeight;
    public static ForgeConfigSpec.IntValue nether_shadite_minHeight;
    public static ForgeConfigSpec.BooleanValue nether_shadite_spawn;

    public static ForgeConfigSpec.IntValue gold_size;
    public static ForgeConfigSpec.IntValue gold_count;
    public static ForgeConfigSpec.IntValue gold_maxHeight;
    public static ForgeConfigSpec.IntValue gold_minHeight;
    public static ForgeConfigSpec.BooleanValue gold_spawn;

    public static ForgeConfigSpec.IntValue deep_gold_size;
    public static ForgeConfigSpec.IntValue deep_gold_count;
    public static ForgeConfigSpec.IntValue deep_gold_maxHeight;
    public static ForgeConfigSpec.IntValue deep_gold_minHeight;
    public static ForgeConfigSpec.BooleanValue deep_gold_spawn;

    public static ForgeConfigSpec.IntValue lumin_size;
    public static ForgeConfigSpec.IntValue lumin_count;
    public static ForgeConfigSpec.IntValue lumin_maxHeight;
    public static ForgeConfigSpec.IntValue lumin_minHeight;
    public static ForgeConfigSpec.BooleanValue lumin_spawn;

    public static ForgeConfigSpec.IntValue deep_lumin_size;
    public static ForgeConfigSpec.IntValue deep_lumin_count;
    public static ForgeConfigSpec.IntValue deep_lumin_maxHeight;
    public static ForgeConfigSpec.IntValue deep_lumin_minHeight;
    public static ForgeConfigSpec.BooleanValue deep_lumin_spawn;

    public static ForgeConfigSpec.IntValue enchant_size;
    public static ForgeConfigSpec.IntValue enchant_count;
    public static ForgeConfigSpec.IntValue enchant_maxHeight;
    public static ForgeConfigSpec.IntValue enchant_minHeight;
    public static ForgeConfigSpec.BooleanValue enchant_spawn;

    public static ForgeConfigSpec.IntValue deep_enchant_size;
    public static ForgeConfigSpec.IntValue deep_enchant_count;
    public static ForgeConfigSpec.IntValue deep_enchant_maxHeight;
    public static ForgeConfigSpec.IntValue deep_enchant_minHeight;
    public static ForgeConfigSpec.BooleanValue deep_enchant_spawn;

    public static ForgeConfigSpec.IntValue ruby_top_maxHeight;
    public static ForgeConfigSpec.IntValue ruby_top_minHeight;
    public static ForgeConfigSpec.IntValue ruby_top_rarity;
    public static ForgeConfigSpec.BooleanValue ruby_top_spawn;

    public static ForgeConfigSpec.IntValue ruby_bottom_maxHeight;
    public static ForgeConfigSpec.IntValue ruby_bottom_minHeight;
    public static ForgeConfigSpec.IntValue ruby_bottom_rarity;
    public static ForgeConfigSpec.BooleanValue ruby_bottom_spawn;

    public static ForgeConfigSpec.IntValue sapphire_end_maxHeight;
    public static ForgeConfigSpec.IntValue sapphire_end_minHeight;
    public static ForgeConfigSpec.IntValue sapphire_end_rarity;
    public static ForgeConfigSpec.BooleanValue sapphire_end_spawn;

    public static ForgeConfigSpec.IntValue sapphire_over_maxHeight;
    public static ForgeConfigSpec.IntValue sapphire_over_minHeight;
    public static ForgeConfigSpec.IntValue sapphire_over_rarity;
    public static ForgeConfigSpec.BooleanValue sapphire_over_spawn;

    public static void init(ForgeConfigSpec.Builder builder) {
        builder.comment("Settings for Swords of the End").push("Settings");

        builder.comment("Ore Generation").push("Oregen");

        builder.comment("Shadite").push("Shadite");
        shadite_spawn = builder.comment("Should the ore 'Shadite' generate in the end? Default true").define("shadite_spawn", true);
        shadite_count = builder.comment("Maximum number of shadite ore veins per chunk. Default 2").defineInRange("shadite_count", 2, 1, 5);
        shadite_size = builder.comment("Maximum amount of ores per vein. Default 4").defineInRange("shadite_size", 4, 1, 8);
        shadite_maxHeight = builder.comment("Max height ores found. Default 30").defineInRange("shadite_maxHeight", 30, 20, 60);
        shadite_minHeight = builder.comment("Min height ores found. Default 10").defineInRange("shadite_minHeight", 10, 10, 40);

        builder.comment("Nether Shadite").push("NetherShadite");
        nether_shadite_spawn = builder.comment("Should the ore 'Shadite' generate in the nether? Default true").define("nether_shadite_spawn", true);
        nether_shadite_count = builder.comment("Maximum number of shadite ore veins per chunk. Default 2").defineInRange("nether_shadite_count", 2, 1, 5);
        nether_shadite_size = builder.comment("Maximum amount of ores per vein. Default 4").defineInRange("nether_shadite_size", 4, 1, 8);
        nether_shadite_maxHeight = builder.comment("Max height ores found. Default 20").defineInRange("nether_shadite_maxHeight", 20, 10, 28);
        nether_shadite_minHeight = builder.comment("Min height ores found. Default 4").defineInRange("nether_shadite_minHeight", 4, 2, 10);
        builder.pop();
        builder.pop();

        builder.comment("Energized Gold").push("Gold");
        gold_spawn = builder.comment("Should the ore 'Energized Gold' generate? Default true").define("gold_spawn", true);
        gold_count = builder.comment("Maximum number of Energized Gold ore veins per chunk. Default 1").defineInRange("gold_count", 1, 1, 5);
        gold_size = builder.comment("Maximum amount of ores per vein. Default 4").defineInRange("gold_size", 4, 1, 8);
        gold_maxHeight = builder.comment("Max height ores found. Default 30").defineInRange("gold_maxHeight", 30, 15, 50);
        gold_minHeight = builder.comment("Min height ores found. Default 10").defineInRange("gold_minHeight",  10, 5, 15);

        builder.comment("Deep Energized Gold").push("DeepGold");
        deep_gold_spawn = builder.comment("Should the ore 'Deep Energized Gold' generate? Default true").define("deep_gold_spawn", true);
        deep_gold_count = builder.comment("Maximum number of Deep Energized Gold ore veins per chunk. Default 2").defineInRange("deep_gold_count", 1, 1, 5);
        deep_gold_size = builder.comment("Maximum amount of ores per vein. Default 4").defineInRange("deep_gold_size", 4, 1, 8);
        deep_gold_maxHeight = builder.comment("Max height ores found. Default 0").defineInRange("deep_gold_maxHeight", 9, 2, 15);
        deep_gold_minHeight = builder.comment("Min height ores found. Default -30").defineInRange("deep_gold_minHeight",  2, 0, 5);
        builder.pop();
        builder.pop();

        builder.comment("Luminite Ore").push("Luminite");
        lumin_spawn = builder.comment("Should the ore 'Luminite' generate? Default true").define("lumin_spawn", true);
        lumin_count = builder.comment("Maximum number of Luminite ore veins per chunk. Default 1").defineInRange("lumin_count", 1, 1, 5);
        lumin_size = builder.comment("Maximum amount of ores per vein. Default 4").defineInRange("lumin_size", 4, 1, 8);
        lumin_maxHeight = builder.comment("Max height ores found. Default 30").defineInRange("lumin_maxHeight", 30, 15, 50);
        lumin_minHeight = builder.comment("Min height ores found. Default -20").defineInRange("lumin_minHeight",  10, 5, 15);

        builder.comment("Deep Luminite").push("DeepLuminite");
        deep_lumin_spawn = builder.comment("Should the ore 'Deep Luminite' generate? Default true").define("deep_lumin_spawn", true);
        deep_lumin_count = builder.comment("Maximum number of Deep Luminite ore veins per chunk. Default 2").defineInRange("deep_lumin_count", 2, 1, 5);
        deep_lumin_size = builder.comment("Maximum amount of ores per vein. Default 4").defineInRange("deep_lumin_size", 4, 1, 8);
        deep_lumin_maxHeight = builder.comment("Max height ores found. Default 0").defineInRange("deep_lumin_maxHeight", 9, 2, 15);
        deep_lumin_minHeight = builder.comment("Min height ores found. Default 2").defineInRange("deep_lumin_minHeight",  2, 0, 5);
        builder.pop();
        builder.pop();

        builder.comment("Enchantment ore").push("Enchantment");
        enchant_spawn = builder.comment("Should the ore 'Enchantment' generate? Default true").define("enchantment_spawn", true);
        enchant_count = builder.comment("Maximum number of Enchantment ore veins per chunk. Default 1").defineInRange("enchantment_count", 1, 1, 5);
        enchant_size = builder.comment("Maximum amount of ores per vein. Default 6").defineInRange("enchantment_size", 6, 1, 8);
        enchant_maxHeight = builder.comment("Max height ores found. Default 30").defineInRange("enchantment_maxHeight", 30, 15, 50);
        enchant_minHeight = builder.comment("Min height ores found. Default 10").defineInRange("enchantment_minHeight", 10, 5, 15);

        builder.comment("Deep Enchantment").push("DeepEnchantment");
        deep_enchant_spawn = builder.comment("Should the ore 'Deep Enchantment' generate? Default true").define("deep_enchantment_spawn", true);
        deep_enchant_count = builder.comment("Maximum number of Deep Enchantment ore veins per chunk. Default 2").defineInRange("deep_enchantment_count", 2, 1, 5);
        deep_enchant_size = builder.comment("Maximum amount of ores per vein. Default 6").defineInRange("deep_enchantment_size", 6, 1, 8);
        deep_enchant_maxHeight = builder.comment("Max height ores found. Default 9").defineInRange("deep_enchantment_maxHeight", 9, 2, 15);
        deep_enchant_minHeight = builder.comment("Min height ores found. Default 2").defineInRange("deep_enchantment_minHeight", 2, 0, 5);
        builder.pop();
        builder.pop();

        builder.comment("Ruby Top Layer").push("RubyTopLayer");
        ruby_top_spawn = builder.comment("Should 'Ruby Geodes' generate at top layer in nether? Default true").define("ruby_top_spawn", true);
        ruby_top_maxHeight = builder.comment("Maximum height that top layer ruby geodes can spawn. Default 120").defineInRange("ruby_top_maxHeight", 120, 100, 125);
        ruby_top_minHeight = builder.comment("Minimum height that top layer ruby geodes can spawn. Default 90").defineInRange("ruby_top_minHeight", 90, 80, 100);
        ruby_top_rarity = builder.comment("Rarity of top layer ruby geodes. Default 89 (Higher numbers lower spawn chance)").defineInRange("ruby_top_rarity", 89, 20, 100);

        builder.comment("Ruby Bottom Layer").push("RubyBottomLayer");
        ruby_bottom_spawn = builder.comment("Should 'Ruby Geodes' generate at the bottom layer in the nether? Default true").define("ruby_bottom_spawn", true);
        ruby_bottom_maxHeight = builder.comment("Maximum height that bottom layer ruby geodes can spawn. Default 25").defineInRange("ruby__bottom_maxHeight", 25, 15, 30);
        ruby_bottom_minHeight = builder.comment("Minimum height that bottom layer ruby geodes can spawn. Default 4").defineInRange("ruby_bottom_minHeight", 4, 2, 10);
        ruby_bottom_rarity = builder.comment("Rarity of bottom layer ruby geodes. Default 34 (Higher numbers lower spawn chance)").defineInRange("ruby_bottom_rarity", 34, 20, 100);
        builder.pop();
        builder.pop();

        builder.comment("Sapphire End Dimension").push("SapphireEndDimension");
        sapphire_end_spawn = builder.comment("Should 'Sapphire Geodes' generate in the End dimension? Default true").define("sapphire_end_spawn", true);
        sapphire_end_maxHeight = builder.comment("Maximum height that end sapphire geodes can spawn. Default 50").defineInRange("sapphire_end_maxHeight", 50, 35, 60);
        sapphire_end_minHeight = builder.comment("Minimum height that end sapphire geodes can spawn. Default 10").defineInRange("sapphire_end_minHeight", 10, 5, 25);
        sapphire_end_rarity = builder.comment("Rarity of end sapphire geodes. Default 32 (Higher numbers lower spawn chance)").defineInRange("sapphire_end_rarity", 32, 20, 100);

        builder.comment("Sapphire Overworld Dimension").push("SapphireOverworldDimension");
        sapphire_over_spawn = builder.comment("Should 'Sapphire Geodes' generate in the Overworld dimension? Default true").define("sapphire_over_spawn", true);
        sapphire_over_maxHeight = builder.comment("Maximum height that overworld sapphire geodes can spawn. Default 30").defineInRange("sapphire_over_maxHeight", 30, 25, 50);
        sapphire_over_minHeight = builder.comment("Minimum height that overworld sapphire geodes can spawn. Default 10").defineInRange("sapphire_over_minHeight", 10, 5, 25);
        sapphire_over_rarity = builder.comment("Rarity of overworld sapphire geodes. Default 100 (Higher numbers lower spawn chance)").defineInRange("sapphire_over_rarity", 100, 20, 100);
        builder.pop();
        builder.pop();

    }

    protected String getName() { return this.name; }
    public boolean isEnable() { return enable; }
    public int getSize() { return size; }
    public int getRange() { return range; }
    public int getCount() { return count; }
    public int getBottom() { return bottom; }
    public int getTop() { return top; }

}

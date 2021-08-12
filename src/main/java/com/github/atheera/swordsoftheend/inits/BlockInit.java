package com.github.atheera.swordsoftheend.inits;

import com.github.atheera.swordsoftheend.materials.Rarities;
import com.github.atheera.swordsoftheend.objects.blocks.BlockInfuser;
import com.github.atheera.swordsoftheend.objects.blocks.BlockItemEnchanted;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.github.atheera.swordsoftheend.SOTE.MOD_ID;

public class BlockInit {

    // Initiate
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    private static final CreativeModeTab bTab = CreativeTabInit.SOTE_B_CMT;
    private static final Rarity GOLD = Rarities.GOLD;
    private static final Rarity PURP = Rarities.PURPLE;
    private static final Rarity BLUE = Rarities.BLUE;
    private static final Rarity GREEN = Rarities.GREEN;

    // Block Properties
    private static final BlockBehaviour.Properties oreProperties = BlockBehaviour.Properties.of(Material.STONE).strength(3.0f, 3.0f)
                         .sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops();
    private static final BlockBehaviour.Properties deepOreProperties = BlockBehaviour.Properties.of(Material.STONE).strength(4.5f, 3.0f)
                         .sound(SoundType.DEEPSLATE).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops();
    private static final BlockBehaviour.Properties metalProperties = BlockBehaviour.Properties.of(Material.METAL).strength(3.0f, 6.0f)
                         .sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops();
    private static final BlockBehaviour.Properties gemProperties = BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_PURPLE)
                         .strength(1.0f).sound(SoundType.AMETHYST).requiresCorrectToolForDrops();
    // Create

        // * * * * * * * * * * * * Blocks * * * * * * * * * * * * \\
            // Ores
    public static final RegistryObject<Block> BLOCK_ORE_SHADITE = BLOCKS.register("block_ore_shadite",
        () -> new Block(oreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_NETHER_SHADITE = BLOCKS.register("block_ore_nether_shadite",
        () -> new Block(oreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_GOLD = BLOCKS.register("block_ore_gold",
        () -> new Block(oreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_LUMIN = BLOCKS.register("block_ore_lumin",
        () -> new Block(oreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_DEEP_GOLD = BLOCKS.register("block_ore_deep_gold",
        () -> new Block(deepOreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_DEEP_LUMIN = BLOCKS.register("block_ore_deep_lumin",
        () -> new Block(deepOreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_MAGIC = BLOCKS.register("block_ore_magic",
        () -> new Block(oreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_DEEP_MAGIC = BLOCKS.register("block_ore_deep_magic",
        () -> new Block(deepOreProperties));
                // Raw
    public static final RegistryObject<Block> BLOCK_MAGIC = BLOCKS.register("block_magic",
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_RAW_SHADITE = BLOCKS.register("block_raw_shadite",
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_RAW_GOLD = BLOCKS.register("block_raw_gold",
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_RAW_LUMIN = BLOCKS.register("block_raw_lumin",
        () -> new Block(metalProperties));
                // Processed
    public static final RegistryObject<Block> BLOCK_SMELT_SHADITE = BLOCKS.register("block_smelt_shadite",
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_SMELT_GOLD = BLOCKS.register("block_smelt_gold",
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_SMELT_LUMIN = BLOCKS.register("block_smelt_lumin",
        () -> new Block(metalProperties));
                // Enchanted
    public static final RegistryObject<Block> BLOCK_SMELT_SHADITE_E = BLOCKS.register("block_smelt_shadite_e",
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_SMELT_GOLD_E = BLOCKS.register("block_smelt_gold_e",
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_SMELT_LUMIN_E = BLOCKS.register("block_smelt_lumin_e",
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_END_E = BLOCKS.register("block_end_e",
        () -> new Block(metalProperties));

            // Gems
    public static final RegistryObject<Block> BLOCK_CLUSTER_RUBY = BLOCKS.register("block_cluster_ruby",
        () -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of(Material.AMETHYST)
        .noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel((p_152651_) -> 5).noOcclusion()));
    public static final RegistryObject<Block> BLOCK_BUD_LARGE_RUBY = BLOCKS.register("block_bud_large_ruby",
        () -> new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(BLOCK_CLUSTER_RUBY.get())
        .sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((p_152639_) -> 3).noOcclusion()));
    public static final RegistryObject<Block> BLOCK_BUD_MEDIUM_RUBY = BLOCKS.register("block_bud_medium_ruby",
        () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(BLOCK_CLUSTER_RUBY.get())
        .sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((p_152632_) -> 2).noOcclusion()));
    public static final RegistryObject<Block> BLOCK_BUD_SMALL_RUBY = BLOCKS.register("block_bud_small_ruby",
        () -> new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(BLOCK_CLUSTER_RUBY.get())
        .sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((p_152629_) -> 1).noOcclusion()));
    public static final RegistryObject<Block> BLOCK_CLUSTER_SAPPHIRE = BLOCKS.register("block_cluster_sapphire",
        () -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of(Material.AMETHYST)
        .noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel((p_152651_) -> 5).noOcclusion()));
    public static final RegistryObject<Block> BLOCK_BUD_LARGE_SAPPHIRE = BLOCKS.register("block_bud_large_sapphire",
        () -> new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(BLOCK_CLUSTER_SAPPHIRE.get())
        .sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((p_152639_) -> 3).noOcclusion()));
    public static final RegistryObject<Block> BLOCK_BUD_MEDIUM_SAPPHIRE = BLOCKS.register("block_bud_medium_sapphire",
        () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(BLOCK_CLUSTER_SAPPHIRE.get())
        .sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((p_152632_) -> 2).noOcclusion()));
    public static final RegistryObject<Block> BLOCK_BUD_SMALL_SAPPHIRE = BLOCKS.register("block_bud_small_sapphire",
        () -> new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(BLOCK_CLUSTER_SAPPHIRE.get())
        .sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((p_152629_) -> 1).noOcclusion()));
            // Full blocks
    public static final RegistryObject<Block> BLOCK_CRYSTAL_RUBY = BLOCKS.register("block_crystal_ruby",
        () -> new AmethystBlock(gemProperties));
    public static final RegistryObject<Block> BLOCK_CRYSTAL_SAPPHIRE = BLOCKS.register("block_crystal_sapphire",
        () -> new AmethystBlock(gemProperties));
    public static final RegistryObject<Block> BLOCK_CRYSTAL_RUBY_E = BLOCKS.register("block_crystal_ruby_e",
        () -> new AmethystBlock(gemProperties));
    public static final RegistryObject<Block> BLOCK_CRYSTAL_SAPPHIRE_E = BLOCKS.register("block_crystal_sapphire_e",
        () -> new AmethystBlock(gemProperties));
    public static final RegistryObject<Block> BLOCK_CRYSTAL_AMETHYST_E = BLOCKS.register("block_crystal_amethyst_e",
        () -> new AmethystBlock(gemProperties));
    public static final RegistryObject<Block> BLOCK_GEM_DIAMOND_E = BLOCKS.register("block_gem_diamond_e",
        () -> new Block(gemProperties));
    public static final RegistryObject<Block> BLOCK_GEM_EMERALD_E = BLOCKS.register("block_gem_emerald_e",
        () -> new Block(gemProperties));

    public static final RegistryObject<Block> BLOCK_GEM_ULTIMATE = BLOCKS.register("block_gem_ultimate",
        () -> new Block(gemProperties));
    public static final RegistryObject<Block> BLOCK_INGOT_ULTIMATE = BLOCKS.register("block_ingot_ultimate",
        () -> new Block(metalProperties));

    public static final RegistryObject<BlockInfuser> BLOCK_ENCHANT_INFUSER = BLOCKS.register("block_infuser", BlockInfuser::new);
    public static final RegistryObject<Item> ITEM_BLOCK_ENCHANT_INFUSER = ITEMS.register("block_infuser",
            () -> new BlockItem(BLOCK_ENCHANT_INFUSER.get(), new Item.Properties().tab(bTab)));

        // * * * * * * * * * * * * Temporary * * * * * * * * * * * * \\
    public static final RegistryObject<Block> BLOCK_ORE_RUBY = BLOCKS.register("block_ore_ruby",
        () -> new Block(oreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_DEEP_RUBY = BLOCKS.register("block_ore_deep_ruby",
        () -> new Block(deepOreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_SAPPHIRE = BLOCKS.register("block_ore_sapphire",
        () -> new Block(oreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_DEEP_SAPPHIRE = BLOCKS.register("block_ore_deep_sapphire",
        () -> new Block(deepOreProperties));

    public static final RegistryObject<Item> ITEM_BLOCK_ORE_RUBY = ITEMS.register("block_ore_ruby",
            () -> new BlockItem(BLOCK_ORE_RUBY.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_DEEP_RUBY= ITEMS.register("block_ore_deep_ruby",
            () -> new BlockItem(BLOCK_ORE_DEEP_RUBY.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_SAPPHIRE = ITEMS.register("block_ore_sapphire",
            () -> new BlockItem(BLOCK_ORE_SAPPHIRE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_DEEP_SAPPHIRE = ITEMS.register("block_ore_deep_sapphire",
            () -> new BlockItem(BLOCK_ORE_DEEP_SAPPHIRE.get(), new Item.Properties().tab(bTab)));



        // * * * * * * * * * * * * Block items * * * * * * * * * * * * \\
            // Ores
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_SHADITE = ITEMS.register("block_ore_shadite",
        () -> new BlockItem(BLOCK_ORE_SHADITE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_NETHER_SHADITE = ITEMS.register("block_ore_nether_shadite",
        () -> new BlockItem(BLOCK_ORE_NETHER_SHADITE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_GOLD = ITEMS.register("block_ore_gold",
        () -> new BlockItem(BLOCK_ORE_GOLD.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_LUMIN = ITEMS.register("block_ore_lumin",
        () -> new BlockItem(BLOCK_ORE_LUMIN.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_DEEP_GOLD = ITEMS.register("block_ore_deep_gold",
        () -> new BlockItem(BLOCK_ORE_DEEP_GOLD.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_DEEP_LUMIN = ITEMS.register("block_ore_deep_lumin",
        () -> new BlockItem(BLOCK_ORE_DEEP_LUMIN.get(), new Item.Properties().tab(bTab)));

    public static final RegistryObject<Item> ITEM_BLOCK_ORE_MAGIC = ITEMS.register("block_ore_magic",
        () -> new BlockItemEnchanted(BLOCK_ORE_MAGIC.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_DEEP_MAGIC = ITEMS.register("block_ore_deep_magic",
        () -> new BlockItemEnchanted(BLOCK_ORE_DEEP_MAGIC.get(), new Item.Properties().tab(bTab).rarity(BLUE)));

            // Raw
    public static final RegistryObject<Item> ITEM_BLOCK_RAW_SHADITE = ITEMS.register("block_raw_shadite",
        () -> new BlockItem(BLOCK_RAW_SHADITE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_RAW_GOLD = ITEMS.register("block_raw_gold",
        () -> new BlockItem(BLOCK_RAW_GOLD.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_RAW_LUMIN = ITEMS.register("block_raw_lumin",
        () -> new BlockItem(BLOCK_RAW_LUMIN.get(), new Item.Properties().tab(bTab)));
            // Processed
    public static final RegistryObject<Item> ITEM_BLOCK_MAGIC = ITEMS.register("block_magic",
        () -> new BlockItemEnchanted(BLOCK_MAGIC.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_SMELT_SHADITE = ITEMS.register("block_smelt_shadite",
        () -> new BlockItem(BLOCK_SMELT_SHADITE.get(), new Item.Properties().tab(bTab).rarity(GREEN)));
    public static final RegistryObject<Item> ITEM_BLOCK_SMELT_GOLD = ITEMS.register("block_smelt_gold",
        () -> new BlockItem(BLOCK_SMELT_GOLD.get(), new Item.Properties().tab(bTab).rarity(GREEN)));
    public static final RegistryObject<Item> ITEM_BLOCK_SMELT_LUMIN = ITEMS.register("block_smelt_lumin",
        () -> new BlockItem(BLOCK_SMELT_LUMIN.get(), new Item.Properties().tab(bTab).rarity(GREEN)));
            // Enchanted
    public static final RegistryObject<Item> ITEM_BLOCK_SMELT_SHADITE_E = ITEMS.register("block_smelt_shadite_e",
        () -> new BlockItemEnchanted(BLOCK_SMELT_SHADITE_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_SMELT_GOLD_E = ITEMS.register("block_smelt_gold_e",
        () -> new BlockItemEnchanted(BLOCK_SMELT_GOLD_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_SMELT_LUMIN_E = ITEMS.register("block_smelt_lumin_e",
        () -> new BlockItemEnchanted(BLOCK_SMELT_LUMIN_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_END_E = ITEMS.register("block_end_e",
        () -> new BlockItemEnchanted(BLOCK_END_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));

            // Gems
    public static final RegistryObject<Item> ITEM_BLOCK_CLUSTER_RUBY = ITEMS.register("block_cluster_ruby",
        () -> new BlockItem(BLOCK_CLUSTER_RUBY.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_BUD_LARGE_RUBY = ITEMS.register("block_bud_large_ruby",
        () -> new BlockItem(BLOCK_BUD_LARGE_RUBY.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_BUD_MEDIUM_RUBY = ITEMS.register("block_bud_medium_ruby",
        () -> new BlockItem(BLOCK_BUD_MEDIUM_RUBY.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_BUD_SMALL_RUBY = ITEMS.register("block_bud_small_ruby",
        () -> new BlockItem(BLOCK_BUD_SMALL_RUBY.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_CLUSTER_SAPPHIRE = ITEMS.register("block_cluster_sapphire",
        () -> new BlockItem(BLOCK_CLUSTER_SAPPHIRE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_BUD_LARGE_SAPPHIRE = ITEMS.register("block_bud_large_sapphire",
        () -> new BlockItem(BLOCK_BUD_LARGE_SAPPHIRE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_BUD_MEDIUM_SAPPHIRE = ITEMS.register("block_bud_medium_sapphire",
        () -> new BlockItem(BLOCK_BUD_MEDIUM_SAPPHIRE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_BUD_SMALL_SAPPHIRE = ITEMS.register("block_bud_small_sapphire",
        () -> new BlockItem(BLOCK_BUD_SMALL_SAPPHIRE.get(), new Item.Properties().tab(bTab)));
                // Full blocks
    public static final RegistryObject<Item> ITEM_BLOCK_CRYSTAL_RUBY = ITEMS.register("block_crystal_ruby",
        () -> new BlockItem(BLOCK_CRYSTAL_RUBY.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_CRYSTAL_SAPPHIRE = ITEMS.register("block_crystal_sapphire",
        () -> new BlockItem(BLOCK_CRYSTAL_SAPPHIRE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_CRYSTAL_RUBY_E = ITEMS.register("block_crystal_ruby_e",
        () -> new BlockItemEnchanted(BLOCK_CRYSTAL_RUBY_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_CRYSTAL_SAPPHIRE_E = ITEMS.register("block_crystal_sapphire_e",
        () -> new BlockItemEnchanted(BLOCK_CRYSTAL_SAPPHIRE_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_CRYSTAL_AMETHYST_E = ITEMS.register("block_crystal_amethyst_e",
        () -> new BlockItemEnchanted(BLOCK_CRYSTAL_AMETHYST_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_GEM_DIAMOND_E = ITEMS.register("block_gem_diamond_e",
        () -> new BlockItemEnchanted(BLOCK_GEM_DIAMOND_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_GEM_EMERALD_E = ITEMS.register("block_gem_emerald_e",
        () -> new BlockItemEnchanted(BLOCK_GEM_EMERALD_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));

    public static final RegistryObject<Item> ITEM_BLOCK_GEM_ULTIMATE = ITEMS.register("block_gem_ultimate",
        () -> new BlockItemEnchanted(BLOCK_GEM_ULTIMATE.get(), new Item.Properties().tab(bTab).rarity(GOLD)));
    public static final RegistryObject<Item> ITEM_BLOCK_INGOT_ULTIMATE = ITEMS.register("block_ingot_ultimate",
        () -> new BlockItemEnchanted(BLOCK_INGOT_ULTIMATE.get(), new Item.Properties().tab(bTab).rarity(GOLD)));


}
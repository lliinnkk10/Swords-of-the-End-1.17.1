package com.github.atheera.swordsoftheend.inits;

import com.github.atheera.swordsoftheend.materials.Rarities;
import com.github.atheera.swordsoftheend.objects.blocks.BlockEnchanter;
import com.github.atheera.swordsoftheend.objects.blocks.BlockInfuser;
import com.github.atheera.swordsoftheend.objects.blocks.BlockItemEnchanted;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.github.atheera.swordsoftheend.utils.Constantz.*;
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
                         .sound(SoundType.STONE).requiresCorrectToolForDrops();
    private static final BlockBehaviour.Properties deepOreProperties = BlockBehaviour.Properties.of(Material.STONE).strength(4.5f, 3.0f)
                         .sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops();
    private static final BlockBehaviour.Properties metalProperties = BlockBehaviour.Properties.of(Material.METAL).strength(3.0f, 6.0f)
                         .sound(SoundType.METAL).requiresCorrectToolForDrops();
    private static final BlockBehaviour.Properties gemProperties = BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_PURPLE)
                         .strength(1.0f).sound(SoundType.AMETHYST).requiresCorrectToolForDrops();
    // Create

        // * * * * * * * * * * * * Blocks * * * * * * * * * * * * \\

            // * * * * * * * * * * * * Ores * * * * * * * * * * * * \\
    public static final RegistryObject<Block> BLOCK_ORE_SHADITE = BLOCKS.register(ORE_SHADITE,
        () -> new Block(oreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_NETHER_SHADITE = BLOCKS.register(ORE_NETHER_SHADITE,
        () -> new Block(oreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_GOLD = BLOCKS.register(ORE_GOLD,
        () -> new Block(oreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_DEEP_GOLD = BLOCKS.register(ORE_GOLD_DEEP,
        () -> new Block(deepOreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_LUMIN = BLOCKS.register(ORE_LUMIN,
        () -> new Block(oreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_DEEP_LUMIN = BLOCKS.register(ORE_LUMIN_DEEP,
        () -> new Block(deepOreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_MAGIC = BLOCKS.register(ORE_MAGIC,
        () -> new Block(oreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_DEEP_MAGIC = BLOCKS.register(ORE_MAGIC_DEEP,
        () -> new Block(deepOreProperties));
                // * * * * * * * * * * * * Raw * * * * * * * * * * * * \\
    public static final RegistryObject<Block> BLOCK_RAW_SHADITE = BLOCKS.register(RAW_SHADITE,
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_RAW_GOLD = BLOCKS.register(RAW_GOLD,
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_RAW_LUMIN = BLOCKS.register(RAW_LUMIN,
        () -> new Block(metalProperties));
                // * * * * * * * * * * * * Compressed * * * * * * * * * * * * \\
    public static final RegistryObject<Block> BLOCK_MAGIC = BLOCKS.register(MAGIC,
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_SMELT_SHADITE = BLOCKS.register(SMELT_SHADITE,
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_SMELT_GOLD = BLOCKS.register(SMELT_GOLD,
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_SMELT_LUMIN = BLOCKS.register(SMELT_LUMIN,
        () -> new Block(metalProperties));
                // * * * * * * * * * * * * Compressed And Enchanted * * * * * * * * * * * * \\
    public static final RegistryObject<Block> BLOCK_SMELT_SHADITE_E = BLOCKS.register(SMELT_SHADITE_E,
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_SMELT_GOLD_E = BLOCKS.register(SMELT_GOLD_E,
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_SMELT_LUMIN_E = BLOCKS.register(SMELT_LUMIN_E,
        () -> new Block(metalProperties));
    public static final RegistryObject<Block> BLOCK_END_E = BLOCKS.register(END_E,
        () -> new Block(metalProperties));

        // * * * * * * * * * * * * Gems * * * * * * * * * * * * \\
    public static final RegistryObject<Block> BLOCK_CLUSTER_RUBY = BLOCKS.register(CLUSTER_RUBY,
        () -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of(Material.AMETHYST)
        .noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel((p_152651_) -> 5).noOcclusion()));
    public static final RegistryObject<Block> BLOCK_BUD_LARGE_RUBY = BLOCKS.register(BUD_LARGE_RUBY,
        () -> new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(BLOCK_CLUSTER_RUBY.get())
        .sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((p_152639_) -> 3).noOcclusion()));
    public static final RegistryObject<Block> BLOCK_BUD_MEDIUM_RUBY = BLOCKS.register(BUD_MEDIUM_RUBY,
        () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(BLOCK_CLUSTER_RUBY.get())
        .sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((p_152632_) -> 2).noOcclusion()));
    public static final RegistryObject<Block> BLOCK_BUD_SMALL_RUBY = BLOCKS.register(BUD_SMALL_RUBY,
        () -> new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(BLOCK_CLUSTER_RUBY.get())
        .sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((p_152629_) -> 1).noOcclusion()));
    public static final RegistryObject<Block> BLOCK_CLUSTER_SAPPHIRE = BLOCKS.register(CLUSTER_SAPPHIRE,
        () -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of(Material.AMETHYST)
        .noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5f).lightLevel((p_152651_) -> 5).noOcclusion()));
    public static final RegistryObject<Block> BLOCK_BUD_LARGE_SAPPHIRE = BLOCKS.register(BUD_LARGE_SAPPHIRE,
        () -> new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(BLOCK_CLUSTER_SAPPHIRE.get())
        .sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((p_152639_) -> 3).noOcclusion()));
    public static final RegistryObject<Block> BLOCK_BUD_MEDIUM_SAPPHIRE = BLOCKS.register(BUD_MEDIUM_SAPPHIRE,
        () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(BLOCK_CLUSTER_SAPPHIRE.get())
        .sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((p_152632_) -> 2).noOcclusion()));
    public static final RegistryObject<Block> BLOCK_BUD_SMALL_SAPPHIRE = BLOCKS.register(BUD_SMALL_SAPPHIRE,
        () -> new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(BLOCK_CLUSTER_SAPPHIRE.get())
        .sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((p_152629_) -> 1).noOcclusion()));

        // * * * * * * * * * * * * Compressed Blocks * * * * * * * * * * * * \\
    public static final RegistryObject<Block> BLOCK_CRYSTAL_RUBY = BLOCKS.register(B_CRYSTAL_RUBY,
        () -> new AmethystBlock(gemProperties));
    public static final RegistryObject<Block> BLOCK_CRYSTAL_SAPPHIRE = BLOCKS.register(B_CRYSTAL_SAPPHIRE,
        () -> new AmethystBlock(gemProperties));
    public static final RegistryObject<Block> BLOCK_CRYSTAL_RUBY_E = BLOCKS.register(B_CRYSTAL_RUBY_E,
        () -> new AmethystBlock(gemProperties));
    public static final RegistryObject<Block> BLOCK_CRYSTAL_SAPPHIRE_E = BLOCKS.register(B_CRYSTAL_SAPPHIRE_E,
        () -> new AmethystBlock(gemProperties));
    public static final RegistryObject<Block> BLOCK_CRYSTAL_AMETHYST_E = BLOCKS.register(B_CRYSTAL_AMETHYST_E,
        () -> new AmethystBlock(gemProperties));
    public static final RegistryObject<Block> BLOCK_GEM_DIAMOND_E = BLOCKS.register(B_GEM_DIAMOND_E,
        () -> new Block(gemProperties));
    public static final RegistryObject<Block> BLOCK_GEM_EMERALD_E = BLOCKS.register(B_GEM_EMERALD_E,
        () -> new Block(gemProperties));
    public static final RegistryObject<Block> BLOCK_GEM_ULTIMATE = BLOCKS.register(GEM_ULTIMATE_E,
        () -> new Block(gemProperties));
    public static final RegistryObject<Block> BLOCK_INGOT_ULTIMATE = BLOCKS.register(INGOT_ULTIMATE_E,
        () -> new Block(metalProperties));

        // * * * * * * * * * * * * Functionality Blocks * * * * * * * * * * * * \\
    public static final RegistryObject<BlockInfuser> BLOCK_ENCHANT_INFUSER_GENERATOR = BLOCKS.register(ENCHANT_INFUSER_GENERATOR, BlockInfuser::new);
    public static final RegistryObject<BlockEnchanter> BLOCK_ENCHANT_INFUSER = BLOCKS.register(ENCHANT_INFUSER, BlockEnchanter::new);

        // * * * * * * * * * * * * Temporary Gem Ores * * * * * * * * * * * * \\
    public static final RegistryObject<Block> BLOCK_ORE_RUBY = BLOCKS.register(ORE_RUBY,
        () -> new Block(oreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_DEEP_RUBY = BLOCKS.register(ORE_DEEP_RUBY,
        () -> new Block(deepOreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_SAPPHIRE = BLOCKS.register(ORE_SAPPHIRE,
        () -> new Block(oreProperties));
    public static final RegistryObject<Block> BLOCK_ORE_DEEP_SAPPHIRE = BLOCKS.register(ORE_DEEP_SAPPHIRE,
        () -> new Block(deepOreProperties));

    public static final RegistryObject<Item> ITEM_BLOCK_ORE_RUBY = ITEMS.register(ORE_RUBY,
        () -> new BlockItem(BLOCK_ORE_RUBY.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_DEEP_RUBY= ITEMS.register(ORE_DEEP_RUBY,
            () -> new BlockItem(BLOCK_ORE_DEEP_RUBY.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_SAPPHIRE = ITEMS.register(ORE_SAPPHIRE,
        () -> new BlockItem(BLOCK_ORE_SAPPHIRE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_DEEP_SAPPHIRE = ITEMS.register(ORE_DEEP_SAPPHIRE,
        () -> new BlockItem(BLOCK_ORE_DEEP_SAPPHIRE.get(), new Item.Properties().tab(bTab)));

        // * * * * * * * * * * * * Block items * * * * * * * * * * * * \\
            // * * * * * * * * * * * * Ores * * * * * * * * * * * * \\
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_SHADITE = ITEMS.register(ORE_SHADITE,
        () -> new BlockItem(BLOCK_ORE_SHADITE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_NETHER_SHADITE = ITEMS.register(ORE_NETHER_SHADITE,
        () -> new BlockItem(BLOCK_ORE_NETHER_SHADITE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_GOLD = ITEMS.register(ORE_GOLD,
        () -> new BlockItem(BLOCK_ORE_GOLD.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_DEEP_GOLD = ITEMS.register(ORE_GOLD_DEEP,
        () -> new BlockItem(BLOCK_ORE_DEEP_GOLD.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_LUMIN = ITEMS.register(ORE_LUMIN,
        () -> new BlockItem(BLOCK_ORE_LUMIN.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_DEEP_LUMIN = ITEMS.register(ORE_LUMIN_DEEP,
        () -> new BlockItem(BLOCK_ORE_DEEP_LUMIN.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_MAGIC = ITEMS.register(ORE_MAGIC,
        () -> new BlockItemEnchanted(BLOCK_ORE_MAGIC.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_DEEP_MAGIC = ITEMS.register(ORE_MAGIC_DEEP,
        () -> new BlockItemEnchanted(BLOCK_ORE_DEEP_MAGIC.get(), new Item.Properties().tab(bTab).rarity(BLUE)));

            // * * * * * * * * * * * * Raw * * * * * * * * * * * * \\
    public static final RegistryObject<Item> ITEM_BLOCK_RAW_SHADITE = ITEMS.register(RAW_SHADITE,
        () -> new BlockItem(BLOCK_RAW_SHADITE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_RAW_GOLD = ITEMS.register(RAW_GOLD,
        () -> new BlockItem(BLOCK_RAW_GOLD.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_RAW_LUMIN = ITEMS.register(RAW_LUMIN,
        () -> new BlockItem(BLOCK_RAW_LUMIN.get(), new Item.Properties().tab(bTab)));
            // * * * * * * * * * * * * Compressed * * * * * * * * * * * * \\
    public static final RegistryObject<Item> ITEM_BLOCK_MAGIC = ITEMS.register(MAGIC,
        () -> new BlockItemEnchanted(BLOCK_MAGIC.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_SMELT_SHADITE = ITEMS.register(SMELT_SHADITE,
        () -> new BlockItem(BLOCK_SMELT_SHADITE.get(), new Item.Properties().tab(bTab).rarity(GREEN)));
    public static final RegistryObject<Item> ITEM_BLOCK_SMELT_GOLD = ITEMS.register(SMELT_GOLD,
        () -> new BlockItem(BLOCK_SMELT_GOLD.get(), new Item.Properties().tab(bTab).rarity(GREEN)));
    public static final RegistryObject<Item> ITEM_BLOCK_SMELT_LUMIN = ITEMS.register(SMELT_LUMIN,
        () -> new BlockItem(BLOCK_SMELT_LUMIN.get(), new Item.Properties().tab(bTab).rarity(GREEN)));
            // * * * * * * * * * * * * Compressed And Enchanted * * * * * * * * * * * * \\
    public static final RegistryObject<Item> ITEM_BLOCK_SMELT_SHADITE_E = ITEMS.register(SMELT_SHADITE_E,
        () -> new BlockItemEnchanted(BLOCK_SMELT_SHADITE_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_SMELT_GOLD_E = ITEMS.register(SMELT_GOLD_E,
        () -> new BlockItemEnchanted(BLOCK_SMELT_GOLD_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_SMELT_LUMIN_E = ITEMS.register(SMELT_LUMIN_E,
        () -> new BlockItemEnchanted(BLOCK_SMELT_LUMIN_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_END_E = ITEMS.register(END_E,
        () -> new BlockItemEnchanted(BLOCK_END_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));

            // * * * * * * * * * * * * Gems * * * * * * * * * * * * \\
    public static final RegistryObject<Item> ITEM_BLOCK_CLUSTER_RUBY = ITEMS.register(CLUSTER_RUBY,
        () -> new BlockItem(BLOCK_CLUSTER_RUBY.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_BUD_LARGE_RUBY = ITEMS.register(BUD_LARGE_RUBY,
        () -> new BlockItem(BLOCK_BUD_LARGE_RUBY.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_BUD_MEDIUM_RUBY = ITEMS.register(BUD_MEDIUM_RUBY,
        () -> new BlockItem(BLOCK_BUD_MEDIUM_RUBY.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_BUD_SMALL_RUBY = ITEMS.register(BUD_SMALL_RUBY,
        () -> new BlockItem(BLOCK_BUD_SMALL_RUBY.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_CLUSTER_SAPPHIRE = ITEMS.register(CLUSTER_SAPPHIRE,
        () -> new BlockItem(BLOCK_CLUSTER_SAPPHIRE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_BUD_LARGE_SAPPHIRE = ITEMS.register(BUD_LARGE_SAPPHIRE,
        () -> new BlockItem(BLOCK_BUD_LARGE_SAPPHIRE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_BUD_MEDIUM_SAPPHIRE = ITEMS.register(BUD_MEDIUM_SAPPHIRE,
        () -> new BlockItem(BLOCK_BUD_MEDIUM_SAPPHIRE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_BUD_SMALL_SAPPHIRE = ITEMS.register(BUD_SMALL_SAPPHIRE,
        () -> new BlockItem(BLOCK_BUD_SMALL_SAPPHIRE.get(), new Item.Properties().tab(bTab)));
            // * * * * * * * * * * * * Compressed Blocks * * * * * * * * * * * * \\
    public static final RegistryObject<Item> ITEM_BLOCK_CRYSTAL_RUBY = ITEMS.register(B_CRYSTAL_RUBY,
        () -> new BlockItem(BLOCK_CRYSTAL_RUBY.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_CRYSTAL_SAPPHIRE = ITEMS.register(B_CRYSTAL_SAPPHIRE,
        () -> new BlockItem(BLOCK_CRYSTAL_SAPPHIRE.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_CRYSTAL_RUBY_E = ITEMS.register(B_CRYSTAL_RUBY_E,
        () -> new BlockItemEnchanted(BLOCK_CRYSTAL_RUBY_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_CRYSTAL_SAPPHIRE_E = ITEMS.register(B_CRYSTAL_SAPPHIRE_E,
        () -> new BlockItemEnchanted(BLOCK_CRYSTAL_SAPPHIRE_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_CRYSTAL_AMETHYST_E = ITEMS.register(B_CRYSTAL_AMETHYST_E,
        () -> new BlockItemEnchanted(BLOCK_CRYSTAL_AMETHYST_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_GEM_DIAMOND_E = ITEMS.register(B_GEM_DIAMOND_E,
        () -> new BlockItemEnchanted(BLOCK_GEM_DIAMOND_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_GEM_EMERALD_E = ITEMS.register(B_GEM_EMERALD_E,
        () -> new BlockItemEnchanted(BLOCK_GEM_EMERALD_E.get(), new Item.Properties().tab(bTab).rarity(BLUE)));
    public static final RegistryObject<Item> ITEM_BLOCK_GEM_ULTIMATE = ITEMS.register(GEM_ULTIMATE_E,
        () -> new BlockItemEnchanted(BLOCK_GEM_ULTIMATE.get(), new Item.Properties().tab(bTab).rarity(GOLD)));
    public static final RegistryObject<Item> ITEM_BLOCK_INGOT_ULTIMATE = ITEMS.register(INGOT_ULTIMATE_E,
        () -> new BlockItemEnchanted(BLOCK_INGOT_ULTIMATE.get(), new Item.Properties().tab(bTab).rarity(GOLD)));

        // * * * * * * * * * * * * Functionality Blocks * * * * * * * * * * * * \\
    public static final RegistryObject<Item> ITEM_BLOCK_ENCHANT_INFUSER_GENERATOR = ITEMS.register(ENCHANT_INFUSER_GENERATOR,
            () -> new BlockItem(BLOCK_ENCHANT_INFUSER_GENERATOR.get(), new Item.Properties().tab(bTab)));
    public static final RegistryObject<Item> ITEM_BLOCK_ENCHANT_INFUSER = ITEMS.register(ENCHANT_INFUSER,
            () -> new BlockItem(BLOCK_ENCHANT_INFUSER.get(), new Item.Properties().tab(bTab)));

}
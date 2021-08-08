package com.github.atheera.swordsoftheend.inits;

import com.github.atheera.swordsoftheend.SOTE;
import com.github.atheera.swordsoftheend.materials.ModToolTier;
import com.github.atheera.swordsoftheend.materials.Rarities;

import com.github.atheera.swordsoftheend.objects.items.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Locale;

public class ItemInit {

	// Initiate
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SOTE.MOD_ID);
	private static final CreativeModeTab iTab = CreativeTabInit.SOTE_I_CMT;
	private static final CreativeModeTab sTab = CreativeTabInit.SOTE_S_CMT;
	private static final Rarity GOLD = Rarities.GOLD;
	private static final Rarity PURP = Rarities.PURPLE;
	private static final Rarity BLUE = Rarities.BLUE;
	private static final Rarity GREEN = Rarities.GREEN;

	// Create
		// Ingots
	public static final RegistryObject<Item> ITEM_INGOT_GOLD = ITEMS.register("item_ingot_gold",
		() -> new Item(new Item.Properties().tab(iTab).rarity(GREEN)));
	public static final RegistryObject<Item> ITEM_INGOT_LUMIN = ITEMS.register("item_ingot_lumin",
		() -> new Item(new Item.Properties().tab(iTab).rarity(GREEN)));
	public static final RegistryObject<Item> ITEM_INGOT_SHADITE = ITEMS.register("item_ingot_shadite",
		() -> new Item(new Item.Properties().tab(iTab).rarity(GREEN)));
			// Raw
	public static final RegistryObject<Item> ITEM_INGOT_GOLD_R = ITEMS.register("item_ingot_gold_r",
		() -> new Item(new Item.Properties().tab(iTab)));
	public static final RegistryObject<Item> ITEM_INGOT_LUMIN_R = ITEMS.register("item_ingot_lumin_r",
		() -> new Item(new Item.Properties().tab(iTab)));
	public static final RegistryObject<Item> ITEM_INGOT_SHADITE_R = ITEMS.register("item_ingot_shadite_r",
		() -> new Item(new Item.Properties().tab(iTab)));
			// Enchanted
	public static final RegistryObject<Item> ITEM_INGOT_GOLD_E = ITEMS.register("item_ingot_gold_e",
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_INGOT_LUMIN_E = ITEMS.register("item_ingot_lumin_e",
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_INGOT_SHADITE_E = ITEMS.register("item_ingot_shadite_e",
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(BLUE)));
		// Gems
	public static final RegistryObject<Item> ITEM_GEM_AMETHYST = ITEMS.register("item_gem_amethyst",
		() -> new Item(new Item.Properties().tab(iTab).rarity(GREEN)));
	public static final RegistryObject<Item> ITEM_GEM_RUBY = ITEMS.register("item_gem_ruby",
		() -> new Item(new Item.Properties().tab(iTab).rarity(GREEN)));
	public static final RegistryObject<Item> ITEM_GEM_SAPPHIRE = ITEMS.register("item_gem_sapphire",
		() -> new Item(new Item.Properties().tab(iTab).rarity(GREEN)));
			// Shards
	public static final RegistryObject<Item> ITEM_GEM_RUBY_S = ITEMS.register("item_shard_ruby",
		() -> new Item(new Item.Properties().tab(iTab)));
	public static final RegistryObject<Item> ITEM_GEM_SAPPHIRE_S = ITEMS.register("item_shard_sapphire",
		() -> new Item(new Item.Properties().tab(iTab)));
			// Enchanted
	public static final RegistryObject<Item> ITEM_DUST_MAGIC_E = ITEMS.register("item_dust_magic",
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<ItemEnchanted> ITEM_GEM_AMETHYST_E = ITEMS.register("item_gem_amethyst_e",
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<ItemEnchanted> ITEM_GEM_RUBY_E = ITEMS.register("item_gem_ruby_e",
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<ItemEnchanted> ITEM_GEM_SAPPHIRE_E = ITEMS.register("item_gem_sapphire_e",
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<ItemEnchanted> ITEM_GEM_DIAMOND_E = ITEMS.register("item_gem_diamond_e",
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<ItemEnchanted> ITEM_GEM_EMERALD_E = ITEMS.register("item_gem_emerald_e",
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(BLUE)));
	
		// Crafting
			// Cores
	public static final RegistryObject<Item> ITEM_CORE_BASE = ITEMS.register("item_core_base",
		() -> new Item(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_CORE_AMETHYST = ITEMS.register("item_core_amethyst",
		() -> new ItemCore(new Item.Properties().tab(iTab).rarity(PURP)));
	public static final RegistryObject<Item> ITEM_CORE_DIAMOND = ITEMS.register("item_core_diamond",
		() -> new ItemCore(new Item.Properties().tab(iTab).rarity(PURP)));
	public static final RegistryObject<Item> ITEM_CORE_EMERALD = ITEMS.register("item_core_emerald",
		() -> new ItemCore(new Item.Properties().tab(iTab).rarity(PURP)));
	public static final RegistryObject<Item> ITEM_CORE_END = ITEMS.register("item_core_end",
		() -> new ItemCore(new Item.Properties().tab(iTab).rarity(PURP)));
	public static final RegistryObject<Item> ITEM_CORE_LEVEL = ITEMS.register("item_core_level",
		() -> new ItemCore(new Item.Properties().tab(iTab).rarity(PURP)));
	public static final RegistryObject<Item> ITEM_CORE_LUMIN = ITEMS.register("item_core_lumin",
		() -> new ItemCore(new Item.Properties().tab(iTab).rarity(PURP)));
	public static final RegistryObject<Item> ITEM_CORE_MASTER = ITEMS.register("item_core_master",
		() -> new ItemCore(new Item.Properties().tab(iTab).rarity(PURP)));
	public static final RegistryObject<Item> ITEM_CORE_RUBY = ITEMS.register("item_core_ruby",
		() -> new ItemCore(new Item.Properties().tab(iTab).rarity(PURP)));
	public static final RegistryObject<Item> ITEM_CORE_SAPPHIRE = ITEMS.register("item_core_sapphire",
		() -> new ItemCore(new Item.Properties().tab(iTab).rarity(PURP)));
	public static final RegistryObject<Item> ITEM_CORE_SHADITE = ITEMS.register("item_core_shadite",
		() -> new ItemCore(new Item.Properties().tab(iTab).rarity(PURP)));
	public static final RegistryObject<Item> ITEM_CORE_THUNDER = ITEMS.register("item_core_thunder",
		() -> new ItemCore(new Item.Properties().tab(iTab).rarity(PURP)));
	public static final RegistryObject<Item> ITEM_CORE_ULTIMATE = ITEMS.register("item_core_ultimate",
		() -> new ItemCore(new Item.Properties().tab(iTab).rarity(PURP)));

		// Tier 1
	public static final RegistryObject<Item> ITEM_TIER_AMETHYST = ITEMS.register("item_tier1_amethyst",
		() -> new Item(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_DIAMOND = ITEMS.register("item_tier_diamond",
		() -> new Item(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_EMERALD = ITEMS.register("item_tier_emerald",
		() -> new Item(new Item.Properties().tab(iTab).rarity(BLUE).stacksTo(1)));
	public static final RegistryObject<Item> ITEM_TIER_END = ITEMS.register("item_tier_end",
		() -> new ItemEnderpearlEnchanted(new Item.Properties().tab(iTab).rarity(BLUE).stacksTo(16)));
	public static final RegistryObject<Item> ITEM_TIER_EXP = ITEMS.register("item_tier_exp",
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(BLUE).stacksTo(1)));
	public static final RegistryObject<Item> ITEM_TIER_GOLDROD = ITEMS.register("item_tier_goldrod",
		() -> new Item(new Item.Properties().tab(iTab).rarity(GREEN)));
	public static final RegistryObject<Item> ITEM_TIER_THUNDER = ITEMS.register("item_tier_thunder",
		() -> new ItemTier(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_LUMIN = ITEMS.register("item_tier_lumin",
		() -> new Item(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_RUBY = ITEMS.register("item_tier_ruby",
		() -> new ItemMagmaball(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_SAPPHIRE = ITEMS.register("item_tier_sapphire",
		() -> new Item(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_SHADITE = ITEMS.register("item_tier_shadite",
		() -> new Item(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_TF_POWER = ITEMS.register("item_tier_tf_power",
		() -> new ItemTF(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_TF_WISDOM = ITEMS.register("item_tier_tf_wisdom",
		() -> new ItemTF(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_TF_COURAGE = ITEMS.register("item_tier_tf_courage",
		() -> new ItemTF(new Item.Properties().tab(iTab).rarity(BLUE)));
		// Tier 2
	public static final RegistryObject<Item> ITEM_TIER2_AMETHYST = ITEMS.register("item_tier_amethyst",
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(PURP)));
	public static final RegistryObject<Item> ITEM_TIER2_END = ITEMS.register("item_tier2_end",
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(PURP)));
	public static final RegistryObject<Item> ITEM_TIER2_EXP = ITEMS.register("item_tier2_exp",
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(PURP).stacksTo(1)));
	public static final RegistryObject<Item> ITEM_TIER2_THUNDER = ITEMS.register("item_tier2_thunder",
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(PURP)));

		// Potions
	public static final RegistryObject<Item> ITEM_POTION_STRENGTH = ITEMS.register("item_potion_strength",
		() -> new ItemPotion(new Item.Properties().tab(iTab).rarity(PURP).stacksTo(1)));
	public static final RegistryObject<Item> ITEM_POTION_SWIFTNESS = ITEMS.register("item_potion_swiftness",
		() -> new ItemPotion(new Item.Properties().tab(iTab).rarity(PURP).stacksTo(1)));
	public static final RegistryObject<Item> ITEM_POTION_JUMP = ITEMS.register("item_potion_jump",
		() -> new ItemPotion(new Item.Properties().tab(iTab).rarity(PURP).stacksTo(1)));
	public static final RegistryObject<Item> ITEM_POTION_WATER = ITEMS.register("item_potion_water",
		() -> new ItemPotion(new Item.Properties().tab(iTab).rarity(PURP).stacksTo(1)));
	public static final RegistryObject<Item> ITEM_POTION_SLOW = ITEMS.register("item_potion_slow",
		() -> new ItemPotion(new Item.Properties().tab(iTab).rarity(PURP).stacksTo(1)));
	public static final RegistryObject<Item> ITEM_POTION_DAMAGE = ITEMS.register("item_potion_damage",
		() -> new ItemPotion(new Item.Properties().tab(iTab).rarity(PURP).stacksTo(1)));
	public static final RegistryObject<Item> ITEM_POTION_POISON = ITEMS.register("item_potion_poison",
		() -> new ItemPotion(new Item.Properties().tab(iTab).rarity(PURP).stacksTo(1)));
	public static final RegistryObject<Item> ITEM_POTION_FALLING = ITEMS.register("item_potion_falling",
		() -> new ItemPotion(new Item.Properties().tab(iTab).rarity(PURP).stacksTo(1)));

		// Swords
	//public static final RegistryObject<ItemToolChisel> ITEM_TOOL_CHISEL = ITEMS.register("item_tool_chisel", () -> new ItemToolChisel(new Item.Properties().tab(sTab).rarity(BLUE)));
	public static final RegistryObject<ItemSwordBase> ITEM_SWORD_BASE = ITEMS.register("item_sword_base",
		() -> new ItemSwordBase(ModToolTier.BASE, 8, -2.4f, new Item.Properties().tab(sTab).rarity(Rarities.PURPLE)));
	public static final RegistryObject<ItemSwordAmethyst> ITEM_SWORD_AMETHYST = ITEMS.register("item_sword_amethyst",
		() -> new ItemSwordAmethyst(ModToolTier.TIERONE, 13, -2.0f, new Item.Properties().tab(sTab).rarity(GOLD)));
	public static final RegistryObject<ItemSwordDiamond> ITEM_SWORD_DIAMOND = ITEMS.register("item_sword_diamond",
		() -> new ItemSwordDiamond(ModToolTier.TIERONE, 11, -1.4f, new Item.Properties().tab(sTab).rarity(GOLD)));
	public static final RegistryObject<ItemSwordEmerald> ITEM_SWORD_EMERALD = ITEMS.register("item_sword_emerald",
		() -> new ItemSwordEmerald(ModToolTier.TIERONE, 16, -1.8f, new Item.Properties().tab(sTab).rarity(GOLD)));
	public static final RegistryObject<ItemSwordEnd> ITEM_SWORD_END = ITEMS.register("item_sword_end",
		() -> new ItemSwordEnd(ModToolTier.TIERONE, 13, -2.4f, new Item.Properties().tab(sTab).rarity(GOLD)));
	public static final RegistryObject<ItemSwordLevel> ITEM_SWORD_LEVEL = ITEMS.register("item_sword_level",
		() -> new ItemSwordLevel(ModToolTier.TIERTWO, 0, -2.4f, new Item.Properties().tab(sTab)));
	public static final RegistryObject<ItemSwordLumin> ITEM_SWORD_LUMIN = ITEMS.register("item_sword_lumin",
		() -> new ItemSwordLumin(ModToolTier.TIERONE, 11, -1.6f, new Item.Properties().tab(sTab).rarity(GOLD)));
	public static final RegistryObject<ItemSwordMaster> ITEM_SWORD_MASTER = ITEMS.register("item_sword_master",
		() -> new ItemSwordMaster(ModToolTier.TIERONE, 0, -2.4f, new Item.Properties().tab(sTab).rarity(GOLD)));
	public static final RegistryObject<ItemSwordRuby> ITEM_SWORD_RUBY = ITEMS.register("item_sword_ruby",
		() -> new ItemSwordRuby(ModToolTier.TIERONE, 14, -2.4f, new Item.Properties().tab(sTab).rarity(GOLD)));
	public static final RegistryObject<ItemSwordSapphire> ITEM_SWORD_SAPPHIRE = ITEMS.register("item_sword_sapphire",
		() -> new ItemSwordSapphire(ModToolTier.TIERONE, 12, -2.2f, new Item.Properties().tab(sTab).rarity(GOLD)));
	public static final RegistryObject<ItemSwordShadite> ITEM_SWORD_SHADITE = ITEMS.register("item_sword_shadite",
		() -> new ItemSwordShadite(ModToolTier.TIERONE, 9, -1.2f, new Item.Properties().tab(sTab).rarity(GOLD)));
	public static final RegistryObject<ItemSwordThunder> ITEM_SWORD_THUNDER = ITEMS.register("item_sword_thunder",
		() -> new ItemSwordThunder(ModToolTier.TIERONE, 19, -2.8f, new Item.Properties().tab(sTab).rarity(GOLD)));
	public static final RegistryObject<ItemSwordUltimate> ITEM_SWORD_ULTIMATE = ITEMS.register("item_sword_ultimate",
		() -> new ItemSwordUltimate(ModToolTier.TIERONE, 24, -2.0f, new Item.Properties().tab(sTab).rarity(GOLD)));
}
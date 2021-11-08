package com.github.atheera.swordsoftheend.inits;

import com.github.atheera.swordsoftheend.SOTE;
import com.github.atheera.swordsoftheend.materials.ModToolTier;
import com.github.atheera.swordsoftheend.materials.Rarities;
import com.github.atheera.swordsoftheend.objects.items.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.github.atheera.swordsoftheend.utils.Constantz.*;

public class ItemInit {

	private ItemInit() {}

// * * * * * * * * * * * * Initiate Variables * * * * * * * * * * * * \\
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SOTE.MOD_ID);
	private static final CreativeModeTab iTab = CreativeTabInit.SOTE_I_CMT;
	private static final CreativeModeTab sTab = CreativeTabInit.SOTE_S_CMT;
	private static final Rarity GOLD = Rarities.GOLD;
	private static final Rarity PURP = Rarities.PURPLE;
	private static final Rarity BLUE = Rarities.BLUE;
	private static final Rarity GREEN = Rarities.GREEN;
	private static final Item.Properties swordProp = new Item.Properties().tab(sTab).rarity(GOLD);

// * * * * * * * * * * * * Create Objects * * * * * * * * * * * * \\

	// * * * * * * * * * * * * Metals * * * * * * * * * * * * \\

		// * * * * * * * * * * * * Raw * * * * * * * * * * * * \\
	public static final RegistryObject<Item> ITEM_INGOT_GOLD_R = ITEMS.register(INGOT_GOLD_R,
		() -> new Item(new Item.Properties().tab(iTab)));
	public static final RegistryObject<Item> ITEM_INGOT_LUMIN_R = ITEMS.register(INGOT_LUMIN_R,
		() -> new Item(new Item.Properties().tab(iTab)));
	public static final RegistryObject<Item> ITEM_INGOT_SHADITE_R = ITEMS.register(INGOT_SHADITE_R,
		() -> new Item(new Item.Properties().tab(iTab)));

		// * * * * * * * * * * * * Smelted * * * * * * * * * * * * \\
	public static final RegistryObject<Item> ITEM_INGOT_GOLD = ITEMS.register(INGOT_GOLD,
		() -> new Item(new Item.Properties().tab(iTab).rarity(GREEN)));
	public static final RegistryObject<Item> ITEM_INGOT_LUMIN = ITEMS.register(INGOT_LUMIN,
		() -> new Item(new Item.Properties().tab(iTab).rarity(GREEN)));
	public static final RegistryObject<Item> ITEM_INGOT_SHADITE = ITEMS.register(INGOT_SHADITE,
		() -> new Item(new Item.Properties().tab(iTab).rarity(GREEN)));

		// * * * * * * * * * * * * Enchanted * * * * * * * * * * * * \\
	public static final RegistryObject<Item> ITEM_INGOT_GOLD_E = ITEMS.register(INGOT_GOLD_E, ItemEnchanted::new);
	public static final RegistryObject<Item> ITEM_INGOT_LUMIN_E = ITEMS.register(INGOT_LUMIN_E, ItemEnchanted::new);
	public static final RegistryObject<Item> ITEM_INGOT_SHADITE_E = ITEMS.register(INGOT_SHADITE_E, ItemEnchanted::new);


	// * * * * * * * * * * * * Gems * * * * * * * * * * * * \\

		// * * * * * * * * * * * * Shards * * * * * * * * * * * * \\
	public static final RegistryObject<Item> ITEM_GEM_RUBY_S = ITEMS.register(GEM_RUBY_S,
		() -> new Item(new Item.Properties().tab(iTab)));
	public static final RegistryObject<Item> ITEM_GEM_SAPPHIRE_S = ITEMS.register(GEM_SAPPHIRE_S,
		() -> new Item(new Item.Properties().tab(iTab)));

		// * * * * * * * * * * * * Crystals * * * * * * * * * * * * \\
	public static final RegistryObject<Item> ITEM_GEM_AMETHYST = ITEMS.register(GEM_AMETHYST,
		() -> new Item(new Item.Properties().tab(iTab).rarity(GREEN)));
	public static final RegistryObject<Item> ITEM_GEM_RUBY = ITEMS.register(GEM_RUBY,
		() -> new Item(new Item.Properties().tab(iTab).rarity(GREEN)));
	public static final RegistryObject<Item> ITEM_GEM_SAPPHIRE = ITEMS.register(GEM_SAPPHIRE,
		() -> new Item(new Item.Properties().tab(iTab).rarity(GREEN)));

		// * * * * * * * * * * * * Enchanted * * * * * * * * * * * * \\
	public static final RegistryObject<ItemEnchanted> ITEM_GEM_AMETHYST_E = ITEMS.register(GEM_AMETHYST_E, ItemEnchanted::new);
	public static final RegistryObject<ItemEnchanted> ITEM_GEM_RUBY_E = ITEMS.register(GEM_RUBY_E, ItemEnchanted::new);
	public static final RegistryObject<ItemEnchanted> ITEM_GEM_SAPPHIRE_E = ITEMS.register(GEM_SAPPHIRE_E, ItemEnchanted::new);
	public static final RegistryObject<ItemEnchanted> ITEM_GEM_DIAMOND_E = ITEMS.register(GEM_DIAMOND_E, ItemEnchanted::new);
	public static final RegistryObject<ItemEnchanted> ITEM_GEM_EMERALD_E = ITEMS.register(GEM_EMERALD_E, ItemEnchanted::new);

	// * * * * * * * * * * * * Dust * * * * * * * * * * * * \\
	public static final RegistryObject<ItemEnchanted> ITEM_DUST_MAGIC_E = ITEMS.register(DUST_MAGIC_E, ItemEnchanted::new);


	// * * * * * * * * * * * * Crafting * * * * * * * * * * * * \\

		// * * * * * * * * * * * * Cores * * * * * * * * * * * * \\
	public static final RegistryObject<ItemCore> ITEM_CORE_BASE = ITEMS.register(CORE_BASE, ItemCore::new);
	public static final RegistryObject<ItemCore> ITEM_CORE_AMETHYST = ITEMS.register(CORE_AMETHYST, ItemCore::new);
	public static final RegistryObject<ItemCore> ITEM_CORE_DIAMOND = ITEMS.register(CORE_DIAMOND, ItemCore::new);
	public static final RegistryObject<ItemCore> ITEM_CORE_EMERALD = ITEMS.register(CORE_EMERALD, ItemCore::new);
	public static final RegistryObject<ItemCore> ITEM_CORE_END = ITEMS.register(CORE_END, ItemCore::new);
	public static final RegistryObject<ItemCore> ITEM_CORE_LEVEL = ITEMS.register(CORE_LEVEL, ItemCore::new);
	public static final RegistryObject<ItemCore> ITEM_CORE_LUMIN = ITEMS.register(CORE_LUMIN, ItemCore::new);
	public static final RegistryObject<ItemCore> ITEM_CORE_MASTER = ITEMS.register(CORE_MASTER, ItemCore::new);
	public static final RegistryObject<ItemCore> ITEM_CORE_RUBY = ITEMS.register(CORE_RUBY, ItemCore::new);
	public static final RegistryObject<ItemCore> ITEM_CORE_SABER = ITEMS.register(CORE_SABER, ItemCore::new);
	public static final RegistryObject<ItemCore> ITEM_CORE_SAPPHIRE = ITEMS.register(CORE_SAPPHIRE, ItemCore::new);
	public static final RegistryObject<ItemCore> ITEM_CORE_SHADITE = ITEMS.register(CORE_SHADITE, ItemCore::new);
	public static final RegistryObject<ItemCore> ITEM_CORE_THUNDER = ITEMS.register(CORE_THUNDER, ItemCore::new);
	public static final RegistryObject<ItemCore> ITEM_CORE_ULTIMATE = ITEMS.register(CORE_ULTIMATE, ItemCore::new);

		// * * * * * * * * * * * * Tier One * * * * * * * * * * * * \\
	public static final RegistryObject<Item> ITEM_TIER_GOLDROD = ITEMS.register(TIER_GOLDROD,
		() -> new Item(new Item.Properties().tab(iTab).rarity(GREEN)));
	public static final RegistryObject<Item> ITEM_TIER_AMETHYST = ITEMS.register(TIER_AMETHYST,
		() -> new Item(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_DIAMOND = ITEMS.register(TIER_DIAMOND,
		() -> new Item(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_EMERALD = ITEMS.register(TIER_EMERALD,
		() -> new Item(new Item.Properties().tab(iTab).rarity(BLUE).stacksTo(1)));
	public static final RegistryObject<Item> ITEM_TIER_END = ITEMS.register(TIER_END,
		() -> new ItemEnderpearlEnchanted(new Item.Properties().tab(iTab).rarity(BLUE).stacksTo(16)));
	public static final RegistryObject<Item> ITEM_TIER_EXP = ITEMS.register(TIER_EXP,
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(BLUE).stacksTo(1)));
	public static final RegistryObject<Item> ITEM_TIER_THUNDER = ITEMS.register(TIER_THUNDER,
		() -> new ItemTier(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_LUMIN = ITEMS.register(TIER_LUMIN,
		() -> new Item(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_RUBY = ITEMS.register(TIER_RUBY,
		() -> new ItemMagmaball(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_SAPPHIRE = ITEMS.register(TIER_SAPPHIRE,
		() -> new Item(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_SHADITE = ITEMS.register(TIER_SHADITE,
		() -> new Item(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_TF_POWER = ITEMS.register(TIER_TF_POWER,
		() -> new ItemTF(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_TF_WISDOM = ITEMS.register(TIER_TF_WISDOM,
		() -> new ItemTF(new Item.Properties().tab(iTab).rarity(BLUE)));
	public static final RegistryObject<Item> ITEM_TIER_TF_COURAGE = ITEMS.register(TIER_TF_COURAGE,
		() -> new ItemTF(new Item.Properties().tab(iTab).rarity(BLUE)));

		// * * * * * * * * * * * * Tier Two * * * * * * * * * * * * \\
	public static final RegistryObject<Item> ITEM_TIER2_AMETHYST = ITEMS.register(TIER2_AMETHYST,
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(PURP)));
	public static final RegistryObject<Item> ITEM_TIER2_END = ITEMS.register(TIER2_END,
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(PURP)));
	public static final RegistryObject<Item> ITEM_TIER2_EXP = ITEMS.register(TIER2_EXP,
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(PURP).stacksTo(1)));
	public static final RegistryObject<Item> ITEM_TIER2_THUNDER = ITEMS.register(TIER2_THUNDER,
		() -> new ItemEnchanted(new Item.Properties().tab(iTab).rarity(PURP)));


	// * * * * * * * * * * * * Potions * * * * * * * * * * * * \\
	public static final RegistryObject<Item> ITEM_POTION_STRENGTH = ITEMS.register(POTION_STRENGTH, ItemPotion::new);
	public static final RegistryObject<Item> ITEM_POTION_SWIFTNESS = ITEMS.register(POTION_SWIFTNESS, ItemPotion::new);
	public static final RegistryObject<Item> ITEM_POTION_JUMP = ITEMS.register(POTION_JUMP, ItemPotion::new);
	public static final RegistryObject<Item> ITEM_POTION_WATER = ITEMS.register(POTION_WATER, ItemPotion::new);
	public static final RegistryObject<Item> ITEM_POTION_SLOW = ITEMS.register(POTION_SLOW, ItemPotion::new);
	public static final RegistryObject<Item> ITEM_POTION_DAMAGE = ITEMS.register(POTION_DAMAGE, ItemPotion::new);
	public static final RegistryObject<Item> ITEM_POTION_POISON = ITEMS.register(POTION_POISON, ItemPotion::new);
	public static final RegistryObject<Item> ITEM_POTION_FALLING = ITEMS.register(POTION_FALLING, ItemPotion::new);


	// * * * * * * * * * * * * Lightsaber Crystals * * * * * * * * * * * * \\
	//public static final RegistryObject<ItemCrystal> ITEM_CRYSTAL_RUBY = ITEMS.register(CRYSTAL_RUBY, ItemCrystal::new);
	//public static final RegistryObject<ItemCrystal> ITEM_CRYSTAL_SAPPHIRE = ITEMS.register(CRYSTAL_SAPPHIRE, ItemCrystal::new);
	//public static final RegistryObject<ItemCrystal> ITEM_CRYSTAL_AMETHYST = ITEMS.register(CRYSTAL_AMETHYST, ItemCrystal::new);
	//public static final RegistryObject<ItemCrystal> ITEM_CRYSTAL_EMERALD = ITEMS.register(CRYSTAL_EMERALD, ItemCrystal::new);
	//public static final RegistryObject<ItemCrystal> ITEM_CRYSTAL_DIAMOND = ITEMS.register(CRYSTAL_DIAMOND, ItemCrystal::new);
	//public static final RegistryObject<Item> ITEM_BATTERY_LIGHTSABER = ITEMS.register(BATTERY_LIGHTSABER, () -> new Item(new Item.Properties().tab(iTab)));


	// * * * * * * * * * * * * Swords * * * * * * * * * * * * \\
	public static final RegistryObject<ItemSwordBase> ITEM_SWORD_BASE = ITEMS.register(SWORD_BASE,
		() -> new ItemSwordBase(ModToolTier.BASE, 8, -2.4f, new Item.Properties().tab(sTab).rarity(Rarities.PURPLE)));
	public static final RegistryObject<ItemSwordAmethyst> ITEM_SWORD_AMETHYST = ITEMS.register(SWORD_AMETHYST,
		() -> new ItemSwordAmethyst(ModToolTier.TIERONE, 13, -2.0f, swordProp));
	public static final RegistryObject<ItemSwordChaos> ITEM_SWORD_CHAOS = ITEMS.register(SWORD_CHAOS,
		() -> new ItemSwordChaos(ModToolTier.TIERONE, 0, -2.4f, swordProp));
	public static final RegistryObject<ItemSwordDiamond> ITEM_SWORD_DIAMOND = ITEMS.register(SWORD_DIAMOND,
		() -> new ItemSwordDiamond(ModToolTier.TIERONE, 11, -1.4f, swordProp));
	public static final RegistryObject<ItemSwordEmerald> ITEM_SWORD_EMERALD = ITEMS.register(SWORD_EMERALD,
		() -> new ItemSwordEmerald(ModToolTier.TIERONE, 16, -1.8f, swordProp));
	public static final RegistryObject<ItemSwordEnd> ITEM_SWORD_END = ITEMS.register(SWORD_END,
		() -> new ItemSwordEnd(ModToolTier.TIERONE, 13, -2.4f, swordProp));
	public static final RegistryObject<ItemSwordKing> ITEM_SWORD_KING = ITEMS.register(SWORD_KING,
		() -> new ItemSwordKing(ModToolTier.TIERONE, 5, -2.4f, swordProp));
	public static final RegistryObject<ItemSwordLevel> ITEM_SWORD_LEVEL = ITEMS.register(SWORD_LEVEL,
		() -> new ItemSwordLevel(ModToolTier.TIERTWO, 0, -2.4f, swordProp));
	public static final RegistryObject<ItemSwordLumin> ITEM_SWORD_LUMIN = ITEMS.register(SWORD_LUMIN,
		() -> new ItemSwordLumin(ModToolTier.TIERONE, 11, -1.6f, swordProp));
	public static final RegistryObject<ItemSwordMaster> ITEM_SWORD_MASTER = ITEMS.register(SWORD_MASTER,
		() -> new ItemSwordMaster(ModToolTier.TIERONE, 0, -2.4f, swordProp));
	public static final RegistryObject<ItemSwordRuby> ITEM_SWORD_RUBY = ITEMS.register(SWORD_RUBY,
		() -> new ItemSwordRuby(ModToolTier.TIERONE, 14, -2.4f, swordProp));
	public static final RegistryObject<ItemSwordSaber> ITEM_SWORD_SABER = ITEMS.register(SWORD_SABER,
		() -> new ItemSwordSaber(ModToolTier.TIERONE, 0, -2.4f, swordProp));
	public static final RegistryObject<ItemSwordSapphire> ITEM_SWORD_SAPPHIRE = ITEMS.register(SWORD_SAPPHIRE,
		() -> new ItemSwordSapphire(ModToolTier.TIERONE, 12, -2.2f, swordProp));
	public static final RegistryObject<ItemSwordShadite> ITEM_SWORD_SHADITE = ITEMS.register(SWORD_SHADITE,
		() -> new ItemSwordShadite(ModToolTier.TIERONE, 9, -1.2f, swordProp));
	public static final RegistryObject<ItemSwordThunder> ITEM_SWORD_THUNDER = ITEMS.register(SWORD_THUNDER,
		() -> new ItemSwordThunder(ModToolTier.TIERONE, 19, -2.8f, swordProp));
	public static final RegistryObject<ItemSwordUltimate> ITEM_SWORD_ULTIMATE = ITEMS.register(SWORD_ULTIMATE,
		() -> new ItemSwordUltimate(ModToolTier.TIERONE, 24, -2.0f, swordProp));

	// * * * * * * * * * * * * Bows * * * * * * * * * * * * \\
	//public static final RegistryObject<ItemBowMulti> ITEM_BOW_MULTI = ITEMS.register(BOW_MULTI, () -> new ItemBowMulti(new Item.Properties().tab(sTab)));

	//public static final RegistryObject<ItemToolChisel> ITEM_TOOL_CHISEL = ITEMS.register("item_tool_chisel", () -> new ItemToolChisel(new Item.Properties().tab(sTab).rarity(BLUE)));

	// * * * * * * * * * * * * Misc * * * * * * * * * * * * \\
	public static final RegistryObject<ItemSwordChaos> ITEM_ENTITY_SWORDSLASH = ITEMS.register("sword_slash_entity",
		() -> new ItemSwordChaos(ModToolTier.TIERONE, 0, -2.4f, new Item.Properties()));
	public static final RegistryObject<ForgeSpawnEggItem> ITEM_SHADE_SPAWN_EGG = ITEMS.register(SHADE_SPAWN_EGG,
		() -> new ForgeSpawnEggItem(EntityInit.SHADE_ENTITY, 0x0B141A, 0x636062, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

}
package com.github.atheera.swordsoftheend.events;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.github.atheera.swordsoftheend.*;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.Map;
import java.util.Random;

import static com.github.atheera.swordsoftheend.SOTE.MOD_ID;
import static com.github.atheera.swordsoftheend.inits.BlockInit.*;
import static com.github.atheera.swordsoftheend.inits.ItemInit.*;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OreBreakEvent {

    private static final Random rand = new Random();

    private static ItemStack stack(RegistryObject<Item> item) {
        return item.get().getDefaultInstance();
    }

    private static boolean check(BlockEvent.BreakEvent e, RegistryObject<Block> block) {
        return e.getState() == block.get().defaultBlockState();
    }

    @SubscribeEvent
    public static void oreBreakEvent(BlockEvent.BreakEvent e) {

        Player player = e.getPlayer();
        ItemStack stack = player.getMainHandItem();
        Item item = stack.getItem();
        int enchantLvl;
        int silky;

        // Setting variables for each item to be spawned or getting the block destroyed
        ItemStack
            IIGR = stack(ITEM_INGOT_GOLD_R),
            IILR = stack(ITEM_INGOT_LUMIN_R),
            IISR = stack(ITEM_INGOT_SHADITE_R),
            IGRS = stack(ITEM_GEM_RUBY_S),
            IGSS = stack(ITEM_GEM_SAPPHIRE_S);
        ItemStack IDME = new ItemStack(ITEM_DUST_MAGIC_E.get());

        boolean
            BOG = check(e, BLOCK_ORE_GOLD),
            BODG = check(e, BLOCK_ORE_DEEP_GOLD),
            BOL = check(e, BLOCK_ORE_LUMIN),
            BODL = check(e, BLOCK_ORE_DEEP_LUMIN),
            BOS = check(e, BLOCK_ORE_SHADITE),
            BOM = check(e, BLOCK_ORE_MAGIC),
            BODM = check(e, BLOCK_ORE_DEEP_MAGIC),
            BOR = check(e, BLOCK_ORE_RUBY),
            BODR = check(e, BLOCK_ORE_DEEP_RUBY),
            BOSA = check(e, BLOCK_ORE_SAPPHIRE),
            BODS = check(e, BLOCK_ORE_DEEP_SAPPHIRE),
            BONS = check(e, BLOCK_ORE_NETHER_SHADITE);

        if(item instanceof PickaxeItem) { // Only applied if blocks are broken with pickaxe
            if(stack.isEnchanted()) { // Checks if pickaxe is enchanted

                Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(stack);

                if(EnchantmentHelper.getEnchantments(stack).containsValue(map.get(Enchantments.BLOCK_FORTUNE))) {
                    enchantLvl = map.get(Enchantments.BLOCK_FORTUNE);
                    switch (enchantLvl) {
                        case 1 -> {
                            e.setExpToDrop(10);
                            if (BOG || BODG) spawnItem(e, IIGR, 1);
                            if (BOL || BODL) spawnItem(e, IILR, 1);
                            if (BOS || BONS) spawnItem(e, IISR, 1);
                            if (BOM || BODM) spawnItem(e, IDME, 2);
                            if (BOR || BODR) spawnItem(e, IGRS, 2);
                            if (BOSA || BODS)spawnItem(e, IGSS, 2);
                        }
                        case 2 -> {
                            e.setExpToDrop(20);
                            if (BOG || BODG) spawnItem(e, IIGR, 2);
                            if (BOL || BODL) spawnItem(e, IILR, 2);
                            if (BOS || BONS) spawnItem(e, IISR, 2);
                            if (BOM || BODM) spawnItem(e, IDME, 4);
                            if (BOR || BODR) spawnItem(e, IGRS, 4);
                            if (BOSA || BODS)spawnItem(e, IGSS, 4);
                        }
                        case 3 -> {
                            e.setExpToDrop(30);
                            if (BOG || BODG) spawnItem(e, IIGR, 3);
                            if (BOL || BODL) spawnItem(e, IILR, 3);
                            if (BOS || BONS) spawnItem(e, IISR, 3);
                            if (BOM || BODM) spawnItem(e, IDME, 6);
                            if (BOR || BODR) spawnItem(e, IGRS, 6);
                            if (BOSA || BODS)spawnItem(e, IGSS, 6);
                        }
                    }
                }

                if(EnchantmentHelper.getEnchantments(stack).containsValue(map.get(Enchantments.SILK_TOUCH))) {
                    silky = map.get(Enchantments.SILK_TOUCH);
                    if (silky == 1) { // Checks if the pickaxe has silk touch
                        if (BOG)  spawnItem(e, ITEM_BLOCK_ORE_GOLD.get().getDefaultInstance(), 0);
                        if (BODG) spawnItem(e, ITEM_BLOCK_ORE_DEEP_GOLD.get().getDefaultInstance(), 0);
                        if (BOL)  spawnItem(e, ITEM_BLOCK_ORE_LUMIN.get().getDefaultInstance(), 0);
                        if (BODL) spawnItem(e, ITEM_BLOCK_ORE_DEEP_LUMIN.get().getDefaultInstance(), 0);
                        if (BOS)  spawnItem(e, ITEM_BLOCK_ORE_SHADITE.get().getDefaultInstance(), 0);
                        if (BOM)  spawnItem(e, ITEM_BLOCK_ORE_MAGIC.get().getDefaultInstance(), 0);
                        if (BODM) spawnItem(e, ITEM_BLOCK_ORE_DEEP_MAGIC.get().getDefaultInstance(), 0);
                        if (BOSA) spawnItem(e, ITEM_BLOCK_ORE_SAPPHIRE.get().getDefaultInstance(), 0);
                        if (BODS) spawnItem(e, ITEM_BLOCK_ORE_DEEP_SAPPHIRE.get().getDefaultInstance(), 0);
                        if (BOR)  spawnItem(e, ITEM_BLOCK_ORE_RUBY.get().getDefaultInstance(), 0);
                        if (BODR) spawnItem(e, ITEM_BLOCK_ORE_DEEP_RUBY.get().getDefaultInstance(), 0);
                        if (BONS) spawnItem(e, ITEM_BLOCK_ORE_NETHER_SHADITE.get().getDefaultInstance(), 0);
                    }
                }
            } else {
                e.setExpToDrop(10);
                if (BOG || BODG) spawnItem(e, IIGR, 0);
                if (BOL || BODL) spawnItem(e, IILR, 0);
                if (BOS || BONS) spawnItem(e, IISR, 0);
                if (BOM || BODM) spawnItem(e, IDME, 1);
                if (BOR || BODR) spawnItem(e, IGRS, 1);
                if (BOSA || BODS)spawnItem(e, IGSS, 1);
            }
        }
    }

    @SubscribeEvent
    public static void blockBreakEvent(BlockEvent.BreakEvent e) {
        Player player = e.getPlayer();
        ItemStack stack = player.getMainHandItem();
        Item item = stack.getItem();
        if(item instanceof PickaxeItem) {

            if(e.getState() == BLOCK_RAW_SHADITE.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_RAW_SHADITE.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_SMELT_SHADITE.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_SMELT_SHADITE.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_RAW_GOLD.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_RAW_GOLD.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_SMELT_GOLD.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_SMELT_GOLD.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_RAW_LUMIN.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_RAW_LUMIN.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_SMELT_LUMIN.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_SMELT_LUMIN.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_MAGIC.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_MAGIC.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_CRYSTAL_SAPPHIRE.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_CRYSTAL_SAPPHIRE.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_CRYSTAL_RUBY.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_CRYSTAL_RUBY.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_CRYSTAL_SAPPHIRE_E.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_CRYSTAL_SAPPHIRE_E.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_CRYSTAL_RUBY_E.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_CRYSTAL_RUBY_E.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_CRYSTAL_AMETHYST_E.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_CRYSTAL_AMETHYST_E.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_GEM_EMERALD_E.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_GEM_EMERALD_E.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_GEM_DIAMOND_E.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_GEM_DIAMOND_E.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_SMELT_GOLD_E.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_SMELT_GOLD_E.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_SMELT_SHADITE_E.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_SMELT_SHADITE_E.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_SMELT_LUMIN_E.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_SMELT_LUMIN_E.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_END_E.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_END_E.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_GEM_ULTIMATE.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_GEM_ULTIMATE.get().getDefaultInstance(), 0);
            if(e.getState() == BLOCK_INGOT_ULTIMATE.get().defaultBlockState())
                spawnItem(e, ITEM_BLOCK_INGOT_ULTIMATE.get().getDefaultInstance(), 0);
        }

    }

    private static void spawnItem(BlockEvent.BreakEvent event, ItemStack stack, int amp) {
        int amount;
        int x = event.getPos().getX();
        int y = event.getPos().getY();
        int z = event.getPos().getZ();
        Level world = (Level)event.getWorld();

        switch (amp) {
            case 0 -> {
                ItemEntity entity = new ItemEntity(world, x, y, z, stack);
                world.addFreshEntity(entity);
            }
            case 1 -> {
                amount = rand.nextInt(2)+1;
                System.out.println(amount);
                for(int i = 0; i < amount; i++) {
                    ItemEntity entity = new ItemEntity(world, x, y, z, stack);
                    world.addFreshEntity(entity);
                }
            }
            case 2 -> {
                amount = rand.nextInt(3)+1;
                System.out.println(amount);
                for(int i = 0; i < amount; i++) {
                    ItemEntity entity = new ItemEntity(world, x, y, z, stack);
                    world.addFreshEntity(entity);
                }
            }
            case 3 -> {
                amount = rand.nextInt(4)+1;
                System.out.println(amount);
                for(int i = 0; i < amount; i++) {
                    ItemEntity entity = new ItemEntity(world, x, y, z, stack);
                    world.addFreshEntity(entity);
                }
            }
            case 4 -> {
                amount = rand.nextInt(5)+1;
                System.out.println(amount);
                for(int i = 0; i < amount; i++) {
                    ItemEntity entity = new ItemEntity(world, x, y, z, stack);
                    world.addFreshEntity(entity);
                }
            }
            case 5 -> {
                amount = rand.nextInt(6)+1;
                System.out.println(amount);
                for(int i = 0; i < amount; i++) {
                    ItemEntity entity = new ItemEntity(world, x, y, z, stack);
                    world.addFreshEntity(entity);
                }
            }
            case 6 -> {
                amount = rand.nextInt(7)+1;
                System.out.println(amount);
                for(int i = 0; i < amount; i++) {
                    ItemEntity entity = new ItemEntity(world, x, y, z, stack);
                    world.addFreshEntity(entity);
                }
            }
            default -> {
                ItemEntity entity = new ItemEntity(world, x, y, z, stack);
                world.addFreshEntity(entity);
                SOTE.LOGGER.info("Swords of the End: Something went wrong and defaulted to spawning one item when breaking a block.");
            }
        }
    }
}
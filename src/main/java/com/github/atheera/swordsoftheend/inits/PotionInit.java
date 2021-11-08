package com.github.atheera.swordsoftheend.inits;

import com.github.atheera.swordsoftheend.SOTE;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PotionInit {

    private PotionInit() {}

    private static final int sec = 20;
    private static final int min = sec*60;

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, SOTE.MOD_ID);

    public static final RegistryObject<Potion> STRENGTH_POTION = POTIONS.register("item_potion_strength",
            () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_BOOST, min*3, 4)));
    public static final RegistryObject<Potion> JUMP_POTION = POTIONS.register("item_potion_jump",
            () -> new Potion(new MobEffectInstance(MobEffects.JUMP, min*3, 4)));
    public static final RegistryObject<Potion> DAMAGE_POTION = POTIONS.register("item_potion_damage",
            () -> new Potion(new MobEffectInstance(MobEffects.HARM, 1, 4)));
    public static final RegistryObject<Potion> POISON_POTION = POTIONS.register("item_potion_poison",
            () -> new Potion(new MobEffectInstance(MobEffects.POISON, min*3, 4)));
    public static final RegistryObject<Potion> SWIFTNESS_POTION = POTIONS.register("item_potion_swiftness",
            () -> new Potion(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, min*3, 4)));
    public static final RegistryObject<Potion> WATER_POTION = POTIONS.register("item_potion_water",
            () -> new Potion(new MobEffectInstance(MobEffects.WATER_BREATHING, min*20)));
    public static final RegistryObject<Potion> SLOW_POTION = POTIONS.register("item_potion_slow",
            () -> new Potion(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, min*3, 4)));
    public static final RegistryObject<Potion> FALLING_POTION = POTIONS.register("item_potion_falling",
            () -> new Potion(new MobEffectInstance(MobEffects.SLOW_FALLING, min*10)));

}
package com.github.atheera.swordsoftheend.inits;

import com.github.atheera.swordsoftheend.enchantments.Enderbane;
import com.github.atheera.swordsoftheend.enchantments.Lifesteal;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.github.atheera.swordsoftheend.SOTE.MOD_ID;

public class EnchantInit {

    private EnchantInit() {}

    public static final DeferredRegister<Enchantment> ENCHANT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MOD_ID);

    public static final RegistryObject<Enchantment> LIFESTEAL = ENCHANT.register("lifesteal",
        () -> new Lifesteal(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND}));
    public static final RegistryObject<Enchantment> ENDERBANE = ENCHANT.register("enderbane",
        () -> new Enderbane(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND}));
}

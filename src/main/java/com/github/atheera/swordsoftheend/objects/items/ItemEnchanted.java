package com.github.atheera.swordsoftheend.objects.items;

import com.github.atheera.swordsoftheend.inits.CreativeTabInit;
import com.github.atheera.swordsoftheend.materials.Rarities;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemEnchanted extends Item {

	public ItemEnchanted() {
		super(new Item.Properties().tab(CreativeTabInit.SOTE_I_CMT).rarity(Rarities.BLUE));
	}

	public ItemEnchanted(Properties stacksTo) {
		super(stacksTo);
	}

	@Override
	public boolean isFoil(ItemStack p_41453_) {
		return true;
	}
	
}
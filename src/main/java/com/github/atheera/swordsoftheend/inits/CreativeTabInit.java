package com.github.atheera.swordsoftheend.inits;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class CreativeTabInit extends CreativeModeTab {

	public CreativeTabInit(int id, String label) {
		super(label);
	}

	@Override
	public ItemStack makeIcon() {
		return null;
	}

    public static final CreativeModeTab SOTE_I_CMT = (new CreativeTabInit(1, "sote_item_tab") {
    	public ItemStack makeIcon() {
    		return new ItemStack(ItemInit.ITEM_CORE_BASE.get());
    	}
    });
    
	public static final CreativeModeTab SOTE_B_CMT = (new CreativeTabInit(2, "sote_block_tab") {
		public ItemStack makeIcon() {
			return new ItemStack(BlockInit.BLOCK_ORE_LUMIN.get()
			);
		}
	});

	public static final CreativeModeTab SOTE_S_CMT = (new CreativeTabInit(3, "sote_sword_tab") {
		public ItemStack makeIcon() { return new ItemStack(ItemInit.ITEM_SWORD_BASE.get()); }
	});

}
package com.github.atheera.swordsoftheend.entities.tile;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
/*
public class BlockInfuserEntity extends AbstractFurnaceBlockEntity {
    public BlockInfuserEntity(BlockEntityType<?> p_154991_, BlockPos p_154992_, BlockState p_154993_, RecipeType<? extends AbstractCookingRecipe> p_154994_) {
        super(p_154991_, p_154992_, p_154993_, p_154994_);
    }

    public BlockInfuserEntity() {
        super(InfuserRecipe.BLOCK_INFUSER_ENTITY, InfuserRecipe.INFUSER_RECIPE_TYPE);
    }

    @Override
    protected Component getDefaultName() {
        return new TextComponent("Enchantment Infuser");
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new InfuserContainerMenu(id, inventory, this, this.);
    }
}
*/
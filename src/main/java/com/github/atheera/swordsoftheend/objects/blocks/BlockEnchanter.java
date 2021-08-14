package com.github.atheera.swordsoftheend.objects.blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import javax.annotation.Nullable;
import java.util.List;

public class BlockEnchanter extends Block implements EntityBlock {
    public BlockEnchanter() {
        super(Properties.of(Material.METAL)
            .sound(SoundType.METAL)
            .strength(2.0f)
            .noOcclusion());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlockEnchanterBE(pos, state);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter reader, List<Component> list, TooltipFlag flag) {
        list.add(new TextComponent(ChatFormatting.AQUA + "Enchantment Infuser"));
        list.add(new TextComponent(ChatFormatting.AQUA + "Place on top of " + ChatFormatting.LIGHT_PURPLE + " Enchantment Infusion Generator " + ChatFormatting.AQUA + " to combine swords with cores"));
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if(level.isClientSide()) {
            return (level1, pos, state1, tile) -> {
                if(tile instanceof BlockEnchanterBE ench) {
                    ench.tickClient(state1);
                }
            };
        } else {
            return (level1, pos, state1, tile) -> {
                if(tile instanceof BlockEnchanterBE ench) {
                    ench.tickServer(state1);
                }
            };
        }
    }
}
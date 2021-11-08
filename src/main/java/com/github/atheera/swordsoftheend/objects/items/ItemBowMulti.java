package com.github.atheera.swordsoftheend.objects.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;

public class ItemBowMulti extends BowItem {

    private static final int MAX_DRAW_DURATION = 35;
    private static final int DEFAULT_RANGE = 12;

    public ItemBowMulti(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, pStack) > 0;
            ItemStack stack = player.getProjectile(pStack);

            int i = this.getUseDuration(pStack) - pTimeLeft;
            i = ForgeEventFactory.onArrowLoose(pStack, pLevel, player, i, !stack.isEmpty() || flag);
            if (i < 0) return;

            if (!stack.isEmpty() || flag) {
                if (stack.isEmpty()) {
                    stack = new ItemStack(Items.ARROW);
                }

                float f = getPowerForTime(i);
                if (!((double)f < 0.1D)) {
                    boolean flag1 = player.getAbilities().instabuild || (stack.getItem() instanceof ArrowItem && ((ArrowItem)stack.getItem()).isInfinite(stack, pStack, player));
                    if (!pLevel.isClientSide) {

                        ArrowItem arrowItem = (ArrowItem)(stack.getItem() instanceof ArrowItem ? stack.getItem() : Items.ARROW);
                        AbstractArrow abstractArrow = arrowItem.createArrow(pLevel, stack, player);

                        abstractArrow = customArrow(abstractArrow);
                        abstractArrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, f*3.0f, 1.0f);

                        if (f == 1.0f) {
                            abstractArrow.setCritArrow(true);
                        }




                    }
                }

            }

        }
    }
}
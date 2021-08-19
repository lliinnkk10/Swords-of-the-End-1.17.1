package com.github.atheera.swordsoftheend.objects.items;

import com.github.atheera.swordsoftheend.SOTE;
import com.github.atheera.swordsoftheend.entities.thrown.ModThrownEnderpearl;
import com.github.atheera.swordsoftheend.entities.thrown.ThrownRandomEntity;
import com.github.atheera.swordsoftheend.inits.ItemInit;
import com.github.atheera.swordsoftheend.materials.ModDamageSource;
import com.github.atheera.swordsoftheend.utils.KeyboardHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Random;

public class ItemSwordChaos extends ItemSword {

    private final Random rand = new Random();

    public ItemSwordChaos(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flagIn) {
        if(KeyboardHelper.isHoldingShift()) {
            tooltip.add(new TextComponent(ChatFormatting.AQUA + "???"));
            tooltip.add(new TextComponent(ChatFormatting.AQUA + "???"));
            tooltip.add(new TextComponent(ChatFormatting.AQUA + "???"));
        } else {
            tooltip.add(new TextComponent(ChatFormatting.WHITE + "Hold " + ChatFormatting.LIGHT_PURPLE + "???" + ChatFormatting.WHITE + " for ???"));
        }
        super.appendHoverText(stack, world, tooltip, flagIn);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if(!world.isClientSide)
            try {
                getRCEffect(player, rand.nextInt(7));
                return InteractionResultHolder.success(player.getMainHandItem());
            } catch (Exception e) {
                e.printStackTrace();
                return InteractionResultHolder.fail(player.getMainHandItem());
            }
        return InteractionResultHolder.success(player.getMainHandItem());
    }

    private void getRCEffect(Player player, int fx) {
        Level world = player.level;
        ItemStack stack = player.getMainHandItem();
        switch (fx) {
            case 0 -> {
                System.out.println(fx);
                player.sendMessage(new TextComponent("???"), player.getUUID());
                player.drop(stack, true);
                player.getInventory().removeItem(stack);
            }
            case 1 -> {
                System.out.println(fx);
                ModThrownEnderpearl thrownEnderpearl = new ModThrownEnderpearl(world, player);
                thrownEnderpearl.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 1.5f, 1.0f);
                world.addFreshEntity(thrownEnderpearl);
            }
            case 2 -> {
                System.out.println(fx);
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_EXPLODE, SoundSource.NEUTRAL, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.8F + 0.8F));
                player.hurt(ModDamageSource.stupidity(player), player.getHealth()-1.0f);
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 50, 4));
            }
            case 3 -> {
                System.out.println(fx);
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sec*5, 10));
            }
            case 4 -> {
                System.out.println(fx);
                player.setYHeadRot(player.getYHeadRot()*2);
                player.setSecondsOnFire(5);
            }
            case 5 -> {
                System.out.println(fx);
                for(int i = 0; i < 10; i++) {
                    Arrow arrow = new Arrow(world, player);
                    arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), (i*0.25f)+(-1.0f), (i*0.25f)+1.0f, 1.0f);
                    arrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                    world.addFreshEntity(arrow);
                }
            }
            case 6 -> {
                System.out.println(fx);
                if(!world.isClientSide) {
                    ThrownRandomEntity tre = new ThrownRandomEntity(world, player);
                    tre.setItem(ItemInit.ITEM_SWORD_CHAOS.get().getDefaultInstance());
                    tre.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 1.5f, 1.0f);
                    world.addFreshEntity(tre);
                }
            }
            default -> {
                System.out.println(fx + " ERROR");
                SOTE.LOGGER.error("Error right-clicking chaos sword!");
            }
        }

    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        try {
            if(rand.nextBoolean()) getHitEffect(attacker, rand.nextInt(5));
            else getHitEffect(target, rand.nextInt(6));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void getHitEffect(LivingEntity entity, int fx) {

        Level world = entity.level;

        if(!world.isClientSide) {

            if (entity instanceof Mob enemy) {

                switch (fx) {
                    case 0 -> {
                        System.out.println(fx + " speed mob");
                        enemy.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sec * 5, 10));
                    }
                    case 1 -> {
                        System.out.println(fx + " sturdy mob");
                        enemy.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, sec * 3, 10000));
                        enemy.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sec * 3, 10));
                    }
                    case 2 -> {
                        System.out.println(fx + " kill mob");
                        enemy.setRemoved(Entity.RemovalReason.KILLED);
                    }
                    case 3 -> {
                        System.out.println(fx + " move mob");
                        Vec3 oPos = enemy.position();
                        boolean flag = false;
                        while (!flag){
                            enemy.randomTeleport(
                                    enemy.getX() + rand.nextInt(5),
                                    enemy.getY() + rand.nextInt(5),
                                    enemy.getZ() + rand.nextInt(5), true);
                            if(oPos != enemy.position()) flag = true;
                        }
                    }
                    case 4 -> {
                        System.out.println(fx + " heal mob");
                        enemy.heal(10.0f);
                    }
                    case 5 -> {
                        System.out.println(fx + " transform mob");
                        enemy.setRemoved(Entity.RemovalReason.DISCARDED);
                        Chicken chicken = new Chicken(EntityType.CHICKEN, world);
                        chicken.setPos(enemy.position());
                        world.addFreshEntity(chicken);
                    }
                    default -> {
                        System.out.println("ERROR");
                        SOTE.LOGGER.error("Error applying effect to mob via chaos sword!");
                    }
                }

            }

            if (entity instanceof Player player) {

                switch (fx) {
                    case 0 -> {
                        System.out.println(fx + " damage boost player");
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, sec * 5, 5));
                    }
                    case 1 -> {
                        System.out.println(fx + " hurt player");
                        player.hurt(ModDamageSource.stupidity(player), 10);
                        player.sendMessage(new TextComponent("Why are you hitting yourself??"), player.getUUID());
                    }
                    case 2 -> {
                        System.out.println(fx + " teleport player");
                        Vec3 oPos = player.position();
                        boolean flag = false;
                        while (!flag){
                            player.randomTeleport(
                                    player.getX() + rand.nextInt(5),
                                    player.getY() + rand.nextInt(5),
                                    player.getZ() + rand.nextInt(5), true);
                            if(oPos != player.position()) flag = true;
                        }
                        player.sendMessage(new TextComponent("Poof!"), player.getUUID());
                    }
                    case 3 -> {
                        System.out.println(fx + " heal player");
                        player.heal(5.0f);
                    }
                    case 4 -> {
                        System.out.println(fx + " sleep player");
                        player.startSleeping(player.blockPosition());
                    }
                    default -> {
                        System.out.println(fx + " ERROR");
                        SOTE.LOGGER.error("Error applying effect to player via chaos sword!");
                    }
                }

            }

        }

    }

}
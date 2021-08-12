package com.github.atheera.swordsoftheend.objects.items;

import com.github.atheera.swordsoftheend.entities.thrown.ModThrownEnderpearl;
import com.github.atheera.swordsoftheend.entities.thrown.ThrownRandomEntity;
import com.github.atheera.swordsoftheend.inits.ItemInit;
import com.github.atheera.swordsoftheend.materials.ModDamageSource;
import com.github.atheera.swordsoftheend.utils.KeyboardHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
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

    private Random rand = new Random();

    private String TAG_TIMER = "timer";
    private int TIMER;

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
            if(player.isShiftKeyDown())
                getRCEffect(player, 6);
            else
                getRCEffect(player, rand.nextInt(7));
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
                player.hurt(DamageSource.ANVIL, player.getHealth()-1.0f);
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, sec*2, 4));
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
                    arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, i*0.25f, 1.0f);
                    arrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                    world.addFreshEntity(arrow);
                }
            }
            case 6 -> {
                System.out.println(fx);
                ThrownRandomEntity tre = new ThrownRandomEntity(world, player);
                tre.setItem(ItemInit.ITEM_SWORD_CHAOS.get().getDefaultInstance());
                tre.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 1.5f, 1.0f);
                world.addFreshEntity(tre);
            }
            default -> {
                System.out.println(fx + " ERROR");
                player.sendMessage(new TextComponent("ERROR"), player.getUUID());
            }
        }

    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(rand.nextBoolean()) getHitEffect(attacker, rand.nextInt(5));
        else getHitEffect(target, rand.nextInt(5));
        return true;
    }

    private void getHitEffect(LivingEntity entity, int fx) {

        Level world = entity.level;
        ItemStack stack = entity.getMainHandItem();

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
                        enemy.hurt(DamageSource.FLY_INTO_WALL, 50);
                    }
                    case 3 -> {
                        System.out.println(fx + " move mob");
                        enemy.move(MoverType.SELF, new Vec3(enemy.getX(), enemy.getY() + 10, enemy.getZ()));
                    }
                    case 4 -> {
                        System.out.println(fx + " heal mob");
                        enemy.heal(10.0f);
                    }
                    default -> {
                        System.out.println("ERROR");
                        enemy.remove(Entity.RemovalReason.KILLED);
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
                    }
                    case 2 -> {
                        System.out.println(fx + " teleport player");
                        player.randomTeleport(
                                player.getX() + rand.nextInt(5),
                                player.getY() + rand.nextInt(5),
                                player.getZ() + rand.nextInt(5), true);
                        player.sendMessage(new TextComponent("???"), player.getUUID());
                    }
                    default -> {
                        System.out.println(fx + " ERROR");
                        player.sendMessage(new TextComponent("ERROR"), player.getUUID());
                    }
                }

            }

        }

    }

}
package com.github.atheera.swordsoftheend.entities.living;

import com.github.atheera.swordsoftheend.SOTE;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ShadeEntity extends Monster {

    private static final ResourceLocation LOOT_TABLE = new ResourceLocation(SOTE.MOD_ID, "entities/shade_entity");

    public ShadeEntity(EntityType<? extends Monster> entity, Level level) {
        super(entity, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.FOLLOW_RANGE, 35.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.5F)
            .add(Attributes.ATTACK_DAMAGE, 1.5D)
            .add(Attributes.ARMOR, 1.0D)
            .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE)
            .add(Attributes.KNOCKBACK_RESISTANCE, 10.0f)
            .add(Attributes.MAX_HEALTH, 30.0f);
    }

    @Override
    public void tick() {
        if(!this.level.isClientSide && this.isAlive()) {
            if(this.isSunBurnTick()) {
                this.hurt(DamageSource.ON_FIRE, 5.0f);
            } else if(this.getBrightness() >= 5) {

            }
        }

        super.tick();
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return LOOT_TABLE;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(5, new MeleeAttackGoal(this, 1.5D, true));
    }
}
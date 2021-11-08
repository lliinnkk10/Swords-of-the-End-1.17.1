package com.github.atheera.swordsoftheend.inits;

import com.github.atheera.swordsoftheend.entities.living.ShadeEntity;
import com.github.atheera.swordsoftheend.entities.thrown.MagmaballEntity;
import com.github.atheera.swordsoftheend.entities.thrown.SwordSlashEntity;
import com.github.atheera.swordsoftheend.objects.blocks.BlockEnchanterBE;
import com.github.atheera.swordsoftheend.objects.blocks.BlockInfuserBE;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.github.atheera.swordsoftheend.SOTE.MOD_ID;

public class EntityInit {

    private EntityInit() {}

    // * * * * * * * * * * * * Initialize * * * * * * * * * * * * \\
    public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCKENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MOD_ID);

    // * * * * * * * * * * * * Create Objects * * * * * * * * * * * * \\

        // * * * * * * * * * * * * Misc * * * * * * * * * * * * \\
    public static final RegistryObject<EntityType<MagmaballEntity>> MAGMABALL = ENTITY.register("magmaball_entity",
        () -> EntityType.Builder.<MagmaballEntity>of(MagmaballEntity::new, MobCategory.MISC)
        .sized(0.5f, 0.5f).build(String.valueOf((new ResourceLocation(MOD_ID, "magmaball_entity")))));
    public static final RegistryObject<EntityType<SwordSlashEntity>> SWORD_SLASH = ENTITY.register("sword_slash_entity",
        () -> EntityType.Builder.<SwordSlashEntity>of(SwordSlashEntity::new, MobCategory.MISC)
        .sized(1.0f, 0.5f).build(String.valueOf((new ResourceLocation(MOD_ID, "sword_slash_entity")))));

        // * * * * * * * * * * * * Mobs * * * * * * * * * * * * \\
    public static final RegistryObject<EntityType<ShadeEntity>> SHADE_ENTITY = ENTITY.register("shade_entity", () ->
        EntityType.Builder.<ShadeEntity>of(ShadeEntity::new, MobCategory.MONSTER).sized(1.0f, 2.0f).setTrackingRange(50)
        .build((new ResourceLocation(MOD_ID, "shade_entity").toString())));

        // * * * * * * * * * * * * Block Entities * * * * * * * * * * * * \\
    public static final RegistryObject<BlockEntityType<BlockInfuserBE>> BLOCK_INFUSER_BE = BLOCKENTITIES.register("block_infuser",
            () -> BlockEntityType.Builder.of(BlockInfuserBE::new, BlockInit.BLOCK_ENCHANT_INFUSER_GENERATOR.get()).build(null));
    public static final RegistryObject<BlockEntityType<BlockEnchanterBE>> BLOCK_ENCHANTER_BE = BLOCKENTITIES.register("block_enchanter",
            () -> BlockEntityType.Builder.of(BlockEnchanterBE::new, BlockInit.BLOCK_ENCHANT_INFUSER.get()).build(null));
}
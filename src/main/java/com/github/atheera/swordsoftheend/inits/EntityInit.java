package com.github.atheera.swordsoftheend.inits;

import com.github.atheera.swordsoftheend.entities.MagmaballEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.github.atheera.swordsoftheend.SOTE.MOD_ID;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);

    public static final RegistryObject<EntityType<MagmaballEntity>> MAGMABALL = ENTITY.register("magmaball_entity",
            () -> EntityType.Builder.<MagmaballEntity>of(MagmaballEntity::new, MobCategory.MISC)
            .sized(1.0f, 1.0f).build(String.valueOf((new ResourceLocation(MOD_ID, "magmaball_entity")))));


}

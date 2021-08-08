package com.github.atheera.swordsoftheend;

import com.github.atheera.swordsoftheend.entities.render.MagmaballEntityRender;
import com.github.atheera.swordsoftheend.inits.*;
import com.github.atheera.swordsoftheend.utils.ClientEventBus;
import com.github.atheera.swordsoftheend.utils.config.Config;
import com.github.atheera.swordsoftheend.utils.recipe.potions.*;
import com.github.atheera.swordsoftheend.world.OreGeneration;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.RenderProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import net.minecraftforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@Mod("swordsoftheend")
@Mod.EventBusSubscriber(modid = SOTE.MOD_ID, bus = Bus.MOD)
public class SOTE {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "swordsoftheend";
    public static SOTE instance;

    public SOTE() {



        instance = this;

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config);

        try {
            Config.loadConfig(Config.server_config, FMLPaths.CONFIGDIR.get().resolve("swordsoftheend.toml").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::processIMC);
        modEventBus.addListener(this::doClientStuff);

        EnchantInit.ENCHANT.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        BlockInit.ITEMS.register(modEventBus);
        PotionInit.POTIONS.register(modEventBus);
        EntityInit.ENTITY.register(modEventBus);
        RecipeSerializerInit.RECIPE_SERIALIZERS.register(modEventBus);

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::addFeaturesToBiomes);
        
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(this::registerPotions);
    }
    
    private void doClientStuff(final FMLClientSetupEvent event) {
    	event.enqueueWork(ClientEventBus::registerPropertyOverride);

    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    	
    }

    private void processIMC(final InterModProcessEvent event) {
    	
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> e) {

        }
    }

    private void registerRender() {
        ItemRenderer renderer = Minecraft.getInstance().getItemRenderer();


    }

    private void registerPotions() {
        BrewingRecipeRegistry.addRecipe(new StrengthPotion());
        BrewingRecipeRegistry.addRecipe(new DamagePotion());
        BrewingRecipeRegistry.addRecipe(new FallingPotion());
        BrewingRecipeRegistry.addRecipe(new JumpPotion());
        BrewingRecipeRegistry.addRecipe(new PoisonPotion());
        BrewingRecipeRegistry.addRecipe(new WaterPotion());
        BrewingRecipeRegistry.addRecipe(new SlowPotion());
    }

}
package com.github.atheera.swordsoftheend;

import com.github.atheera.swordsoftheend.client.gui.InfuserScreen;
import com.github.atheera.swordsoftheend.inits.*;
import com.github.atheera.swordsoftheend.utils.ClientEventBus;
import com.github.atheera.swordsoftheend.utils.config.Config;
import com.github.atheera.swordsoftheend.utils.recipe.potions.*;
import com.github.atheera.swordsoftheend.world.OreGeneration;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static com.github.atheera.swordsoftheend.SOTE.MOD_ID;

@Mod(MOD_ID)
@Mod.EventBusSubscriber(modid = MOD_ID, bus = Bus.MOD)
public class SOTE {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "swordsoftheend";
    public static SOTE instance;
    public static final ResourceLocation DISTANCE_PROPERTY = new ResourceLocation(MOD_ID, "distance");

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
        BlockInit.BLOCKS.register(modEventBus);
        BlockInit.ITEMS.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        PotionInit.POTIONS.register(modEventBus);
        EntityInit.ENTITY.register(modEventBus);
        EntityInit.BLOCKENTITIES.register(modEventBus);
        ContainerInit.CONTAINERS.register(modEventBus);
        RecipeSerializerInit.RECIPE_SERIALIZERS.register(modEventBus);

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::addFeaturesToBiomes);
        
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(this::registerPotions);
    }
    
    private void doClientStuff(final FMLClientSetupEvent event) {
        MenuScreens.register(ContainerInit.INFUSER_GENERATOR_CONTAINER.get(), InfuserScreen::new);
        ItemBlockRenderTypes.setRenderLayer(BlockInit.BLOCK_CLUSTER_RUBY.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.BLOCK_BUD_LARGE_RUBY.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.BLOCK_BUD_MEDIUM_RUBY.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.BLOCK_BUD_SMALL_RUBY.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.BLOCK_CLUSTER_SAPPHIRE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.BLOCK_BUD_LARGE_SAPPHIRE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.BLOCK_BUD_MEDIUM_SAPPHIRE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.BLOCK_BUD_SMALL_SAPPHIRE.get(), RenderType.translucent());
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
package com.github.atheera.swordsoftheend.utils.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        DataGenerator generator = event.getGenerator();

        if(event.includeServer()) {
            generator.addProvider(new RecipeGenerators(generator));
            generator.addProvider(new LootTables(generator));
            generator.addProvider(new Tags(generator, event.getExistingFileHelper()));
        }

        if(event.includeClient()) {
            generator.addProvider(new BlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new ItemGenerator(generator, event.getExistingFileHelper()));
        }

    }

}
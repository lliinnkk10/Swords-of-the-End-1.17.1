package com.github.atheera.swordsoftheend.utils.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import com.github.atheera.swordsoftheend.*;

import java.io.File;
import java.io.IOException;

@Mod.EventBusSubscriber
public class Config {

    private static final ForgeConfigSpec.Builder server_builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec server_config;

    static {

        OregenConfig.init(server_builder);

        server_config = server_builder.build();
    }

    public static void loadConfig(ForgeConfigSpec config, String path) throws IOException, IllegalStateException {

        SOTE.LOGGER.info("Loading config: " + path);
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        SOTE.LOGGER.info("Built config: " + path);
        file.load();
        SOTE.LOGGER.info("Loaded config: " + path);
        config.setConfig(file);

    }

}
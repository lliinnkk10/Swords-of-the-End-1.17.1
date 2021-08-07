package com.github.atheera.swordsoftheend.utils.config;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;

public class ConfigScreen extends Screen {

    private static final int TITLE_HEIGHT = 8;

    private static final int OPTIONS_LIST_TOP_HEIGHT = 24;
    private static final int OPTIONS_LIST_BOTTOM_OFFSET = 32;
    private static final int OPTIONS_LIST_ITEM_HEIGHT = 25;

    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 20;
    private static final int DONE_BUTTON_TOP_OFFSET = 26;

    private OptionsList optionsList;

    public ConfigScreen() {
        super(new TranslatableComponent("swordsoftheend.configGui.title", "Swords Of The End Configuration Menu"));
    }

    public interface IPressable {
        void onPress(Button button);
    }

    @Override
    protected void init() {

        assert this.minecraft != null;
        this.optionsList = new OptionsList(this.minecraft, this.width, this.height, OPTIONS_LIST_TOP_HEIGHT,
                                   this.height - OPTIONS_LIST_BOTTOM_OFFSET,
                                           OPTIONS_LIST_ITEM_HEIGHT);

        this.addWidget(new Button(
                (this.width - BUTTON_WIDTH) / 2,
                this.height - DONE_BUTTON_TOP_OFFSET,
                BUTTON_WIDTH, BUTTON_HEIGHT,
                new TranslatableComponent("gui.done", "Done"),
                button -> this.onClose()
        ));

        //this.children().add(optionsList.children());

        super.init();
    }

    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float partialTicks) {

        this.renderBackground(stack);

        drawCenteredString(stack, this.font, this.title.getString(), this.width/2, TITLE_HEIGHT, 0xFFFFFF);

        super.render(stack, mouseX, mouseY, partialTicks);
    }
}
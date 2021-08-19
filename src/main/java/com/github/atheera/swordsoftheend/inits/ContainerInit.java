package com.github.atheera.swordsoftheend.inits;

import com.github.atheera.swordsoftheend.SOTE;
import com.github.atheera.swordsoftheend.client.gui.EnchanterContainer;
import com.github.atheera.swordsoftheend.client.gui.InfuserContainer;
import com.github.atheera.swordsoftheend.client.gui.LightsaberContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.github.atheera.swordsoftheend.utils.Constantz.*;

public class ContainerInit {

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, SOTE.MOD_ID);

    public static final RegistryObject<MenuType<InfuserContainer>> INFUSER_GENERATOR_CONTAINER = CONTAINERS.register(ENCHANT_INFUSER_GENERATOR,
            () -> IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                Level world = inv.player.getCommandSenderWorld();
                return new InfuserContainer(windowId, world, pos, inv, inv.player);
            }));

    public static final RegistryObject<MenuType<EnchanterContainer>> INFUSION_ENCHANTER_CONTAINER = CONTAINERS.register(ENCHANT_INFUSER,
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                Level world = inv.player.getCommandSenderWorld();
                return new EnchanterContainer(windowId, world, pos, inv, inv.player);
            })));

    public static final RegistryObject<MenuType<LightsaberContainer>> LIGHTSABER_CONTAINER = CONTAINERS.register(SWORD_SABER,
            () -> IForgeContainerType.create((windowId, inv, data) -> {

                Level world = inv.player.getCommandSenderWorld();
                return new LightsaberContainer(windowId, world, inv, inv.player);
            }));

}
package com.github.atheera.swordsoftheend.inits;

import com.github.atheera.swordsoftheend.SOTE;
import com.github.atheera.swordsoftheend.client.gui.InfuserContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerInit {

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, SOTE.MOD_ID);

    public static final RegistryObject<MenuType<InfuserContainer>> INFUSER_GENERATOR_CONTAINER = CONTAINERS.register("block_infuser",
            () -> IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                Level world = inv.player.getCommandSenderWorld();
                return new InfuserContainer(windowId, world, pos, inv, inv.player);
            }));

}
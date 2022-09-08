package com.pnm.musicdiscsmod.screen;

import com.pnm.musicdiscsmod.MusicDiscsMod;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public final class ModContainers {

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(
            ForgeRegistries.CONTAINERS, MusicDiscsMod.MOD_ID);
    public static final RegistryObject<MenuType<PortableJukeboxContainer>> PORTABLE_JUKEBOX = CONTAINERS
            .register("portable_jukebox", () -> new MenuType<>(PortableJukeboxContainer::new));

    public static void register(IEventBus eventBus){
        CONTAINERS.register(eventBus);
    }
}

package com.pnm.musicdiscsmod.event;


import com.pnm.musicdiscsmod.MusicDiscsMod;
import com.pnm.musicdiscsmod.item.ModItems;
import com.pnm.musicdiscsmod.screen.ModContainers;
import com.pnm.musicdiscsmod.screen.PortableJukeboxScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MusicDiscsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEvents {

    private ModEvents() {
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        MenuScreens.register(ModContainers.PORTABLE_JUKEBOX.get(), PortableJukeboxScreen::new);
    }
}

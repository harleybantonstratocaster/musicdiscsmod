package com.pnm.musicdiscsmod.item;

import com.pnm.musicdiscsmod.ModCreativeTab;
import com.pnm.musicdiscsmod.MusicDiscsMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MusicDiscsMod.MOD_ID);

    public static final RegistryObject<Item> RECORD_SLEEVE = ITEMS.register("recordsleeve",
            () -> new RecordSleeveItem(new Item.Properties().tab(ModCreativeTab.MUSIC_DISCS_TAB)));

    public static final RegistryObject<Item> PORTABLE_JUKEBOX = ITEMS.register("portablejukebox",
            () -> new PortableJukeboxItem(new Item.Properties().tab(ModCreativeTab.MUSIC_DISCS_TAB).stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

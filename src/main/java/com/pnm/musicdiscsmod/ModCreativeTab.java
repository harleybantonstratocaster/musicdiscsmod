package com.pnm.musicdiscsmod;

import com.pnm.musicdiscsmod.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {

    public static final CreativeModeTab MUSIC_DISCS_TAB = new CreativeModeTab("musicdiscsmodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.RECORD_SLEEVE.get());
        }
    };
}

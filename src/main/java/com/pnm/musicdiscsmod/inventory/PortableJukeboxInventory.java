package com.pnm.musicdiscsmod.inventory;

import com.pnm.musicdiscsmod.MusicDiscsMod;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class PortableJukeboxInventory implements ICapabilitySerializable<CompoundTag> {

    public static final int size = 1;
    protected LazyOptional<IItemHandler> handler;
    public final ItemStackHandler inventory;
    public static final Component TITLE = new TranslatableComponent(
            "Container" + MusicDiscsMod.MOD_ID + ".portable_jukebox");

    public PortableJukeboxInventory() {
        this.inventory = createInventory();
        this.handler = LazyOptional.of(() -> this.inventory);

    }

    private ItemStackHandler createInventory() {
        return new ItemStackHandler(this.size);
    }


    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return null;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.put("inventory",inventory.serializeNBT());
        return nbt;

    }


    @Override
   public void deserializeNBT(CompoundTag nbt) {
        inventory.deserializeNBT(nbt.getCompound("inventory"));
    }

}


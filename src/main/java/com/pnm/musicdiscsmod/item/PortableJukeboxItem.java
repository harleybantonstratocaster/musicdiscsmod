package com.pnm.musicdiscsmod.item;


import com.pnm.musicdiscsmod.inventory.PortableJukeboxInventory;
import com.pnm.musicdiscsmod.screen.PortableJukeboxContainer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;


public class PortableJukeboxItem extends Item {
    PortableJukeboxInventory inv = new PortableJukeboxInventory();
    public PortableJukeboxItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        CompoundTag nbt = new CompoundTag();
        inv.deserializeNBT(nbt);
        if(!pLevel.isClientSide) {
            MenuProvider container = new SimpleMenuProvider(PortableJukeboxContainer.getServerContainer(inv),PortableJukeboxInventory.TITLE);
            NetworkHooks.openGui((ServerPlayer) pPlayer, container);
        }

        return super.use(pLevel,pPlayer,pUsedHand);

    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        inv.serializeNBT();
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        if( stack.getItem() == ModItems.PORTABLE_JUKEBOX.get()){
            return new PortableJukeboxInventory();
        }
        return super.initCapabilities(stack, nbt);
    }

}
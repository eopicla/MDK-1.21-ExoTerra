package com.ultricem.exoterra.block.custom.simplegenerator;

import com.ultricem.exoterra.Config;
import com.ultricem.exoterra.block.ModBlocks;
import com.ultricem.exoterra.capabilities.SimpleGenEnergyStorage;
import com.ultricem.exoterra.capabilities.SimpleGenItemHandler;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.level.block.entity.BlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;

import javax.annotation.Nullable;

public class SimpleGeneratorBE extends BlockEntity implements MenuProvider {

    public enum Slots {
        FUEL(0),
        CHARGE(1);

        int id;

        Slots(int number) {
            id = number;
        }

        public int getId() {
            return id;
        }
    }

    private int counter = 0;
    private int maxBurn = 0;

    public SimpleGenEnergyStorage energyStorage;
    public SimpleGenItemHandler inventory = new SimpleGenItemHandler(this);

    public final ContainerData simpleGeneratorData = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> SimpleGeneratorBE.this.energyStorage.getEnergyStored() / 32;
                case 1 -> SimpleGeneratorBE.this.energyStorage.getMaxEnergyStored() / 32;
                case 2 -> SimpleGeneratorBE.this.counter;
                case 3 -> SimpleGeneratorBE.this.maxBurn;
                default -> throw new IllegalArgumentException("Invalid index: " + index);
            };
        }

        @Override
        public void set(int index, int value) {
            throw new IllegalStateException("Cannot set values through IIntArray");
        }

        @Override
        public int getCount() {
            return 4;
        }
    };

    public SimpleGeneratorBE(BlockPos pos, BlockState state) {
        super(ModBlocks.SIMPLE_GENERATOR_BE.get(), pos, state);
        this.energyStorage = new SimpleGenEnergyStorage(this, 0, Config.GENERAL.simpleGenMaxPower.get());
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory playerInventory, Player playerEntity) {
        assert level != null;
        return new SimpleGeneratorContainer(this, this.simpleGeneratorData, i, playerInventory, this.inventory);
    }

    public static <T extends BlockEntity> void ticker(Level level, BlockPos blockPos, BlockState state, T t) {
        if (t instanceof SimpleGeneratorBE entity) {
            entity.tryBurn();

            ItemStack stack = entity.inventory.getStackInSlot(Slots.CHARGE.id);
            if (!stack.isEmpty())
                entity.chargeItem(stack);
        }
    }


    private void chargeItem(ItemStack stack) {
        IEnergyStorage energy = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if (energy == null) return;
        if (!isChargingItem(energy))
            return;

        int energyRemoved = energy.receiveEnergy(Math.min(energyStorage.getEnergyStored(), 2500), false);
        energyStorage.consumeEnergy(energyRemoved, false);
    }

    public boolean isChargingItem(IEnergyStorage energy) {
        return energy.getEnergyStored() >= 0 && energy.receiveEnergy(energy.getEnergyStored(), true) >= 0;
    }

    private void tryBurn() {
        if (level == null)
            return;

        boolean canInsertEnergy = energyStorage.receiveEnergy(625, true) > 0;
        if (counter > 0 && canInsertEnergy) {
            burn(energyStorage);
        } else if (canInsertEnergy) {
            if (initBurn())
                burn(energyStorage);
        }
    }


    private void burn(IEnergyStorage energyStorage) {
        energyStorage.receiveEnergy(625, false);

        counter--;
        if (counter == 0) {
            maxBurn = 0;
            initBurn();
        }
    }

    private boolean initBurn() {
        ItemStack stack = inventory.getStackInSlot(Slots.FUEL.id);

        int burnTime = stack.getBurnTime(RecipeType.SMELTING);
        if (burnTime > 0) {
            //Item fuelStack = inventory.getStackInSlot(Slots.FUEL.id).getItem();
            ItemStack fuelStack = inventory.getStackInSlot(Slots.FUEL.id);
            if (fuelStack.hasCraftingRemainingItem())
                inventory.setStackInSlot(Slots.FUEL.id, fuelStack.getCraftingRemainingItem());
            else
                fuelStack.shrink(1);

            setChanged();
            counter = (int) Math.floor(burnTime) / 50;
            maxBurn = counter;
            return true;
        }
        return false;
    }

    @Override
    public void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        super.loadAdditional(compound, provider);

        inventory.deserializeNBT(provider, compound.getCompound("inv"));
        energyStorage.deserializeNBT(provider, compound.getCompound("energy"));
        counter = compound.getInt("counter");
        maxBurn = compound.getInt("maxburn");
    }

    @Override
    public void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        compound.put("inv", inventory.serializeNBT(provider));
        compound.put("energy", energyStorage.serializeNBT(provider));

        compound.putInt("counter", counter);
        compound.putInt("maxburn", maxBurn);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        // Vanilla uses the type parameter to indicate which type of tile entity (command block, skull, or beacon?) is receiving the packet, but it seems like Forge has overridden this behavior
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag, provider);
        return tag;
    }


    @Override
    public void handleUpdateTag(CompoundTag tag, HolderLookup.Provider lookupProvider) {
        this.loadAdditional(tag, lookupProvider);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider lookupProvider) {
        super.onDataPacket(net, pkt, lookupProvider);
        //loadAdditional(pkt.getTag(), lookupProvider);
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Simple Generator BE");
    }
}
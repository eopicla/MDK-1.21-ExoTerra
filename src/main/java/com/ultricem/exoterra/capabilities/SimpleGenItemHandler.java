package com.ultricem.exoterra.capabilities;

import com.ultricem.exoterra.block.custom.simplegenerator.SimpleGeneratorBE;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class SimpleGenItemHandler extends ItemStackHandler {

    private final SimpleGeneratorBE simpleGeneratorBE;

    public SimpleGenItemHandler(SimpleGeneratorBE simpleGenTile) {
        super(2);
        this.simpleGeneratorBE = simpleGenTile;
    }

    @Override
    protected void onContentsChanged(int slot) {
        simpleGeneratorBE.setChanged();
    }

    @Nonnull
    @Override
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
        if (slot == SimpleGeneratorBE.Slots.FUEL.getId() && stack.getItem() == Items.BUCKET)
            return super.insertItem(slot, stack, simulate);

        if (slot == SimpleGeneratorBE.Slots.FUEL.getId() && stack.getBurnTime(RecipeType.SMELTING) <= 0)
            return stack;

        if (slot == SimpleGeneratorBE.Slots.CHARGE.getId() && (stack.getCapability(Capabilities.EnergyStorage.ITEM) == null || getStackInSlot(slot).getCount() > 0))
            return stack;

        return super.insertItem(slot, stack, simulate);
    }
}

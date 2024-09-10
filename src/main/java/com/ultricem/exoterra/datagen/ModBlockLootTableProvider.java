package com.ultricem.exoterra.datagen;

import com.ultricem.exoterra.block.ModBlocks;
import com.ultricem.exoterra.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.IRIDIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.IRIDIUM_ORE.get(), ModItems.IRIDIUM_ORE_ITEM.get()));
        this.add(ModBlocks.DEEPSLATE_IRIDIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_IRIDIUM_ORE.get(), ModItems.IRIDIUM_ORE_ITEM.get()));

        this.add(ModBlocks.BAUXITE_ORE.get(),
                block -> createOreDrop(ModBlocks.BAUXITE_ORE.get(), ModItems.BAUXITE_ORE_ITEM.get()));
        this.add(ModBlocks.DEEPSLATE_BAUXITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_BAUXITE_ORE.get(), ModItems.BAUXITE_ORE_ITEM.get()));

        this.add(ModBlocks.CASSERITE_ORE.get(),
                block -> createOreDrop(ModBlocks.CASSERITE_ORE.get(), ModItems.CASSERITE_ORE_ITEM.get()));
        this.add(ModBlocks.DEEPSLATE_CASSERITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_CASSERITE_ORE.get(), ModItems.CASSERITE_ORE_ITEM.get()));

        this.add(ModBlocks.RUTILE_ORE.get(),
                block -> createOreDrop(ModBlocks.RUTILE_ORE.get(), ModItems.RUTILE_ORE_ITEM.get()));
        this.add(ModBlocks.DEEPSLATE_RUTILE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_RUTILE_ORE.get(), ModItems.RUTILE_ORE_ITEM.get()));

        this.add(ModBlocks.MAGNESITE_ORE.get(),
                block -> createOreDrop(ModBlocks.MAGNESITE_ORE.get(), ModItems.MAGNESITE_ORE_ITEM.get()));
        this.add(ModBlocks.DEEPSLATE_MAGNESITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_MAGNESITE_ORE.get(), ModItems.MAGNESITE_ORE_ITEM.get()));



        dropSelf(ModBlocks.BASIC_MOTOR.get());
        dropSelf(ModBlocks.ENHANCED_MOTOR.get());
        dropSelf(ModBlocks.ADVANCED_MOTOR.get());
        dropSelf(ModBlocks.ELITE_MOTOR.get());

        dropSelf(ModBlocks.BASIC_MACHINE_STRUCTURE.get());
        dropSelf(ModBlocks.ADVANCED_MACHINE_STRUCTURE.get());
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}

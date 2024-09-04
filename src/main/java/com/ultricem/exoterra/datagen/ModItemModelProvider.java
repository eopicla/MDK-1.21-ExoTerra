package com.ultricem.exoterra.datagen;

import com.ultricem.exoterra.ExoTerra;

import com.ultricem.exoterra.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ExoTerra.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        /**
         * Items
         */

        basicItem(ModItems.COMMON_SILICA_SAND.get());
        basicItem(ModItems.SILICON_WAFER.get());
        basicItem(ModItems.SILICON_BOULE.get());
        basicItem(ModItems.IRIDIUM_INGOT.get());
        basicItem(ModItems.IRIDIUM_NUGGET.get());
        basicItem(ModItems.IRIDIUM_ROD.get());
        basicItem(ModItems.IRIDIUM_PLATE.get());
        basicItem(ModItems.IRIDIUM_POWDER.get());
        basicItem(ModItems.IRIDIUM_ORE_ITEM.get());
        basicItem(ModItems.BAUXITE_ORE_ITEM.get());
        basicItem(ModItems.ALUMINUM_INGOT.get());
        basicItem(ModItems.ALUMINUM_NUGGET.get());
        basicItem(ModItems.ALUMINUM_ROD.get());
        basicItem(ModItems.ALUMINUM_PLATE.get());
        basicItem(ModItems.ALUMINUM_POWDER.get());
        basicItem(ModItems.RAW_ALUMINUM.get());
        basicItem(ModItems.CASSERITE_ORE_ITEM.get());
        basicItem(ModItems.TIN_INGOT.get());
        basicItem(ModItems.TIN_NUGGET.get());
        basicItem(ModItems.TIN_ROD.get());
        basicItem(ModItems.TIN_PLATE.get());
        basicItem(ModItems.TIN_POWDER.get());
        basicItem(ModItems.RUTILE_ORE_ITEM.get());
        basicItem(ModItems.TITANIUM_INGOT.get());
        basicItem(ModItems.TITANIUM_NUGGET.get());
        basicItem(ModItems.TITANIUM_ROD.get());
        basicItem(ModItems.TITANIUM_PLATE.get());
        basicItem(ModItems.TITANIUM_POWDER.get());
        basicItem(ModItems.RAW_TITANIUM.get());
        basicItem(ModItems.STEEL_INGOT.get());
        basicItem(ModItems.STEEL_NUGGET.get());
        basicItem(ModItems.STEEL_ROD.get());
        basicItem(ModItems.STEEL_PLATE.get());
        basicItem(ModItems.STEEL_POWDER.get());
        basicItem(ModItems.MAGNESITE_ORE_ITEM.get());
        basicItem(ModItems.MAGNESIUM_POWDER.get());
        basicItem(ModItems.SULFUR_POWDER.get());
        basicItem(ModItems.ALUMINA.get());
    }
}
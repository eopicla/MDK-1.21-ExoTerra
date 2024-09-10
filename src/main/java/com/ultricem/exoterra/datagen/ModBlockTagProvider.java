package com.ultricem.exoterra.datagen;

import com.ultricem.exoterra.ExoTerra;
import com.ultricem.exoterra.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExoTerra.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.IRIDIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_IRIDIUM_ORE.get())
                .add(ModBlocks.BAUXITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_BAUXITE_ORE.get())
                .add(ModBlocks.CASSERITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_CASSERITE_ORE.get())
                .add(ModBlocks.RUTILE_ORE.get())
                .add(ModBlocks.DEEPSLATE_RUTILE_ORE.get())
                .add(ModBlocks.MAGNESITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_MAGNESITE_ORE.get())

                .add(ModBlocks.BASIC_MOTOR.get())
                .add(ModBlocks.ADVANCED_MOTOR.get())
                .add(ModBlocks.ENHANCED_MOTOR.get())
                .add(ModBlocks.ELITE_MOTOR.get())

                .add(ModBlocks.BASIC_MACHINE_STRUCTURE.get())
                .add(ModBlocks.ADVANCED_MACHINE_STRUCTURE.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.IRIDIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_IRIDIUM_ORE.get())
                .add(ModBlocks.BAUXITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_BAUXITE_ORE.get())
                .add(ModBlocks.CASSERITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_CASSERITE_ORE.get())
                .add(ModBlocks.RUTILE_ORE.get())
                .add(ModBlocks.DEEPSLATE_RUTILE_ORE.get())
                .add(ModBlocks.MAGNESITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_MAGNESITE_ORE.get())

                .add(ModBlocks.BASIC_MOTOR.get())
                .add(ModBlocks.ADVANCED_MOTOR.get())
                .add(ModBlocks.ENHANCED_MOTOR.get())
                .add(ModBlocks.ELITE_MOTOR.get())

                .add(ModBlocks.BASIC_MACHINE_STRUCTURE.get())
                .add(ModBlocks.ADVANCED_MACHINE_STRUCTURE.get());
    }
}
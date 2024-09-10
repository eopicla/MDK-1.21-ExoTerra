package com.ultricem.exoterra.datagen;

import com.ultricem.exoterra.ExoTerra;
import com.ultricem.exoterra.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.awt.*;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ExoTerra.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.IRIDIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_IRIDIUM_ORE);

        blockWithItem(ModBlocks.BAUXITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_BAUXITE_ORE);

        blockWithItem(ModBlocks.CASSERITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_CASSERITE_ORE);

        blockWithItem(ModBlocks.RUTILE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_RUTILE_ORE);

        blockWithItem(ModBlocks.MAGNESITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_MAGNESITE_ORE);

    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("exoterra:block/" + deferredBlock.getId().getPath()));
    }

}
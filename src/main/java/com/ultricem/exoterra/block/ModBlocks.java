package com.ultricem.exoterra.block;

import com.ultricem.exoterra.ExoTerra;
import com.ultricem.exoterra.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ExoTerra.MOD_ID);


    public static final DeferredBlock<Block> IRIDIUM_ORE = registerBlock("iridium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_IRIDIUM_ORE = registerBlock("deepslate_iridium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));


    public static final DeferredBlock<Block> BAUXITE_ORE = registerBlock("bauxite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_BAUXITE_ORE = registerBlock("deepslate_bauxite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));


    public static final DeferredBlock<Block> CASSERITE_ORE = registerBlock("casserite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_CASSERITE_ORE = registerBlock("deepslate_casserite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));


    public static final DeferredBlock<Block> RUTILE_ORE = registerBlock("rutile_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_RUTILE_ORE = registerBlock("deepslate_rutile_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));


    public static final DeferredBlock<Block> MAGNESITE_ORE = registerBlock("magnesite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_MAGNESITE_ORE = registerBlock("deepslate_magnesite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

package com.ultricem.exoterra.block;

import com.mojang.serialization.MapCodec;
import com.ultricem.exoterra.ExoTerra;
import com.ultricem.exoterra.block.custom.MotorBlock;
import com.ultricem.exoterra.block.custom.simplegenerator.SimpleGeneratorBE;
import com.ultricem.exoterra.block.custom.simplegenerator.SimpleGeneratorBlock;
import com.ultricem.exoterra.block.custom.simplegenerator.SimpleGeneratorContainer;
import com.ultricem.exoterra.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ExoTerra.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ExoTerra.MOD_ID);
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(Registries.MENU, ExoTerra.MOD_ID);

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

    //NOTE: Motor Blocks V
    public static final DeferredBlock<Block> BASIC_MOTOR = registerBlock("basic_motor", () -> new MotorBlock(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ADVANCED_MOTOR = registerBlock("advanced_motor", () -> new MotorBlock(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ENHANCED_MOTOR = registerBlock("enhanced_motor", () -> new MotorBlock(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> ELITE_MOTOR = registerBlock("elite_motor", () -> new MotorBlock(BlockBehaviour.Properties.of()));

    //NOTE: Machine Structure Blocks V
    public static final DeferredBlock<Block> BASIC_MACHINE_STRUCTURE = registerBlock("basic_machine_structure", () -> new Block(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.METAL)));
    public static final DeferredBlock<Block> ADVANCED_MACHINE_STRUCTURE = registerBlock("advanced_machine_structure", () -> new Block(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.METAL)));

    //NOTE: Power I/O Plug Blocks
    public static final DeferredBlock<Block> POWER_INPUT_PLUG = registerBlock("power_input_plug", () -> new Block(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.METAL)));
    public static final DeferredBlock<Block> POWER_OUTPUT_PLUG = registerBlock("power_output_plug", () -> new Block(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.METAL)));

    //NOTE: Fluid I/O Hatch Blocks
    public static final DeferredBlock<Block> FLUID_INPUT_HATCH = registerBlock("fluid_input_hatch", () -> new Block(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.METAL)));
    public static final DeferredBlock<Block> FLUID_OUTPUT_HATCH = registerBlock("fluid_output_hatch", () -> new Block(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.METAL)));

    //NOTE: Simple Generator Block
    public static final DeferredHolder<Block, SimpleGeneratorBlock> SIMPLE_GENERATOR = BLOCKS.register("simple_generator", SimpleGeneratorBlock::new);
    public static final Supplier<BlockEntityType<SimpleGeneratorBE>> SIMPLE_GENERATOR_BE = BLOCK_ENTITIES.register("simple_generator_be", () -> BlockEntityType.Builder.of(SimpleGeneratorBE::new, SIMPLE_GENERATOR.get()).build(null));
    public static final Supplier<MenuType<SimpleGeneratorContainer>> SIMPLE_GENERATOR_CONTAINER = CONTAINERS.register("simple_generator_container", () -> IMenuTypeExtension.create(SimpleGeneratorContainer::new));


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
        BLOCK_ENTITIES.register(eventBus);
        CONTAINERS.register(eventBus);
    }
}

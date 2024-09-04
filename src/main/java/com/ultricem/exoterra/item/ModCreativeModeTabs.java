package com.ultricem.exoterra.item;

import com.ultricem.exoterra.ExoTerra;
import com.ultricem.exoterra.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExoTerra.MOD_ID);

    public static final Supplier<CreativeModeTab> EXOTERRA_ITEMS_TAB = CREATIVE_MODE_TAB.register("exoterra_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SILICON_WAFER.get()))
                    .title(Component.translatable("creativetab.exoterra.exoterra_items"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.ALUMINUM_INGOT);
                        output.accept(ModItems.ALUMINUM_NUGGET);
                        output.accept(ModItems.ALUMINUM_PLATE);
                        output.accept(ModItems.ALUMINUM_POWDER);
                        output.accept(ModItems.ALUMINUM_ROD);
                        output.accept(ModItems.IRIDIUM_INGOT);
                        output.accept(ModItems.IRIDIUM_NUGGET);
                        output.accept(ModItems.IRIDIUM_PLATE);
                        output.accept(ModItems.IRIDIUM_POWDER);
                        output.accept(ModItems.IRIDIUM_ROD);
                        output.accept(ModItems.MAGNESIUM_POWDER);
                        output.accept(ModItems.STEEL_INGOT);
                        output.accept(ModItems.STEEL_NUGGET);
                        output.accept(ModItems.STEEL_PLATE);
                        output.accept(ModItems.STEEL_POWDER);
                        output.accept(ModItems.STEEL_ROD);
                        output.accept(ModItems.TIN_INGOT);
                        output.accept(ModItems.TIN_NUGGET);
                        output.accept(ModItems.TIN_PLATE);
                        output.accept(ModItems.TIN_POWDER);
                        output.accept(ModItems.TIN_ROD);
                        output.accept(ModItems.TITANIUM_INGOT);
                        output.accept(ModItems.TITANIUM_NUGGET);
                        output.accept(ModItems.TITANIUM_PLATE);
                        output.accept(ModItems.TITANIUM_POWDER);
                        output.accept(ModItems.TITANIUM_ROD);

                    }).build());

    public static final Supplier<CreativeModeTab> EXOTERRA_RESOURCES_TAB = CREATIVE_MODE_TAB.register("exoterra_resources_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_TITANIUM.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExoTerra.MOD_ID, "exoterra_items_tab"))
                    .title(Component.translatable("creativetab.exoterra.exoterra_resources"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.IRIDIUM_ORE_ITEM);
                        output.accept(ModItems.BAUXITE_ORE_ITEM);
                        output.accept(ModItems.CASSERITE_ORE_ITEM);
                        output.accept(ModItems.RUTILE_ORE_ITEM);
                        output.accept(ModItems.MAGNESITE_ORE_ITEM);
                        output.accept(ModItems.RAW_ALUMINUM);
                        output.accept(ModItems.RAW_TITANIUM);
                        output.accept(ModItems.ALUMINA);
                        output.accept(ModItems.SULFUR_POWDER);
                        output.accept(ModItems.COMMON_SILICA_SAND);

                    }).build());

    public static final Supplier<CreativeModeTab> EXOTERRA_BLOCKS_TAB = CREATIVE_MODE_TAB.register("exoterra_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BAUXITE_ORE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExoTerra.MOD_ID, "exoterra_resources_tab"))
                    .title(Component.translatable("creativetab.exoterra.exoterra_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.IRIDIUM_ORE);
                        output.accept(ModBlocks.DEEPSLATE_IRIDIUM_ORE);

                        output.accept(ModBlocks.BAUXITE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_BAUXITE_ORE);

                        output.accept(ModBlocks.CASSERITE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_CASSERITE_ORE);

                        output.accept(ModBlocks.RUTILE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_RUTILE_ORE);

                        output.accept(ModBlocks.MAGNESITE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_MAGNESITE_ORE);

                    }).build());

    public static final Supplier<CreativeModeTab> EXOTERRA_COMPONENTS_TAB = CREATIVE_MODE_TAB.register("exoterra_components_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.ARMOR_STAND))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExoTerra.MOD_ID, "exoterra_blocks_tab"))
                    .title(Component.translatable("creativetab.exoterra.exoterra_components"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.SILICON_BOULE);
                        output.accept(ModItems.SILICON_WAFER);

                    }).build());

    public static final Supplier<CreativeModeTab> EXOTERRA_MACHINES_TAB = CREATIVE_MODE_TAB.register("exoterra_machines_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.STONECUTTER))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExoTerra.MOD_ID, "exoterra_components_tab"))
                    .title(Component.translatable("creativetab.exoterra.exoterra_machines"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.ALUMINA);
                        // Add contents here as before

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}

package com.ultricem.exoterra.item;

import com.ultricem.exoterra.ExoTerra;
import com.ultricem.exoterra.block.ModBlocks;
import com.ultricem.exoterra.block.custom.simplegenerator.SimpleGeneratorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExoTerra.MOD_ID);

    /**
     *
     * Below all items
     */
    // Silicon
    public static final DeferredItem<Item> COMMON_SILICA_SAND = ITEMS.registerSimpleItem("common_silica_sand", new Item.Properties());
    public static final DeferredItem<Item> SILICON_WAFER = ITEMS.registerSimpleItem("silicon_wafer", new Item.Properties());
    public static final DeferredItem<Item> SILICON_BOULE = ITEMS.registerSimpleItem("silicon_boule", new Item.Properties());

    // Iridium
    public static final DeferredItem<Item> IRIDIUM_INGOT = ITEMS.registerSimpleItem("iridium_ingot", new Item.Properties());
    public static final DeferredItem<Item> IRIDIUM_NUGGET = ITEMS.registerSimpleItem("iridium_nugget", new Item.Properties());
    public static final DeferredItem<Item> IRIDIUM_ROD = ITEMS.registerSimpleItem("iridium_rod", new Item.Properties());
    public static final DeferredItem<Item> IRIDIUM_PLATE = ITEMS.registerSimpleItem("iridium_plate", new Item.Properties());
    public static final DeferredItem<Item> IRIDIUM_POWDER = ITEMS.registerSimpleItem("iridium_powder", new Item.Properties());
    public static final DeferredItem<Item> IRIDIUM_ORE_ITEM = ITEMS.registerSimpleItem("iridium_ore_item", new Item.Properties());

    // Aluminum / Bauxite
    public static final DeferredItem<Item> BAUXITE_ORE_ITEM = ITEMS.registerSimpleItem("bauxite_ore_item", new Item.Properties());

    public static final DeferredItem<Item> ALUMINUM_INGOT = ITEMS.registerSimpleItem("aluminum_ingot", new Item.Properties());
    public static final DeferredItem<Item> ALUMINUM_NUGGET = ITEMS.registerSimpleItem("aluminum_nugget", new Item.Properties());
    public static final DeferredItem<Item> ALUMINUM_ROD = ITEMS.registerSimpleItem("aluminum_rod", new Item.Properties());
    public static final DeferredItem<Item> ALUMINUM_PLATE = ITEMS.registerSimpleItem("aluminum_plate", new Item.Properties());
    public static final DeferredItem<Item> ALUMINUM_POWDER = ITEMS.registerSimpleItem("aluminum_powder", new Item.Properties());
    public static final DeferredItem<Item> RAW_ALUMINUM = ITEMS.registerSimpleItem("raw_aluminum", new Item.Properties());

    // Tin / Casserite
    public static final DeferredItem<Item> CASSERITE_ORE_ITEM = ITEMS.registerSimpleItem("casserite_ore_item", new Item.Properties());

    public static final DeferredItem<Item> TIN_INGOT = ITEMS.registerSimpleItem("tin_ingot", new Item.Properties());
    public static final DeferredItem<Item> TIN_NUGGET = ITEMS.registerSimpleItem("tin_nugget", new Item.Properties());
    public static final DeferredItem<Item> TIN_ROD = ITEMS.registerSimpleItem("tin_rod", new Item.Properties());
    public static final DeferredItem<Item> TIN_PLATE = ITEMS.registerSimpleItem("tin_plate", new Item.Properties());
    public static final DeferredItem<Item> TIN_POWDER = ITEMS.registerSimpleItem("tin_powder", new Item.Properties());

    // Titanium / Rutile
    public static final DeferredItem<Item> RUTILE_ORE_ITEM = ITEMS.registerSimpleItem("rutile_ore_item", new Item.Properties());

    public static final DeferredItem<Item> TITANIUM_INGOT = ITEMS.registerSimpleItem("titanium_ingot", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> TITANIUM_NUGGET = ITEMS.registerSimpleItem("titanium_nugget", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> TITANIUM_ROD = ITEMS.registerSimpleItem("titanium_rod", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> TITANIUM_PLATE = ITEMS.registerSimpleItem("titanium_plate", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> TITANIUM_POWDER = ITEMS.registerSimpleItem("titanium_powder", new Item.Properties());
    public static final DeferredItem<Item> RAW_TITANIUM = ITEMS.registerSimpleItem("raw_titanium", new Item.Properties());

    // Steel
    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.registerSimpleItem("steel_ingot", new Item.Properties());
    public static final DeferredItem<Item> STEEL_NUGGET = ITEMS.registerSimpleItem("steel_nugget", new Item.Properties());
    public static final DeferredItem<Item> STEEL_ROD = ITEMS.registerSimpleItem("steel_rod", new Item.Properties());
    public static final DeferredItem<Item> STEEL_PLATE = ITEMS.registerSimpleItem("steel_plate", new Item.Properties());
    public static final DeferredItem<Item> STEEL_POWDER = ITEMS.registerSimpleItem("steel_powder", new Item.Properties());

    // Magnesium / Magnesite
    public static final DeferredItem<Item> MAGNESITE_ORE_ITEM = ITEMS.registerSimpleItem("magnesite_ore_item", new Item.Properties());

    public static final DeferredItem<Item> MAGNESIUM_POWDER = ITEMS.registerSimpleItem("magnesium_powder", new Item.Properties());

    // Sulfur
    public static final DeferredItem<Item> SULFUR_POWDER = ITEMS.registerSimpleItem("sulfur_powder", new Item.Properties());

    // Alumina
    public static final DeferredItem<Item> ALUMINA = ITEMS.registerSimpleItem("alumina", new Item.Properties());

    //Simple Generator Item
    public static final Supplier<Item> SIMPLE_GENERATOR_BI = ITEMS.register("simple_generator", () -> new SimpleGeneratorItem(ModBlocks.SIMPLE_GENERATOR.get(), new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

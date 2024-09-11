package com.ultricem.exoterra.setup;

import com.ultricem.exoterra.ExoTerra;
import com.ultricem.exoterra.block.ModBlocks;
import com.ultricem.exoterra.block.custom.simplegenerator.SimpleGeneratorScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = ExoTerra.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void init(final FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModBlocks.SIMPLE_GENERATOR_CONTAINER.get(), SimpleGeneratorScreen::new);
    }
}

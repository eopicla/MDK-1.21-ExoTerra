package com.ultricem.exoterra;

import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class Config
{
    private static final ModConfigSpec.Builder SERVER_BUILDER = new ModConfigSpec.Builder();
    public static final CategoryGeneral GENERAL = new CategoryGeneral();

    public static ModConfigSpec SERVER_CONFIG;

    public static final class CategoryGeneral {
        public final ModConfigSpec.IntValue simpleGenMaxPower;

        private CategoryGeneral() {
            SERVER_BUILDER.comment("General settings").push("general");

            simpleGenMaxPower = SERVER_BUILDER.comment("Maximum power for the Simple Generator")
                    .defineInRange("simpleGenMaxPower", 1000000, 0, Integer.MAX_VALUE);

            SERVER_BUILDER.pop();
            SERVER_CONFIG = SERVER_BUILDER.build();
        }
    }
}

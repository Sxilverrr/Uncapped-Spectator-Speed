package com.sxilverr.uncappedspectatorspeed.forge;

import com.sxilverr.uncappedspectatorspeed.ModConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;

public final class ForgeConfig
{
    private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue CAP_SPECTATOR_SPEED;
    private static final ForgeConfigSpec.DoubleValue MAXIMUM_SPECTATOR_SPEED;
    private static final ForgeConfigSpec.DoubleValue SCROLL_SPEED_MULTIPLIER;
    private static final ForgeConfigSpec.BooleanValue PREVENT_SPECTATOR_DEATH;

    private static final ForgeConfigSpec CLIENT_SPEC;
    private static final ForgeConfigSpec COMMON_SPEC;

    static
    {
        CLIENT_BUILDER.push("Client");
        CAP_SPECTATOR_SPEED = CLIENT_BUILDER
                .comment("Cap spectator speed.")
                .define("cap_spectator_speed", ModConfig.DEFAULT_CAP_SPECTATOR_SPEED);
        MAXIMUM_SPECTATOR_SPEED = CLIENT_BUILDER
                .comment("Maximum spectator speed.")
                .defineInRange("maximum_spectator_speed", ModConfig.DEFAULT_MAXIMUM_SPECTATOR_SPEED, 0.0D, Double.MAX_VALUE);
        SCROLL_SPEED_MULTIPLIER = CLIENT_BUILDER
                .comment("Speed gained per scroll tick. Higher = faster.")
                .defineInRange("scroll_speed_multiplier", ModConfig.DEFAULT_SCROLL_SPEED_MULTIPLIER, 0.0D, Double.MAX_VALUE);
        CLIENT_BUILDER.pop();

        COMMON_BUILDER.push("Common");
        PREVENT_SPECTATOR_DEATH = COMMON_BUILDER
                .comment("Prevent spectators from dying in the void.")
                .define("prevent_spectator_death", ModConfig.DEFAULT_PREVENT_SPECTATOR_DEATH);
        COMMON_BUILDER.pop();

        CLIENT_SPEC = CLIENT_BUILDER.build();
        COMMON_SPEC = COMMON_BUILDER.build();
    }

    static void register()
    {
        ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.CLIENT, CLIENT_SPEC);
        ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON, COMMON_SPEC);
    }

    static void syncClient()
    {
        if (!CLIENT_SPEC.isLoaded()) return;
        ModConfig.capSpectatorSpeed = CAP_SPECTATOR_SPEED.get();
        ModConfig.maximumSpectatorSpeed = MAXIMUM_SPECTATOR_SPEED.get();
        ModConfig.scrollSpeedMultiplier = SCROLL_SPEED_MULTIPLIER.get();
    }

    static void syncCommon()
    {
        if (!COMMON_SPEC.isLoaded()) return;
        ModConfig.preventSpectatorDeath = PREVENT_SPECTATOR_DEATH.get();
    }

    private ForgeConfig()
    {
    }
}

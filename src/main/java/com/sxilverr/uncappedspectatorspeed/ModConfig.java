package com.sxilverr.uncappedspectatorspeed;

import net.minecraftforge.common.config.Config;

@Config(modid = UncappedSpectatorSpeed.MODID, name = UncappedSpectatorSpeed.MODID)
public class ModConfig
{
    public static Client client = new Client();
    public static Common common = new Common();

    public static class Client
    {
        @Config.Name("cap_spectator_speed")
        @Config.Comment("Cap spectator speed.")
        public boolean capSpectatorSpeed = false;

        @Config.Name("maximum_spectator_speed")
        @Config.Comment("Maximum spectator speed.")
        @Config.RangeDouble(min = 0.0D)
        public double maximumSpectatorSpeed = 0.2D;

        @Config.Name("scroll_speed_multiplier")
        @Config.Comment("Speed gained per scroll tick. Higher = faster.")
        @Config.RangeDouble(min = 0.0D)
        public double scrollSpeedMultiplier = 1.0D;
    }

    public static class Common
    {
        @Config.Name("prevent_spectator_death")
        @Config.Comment("Prevent spectators from dying in the void.")
        public boolean preventSpectatorDeath = true;
    }
}

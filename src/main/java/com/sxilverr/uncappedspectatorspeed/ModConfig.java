package com.sxilverr.uncappedspectatorspeed;

public final class ModConfig
{
    public static final boolean DEFAULT_CAP_SPECTATOR_SPEED = false;
    public static final double DEFAULT_MAXIMUM_SPECTATOR_SPEED = 0.2D;
    public static final double DEFAULT_SCROLL_SPEED_MULTIPLIER = 1.0D;
    public static final boolean DEFAULT_PREVENT_SPECTATOR_DEATH = true;

    public static boolean capSpectatorSpeed = DEFAULT_CAP_SPECTATOR_SPEED;
    public static double maximumSpectatorSpeed = DEFAULT_MAXIMUM_SPECTATOR_SPEED;
    public static double scrollSpeedMultiplier = DEFAULT_SCROLL_SPEED_MULTIPLIER;
    public static boolean preventSpectatorDeath = DEFAULT_PREVENT_SPECTATOR_DEATH;

    private ModConfig()
    {
    }
}

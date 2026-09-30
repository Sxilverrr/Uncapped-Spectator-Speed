package com.sxilverr.uncappedspectatorspeed.neoforge;

import com.sxilverr.uncappedspectatorspeed.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(ModConfig.MODID)
public final class UncappedSpectatorSpeedNeoForge
{
    public UncappedSpectatorSpeedNeoForge(ModContainer container)
    {
        NeoForgeConfig.register(container);
    }
}

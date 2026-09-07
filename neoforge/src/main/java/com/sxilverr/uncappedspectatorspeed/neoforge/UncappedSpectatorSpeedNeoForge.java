package com.sxilverr.uncappedspectatorspeed.neoforge;

import com.sxilverr.uncappedspectatorspeed.UncappedSpectatorSpeed;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(UncappedSpectatorSpeed.MODID)
public final class UncappedSpectatorSpeedNeoForge
{
    public UncappedSpectatorSpeedNeoForge(IEventBus modBus, ModContainer container)
    {
        NeoForgeConfig.register(container);
    }
}

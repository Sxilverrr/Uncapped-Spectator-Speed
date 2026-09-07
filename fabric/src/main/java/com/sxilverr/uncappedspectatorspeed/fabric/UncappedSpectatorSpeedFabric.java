package com.sxilverr.uncappedspectatorspeed.fabric;

import com.sxilverr.uncappedspectatorspeed.SpectatorGuard;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;

public final class UncappedSpectatorSpeedFabric implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        FabricConfig.load();
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) ->
                !SpectatorGuard.shouldCancelDamage(entity, source));
    }
}

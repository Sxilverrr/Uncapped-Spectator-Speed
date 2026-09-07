package com.sxilverr.uncappedspectatorspeed.neoforge;

import com.sxilverr.uncappedspectatorspeed.SpectatorGuard;
import com.sxilverr.uncappedspectatorspeed.UncappedSpectatorSpeed;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber(modid = UncappedSpectatorSpeed.MODID)
public final class NeoForgeCommonEvents
{
    @SubscribeEvent
    public static void onLivingIncomingDamage(LivingIncomingDamageEvent event)
    {
        NeoForgeConfig.syncCommon();
        if (SpectatorGuard.shouldCancelDamage(event.getEntity(), event.getSource()))
        {
            event.setCanceled(true);
        }
    }

    private NeoForgeCommonEvents()
    {
    }
}

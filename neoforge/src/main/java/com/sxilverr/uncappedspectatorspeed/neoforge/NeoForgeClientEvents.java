package com.sxilverr.uncappedspectatorspeed.neoforge;

import com.sxilverr.uncappedspectatorspeed.ModConfig;
import com.sxilverr.uncappedspectatorspeed.SpectatorSpeed;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;

@EventBusSubscriber(modid = ModConfig.MODID, value = Dist.CLIENT)
public final class NeoForgeClientEvents
{
    @SubscribeEvent
    public static void onMouseScroll(InputEvent.MouseScrollingEvent event)
    {
        NeoForgeConfig.syncClient();
        if (SpectatorSpeed.applyScroll(event.getScrollDeltaY()))
        {
            event.setCanceled(true);
        }
    }

    private NeoForgeClientEvents()
    {
    }
}

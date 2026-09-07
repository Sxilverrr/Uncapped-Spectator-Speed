package com.sxilverr.uncappedspectatorspeed.forge;

import com.sxilverr.uncappedspectatorspeed.SpectatorSpeed;
import com.sxilverr.uncappedspectatorspeed.UncappedSpectatorSpeed;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UncappedSpectatorSpeed.MODID, value = Dist.CLIENT)
public final class ForgeClientEvents
{
    @SubscribeEvent
    //? if >=1.19 {
    public static void onMouseScroll(InputEvent.MouseScrollingEvent event)
    //?} else {
    /*public static void onMouseScroll(InputEvent.MouseScrollEvent event)*/
    //?}
    {
        ForgeConfig.syncClient();
        if (SpectatorSpeed.applyScroll(event.getScrollDelta()))
        {
            event.setCanceled(true);
        }
    }

    private ForgeClientEvents()
    {
    }
}

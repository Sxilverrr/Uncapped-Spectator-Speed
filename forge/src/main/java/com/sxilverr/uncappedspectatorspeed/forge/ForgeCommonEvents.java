package com.sxilverr.uncappedspectatorspeed.forge;

import com.sxilverr.uncappedspectatorspeed.ModConfig;
import com.sxilverr.uncappedspectatorspeed.SpectatorGuard;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModConfig.MODID)
public final class ForgeCommonEvents
{
    @SubscribeEvent
    public static void onLivingAttack(LivingAttackEvent event)
    {
        ForgeConfig.syncCommon();
        //? if >=1.19 {
        if (SpectatorGuard.shouldCancelDamage(event.getEntity(), event.getSource()))
        //?} else {
        /*if (SpectatorGuard.shouldCancelDamage(event.getEntityLiving(), event.getSource()))*/
        //?}
        {
            event.setCanceled(true);
        }
    }

    private ForgeCommonEvents()
    {
    }
}

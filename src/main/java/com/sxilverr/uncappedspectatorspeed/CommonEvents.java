package com.sxilverr.uncappedspectatorspeed;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = UncappedSpectatorSpeed.MODID)
public final class CommonEvents
{
    @SubscribeEvent
    public static void onLivingAttack(LivingAttackEvent event)
    {
        if (!ModConfig.common.preventSpectatorDeath) return;
        if (!(event.getEntityLiving() instanceof EntityPlayer)) return;
        if (!((EntityPlayer) event.getEntityLiving()).isSpectator()) return;
        if (event.getSource() == DamageSource.OUT_OF_WORLD)
        {
            event.setCanceled(true);
        }
    }

    private CommonEvents()
    {
    }
}

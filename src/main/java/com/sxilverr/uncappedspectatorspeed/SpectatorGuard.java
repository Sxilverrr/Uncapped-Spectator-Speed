package com.sxilverr.uncappedspectatorspeed;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
//? if >=1.20
import net.minecraft.world.damagesource.DamageTypes;

public final class SpectatorGuard
{
    public static boolean shouldCancelDamage(Entity entity, DamageSource source)
    {
        if (!ModConfig.preventSpectatorDeath || !(entity instanceof Player) || !((Player) entity).isSpectator()) return false;
        //? if >=1.20 {
        return source.is(DamageTypes.FELL_OUT_OF_WORLD);
        //?} else {
        /*return source == DamageSource.OUT_OF_WORLD;*/
        //?}
    }

    private SpectatorGuard()
    {
    }
}

package com.sxilverr.uncappedspectatorspeed;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Abilities;

public final class SpectatorSpeed
{
    public static boolean applyScroll(double scrollDelta)
    {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || !mc.player.isSpectator()) return false;
        if (mc.gui.getSpectatorGui().isMenuActive()) return false;

        //? if >=1.17 {
        Abilities abilities = mc.player.getAbilities();
        //?} else {
        /*Abilities abilities = mc.player.abilities;*/
        //?}

        float current = abilities.getFlyingSpeed();
        float step = (float) (scrollDelta * 0.005D * ModConfig.scrollSpeedMultiplier);
        float updated;

        if (ModConfig.capSpectatorSpeed)
        {
            updated = Mth.clamp(current + step, 0.0F, (float) ModConfig.maximumSpectatorSpeed);
        }
        else
        {
            updated = Math.max(0.0F, current + step);
        }

        abilities.setFlyingSpeed(updated);
        return true;
    }

    private SpectatorSpeed()
    {
    }
}

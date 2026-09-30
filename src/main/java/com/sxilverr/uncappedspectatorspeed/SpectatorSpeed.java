package com.sxilverr.uncappedspectatorspeed;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Abilities;

public final class SpectatorSpeed
{
    public static boolean applyScroll(double scrollDelta)
    {
        Minecraft mc = Minecraft.getInstance();
        if (mc.screen != null || mc.player == null || !mc.player.isSpectator()) return false;
        if (mc.gui.getSpectatorGui().isMenuActive()) return false;

        //? if >=1.17 {
        Abilities abilities = mc.player.getAbilities();
        //?} else {
        /*Abilities abilities = mc.player.abilities;*/
        //?}

        float step = (float) (scrollDelta * 0.005D * ModConfig.scrollSpeedMultiplier);
        float updated = Math.max(0.0F, abilities.getFlyingSpeed() + step);
        if (ModConfig.capSpectatorSpeed) updated = Math.min(updated, (float) ModConfig.maximumSpectatorSpeed);

        abilities.setFlyingSpeed(updated);
        return true;
    }

    private SpectatorSpeed()
    {
    }
}

package com.sxilverr.uncappedspectatorspeed;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = UncappedSpectatorSpeed.MODID, value = Side.CLIENT)
public final class ClientEvents
{
    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (UncappedSpectatorSpeed.MODID.equals(event.getModID()))
        {
            ConfigManager.sync(UncappedSpectatorSpeed.MODID, net.minecraftforge.common.config.Config.Type.INSTANCE);
        }
    }

    @SubscribeEvent
    public static void onMouse(MouseEvent event)
    {
        if (event.getDwheel() == 0) return;

        Minecraft mc = Minecraft.getMinecraft();
        if (mc.player == null || !mc.player.isSpectator()) return;
        if (mc.ingameGUI.getSpectatorGui().isMenuActive()) return;

        PlayerCapabilities capabilities = mc.player.capabilities;
        float current = capabilities.getFlySpeed();
        float step = (float) (event.getDwheel() / 120.0D * 0.005D * ModConfig.client.scrollSpeedMultiplier);
        float updated;

        if (ModConfig.client.capSpectatorSpeed)
        {
            updated = MathHelper.clamp(current + step, 0.0F, (float) ModConfig.client.maximumSpectatorSpeed);
        }
        else
        {
            updated = Math.max(0.0F, current + step);
        }

        capabilities.setFlySpeed(updated);
        event.setCanceled(true);
    }

    private ClientEvents()
    {
    }
}

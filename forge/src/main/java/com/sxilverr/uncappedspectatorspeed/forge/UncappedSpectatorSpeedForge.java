package com.sxilverr.uncappedspectatorspeed.forge;

import com.sxilverr.uncappedspectatorspeed.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModConfig.MODID)
public final class UncappedSpectatorSpeedForge
{
    //? if >=1.19 {
    public UncappedSpectatorSpeedForge(FMLJavaModLoadingContext context)
    {
        ForgeConfig.register(context);
    }
    //?} else {
    /*public UncappedSpectatorSpeedForge()
    {
        ForgeConfig.register(net.minecraftforge.fml.ModLoadingContext.get());
    }*/
    //?}
}

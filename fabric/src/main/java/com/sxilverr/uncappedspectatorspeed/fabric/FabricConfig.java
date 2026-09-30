package com.sxilverr.uncappedspectatorspeed.fabric;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sxilverr.uncappedspectatorspeed.ModConfig;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FabricConfig
{
    public static final class Data
    {
        public boolean cap_spectator_speed = ModConfig.DEFAULT_CAP_SPECTATOR_SPEED;
        public double maximum_spectator_speed = ModConfig.DEFAULT_MAXIMUM_SPECTATOR_SPEED;
        public double scroll_speed_multiplier = ModConfig.DEFAULT_SCROLL_SPEED_MULTIPLIER;
        public boolean prevent_spectator_death = ModConfig.DEFAULT_PREVENT_SPECTATOR_DEATH;
    }

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static Data data = new Data();

    public static Data data()
    {
        return data;
    }

    public static void load()
    {
        Path path = path();
        if (Files.exists(path))
        {
            try (Reader reader = Files.newBufferedReader(path))
            {
                Data loaded = GSON.fromJson(reader, Data.class);
                if (loaded != null)
                {
                    data = loaded;
                }
            }
            catch (IOException ignored)
            {
            }
        }
        persist();
    }

    public static void persist()
    {
        apply();
        try (Writer writer = Files.newBufferedWriter(path()))
        {
            GSON.toJson(data, writer);
        }
        catch (IOException ignored)
        {
        }
    }

    private static void apply()
    {
        ModConfig.capSpectatorSpeed = data.cap_spectator_speed;
        ModConfig.maximumSpectatorSpeed = data.maximum_spectator_speed;
        ModConfig.scrollSpeedMultiplier = data.scroll_speed_multiplier;
        ModConfig.preventSpectatorDeath = data.prevent_spectator_death;
    }

    private static Path path()
    {
        return FabricLoader.getInstance().getConfigDir().resolve(ModConfig.MODID + ".json");
    }

    private FabricConfig()
    {
    }
}

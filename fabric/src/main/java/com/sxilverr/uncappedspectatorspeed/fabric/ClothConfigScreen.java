package com.sxilverr.uncappedspectatorspeed.fabric;

import com.sxilverr.uncappedspectatorspeed.ModConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class ClothConfigScreen
{
    public static Screen create(Screen parent)
    {
        FabricConfig.Data data = FabricConfig.data();
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Component.literal("Uncapped Spectator Speed"))
                .setSavingRunnable(FabricConfig::persist);
        ConfigEntryBuilder eb = builder.entryBuilder();

        ConfigCategory client = builder.getOrCreateCategory(Component.literal("Client"));
        client.addEntry(eb.startBooleanToggle(Component.literal("Cap spectator speed"), data.cap_spectator_speed)
                .setDefaultValue(ModConfig.DEFAULT_CAP_SPECTATOR_SPEED)
                .setSaveConsumer(v -> data.cap_spectator_speed = v).build());
        client.addEntry(eb.startDoubleField(Component.literal("Maximum spectator speed"), data.maximum_spectator_speed)
                .setMin(0.0D)
                .setDefaultValue(ModConfig.DEFAULT_MAXIMUM_SPECTATOR_SPEED)
                .setSaveConsumer(v -> data.maximum_spectator_speed = v).build());
        client.addEntry(eb.startDoubleField(Component.literal("Scroll speed multiplier"), data.scroll_speed_multiplier)
                .setMin(0.0D)
                .setDefaultValue(ModConfig.DEFAULT_SCROLL_SPEED_MULTIPLIER)
                .setSaveConsumer(v -> data.scroll_speed_multiplier = v).build());

        ConfigCategory common = builder.getOrCreateCategory(Component.literal("Common"));
        common.addEntry(eb.startBooleanToggle(Component.literal("Prevent spectator death"), data.prevent_spectator_death)
                .setDefaultValue(ModConfig.DEFAULT_PREVENT_SPECTATOR_DEATH)
                .setSaveConsumer(v -> data.prevent_spectator_death = v).build());

        return builder.build();
    }

    private ClothConfigScreen()
    {
    }
}

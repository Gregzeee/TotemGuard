package de.outdev.totemguardv2;

import de.outdev.totemguardv2.commands.ReloadCommand;
import de.outdev.totemguardv2.listeners.TotemUseListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

public final class TotemGuardV2 extends JavaPlugin {

    private static TotemGuardV2 instance;
    private static FileConfiguration config;

    @Nullable
    public static TotemGuardV2 getInstance() {
        return instance;
    }

    @Nullable
    public static FileConfiguration getConfiguration() {
        return config;
    }


    @Override
    public void onEnable() {
        getLogger().info("Loading TotemGuard...");

        long start = System.currentTimeMillis();

        new ReloadCommand(this);

        instance = this;
        config = getConfig();

        saveDefaultConfig();

        new TotemUseListener(this);

        getLogger().info(" _____ __ _____ ___ __ __  __ _  _  __  ___ __   ");
        getLogger().info("|_   _/__\\_   _| __|  V  |/ _] || |/  \\| _ \\ _\\  ");
        getLogger().info("  | || \\/ || | | _|| \\_/ | [/\\ \\/ | /\\ | v / v | ");
        getLogger().info("  |_| \\__/ |_| |___|_| |_|\\__/\\__/|_||_|_|_\\__/  ");
        getLogger().info("                                                ");

        long finish = System.currentTimeMillis() - start;
        getLogger().info("Successfully loaded TotemGuard in " + finish + "ms!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling plugin 'TotemGuard'...");
        saveDefaultConfig();
    }
}

package de.outdev.totemguardv2;

import de.outdev.totemguardv2.commands.CheckCommand;
import de.outdev.totemguardv2.commands.TotemGuardCommand;
import de.outdev.totemguardv2.listeners.TotemUseListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

public final class TotemGuardV2 extends JavaPlugin {

    private static TotemGuardV2 instance;
    private static FileConfiguration config;
    private TotemUseListener totemUseListener;

    @Nullable
    public static TotemGuardV2 getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        getLogger().info("Loading TotemGuard...");

        getCommand("totemguard").setExecutor(new TotemGuardCommand());
        getCommand("check").setExecutor(new CheckCommand());

        instance = this;
        config = getConfig();

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(totemUseListener = new TotemUseListener(), this);

        getLogger().info(" \n"+
                "  _____    _             ___                  _ \n" +
                " |_   _|__| |_ ___ _ __ / __|_  _ __ _ _ _ __| |\n" +
                "   | |/ _ \\  _/ -_) '  \\ (_ | || / _` | '_/ _` |\n" +
                "   |_|\\___/\\__\\___|_|_|_\\___|\\_,_\\__,_|_| \\__,_|\n" +
                "                                                ");
    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
    }

    public double getTPS() {
        try {
            Object server = Bukkit.getServer().getClass().getDeclaredMethod("getServer").invoke(Bukkit.getServer());
            double[] tps = (double[]) server.getClass().getField("recentTps").get(server);
            return tps[0];
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}

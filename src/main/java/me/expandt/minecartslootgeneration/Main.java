package me.expandt.minecartslootgeneration;

import me.expandt.minecartslootgeneration.events.ChunkGeneration;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new ChunkGeneration(), plugin);
    }

    @Override
    public void onDisable() {

    }

}

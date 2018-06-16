package com.twanl.minigame;

import com.twanl.minigame.util.Strings;
import nl.RamonPeek.API;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class MiniGame extends JavaPlugin {


    private API api = (API) Bukkit.getServer().getPluginManager().getPlugin("Core");

    @EventHandler
    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("Core") != null) {
            getServer().getConsoleSender().sendMessage(Strings.green + Strings.logName + "Core HOOKED.");
        } else {
            getServer().getConsoleSender().sendMessage(Strings.green + Strings.logName + Strings.red + "Core not found, plugin will be disabled");
            Bukkit.getServer().getPluginManager().disablePlugins();
        }


    }

    public void onDisable() {

    }
}

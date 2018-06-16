package com.twanl.minigame.util;

import com.twanl.minigame.MiniGame;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private MiniGame plugin = MiniGame.getPlugin(MiniGame.class);

    //Files & Config Files
    public static FileConfiguration dataC;
    public static File dataF;

    //--------------------


    public void setup() {
        dataF = new File(plugin.getDataFolder(), "data.yml");
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }


        if (!dataF.exists()) {
            try {
                dataF.createNewFile();
                Bukkit.getServer().getConsoleSender().sendMessage(Strings.green + "The data.yml file has been created");
            } catch (IOException e) {
                Bukkit.getServer().getConsoleSender().sendMessage(Strings.red + "Could not create the data.yml file");
            }
        }

        dataC = YamlConfiguration.loadConfiguration(dataF);

    }


    public FileConfiguration getData() {
        return dataC;

    }



    public void saveData() {
        dataF = new File(plugin.getDataFolder(), "data.yml");

        try {
            dataC.save(dataF);
            Bukkit.getServer().getConsoleSender().sendMessage(Strings.green + "The data.yml file has been saved");

        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(Strings.red + "Could not save the data.yml file");

        }
    }


    public void reloadData() {
        dataC = YamlConfiguration.loadConfiguration(dataF);
        Bukkit.getServer().getConsoleSender().sendMessage(Strings.green + "The data.yml file has been reloaded");

    }
}

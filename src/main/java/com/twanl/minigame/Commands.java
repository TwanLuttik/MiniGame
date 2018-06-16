package com.twanl.minigame;

import com.twanl.minigame.util.ConfigManager;
import com.twanl.minigame.util.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    private ConfigManager cfgM = new ConfigManager();



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Strings.logName + Strings.red + "Only a player can execute commands!");
            return true;
        }

        Player p = (Player) sender;

        cfgM.setup();

        if (cmd.getName().equalsIgnoreCase("minigame")) {
            if (args.length == 0) {
                p.sendMessage(Strings.greenB+"This is the main command!");

            } else if (args[0].equalsIgnoreCase("help")) {

            } else if (args[0].equalsIgnoreCase("set")) {
                int a = Integer.parseInt(args[1]);



                cfgM.getData().set("arena." + a + ".location.x", p.getLocation().getX());
                cfgM.getData().set("arena." + a + ".location.y", p.getLocation().getY());
                cfgM.getData().set("arena." + a + ".location.z", p.getLocation().getZ());
                cfgM.getData().set("arena." + a + ".location.world", p.getLocation().getWorld().getName());
                cfgM.saveData();
                p.sendMessage(Strings.green + "Location has been set");




            } else if (args[0].equalsIgnoreCase("tp")) {
                int a = Integer.parseInt(args[1]);


                double x = cfgM.getData().getDouble("arena." + a + ".location.x");
                double y = cfgM.getData().getDouble("arena." + a + ".location.y");
                double z = cfgM.getData().getDouble("arena." + a + ".location.z");
                World w = Bukkit.getServer().getWorld(cfgM.getData().getString("arena." + a + ".location.world"));


                p.teleport(new Location(w, x, y, z));
                p.sendMessage(Strings.green + "Teleported to location");










            }
        }



        return true;
    }
}

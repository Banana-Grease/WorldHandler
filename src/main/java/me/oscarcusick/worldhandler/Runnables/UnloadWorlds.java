package me.oscarcusick.worldhandler.Runnables;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

public class UnloadWorlds extends BukkitRunnable {
    Plugin PluginInstance;
    public UnloadWorlds(Plugin ParsedPluginInstance) {
        PluginInstance = ParsedPluginInstance;
    }

    @Override
    public void run() {
        List<World> Worlds = new ArrayList<>();
        Worlds = PluginInstance.getServer().getWorlds();
        for (int i = 0; i < Worlds.size(); i++) {
            if (Worlds.get(i).getPlayerCount() == 0 && !Worlds.get(i).getName().equals("world")) {
                 if (!PluginInstance.getServer().unloadWorld(Worlds.get(i), true)) {
                     System.out.println("Failed To Unload World: " + Worlds.get(i).getName());
                 }else {
                     System.out.println("Unloaded World: " + Worlds.get(i).getName());
                 }
            }
        }
    }
}

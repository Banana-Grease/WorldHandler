package me.oscarcusick.worldhandler.Runnables;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class TeleportPlayerRunnable extends BukkitRunnable {
    Plugin PluginInstance;
    Location TPTarget;
    Player User;
    public TeleportPlayerRunnable(Plugin ParsedPluginInstance, Location ParsedTPTarget, Player ParsedUser) {
        PluginInstance = ParsedPluginInstance;
        TPTarget = ParsedTPTarget;
        User = ParsedUser;
    }

    @Override
    public void run() {
        User.sendTitle(ChatColor.GREEN + "Arrived At", TPTarget.getWorld().getName().replace("world_", ""), 10, (2*20), 20);
    }
}

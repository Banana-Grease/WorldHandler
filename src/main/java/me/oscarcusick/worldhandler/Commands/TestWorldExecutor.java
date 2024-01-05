package me.oscarcusick.worldhandler.Commands;

import me.oscarcusick.worldhandler.Runnables.TeleportPlayerRunnable;
import me.oscarcusick.worldhandler.Util.Worlds;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public class TestWorldExecutor implements CommandExecutor {
    Plugin PluginInstance;
    public TestWorldExecutor(Plugin ParsedPluginInstance){
        PluginInstance = ParsedPluginInstance;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 0) { // only one argument
            Player User = (Player)commandSender;
            PluginInstance.getServer().createWorld(new WorldCreator("world"));
            Location TPTarget = new Location(PluginInstance.getServer().getWorld("world"), 0, PluginInstance.getServer().getWorld("world").getHighestBlockYAt(0, 0),0);
            User.teleport(TPTarget);
            BukkitTask TPTask = new TeleportPlayerRunnable(PluginInstance, TPTarget, User).runTaskLater(PluginInstance, 1*20);
            return true;
        }
        return false;
    }
}

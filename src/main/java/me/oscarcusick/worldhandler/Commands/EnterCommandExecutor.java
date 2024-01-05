package me.oscarcusick.worldhandler.Commands;

import me.oscarcusick.worldhandler.Runnables.TeleportPlayerRunnable;
import me.oscarcusick.worldhandler.Util.Worlds;
import me.oscarcusick.worldhandler.WorldHandler;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public class EnterCommandExecutor implements CommandExecutor {
    Plugin PluginInstance;
    public EnterCommandExecutor(Plugin ParsedPluginInstance){
        PluginInstance = ParsedPluginInstance;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 1) { // only one argument
            Worlds ValidWorlds = new Worlds();
            if (ValidWorlds.ValidWorlds.contains(strings[0])) {
                Player User = (Player)commandSender;
                PluginInstance.getServer().createWorld(new WorldCreator("world_"+strings[0]));
                Location TPTarget;
                if (strings[0].equalsIgnoreCase("spawn")) {
                    if (!User.isOp()) {
                        User.setGameMode(GameMode.ADVENTURE);
                    }
                    TPTarget = new Location(PluginInstance.getServer().getWorld("world_"+strings[0]), 1110.5, 17,764.5);
                } else {
                    if (!User.isOp()) {
                        User.setGameMode(GameMode.SURVIVAL);
                    }
                    TPTarget = new Location(PluginInstance.getServer().getWorld("world_" + strings[0]), 0, PluginInstance.getServer().getWorld("world_" + strings[0]).getHighestBlockYAt(0, 0), 0);
                }
                User.teleport(TPTarget);
                BukkitTask TPTask = new TeleportPlayerRunnable(PluginInstance, TPTarget, User).runTaskLater(PluginInstance, 1*20);
                return true;
            }
        }
        return false;
    }
}

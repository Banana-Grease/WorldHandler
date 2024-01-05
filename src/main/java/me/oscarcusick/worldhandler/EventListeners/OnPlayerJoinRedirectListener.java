package me.oscarcusick.worldhandler.EventListeners;

import org.bukkit.GameMode;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.Plugin;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoinRedirectListener implements Listener {
    Plugin PluginInstance;
    public OnPlayerJoinRedirectListener(Plugin ParsedPluginInstance) {
        PluginInstance = ParsedPluginInstance;
    }

    @EventHandler
    public void OnPlayerJoinRedirect(PlayerJoinEvent event) {
        // teleport to spawn world
        PluginInstance.getServer().createWorld(new WorldCreator("world_Spawn"));
        if (!event.getPlayer().isOp()) {
            event.getPlayer().setGameMode(GameMode.ADVENTURE);
        }
        event.getPlayer().teleport(new Location(PluginInstance.getServer().getWorld("world_Spawn"), PluginInstance.getServer().getWorld("world_Spawn").getSpawnLocation().getX(), PluginInstance.getServer().getWorld("world_Spawn").getSpawnLocation().getY(), PluginInstance.getServer().getWorld("world_Spawn").getSpawnLocation().getZ()));
    }
}

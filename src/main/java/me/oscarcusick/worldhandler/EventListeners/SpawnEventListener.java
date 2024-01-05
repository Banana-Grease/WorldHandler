package me.oscarcusick.worldhandler.EventListeners;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

public class SpawnEventListener implements Listener {
    Plugin PluginInstance;
    public SpawnEventListener(Plugin ParsedPluginInstance) {
        PluginInstance = ParsedPluginInstance;
    }

    @EventHandler
    public void OnPlayerSpawn(PlayerRespawnEvent event) {
        Player User = (Player)event.getPlayer();
        if (event.isBedSpawn()) { // if the player is respawning into a bed change nothing
            return;
        } else { // if the repsawn isn't to a bed, set it the to the server hub
            Location RespawnLoc = User.getLocation();
            PluginInstance.getServer().createWorld(new WorldCreator("world_Spawn")); // create the world before setting it to a location
            User.setGameMode(GameMode.ADVENTURE);
            event.setRespawnLocation(new Location(PluginInstance.getServer().getWorld("world_Spawn"), 1110.5, 17, 764.5));
        }
    }
}

package me.oscarcusick.worldhandler;

import me.oscarcusick.worldhandler.Commands.EnterCommandExecutor;
import me.oscarcusick.worldhandler.Commands.EnterCommandTabCompleter;
import me.oscarcusick.worldhandler.Commands.TestWorldExecutor;
import me.oscarcusick.worldhandler.EventListeners.OnPlayerJoinRedirectListener;
import me.oscarcusick.worldhandler.EventListeners.SpawnEventListener;
import me.oscarcusick.worldhandler.Runnables.UnloadWorlds;
import me.oscarcusick.worldhandler.Util.Worlds;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class WorldHandler extends JavaPlugin implements Plugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("Enter").setExecutor(new EnterCommandExecutor(this));
        getCommand("Enter").setTabCompleter(new EnterCommandTabCompleter());
        getCommand("TestWorld").setExecutor(new TestWorldExecutor(this));
        getServer().getPluginManager().registerEvents(new OnPlayerJoinRedirectListener(this), this); // player join handler
        getServer().getPluginManager().registerEvents(new SpawnEventListener(this), this); // player spawn handler

        // create a runnable that checks every 5 seconds if any world has 0 players and if so unloads it
        BukkitTask WorldUnloader = new UnloadWorlds(this).runTaskTimer(this, 10, 5*20); // World unload handler
    }
}

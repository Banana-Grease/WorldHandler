package me.oscarcusick.worldhandler.Util;

import org.bukkit.World;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Worlds {
    //Plugin PluginInstance; // un-needed for now
    public List<String> ValidWorlds = new ArrayList<>();
    public HashMap<String, Boolean> WorldActive = new HashMap<>();
    public Worlds() {
        //PluginInstance = ParsedPluginInstance; // un-needed for now
        ValidWorlds.add("Spawn");
        ValidWorlds.add("Survival");
        ValidWorlds.add("Anarchy");

        WorldActive.put("world_Spawn", true);
        WorldActive.put("world_Survival", false);
        WorldActive.put("world_Anarchy", false);
    }

}

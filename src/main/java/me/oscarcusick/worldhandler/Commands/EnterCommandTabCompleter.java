package me.oscarcusick.worldhandler.Commands;

import me.oscarcusick.worldhandler.Util.Worlds;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EnterCommandTabCompleter implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Worlds ValidWorlds = new Worlds();
        return ValidWorlds.ValidWorlds;
    }
}

package net.snapecraft.CustomServerUtilv2.util;

import net.md_5.bungee.api.ChatColor;
import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ConfigWerte {



    public final String Prefix = CustomServerUtilv2.getPlugin().getConfig().getString("Settings.Prefix");
    public final String NoPerm = CustomServerUtilv2.getPlugin().getConfig().getString("Settings.NoPermission");

    public final String ToSpawn = CustomServerUtilv2.getPlugin().getConfig().getString("Spawn.ToSpawn");
    public final String NoSpawnpoint = CustomServerUtilv2.getPlugin().getConfig().getString("Spawn.NoSpawnpoint");
    public final String SpeakDeveloper = CustomServerUtilv2.getPlugin().getConfig().getString("Spawn.SpeakDeveloper");
    public final String MoveSpawn = CustomServerUtilv2.getPlugin().getConfig().getString("Spawn.MoveSpawn");
    public final String SetSpawn = CustomServerUtilv2.getPlugin().getConfig().getString("Spawn.SetSpawn");
    public final String SpawnCMD = CustomServerUtilv2.getPlugin().getConfig().getString("Spawn.SpawnCMD");

    public static void playerMessage(Player player, String message){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',message));
    }

    public static void consolMessage(String message){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',message));
    }

    public static void broadcastMessage(String message){
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',message));
    }
}

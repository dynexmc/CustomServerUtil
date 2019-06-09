package net.snapecraft.CustomServerUtilv2.util;

import net.md_5.bungee.api.ChatColor;
import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ConfigWerte {

    //Settings
    public final String Prefix = CustomServerUtilv2.getPlugin().getConfig().getString("Settings.Prefix");
    public final String NoPerm = CustomServerUtilv2.getPlugin().getConfig().getString("Settings.NoPermission");
    public final String UnknownPlayer = CustomServerUtilv2.getPlugin().getConfig().getString("Settings.UnknownPlayer");
    public final String HomeFormat = CustomServerUtilv2.getPlugin().getConfig().getString("Settings.HomeFormat");

    //Spawn
    public final String ToSpawn = CustomServerUtilv2.getPlugin().getConfig().getString("Spawn.ToSpawn");
    public final String NoSpawnpoint = CustomServerUtilv2.getPlugin().getConfig().getString("Spawn.NoSpawnpoint");
    public final String SpeakDeveloper = CustomServerUtilv2.getPlugin().getConfig().getString("Spawn.SpeakDeveloper");
    public final String MoveSpawn = CustomServerUtilv2.getPlugin().getConfig().getString("Spawn.MoveSpawn");
    public final String SetSpawn = CustomServerUtilv2.getPlugin().getConfig().getString("Spawn.SetSpawn");
    public final String SpawnCMD = CustomServerUtilv2.getPlugin().getConfig().getString("Spawn.SpawnCMD");

    //Vanish
    public final String Show = CustomServerUtilv2.getPlugin().getConfig().getString("Vanish.Show");
    public final String Hide = CustomServerUtilv2.getPlugin().getConfig().getString("Vanish.Hide");

    //Sun
    public final String Sun = CustomServerUtilv2.getPlugin().getConfig().getString("Sun.Sunny");

    //Fly
    public final String CanFly = CustomServerUtilv2.getPlugin().getConfig().getString("Fly.CanFly");
    public final String CantFly = CustomServerUtilv2.getPlugin().getConfig().getString("Fly.CantFly");
    public final String CanOtherFly = CustomServerUtilv2.getPlugin().getConfig().getString("Fly.CanOtherFly");
    public final String CantOtherFly = CustomServerUtilv2.getPlugin().getConfig().getString("Fly.CantOtherFly");
    public final String FlyCMD = CustomServerUtilv2.getPlugin().getConfig().getString("Fly.FlyCMD");

    //Day
    public final String Day = CustomServerUtilv2.getPlugin().getConfig().getString("Day.Day");

    //Gamemode
    public final String GmCMD = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.GmCMD");
    public final String Survival = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.Survival");
    public final String SurvivalOther = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.SurvivalOther");
    public final String Creative = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.Creative");
    public final String CreativeOther = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.CreativeOther");
    public final String Spectator = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.Spectator");
    public final String SpectatorOther = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.SpectatorOther");
    public final String Adventure = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.Adventure");
    public final String AdventureOther = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.AdventureOther");

    //Home
    public final String HomeCMD = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.HomeCMD");
    public final String Homes = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.Homes");
    public final String NoHomes = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.NoHomes");
    public final String SetHome = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.SetHome");
    public final String NoFreeHomes = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.NoFreeHomes");
    public final String HomeExist = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.HomeExist");
    public final String HomeDontExist = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.HomeDontExist");
    public final String RemoveHome = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.RemoveHome");
    public final String Home = CustomServerUtilv2.getPlugin().getConfig().getString("Gamemode.Home");

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

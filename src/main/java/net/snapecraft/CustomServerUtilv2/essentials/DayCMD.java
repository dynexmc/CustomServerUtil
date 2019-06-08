package net.snapecraft.CustomServerUtilv2.essentials;


import net.snapecraft.CustomServerUtilv2.util.ConfigWerte;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;

public class DayCMD implements CommandExecutor {

    private static ConfigWerte cw;

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            cw = new ConfigWerte();
            Player p = (Player) sender;
            if (p.hasPermission("csu.day")) {
                p.getLocation().getWorld().setTime(0);
                ConfigWerte.playerMessage(p, cw.Prefix + cw.Day);
            } else {
                ConfigWerte.playerMessage(p, cw.Prefix + cw.NoPerm);
            }
        }
        return true;
    }
}



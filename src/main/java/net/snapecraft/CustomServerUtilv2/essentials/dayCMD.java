package net.snapecraft.CustomServerUtilv2.essentials;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;

public class dayCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player p = (Player) sender;
        if(p.hasPermission("CustomServerUtil.setDayTime")) {
            p.getLocation().getWorld().setTime(0);
            p.sendMessage(CustomServerUtilv2.Prefix + "§aEs ist nun §6Tag!");
        } else {
            p.sendMessage(CustomServerUtilv2.Prefix + CustomServerUtilv2.noPermission);
        }

        return true;
    }
}



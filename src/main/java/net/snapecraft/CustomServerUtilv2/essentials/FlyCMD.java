package net.snapecraft.CustomServerUtilv2.essentials;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;

public class FlyCMD implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings)
    {
        if(strings.length == 0) {
            Player p = (Player)commandSender;
            if (p.hasPermission("CustomLobby.Fly"))
            {
                if (!p.getAllowFlight())
                {
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.sendMessage(CustomServerUtilv2.Prefix + "§aDu kannst nun fliegen.");
                }
                else
                {
                    p.setFlying(false);
                    p.setAllowFlight(false);
                    p.sendMessage(CustomServerUtilv2.Prefix + "§aDu kannst nun §6nicht mehr fliegen.");
                }
            }
            else {
                p.sendMessage(CustomServerUtilv2.noPermission);
            }
        } else if(strings.length == 1) {
            Player target = Bukkit.getPlayer(strings[0]);
            if(commandSender.hasPermission("CustomLoby.FlyOthers")) {
                if(target != null) {

                    if (!target.getAllowFlight())
                    {
                        target.setAllowFlight(true);
                        target.setFlying(true);
                        target.sendMessage(CustomServerUtilv2.Prefix + "§aDu kannst nun fliegen.");
                    }
                    else
                    {
                        target.setFlying(false);
                        target.setAllowFlight(false);
                        target.sendMessage(CustomServerUtilv2.Prefix + "§aDu kannst nun §6nicht mehr fliegen.");
                    }


                } else {
                    commandSender.sendMessage(CustomServerUtilv2.getPrefix() + " §cSpieler nicht gefunden!");
                }
            }
        } else {
            commandSender.sendMessage(CustomServerUtilv2.getPrefix() + " §cWrong Usage: /fly oder /fly <Name>");
        }

        return true;
    }
}
package net.snapoecraft.CustomServerUtilv2.Tpa;

import net.snapecraft.CustomServerUtilv2.CustomServerUtilv2;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendTpaCMD implements CommandExecutor {

    
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;


        if(strings.length == 1) {
            if(Bukkit.getPlayer(strings[0]) != null) {
                SendTpa.sendTpaToPlayer(p, Bukkit.getPlayer(strings[0]));
            } else {
                p.sendMessage(CustomServerUtilv2.Prefix + "§cDieser Spieler existiert nicht!");
            }
        } else {
            p.sendMessage(CustomServerUtilv2.Prefix + "§cBenutzung: /tpa <Spieler>");
        }




        return true;
    }
}

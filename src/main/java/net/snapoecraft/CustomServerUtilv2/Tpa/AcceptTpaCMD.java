package net.snapoecraft.CustomServerUtilv2.Tpa;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.snapecraft.CustomServerUtilv2.CustomServerUtilv2;

public class AcceptTpaCMD implements CommandExecutor {

   
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;

        if(strings.length == 1) {
            AcceptTpa.acceptTpaByPlayer(p, strings[0]);
        } else {
            p.sendMessage(CustomServerUtilv2.Prefix + "§cBenutzung: /tpaccept <Spieler>");
        }



        return true;
    }
}
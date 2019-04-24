package net.snapoecraft.CustomServerUtilv2.Tpa;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.snapecraft.CustomServerUtilv2.CustomServerUtilv2;

public class DeclineTpa {

    public static void declineTpaByPlayer(Player p, String s) {



        if(SendTpa.tpaMap.containsKey(s) && SendTpa.tpaMap.get(s).equalsIgnoreCase(p.getName())) {
            SendTpa.tpaMap.remove(s, p.getName());
            p.sendMessage(CustomServerUtilv2.Prefix + "§aDu hast die Anfrage abgelehnt");
            Bukkit.getPlayer(s).sendMessage(CustomServerUtilv2.Prefix + "§6" + p.getName() + " §ahat deine Teleportanfrage §cabgelehnt!");

        } else {
            p.sendMessage(CustomServerUtilv2.Prefix + "§cDu hast keine Teleportanfrage von diesem Spieler bekommen!");
        }


    }


	}


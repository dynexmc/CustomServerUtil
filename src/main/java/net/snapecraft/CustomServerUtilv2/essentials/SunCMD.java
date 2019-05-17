package net.snapecraft.CustomServerUtilv2.essentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;

public class SunCMD implements CommandExecutor {
	
	 public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
	        Player p = (Player) commandSender;
	        if(p.hasPermission("CustomServerUtil.setWeather")) {
	            p.getLocation().getWorld().setStorm(false);
	            p.getLocation().getWorld().setThundering(false);
	            p.sendMessage(CustomServerUtilv2.Prefix + "§aEs ist nun §6sonnig!");
	        } else {
				p.sendMessage(CustomServerUtilv2.getPrefix() + "§cDu Hast nicht Die Ber");
	        }




	        return true;
	    }

	}
	
	
	
	
	



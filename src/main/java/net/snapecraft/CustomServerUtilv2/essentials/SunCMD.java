package net.snapecraft.CustomServerUtilv2.essentials;

import net.snapecraft.CustomServerUtilv2.util.ConfigWerte;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;

public class SunCMD implements CommandExecutor {

	private static ConfigWerte cw;

	public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
		Player p = (Player) commandSender;
		if(p.hasPermission("csu.sun")) {
			p.getLocation().getWorld().setStorm(false);
			p.getLocation().getWorld().setThundering(false);
			ConfigWerte.playerMessage(p,cw.Prefix + cw.Sun);
		} else {
			ConfigWerte.playerMessage(p,cw.Prefix + cw.NoPerm);
		}
		return true;
	}
}
	
	
	
	
	



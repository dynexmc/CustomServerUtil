package net.snapecraft.CustomServerUtilv2.essentials;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;

public class VanishCMD implements CommandExecutor {
	
	public static List<Player> vanished = new ArrayList<Player>();
	
	
	public boolean onCommand(CommandSender cs, Command arg1, String arg2, String[] args) {
		if (!(cs instanceof Player))
			return false;
		
		
		
		
		Player p = (Player) cs;
		
		if(!p.hasPermission("CustomServerutil.vanish")) return true;
		
		if(args.length == 0) {
			if(vanished.contains(p)) {
				vanished.remove(p);
				p.sendMessage(CustomServerUtilv2.Prefix + "Du Bist nun Sichtbar Jeder kann dich Sehen!");
				for(Player all : Bukkit.getOnlinePlayers()) {
					all.showPlayer(p);
				}
			}else {
				vanished.add(p);
				p.sendMessage(CustomServerUtilv2.Prefix + "Du Bist nun Unsichtbar keiner kann dich Sehen");
				for(Player all : Bukkit.getOnlinePlayers()) {
					
					if(!all.hasPermission("CustomServerUtil.see")) {
						all.hidePlayer(p);
					}
				}
			}
		}
		
	return false;
	
	
	}
	
}
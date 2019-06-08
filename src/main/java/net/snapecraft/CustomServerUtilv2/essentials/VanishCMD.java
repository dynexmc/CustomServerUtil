package net.snapecraft.CustomServerUtilv2.essentials;

import java.util.ArrayList;
import java.util.List;

import net.snapecraft.CustomServerUtilv2.util.ConfigWerte;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;

public class VanishCMD implements CommandExecutor {
	
	public static List<Player> vanished = new ArrayList<Player>();

	private static ConfigWerte cw;

	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("csu.vanish")){
				cw = new ConfigWerte();
				if (args.length == 0) {
					if (vanished.contains(p)) {
						vanished.remove(p);
						ConfigWerte.playerMessage(p, cw.Prefix + cw.Show);
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.showPlayer(p);
						}
						} else {
							vanished.add(p);
							ConfigWerte.playerMessage(p, cw.Prefix + cw.Hide);
							for (Player all : Bukkit.getOnlinePlayers()) {
								if (!all.hasPermission("csu.see")) {
								all.hidePlayer(p);
							}
						}
					}
				}
			}
			else
				ConfigWerte.playerMessage(p, cw.Prefix + cw.NoPerm);
		}
		return false;
	}
}
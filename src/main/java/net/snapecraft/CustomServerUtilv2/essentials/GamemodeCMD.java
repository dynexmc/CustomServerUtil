package net.snapecraft.CustomServerUtilv2.essentials;

import net.snapecraft.CustomServerUtilv2.util.ConfigWerte;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;

public class GamemodeCMD implements CommandExecutor{

	private static ConfigWerte cw;

	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			cw = new ConfigWerte();
			if (p.hasPermission("csu.gm")) {
				if (args.length == 0) {
					if (command.getName().equalsIgnoreCase("s")) {
						p.setGameMode(GameMode.SURVIVAL);
					}
					if (command.getName().equalsIgnoreCase("c")) {
						p.setGameMode(GameMode.CREATIVE);
					}
					if (command.getName().equalsIgnoreCase("sp")) {
						p.setGameMode(GameMode.SPECTATOR);
					}
				}
			} else
				ConfigWerte.playerMessage(p, cw.Prefix + cw.NoPerm);
			if (p.hasPermission("csu.othergm")) {
				if (args.length == 1) {
					if (Bukkit.getPlayer(args[0]) != null) {
						if (command.getName().equalsIgnoreCase("s")) {
							Bukkit.getPlayer(args[0]).setGameMode(GameMode.SURVIVAL);
						}
						if (command.getName().equalsIgnoreCase("c")) {
							Bukkit.getPlayer(args[0]).setGameMode(GameMode.CREATIVE);
						}
						if (command.getName().equalsIgnoreCase("sp")) {
							Bukkit.getPlayer(args[0]).setGameMode(GameMode.SPECTATOR);
						} else {
							p.sendMessage(CustomServerUtilv2.Prefix + "§cBenutzung: /<c/s/sp>");
						}
					} else {
						p.sendMessage(CustomServerUtilv2.Prefix + "§cBitte gib einen gültigen Spielernamen ein!");
					}
				} else {
					p.sendMessage(CustomServerUtilv2.Prefix + "§cBenutzung: /<c/s/sp> <Spieler>");
				}
			} else
				p.sendMessage(CustomServerUtilv2.noPermission);
		}
		return true;
	}
}
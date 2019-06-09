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
						ConfigWerte.playerMessage(p, cw.Prefix + cw.Survival);
					}
					if (command.getName().equalsIgnoreCase("c")) {
						p.setGameMode(GameMode.CREATIVE);
						ConfigWerte.playerMessage(p, cw.Prefix + cw.Creative);
					}
					if (command.getName().equalsIgnoreCase("sp")) {
						p.setGameMode(GameMode.SPECTATOR);
						ConfigWerte.playerMessage(p, cw.Prefix + cw.Spectator);
					}
					if(command.getName().equalsIgnoreCase("a")){
						p.setGameMode(GameMode.ADVENTURE);
						ConfigWerte.playerMessage(p, cw.Prefix + cw.Adventure);
					}
				}
			} else
				ConfigWerte.playerMessage(p, cw.Prefix + cw.NoPerm);

			if (p.hasPermission("csu.othergm")) {
				if (args.length == 1) {
					if (Bukkit.getPlayer(args[0]) != null) {
						Player target = Bukkit.getPlayer(args[0]);
						if (command.getName().equalsIgnoreCase("s")) {
							target.setGameMode(GameMode.SURVIVAL);
							ConfigWerte.playerMessage(target, cw.Prefix + cw.Survival);
							ConfigWerte.playerMessage(p, cw.Prefix + cw.SurvivalOther.replace("%player%", args[0]));
						}
						if (command.getName().equalsIgnoreCase("c")) {
							target.setGameMode(GameMode.CREATIVE);
							ConfigWerte.playerMessage(target, cw.Prefix + cw.Creative);
							ConfigWerte.playerMessage(p, cw.Prefix + cw.CreativeOther.replace("%player%", args[0]));
						}
						if (command.getName().equalsIgnoreCase("sp")) {
							target.setGameMode(GameMode.SPECTATOR);
							ConfigWerte.playerMessage(target, cw.Prefix + cw.Spectator);
							ConfigWerte.playerMessage(p, cw.Prefix + cw.SpectatorOther.replace("%player%", args[0]));
						}
						if(command.getName().equalsIgnoreCase("a")){
							target.setGameMode(GameMode.ADVENTURE);
							ConfigWerte.playerMessage(target, cw.Prefix + cw.Adventure);
							ConfigWerte.playerMessage(p, cw.Prefix + cw.AdventureOther.replace("%player%", args[0]));
						}
					} else
						ConfigWerte.playerMessage(p,cw.Prefix + cw.UnknownPlayer);
				} else
					ConfigWerte.playerMessage(p,cw.Prefix + cw.GmCMD.replace("%player%", args[0]));
			} else
				p.sendMessage(CustomServerUtilv2.noPermission);
		}
		return true;
	}
}
package net.snapecraft.CustomServerUtilv2.essentials;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;

public class Gamemodes implements CommandExecutor{

	    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

	        Player p = (Player) sender;


	        if(p.hasPermission("CustomServerUtil.gamemode")) {
	            if(args.length == 0) {
	                if(command.getName().equalsIgnoreCase("s")) {
	                    p.setGameMode(GameMode.SURVIVAL);
	                } if(command.getName().equalsIgnoreCase("c")) {
	                    p.setGameMode(GameMode.CREATIVE);
	                } if(command.getName().equalsIgnoreCase("sp")) {
	                    p.setGameMode(GameMode.SPECTATOR);
	                }
	            } else if(args.length == 1) {
	                if(Bukkit.getPlayer(args[0]) != null) {
	                    if(command.getName().equalsIgnoreCase("s")) {
	                        Bukkit.getPlayer(args[0]).setGameMode(GameMode.SURVIVAL);
	                    } if(command.getName().equalsIgnoreCase("c")) {
	                        Bukkit.getPlayer(args[0]).setGameMode(GameMode.CREATIVE);
	                    } if(command.getName().equalsIgnoreCase("sp")) {
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
	        } else {
	            p.sendMessage(CustomServerUtilv2.noPermission);
	        }



	        return true;
	    }
	}
package net.snapecraft.CustomServerUtilv2.commands;

import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;
import net.snapecraft.CustomServerUtilv2.util.Warp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(args.length == 0 && !cmd.getName().equalsIgnoreCase("warps")){

            }
            //setWarp
            if(args.length == 1){
                if(cmd.getName().equalsIgnoreCase("setWarp")){
                    if(player.hasPermission("csu.setwarp")) {
                        Warp warp = new Warp(player.getLocation(), args[0]);
                        if (!warp.warpExists()) {
                            warp.setWarp();
                            player.sendMessage(CustomServerUtilv2.Prefix + "§2Du hast den Warp §6" + args[0] + " §2erstellt!");
                        } else {
                            player.sendMessage(CustomServerUtilv2.Prefix + "§4Der Warp existiert bereits!");
                        }
                    }else{
                        player.sendMessage(CustomServerUtilv2.Prefix + "§4Du hast nicht die benötigten Rechte!");
                    }
                }
            }
            //warps
            if(args.length == 0){
                if(cmd.getName().equalsIgnoreCase("warps")){
                    Warp warp = new Warp();
                    player.sendMessage(CustomServerUtilv2.Prefix + "§2Warps: §6" + warp.warpList());
                }
            }

            if(args.length == 1){
                if(cmd.getName().equalsIgnoreCase("warp")){
                    Warp warp = new Warp(args[0]);
                    if(warp.warpExists()){
                        player.teleport(warp.getWarp());
                    }
                }
            }
        }
        return false;
    }
}

package net.snapecraft.CustomServerUtilv2.commands;

import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;
import net.snapecraft.CustomServerUtilv2.util.Locations;
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
                        Locations loc = new Locations(player.getLocation(), args[0]);
                        if (!loc.warpExists()) {
                            loc.setWarp();
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
                    Locations loc = new Locations();
                    player.sendMessage(CustomServerUtilv2.Prefix + "§2Warps: §6" + loc.warpList());
                }
            }

            if(args.length == 1){
                if(cmd.getName().equalsIgnoreCase("warp")){
                    Locations locations = new Locations(args[0]);
                    if(locations.warpExists()){
                        player.teleport(locations.getWarp());
                    }
                }
            }
        }
        return false;
    }
}

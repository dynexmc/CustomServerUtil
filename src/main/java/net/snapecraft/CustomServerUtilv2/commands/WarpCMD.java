package net.snapecraft.CustomServerUtilv2.commands;

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
            if(args.length == 1){
                Locations loc = new Locations(player.getLocation(),args[0]);
                if(!loc.warpExists()){
                    loc.setWarp();
                }
            }
            if(args.length == 0){
                if(cmd.getName().equalsIgnoreCase("warps")){
                    Locations loc = new Locations();
                    player.sendMessage(loc.waprList());
                }
            }

            if(args.length == 1){
                if(cmd.getName().equalsIgnoreCase("warp")){
                    Locations locations = new Locations(args[0],0);
                    if(locations.warpExists()){
                        player.teleport(locations.getWarp());
                    }
                }
            }
        }
        return false;
    }
}

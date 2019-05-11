package net.snapecraft.CustomServerUtilv2.commands;

import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;
import net.snapecraft.CustomServerUtilv2.util.Locations;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;

public class HomeCMD implements CommandExecutor {

    public static String HomesFormat = "§6%homes%§7, §6%nextHomes%";

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0 && !cmd.getName().equalsIgnoreCase("homes")){
                player.sendMessage(CustomServerUtilv2.Prefix + "§4Benutze /home <home> um!");
            }
            if(args.length == 0) {
                if (cmd.getName().equalsIgnoreCase("homes")) {
                    Locations loc = new Locations(player.getName());
                    if(loc.playerExists()) {
                        player.sendMessage(CustomServerUtilv2.Prefix + "§2Deine Homes: " + loc.getHomes());
                    }else {
                        player.sendMessage(CustomServerUtilv2.Prefix + "§4Du hast noch keine Homes /sethome <home>");
                    }
                }
            }
            if(args.length == 1){
                if(cmd.getName().equalsIgnoreCase("sethome")){
                    Locations loc = new Locations(player.getLocation(),player.getName(),args[0]);
                    int homes = FreeHomes(player);
                    if(!(loc.homeExists())){
                        if(loc.hasFreeHomes(homes)){
                            loc.setHome();
                            player.sendMessage(CustomServerUtilv2.Prefix + "§2Du hast ein Home mit dem Name §6" + args[0] + "§2 gesetzt!");
                        }
                        else {
                            player.sendMessage(CustomServerUtilv2.Prefix + "§4Du hast keine freien Homes mehr!");
                        }
                    }else {
                        player.sendMessage(CustomServerUtilv2.Prefix + "§4Dieses Home exestiert bereits!");
                    }
                }
            }
            if(args.length == 1){
                if (cmd.getName().equalsIgnoreCase("delhome")){
                    Locations loc = new Locations(player.getName(), args[0]);
                    if(loc.playerExists()){
                        if(loc.homeExists()){
                            loc.removeHome();
                            player.sendMessage(CustomServerUtilv2.Prefix + "§2Du hast §6" + args[0] + " §2gelöscht!");
                        }else {
                            player.sendMessage(CustomServerUtilv2.Prefix + "§4Diesen Home existiert nicht!");
                        }
                    }else{
                        player.sendMessage(CustomServerUtilv2.Prefix + "§4Du hast keine Homes zum löschen!");
                    }
                }
            }
            if(args.length == 1){
                if(cmd.getName().equalsIgnoreCase("home")){
                    Locations loc = new Locations(player.getName(), args[0]);
                    if(loc.playerExists()){
                        if(loc.homeExists()){
                            player.teleport(loc.getHome());
                            player.sendMessage(CustomServerUtilv2.Prefix + "§2Du wardest zu dem Home §6" + args[0] + " §2Teleportiert!");
                        }else {
                            player.sendMessage(CustomServerUtilv2.Prefix + "§4Diesen Home existiert nicht!");
                        }
                    }else{
                        player.sendMessage(CustomServerUtilv2.Prefix + "§4Du hast noch keine Homes /sethome <home>");
                    }
                }
            }
        }
        return false;
    }
    private int FreeHomes(Player player){
        int maxSize = 0;
        for(PermissionAttachmentInfo perms : player.getEffectivePermissions()){
            if (perms.getPermission().startsWith("homes.")) {
                maxSize = Math.max(maxSize, Integer.valueOf(perms.getPermission().split("homes.")[1]));
                return maxSize;
            }
        }
        return 0;
    }
}

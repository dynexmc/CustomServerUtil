package net.snapecraft.CustomServerUtilv2.commands;

import net.snapecraft.CustomServerUtilv2.util.Locations;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length == 0 && !cmd.getName().equalsIgnoreCase("homes")){

            }
            if(args.length == 0)
                if(cmd.getName().equalsIgnoreCase("homes")){
                    Locations loc = new Locations(player.getName(),"");
                    String out = "";
                    for(String s : loc.getHomes()){
                        out = "§e" + s + "§7, " + out;
                    }

                    out = out.trim();
                    out = out.substring(0, out.length() -1);
                    player.sendMessage(out);

                }
        }
        return false;
    }
}

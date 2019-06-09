package net.snapecraft.CustomServerUtilv2.commands;

import net.snapecraft.CustomServerUtilv2.util.ConfigWerte;
import net.snapecraft.CustomServerUtilv2.util.Home;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;

public class HomeCMD implements CommandExecutor {

    private static ConfigWerte cw;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            cw = new ConfigWerte();
            if(args.length == 0 && !cmd.getName().equalsIgnoreCase("homes")){
                ConfigWerte.playerMessage(player, cw.Prefix + cw.HomeCMD);
            }
            if(args.length == 0) {
                if (cmd.getName().equalsIgnoreCase("homes")) {
                    Home home = new Home(player.getName());
                    if(home.playerExists()) {
                        ConfigWerte.playerMessage(player,cw.Prefix + cw.Homes.replace("%homes%", home.getHomes()));
                    }else
                        ConfigWerte.playerMessage(player, cw.Prefix + cw.NoHomes);
                }
            }
            if(args.length == 1){
                if(cmd.getName().equalsIgnoreCase("sethome")){
                    Home home = new Home(player.getLocation(),player.getName(),args[0]);
                    int homes = FreeHomes(player);
                    if(!(home.homeExists())){
                        if(home.hasFreeHomes(homes)){
                            home.setHome();
                            ConfigWerte.playerMessage(player, cw.Prefix + cw.SetHome.replace("%home%", args[0]));                        }
                        else
                            ConfigWerte.playerMessage(player,cw.Prefix + cw.NoFreeHomes);
                    }else
                        ConfigWerte.playerMessage(player, cw.Prefix + cw.HomeExist);
                }
            }
            if(args.length == 1){
                if (cmd.getName().equalsIgnoreCase("delhome")){
                    Home home = new Home(player.getName(), args[0]);
                    if(home.playerExists()){
                        if(home.homeExists()){
                            home.removeHome();
                            ConfigWerte.playerMessage(player,cw.Prefix + cw.RemoveHome.replace("%home%", args[0]));
                        }else
                            ConfigWerte.playerMessage(player, cw.Prefix + cw.HomeDontExist);
                    }else
                        ConfigWerte.playerMessage(player, cw.Prefix + cw.NoHomes);
                }
            }
            if(args.length == 1){
                if(cmd.getName().equalsIgnoreCase("home")){
                    Home home = new Home(player.getName(), args[0]);
                    if(home.playerExists()){
                        if(home.homeExists()){
                            player.teleport(home.getHome());
                            ConfigWerte.playerMessage(player, cw.Prefix + cw.Home.replace("%home%", args[0]));
                        }else
                            ConfigWerte.playerMessage(player, cw.Prefix + cw.HomeDontExist);
                    }else
                        ConfigWerte.playerMessage(player, cw.Prefix + cw.NoHomes);
                }
            }
        }
        return false;
    }
    private int FreeHomes(Player player){
        int maxSize = 0;
        for(PermissionAttachmentInfo perms : player.getEffectivePermissions()){
            if (perms.getPermission().startsWith("csu.homes.")) {
                maxSize = Math.max(maxSize, Integer.valueOf(perms.getPermission().split("homes.")[1]));
                return maxSize;
            }
        }
        return 0;
    }
}

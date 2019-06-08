package net.snapecraft.CustomServerUtilv2.essentials;

import net.snapecraft.CustomServerUtilv2.util.ConfigWerte;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCMD implements CommandExecutor {

    private static ConfigWerte cw;

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args)
    {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (args.length == 0) {
                if (p.hasPermission("CustomLobby.Fly")) {
                    if (!p.getAllowFlight()) {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        ConfigWerte.playerMessage(p,cw.Prefix + cw.CanFly);
                    } else {
                        p.setFlying(false);
                        p.setAllowFlight(false);
                        ConfigWerte.playerMessage(p,cw.Prefix + cw.CantFly);
                    }
                } else {
                    ConfigWerte.playerMessage(p,cw.Prefix + cw.NoPerm);
                }
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (commandSender.hasPermission("CustomLoby.FlyOthers")) {
                    if (target != null) {

                        if (!target.getAllowFlight()) {
                            target.setAllowFlight(true);
                            target.setFlying(true);
                            ConfigWerte.playerMessage(p,cw.Prefix + cw.CanOtherFly.replace("%player%", args[0]));
                            ConfigWerte.playerMessage(target,cw.Prefix + cw.CanFly);
                        } else {
                            target.setFlying(false);
                            target.setAllowFlight(false);
                            ConfigWerte.playerMessage(p,cw.Prefix + cw.CantOtherFly.replace("%player%", args[0]));
                            ConfigWerte.playerMessage(target,cw.Prefix + cw.CantFly);
                        }
                    } else
                        ConfigWerte.playerMessage(p, cw.Prefix + cw.UnknownPlayer.replace("%player%", args[0]));
                }else
                    ConfigWerte.playerMessage(p,cw.Prefix + cw.NoPerm);
            } else
                ConfigWerte.playerMessage(p,cw.Prefix + cw.FlyCMD);
        }
        return true;
    }
}
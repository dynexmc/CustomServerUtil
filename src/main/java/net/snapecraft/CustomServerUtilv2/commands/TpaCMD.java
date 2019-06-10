package net.snapecraft.CustomServerUtilv2.commands;

import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class TpaCMD implements CommandExecutor {

    private static HashMap<Player, Player> tpaRequests = new HashMap<Player, Player>();
    private static HashMap<Player, Player> tpahereRequests = new HashMap<Player, Player>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(args.length == 0 && !cmd.getName().equalsIgnoreCase("tpaccept") && !cmd.getName().equalsIgnoreCase("tpadecline")){
                player.sendMessage(CustomServerUtilv2.Prefix + "§4Benutze /tpa <Player> oder /tpahere <Player>");
            }
            if(cmd.getName().equalsIgnoreCase("tpa")){
                if(args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                        if(target.isOnline()){
                            target.sendMessage(CustomServerUtilv2.Prefix + "§2Der Spieler §6" + player.getDisplayName() + " §2hat dir eine Teleportations anfrage geschickt!");
                            target.sendMessage(CustomServerUtilv2.Prefix + "§2Nutze §a/tpaccept §2um Die Anfrage anzunehmn oder §a/tpdecline §2um abzulehnen!");
                            player.sendMessage(CustomServerUtilv2.Prefix + "§2Du hast §6" + target.getDisplayName() + " §2eine Teleportations anfrage geschickt!");
                            if(!tpaRequests.containsKey(target)){
                                tpaRequests.put(target, player);
                            }else{
                                player.sendMessage(CustomServerUtilv2.Prefix + "§4Du hast schon eine Teleportationsanfrage geschickt!");
                            }
                        }else {
                            player.sendMessage(CustomServerUtilv2.Prefix + "§4Der Spieler " + args[0] + " §4ist nicht online!");
                        }
                }else {
                    player.sendMessage(CustomServerUtilv2.Prefix + "§4Benutze /tpa <Player>");
                }
            }
            if(cmd.getName().equalsIgnoreCase("tpahere")){
                if(args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target.isOnline()){
                        target.sendMessage(CustomServerUtilv2.Prefix + "§2Der Spieler §6" + player.getDisplayName() + " §2hat dir eine Teleportations anfrage zu ihm geschickt!");
                        target.sendMessage(CustomServerUtilv2.Prefix + "§2Nutze §a/tpaccept §2um die Anfrage anzunehmn oder §a/tpdecline §2um abzulehnen!");
                        player.sendMessage(CustomServerUtilv2.Prefix + "§2Du hast §6" + target.getDisplayName() + " §2eine Teleportations anfrage zu dir sgeschickt!");
                        if(!tpahereRequests.containsKey(player)){
                            tpahereRequests.put(target, player);
                        }else{
                            player.sendMessage(CustomServerUtilv2.Prefix + "§4Du hast schon eine Teleportationsanfrage geschickt!");
                        }
                    }else {
                        player.sendMessage(CustomServerUtilv2.Prefix + "§4Der Spieler " + args[0] + " §4ist nicht online!");
                    }
                }else {
                    player.sendMessage(CustomServerUtilv2.Prefix + "§4Benutze /tpa <Player>");
                }
            }
            if(cmd.getName().equalsIgnoreCase("tpaccept")){
                if(args.length == 0){
                    if(tpaRequests.containsKey(player)){
                        Player target = tpaRequests.get(player);
                        target.teleport(player);
                        target.sendMessage(CustomServerUtilv2.Prefix + "§2Du hast die Teleportationsanfrage von §6" + player.getDisplayName() + " §2angenommen");
                        player.sendMessage(CustomServerUtilv2.Prefix + "§a " + target.getDisplayName() + " §2wird zu dir Teleportiert!");
                        tpaRequests.remove(target);
                    }
                    if(tpahereRequests.containsKey(player)){
                        Player target = tpahereRequests.get(player);
                        player.teleport(target);
                        target.sendMessage(CustomServerUtilv2.Prefix + "§2Du hast die Teleportationsanfrage von §6" + player.getDisplayName() + " §2angenommen");
                        player.sendMessage(CustomServerUtilv2.Prefix + "§2Du wirst zu §a" + player.getDisplayName() + " §2Teleportiert!");
                        tpahereRequests.remove(target);
                    }
                }
            }
            if(cmd.getName().equalsIgnoreCase("tpdecline")){
                if(args.length == 0){
                    if(tpaRequests.containsKey(player)){
                        Player target = tpaRequests.get(player);
                        tpaRequests.remove(target);
                        target.sendMessage(CustomServerUtilv2.Prefix + "§4Du hast die Teleportationsanfrage von §6" + player.getDisplayName() + " §4abgelent");
                        player.sendMessage(CustomServerUtilv2.Prefix + "§4Deine Teleportationsanfrage wurde von §6" + target.getDisplayName() + "§4abgelent");
                    }
                    if(tpahereRequests.containsKey(player)){
                        Player target = tpaRequests.get(player);
                        tpahereRequests.remove(target);
                        target.sendMessage(CustomServerUtilv2.Prefix + "§4Du hast die Teleportationsanfrage von §6" + player.getDisplayName() + " §4abgelent");
                        player.sendMessage(CustomServerUtilv2.Prefix + "§4Deine Teleportationsanfrage wurde von §6" + target.getDisplayName() + "§4abgelent");
                    }
                }
            }
        }else {
            Bukkit.getConsoleSender().sendMessage(CustomServerUtilv2.Prefix + "§4Der Befehl ist nur für Spieler geeignet!");
        }
        return false;
    }
}

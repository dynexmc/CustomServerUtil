package net.snapecraft.CustomServerUtilv2.commands;

import net.snapecraft.CustomServerUtilv2.main.CustomServerUtilv2;
import net.snapecraft.CustomServerUtilv2.util.ConfigWerte;
import net.snapecraft.CustomServerUtilv2.util.Spawn;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor {

    private static ConfigWerte cw;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    cw = new ConfigWerte();

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(args.length == 0){
                if(cmd.getName().equalsIgnoreCase("spawn")){
                    Spawn spawn = new Spawn();
                    if(spawn.spawnExists()){
                        player.teleport(spawn.getSpawn());
                        ConfigWerte.playerMessage(player,cw.Prefix + cw.ToSpawn);
                    }else {
                        ConfigWerte.playerMessage(player,cw.Prefix + cw.NoSpawnpoint);
                        ConfigWerte.playerMessage(player,cw.Prefix + cw.SpeakDeveloper);
                    }
                }
                if(cmd.getName().equalsIgnoreCase("setspawn")){
                    if(player.hasPermission("csu.setspawn")) {
                        Spawn spawn = new Spawn(player.getLocation());
                        if (spawn.spawnExists()) {
                            spawn.setSpawn();
                            ConfigWerte.playerMessage(player, cw.Prefix + cw.MoveSpawn);
                        } else {
                            spawn.setSpawn();
                            ConfigWerte.playerMessage(player, cw.Prefix + cw.SetSpawn);
                        }
                    }else
                        ConfigWerte.playerMessage(player, cw.Prefix + cw.NoPerm);
                }
            }else
                ConfigWerte.playerMessage(player, cw.Prefix + cw.SpawnCMD);
        }
        return false;
    }
}

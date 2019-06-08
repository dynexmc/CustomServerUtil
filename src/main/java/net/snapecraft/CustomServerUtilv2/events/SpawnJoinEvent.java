package net.snapecraft.CustomServerUtilv2.events;

import net.snapecraft.CustomServerUtilv2.util.Spawn;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SpawnJoinEvent implements Listener {

    @EventHandler
    private void onSpawnTeleport(PlayerJoinEvent event){
        Spawn spawn = new Spawn();
        Player player = event.getPlayer();
        if(spawn.spawnExists()){
            player.teleport(spawn.getSpawn());
        }
    }
}

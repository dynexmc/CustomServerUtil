package net.snapecraft.CustomServerUtilv2.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import net.snapecraft.CustomServerUtilv2.essentials.VanishCMD;

public class VanishPlayerQuitEvent implements Listener {
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		
		if(VanishCMD.vanished.contains(e.getPlayer())) VanishCMD.vanished.remove(e.getPlayer());
	}

}

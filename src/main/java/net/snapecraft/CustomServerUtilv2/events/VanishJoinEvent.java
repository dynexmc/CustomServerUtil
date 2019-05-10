package net.snapecraft.CustomServerUtilv2.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


import net.snapecraft.CustomServerUtilv2.essentials.VanishCMD;

public class VanishJoinEvent implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		

				for (Player vanish : VanishCMD.vanished) {
					
					if (!e.getPlayer().hasPermission("CustomServerUtil.see")) {
						e.getPlayer().hidePlayer(vanish);
				}
			}
		}
	}

 
	
	

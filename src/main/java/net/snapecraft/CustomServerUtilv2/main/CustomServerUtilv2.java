package net.snapecraft.CustomServerUtilv2.main;

import net.snapecraft.CustomServerUtilv2.commands.HomeCMD;
import net.snapecraft.CustomServerUtilv2.commands.SpawnCMD;
import net.snapecraft.CustomServerUtilv2.commands.TpaCMD;
import net.snapecraft.CustomServerUtilv2.commands.WarpCMD;
import net.snapecraft.CustomServerUtilv2.events.SpawnJoinEvent;
import net.snapecraft.CustomServerUtilv2.util.ConfigWerte;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.snapecraft.CustomServerUtilv2.essentials.FlyCMD;
import net.snapecraft.CustomServerUtilv2.essentials.GamemodeCMD;
import net.snapecraft.CustomServerUtilv2.essentials.VanishCMD;
import net.snapecraft.CustomServerUtilv2.essentials.DayCMD;
import net.snapecraft.CustomServerUtilv2.essentials.SunCMD;


public class CustomServerUtilv2 extends JavaPlugin 
{
	private static CustomServerUtilv2 plugin;
	public static String Prefix = "Kacke < ";
	public static String noPermission = "Kake >";

	public final String art = "\n" +
			"   _____          _                   _____                          _    _ _   _ _ \n" + 
			"  / ____|        | |                 / ____|                        | |  | | | (_) |\n" + 
			" | |    _   _ ___| |_ ___  _ __ ___ | (___   ___ _ ____   _____ _ __| |  | | |_ _| |\n" + 
			" | |   | | | / __| __/ _ \\| '_ ` _ \\ \\___ \\ / _ \\ '__\\ \\ / / _ \\ '__| |  | | __| | |\n" + 
			" | |___| |_| \\__ \\ || (_) | | | | | |____) |  __/ |   \\ V /  __/ |  | |__| | |_| | |\n" + 
			"  \\_____\\__,_|___/\\__\\___/|_| |_| |_|_____/ \\___|_|    \\_/ \\___|_|   \\____/ \\__|_|_|\n" + 
			"                                                                                    \n" ;
	
	@Override
	public void onEnable() {
		plugin = this;
		registerCommands();
		registerConfig();
        registerEvents(Bukkit.getPluginManager());

		System.out.println(art);
	}

    private void registerEvents(PluginManager pm) {
        pm.registerEvents(new SpawnJoinEvent(), this);


    }
	//Test
    private void registerCommands() {
		getCommand("day").setExecutor(new DayCMD());
		getCommand("sun").setExecutor(new SunCMD());
		getCommand("c").setExecutor(new GamemodeCMD());
		getCommand("s").setExecutor(new GamemodeCMD());
		getCommand("sp").setExecutor(new GamemodeCMD());
		getCommand("a").setExecutor(new GamemodeCMD());
		getCommand("tpa").setExecutor(new TpaCMD());
		getCommand("tpaccept").setExecutor(new TpaCMD());
		getCommand("tpdecline").setExecutor(new TpaCMD());
		getCommand("tpahere").setExecutor(new TpaCMD());
		getCommand("fly").setExecutor(new FlyCMD());
		getCommand("vanish").setExecutor(new VanishCMD());
		getCommand("homes").setExecutor(new HomeCMD());
		getCommand("sethome").setExecutor(new HomeCMD());
		getCommand("delhome").setExecutor(new HomeCMD());
		getCommand("home").setExecutor(new HomeCMD());
		getCommand("warps").setExecutor(new WarpCMD());
		getCommand("setwarp").setExecutor(new WarpCMD());
		getCommand("warp").setExecutor(new WarpCMD());
		getCommand("delWarp").setExecutor(new WarpCMD());
		getCommand("spawn").setExecutor(new SpawnCMD());
		getCommand("setspawn").setExecutor(new SpawnCMD());
	}
	
	public static CustomServerUtilv2 getPlugin() {



		return plugin;
	}
	
	private void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	public static String getPrefix() {


		return Prefix;
	}
}

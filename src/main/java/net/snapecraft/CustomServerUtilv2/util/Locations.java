package net.snapecraft.CustomServerUtilv2.util;

import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class Locations {

    private File file = new File("plugins//CustomServerUtilv2//Locations.yml");
    private FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    private String playerName;
    private Location location;
    private String tpName;
    private int homes;



    public Locations(Location location, String playerName,String tpName){
        this.playerName = playerName;
        this.location = location;
        this.tpName = tpName;
    }

    public Locations(String playerName,String tpName){
        this.playerName = playerName;
        this.tpName = tpName;
    }

    public void setHome(){
            String path = playerName +".homes." + tpName;
            int homes = cfg.getInt(playerName + ".homes.anzahl");
            cfg.set(path + ".x",location.getX());
            cfg.set(path + ".y",location.getY());
            cfg.set(path + ".z",location.getZ());
            cfg.set(path + ".yaw",location.getYaw());
            cfg.set(path + ".pitch",location.getPitch());
            save();
    }

    public boolean hasFreeHomes() {
        ConfigurationSection cs = cfg.getConfigurationSection(playerName + ".homes");
        if(cs.getList(cs.getCurrentPath()).size() <= homes)
            return true;
        return false;
    }


    public boolean homeExists(){
        ConfigurationSection cs = cfg.getConfigurationSection(playerName + ".homes");
        if(cs.contains(tpName))
            return true;
        return false;
    }

    public Set<String> getHomes(){
        if(playerExists()) {
            ConfigurationSection cs = cfg.getConfigurationSection(playerName + ".homes");

                return cs.getKeys(false);

        }
        return null;
    }


    public boolean playerExists(){
        if(cfg.contains(playerName))
            return true;

        return false;
    }

    public void save(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

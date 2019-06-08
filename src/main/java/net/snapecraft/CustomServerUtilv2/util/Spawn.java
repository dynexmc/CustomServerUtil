package net.snapecraft.CustomServerUtilv2.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Spawn {

    public Spawn(Location location){
        this.location = location;
    }
    public Spawn(){}

    private File file = new File("plugins//CustomServerUtilv2//Spawn.yml");
    private FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    private Location location;

    public void setSpawn(){
        cfg.set("Spawn.world", location.getWorld().getName());
        cfg.set("Spawn.x",location.getX());
        cfg.set("Spawn.y",location.getY());
        cfg.set("Spawn.z",location.getZ());
        cfg.set("Spawn.yaw",location.getYaw());
        cfg.set("Spawn.pitch",location.getPitch());
        save();
    }

    public Location getSpawn(){
        String W = cfg.getString("Spawn.world");
        World w = Bukkit.getWorld(W);
        double x = cfg.getDouble("Spawn.x");
        double y = cfg.getDouble("Spawn.y");
        double z = cfg.getDouble("Spawn.z");
        float yaw = (float)cfg.getDouble("Spawn.yaw");
        float pitch = (float)cfg.getDouble("Spawn.pitch");
        return new Location(w,x,y,z,yaw,pitch);
    }

    public boolean spawnExists(){
        if(cfg.contains("Spawn"))
            return true;
        return false;
    }

    private void save(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

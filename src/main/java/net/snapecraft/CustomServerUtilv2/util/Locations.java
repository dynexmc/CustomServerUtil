package net.snapecraft.CustomServerUtilv2.util;

import net.snapecraft.CustomServerUtilv2.commands.HomeCMD;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Locations {

    private File file = new File("plugins//CustomServerUtilv2//Locations.yml");
    private FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    private String playerName;
    private Location location;
    private String tpName;

    public Locations(Location location, String playerName,String tpName){
        this.playerName = playerName;
        this.location = location;
        this.tpName = tpName;
    }

    public Locations(String playerName,String tpName){
        this.playerName = playerName;
        this.tpName = tpName;
    }

    public Locations(String playerName){
        this.playerName = playerName;
    }

    public Locations(Location location, String tpName){
        this.location = location;
        this.tpName = tpName;
    }

    public Locations(String tpName, int nix){
        this.tpName = tpName;
    }

    public Locations(){}

    public void setHome(){
        String path = playerName +".homes." + tpName;
        cfg.set(path + ".world", location.getWorld().getName());
        cfg.set(path + ".x",location.getX());
        cfg.set(path + ".y",location.getY());
        cfg.set(path + ".z",location.getZ());
        cfg.set(path + ".yaw",location.getYaw());
        cfg.set(path + ".pitch",location.getPitch());
        save();
    }

    public Location getHome(){
        String path = playerName +".homes." + tpName;
        String W = cfg.getString(path + ".world");
        World w = Bukkit.getWorld(W);
        double x = cfg.getDouble(path + ".x");
        double y = cfg.getDouble(path + ".y");
        double z = cfg.getDouble(path + ".z");
        float yaw = (float)cfg.getDouble(path + ".yaw");
        float pitch = (float)cfg.getDouble(path + ".pitch");
        return new Location(w,x,y,z,yaw,pitch);
    }

    public boolean hasFreeHomes(int homes) {
        if(cfg.contains(playerName)){
        ConfigurationSection cs = cfg.getConfigurationSection(playerName + ".homes");
        if(cs.getKeys(false).size() <= homes -1)
            return true;
        }else
            return true;
        return false;
    }


    public boolean homeExists(){
        if(cfg.contains(playerName + ".homes." + tpName))
            return true;
        return false;
    }

    public String getHomes(){
        if(playerExists()) {
            ConfigurationSection cs = cfg.getConfigurationSection(playerName + ".homes");
            String out = "";
            for(String s : cs.getKeys(false)){
                out = HomeCMD.HomesFormat.replace("%homes%", s).replace("%nextHomes%",out);
            }

            out = out.trim();
            out = out.substring(0, out.length() -1);
                return out;
        }
        return null;
    }

    public void removeHome(){
        cfg.set(playerName + ".homes." + tpName, null);
        save();
    }

    public boolean playerExists(){
        if(cfg.contains(playerName))
            return true;

        return false;
    }

    public void setWarp(){
        String path = "Warps." + tpName;
        cfg.set(path + ".world", location.getWorld().getName());
        cfg.set(path + ".x", location.getX());
        cfg.set(path + ".y", location.getY());
        cfg.set(path + ".z", location.getZ());
        cfg.set(path + ".yaw", location.getYaw());
        cfg.set(path + ".pitch", location.getPitch());
        save();
    }

    public Location getWarp(){
        String path = "Warps." + tpName;
        String World = cfg.getString(path + ".world");
        World w = Bukkit.getWorld(World);
        double x = cfg.getDouble(path + ".x");
        double y = cfg.getDouble(path + ".y");
        double z = cfg.getDouble(path + ".z");
        float yaw = (float)cfg.getDouble(path + ".yaw");
        float pitch = (float)cfg.getDouble(path + ".pitch");

        return new Location(w,x,y,z,yaw,pitch);
    }

    public boolean warpExists(){
        if(cfg.contains("Warps." + tpName))
            return true;
        return false;
    }

    public String waprList(){
        ConfigurationSection cs = cfg.getConfigurationSection("Warps");
        String out = "";
        for(String s : cs.getKeys(false)){
            out = HomeCMD.HomesFormat.replace("%homes%", s).replace("%nextHomes%",out);
        }

        out = out.trim();
        out = out.substring(0, out.length() -4);
        if(out != null)
        return out;

        return null;
    }

    public void delWarp(){
        cfg.set("Warps." + tpName, null);
        save();
    }

    public void save(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

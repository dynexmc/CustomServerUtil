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

public class Home {

    private File file = new File("plugins//CustomServerUtilv2//Homes.yml");
    private FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    private String playerName;
    private Location location;
    private String root;

    public Home(Location location, String playerName, String root){
        this.playerName = playerName;
        this.location = location;
        this.root = root;
    }
    public Home(String playerName, String root){
        this.playerName = playerName;
        this.root = root;
    }
    public Home(String Root){
        this.root = root;
    }

    //Location PlayerName Root
    public void setHome(){
        String path = playerName +".homes." + root;
        cfg.set(path + ".world", location.getWorld().getName());
        cfg.set(path + ".x",location.getX());
        cfg.set(path + ".y",location.getY());
        cfg.set(path + ".z",location.getZ());
        cfg.set(path + ".yaw",location.getYaw());
        cfg.set(path + ".pitch",location.getPitch());
        save();
    }

    //PlayerName Root
    public Location getHome(){
        String path = playerName +".homes." + root;
        String W = cfg.getString(path + ".world");
        World w = Bukkit.getWorld(W);
        double x = cfg.getDouble(path + ".x");
        double y = cfg.getDouble(path + ".y");
        double z = cfg.getDouble(path + ".z");
        float yaw = (float)cfg.getDouble(path + ".yaw");
        float pitch = (float)cfg.getDouble(path + ".pitch");
        return new Location(w,x,y,z,yaw,pitch);
    }

    //Root
    public boolean hasFreeHomes(int homes) {
        if(cfg.contains(root)){
            ConfigurationSection cs = cfg.getConfigurationSection(root + ".homes");
            if(cs.getKeys(false).size() <= homes -1)
                return true;
        }else
            return true;
        return false;
    }

    //PlayerName Root
    public boolean homeExists(){
        if(cfg.contains(playerName + ".homes." + root))
            return true;
        return false;
    }

    //Root
    public String getHomes(){
        if(playerExists()) {
            ConfigurationSection cs = cfg.getConfigurationSection(root + ".homes");
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

    //PlayerName Root
    public void removeHome(){
        cfg.set(playerName + ".homes." + root, null);
        save();
    }

    //Root
    public boolean playerExists(){
        if(cfg.contains(root))
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

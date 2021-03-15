package net.michal.basic;

import net.michal.commands.FreeSpaceCommand;
import net.michal.tasks.GenerateCoordinatesTask;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class FunnyGuildsAddon extends JavaPlugin {
    private final List<Location> locationList = new ArrayList<>();

    @Override
    public void onEnable() {
        new GenerateCoordinatesTask(this);
        new FreeSpaceCommand(this);
        saveDefaultConfig();
    }

    public List<Location> getLocationList() {
        return locationList;
    }
}

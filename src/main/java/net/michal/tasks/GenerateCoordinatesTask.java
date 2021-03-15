package net.michal.tasks;

import net.dzikoysk.funnyguilds.basic.guild.RegionUtils;
import net.michal.basic.FunnyGuildsAddon;
import net.michal.config.Configuration;
import net.michal.utils.RandomUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class GenerateCoordinatesTask implements Runnable {
    private final FunnyGuildsAddon addon;

    public GenerateCoordinatesTask(FunnyGuildsAddon addon) {
        this.addon = addon;
        addon.getServer().getScheduler().runTaskTimerAsynchronously(addon, this, 0L, Configuration.generationDelay * 20L);
    }

    @Override
    public void run() {
        int x = RandomUtils.getRandomInt(Configuration.minBound, Configuration.maxBound),
            z = RandomUtils.getRandomInt(Configuration.minBound, Configuration.maxBound);

        Location location = new Location(Bukkit.getWorlds().get(0), x, 128, z);

        if (!RegionUtils.isIn(location) && !RegionUtils.isNear(location)) {
            if (!(addon.getLocationList().size() > (Configuration.listSize - 1))) {
                addon.getLocationList().add(location);
            }
        }
    }
}

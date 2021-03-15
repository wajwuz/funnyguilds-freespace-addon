package net.michal.config;

import net.michal.basic.FunnyGuildsAddon;
import org.bukkit.configuration.file.FileConfiguration;

public class Configuration {
    private static final FileConfiguration configuration = FunnyGuildsAddon.getPlugin(FunnyGuildsAddon.class).getConfig();
    public static int minBound = configuration.getInt("bound.min");
    public static int maxBound = configuration.getInt("bound.max");
    public static String freeSpaceMessage = configuration.getString("messages.freeSpace");
    public static String locationListMessage = configuration.getString("messages.locationList");
    public static int generationDelay = configuration.getInt("generationTime");
    public static int listSize = configuration.getInt("listSize");
}

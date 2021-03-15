package net.michal.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LocationUtils {
    public static long getDistanceToLocation(final Location location, final Player player) {
        final Location playerLocation = player.getLocation();
        final double distance = playerLocation.distance(location);

        return Math.round(distance);
    }
}

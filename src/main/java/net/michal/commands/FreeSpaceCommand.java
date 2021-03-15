package net.michal.commands;

import net.dzikoysk.funnyguilds.basic.guild.RegionUtils;
import net.michal.basic.FunnyGuildsAddon;
import net.michal.config.Configuration;
import net.michal.helpers.ChatHelper;
import net.michal.utils.LocationUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreeSpaceCommand implements CommandExecutor {
    private final FunnyGuildsAddon addon;

    public FreeSpaceCommand(FunnyGuildsAddon addon) {
        this.addon = addon;
        addon.getCommand("wolnemiejsce").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return true;
        final Player player = (Player) commandSender;

        addon.getLocationList().removeIf(RegionUtils::isIn);
        addon.getLocationList().removeIf(RegionUtils::isNear);

        player.sendMessage(ChatHelper.fix(Configuration.freeSpaceMessage));
        addon.getLocationList().forEach(location -> player.sendMessage(ChatHelper.fix(Configuration.locationListMessage)
                .replace("{X}", String.valueOf(location.getX()))
                .replace("{Z}", String.valueOf(location.getZ()))
                .replace("{DISTANCE}", String.valueOf(LocationUtils.getDistanceToLocation(location, player)))));
        return false;
    }
}

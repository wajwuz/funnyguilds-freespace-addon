package net.michal.helpers;

import org.bukkit.ChatColor;

public class ChatHelper {
    public static String fix(String s) {
        return ChatColor.translateAlternateColorCodes('&', s)
                .replace(">>", "\u00BB")
                .replace("<<", "\u00AB")
                .replace("{o}", "\u30FB");
    }
}

package de.noel.utils;

import static de.schmidimc.mc.common.communication.ChatHelper.say;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import de.noel.Start;
import de.schmidimc.mc.common.communication.ChatHelper;

public class ChatManager {

	public static void sendMessage(CommandSender sender, String text) {
		ChatHelper.setPrefix(ChatColor.BOLD + "" + ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + Start.pluginName
				+ ChatColor.DARK_GREEN + "]" + ChatColor.BLUE + " >>> ");
		say(sender, text);
	}

	public static void sendErrorMessage(CommandSender sender, String text) {
		ChatHelper.setPrefix(ChatColor.BOLD+""+ChatColor.DARK_GREEN+"["+ChatColor.GREEN+Start.pluginName+ChatColor.DARK_GREEN+"]"+ChatColor.RED+" >>> ");
		
	}
}

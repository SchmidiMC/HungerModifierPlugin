package de.noel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import de.noel.config.SettingsConfig;
import de.noel.controller.ListenerController;
import de.noel.repository.ListenerPointsRepository;
import de.noel.services.ActivatedTrackersService;
import de.noel.services.PlayerFoodService;
import de.noel.utils.ChatManager;
import de.schmidimc.mc.common.annotation.ApiVersion;
import de.schmidimc.mc.common.annotation.plugin.Plugin;

@Plugin(apiVersion = ApiVersion.VERSION_1_16, author = "Schmidi", description = "Plugin to configure hunger", main = "de.noel.Start", name = Start.pluginName, version = "1.0.0")
public class Start extends JavaPlugin {

	public final static String pluginName = "MoreHunger";
	private ConsoleCommandSender console;

	private PlayerFoodService playerFoodService;

	private ListenerController listenerController;

	private ListenerPointsRepository listenerPointRepo;

	private ActivatedTrackersService activatedTrackerService;

	private SettingsConfig settingsConfig;
	
	@Override
	public void onEnable() {
		this.console = Bukkit.getConsoleSender();

		this.settingsConfig = new SettingsConfig(this);
		
		this.playerFoodService = new PlayerFoodService();

		this.listenerController = new ListenerController(playerFoodService);

		this.listenerPointRepo = new ListenerPointsRepository(this.settingsConfig.getAllTrackerPoints());

		this.activatedTrackerService = new ActivatedTrackersService(this.listenerController);

		ChatManager.sendMessage(console, "MoreHunger was started successfully.");
	}


	@Override
	public void onDisable() {
		this.settingsConfig.saveConfig();
	}
}

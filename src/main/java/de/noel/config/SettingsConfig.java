package de.noel.config;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.noel.Start;
import de.noel.model.ActivatedTracker;

public class SettingsConfig {

	private final String defaultPath = "settings.";
	private File customConfigFile;
	private FileConfiguration customConfig;
	private Start plugin;

	public SettingsConfig(Start plugin) {
		this.plugin = plugin;
		this.createCustomConfig();
	}

	private void createCustomConfig() {
		customConfigFile = new File(plugin.getDataFolder(), defaultPath+"yml");
		if (!customConfigFile.exists()) {
			customConfigFile.getParentFile().mkdirs();
			this.loadDefaultValues();
			plugin.saveResource(defaultPath+"yml", false);
		}

		customConfig = new YamlConfiguration();
		try {
			customConfig.load(customConfigFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	private void loadDefaultValues() {

		this.customConfig.set(defaultPath+"defaultFood", true);
		this.customConfig.set(defaultPath+"loosingFoodLevel", 1);
		this.customConfig.set(defaultPath+"maxPoints", 1500);

		this.customConfig.set(defaultPath+"points.BLOCK_DESTROYING", 100);
		this.customConfig.set(defaultPath+"points.BLOCK_PLACING", 100);
		this.customConfig.set(defaultPath+"points.SLEEPING", 10000);
		this.customConfig.set(defaultPath+"points.WALKING", 100);

	}

	public void saveConfig() {
		try {
			this.customConfig.save(this.customConfigFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean usingDefaultFood() {
		return this.customConfig.getBoolean(defaultPath+"defaultFood");
	}
	
	public int getLossingFoodLevel() {
		return this.customConfig.getInt(defaultPath+"loosingFoodLevel");
	}
	
	public double getMaxPoints() {
		return this.customConfig.getDouble(defaultPath+"maxPoints");
	}
	
	public double getPointsFrom(String tracker) {
		return this.customConfig.getDouble(defaultPath+"points."+tracker);
	}
	
	public Map<ActivatedTracker, Double> getAllTrackerPoints() {
		Map<ActivatedTracker, Double> trackerPoints = new HashMap<>();
		for(ActivatedTracker tracker : ActivatedTracker.values()) {
			double points = this.getPointsFrom(tracker.toString());
			if(points > 0) {
				trackerPoints.put(tracker, points);
			}
		}
		return trackerPoints;
	}

}

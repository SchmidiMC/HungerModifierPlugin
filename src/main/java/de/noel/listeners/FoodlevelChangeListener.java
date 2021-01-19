package de.noel.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import de.noel.Start;
import de.schmidimc.mc.common.annotation.Listener;

@Listener
public class FoodlevelChangeListener {

	private Start plugin;

	public FoodlevelChangeListener(Start plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onFoodlevelChange(FoodLevelChangeEvent event) {
		if (!this.plugin.defaultFoodActivated()) {
			event.setCancelled(true);
		}

	}

}

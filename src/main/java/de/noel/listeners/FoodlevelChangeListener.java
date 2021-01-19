package de.noel.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import de.schmidimc.mc.common.annotation.Listener;

@Listener
public class FoodlevelChangeListener {

	public FoodlevelChangeListener() {
		// TODO Auto-generated constructor stub
	}
	
	@EventHandler
	public void onFoodlevelChange(FoodLevelChangeEvent event) {
		/*
		 * TODO 
		 * if(changing by default is disabled) {
		 * 	if allowed to change -> change;
		 * }
		 * 
		 */
	}
	
}

package de.noel.services;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class PlayerFoodService {
	
	private Map<Player, Double> playerFoodPoints;

	private double maxPoints;
	private int loosingFoodLevels;

	public PlayerFoodService() {
		this.playerFoodPoints = new HashMap<>();
		this.maxPoints = 100.0;
		this.loosingFoodLevels = 2;
	}
	
	/***
	 * 
	 * @param maxPoints - defines the amount of points a player requires to loose a defined foodlevel.
	 * @param loosingFoodLevels - amount of foodlevels a player looses when reaching the maximum points.
	 */
	public PlayerFoodService(double maxPoints, int loosingFoodLevels) {
		this.playerFoodPoints = new HashMap<>();
		this.maxPoints = maxPoints;
		this.loosingFoodLevels = loosingFoodLevels;
	}
	
	public void addPointsTo(Player player, double points) {
		if(this.playerFoodPoints.containsKey(player)) {
			
			double updatedPoints = this.playerFoodPoints.get(player) + points;
			
			if(updatedPoints >= this.maxPoints) {
				updatedPoints = updatedPoints-this.maxPoints;
				for(int i = 0; i < loosingFoodLevels; i++) {
					removeFoodlevel(player);
				}
			}
			
			this.playerFoodPoints.put(player, updatedPoints);
		} else {
			this.playerFoodPoints.put(player, (double) points);
		}
	}
	
	public void removeFoodlevel(Player p) {
		int currentFoodlevel = p.getFoodLevel();
		if(currentFoodlevel > 0) {
			p.setFoodLevel(currentFoodlevel-1);
		}
	}
	
	public Map<Player, Double> getPlayerFoodPoints() {
		return playerFoodPoints;
	}

}

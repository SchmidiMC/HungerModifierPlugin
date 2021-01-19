package de.noel.services;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import de.noel.model.ActivatedTracker;
import de.noel.repository.ListenerPointsRepository;

public class PlayerSleepListener implements Listener {

	private PlayerFoodService playerFoodService;
	private ListenerPointsRepository listenerPointRepo;
	
	public PlayerSleepListener(PlayerFoodService playerFoodService) {
		this.playerFoodService = playerFoodService;
	}
	
	@EventHandler
	public void onPlayerSleep(PlayerBedLeaveEvent event) {
		
		Player player = event.getPlayer();
		this.playerFoodService.addPointsTo(player, this.listenerPointRepo.getPointsOf(ActivatedTracker.SLEEPING));
		
	}
	
}

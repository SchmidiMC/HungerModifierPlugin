package de.noel.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.noel.model.ActivatedTracker;
import de.noel.repository.ListenerPointsRepository;
import de.noel.services.PlayerFoodService;

public class PlayerWalkListener implements Listener {

	private PlayerFoodService playerFoodService;
	private ListenerPointsRepository listenerPointRepo;

	public PlayerWalkListener(PlayerFoodService playerFoodService) {
		this.playerFoodService = playerFoodService;
	}

	@EventHandler
	public void onPlayerWalk(PlayerMoveEvent event) {

		Player player = event.getPlayer();

		if (event.getFrom().distance(event.getTo()) > 1) {

			this.playerFoodService.addPointsTo(player, this.listenerPointRepo.getPointsOf(ActivatedTracker.WALKING));
		}

	}

}

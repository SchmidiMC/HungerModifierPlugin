package de.noel.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import de.noel.model.ActivatedTracker;
import de.noel.repository.ListenerPointsRepository;
import de.noel.services.PlayerFoodService;

public class BlockDestroyListener implements Listener {

	private PlayerFoodService playerFoodService;
	private ListenerPointsRepository listenerPointRepo;

	public BlockDestroyListener(PlayerFoodService playerFoodService) {
		this.playerFoodService = playerFoodService;
	}

	@EventHandler
	public void onPlayerDestroy(BlockBreakEvent event) {

		Player player = event.getPlayer();

		this.playerFoodService.addPointsTo(player,
				this.listenerPointRepo.getPointsOf(ActivatedTracker.BLOCK_DESTROYING));

	}

}

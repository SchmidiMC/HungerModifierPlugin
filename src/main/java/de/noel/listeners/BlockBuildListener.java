package de.noel.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import de.noel.model.ActivatedTracker;
import de.noel.repository.ListenerPointsRepository;
import de.noel.services.PlayerFoodService;

public class BlockBuildListener implements Listener {

	private PlayerFoodService playerFoodService;
	private ListenerPointsRepository listenerPointRepo;

	public BlockBuildListener(PlayerFoodService playerFoodService) {
		this.playerFoodService = playerFoodService;
	}

	@EventHandler
	public void onBlockBuild(BlockPlaceEvent event) {

		Player player = event.getPlayer();

		this.playerFoodService.addPointsTo(player, this.listenerPointRepo.getPointsOf(ActivatedTracker.BLOCK_PLACING));

	}

}

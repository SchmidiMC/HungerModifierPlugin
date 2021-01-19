package de.noel.controller;

import java.util.List;
import java.util.Map;

import org.bukkit.event.Listener;

import de.noel.listeners.BlockBuildListener;
import de.noel.listeners.BlockDestroyListener;
import de.noel.listeners.PlayerWalkListener;
import de.noel.model.ActivatedTracker;
import de.noel.services.PlayerFoodService;
import de.noel.services.PlayerSleepListener;

public class ListenerController {

	private BlockDestroyListener blockDestroyListener;
	private BlockBuildListener blockBuildListener;
	private PlayerWalkListener playerWalkListener;
	private PlayerSleepListener playerSleepListener;

	private List<Listener> avaibleListener;

	private Map<ActivatedTracker, Boolean> activatedTrackers;

	private PlayerFoodService playerFoodService;

	public ListenerController(PlayerFoodService playerFoodService) {
		this.playerFoodService = playerFoodService;
	}

	public void updateTrackers(Map<ActivatedTracker, Boolean> activatedTrackers) {
		this.activatedTrackers = activatedTrackers;
		this.initializeListeners();
	}

	public void initializeListeners() {
		if (this.activatedTrackers.get(ActivatedTracker.BLOCK_PLACING)) {
			this.blockBuildListener = new BlockBuildListener(this.playerFoodService);
			this.avaibleListener.add(this.blockBuildListener);
		}

		if (this.activatedTrackers.get(ActivatedTracker.BLOCK_DESTROYING)) {
			this.blockDestroyListener = new BlockDestroyListener(this.playerFoodService);
			this.avaibleListener.add(this.blockDestroyListener);
		}

		if (this.activatedTrackers.get(ActivatedTracker.WALKING)) {
			this.playerWalkListener = new PlayerWalkListener(this.playerFoodService);
			this.avaibleListener.add(this.playerWalkListener);
		}

		if (this.activatedTrackers.get(ActivatedTracker.SLEEPING)) {
			this.playerSleepListener = new PlayerSleepListener(this.playerFoodService);
			this.avaibleListener.add(this.playerSleepListener);
		}
	}

	public List<Listener> getAvaibleListener() {
		return avaibleListener;
	}

}

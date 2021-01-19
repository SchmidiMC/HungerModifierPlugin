package de.noel.services;

import java.util.HashMap;
import java.util.Map;

import de.noel.controller.ListenerController;
import de.noel.model.ActivatedTracker;

public class ActivatedTrackersService {

	private Map<ActivatedTracker, Boolean> activatedTrackers;
	private ListenerController listenerController;

	public ActivatedTrackersService(ListenerController listenerController) {
		this.activatedTrackers = new HashMap<>();
		for (ActivatedTracker tracker : ActivatedTracker.values()) {
			this.activatedTrackers.put(tracker, true);
		}
		this.listenerController.updateTrackers(this.activatedTrackers);
	}

	public ActivatedTrackersService(Map<ActivatedTracker, Boolean> activatedTrackers,
			ListenerController listenerController) {
		this.activatedTrackers = activatedTrackers;
		this.listenerController.updateTrackers(this.activatedTrackers);
	}

	public void setTracker(ActivatedTracker tracker) {
		boolean trackerValue = this.activatedTrackers.get(tracker);
		this.activatedTrackers.put(tracker, !trackerValue);
		this.listenerController.updateTrackers(this.activatedTrackers);
	}

	public boolean trackerIsActive(ActivatedTracker tracker) {
		return this.activatedTrackers.get(tracker);
	}

	public Map<ActivatedTracker, Boolean> getActivatedTrackers() {
		return activatedTrackers;
	}

}

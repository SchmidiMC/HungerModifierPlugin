package de.noel.repository;

import java.util.Map;

import de.noel.model.ActivatedTracker;

public class ListenerPointsRepository {

	private Map<ActivatedTracker, Double> trackerPoints;
	
	public ListenerPointsRepository(Map<ActivatedTracker, Double> trackerPoints) {
		this.trackerPoints = trackerPoints;
	}
	
	public double getPointsOf(ActivatedTracker tracker) {
		if(this.trackerPoints.containsKey(tracker)) {
			return this.trackerPoints.get(tracker);
		}
		return 0;
	}
	
}

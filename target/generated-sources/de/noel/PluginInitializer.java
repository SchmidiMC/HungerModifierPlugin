package de.noel;
public final class PluginInitializer {

	public static final void init(final de.noel.Start plugin) {
		plugin.getServer().getPluginManager().registerEvents(new de.noel.listeners.FoodlevelChangeListener(plugin), plugin);
		
	}
}

package games.stendhal.server.entity.mapstuff.chest;

import games.stendhal.common.MathHelper;
import games.stendhal.server.core.config.ZoneConfigurator;
import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.Entity;
import games.stendhal.server.entity.mapstuff.chest.StoredChest;

import java.util.List;
import java.util.Map;

public class StoredChestConfigurator implements ZoneConfigurator {

	/**
	 * Configure a zone.
	 *
	 * @param	zone		The zone to be configured.
	 * @param	attributes	Configuration attributes.
	 */
	public void configureZone(final StendhalRPZone zone, final Map<String, String> attributes) {
		if (isValid(attributes)) {
			final int x = MathHelper.parseInt(attributes.get("x"));
			final int y = MathHelper.parseInt(attributes.get("y"));
			buildStoredChest(zone, x, y);
		}
	}

	private void buildStoredChest(final StendhalRPZone zone, final int x, final int y) {
		if (!chestAt(zone, x,y)) {
			final StoredChest chest = new StoredChest();
			chest.setPosition(x, y);
			zone.add(chest);
		}
	}

	private boolean chestAt(final StendhalRPZone zone, final int x, final int y) {
		final List<Entity> list = zone.getEntitiesAt(x,y);
		for (Entity entity : list) {
			if (entity instanceof StoredChest) {
				// Don't put a stored chest over a previously stored one
				return true;
			}
		}
		return false;
	}

	private boolean isValid(final Map<String, String> attributes) {
		return attributes.containsKey("x") && attributes.containsKey("y");
	}

}

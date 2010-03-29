/* $Id$ */
/***************************************************************************
 *                      (C) Copyright 2003 - Marauroa                      *
 ***************************************************************************
 ***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 ***************************************************************************/
package games.stendhal.server.entity.mapstuff.spawner;

import games.stendhal.common.Rand;
import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.core.rp.StendhalRPAction;
import games.stendhal.server.entity.creature.KillNotificationCreature;

import java.util.LinkedList;
import java.util.List;
import java.util.Observer;

import org.apache.log4j.Logger;

public class KillNotificationCreatureRespawnPoint extends CreatureRespawnPoint {

	/** the logger instance. */
	private static final Logger logger = Logger.getLogger(CreatureRespawnPoint.class);

	/**
	 * This is the prototype; it will be copied to create new creatures that
	 * will be spawned here.
	 */
	private final KillNotificationCreature prototypeCreature;

	/** All creatures that were spawned here and that are still alive. */
	private final List<KillNotificationCreature> creatures;

	
	private Observer observer;

	/**
	 * Creates a new RespawnPoint.
	 * 
	 * @param zone
	 * @param x
	 * @param y
	 * @param creature
	 *            The prototype creature
	 * @param maximum
	 *            The number of creatures spawned here that can exist at the
	 *            same time
	 */
	public KillNotificationCreatureRespawnPoint(final StendhalRPZone zone, final int x, final int y,
			final KillNotificationCreature creature, final int maximum, final Observer observer) {
		super(zone, x, y, creature, maximum);
		this.prototypeCreature = creature;
		this.observer = observer;
		this.creatures = new LinkedList<KillNotificationCreature>();

		//respawning = true;
		
		// don't respawn in next turn!
		//SingletonRepository.getTurnNotifier().notifyInTurns(calculateNextRespawnTurn(), this); 
	
	}


	/**
	 * Pops up a new creature.
	 */
	@Override
	protected void respawn() {

		try {
			// clone the prototype creature
			final KillNotificationCreature newentity = prototypeCreature.getNewInstance();

			// A bit of randomization to make Joan and Snaketails a bit happier.
			// :)
			newentity.setATK(Rand.randGaussian(newentity.getATK(),
					newentity.getATK() / 10));
			newentity.setDEF(Rand.randGaussian(newentity.getDEF(),
					newentity.getDEF() / 10));
			newentity.registerObjectsForNotification(observer);
			
			if (StendhalRPAction.placeat(zone, newentity, x, y)) {
				newentity.init();
				newentity.setRespawnPoint(this);

				creatures.add(newentity);
			} else {
				// Could not place the creature anywhere. 
				// Treat it like it just had died.
				notifyDead(newentity);
				logger.warn("Could not respawn " + newentity.getName() + " near " 
						+ zone.getName() + " " + x + " " + y);
			}
		} catch (final Exception e) {
			logger.error("error respawning entity " + prototypeCreature, e);
		}
	}
}

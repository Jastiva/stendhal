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
package games.stendhal.client.entity;

import games.stendhal.client.GameObjects;
import marauroa.common.game.AttributeNotFoundException;
import marauroa.common.game.RPObject;

public abstract class PassiveEntity extends Entity {
	public PassiveEntity(GameObjects gameObjects, RPObject object)
			throws AttributeNotFoundException {
		super(gameObjects, object);
	}
}

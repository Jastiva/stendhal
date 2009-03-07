package games.stendhal.client.gui.bag;

import java.awt.Component;
import java.awt.Dimension;

import marauroa.common.game.RPObject;

public class ItemPanelControler {

	private static final Dimension PREFERRED_SIZE = new Dimension(40, 40);
	private boolean isEmpty = true;
	private final ItemPanel ITEM_PANEL = new ItemPanel();
	
	public ItemPanelControler() {
		ITEM_PANEL.setPreferredSize(PREFERRED_SIZE);
	}
	
	public Component getComponent() {
		return ITEM_PANEL;
	}

	public void removeItem(RPObject object) {
		ITEM_PANEL.setImage(null);
		this.isEmpty = true;
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}
	
	public void addNew(final RPObject object) {
		isEmpty = false;
		ITEM_PANEL.setImage(new ItemImageLoader().loadItemImageFromObject(object));
		String amount = "";
		if (object.has("quantity")) {
			amount = object.get("quantity");
		}
	}

	public void updateValues(final RPObject object) {
		if (object.has("quantity")) {
		}
	}
}

package games.stendhal.server.core.events;

/**
 * Event types used in the tutorial.
 * 
 * @author hendrik
 */
public enum TutorialEventType {

	FIRST_LOGIN(
			"Hi, welcome to Stendhal. You can move around using the arrow keys."),
	FIRST_MOVE(
			"You can talk to Hayunn Naratha by saying \"hi\"."),
	RETURN_GUARDHOUSE(
			"Talk to Hayunn Naratha again by saying \"hi\"."),
	VISIT_SEMOS_CITY(
			"You can get a map of Semos from Monogenes. Start by saying \"hi\". Or you can go down the steps to the dungeons and fight some creatures."),
	VISIT_SEMOS_DUNGEON(
			"You can attack creatures by clicking on them."),
	VISIT_SEMOS_DUNGEON_2(
			"Be careful. If you walk deeper and deeper, the creatures will get more powerful."),
	VISIT_SEMOS_TAVERN(
			"You can trade with an NPC by saying \"hi\" then asking for their \"offer\". If you want to buy a flask, say \"buy flask\"."),
	FIRST_ATTACKED(
			"Did you notice that creature walking towards you with the yellow square? It is attacking you."),
	FIRST_KILL(
			"Click on the Corpse and drag the items with the mouse over your bag and drop them there."),
    FIRST_PLAYER_KILL(
			"You have been marked with the red skull of a player killer. You may find that people are wary of you now. To get it removed, you may speak to Io Flotto in Semos temple."),
	FIRST_POISONED(
			"You've just been poisoned. If you didn't drink poison, it was probably a poisonous creature attacking you. Kill poisonous creatures quickly, as you lose more HP each time you are poisoned."),
	FIRST_PLAYER(
			"Have you noticed that this name is printed in white? It is another real human player."),
	FIRST_DEATH(
			"Oh, you have just died. But fortunately death is not permanent in this world."),
	TIMED_HELP(
			"Press F1 to read the manual with many pictures."),
	TIMED_NAKED(
			"Oh, aren't you feeling cold? Right click on yourself and choose \"Set Outfit\" to get dressed."),
	TIMED_PASSWORD(
			"Remember to keep your password completely secret, never tell it to another friend, player, or even admin."),
	TIMED_OUTFIT(
			"Do you like your outfit? If not, you can change it. Right click on yourself and choose \"Set Outfit\" to experiment with new hair, face, clothes and body."),
	TIMED_RULES(
			"Thank you for continuing to play Stendhal. Now that you have played for some time, it's important that you read the rules, please type #/rules and they will open in a browser.");
	private String message;

	/**
	 * Creates a new TutorialEventType.
	 * 
	 * @param message
	 *            human readable message
	 */
	private TutorialEventType(final String message) {
		this.message = message;
	}

	/**
	 * Gets the descriptive message.
	 * 
	 * @return message
	 */
	String getMessage() {
		return message;
	}
}

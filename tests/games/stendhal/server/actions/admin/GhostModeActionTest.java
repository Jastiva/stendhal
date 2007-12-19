package games.stendhal.server.actions.admin;

import static org.junit.Assert.*;
import games.stendhal.server.actions.CommandCenter;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.maps.MockStendhalRPRuleProcessor;

import marauroa.common.game.RPAction;

import org.junit.BeforeClass;
import org.junit.Test;

import utilities.PlayerTestHelper;

public class GhostModeActionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

	@Test
	public final void testGhostmode() {
		Player hugo = PlayerTestHelper.createPlayer("hugo");
		hugo.put("adminlevel", 5000);
		
		Player bob = PlayerTestHelper.createPlayer("bob");
		bob.setKeyedSlot("!buddy", "_" + hugo.getName(), "1");

		Player jack = PlayerTestHelper.createPlayer("jack");
		
		MockStendhalRPRuleProcessor.get().addPlayer(hugo);
		MockStendhalRPRuleProcessor.get().addPlayer(bob);
		MockStendhalRPRuleProcessor.get().addPlayer(jack);
		
		RPAction action = new RPAction();

		action.put("type", "ghostmode");
		assertFalse(hugo.isInvisible());
		assertFalse(hugo.isGhost());

		CommandCenter.execute(hugo, action);

		assertTrue(hugo.isInvisible());
		assertTrue(hugo.isGhost());

		assertEquals(null, bob.get("online"));
		assertEquals("hugo", bob.get("offline"));
		
		assertEquals(null, jack.get("online"));
		assertEquals(null, jack.get("offline"));

		bob.remove("offline");
		bob.clearEvents();
		CommandCenter.execute(hugo, action);

		assertFalse(hugo.isInvisible());
		assertFalse(hugo.isGhost());
		
		assertEquals("hugo", bob.get("online"));
		assertEquals(null, bob.get("offline"));
				
		assertEquals(null, jack.get("online"));
		assertEquals(null, jack.get("offline"));
	}


}

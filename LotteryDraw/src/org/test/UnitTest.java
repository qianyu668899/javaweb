/**
 * 
 */
package org.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.lottery.control.Control;
import org.lottery.player.Player;

/**
 * @author Administrator
 *
 */
public class UnitTest {

	/**
	 * Test method for {@link org.lottery.control.Control#sell(org.lottery.player.Player)}.
	 */
	@Test
	public void testBuy() {
		Control control = new Control();
		control.setTickets(10);
		Player player = new Player("qianyu");
		player.buy(control);
		player.buy(control);
		player.buy(control);
		player.buy(control);
		player.buy(control);
		Player player1 = new Player("yjxu");
		player1.buy(control);
		player1.buy(control);
		player1.buy(control);
		player1.buy(control);
		player1.buy(control);
		player1.buy(control);
		assertEquals(" ", control.sell(player), -1);
		//fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Test method for {@link org.lottery.control.Control#sell(org.lottery.player.Player)}.
	 */
	@Test
	public void testSell() {
		Control control = new Control();
		control.setTickets(10);
		Player player = new Player("qianyu");
		player.buy(control);
		player.buy(control);
		player.buy(control);
		assertTrue(control.sell(player)>=0);
		Player player1 = new Player("yjxu");
		player1.buy(control);
		player1.buy(control);
		player1.buy(control);
		player1.buy(control);
		player1.buy(control);
		player1.buy(control);
		assertEquals(" ", control.sell(player1), -1);
	}

}

/**
 * 
 */
package org.lottery.ball;

import org.lottery.player.Player;

/**
 * @author Administrator
 *
 */
public class Ball {
	private int index;//number of the ball

	private boolean sold;//mark it is sold or still available
	private Player player;//if is sold, then it must be associated with a player 
	private double profit;//can be 0.75, 0.15, 0.10
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	public Ball()
	{
		this.index = -1;
		this.sold = false;
		this.player = null;
		this.profit = 0.0;
	}
}

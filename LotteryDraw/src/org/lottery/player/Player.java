package org.lottery.player;

import java.util.Vector;
import org.lottery.ball.Ball;
import org.lottery.control.Control;

/**
 * @author Yu Qian
 *
 */
public class Player {

	private String name;//the name of the player, this is required
	private Vector<Ball> currentBalls = new Vector<Ball>();//current balls the player bought
	private double profit;
	public Player(String name)
	{
		this.name = name;
	}
	public Player()
	{
		
	}
	/*
	 * every player can buy more than one tickets
	 * get all his profit
	 */
	public double getProfit() {
		for(int i = 0;i < this.currentBalls.size();i++){ 
			this.profit += this.currentBalls.get(i).getProfit();
		}
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vector<Ball> getCurrentBall() {
		return this.currentBalls;
	}
	public void addCurrentBall(Ball currentBall) {
		this.currentBalls.add(currentBall);
	}
	/*
	 * player can buy tickets
	 */
	public void buy(Control machine)
	{
		//this.name = name;
		int num = machine.sell(this);
		if(num==-1)
		{
			System.out.println("No tickets available");
			return;
		}
		System.out.println("You bought ball: "+num);
	}
	/*
	 * player can draw, it's actually controlled by the system
	 */
	public void draw(Control machine)
	{
		machine.draw();
	}
	/*
	 * player can see winners
	 */
	public void seeWinners(Control machine)
	{
		machine.getRecords().getWinnerBoard().printCurrentWinner();
	}
	
}

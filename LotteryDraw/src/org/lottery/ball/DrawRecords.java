/**
 * 
 */
package org.lottery.ball;

import java.util.Vector;
import org.lottery.control.Winner;
import org.lottery.control.WinnerBoard;
import org.lottery.player.Player;

/**
 * @author Administrator
 *
 */
public class DrawRecords {
	private int ticketsNum;//total tickets number, equals to number of balls 
	private int tickets;//available tickets, this will change if buyer comes in 
	private Vector<Ball> ballPool;//save all the balls available
	private WinnerBoard winnerBoard;//record the information of winners
	private Vector<Player> playerList = new Vector<Player>();//record the players of the latest draw
	private double cash;//cash we can use in the cash box
	public double getCash() {
		return cash;
	}
	public void setCash(double cash) {
		this.cash = cash;
	}
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	/*
	 * initialize the tickets and set up the balls
	 */
	public void initTickets(int tickets) {
		if(tickets<10)
		{
			System.out.println("Tickets number can not be less than 10");
			return;
		}
		this.ballPool = new Vector<Ball>(tickets);
		this.tickets = tickets;
		this.ticketsNum = tickets;
		for(int i=0; i<this.tickets; i++)
		{
			Ball ball = new Ball();
			ball.setIndex(i+1);
			this.ballPool.add(ball);
		}
	}
	public int getTicketsNum() {
		return ticketsNum;
	}
	public void setTicketsNum(int ticketsNum) {
		this.ticketsNum = ticketsNum;
	}
	public Vector<Ball> getBallPool() {
		return this.ballPool;
	}
	public void setBallPool(Vector<Ball> ballPool) {
		this.ballPool = ballPool;
	}
	public WinnerBoard getWinnerBoard() {
		return this.winnerBoard;
	}
	public void setWinnerBoard(WinnerBoard winnerBoard) {
		this.winnerBoard = winnerBoard;
	}
	public Vector<Player> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(Vector<Player> playerList) {
		this.playerList = playerList;
	}
	public void clearPlayersList()
	{
		this.playerList.clear();
	}
	/*
	 * constructors
	 */
	public DrawRecords()
	{
		this.tickets=50;
		this.cash=200.0;
		this.winnerBoard = new WinnerBoard();
		this.initTickets(this.tickets);
	}
	/*
	 * check if two players use the same name
	 * if not exist, return -1, or return the index
	 */
	public int checkPlayerName(String name)
	{
		int id = -1;
		int playerNum = this.playerList.size();
		if(playerNum==0)
		{
			System.out.println("No player so far");
			return -1;
		}
		for(int i=0; i<playerNum; i++)
		{
			if(this.playerList.get(i).getName().equals(name))
			{
				id = i;
				break;
			}
		}
		System.out.println("player number: "+id);
		return id;
	}
	/*
	 * add new player to list
	 */
	public void addPlayer(Player player)
	{
		boolean flag = false;
		for(int i=0; i<this.playerList.size(); i++)
		{
			if(this.playerList.get(i).getName()==player.getName())
			{
				flag = true;
				break;
			}
		}
		if(flag==false)
		{
			this.playerList.add(player);
		}
	}
	/*
	 * add records to history 
	 */
	public void addToHistoryWinner(Winner winner)
	{
		this.winnerBoard.addToList(winner);
	}
	/*
	 * print players list of last draw
	 */
	public void printPlayerList()
	{
		if(this.playerList.size()==0)
		{
			System.out.println("   ***No player***   ");
			return;
		}
		for(int i=0; i<this.playerList.size(); i++)
		{
			Player player = this.playerList.get(i);
			System.out.print(i+" "+player.getName()+" ball: ");
			for(int j=0; j<player.getCurrentBall().size(); j++)
			{
				System.out.print(player.getCurrentBall().get(j).getIndex()+" ");
			}
			System.out.println("");
		}
	}
	/*
	 * print ball information
	 */
	public void printBallPool()
	{
		if(this.ballPool.size()==0)
		{
			System.out.println("No ball available");
			return;
		}
		for(int i=0; i<this.ballPool.size(); i++)
		{
			System.out.println(this.ballPool.get(i).getIndex()+" "+this.ballPool.get(i).isSold());
		}
	}

}

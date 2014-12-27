/**
 * 
 */
package org.lottery.control;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import org.lottery.ball.Ball;
import org.lottery.ball.Data;
import org.lottery.ball.DrawRecords;
import org.lottery.ball.RandomFunction;
import org.lottery.player.Player;

/**
 * @author Yu Qian
 *
 */
public class Control {
	private DrawRecords records;//informations are saved in this object
	
	public DrawRecords getRecords() {
		return records;
	}

	public void setRecords(DrawRecords records) {
		this.records = records;
	}
	//initialize tickets information, along with balls available
	public void setTickets(int tickets) {
		this.records.initTickets(tickets);
	}
	public void setTickets( ) {
		this.records.setTickets(this.records.getTickets());
	}
	
	public Control()
	{
		this.records = new DrawRecords();
	}
	/*
	 * draw, get the first 3 winner ball numbers
	 * after every draw, information should be cleared
	 * every ball never belongs to any player after every draw
	 * clear the players list
	 * history information are still in WinnerBoard object
	 */
	public void draw()
	{
		//generate new winners using random function
		/*
		 * in order to generate 3 different ball index, use HashSet
		 */
		HashSet<Integer> threeBalls = RandomFunction.getWinnerBalls(this.records.getBallPool().size());
		int i=0;
		for(Iterator<Integer> it=threeBalls.iterator();it.hasNext();)
		{
			int index = it.next();
			//System.out.println("win ball: "+index);
			if(i==0)
			{
				this.records.getBallPool().get(index).setProfit(Data.FIRST_LEVEL*Data.RATIO*this.records.getCash());
				Ball first = this.records.getBallPool().get(index);
				//
				if(first.getPlayer()==null)
				{
					//System.out.println("winner:"+this.records.getWinnerBoard().getCurrentWinner());
					//Ball ball= new Ball();
					first.setPlayer(new Player("No player"));
					this.records.getWinnerBoard().getCurrentWinner().setFirstPlayer(first);
				}else
				{
					//System.out.println("winner1:"+first.getIndex());
					this.records.getWinnerBoard().getCurrentWinner().setFirstPlayer(first);
				}
			}
			else if(i==1)
			{
				this.records.getBallPool().get(index).setProfit(Data.SECOND_LEVEL*Data.RATIO*this.records.getCash());
				Ball second = this.records.getBallPool().get(index);
				if(second.getPlayer()==null)
				{
					//Ball ball= new Ball();
					second.setPlayer(new Player("No player"));
					this.records.getWinnerBoard().getCurrentWinner().setSecondPlayer(second);
				}else
				{
					this.records.getWinnerBoard().getCurrentWinner().setSecondPlayer(second);
				}
			}
			else if(i==2)
			{
				this.records.getBallPool().get(index).setProfit(Data.THIRD_LEVEL*Data.RATIO*this.records.getCash());
				Ball third = this.records.getBallPool().get(index);
				if(third.getPlayer()==null)
				{
					//Ball ball= new Ball();
					third.setPlayer(new Player("No player"));
					this.records.getWinnerBoard().getCurrentWinner().setThirdPlayer(third);
				}else
				{
					this.records.getWinnerBoard().getCurrentWinner().setThirdPlayer(third);
				}
			}
			
			i++;
		}
		/*
		 * add to history records
		 */
		Winner winner = new Winner();
		winner.setFirstPlayer(this.records.getWinnerBoard().getCurrentWinner().getFirstPlayer());
		winner.setSecondPlayer(this.records.getWinnerBoard().getCurrentWinner().getSecondPlayer());
		winner.setThirdPlayer(this.records.getWinnerBoard().getCurrentWinner().getThirdPlayer());
		this.records.addToHistoryWinner(winner);
		//clear information after every draw
		this.setTickets(this.getRecords().getTicketsNum());
		this.records.clearPlayersList();
		//System.out.println("winner:"+this.records.getWinnerBoard().getCurrentWinner().getFirstPlayer().getIndex());
	}
	/*
	 * control system can sell a ticket to player
	 * synchronized must be used
	 */
	public synchronized int sell(Player player)
	{
		//check if there are available tickets
		if(this.records.getTickets()>0)
		{
			//System.out.println("remain tickets: "+this.records.getTickets());
			
			//from ballPool.capacity()-tickets+1 to ballPool.capacity()
			/*
			 * random function to generate a ball index for buyer
			 */
			int startIndex = this.records.getBallPool().size() - this.records.getTickets();
			int ticketNumber = RandomFunction.getRandomId(0, this.records.getTickets())+startIndex;
			//System.out.println("ball numbers: "+this.records.getBallPool().size());
			//System.out.println("ball index: "+ticketNumber);
			//ball number is ticketNumber+1
			/*
			 * bind ball and player to each other
			 */
			this.records.getBallPool().get(ticketNumber).setSold(true);
			player.addCurrentBall(this.records.getBallPool().get(ticketNumber));
			this.records.getBallPool().get(ticketNumber).setPlayer(player);
			this.records.addPlayer(player);
			int ballNum = this.records.getBallPool().get(ticketNumber).getIndex();
			
			//swap with ballPool.()-tickets+1
			/*
			 * actual ball number is an attribute in Ball class
			 * we use index in the ballpool to generate random index
			 */
			Ball temp;
			temp = this.records.getBallPool().get(this.records.getBallPool().size()-this.records.getTickets());
			this.records.getBallPool().set(this.records.getBallPool().size()-this.records.getTickets(), this.records.getBallPool().get(ticketNumber));
			this.records.getBallPool().set(ticketNumber, temp);
			//System.out.println("ball numbers: "+this.records.getBallPool().size());
			this.records.setTickets(this.records.getTickets()-1);
			return ballNum;
		}
		else
		{
			System.out.println("Sorry, tickets are all sold out!");
			return -1;
		}
		
	}
	/*
	 * check if input valid
	 * check if name exists already
	 */
	public Player getPlayerName()
	{
		String name="";
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your name:");
		name=scan.next();
		while(name=="")
		{
			name = scan.next();
			System.out.println("Please enter your name:");
		}
		int id = this.records.checkPlayerName(name);
		while( id != -1)
		{
			System.out.println("Your name "+name+" is in the list.");
			return this.records.getPlayerList().get(id);
		}
		return new Player(name);
	}

}

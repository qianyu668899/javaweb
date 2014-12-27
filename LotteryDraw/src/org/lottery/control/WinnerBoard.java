/**
 * 
 */
package org.lottery.control;

import java.util.Vector;
import org.lottery.ball.Data;

/**
 * @author Yu Qian
 *
 */
public class WinnerBoard {
	private Winner currentWinner;// winner of the latest draw
	private Vector<Winner> history;//history records, we can limit the size
	int boardSize;//limit the board to record only 20 draw results
	
	public WinnerBoard()
	{
		this.currentWinner = new Winner();
		this.history = new Vector<Winner>(100);
	}
	public Winner getCurrentWinner() {
		return this.currentWinner;
	}
	public void setCurrentWinner(Winner currentWinner) {
		this.currentWinner = currentWinner;
	}
	public Vector<Winner> getHistory() {
		return history;
	}
	public void setHistory(Vector<Winner> history) {
		this.history = history;
	}
	public int getBoardSize() {
		return boardSize;
	}
	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	
	public void printCurrentWinner( ) {
		if(this.currentWinner.getFirstPlayer()==null)
		{
			System.out.println("No draw happened");
			return;
		}
		String res1 = "1st ball: number "+ currentWinner.getFirstPlayer().getIndex()
				+" >"+currentWinner.getFirstPlayer().getPlayer().getName()+" >"+currentWinner.getFirstPlayer().getProfit();
		
		String res2 = "2nd ball: number "+ currentWinner.getSecondPlayer().getIndex()
				+" >"+currentWinner.getSecondPlayer().getPlayer().getName()+" >"+currentWinner.getSecondPlayer().getProfit();
		
		String res3 = "3rd ball: number "+ currentWinner.getThirdPlayer().getIndex()
				+" >"+currentWinner.getThirdPlayer().getPlayer().getName()+" >"+currentWinner.getThirdPlayer().getProfit();
		
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
	public void printHistoryWinner()
	{
		if(this.history.size()==0)
		{
			System.out.println("No history records");
			return;
		}
		int size = this.history.size()>Data.BOARD_SIZE?Data.BOARD_SIZE:this.history.size();
		for(int i=0; i<size; i++)
		{
			System.out.println("*********************");
			printCurrentWinner(this.history.get(i)); 
		}
	}
	/*
	 * print the winner of the latest draw
	 */
	public void printCurrentWinner(Winner winner) {
		if(winner.getFirstPlayer()==null)
		{
			System.out.println("No draw happened");
			return;
		}
		String res1 = "1st ball: number "+ winner.getFirstPlayer().getIndex()
				+" >"+winner.getFirstPlayer().getPlayer().getName()+" >"+winner.getFirstPlayer().getProfit();
		
		String res2 = "2nd ball: number "+ winner.getSecondPlayer().getIndex()
				+" >"+winner.getSecondPlayer().getPlayer().getName()+" >"+winner.getSecondPlayer().getProfit();
		
		String res3 = "3rd ball: number "+ winner.getThirdPlayer().getIndex()
				+" >"+winner.getThirdPlayer().getPlayer().getName()+" >"+winner.getThirdPlayer().getProfit();
		
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
	/*
	 * 
	 */
	public void addToList()
	{
		if(this.currentWinner.getFirstPlayer()!=null)
		{
			Winner winner = new Winner();
			winner = this.currentWinner;
			this.history.add(winner);
		}
		//this.currentWinner = null;
	}
	/*
	 * add winner to hisory records
	 */
	public void addToList(Winner winner)
	{
		if(winner.getFirstPlayer()!=null && this.history.size()<=Data.BOARD_SIZE)
		{
			this.history.add(winner);
		}
	}
}

package org.test;

import org.lottery.control.Control;
import org.lottery.player.Player;

public class SimpleTest {

	public static void test()
	{
		Control control = new Control();
		control.setTickets(10);
		System.out.println("===Tickets number is set to: "+control.getRecords().getTicketsNum());
		Player player = new Player("qianyu");
		System.out.println("=player " +player.getName()+ " start to buy tickets");
		player.buy(control);
		player.buy(control);
		player.buy(control);
		player.buy(control);
		player.buy(control);
		System.out.println("=player " +player.getName()+ " bought "+player.getCurrentBall().size()+" tickets");
		Player player1 = new Player("yjxu");
		System.out.println("=player " +player1.getName()+ " start to buy tickets");
		player1.buy(control);
		player1.buy(control);
		player1.buy(control);
		player1.buy(control);
		player1.buy(control);
		player1.buy(control);
		System.out.println("=player " +player1.getName()+ " bought "+player1.getCurrentBall().size()+" tickets");
		//control.getRecords().printBallPool();
		System.out.println("===Start draw...");
		control.draw();
		System.out.println("===Show winners...");
		control.getRecords().getWinnerBoard().printCurrentWinner();
		System.out.println("===After every draw, balls are available again");
		control.getRecords().printPlayerList();
		System.out.println("===Print draw history...");
		control.getRecords().getWinnerBoard().printHistoryWinner();
	}

}

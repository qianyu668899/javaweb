/**
 * 
 */
package org.main;

import java.util.Scanner;

import org.lottery.ball.Data;
import org.lottery.control.Control;
import org.lottery.player.Player;
import org.test.SimpleTest;

/**
 * @author Yu Qian
 *
 */
public class Run {

	/**
	 * @param args
	 */
	public static void panel()
	{
		String mainBoard="====================================\n"+
	                     "                WELCOME             \n"+
	                     "  (Please enter number to continue) \n"+
	                     " 1. Buy      2. Draw     3. Winners \n"+
	                     " 4. History winners  5. Players List\n"+
	                     " 6. Tickets 7. Set Cash\n"+
	                     " 0. Quit                            \n"+
	                     "====================================\n";
		
		Control control = new Control();
		control.setTickets(10);
		while(true)
		{
			System.out.println(mainBoard);
			Scanner choice = new Scanner(System.in);
			int num = choice.nextInt();
			if(num<0 || num>7)
			{
				num = -1;
			}
			switch(num)
			{
			case 1:
				Player player = control.getPlayerName();
				player.buy(control);
				break;
			case 2:
				control.draw();
				break;
			case 3:
				control.getRecords().getWinnerBoard().printCurrentWinner();
				break;
			case 4:
				control.getRecords().getWinnerBoard().printHistoryWinner();
				break;
			case 5:
				control.getRecords().printPlayerList();
				break;
			case 6:
				System.out.println(control.getRecords().getTickets()+" tickets available");
				break;
			case 7:
				System.out.println("Enter a valid number:");
				double cash = new Scanner(System.in).nextDouble();
				if(Data.CASH_LIMIT-cash>=0)
				{
					control.getRecords().setCash(cash);
					System.out.println("Cash is "+control.getRecords().getCash()+" now!");
				}else
				{
					System.out.println("Set cash failed");
				}
				break;
			case 0:
				return;
			case -1:System.out.println("Invalid Command");break;
			default:break;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//panel();
		SimpleTest.test();
		
	}

}

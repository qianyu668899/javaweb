/**
 * 
 */
package org.lottery.ball;

import java.util.HashSet;
import java.util.Random;

/**
 * @author Yu Qian
 * random functions
 */
public class RandomFunction {
	//private int start;
	//private int end;
	public RandomFunction()
	{
		//this.start = start;
		//this.end = end;
	}
	/*
	 * generate a random number between start and end
	 */
	public static int getRandomId(int start, int end)
	{
		Random random = new Random();
		int id = random.nextInt(end - start)+start;
		return id;
	}
	/*
	 * generate three different random numbers in [0, size-1]
	 */
	public static HashSet<Integer> getWinnerBalls(int size)
	{
		Random random = new Random();
		HashSet<Integer> hs = new HashSet<Integer>();
        while (hs.size() < 3) {
            hs.add(random.nextInt(size));
        }
        return hs;
	}
}

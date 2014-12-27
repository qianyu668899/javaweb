/**
 * 
 */
package org.lottery.control;

import org.lottery.ball.Ball;


/**
 * @author Yu Qian
 * use this class to store winners of every draw
 *
 */
public class Winner {
	private Ball FirstPlayer;
	private Ball SecondPlayer;
	private Ball ThirdPlayer;
	public Ball getFirstPlayer() {
		return FirstPlayer;
	}
	public void setFirstPlayer(Ball firstPlayer) {
		FirstPlayer = firstPlayer;
	}
	public Ball getSecondPlayer() {
		return SecondPlayer;
	}
	public void setSecondPlayer(Ball secondPlayer) {
		SecondPlayer = secondPlayer;
	}
	public Ball getThirdPlayer() {
		return ThirdPlayer;
	}
	public void setThirdPlayer(Ball thirdPlayer) {
		ThirdPlayer = thirdPlayer;
	}
	

}

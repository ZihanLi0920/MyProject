package model;

import java.awt.Graphics;

import model.balls.Ball;

/**
 * @author 
 * the abstract interface that the Ball will use to paint.
 */
public interface IPaintStrategy {
	/**
	 * @param g The graphics context to draw upon.
	 * @param host The host ball.
	 * the abstract method that the Ball use to paint
	 */
	public void paint(Graphics g, Ball host);

	/**
	 * @param host The ball to initialize.
	 * Initializes the given ball.
	 */
	public void init(Ball host);

}

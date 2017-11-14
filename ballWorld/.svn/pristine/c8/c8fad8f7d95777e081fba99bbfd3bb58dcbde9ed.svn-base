package model.strategy;

import java.awt.Point;

import model.IUpdateStrategy;
import model.balls.Ball;

import util.IDispatcher;

/**
 * @author GPS
 * The strategy to make the ball move in S path
 */
public class sPathStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {
	private int i = 1;
	boolean turnLeft = true;

	/** 
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, Dispatcher)
	 * Change the direction of velocity to make the ball move in S path
	 */
	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		if (++i % 3 == 0)
			turnLeft = (turnLeft ? false : true);
		double theta = 0.7;
		theta = (turnLeft ? theta : -theta);
		Point oldVel = ball.getVel();
		int velX, velY;
		velX = (int) Math.round(oldVel.getX() * Math.cos(theta) - oldVel.getY() * Math.sin(theta));
		velY = (int) Math.round(oldVel.getY() * Math.cos(theta) + oldVel.getX() * Math.sin(theta));
		ball.setVel(new Point(velX, velY));

	}

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#init(model.balls.Ball)
	 * do nothing
	 */
	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub

	}
}

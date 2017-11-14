package model.strategy;

import java.awt.Point;

import model.IUpdateStrategy;
import model.balls.Ball;
import util.IDispatcher;

/**
 * @author zihanli
 * The strategy to make the ball move with a random speed
 */
public class SpeedingStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {
	/**
	 * The maximum speed that a SpeedingStrategy will increase a ball's speed to
	 */
	private final int MAX_SPEED = 30;

	/**
	 * The minimum speed that a SpeedingStrategy will increase a ball's speed to
	 */
	private final int MIN_SPEED = 5;

	/**
	 * If the ball is speeding up or slowing down
	 */
	private boolean speedingUp = true;

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, Dispatcher)
	 * Changes the velocity by a random amount
	 */
	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		// TODO Auto-generated method stub
		// Speed up or not
		int acceleration = speedingUp ? 1 : -1;

		// Save for convenience
		int oldvelX = ball.getVel().x;
		int oldvelY = ball.getVel().y;

		// Change velocities
		int velX = (oldvelX < 0) ? oldvelX - acceleration : oldvelX + acceleration;
		int velY = (oldvelY < 0) ? oldvelY - acceleration : oldvelY + acceleration;

		// Stop speeding up eventually
		if (Math.abs(velX) > MAX_SPEED && Math.abs(velY) > MAX_SPEED) {
			speedingUp = false;
		} else if (Math.abs(velX) < MIN_SPEED && Math.abs(velY) < MIN_SPEED) {
			speedingUp = true;
		}
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

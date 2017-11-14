package model.strategy;

import java.awt.Point;

import model.IUpdateStrategy;
import model.balls.Ball;
import util.IDispatcher;
import util.Randomizer;

/**
 * @author zihanli
 * The strategy to make the ball move in a curve path
 */
public class CurveStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {
	private double theta = Randomizer.Singleton.randomDouble(0, 1);

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, Dispatcher)
	 * Change the direction of velocity to make the ball move in a curve path
	 */
	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
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

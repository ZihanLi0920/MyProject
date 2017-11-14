package model.strategy;

import model.IUpdateStrategy;
import model.balls.Ball;
import util.IDispatcher;
import util.Randomizer;

/**
 * @author zihanli
 * The strategy to change the ball' color
 */
public class ColorStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, Dispatcher)
	 * change the color of the ball to a random color
	 */
	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		// TODO Auto-generated method stub
		ball.setColor(Randomizer.Singleton.randomColor());
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

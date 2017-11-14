package model.strategy;

import model.IUpdateStrategy;
import model.balls.*;
import util.IDispatcher;

/**
 * @author zihanli
 * The strategy to make the ball move in a straight path
 */
public class StraightStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {
	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, Dispatcher)
	 * Do nothing so that the ball can move in straight path
	 */
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {

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

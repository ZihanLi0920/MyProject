package model.strategy;

import model.IUpdateStrategy;
import model.balls.Ball;
import util.IDispatcher;

/**
 * @author zihanli
 * the class used to create strategy that can change its method pf updating
 */
public class SwitchStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	private IUpdateStrategy<TDispMsg> tempStrategy = new StraightStrategy<TDispMsg>();

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, Dispatcher)
	 * using temp strategy to update the ball
	 */
	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		// TODO Auto-generated method stub
		tempStrategy.updateState(ball, null);

	}

	/**
	 * @param newStrategy
	 * set  tempStrategy to a new one
	 */
	public void setStrategy(IUpdateStrategy<TDispMsg> newStrategy) {
		tempStrategy = newStrategy;
		//init(context);
	}

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#init(model.balls.Ball)
	 * don't care now
	 */
	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub
		//tempStrategy.init(context);

	}

}

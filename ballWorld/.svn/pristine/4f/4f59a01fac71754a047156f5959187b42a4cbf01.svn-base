package model.strategy;

import model.IUpdateStrategy;
import model.balls.Ball;
import util.IDispatcher;

/**
 * @author zihanli
 * Composition design pattern
 */
public class MultiStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {
	private IUpdateStrategy<TDispMsg> strategy1, strategy2;

	/**
	 * @param s1
	 * @param s2
	 * initialize the strategy and strategy2
	 */
	public MultiStrategy(IUpdateStrategy<TDispMsg> s1, IUpdateStrategy<TDispMsg> s2) {
		strategy1 = s1;
		strategy2 = s2;
	}

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, Dispatcher)
	 * call the method of the two strategy to update
	 */
	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		// TODO Auto-generated method stub
		strategy1.updateState(ball, dispatcher);
		strategy2.updateState(ball, dispatcher);

	}

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#init(model.balls.Ball)
	 * call the method of the two strategy to init
	 */
	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub
		strategy1.init(context);
		strategy2.init(context);

	}

}

package model.strategy;

import model.IBallCmd;
import model.IInteractStrategy;
import model.balls.Ball;
import util.IDispatcher;

/**
 * @author zihanli
 * Composition design pattern
 */
public class MultiInteractStrategy implements IInteractStrategy {

	private IInteractStrategy strategy1, strategy2;

	MultiInteractStrategy(IInteractStrategy iInteractStrategy2, IInteractStrategy iInteractStrategy) {
		strategy1 = iInteractStrategy2;
		strategy2 = iInteractStrategy;
	}

	/** (non-Javadoc)
	 * @see model.IInteractStrategy#interact(model.balls.Ball, model.balls.Ball, util.Dispatcher)
	 * call the interact method of both strategy
	 */
	@Override
	public void interact(Ball context, Ball target, IDispatcher<IBallCmd> disp) {
		// TODO Auto-generated method stub
		strategy1.interact(context, target, disp);
		strategy2.interact(context, target, disp);

	}

}

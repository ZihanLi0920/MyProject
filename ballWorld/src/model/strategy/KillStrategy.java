package model.strategy;

import model.IUpdateStrategy;
import model.IBallCmd;
import model.IInteractStrategy;
import model.balls.Ball;
import util.IDispatcher;

/**
 * @author zihanli
 * deletes other when it collides.
 */
public class KillStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, util.Dispatcher)
	 * Do nothing
	 */
	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		// TODO Auto-generated method stub

	}

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#init(model.balls.Ball)
	 * Set the ball's interact strategy of which the interact method is to delete the target from the dispatcher.
	 */
	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub
		context.setInteractStrategy(new MultiInteractStrategy(context.getInteractStrategy(), new IInteractStrategy() {
			

			@Override
			public void interact(Ball context, Ball target, IDispatcher<IBallCmd> disp) {
				// TODO Auto-generated method stub
				disp.deleteObserver(target);
			}

		}));

	}

}

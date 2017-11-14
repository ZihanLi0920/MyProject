package model.strategy;

import model.IBallCmd;
import model.IInteractStrategy;
import model.IUpdateStrategy;
import model.balls.Ball;
import util.IDispatcher;

/**
 * @author zihanli
 * kills whomever the ball collides with and increases its area by the killed ball's area.
 */
public class EatStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, util.Dispatcher)
	 * do nothing
	 */
	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		// TODO Auto-generated method stub

	}

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#init(model.balls.Ball)
	 * Set the ball's interact strategy of which the interact method is to delete the target from the dispatcher and add it's radius by the target's radius.
	 */
	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub
		context.setInteractStrategy(new MultiInteractStrategy(context.getInteractStrategy(), new IInteractStrategy() {
			

			@Override
			public void interact(Ball context, Ball target, IDispatcher<IBallCmd> disp) {
				// TODO Auto-generated method stub
				context.setRadius((int) (context.getRadius() + target.getRadius()));
				disp.deleteObserver(target);
			}

		}));

	}

}

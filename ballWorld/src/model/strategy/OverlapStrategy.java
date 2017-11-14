package model.strategy;

import model.IBallCmd;
import model.IUpdateStrategy;
import model.balls.Ball;
import util.IDispatcher;

/**
 * @author zihanli
 * Detects if the ball overlaps with any other balls.
 */
public class OverlapStrategy<TDispMsg> implements IUpdateStrategy<IBallCmd> {

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, util.Dispatcher)
	 * If it is overlapped with another ball, call the interactWith method of that ball.
	 */
	@Override
	public void updateState(Ball context, IDispatcher<IBallCmd> dispatcher) {
		// TODO Auto-generated method stub
		dispatcher.dispatch(new IBallCmd() {

			@Override
			public void apply(Ball other, IDispatcher<IBallCmd> disp) {

				if (context != other) {
					if ((context.getRadius() + other.getRadius()) > context.getLocation()
							.distance(other.getLocation())) {
						other.interactWith(context, dispatcher);
					}
				}
			}

		});

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

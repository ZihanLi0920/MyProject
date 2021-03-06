package model.strategy;

import java.awt.Point;

import model.IBallCmd;
import model.IUpdateStrategy;
import model.balls.Ball;
import util.IDispatcher;

/**
 * @author zihanli
 * adds an identical ball whenever it overlaps with another ball.
 */
public class SpawnStrategy<TDispMsg> implements IUpdateStrategy<IBallCmd> {

	private int count = 0; // tick counter that counts out the delay before another ball can be spawned.
	private int delay = 100; // tick delay which increases at each spawn to keep total spawn rate from exponentially exploding.

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, util.Dispatcher)
	 * If it's time to add a new ball, sent a command to see if there is a ball overlaps with it, if so, add a new ball that is same as itself.
	 */
	@Override
	public void updateState(final Ball context, IDispatcher<IBallCmd> dispatcher) {

		if (delay < count++) {
			dispatcher.dispatch(new IBallCmd() {

				@Override
				public void apply(Ball other, IDispatcher<IBallCmd> disp) {

					if (count != 0 && context != other) {
						if ((context.getRadius() + other.getRadius()) > context.getLocation()
								.distance(other.getLocation())) {
							disp.addObserver(new Ball(new Point(context.getLocation()), (int) context.getRadius(),
									new Point(-context.getVel().x + 1, -context.getVel().y + 1), context.getColor(),
									context.getCanvas(), new SpawnStrategy<IBallCmd>(), context.getPaintStrategy()));
							count = 0;
							delay *= 5;
						}
					}
				}

			});
		}
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

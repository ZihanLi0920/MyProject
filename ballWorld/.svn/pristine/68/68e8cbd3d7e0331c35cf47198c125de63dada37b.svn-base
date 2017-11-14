package model.strategy;

import java.awt.Color;

import model.IBallCmd;
import model.IUpdateStrategy;
import model.balls.Ball;
import util.IDispatcher;
import util.Randomizer;

/**
 * @author zihanli
 * a black-colored ball that will turn any other ball it overlaps with into an Infect ball for its first 50 updates.   
 * After that, the ball becomes a normal Straight ball.
 *
 */
public class InfectStrategy<TDispMsg> implements IUpdateStrategy<IBallCmd> {

	private int count = 0;

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, util.Dispatcher)
	 * if count is more than 50, change the ball's update strategy to StraightStrategy
	 * else send command to see if there is a ball overlap with it, if so change the target's update strategy to InfectStrategy
	 */
	@Override
	public void updateState(Ball context, IDispatcher<IBallCmd> dispatcher) {
		// TODO Auto-generated method stub

		if (count++ < 50) {
			context.setColor(Color.BLACK);
			dispatcher.dispatch(new IBallCmd() {


				@Override
				public void apply(Ball other, IDispatcher<IBallCmd> o) {
					// TODO Auto-generated method stub
					if (context != other) {
						if ((context.getRadius() + other.getRadius()) > context.getLocation()
								.distance(other.getLocation())) {
							other.setUpdateStrategy(new InfectStrategy<IBallCmd>());
						}
					}
				}

			});
		} else {
			context.setColor(Randomizer.Singleton.randomColor());
			context.setUpdateStrategy(new StraightStrategy<IBallCmd>());
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

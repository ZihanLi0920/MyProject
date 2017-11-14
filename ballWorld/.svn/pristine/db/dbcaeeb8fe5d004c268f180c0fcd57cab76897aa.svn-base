package model.strategy;

import java.awt.Color;

import model.IBallCmd;

import model.IUpdateStrategy;
import model.balls.Ball;
import util.IDispatcher;

/**
 * @author zihanli
 * flashes red color when overlaps with another ball.
 */
public class HitFlashStrategy<TDispMsg>implements IUpdateStrategy<IBallCmd> {

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, util.Dispatcher)
	 * Send a command out to all the other balls to see if anyone has overlapped with the context ball. If so, flash red.
	 */
	@Override
	public void updateState(Ball context, IDispatcher<IBallCmd> dispatcher) {
		// TODO Auto-generated method stub
		context.setColor(Color.BLACK);
		//dispatcher.dispatch(new IBallCmd() {});
		dispatcher.dispatch(new IBallCmd() {
			@Override
			public void apply(Ball other, IDispatcher<IBallCmd> disp) {

				if (context != other) {
					if ((context.getRadius() + other.getRadius()) > context.getLocation()
							.distance(other.getLocation())) {
						context.setColor(Color.red);
					}
				}
			}
		}

		);

	}

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#init(model.balls.Ball)
	 * do nothing
	 */
	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub;

	}



}

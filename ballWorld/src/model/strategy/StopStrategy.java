package model.strategy;

import java.awt.Point;

import model.IBallCmd;
import model.IInteractStrategy;
import model.IUpdateStrategy;
import model.balls.Ball;
import util.IDispatcher;

/**
 * @author zihanli
 * a strategy that only implements the interaction
 *
 * @param <TDispMsg>
 */
public class StopStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, util.IDispatcher)
	 * do nothing
	 */
	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		// TODO Auto-generated method stub
		
	}

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#init(model.balls.Ball)
	 * when itis interact with other ball, it will stop
	 */
	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub
		context.setInteractStrategy(new MultiInteractStrategy(context.getInteractStrategy(), new IInteractStrategy() {
			

			@Override
			public void interact(Ball context, Ball target, IDispatcher<IBallCmd> disp) {
				// TODO Auto-generated method stub
				context.setVel(new Point(0,0));
				
			}

		}));
	}

	
}

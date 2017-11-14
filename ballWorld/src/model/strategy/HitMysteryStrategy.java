package model.strategy;

import model.IBallCmd;
import model.IInteractStrategy;
import model.IUpdateStrategy;
import model.balls.Ball;
import util.*;

/**
 */

public class HitMysteryStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {
	
	/**
	 * The updateState method will cause the attribute changing to take place 
	 * when the ball comes into contact with another.
	 */

	@Override
	public void updateState(Ball context, IDispatcher<TDispMsg> dispatcher) {
	}
	
	/**
	 * The interact method will cause the attribute changing to take place 
	 */
	
	@Override
	public void init(Ball context) {
		
		context.setInteractStrategy(new MultiInteractStrategy(context.getInteractStrategy(), new IInteractStrategy() {
			@Override
			public void interact(Ball context, Ball target, IDispatcher<IBallCmd> disp) {
				context.setColor(Randomizer.Singleton.randomColor());
				context.setRadius(Randomizer.Singleton.randomInt(10, 40));
			}

		}));

	}

}

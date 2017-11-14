package model.strategy;

import java.awt.*;
import model.IBallCmd;
import model.IUpdateStrategy;
import model.balls.Ball;

import util.IDispatcher;
import util.Randomizer;

/**
 * The PartyStrategy class will have a ball that "parties" by rapidly changing 
 * color and velocity. After a while, the ball gets tired and its color becomes
 * constant and velocity is constant and quite low. However, when a party ball
 * touches another one, it starts partying again.
 */

public class PartyStrategy<TDispMsg> implements IUpdateStrategy<IBallCmd> {
	
	/**
	 * The counter for the partying.
	 */
	
	private int count = 0;
	
	/**
	 * The update method for the ball, it will be in party mode for 50 ticks and
	 * then will exit party mode until a friend comes to reinvigorate it.
	 */

	public void updateState(Ball context, IDispatcher<IBallCmd> dispatcher) {
		
		context.setVel(new Point(Randomizer.Singleton.randomInt(-10, 10),
				Randomizer.Singleton.randomInt(-10, 10)));
		
		if (count++ < 50) {
			
			context.setColor(Randomizer.Singleton.randomColor());
			dispatcher.dispatch(new IBallCmd() {

				@Override
				public void apply(Ball other, IDispatcher<IBallCmd> disp) {

					if (context != other) {
						
						if ((context.getRadius() + other.getRadius()) > context.getLocation()
								.distance(other.getLocation())) {
							other.setUpdateStrategy(new PartyStrategy<IBallCmd>());
						}
						
					}
					
				}

			});
			
		} else {
			
			context.setVel(new Point(Randomizer.Singleton.randomInt(-2, 2),
					Randomizer.Singleton.randomInt(-2, 2)));
			context.setColor(Randomizer.Singleton.randomColor());
			context.setUpdateStrategy(new StraightStrategy<IBallCmd>());
			
		}
		
	}
	
	/**
	 * The init method is not utilized here.
	 */
	
	public void init(Ball context) {
		
		//
		
	}

}

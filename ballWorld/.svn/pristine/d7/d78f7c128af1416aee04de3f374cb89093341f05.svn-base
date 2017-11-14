package model.strategy;


import model.IBallCmd;
import model.IUpdateStrategy;
import model.balls.Ball;
import util.IDispatcher;
import util.Randomizer;
/**
 * 
 * @author zihanli
 * to detect if there is any ball that has the similar radius
 *
 */
public class SimilarRadiusStrategy<TDispMsg> implements IUpdateStrategy<IBallCmd> {

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, util.Dispatcher)
	 * to detect if there is ball that has the similar radius
	 */
	@Override
	public void updateState(Ball ball, IDispatcher<IBallCmd> dispatcher) {
		// TODO Auto-generated method stub
		dispatcher.dispatch(new IBallCmd() {

			@Override
			public void apply(Ball other, IDispatcher<IBallCmd> disp) {
				if(ball!=other&&Math.abs(ball.getRadius()-other.getRadius())<1)
				{
					ball.interactWith(other, disp);
					other.interactWith(ball, disp);
					ball.setRadius((int)Randomizer.Singleton.randomInt(5, 20));
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

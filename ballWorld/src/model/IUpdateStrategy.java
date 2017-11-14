package model;

import model.balls.*;
import util.IDispatcher;

/**
 * @author zihanli
 * the interface which is used to change a ball's state
 */
public interface IUpdateStrategy<TDispMsg> {
	/**
	 * @param ball
	 * it's a abstract method to update the state of a ball
	 * @param dispatcher TODO
	 */
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher);

	/**
	 * @param context
	 * set the ball's interact strategy
	 */
	public void init(Ball context);
}

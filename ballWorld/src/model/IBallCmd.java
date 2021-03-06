package model;

import model.balls.Ball;
import util.IDispatcher;

/**
 * @author zihanli
 * Interface that represents commands sent through the dispatcher to process the balls
 */
public interface IBallCmd {
	/**
	 * The method run by the ball's update method which is called when the ball is updated by the dispatcher.
	 * @param context The ball that is calling this method.   The context under which the command is to be run.
	 * @param o The Dispatcher that sent the command out.
	 */
	public abstract void apply(Ball context, IDispatcher<IBallCmd> o);
}

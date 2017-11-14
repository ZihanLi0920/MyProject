package model;

/**
 * @author zihanli
 * the interface to make a strategy
 */
public interface IStrategyFac<TDispMsg> {

	/**
	 * @return
	 * abstract method to make a strategy
	 */
	public IUpdateStrategy<TDispMsg> make();
}

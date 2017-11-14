package model.paint;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.balls.Ball;

/**
 * @author zihanli
 * Abstract class that provides default behavior for subclasses 
 * that will decorate another IPaintStrategy to add functionality to that strategy.
 */
public abstract class ADecoratorPaintStrategy extends APaintStrategy {

	/**The "decoree" paint strategy whose methods are being augmented by this decorator paint strategy.*/
	private APaintStrategy strategy;

	/**
	 * @param _at The AffineTransform to use
	 * @param _strategy The paint strategy that is to be decorated
	 * Constructor that takes the decoree paint strategy
	 */
	public ADecoratorPaintStrategy(AffineTransform _at, APaintStrategy _strategy) {
		super(_at);
		// TODO Auto-generated constructor stub
		strategy = _strategy;
	}

	/** (non-Javadoc)
	 * Default behavior is to simply delegate to the decoree's init method
	 * @see model.IPaintStrategy#init(model.balls.Ball)
	 */
	@Override
	public void init(Ball host) {
		// TODO Auto-generated method stub
		strategy.init(host);

	}

	/**
	 * @return the decoree
	 */
	public APaintStrategy getStrategy() {
		return strategy;
	}

	/** (non-Javadoc)
	 * abstract paintXfrm method
	 * @see model.paint.APaintStrategy#paintXfrm(java.awt.Graphics, model.balls.Ball, java.awt.geom.AffineTransform)
	 */
	@Override
	public abstract void paintXfrm(Graphics g, Ball host, AffineTransform at);

}

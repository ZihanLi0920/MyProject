package model.paint;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.balls.Ball;

/**
 * @author zihanli
 * Paint strategy that use multiple strategies
 */
public class MultiPaintStrategy extends APaintStrategy {

	private APaintStrategy[] psts;

	/**
	 * @param _at
	 * @param aPaintStrategies
	 * the constructor with Variable Input Argument Lists
	 */
	public MultiPaintStrategy(AffineTransform _at, APaintStrategy... aPaintStrategies) {
		super(_at);
		// TODO Auto-generated constructor stub
		psts = aPaintStrategies;
	}

	/** (non-Javadoc)
	 * @see model.IPaintStrategy#init(model.balls.Ball)
	 * do all the strategy's init
	 */
	@Override
	public void init(Ball host) {
		for (int i = 0; i < psts.length; i++) {
			psts[i].init(host);
		}
	}

	/** (non-Javadoc)
	 * tell the strategy to paint with the at of this class
	 * @see model.paint.APaintStrategy#paintXfrm(java.awt.Graphics, model.balls.Ball, java.awt.geom.AffineTransform)
	 */
	@Override
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		// TODO Auto-generated method stub
		for (int i = 0; i < psts.length; i++) {
			psts[i].paintXfrm(g, host, at);
		}

	}

}

package model.paint.strategy;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.balls.Ball;
import model.paint.MultiPaintStrategy;

/**
 * @author zihanli
 * Subclass of MultiPaintStrategy that uses a Fish1PaintStrategy
 *  and an EyePaintStrategy to paint a swimming fish shape that has an eye.
 */
public class NiceFishPaintStrategy extends MultiPaintStrategy {

	/**
	 * No-parameter constructor that instantiates the AffineTransform for internal use.
	 */
	public NiceFishPaintStrategy() {
		super(new AffineTransform(), new SwimFishPaintStrategy(), new EyePaintStrategy());
		// TODO Auto-generated constructor stub
	}

	/** (non-Javadoc)
	 * Override paintCfg to add the transform needed to keep the fish upright at all times.
	 * @see model.paint.APaintStrategy#paintCfg(java.awt.Graphics, model.balls.Ball)
	 */
	@Override
	public void paintCfg(Graphics g, Ball host) {
		super.paintCfg(g, host);
		if (Math.abs(Math.atan2(host.getVel().y, host.getVel().x)) > Math.PI / 2.0) {
			getAt().scale(1.0, -1.0);

		}

	}

}

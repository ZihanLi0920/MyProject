package model.paint.strategy;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.balls.Ball;
import model.paint.ImagePaintStrategy;

/**
 * @author zihanli
 * Paint strategy that paints a sun as its image.
 */
public class SunPaintStrategy extends ImagePaintStrategy {

	/**
	 * Constructor loads the sun image
	 */
	public SunPaintStrategy() {
		super(new AffineTransform(), "image/sun.jpg", 0.75);
		// TODO Auto-generated constructor stub

	}

	/** (non-Javadoc)
	 * This is just provided as an easy means to demonstrate the effects of flipping the image to keep the image upright.
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

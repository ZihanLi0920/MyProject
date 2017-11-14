package model.paint.strategy;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import model.IPaintStrategy;
import model.balls.Ball;

/**
 * @author zihanli
 * Paint strategy that paints a filled circle with the Ball's radius.
 * The class demonstrates a direct implementation of IPaintStrategy.
 *
 */
public class BallPaintStrategy implements IPaintStrategy {

	/** (non-Javadoc)
	 * Paints on the given graphics context using the color, scale and direction provided by the host.
	 * @see model.IPaintStrategy#paint(java.awt.Graphics, model.balls.Ball)
	 */
	@Override
	public void paint(Graphics g, Ball host) {
		// TODO Auto-generated method stub
		int radius = (int) host.getRadius();
		Point location = host.getLocation();
		Ellipse2D circle = new Ellipse2D.Double(location.x - radius, location.y - radius, 2 * radius, 2 * radius);
		g.setColor(host.getColor());
		((Graphics2D) g).fill(circle);

	}

	/** (non-Javadoc)
	 * By default, do nothing for initialization.
	 * @see model.IPaintStrategy#init(model.balls.Ball)
	 */
	@Override
	public void init(Ball host) {
		// TODO Auto-generated method stub

	}

}

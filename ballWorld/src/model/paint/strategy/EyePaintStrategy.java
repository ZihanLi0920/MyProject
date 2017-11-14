package model.paint.strategy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.balls.Ball;
import model.paint.ADecoratorPaintStrategy;
import model.paint.ShapePaintStrategy;
import model.paint.shape.EllipseShapeFactory;

/**
 * @author zihanli
 * the strategy to paint an circle that always be black
 */
public class EyePaintStrategy extends ADecoratorPaintStrategy {

	/**
	 * the constructor 
	 */
	public EyePaintStrategy() {
		super(new AffineTransform(), new ShapePaintStrategy(new AffineTransform(),
				EllipseShapeFactory.Singleton.makeShape(2.0 / 5, 0, 0.1, 0.1)));
		// TODO Auto-generated constructor stub
	}

	/** (non-Javadoc)
	 * set the color of g and then delegate to the decoree
	 * @see model.paint.ADecoratorPaintStrategy#paintXfrm(java.awt.Graphics, model.balls.Ball, java.awt.geom.AffineTransform)
	 */
	@Override
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		getStrategy().paintXfrm(g, host, at);
		g.setColor(host.getColor());

	}

}

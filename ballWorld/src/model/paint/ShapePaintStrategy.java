package model.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import model.balls.Ball;

/**
 * @author zihanli
 * Concrete class that defines invariant painting behaviors to paint Shape objects for all its subclasses. 
 *
 */
public class ShapePaintStrategy extends APaintStrategy {

	/**The Shape to be painted*/
	private Shape shape;

	/**
	 * @param _at
	 * @param _shape
	 * Constructor that uses a supplied AffineTransform for internal use.
	 */
	public ShapePaintStrategy(AffineTransform _at, Shape _shape) {
		super(_at);
		shape = _shape;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param _shape
	 * Constructor that allocates a new AffineTransform for internal use.
	 */
	public ShapePaintStrategy(Shape _shape) {
		super(new AffineTransform());
		shape = _shape;
		// TODO Auto-generated constructor stub
	}

	/** (non-Javadoc)
	 * @see model.IPaintStrategy#init(model.balls.Ball)
	 * just do nothing
	 */
	@Override
	public void init(Ball host) {
		// TODO Auto-generated method stub

	}

	/** (non-Javadoc)
	 * Paints the shape on the given Graphics context using the supplied AffineTransform.
	 * @see model.paint.APaintStrategy#paintXfrm(java.awt.Graphics, model.balls.Ball, java.awt.geom.AffineTransform)
	 */
	@Override
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		// TODO Auto-generated method stub
		((Graphics2D) g).fill(at.createTransformedShape(shape));

	}

}

package model.paint.shape;

import java.awt.Point;
import java.awt.geom.AffineTransform;

/**
 * @author zihanli
 * Concrete PolygonFactory that creates fish-shaped Polygons that have a closed mouth.
 *
 */
public class Fish2PolygonFactory extends PolygonFactory {

	/**
	 * Constructor that calls the PolygonFactory superclass constructor with the scale factor and polygon points that define the fish shape.
	 */
	public Fish2PolygonFactory() {
		super(new AffineTransform(), 0.2, new Point(5, 0), new Point(0, 2), new Point(-4, 0), new Point(-5, 2),
				new Point(-5, -2), new Point(-4, 0), new Point(0, -2));
	}
}

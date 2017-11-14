package model.paint.shape;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * @author zihanli
 * Concrete shape factory that instantiates Ellipse2D.Double shapes.
 *
 */
public class EllipseShapeFactory implements IShapeFactory {

	/** Singleton pattern*/
	public static EllipseShapeFactory Singleton = new EllipseShapeFactory();

	/** (non-Javadoc)
	 * @see model.paint.shape.IShapeFactory#makeShape(double, double, double, double)
	 * return a ellipse.
	 */
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		// TODO Auto-generated method stub
		Ellipse2D ellipse = new Ellipse2D.Double(x - xScale / 2, y - yScale / 2, xScale, yScale);

		return ellipse;
	}

}

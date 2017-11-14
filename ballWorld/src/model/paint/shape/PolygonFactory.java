package model.paint.shape;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

/**
 * @author zihanli
 *Concrete IShapeFactory that provides the invariant behavior to instantiate a Shape that is a Polygon
 */
public class PolygonFactory implements IShapeFactory {

	/**The Polygon shape to use as the prototype.*/
	private Polygon poly = new Polygon();
	/**The AffineTransform used for internal calculations*/
	private AffineTransform at;
	/**Scale factor that scales the integer Point-defined Polygon to a unit size, which requires doubles.*/
	double scaleFactor = 1.0;

	/** (non-Javadoc)
	 * @see model.paint.shape.IShapeFactory#makeShape(double, double, double, double)
	 * Instantiates a Shape object that is the prototype Polygon translated by the given (x, y) point
	 * and scaled by given (xScale, yScale) factor times the internal scaleFactor.
	 */
	@Override
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		// TODO Auto-generated method stub
		at.setToTranslation(x, y);
		at.scale(xScale * scaleFactor, yScale * scaleFactor); // optional rotation can be added as well
		return at.createTransformedShape(poly);

	}

	/**Constructor that uses an externally defined AffineTransform
	 * for internal use plus takes the defining points of the prototype Polygon
	 * and a scale factor to scale the given points to the desired unit size.
	 * 
	 * @param _at
	 * @param _scaleFactor
	 * @param pts
	 */
	PolygonFactory(AffineTransform _at, double _scaleFactor, Point... pts) {
		at = _at;
		scaleFactor = _scaleFactor;
		for (int i = 0; i < pts.length; i++) {
			poly.addPoint(pts[i].x, pts[i].y);
		}

	}

}

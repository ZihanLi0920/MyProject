package model.paint.strategy;

import java.awt.geom.AffineTransform;

import model.paint.ImagePaintStrategy;

/**
 * @author zihanli
 * Paint strategy that paints a angry emoji as its image.
 */
public class AngryPaintStrategy extends ImagePaintStrategy {

	/**
	 * Constructor loads the angry image
	 */
	public AngryPaintStrategy() {
		super(new AffineTransform(), "image/angry.jpg", 0.75);
		// TODO Auto-generated constructor stub

	}

}

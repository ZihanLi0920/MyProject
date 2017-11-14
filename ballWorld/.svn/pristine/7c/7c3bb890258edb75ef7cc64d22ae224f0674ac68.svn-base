package model.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import model.balls.Ball;

/**
 * @author zihanli
 *Paint strategy that paints an image from a file, scaled to the host Ball's radius. 
 */
public class ImagePaintStrategy extends APaintStrategy {

	/**The image to paint*/
	private Image img;
	/**Ratio of the unit radius circle to the effective radius size of the image.*/
	private double scaleFactor = 1.0;
	/**The percentage of the average of the width and height of the image that defines a unit radius for the image.*/
	private double fillFactor = 1.0;
	/**ImageObserver needed for some image operations*/
	private ImageObserver imgObs;
	/**A local affine transform used to transform the image into its unit size and location.*/
	private AffineTransform localAt = new AffineTransform();

	/**
	 * @param _at
	 * @param filename
	 * @param _fillFactor
	 * Constructor that takes an external AffineTransform, the filename of the image to paint and a fill factor of the image.
	 */
	public ImagePaintStrategy(AffineTransform _at, String filename, double _fillFactor) {
		super(_at);
		try {
			img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(filename));
		} catch (Exception e) {
			System.err.println("ImagePaintStrategy: Error reading file: " + filename + "\n" + e);
		}
		fillFactor = _fillFactor;
		// TODO Auto-generated constructor stub
	}

	/** (non-Javadoc)
	 * @see model.IPaintStrategy#init(model.balls.Ball)
	 * Initializes the internal ImageObserver reference from the host Ball Also calculates the net scale factor for the image.
	 */
	@Override
	public void init(Ball host) {
		// TODO Auto-generated method stub
		imgObs = host.getCanvas();
		MediaTracker mt = new MediaTracker(host.getCanvas());
		mt.addImage(img, 1);
		try {
			mt.waitForAll();
		} catch (Exception e) {
			System.out.println("ImagePaintStrategy.init(): Error waiting for image.  Exception = " + e);
		}

		scaleFactor = 2.0 / (fillFactor * (img.getWidth(imgObs) + img.getHeight(imgObs)) / 2.0);

	}

	/** (non-Javadoc)
	 * Draws the image on the given Graphics context using the given affine transform in combination with the local affine transform.
	 * @see model.paint.APaintStrategy#paintXfrm(java.awt.Graphics, model.balls.Ball, java.awt.geom.AffineTransform)
	 */
	@Override
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		// TODO Auto-generated method stub
		localAt.setToScale(scaleFactor, scaleFactor);
		localAt.translate(-img.getWidth(imgObs) / 2.0, -img.getHeight(imgObs) / 2.0);
		localAt.preConcatenate(at);
		((Graphics2D) g).drawImage(img, localAt, imgObs);

	}

}

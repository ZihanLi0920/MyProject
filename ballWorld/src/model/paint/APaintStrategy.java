package model.paint;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.IPaintStrategy;
import model.balls.Ball;

/**
 * @author zihanli
 * The top-level affine transform-based paint strategy that provides services for its subclasses
 *
 */
public abstract class APaintStrategy implements IPaintStrategy {

	private AffineTransform at;

	/**
	 * @param _at The AffineTransform for this paint strategy to use.
	 * Constructor that initializes the strategy with an affine transform
	 */
	public APaintStrategy(AffineTransform _at) {
		at = _at;
	}

	/**
	 * @param g The Graphics context that will be paint on
	 * @param host The host Ball that the required information will be pulled from.
	 * default method which is do nothing
	 */
	public void paintCfg(Graphics g, Ball host) {
	};

	/**
	 * @param g The Graphics context that will be paint on
	 * @param host The host Ball that the required information will be pulled from.
	 * @param at The AffineTransform for this paint strategy to use.
	 * Paints the host onto the given Graphics context.
	 */
	public abstract void paintXfrm(Graphics g, Ball host, AffineTransform at);

	/** (non-Javadoc)
	 * @see model.IPaintStrategy#paint(java.awt.Graphics, model.balls.Ball)
	 * Paints on the given graphics context using the color, scale and direction provided by the host.
	 */
	@Override
	public void paint(Graphics g, Ball host) {
		// TODO Auto-generated method stub
		double scale = host.getRadius();
		at.setToTranslation(host.getLocation().x, host.getLocation().y);
		at.scale(scale, scale);
		at.rotate(host.getVel().x, host.getVel().y);
		g.setColor(host.getColor());
		paintCfg(g, host);
		paintXfrm(g, host, at);
	}

	/**
	 * @return the internal AffineTransform
	 * Protected accessor for the internal affine transform
	 */
	public AffineTransform getAt() {
		return at;
	}

}

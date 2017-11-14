package model.paint;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.balls.Ball;

/**
 * @author zihanli
 * Concrete paint strategy that cycles through a sequence of paint strategies, painting one per paint update.
 */
public class AnimatePaintStrategy extends APaintStrategy {

	/**The counter that keeps track of which paint strategy to use next.*/
	private int count = 0;
	private APaintStrategy[] PaintStrats;

	/**
	 * @param _at The AffineTransform to use
	 * @param pstrats vararg input of the paint strategies to cycle through, in order.
	 * Constructor that uses the supplied AffineTransform for internal use.
	 */
	public AnimatePaintStrategy(AffineTransform _at, APaintStrategy... pstrats) {
		super(_at);
		// TODO Auto-generated constructor stub
		PaintStrats = pstrats;
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
	 * @see model.paint.APaintStrategy#paintXfrm(java.awt.Graphics, model.balls.Ball, java.awt.geom.AffineTransform)
	 * Paints the currently indexed paint strategy on the given Graphics context using the supplied AffineTransform.
	 */
	@Override
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		// TODO Auto-generated method stub
		PaintStrats[count].paintXfrm(g, host, at);
		count++;
		count = count % PaintStrats.length;
	}

}

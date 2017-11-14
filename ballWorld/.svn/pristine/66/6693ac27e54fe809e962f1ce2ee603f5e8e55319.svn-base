package model.balls;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


import model.IBallCmd;
import model.IInteractStrategy;
import model.IPaintStrategy;
import model.IUpdateStrategy;
import util.IDispatcher;
import util.IObserver;
import util.Randomizer;

/**
 * An abstract class of balls
 *
 */
public class Ball implements IObserver<IBallCmd> {
	/** generate random values*/
	private Randomizer rand;
	/** The color of the ball*/
	private Color color;
	/** The center point of the ball*/
	private Point location;
	/**The velocity of the ball*/
	private Point velocity;
	/** The radius of the ball*/
	private int radius;
	/** The windows that the ball will be paint*/
	private Component window;
	/** The strategy used to update the ball's state*/
	private IUpdateStrategy<IBallCmd> strategy;
	/** The strategy used to paint*/
	private IPaintStrategy paintStrategy;
	private IInteractStrategy interactStrategy = IInteractStrategy.NULL_STRATEGY;

	/**
	 * 
	 * @param _window The JPanel that the ball will be paint
	 * Initialize the fields of the ball using the input value
	 */
	public Ball(Point _location, int _radius, Point _velocity, Color _color, Component _window,
			IUpdateStrategy<IBallCmd> _updateStrategy, IPaintStrategy _paintStrategy) {
		paintStrategy = _paintStrategy;
		color = _color;
		location = _location;
		velocity = _velocity;
		radius = _radius;
		window = _window;
		setUpdateStrategy(_updateStrategy);
		paintStrategy.init(this);
	}

	/**
	 * @param _window
	 * @param _strategy
	 * @param _paintStrategy
	 * Initialize the fields of the ball using randomizer
	 */
	public Ball(Component _window, IUpdateStrategy<IBallCmd> _strategy, IPaintStrategy _paintStrategy) {
		paintStrategy = _paintStrategy;
		rand = Randomizer.Singleton;
		color = rand.randomColor();
		radius = rand.randomInt(5, 20);
		window = _window;
		location = new Point(rand.randomInt(radius, window.getWidth() - radius),
				rand.randomInt(radius, window.getHeight() - radius));
		velocity = rand.randomVel(new Rectangle(20, 20));
		//make sure that the ball will not be static
		if (velocity.x == 0 && velocity.y == 0) {
			velocity.x++;
			velocity.y++;
		}
		setUpdateStrategy(_strategy);
		paintStrategy.init(this);
	}

	/**
	 * call the interact method of interact stratgey
	 * @param target the ball that interact with this ball
	 * @param disp the general dispatcher
	 */
	public void interactWith(Ball target, IDispatcher<IBallCmd> disp) {
		interactStrategy.interact(this, target, disp);
	}

	/**
	 * @return the interact strategy of the ball
	 */
	public IInteractStrategy getInteractStrategy() {
		return interactStrategy;
	}

	/**
	 * @param _interactStrategy the interact strategy of the ball
	 * set the interact strategy of the ball
	 */
	public void setInteractStrategy(IInteractStrategy _interactStrategy) {
		interactStrategy = _interactStrategy;
	}

	/**
	 * @param _strategy the update strategy of the ball
	 * set the update strategy of the ball
	 */
	public void setUpdateStrategy(IUpdateStrategy<IBallCmd> _strategy) {
		strategy = _strategy;
		strategy.init(this);
	}

	/** Define how the ball move
	 *  call the method called 'translate' of Point to change the center point of the ball
	 */
	public void move() {
		location.translate(velocity.x, velocity.y);
	}

	/**Determine whether the ball need to bounce
	 * if the ball has passed the widow boundaries, translate it back.
	 * change the direction of the velocity
	 */
	public void bounce() {
		// check if the ball past right wall
		if (location.x + radius >= window.getWidth()) {
			location.translate(-2 * (location.x + radius - window.getWidth()), 0);
			velocity.setLocation(-velocity.x, velocity.y);
		}
		// check if the ball past left wall
		else if (location.x - radius <= 0) {
			location.translate(2 * (radius - location.x), 0);
			velocity.setLocation(-velocity.x, velocity.y);
		}
		// check if the ball past bottom wall
		if (location.y + radius >= window.getHeight()) {
			location.translate(0, -2 * (location.y + radius - window.getHeight()));
			velocity.setLocation(velocity.x, -velocity.y);
		}
		// check if the ball past top wall
		else if (location.y - radius <= 0) {
			location.translate(0, 2 * (radius - location.y));
			velocity.setLocation(velocity.x, -velocity.y);
		}
	}

	/**
	 * all the sub-class should have this method to update the status of the ball e.g color, velocity, radius
	 */

	/**
	 * @param g the object to draw ball
	 * paint a ball on the window
	 */
	public void paint(Graphics g) {
		paintStrategy.paint((Graphics) g, this);
	}

	/**
	 * use its strategy to update the ball's state
	 */
	public void updateState(IDispatcher<IBallCmd> disp) {
		strategy.updateState(this, disp);
	}


	/**
	 * @return the velocity of the ball
	 */
	public Point getVel() {
		return velocity;
	}

	/**
	 * @param p The value used to set the velocity of the ball
	 */
	public void setVel(Point p) {
		velocity = p;
	}

	/**
	 * @param _color set the value of the ball's color
	 */
	public void setColor(Color _color) {
		color = _color;
	}

	/**
	 * @param d set the value of radius
	 */
	public void setRadius(int d) {
		radius = d;
	}

	/**
	 * @return the update strategy of the ball
	 * return the update strategy of the ball
	 */
	public IUpdateStrategy<IBallCmd> getUpdateStrategy() {
		return strategy;
	}

	/**
	 * @return the paint strategy of the ball
	 * the paint strategy of the ball
	 */
	public IPaintStrategy getPaintStrategy() {
		return paintStrategy;
	}

	/**
	 * @return the radius of the ball
	 */
	public double getRadius() {
		// TODO Auto-generated method stub
		return radius;
	}

	/**
	 * @return the location of the ball
	 */
	public Point getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	/**
	 * @return the color of the ball
	 */
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	/**
	 * @return the component that ball is painted on
	 */
	public Component getCanvas() {
		// TODO Auto-generated method stub
		return window;
	}

	/**
	 * @param _location the location of the ball
	 * set the location of the ball
	 */
	public void setLocation(Point _location) {
		location = _location;
	}

	/** (non-Javadoc)
	 * @see util.IObserver#update(util.IDispatcher, java.lang.Object)
	 * do the things that the msg tell the ball to do
	 */
	@Override
	public void update(IDispatcher<IBallCmd> dispatcher, IBallCmd msg) {
		// TODO Auto-generated method stub
		msg.apply(this, dispatcher);
		
	}

}

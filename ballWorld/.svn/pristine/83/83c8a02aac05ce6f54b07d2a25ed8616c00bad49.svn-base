package model;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Timer;

import model.balls.Ball;
import model.paint.strategy.BallPaintStrategy;
import model.strategy.*;
import util.IDispatcher;
import util.SetDispatcherSequential;

/**
 * @author zihanli,yiranwei
 * The model that drives the view MainFrame
 */
public class BallModel {

	private IModel2ViewAdapter _model2ViewAdpt = IModel2ViewAdapter.NULL_OBJECT; // Insures that the adapter is always valid
	private int _timeSlice1 = 50; // paint every 50 milliseconds
	private int _timeSlice2 = 50;//update every 50 milliseconds
	/**The dispatcher that updates all the balls.*/
	private IDispatcher<IBallCmd> _dispatcher = new SetDispatcherSequential<IBallCmd>();
	/**The timer that controls when the balls are periodically painted.*/
	private Timer _timer = new Timer(_timeSlice1, (e) -> _model2ViewAdpt.update());
	/**The timer that controls when the balls are periodically updated.*/
	private Timer _timer1 = new Timer(_timeSlice2, (e) -> move_update());
	/** the strategy that is used when the class is wrong*/
	public IStrategyFac<IBallCmd> _errorStrategyFac;
	/**The one switcher strategy instance in the system.*/
	private SwitchStrategy<IBallCmd> _switcher = new SwitchStrategy<IBallCmd>();

	/**
	 * @param g An input parameter to give to each ball's update method.
	 * notify all the balls to paint
	 */
	public void update(Graphics g) {
		_dispatcher.dispatch((IBallCmd) (context, disp) -> {
			context.paint(g);
			// Whatever you want to do with the context Ball!
		});
	}

	/**
	 * notify all the balls to move and update its state
	 */
	public void move_update() {
		_dispatcher.dispatch((IBallCmd) (context, disp) -> {
			context.updateState(disp);
			context.move();
			context.bounce();

		});
	}

	/**
	 * @return the SwitchStrategy
	 */
	public SwitchStrategy<IBallCmd> getSwitchStrategy() {
		return _switcher;
	}

	/**
	 * @param newStrategy change the temp strategy to a new strategy
	 */
	public void swichSwichStrategy(IUpdateStrategy<IBallCmd> newStrategy) {
		_switcher.setStrategy(newStrategy);
	}

	/**
	 * @param model2ViewAdpt 
	 * use IModel2ViewAdapter to initialize the class
	 */
	public BallModel(IModel2ViewAdapter model2ViewAdpt) {
		_model2ViewAdpt = model2ViewAdpt;
		_errorStrategyFac = new IStrategyFac<IBallCmd>() {

			@Override
			/**
			 * Make the beeping error strategy
			 * @return  An instance of a beeping error strategy
			 */
			public IUpdateStrategy<IBallCmd> make() {
				return new IUpdateStrategy<IBallCmd>() {
					private int count = 0; // update counter
					

					@Override
					public void init(Ball context) {
						// TODO Auto-generated method stub

					}

					/**
					 * Beep the speaker every 25 updates
					 */
					@Override
					public void updateState(Ball ball, IDispatcher<IBallCmd> dispatcher) {
						// TODO Auto-generated method stub
						if (25 < count++) {
							java.awt.Toolkit.getDefaultToolkit().beep();
							count = 0;
						}
						
					}
				};
			}

		};
	}

	/**
	 * Delete all observers from the dispatcher and from the screen
	 */
	public void deleteBalls() {
		_dispatcher.deleteObservers();
	}

	/**
	 * Returns an IStrategyFac that can instantiate the strategy specified by
	 * classname. Returns a factory for a beeping error strategy if classname is null. 
	 * The toString() of the returned factory is the classname.
	 * 
	 * @param classname  Shortened name of desired strategy
	 * @return A factory to make that strategy
	 */
	public IStrategyFac<IBallCmd> makeStrategyFac(final String classname) {
		IStrategyFac<IBallCmd> strategyFac = new IStrategyFac<IBallCmd>() {
			/**
			 * Instantiate a strategy corresponding to the given class name.
			 * @return An IUpdateStrategy instance
			 */
			public IUpdateStrategy<IBallCmd> make() {
				return loadStrategy(fixName(classname)) == null ? new StraightStrategy<IBallCmd>()
						: loadStrategy(fixName(classname));
			}

			public String toString() {
				return classname;
			}
		};
		return strategyFac;
	}

	/**
	 * Instantiate a paint strategy corresponding to the given class name.
	 * @param classname
	 * @return A factory to make that strategy
	 */
	public IPaintFac makePaintFac(final String classname) {
		IPaintFac strategyFac = new IPaintFac() {
			/**
			 * Instantiate a strategy corresponding to the given class name.
			 * @return An IPaintStrategy instance
			 */
			public IPaintStrategy make() {
				return loadPaintStrategy(fixPaintName(classname)) == null ? new BallPaintStrategy()
						: loadPaintStrategy(fixPaintName(classname));
			}

			public String toString() {
				return classname;
			}
		};
		return strategyFac;
	}

	/**
	 * Returns an IStrategyFac that can instantiate a MultiStrategy with the two
	 * strategies made by the two given IStrategyFac objects. Returns null if
	 * either supplied factory is null. The toString() of the returned factory
	 * is the toString()'s of the two given factories, concatenated with "-". 
	 * If either factory is null, then a factory for a beeping error strategy is returned.
	 * 
	 * @param stratFac1 An IStrategyFac for a strategy
	 * @param stratFac2 An IStrategyFac for a strategy
	 * @return An IStrategyFac for the composition of the two strategies
	 */
	public IStrategyFac<IBallCmd> combineStrategyFacs(final IStrategyFac<IBallCmd> stratFac1, final IStrategyFac<IBallCmd> stratFac2) {
		if (null == stratFac1 || null == stratFac2)
			return _errorStrategyFac;
		return new IStrategyFac<IBallCmd>() {
			/**
			 * Instantiate a new MultiStrategy with the strategies from the given strategy factories
			 * @return A MultiStrategy instance
			 */
			public IUpdateStrategy<IBallCmd> make() {
				return new MultiStrategy<IBallCmd>(stratFac1.make(), stratFac2.make());
			}

			/**
			 * Return a string that is the toString()'s of the given strategy factories concatenated with a "-"
			 */
			public String toString() {
				return stratFac1.toString() + "-" + stratFac2.toString();
			}
		};
	}

	/**
	 * Use the classname to create an object of IUpdateStrategy
	 * @param classname The fully qualified classname of a strategy
	 * @return An IUpdateStrategy instance
	 */
	@SuppressWarnings("unchecked")
	public IUpdateStrategy<IBallCmd> loadStrategy(String classname) {
		try {
			java.lang.reflect.Constructor<?> cs[] = Class.forName(classname).getConstructors(); // get all the constructors
			java.lang.reflect.Constructor<?> c = null;
			for (int i = 0; i < cs.length; i++) { // find the first constructor with the right number of input parameters
				if (0 == (cs[i]).getParameterTypes().length) {
					c = cs[i];
					break;
				}
			}
			return (IUpdateStrategy<IBallCmd>) c.newInstance();
			//IUpdateStrategy strategy=(IUpdateStrategy) Class.forName(classname).newInstance();
			//return strategy;
		} catch (Exception e) {
			System.err.println("Class " + classname + " failed to load. \nException = \n" + e);
			e.printStackTrace(); // print the stack trace to help in debugging.
			return null; // Is this really a useful thing to return here?  Is there something better that could be returned?
		} catch (Error err) {
			return null;
		}
	}

	/**
	 * Use the classname to create an object of IPaintStrategy
	 * @param classname The fully qualified classname of a paint strategy
	 * @return An PaintStrategy instance
	 */
	public IPaintStrategy loadPaintStrategy(String classname) {
		try {
			java.lang.reflect.Constructor<?> cs[] = Class.forName(classname).getConstructors(); // get all the constructors
			java.lang.reflect.Constructor<?> c = null;
			for (int i = 0; i < cs.length; i++) { // find the first constructor with the right number of input parameters
				if (0 == (cs[i]).getParameterTypes().length) {
					c = cs[i];
					break;
				}
			}
			return (IPaintStrategy) c.newInstance();
			//IUpdateStrategy strategy=(IUpdateStrategy) Class.forName(classname).newInstance();
			//return strategy;
		} catch (Exception e) {
			System.err.println("Class " + classname + " failed to load. \nException = \n" + e);
			e.printStackTrace(); // print the stack trace to help in debugging.
			return null; // Is this really a useful thing to return here?  Is there something better that could be returned?
		} catch (Error err) {
			return null;
		}
	}

	/**
	 * @param paintStrategy  An IPaintStrategy for the new ball to use.
	 * @param strategy An IUpdateStrategy for the new ball to use.
	 * To create a ball
	 */
	public void loadBall(Component window, IUpdateStrategy<IBallCmd> strategy, IPaintStrategy paintStrategy) {
		Ball ball = new Ball(window, strategy, paintStrategy);
		_dispatcher.addObserver(ball);
	}

	/**
	 * @param classname The abbreviated, shortened or the full name
	 * @return the right full name
	 * make sure to support  either full or abbreviated strategy class name
	 */
	public String fixName(String classname) {
		if (classname.length() >= 9) {
			if (classname.substring(0, 8) == "strategy.")
				return classname;
		}
		return "model.strategy." + classname + "Strategy";

	}

	/**
	 * @param classname The abbreviated, shortened name
	 * @return the right full name of the paint startegy
	 */
	public String fixPaintName(String classname) {
		return "model.paint.strategy." + classname + "PaintStrategy";

	}

	/**
	 * start the timer to make the animations
	 */
	public void start() {
		_timer.start();
		_timer1.start();
	}

}

package controller;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import view.*;
import model.*;

/**
 *  The class to control the information flow between view and model
 *
 */
public class Controller {
	private MainFrame<IStrategyFac<IBallCmd>, IPaintFac> ballView;
	private BallModel ballModel;

	Controller() {
		ballView = new MainFrame<IStrategyFac<IBallCmd>, IPaintFac>(new IView2ModelCtrlAdapter<IStrategyFac<IBallCmd>, IPaintFac>() {
			@Override
			public void clearBalls() {
				// TODO Auto-generated method stub
				ballModel.deleteBalls();
			}

			@Override
			/**
			* Returns an IStrategyFac that can instantiate the strategy specified
			* by classname. Returns null if classname is null. The toString() of
			* the returned factory is the classname.
			* @param classname  Shortened name of desired strategy 
			* @return A factory to make that strategy
			*/
			public IStrategyFac<IBallCmd> addStrategy(String classname) {
				return ballModel.makeStrategyFac(classname);
			}

			@Override
			/**
			* Add a ball to the system with a strategy asgiven by the given IStrategyFac
			* @param selectedItem The fully qualified name of the desired strategy.
			*/
			public void makeBall(Component window, IStrategyFac<IBallCmd> selectedItem, IPaintFac selectedItem1) {
				// TODO Auto-generated method stub
				if (null != selectedItem)
					ballModel.loadBall(window, selectedItem.make(), selectedItem1.make()); // Here, loadBall takes a strategy object, but your method may take the strategy factory instead.

			}

			@Override
			public IStrategyFac<IBallCmd> combineStrategies(IStrategyFac<IBallCmd> s2, IStrategyFac<IBallCmd> s1) {
				// TODO Auto-generated method stub
				return ballModel.combineStrategyFacs(s2, s1);
			}

			@Override
			public void switchStrategy(IStrategyFac<IBallCmd> newStrategy) {
				// TODO Auto-generated method stub
				if (newStrategy == null)
					ballModel.swichSwichStrategy(ballModel._errorStrategyFac.make());
				else
					ballModel.swichSwichStrategy(newStrategy.make());

			}

			@Override
			public void makeSwitchBall(Component window, IPaintFac s1) {
				// TODO Auto-generated method stub
				ballModel.loadBall(window, ballModel.getSwitchStrategy(), s1.make());

			}

			@Override
			public IPaintFac addPaintStrategy(String classname) {
				// TODO Auto-generated method stub
				return ballModel.makePaintFac(classname);
			}

		}, new IView2ModelPaintAdapter() {
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				ballModel.update(g);
			};
		});
		ballModel = new BallModel(new IModel2ViewAdapter() {

			@Override
			public void update() {
				// TODO Auto-generated method stub
				ballView.update();

			}
		});
	}

	/**
	 * Start both View and Model
	 */
	public void start() {
		ballView.start();
		ballModel.start();

	}

	/**
	 * @param args
	 * new an object of Controller and call the start method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller controller = new Controller();
					controller.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
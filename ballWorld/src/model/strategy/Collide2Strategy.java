package model.strategy;

import java.awt.Point;
import java.awt.geom.Point2D;

import model.IBallCmd;
import model.IInteractStrategy;
import model.IUpdateStrategy;
import model.balls.Ball;

import util.IDispatcher;

/**
 * @author zihanli
 * elastic collision implemented purely as an interaction strategy.   Combine with Overlap to see bouncing balls.
 */
public class Collide2Strategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#updateState(model.balls.Ball, util.Dispatcher)
	 * do nothing
	 */
	@Override
	public void updateState(Ball ball, IDispatcher<TDispMsg> dispatcher) {
		// TODO Auto-generated method stub

	}

	/** (non-Javadoc)
	 * @see model.IUpdateStrategy#init(model.balls.Ball)
	 * set the interact strategy of the ball of which the interact method is to collide with the target. 
	 * justify if it is overlapped with the target to avoid collide twice.
	 */
	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub

		context.setInteractStrategy(new MultiInteractStrategy(context.getInteractStrategy(), new IInteractStrategy() {
			

			@Override
			public void interact(Ball ball, Ball target, IDispatcher<IBallCmd> disp) {
				// TODO Auto-generated method stub
				double temp_distance = ball.getLocation().distance(target.getLocation());
				if (temp_distance <= ball.getRadius() + target.getRadius()) {
					double _reducedMass = reducedMass(ball.getRadius() * ball.getRadius(),
							target.getRadius() * target.getRadius());
					Point2D.Double _impulse = impulse(ball.getLocation(), ball.getVel(), target.getLocation(),
							target.getVel(), _reducedMass, temp_distance,
							ball.getRadius() + target.getRadius() - temp_distance);
					updateCollision(ball, target, _impulse.x, _impulse.y);
					updateCollision(target, ball, -1 * _impulse.x, -1 * _impulse.y);

				}
				
			}

		}));
	}

	/**
	 * Returns the reduced mass of the two balls (m1*m2)/(m1+m2) Gives correct
	 * result if one of the balls has infinite mass.
	 * 
	 * @param mSource
	 *            Mass of the source ball
	 * @param mTarget
	 *            Mass of the target ball
	 */
	protected double reducedMass(double mSource, double mTarget) {
		if (mSource == Double.POSITIVE_INFINITY)
			return mTarget;
		if (mTarget == Double.POSITIVE_INFINITY)
			return mSource;
		else
			return (mSource * mTarget) / (mSource + mTarget);
	}

	private double Nudge = 1.1;

	/**
	 * Calculates the impulse (change in momentum) of the collision in the
	 * direction from the source to the target This method calculates the
	 * impulse on the source ball. The impulse on the target ball is the
	 * negative of the result. Also moves source ball out of collision range
	 * along normal direction. The change in velocity of the source ball is the
	 * impulse divided by the source's mass The change in velocity of the target
	 * ball is the negative of the impulse divided by the target's mass
	 * 
	 * Operational note: Even though theoretically, the difference in velocities
	 * of two balls should be co-linear with the normal line between them, the
	 * discrete nature of animations means that the point where collision is
	 * detected may not be at the same point as the theoretical contact point.
	 * This method calculates the rebound directions as if the two balls were
	 * the appropriate radii such that they had just contacted
	 * _at_the_point_of_collision_detection_. This may give slightly different
	 * rebound direction than one would calculate if they contacted at the
	 * theoretical point given by their actual radii.
	 * 
	 * @param lSource
	 *            Location of the source ball
	 * @param vSource
	 *            Velocity of the source ball
	 * @param lTarget
	 *            Location of the target ball
	 * @param vTarget
	 *            Velocity of the target ball
	 * @param reducedMass
	 *            Reduced mass of the two balls
	 * @param distance
	 *            Distance between the two balls.
	 * @param deltaR
	 *            The minimum allowed separation(sum of the ball radii) minus the actual separation(distance between ball centers). Should be a
	 *            positive value.  This is the amount of overlap of the balls as measured along the line between their centers.
	 * @return
	 */
	protected Point2D.Double impulse(Point lSource, Point vSource, Point lTarget, Point vTarget, double reducedMass,
			double distance, double deltaR) {
		// Calculate the normal vector, from source to target
		double nx = ((double) (lTarget.x - lSource.x)) / distance;
		double ny = ((double) (lTarget.y - lSource.y)) / distance;

		// delta velocity (speed, actually) in normal direction, source to
		// target
		double dvn = (vTarget.x - vSource.x) * nx + (vTarget.y - vSource.y) * ny;

		// move the source ball beyond collision range of the target ball, along
		// the normal direction.
		lSource.translate((int) Math.ceil(-nx * (Nudge * deltaR)), (int) Math.ceil(-ny * (Nudge * deltaR)));

		return new Point2D.Double(2.0 * reducedMass * dvn * nx, 2.0 * reducedMass * dvn * ny);
	}

	/**
	 * Updates the velocity of the source ball, given an impulse, then uses the
	 * context's interactWith method to determine the post collision behavior, from the context
	 * ball's perspective. The change in velocity is the impulse divided by the (source) ball's mass. To change
	 * the velocity of the target ball, switch the source and target input
	 * parameters and negate the impulse values.   This will also run the post collision behavior from 
	 * the other perspective.
	 * 
	 * @param context
	 *            The ball to update
	 * @param target
	 *            The ball being collided with
	 * @param impX
	 *            x-coordinate of the impulse
	 * @param impY
	 *            y-coordinate of the impulse
	 */
	protected void updateCollision(Ball context, Ball target, double impX, double impY) {
		int mContext = (int) (context.getRadius() * context.getRadius());

		context.getVel().translate((int) Math.round(impX / mContext), (int) Math.round(impY / mContext));
	}

}

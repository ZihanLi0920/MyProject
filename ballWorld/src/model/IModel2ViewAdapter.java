package model;

/**
 * Interface that goes from the model to the view that enables the model to talk to the view
 */
public interface IModel2ViewAdapter {

	/**
	 * The method that tells the view to update
	 */
	public void update();

	/**
	 * No-op "null" adapter
	 * See the web page on the Null Object Design Pattern at http://cnx.org/content/m17227/latest/
	 */
	public static final IModel2ViewAdapter NULL_OBJECT = new IModel2ViewAdapter() {
		public void update() {
		}
	};
}